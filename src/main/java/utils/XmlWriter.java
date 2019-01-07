package utils;

public class XmlWriter {

    private StringBuilder xml = new StringBuilder();
    private String startTag;

    public XmlWriter(){

    }

    public void start(String start){
        this.startTag = start;
        xml.append(transTag(startTag)).append("\n");
    }

    public void addTag(String tag, String content){
        xml.append("\t").append(transTag(tag))
                .append(content)
                .append(transEndTag(tag))
                .append("\n");
    }

    public void addTagWithNoEnd(String tag, String content){
        xml.append(transTag(tag))
                .append("\n");
    }

    public void build(){
        xml.append(transEndTag(startTag));
    }

    public String getXML(){
        return xml.toString();
    }

    public StringBuilder getXml() {
        return xml;
    }

    private static String transTag(String tag){
        return "<" + tag + ">";
    }

    private static String transEndTag(String tag){
        return "</" + tag + ">";
    }

}
