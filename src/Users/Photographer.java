package Users;
import Contest.Contest;
import Contest.Photo;
import java.util.ArrayList;

public class Photographer extends User{

    private ArrayList<Contest> contests = new ArrayList<Contest>();
//    private ArrayList<Photo> photos = new ArrayList<>();

    public Participant applyForContest(Contest contest, Photo photo){
        Participant participant = new Participant();
        participant.addPhoto(photo);
        participant.setContest(contest);
        contest.addParticipant(participant);
        return participant;
    }

    public Participant applyForContest(Contest contest){
        Participant participant = new Participant();
        participant.setContest(contest);
        contest.addParticipant(participant);
        return participant;
    }

}
