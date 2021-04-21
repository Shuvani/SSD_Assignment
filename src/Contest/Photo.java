package Contest;
import Users.Participant;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.io.*;

public class Photo {
    private String title;
    private FileInputStream data;
    private int votes;
    private Participant author;
    /**
     * Possible values of `status` attribute
     * 0 - plagiarized
     * 1 - verified
     * -1 - not defined
     * */
    private int status;

    public Photo(FileInputStream data, Participant author){
        this.data = data;
        this.author = author;
        this.status = -1; // not defined
    }

    public Photo(FileInputStream data, Participant author, String title){
        this(data, author);
        this.title = title;
    }

    public String getTitle(){return this.title;}

    public void rename(String newTitle){
        this.title = newTitle;
    }

    public void changeStatus(int newStatus){
        if(newStatus > 1 || newStatus<-1){
            throw new ValueException("Status of the photo should be in [-1, 0, 1]. Given value: " + newStatus);
        }
        this.status = newStatus;
    }

    public void vote(){
        if(this.status == 1) {
            this.votes++;
        }
    }
    public void removeVote(){
        if(this.status == 1) {
            this.votes--;
        }
    }
    public int getVotes(){
        return this.votes;
    }
    protected Participant getAuthor(){
        return this.author;
    }

}
