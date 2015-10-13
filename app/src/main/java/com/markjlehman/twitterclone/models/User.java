package com.markjlehman.twitterclone.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Users", id = "_id")
public class User extends Model {
    @Column(name = "Name")
    private String mName;

    @Column(name = "Email")
    private String mEmail;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public User(String mName, String mEmail) {
        super();
        this.mName = mName;
        this.mEmail = mEmail;
    }

    public User() {
        super();
    }
}
