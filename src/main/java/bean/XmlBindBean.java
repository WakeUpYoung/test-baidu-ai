package bean;

import java.util.List;

public class XmlBindBean {
    private String folder;

    private String filename;

    private String path;

    private List<PropertyBean> propertyBeanList;

    public XmlBindBean(String folder, String filename, String path, List<PropertyBean> propertyBeanList) {
        this.folder = folder;
        this.filename = filename;
        this.path = path;
        this.propertyBeanList = propertyBeanList;
    }

    public XmlBindBean(List<PropertyBean> propertyBeanList) {
        this.propertyBeanList = propertyBeanList;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<PropertyBean> getPropertyBeanList() {
        return propertyBeanList;
    }

    public void setPropertyBeanList(List<PropertyBean> propertyBeanList) {
        this.propertyBeanList = propertyBeanList;
    }
}
