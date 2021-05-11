package Contest;

import NotificationFabric.NotificationFabric;
import Users.Participant;
import NotificationFabric.SMSNotificationFabric;
import NotificationFabric.MailNotificationFabric;

import java.util.*;

public class Contest {

    private String name;
    private String description;
    private boolean votingRequired;
    private int winnersCount;
    private int winnerNotificationType;
    private boolean isActive;
    private Date start;
    private Date finnish;

    private ArrayList<Participant> participants;
    private ArrayList<Participant> winners;

    public Contest(String name, String description, Date start, Date finnish,
                   int winnerNotificationType, boolean votingRequired, int winnersCount) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finnish = finnish;
        this.winnerNotificationType = winnerNotificationType;
        this.votingRequired = votingRequired;
        this.winnersCount = winnersCount;
        this.participants = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public Contest(String name, String description, Date start, Date finnish) {
        this(name, description, start, finnish, 0, true, 3);
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void updateStart(Date start) {
        this.start = start;
    }

    public Date getFinnish() {
        return finnish;
    }

    public void updateFinnish(Date finnish) {
        this.finnish = finnish;
    }

    public ArrayList<Participant> getParticipants(){
        return this.participants;
    }

    // main part

    /**
     * Updates the `isActive` variable, according to the current date
     * */
    private void checkDates() {
//        System.out.println("First check: "+ new Date() + "\t finn: "+
//                finnish+"\n Res: "+ new Date().compareTo(finnish));
//        System.out.println("Second check: "+ new Date() + "\t start: "+
//                start+"\n Res: "+ new Date().compareTo(start));
        if(new Date().compareTo(finnish) >= 0) {
            this.isActive = false;
        }else if(new Date().compareTo(start) < 0) {
            this.isActive = false;
        } else{
            this.isActive = true;
        }
    }

    /**
     * Returns, if the contest is open for participating
     * */
    public boolean isActive() {
        checkDates();
        return this.isActive;
    }

    /**
     * Adds the participant to the list of participants, if the competition is active
     * */
    public void addParticipant(Participant participant) {
        checkDates();
        if (! isActive){
            throw new AssertionError("The competition is already closed. Final date "+
                    this.finnish + "\nGiven date:"+new Date());
        }
        this.participants.add(participant);
    }

    /**
     * If the voting procedure is not required for the contest, then the
     * winners should be manually selected by the Admin
     * */
    public void setWinners(ArrayList<Participant> newWinners) {
        this.winners = newWinners;
    }

    /**
     * Search for the photos and authors, who are the winners
     * (top-`winnersCount`) of the contest
     * */
    public void findWinners() {
        ArrayList<Photo> photos = new ArrayList<>();
        for (Participant participant: participants) {
            for (Photo ph: participant.getPhotos()) {
                photos.add(ph);
            }
        }
        Collections.sort(photos, new PhotoComparator());
        for (int i = 0; i < this.winnersCount && i < photos.size(); i++) {
            this.winners.add(photos.get(photos.size()-1-i).getAuthor());
        }
    }

    /**
     * The Finish method
     * - makes it impossible to participate in the contest
     * - searches for the winners of the contest
     * - notifies the winners of the contest
     * */
    public void finish() {
        // impossible to participate
        this.finnish = new Date();
        this.isActive = false;
        // find winners
        if (votingRequired) {
            findWinners();
        } else if (winners.isEmpty()) {
            throw new AssertionError("Nobody is the winner of the contest. " +
                    "Please, set up a winner before finnish");
        }
        // notify winners
        NotificationFabric fabric;
        switch (this.winnerNotificationType) {
            case 0:                                         /* both types */
                fabric = new SMSNotificationFabric();
                fabric.createWinnerNotification().sendNotification();
            case 1:                                         /* mail only */
                fabric = new MailNotificationFabric();
                break;
            case 2:                                         /* sms only */
                fabric = new SMSNotificationFabric();
                break;
            default:
                throw new AssertionError("No such notification type " +
                        this.winnerNotificationType);
        }
        fabric.createWinnerNotification().sendNotification();
    }


    public ArrayList<Participant> getWinners(){
        if (this.isActive){
            throw new AssertionError("Contest hasn't finished yet");
        }
        return this.winners;
    }


    public Iterator<Photo> photosIterator(){
        ArrayList<Photo> photos = new ArrayList<Photo>();

        for (Participant participant: participants) {
            for (Photo ph: participant.getPhotos()) {
                photos.add(ph);
            }
        }

        return new SeqPhotoIterator(photos);
    }

    public Iterator<Photo> photosIterator(Specifier s){
        ArrayList<Photo> photos = new ArrayList<Photo>();

        for (Participant participant: participants) {
            for (Photo ph: participant.getPhotos()) {
                photos.add(ph);
            }
        }

        if(s instanceof RandSpec) { return new RandPhotoIterator(photos); }
        if(s instanceof SeqSpec) { return new RandPhotoIterator(photos); }
        if(s instanceof TitleSpec) { return new RandPhotoIterator(photos); }
        if(s instanceof VotesSpec) { return new RandPhotoIterator(photos); }

        return new SeqPhotoIterator(photos);
    }

}
