package Users;
import Contest.Contest;
import Contest.Photo;
import java.util.ArrayList;

public class Photographer extends User{

    private ArrayList<Contest> contests = new ArrayList<Contest>();
//    private ArrayList<Contest.Photo> photos = new ArrayList<>();

    public void applyForContest(Contest contest){
        contests.add(contest);
    }

}
