package com.avengors.entity;

public class Member {
    private int idx;
    private String userId, userPw, name, birth, gender, address;
    private boolean deleted;

    @Override
    public String toString() {
        return "Member{" +
                "idx=" + idx +
                ", userId='" + userId + '\'' +
                ", userPw='" + "****" + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public Member() {
    }

    public Member(String userId, String userPw, String name, String birth, String gender, String address) {
        this.userId = userId;
        this.userPw = userPw;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
