package workingWithFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    private final String FILE_NAME = "resource/fileLinks.txt";
    public List<String> getLinksFromFile() {
        List<String> listLinks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "Cp1251"))){
            String str;
            while((str = br.readLine()) != null){
                listLinks.add(str);
            }
        }
        catch (UnsupportedEncodingException | FileNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listLinks;
    }
}
