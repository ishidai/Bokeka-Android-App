
package com.bokeka.hub.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginTokenResp {

    private Long id;

    @SerializedName("expiration")
    @Expose
    private Integer expiration;

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

    public LoginTokenResp(Long id, Integer expiration,String token,
                          Integer userId) {
        this.id = id;
        this.expiration = expiration;
        this.token = token;
        this.userId = userId;
    }

    public LoginTokenResp() {
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LoginTokenResp{" +
                "expiration=" + expiration +
                ", token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
