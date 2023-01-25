package model;

import java.util.Date;
import java.util.Objects;

public class News {
    private int id;
    private Date createDate;
    private String header;
    private String content;

    private boolean visible;

    public News() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public News(String header, String content) {
        this.createDate = new Date();
        this.header = header;
        this.content = content;
        this.visible = true;
    }

    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        News news = (News) o;
        return id == news.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate, header, content, visible);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", visible=" + visible +
                '}';
    }
}
