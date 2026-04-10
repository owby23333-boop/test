package com.yuewen.openapi.entity;

/* JADX INFO: loaded from: classes8.dex */
public class ChapterContent {
    public String content;
    public int isTaked;

    public String getContent() {
        return this.content;
    }

    public int getIsTaked() {
        return this.isTaked;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsTaked(int i) {
        this.isTaked = i;
    }

    public String toString() {
        return "ChapterContent{content='" + this.content + "', isTaked=" + this.isTaked + '}';
    }
}
