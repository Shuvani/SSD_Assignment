package Users;
import Contest.Contest;
import Contest.Photo;
import Contest.Image;
import Contest.PhotosCollection;
import java.util.ArrayList;

public class Participant {

    private Contest contest;
    private Photographer photographer;
    private PhotosCollection photos = new PhotosCollection();

    public PhotosCollection getPhotos(){
        return this.photos;
    }

    public Participant(Photographer photographer){
        this.photographer = photographer;
    }

    @Override
    public String toString() {
        return photographer.toString();
    }

    public void addPhotoFromImageIndex(int imageIndex, String title){
        Image img = this.photographer.getImageById(imageIndex);
        addPhoto(img, title);
    }
    public void addPhoto(Image image){
        this.photos.add(new Photo(image, this, ""));
    }
    public void addPhoto(Image image, String title){
        this.photos.add(new Photo(image, this, title));
    }

    public void removePhoto(Photo photo){
        this.photos.remove(photo);
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }
}
