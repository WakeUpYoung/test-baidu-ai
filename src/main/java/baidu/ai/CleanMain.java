package baidu.ai;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class CleanMain {

    private static final Logger LOG = LoggerFactory.getLogger(CleanMain.class);

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Ste\\Desktop\\file\\王禹");
        AipImageClassify imageClient = BaiduAi.getImageClient();
        long start = System.currentTimeMillis();
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File img : files){
                dataClean(img, imageClient);
            }
            System.out.println("程序完成，耗时:" + (System.currentTimeMillis() - start));
        }
    }

    public static void dataClean(File image, AipImageClassify imageClient) {
        HashMap<String, String> options = new HashMap<>();
        JSONObject jsonObject = imageClient.advancedGeneral(image.getAbsolutePath(), options);
        String jsonString = jsonObject.toString();
        if (jsonString.contains("汽车")) {
            copy(image, "C:\\Users\\Ste\\Desktop\\file\\clean" + "\\" + image.getName());
//            LOG.info("Copy成功:" + image.getName());
            System.out.println("Copy成功:" + image.getName());
        }
    }

    public static void copy(File source, String desPath){
        FileChannel sourceChannel = null;
        FileChannel desChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            desChannel = new FileOutputStream(new File(desPath)).getChannel();
            if (source.exists()){
                desChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                sourceChannel.close();
                desChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
