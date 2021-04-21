package Users;
import Contest.Contest;
import Contest.Photo;
import java.util.ArrayList;

public class Participant {

    private Contest contest;
    private Photographer photographer;
    private ArrayList<Photo> photos = new ArrayList<>();

    public Participant(Photographer photographer){
        this.photographer = photographer;
    }

    @Override
    public String toString() {
        return photographer.toString();
    }

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
