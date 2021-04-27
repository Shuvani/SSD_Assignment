package Users;
import Contest.Contest;
import Contest.Photo;
import Contest.Image;
import java.io.*;
import java.util.ArrayList;


public class Photographer extends User{

    public Photographer(String email, String pass, int phoneNumber){
        super(email, pass, phoneNumber);
    }
    private ArrayList<Contest> contests = new ArrayList<>();
    private ArrayList<Image> images = new ArrayList<>();

    public Participant applyForContest(Contest contest, Image img){
        Participant participant = applyForContest(contest);
        participant.addPhoto(img);
        return participant;
    }

    public Participant applyForContest(Contest contest){
        Participant participant = new Participant(this);
        this.contests.add(contest);
        participant.setContest(contest);
        contest.addParticipant(participant);
        return participant;
    }

    public void addImage(Image img){
        this.images.add(img);
    }

    public Image getImageById(int i){
        return this.images.get(i);
    }

}
