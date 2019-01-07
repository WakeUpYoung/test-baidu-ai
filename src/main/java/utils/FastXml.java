package utils;

import bean.PropertyBean;
import bean.XmlBindBean;

public class FastXml {

    private XmlBindBean xmlBean;

    public FastXml(XmlBindBean xmlBean) {
        this.xmlBean = xmlBean;
    }

    public String create(){
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("annotation");
        xmlWriter.addTag("folder", xmlBean.getFolder());
        xmlWriter.addTag("filename", xmlBean.getFilename());
        xmlWriter.addTag("source", "\n\t\t<database>Unknown</database>\n\t");
        xmlWriter.addTag("size", "\n\t\t<width>1920</width>\n" +
                "\t\t<height>1080</height>\n" +
                "\t\t<depth>3</depth>\n\t");
        xmlWriter.addTag("segmented", "0");
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
                .append(bean.getBndBox().getXmin()).append("</xmin>\n").append("\t\t\t<ymin>").append(bean.getBndBox().getXmin())
                .append("</ymin>\n").append("\t\t\t<xmax>").append(bean.getBndBox().getXmin()).append("</xmax>\n").append("\t\t\t<ymax>")
                .append(bean.getBndBox().getXmin()).append("</ymax>\n").append("\t\t</bndbox>").append("\n").append("\t</object>\n");

    }
}
