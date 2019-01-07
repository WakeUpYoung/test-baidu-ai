package baidu.ai;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;

public class BaiduAi {
    private static final String APP_ID = "15340554";
    private static final String API_KEY = "f3hvVD2AIjs1V4UyEUh8m7UO";
    private static final String SECRET_KEY = "iQiSEk0GY3l57Eu5xkdG2sRRzFkkTrSf";

    private static AipImageClassify imageClient;

    private static AipOcr ocrClient;

    private BaiduAi(){

    }

    public static AipImageClassify getImageClient() {
        if (imageClient != null){
            return imageClient;
        }else {
            imageClient = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
            imageClient.setConnectionTimeoutInMillis(30000);
            return imageClient;
        }
    }

    public static AipOcr getOcrClient(){
        if (ocrClient != null){
            return ocrClient;
        }else {
            ocrClient = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
            ocrClient.setConnectionTimeoutInMillis(30000);
            return ocrClient;
        }
    }
}
