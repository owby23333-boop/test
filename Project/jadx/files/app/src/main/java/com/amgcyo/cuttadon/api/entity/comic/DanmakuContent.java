package com.amgcyo.cuttadon.api.entity.comic;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class DanmakuContent implements Serializable {
    private int color;
    private String content;
    private int user_id;

    public DanmakuContent() {
    }

    public int getColor() {
        return this.color;
    }

    public String getContent() {
        return this.content;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setColor(int i2) {
        this.color = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }

    @NonNull
    public String toString() {
        return "DanmakuContent{content='" + this.content + "', user_id=" + this.user_id + ", color=" + this.color + '}';
    }

    public DanmakuContent(String str, int i2, int i3) {
        this.content = str;
        this.user_id = i2;
        this.color = i3;
    }
}
