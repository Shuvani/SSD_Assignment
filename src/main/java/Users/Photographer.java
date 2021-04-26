package Users;
import Contest.Contest;
import Contest.Photo;
import java.util.ArrayList;

public class Photographer extends User{

    public Photographer(String email, String pass, int phoneNumber){
        super(email, pass, phoneNumber);
    }
    private ArrayList<Contest> contests = new ArrayList<>();

    public Participant applyForContest(Contest contest, Photo photo){
        Participant participant = applyForContest(contest);
        participant.addPhoto(photo);
        return participant;
    }

    public Participant applyForContest(Contest contest){
        Participant participant = new Participant(this);
        this.contests.add(contest);
        participant.setContest(contest);
        contest.addParticipant(participant);
        return participant;
    }

}
