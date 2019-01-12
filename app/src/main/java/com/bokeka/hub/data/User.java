
package com.bokeka.hub.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("followed_posts")
    @Expose
    private String followedPosts;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("last_seen")
    @Expose
    private String lastSeen;
    @SerializedName("member_since")
    @Expose
    private String memberSince;
    @SerializedName("post_count")
    @Expose
    private Integer postCount;
    @SerializedName("posts")
    @Expose
    private String posts;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("username")
    @Expose
    private String username;

    public String getFollowedPosts() {
        return followedPosts;
    }

    public void setFollowedPosts(String followedPosts) {
        this.followedPosts = followedPosts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
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

    @Override
    public String toString() {
        return "User{" +
                "followedPosts='" + followedPosts + '\'' +
                ", id=" + id +
                ", lastSeen='" + lastSeen + '\'' +
                ", memberSince='" + memberSince + '\'' +
                ", postCount=" + postCount +
                ", posts='" + posts + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
