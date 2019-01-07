package bean;

import java.util.List;

public class AdvanceResult {
    private Long logId;

    private String wordsResultNum;

    private List<WordsResult> wordsResult;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getWordsResultNum() {
        return wordsResultNum;
    }

    public void setWordsResultNum(String wordsResultNum) {
        this.wordsResultNum = wordsResultNum;
    }

    public List<WordsResult> getWordsResult() {
        return wordsResult;
    }

    public void setWordsResult(List<WordsResult> wordsResult) {
        this.wordsResult = wordsResult;
    }
}
