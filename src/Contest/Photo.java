package Contest;
import Users.Participant;

import java.io.*;

public class Photo {
    private String title;
    private FileInputStream data;
    private int votes;
    private Participant author;

    public Photo(FileInputStream data, Participant author){
        this.data = data;
        this.author = author;
    }

    public Photo(FileInputStream data, Participant author, String title){
        this(data, author);
        this.title = title;
    }

    public String getTitle(){return this.title;}
    public void rename(String newTitle){
        this.title = newTitle;
    }
    public void vote(){
        this.votes++;
    }
    public void removeVote(){
        this.votes--;
    }
    protected int getVotes(){
        return this.votes;
    }
    protected Participant getAuthor(){
        return this.author;
    }

}
