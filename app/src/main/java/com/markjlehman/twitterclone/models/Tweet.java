package com.markjlehman.twitterclone.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Table(name = "Tweets", id = "_id")
public class Tweet extends Model {
    @Column(name = "User")
    private User mUser;

    @Column(name = "CreatedAt")
    private long mCreatedAt;

    @Column(name = "Content")
    private String mContent;

    @Column(name = "_id")
    private Long mId;

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

    public static List<Tweet> all() {
        return new Select().from(Tweet.class).execute();
    }

    public static Tweet find(int id) {
        return new Select().from(Tweet.class).where("_id = ?", id).executeSingle();
    }

    public Long getmId() {
        return mId;
    }
}
