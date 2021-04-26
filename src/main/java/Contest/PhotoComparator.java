package Contest;
import java.util.*;

public class PhotoComparator implements Comparator<Photo>{
    public int compare(Photo s1, Photo s2)
    {
        return s1.getVotes() - s2.getVotes();
    }
}
