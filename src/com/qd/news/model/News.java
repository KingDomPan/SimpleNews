package com.qd.news.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.qd.news.template.ItemTemplate;

@Document(collection = "news")
public class News implements ItemTemplate {
    private String content;
    private Date createDate;
    private String filePath;
    private List<Forum> forums;
    @Id
    private String id;
    private Date lastModifyTime;
    @Indexed(unique = true)
    private String title;
    private String type;

    public String getContent() {
        return content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public List<Forum> getForums() {
        return forums;
    }

    public String getId() {
        return id;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setForums(List<Forum> forums) {
        this.forums = forums;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "News [id=" + id + ", title=" + title + ", content=" + content
                + ", createDate=" + createDate + ", forums=" + forums
                + ", lastModifyTime=" + lastModifyTime + ", filePath="
                + filePath + ", type=" + type + "]";
    }
}
