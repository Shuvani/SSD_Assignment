package Contest;

import java.util.*;

public class TitlePhotoIterator implements Iterator<Photo> {
    private Iterator<Photo> photosIter;

    public TitlePhotoIterator(ArrayList<Photo> photos){
        Collections.sort(photos, new Comparator<Photo>(){
                @Override
                public int compare(Photo p1, Photo p2) {
                    return p1.getTitle().compareTo(p2.getTitle());
                }
            });

        this.photosIter = photos.iterator();
    }

    public boolean hasNext(){
        return this.photosIter.hasNext();
    }

    public Photo next(){
        return this.photosIter.next();
    }
}
