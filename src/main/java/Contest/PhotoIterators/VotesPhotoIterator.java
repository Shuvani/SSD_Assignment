package Contest;

import java.util.*;

public class VotesPhotoIterator implements Iterator<Photo> {
    private Iterator<Photo> photosIter;

    public VotesPhotoIterator(ArrayList<Photo> photos){
        Collections.sort(photos, new Comparator<Photo>(){
                @Override
                public int compare(Photo p1, Photo p2) {
                    Integer i1 = Integer.valueOf(p1.getVotes());
                    Integer i2 = Integer.valueOf(p2.getVotes());
                    return i1.compareTo(i2);
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
