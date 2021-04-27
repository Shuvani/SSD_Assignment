package Contest;

import java.io.*;

public class Image {
    private FileInputStream data;

    public Image(FileInputStream data){
        this.data = data;
    }

    public FileInputStream getImageData(){
        return this.data;
    }
}
