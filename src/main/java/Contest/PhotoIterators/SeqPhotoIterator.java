package Contest;

import java.util.*;

public class SeqPhotoIterator implements Iterator<Photo> {
    private Iterator<Photo> photosIter;

    public SeqPhotoIterator(ArrayList<Photo> photos){
        this.photosIter = photos.iterator();
    }

    public boolean hasNext(){
        return this.photosIter.hasNext();
    }

    public Photo next(){
        return this.photosIter.next();
    }
}
