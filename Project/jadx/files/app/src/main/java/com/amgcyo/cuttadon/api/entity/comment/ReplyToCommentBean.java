package com.amgcyo.cuttadon.api.entity.comment;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ReplyToCommentBean implements Serializable {
    private String avatar;
    private boolean floor_host;
    private String nick;
    private int user_id;

    public ReplyToCommentBean() {
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public boolean isFloor_host() {
        return this.floor_host;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFloor_host(boolean z2) {
        this.floor_host = z2;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }

    public String toString() {
        return "ReplyToCommentBean{nick='" + this.nick + "', avatar='" + this.avatar + "', user_id=" + this.user_id + ", floor_host=" + this.floor_host + '}';
    }

    public ReplyToCommentBean(String str, String str2, int i2, boolean z2) {
        this.nick = str;
        this.avatar = str2;
        this.user_id = i2;
        this.floor_host = z2;
    }
}
