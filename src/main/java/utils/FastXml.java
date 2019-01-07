package utils;

import bean.PropertyBean;
import bean.XmlBindBean;

import java.io.*;

public class FastXml {

    private XmlBindBean xmlBean;
    private boolean isNeed = true;
    public FastXml(XmlBindBean xmlBean) {
        this.xmlBean = xmlBean;
    }

    public String create(){
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("annotation");
        xmlWriter.addTag("folder", xmlBean.getFolder());
        xmlWriter.addTag("filename", xmlBean.getFilename());
        xmlWriter.addTag("path", xmlBean.getPath());
        xmlWriter.addTag("source", "\n\t\t<database>Unknown</database>\n\t");
        xmlWriter.addTag("size", "\n\t\t<width>1920</width>\n" +
                "\t\t<height>1080</height>\n" +
                "\t\t<depth>3</depth>\n\t");
        xmlWriter.addTag("segmented", "0");
        if (xmlBean.getPropertyBeanList().size() <= 0){
            isNeed = false;
            return "";
        }
        for (PropertyBean bean : xmlBean.getPropertyBeanList()){
            addObject(xmlWriter, bean);
        }
        xmlWriter.build();
        return xmlWriter.getXML();

    }

    public XmlBindBean getXmlBean() {
        return xmlBean;
    }

    public void setXmlBean(XmlBindBean xmlBean) {
        this.xmlBean = xmlBean;
    }

    private static void addObject(XmlWriter xmlWriter, PropertyBean bean){
        StringBuilder xml = xmlWriter.getXml();
        xml.append("\t<object>").append("\n")
                .append("\t\t<name>").append(bean.getName()).append("</name>").append("\n")
                .append("\t\t<pose>Unspecified</pose>").append("\n")
                .append("\t\t<truncated>0</truncated>\n" +
                        "\t\t<difficult>0</difficult>").append("\n").append("\t\t<bndbox>\n" + "\t\t\t<xmin>")
                .append(bean.getBndBox().getXmin()).append("</xmin>\n").append("\t\t\t<ymin>").append(bean.getBndBox().getYmin())
                .append("</ymin>\n").append("\t\t\t<xmax>").append(bean.getBndBox().getXmax()).append("</xmax>\n").append("\t\t\t<ymax>")
                .append(bean.getBndBox().getYmax()).append("</ymax>\n").append("\t\t</bndbox>").append("\n").append("\t</object>\n");

    }

    public static boolean write(String writeStr, File desFile){
        if (writeStr == null || writeStr.equals("")){
            return false;
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(desFile, false);
            fos.write(writeStr.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
