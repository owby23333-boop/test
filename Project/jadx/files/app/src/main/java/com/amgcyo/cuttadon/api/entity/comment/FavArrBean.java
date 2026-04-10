package com.amgcyo.cuttadon.api.entity.comment;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FavArrBean implements Serializable {
    private String avatar;
    private String nick;
    private int user_id;

    public FavArrBean(String str, String str2, int i2) {
        this.nick = str;
        this.avatar = str2;
        this.user_id = i2;
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

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }

    public String toString() {
        return "FavArrBean{nick='" + this.nick + "', avatar='" + this.avatar + "', user_id=" + this.user_id + '}';
    }

    public FavArrBean() {
    }
}
