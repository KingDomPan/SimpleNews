package com.qd.news.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.qd.news.template.ItemTemplate;

@Document(collection = "forum")
public class Forum implements ItemTemplate {
    @Id
    private String id;
    private String title;
    private String content;
    @DBRef
    private User viewer;

    @Override
    public String toString() {
        return "Forum [id=" + id + ", title=" + title + ", content=" + content
                + ", viewer=" + viewer + ", issDate=" + issDate + ", reforum="
                + reforum + "]";
    }

    @Indexed(unique = true)
    private Date issDate;
    @DBRef
    private Forum reforum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getViewer() {
        return viewer;
    }

    public void setViewer(User viewer) {
        this.viewer = viewer;
    }

    public Date getIssDate() {
        return issDate;
    }

    public void setIssDate(Date issDate) {
        this.issDate = issDate;
    }

    public Forum getReforum() {
        return reforum;
    }

    public void setReforum(Forum reforum) {
        this.reforum = reforum;
    }
}
