package com.markjlehman.twitterclone.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Table(name = "Tweets", id = "_id")
public class Tweet extends Model {
    @Column(name = "User")
    private User mUser;

    @Column(name = "CreatedAt")
    private long mCreatedAt;

    @Column(name = "Content")
    private String mContent;

    public Tweet(User mUser, String mContent) {
        super();
        this.mUser = mUser;
        this.mContent = mContent;
        this.mCreatedAt = new Date().getTime();
    }

    public Tweet() {
        super();
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public long getmCreatedAt() {
        return mCreatedAt;
    }

    public void setmCreatedAt(long mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("PST"));
        return formatter.format(mCreatedAt);
    }
}
