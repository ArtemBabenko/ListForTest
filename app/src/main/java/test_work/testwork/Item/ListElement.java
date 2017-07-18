package test_work.testwork.Item;

public class ListElement {
    private int id;
    private int img;
    private String header;
    private String date;
    private String apartments;
    private String apartments_build;
    private String location_text;
    private String topic;
    private int topic_image;
    private String text_body;

    public ListElement(int id, int img, String header, String date, String apartments, String apartments_build, String location_text, String topic, int topic_image, String text_body) {
        this.id = id;
        this.img = img;
        this.header = header;
        this.date = date;
        this.apartments = apartments;
        this.apartments_build = apartments_build;
        this.location_text = location_text;
        this.topic = topic;
        this.topic_image = topic_image;
        this.text_body = text_body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getApartments() {
        return apartments;
    }

    public void setApartments(String location) {
        this.apartments = location;
    }

    public String getApartments_build() {
        return apartments_build;
    }

    public void setApartments_build(String location_body) {
        this.apartments_build = location_body;
    }

    public String getLocation_text() {
        return location_text;
    }

    public void setLocation_text(String location_text) {
        this.location_text = location_text;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTopic_image() {
        return topic_image;
    }

    public void setTopic_image(int topic_image) {
        this.topic_image = topic_image;
    }

    public String getText_body() {
        return text_body;
    }

    public void setText_body(String text_body) {
        this.text_body = text_body;
    }
}
