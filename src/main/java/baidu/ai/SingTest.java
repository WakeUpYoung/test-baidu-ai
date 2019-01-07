package baidu.ai;

import bean.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SingTest {
    public static void main(String[] args) {
        JSONObject jsonObject = get("C:\\Users\\Ste\\Desktop\\file\\王禹\\33727.jpg");
//        BndBox bndBox = new BndBox();
        String str = jsonObject.toString().replace("char", "character");
        AdvanceResult advanceResult = JSON.parseObject(str, new TypeReference<AdvanceResult>() {
        });
        for (WordsResult wordsResult : advanceResult.getWordsResult()){
            String words = wordsResult.getWords();
            Pattern pattern = Pattern.compile("[a-z]");
            if (words.equals("00 : 00")){
                continue;
            }
            if (pattern.matcher(words).find()){
                continue;
            }
            for (CharValue charValue : wordsResult.getCharacters()){
                System.out.println("Height  " + charValue.getLocation().getHeight());
            }
            for (VertexesLocation vertexesLocation : wordsResult.getVertexesLocation()){
                System.out.println(vertexesLocation.getX() + "," + vertexesLocation.getY());
            }
        }
    }

    public static JSONObject get(String image){
        AipOcr ocrClient = BaiduAi.getOcrClient();
        HashMap<String, String> options = new HashMap<>();
        options.put("recognize_granularity", "small");
        options.put("language_type", "ENG");
        options.put("vertexes_location", "true");
        return ocrClient.general(image, options);
    }
}
