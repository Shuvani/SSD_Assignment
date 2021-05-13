package Contest;

import java.util.*;

public class PhotosCollection implements Iterable<Photo> {
    private ArrayList<Photo> photos;

    public PhotosCollection(){
        this.photos = new ArrayList<Photo>();
    }

    public PhotosCollection(ArrayList<Photo> photos){
        this.photos = photos;
    }

    public ArrayList<Photo> unwrap(){
        return this.photos;
    }

    public void wrap(ArrayList<Photo> photos){
        this.photos = photos;
    }

    public void add(Photo p){
        photos.add(p);
    }

    public void remove(Photo p){
        photos.remove(p);
    }

    /**
     * The generator of iterator over all photos in order,
     * they were added to the contest
     * */
    public Iterator<Photo> iterator(){
        return new SeqPhotoIterator(photos);
    }

    /**
     * The iterator over the photos, the order is specified by the `Specifier`
     * - `RandSpec` - random order of the photos
     * - `SeqSpec` - default, the order is the same, as the order of addition to the contest
     * - `TitleSpec` - the photos are ordered by the title
     * - `VotesSpec` - the photos are ordered from the most popular to the least popular image
     * */
    public Iterator<Photo> iterator(Specifier s){
        if(s instanceof RandSpec) { return new RandPhotoIterator(photos); }
        if(s instanceof SeqSpec) { return new SeqPhotoIterator(photos); }
        if(s instanceof TitleSpec) { return new TitlePhotoIterator(photos); }
        if(s instanceof VotesSpec) { return new VotesPhotoIterator(photos); }

        return new SeqPhotoIterator(photos);
    }
}
