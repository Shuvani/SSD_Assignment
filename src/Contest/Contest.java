package Contest;
import Users.Participant;
import java.util.ArrayList;

public class Contest {

    private ArrayList<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant){
        this.participants.add(participant);
    }
    public ArrayList<Participant> getParticipants(){
        return participants;
    }

}
