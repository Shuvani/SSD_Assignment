package Users;
import Contest.Contest;
import Contest.Photo;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends User {

    public Admin(String email, String pass, int phoneNumber){
        super(email, pass, phoneNumber);
    }

    public void changeStatusOfPhoto(Photo photo, int newStatus){
        photo.changeStatus(newStatus);
    }

    public Contest loadContest(String topic, String description, Date dateStart, Date dateFinish){
        return new Contest(topic, description, dateStart, dateFinish);
    }

    public Contest loadContest(String name, String description, Date start, Date finnish,
                               int winnerNotificationType, boolean votingRequired, int winnersCount){
        return new Contest(name, description, start, finnish,
                winnerNotificationType, votingRequired, winnersCount);
    }

    public void closeContest(Contest contest){
        contest.finish();
    }

    public void setWinners(Contest contest, ArrayList<Participant> winners){
        contest.setWinners(winners);
    }



}
