package com.dangdang.reader.dread.data;

/* JADX INFO: loaded from: classes10.dex */
public class BookNotePublicDetail extends BookNotePublic {
    private String noteText;
    private String noteTime;
    private String user;
    private String userHeadUrl;
    private String userId;

    public String getNoteText() {
        return this.noteText;
    }

    public String getNoteTime() {
        return this.noteTime;
    }

    public String getUser() {
        return this.user;
    }

    public String getUserHeadUrl() {
        return this.userHeadUrl;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setNoteText(String str) {
        this.noteText = str;
    }

    public void setNoteTime(String str) {
        this.noteTime = str;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public void setUserHeadUrl(String str) {
        this.userHeadUrl = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
