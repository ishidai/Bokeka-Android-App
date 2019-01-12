
package com.bokeka.hub.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Blog {

    @SerializedName("blogs")
    @Expose
    private List<BlogEntity> blogs = null;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("prev")
    @Expose
    private Object prev;

    public List<BlogEntity> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogEntity> blogs) {
        this.blogs = blogs;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrev() {
        return prev;
    }

    public void setPrev(Object prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogs=" + blogs +
                ", count=" + count +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
