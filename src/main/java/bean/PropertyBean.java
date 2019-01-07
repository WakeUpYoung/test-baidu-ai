package bean;

public class PropertyBean {
    private String name;

    private String pose = "Unspecified";

    private int truncated = 0;

    private int difficult = 0;

    private BndBox bndBox;

    public PropertyBean() {
    }

    public PropertyBean(String name, BndBox bndBox) {
        this.name = name;
        this.bndBox = bndBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPose() {
        return pose;
    }

    public void setPose(String pose) {
        this.pose = pose;
    }

    public int getTruncated() {
        return truncated;
    }

    public void setTruncated(int truncated) {
        this.truncated = truncated;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public BndBox getBndBox() {
        return bndBox;
    }

    public void setBndBox(BndBox bndBox) {
        this.bndBox = bndBox;
    }
}
