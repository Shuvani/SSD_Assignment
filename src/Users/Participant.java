package Users;
import Contest.Contest;
import Contest.Photo;
import java.util.ArrayList;

public class Participant extends Photographer{

    private Photo photo;
    private Contest contest;

    public void setPhoto(Photo photo){
        this.photo = photo;
    }

    public void removePhoto(){

        this.photo = null;
    }

    public Photo getPhoto(){

        return this.photo;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }
}
