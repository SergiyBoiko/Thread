package workingWithFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToFile {
    private final String FILE_NAME = "resource/MD5Hash.txt";
    public void writeMD5HashToFile(String content){
        try (BufferedWriter write = new BufferedWriter(new FileWriter(new File(FILE_NAME),true))){
            write.write("["+content+"]");
            write.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cleanResources(){
        try {
            Files.deleteIfExists(Paths.get(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
