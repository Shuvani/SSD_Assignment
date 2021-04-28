import NotificationFabric.NotificationFabric;
import NotificationFabric.SMSNotificationFabric;
import NotificationFabric.MailNotificationFabric;
import Users.*;
import Contest.*;
import javax.naming.OperationNotSupportedException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

public class ApplicationConfigurator {

    private static void testNotifications(String notificationType) throws OperationNotSupportedException{
        NotificationFabric fabric;

        if (notificationType.equals("SMS")) {
            fabric = new SMSNotificationFabric();
        }
        else if (notificationType.equals("Mail")) {
            fabric = new MailNotificationFabric();
        }
        else {
            throw new OperationNotSupportedException();
        }

        Application app = new Application(fabric);
        app.createNotification();
        app.sendNotification();
    }

    private static void testContest() throws FileNotFoundException {
        Admin admin = new Admin("abmin.admin@gmail.com", "admin", 123456);

        Date start = new Date(50, 6, 7);
        Date end = new Date(152, 6, 7);


        Contest contest = admin.loadContest("Red", "Contest of colorful photos",
                start, end, 0, true, 1);

        // create participants
        int N = 10;
        Photographer[] photographers = new Photographer[N];
        Photo[] photos= new Photo[N];

        Image img = new Image(new FileInputStream("./src/main/java/Application.java"));

        for(int i = 0; i < N; i++) {
            photographers[i] = new Photographer("email", "123", i);
            // participate with a new photo
            Participant participant = photographers[i].applyForContest(contest);
            participant.addPhoto(img, "title");

            ArrayList<Photo> list = participant.getPhotos();
            photos[i] = list.get(list.size() - 1);
            admin.changeStatusOfPhoto(photos[i], 1);
        }
        // create voters
        Voter[] voters = new Voter[N];
        for(int i = 0; i < N; i++) {
            voters[i] = new Voter("voter_email", "1234", 98700+i);
            // perform voting
            int firstVoteIndex = new Random().nextInt(N);
            voters[i].vote(contest, photos[firstVoteIndex]);
            voters[i].vote(contest, photos[new Random().nextInt(N)]);
            voters[i].vote(contest, photos[new Random().nextInt(N)]);
            if (i % 3 == 0){
                voters[i].removeVote(contest, photos[firstVoteIndex]);
            }
            voters[i].vote(contest, photos[new Random().nextInt(N)]);
        }
        // Finish the contest
        admin.closeContest(contest);
        for (int i=0; i<N; i++){
            System.out.println("Photo["+i+"]\t Score: "+photos[i].getVotes());
        }
        for(Participant p: contest.getWinners()) {
            System.out.println(p.toString());
        }
    }


    public static void main(String[] args) throws OperationNotSupportedException, FileNotFoundException {
        testNotifications("SMS");
        testNotifications("Mail");
        testContest();
    }

}
