package bean;

import java.util.List;

public class AdvanceResult {
    private Long logId;

    private String resultNum;

    private List<WordsResult> wordsResult;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getResultNum() {
        return resultNum;
    }

    public void setResultNum(String resultNum) {
        this.resultNum = resultNum;
    }

    public List<WordsResult> getWordsResult() {
        return wordsResult;
    }

    public void setWordsResult(List<WordsResult> wordsResult) {
        this.wordsResult = wordsResult;
    }
}
