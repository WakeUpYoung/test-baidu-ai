package baidu.ai;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String img = "C:\\Users\\Ste\\Desktop\\file\\王禹0117\\7940.jpg";
        AipImageClassify imageClassify = BaiduAi.getImageClient();
        HashMap<String, String> options = new HashMap<>();
        options.put("top_num", "3");
        JSONObject jsonObject = imageClassify.carDetect(img, options);
        System.out.println(jsonObject.toString());

    }
}
