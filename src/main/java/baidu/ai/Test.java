package baidu.ai;

import com.baidu.aip.ocr.AipOcr;

import java.io.File;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String img = "C:\\Users\\Ste\\Desktop\\file\\clean\\34002.jpg";
        AipOcr ocrClient = BaiduAi.getOcrClient();
        HashMap<String, String> options = new HashMap<>();
        options.put("recognize_granularity", "small");
        options.put("language_type", "ENG");
        String s = ocrClient.general(img, options).toString();
        System.out.println(s);

        SingleHandler.startHandle(new File(img));

    }
}
