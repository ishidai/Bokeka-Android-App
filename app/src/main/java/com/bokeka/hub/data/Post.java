
package com.bokeka.hub.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("body_html")
    @Expose
    private String bodyHtml;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @SerializedName("comment_user_last")
    @Expose
    private String commentUserLast;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("num_view")
    @Expose
    private Integer numView;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("username")
    @Expose
    private String username;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getCommentUserLast() {
        return commentUserLast;
    }

    public void setCommentUserLast(String commentUserLast) {
        this.commentUserLast = commentUserLast;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumView() {
        return numView;
    }

    public void setNumView(Integer numView) {
        this.numView = numView;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
