package com.amgcyo.cuttadon.api.entity.comment;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BaseCommentBean implements Serializable {
    private String avatar;
    private int comment_id;
    private String content;
    private String created_at;
    private boolean isLoginUser;
    private String nick;
    private int reply_count;
    private int score;
    private int user_id;

    public String getAvatar() {
        return this.avatar;
    }

    public int getComment_id() {
        return this.comment_id;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getNick() {
        return this.nick;
    }

    public int getReply_count() {
        return this.reply_count;
    }

    public int getScore() {
        return this.score;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public boolean isLoginUser() {
        return this.isLoginUser;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setComment_id(int i2) {
        this.comment_id = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setLoginUser(boolean z2) {
        this.isLoginUser = z2;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setReply_count(int i2) {
        this.reply_count = i2;
    }

    public void setScore(int i2) {
        this.score = i2;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }
}
