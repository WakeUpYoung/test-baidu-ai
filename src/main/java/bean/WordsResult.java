package bean;

import java.util.ArrayList;
import java.util.List;

public class WordsResult {
    private String words;

    private WordLocation location;

    private ArrayList<CharValue> characters;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public WordLocation getLocation() {
        return location;
    }

    public void setLocation(WordLocation location) {
        this.location = location;
    }

    public ArrayList<CharValue> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<CharValue> characters) {
        this.characters = characters;
    }

}
