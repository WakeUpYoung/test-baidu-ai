package baidu.ai;

import bean.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import utils.FastXml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class SingleHandler {

    public static void startHandle(File image){
        String imgPath = image.getAbsolutePath();
        JSONObject jsonObject = get(imgPath);
        List<PropertyBean> propertyBeanList = new ArrayList<>();
        XmlBindBean xmlBindBean = new XmlBindBean(propertyBeanList);
        xmlBindBean.setFilename(image.getName());
        xmlBindBean.setFolder(image.getParentFile().getName());
        xmlBindBean.setPath(image.getAbsolutePath());
        String str = jsonObject.toString().replace("char", "character");
        System.out.println(str);
        AdvanceResult advanceResult = JSON.parseObject(str, new TypeReference<AdvanceResult>() {
        });
        if (advanceResult.getWordsResult() == null){
            return;
        }
        Iterator<WordsResult> iterator = advanceResult.getWordsResult().iterator();
        while (iterator.hasNext()){
            WordsResult wordsResult = iterator.next();
            String words = wordsResult.getWords();
            Pattern pattern = Pattern.compile("[a-z/]");
            if (words.equals("00 : 00")){  // 不能匹配时间
                iterator.remove();
                continue;
            }
            if (words.equals("II M DM B W EO 3")){  // 不能匹配非法字符
                iterator.remove();
                continue;
            }
            if (pattern.matcher(words).find()){
                iterator.remove();
                continue;
            }
            // 如果没有需要处理的字符，则不继续操作
            if (advanceResult.getWordsResult().size() <= 0){
                return;
            }
            for (CharValue charValue : wordsResult.getCharacters()){
                if (charValue.getCharacter().equals(".")){
                    continue;
                }
                WordLocation location = charValue.getLocation();
                int y = location.getTop();
                int x = location.getLeft();
                int height = location.getHeight();
                int width = location.getWidth();
                PropertyBean propertyBean = new PropertyBean();
                propertyBean.setName(charValue.getCharacter());
                BndBox bndBox = new BndBox(x, y, x + width, y + height);
                propertyBean.setBndBox(bndBox);
                propertyBeanList.add(propertyBean);
            }
        }// end of WordsResult
        FastXml fastXml = new FastXml(xmlBindBean);
        String xml = fastXml.create();
        String newFileName = imgPath.substring(0, imgPath.lastIndexOf("."))+".xml";
        File desFile = new File(newFileName);
        boolean write = FastXml.write(xml, desFile);
    }

    private static JSONObject get(String image){
        AipOcr ocrClient = BaiduAi.getOcrClient();
        HashMap<String, String> options = new HashMap<>();
        options.put("recognize_granularity", "small");
        options.put("language_type", "ENG");
        return ocrClient.general(image, options);
    }
}
