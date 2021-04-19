package Users;
import Contest.Contest;
import Contest.Photo;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends User {


    public void changeStatusOfPhoto(Photo photo, String newStatus){}

    public Contest loadContest(String topic, String description, Date dateStart, Date dateFinish){
        return new Contest(topic, description, dateStart, dateFinish);
    }

    public void closeContest(Contest contest){}

    public void setWinner(Contest contest, Participant winner){
//        contest.setWinner(winner);
    }



}
