import org.apache.commons.codec.digest.DigestUtils;
import workingWithFile.CrawlURL;
import workingWithFile.ReadFromFile;
import workingWithFile.WriteToFile;

import java.util.concurrent.ExecutorService;

public class Processes {
    public void run(ReadFromFile readFromFile, WriteToFile writeToFile, CrawlURL crawlURL, ExecutorService executor){
        readFromFile.getLinksFromFile().forEach((link) -> {
            executor.execute(() -> {
                writeToFile.cleanResources();
                String content = crawlURL.getContentByLink(link);
                String hash = DigestUtils.md5Hex(content);
                writeToFile.writeMD5HashToFile(hash);
            });
        });
        executor.shutdown();
    }
}
