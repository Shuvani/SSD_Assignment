package Users;
import Contest.Contest;
import Contest.Photo;
import java.util.*;

public class Voter extends User {

    private Map<Contest, ArrayList<Photo>> votes = new HashMap<Contest, ArrayList<Photo>>();

    public Voter(String email, String pass, int phoneNumber) {
        super(email, pass, phoneNumber);
    }

    public void vote(Contest contest, Photo photo){
        if (this.votes.containsKey(contest)){
            if (this.votes.get(contest).size() < 3){
                this.votes.get(contest).add(photo);
                photo.vote();
            }
            else {
                System.out.println("You cannot vote for more than 3 times in '" + contest.getName() + "' contest");
            }
        }
        else{
            ArrayList<Photo> photos = new ArrayList<>();
            photos.add(photo);
            this.votes.put(contest, photos);
            photo.vote();
        }
    }

    public void removeVote(Contest contest, Photo photo){
        if (this.votes.containsKey(contest)){
            if (this.votes.get(contest).contains(photo)){
                this.votes.get(contest).remove(photo);
                photo.removeVote();
            }
            else{
                System.out.println("You did not vote for photo '" + photo.getTitle() +
                        "' in contest '" + contest.getName());
            }
        }
        else{
            System.out.println("You did not vote in contest '" + contest.getName());
        }
    }

}
