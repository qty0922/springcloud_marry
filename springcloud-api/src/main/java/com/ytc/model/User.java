package com.ytc.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * dubbo中的实体类一定要实现序列化，因为我们传递参数的时候是通过二进制的流传递的
     * 不序列化，是没有办法把对象传过去的
     */
    private static final long serialVersionUID = -7851723820525052564L;
    private Integer userId;

    private String userName;

    private String userPwd;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public User() {
    }
}