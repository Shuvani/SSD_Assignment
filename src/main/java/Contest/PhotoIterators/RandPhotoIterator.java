package Contest;

import java.util.*;

public class RandPhotoIterator implements Iterator<Photo> {
    private Iterator<Photo> photosIter;

    public RandPhotoIterator(ArrayList<Photo> photos){
        Collections.shuffle(photos);
        this.photosIter = photos.iterator();
    }

    public boolean hasNext(){
        return this.photosIter.hasNext();
    }

    public Photo next(){
        return this.photosIter.next();
    }
}
