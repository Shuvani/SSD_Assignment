package Users;
import Contest.Contest;
import Contest.Photo;
import java.util.ArrayList;

public class Participant extends Photographer{

    private Contest contest;
    private ArrayList<Photo> photos = new ArrayList<Photo>();

    public void addPhoto(Photo photo){
        this.photos.add(photo);
    }

    public void removePhoto(Photo photo){

        this.photos.remove(photo);
    }

    public ArrayList<Photo> getPhotos(){

        return this.photos;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }
}
