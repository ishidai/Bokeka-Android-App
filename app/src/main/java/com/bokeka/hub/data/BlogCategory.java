
package com.bokeka.hub.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlogCategory {

    @SerializedName("blog_categories")
    @Expose
    private List<BlogCategoryModel> blogCategories = null;
    @SerializedName("code")
    @Expose
    private String code;

    public List<BlogCategoryModel> getBlogCategories() {
        return blogCategories;
    }

    public void setBlogCategories(List<BlogCategoryModel> blogCategories) {
        this.blogCategories = blogCategories;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
