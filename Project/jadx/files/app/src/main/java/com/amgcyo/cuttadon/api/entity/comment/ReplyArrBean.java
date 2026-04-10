package com.amgcyo.cuttadon.api.entity.comment;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ReplyArrBean implements Serializable {
    private String avatar;
    private int book_id;
    private int comment_id;
    private int comment_reply_id;
    private String content;
    private String created_at;
    private int fav_num;
    private int fav_status;
    private boolean floor_host;
    private String nick;
    private ReplyToCommentBean reply_to_comment;
    private int status;
    private int user_id;

    public ReplyArrBean() {
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public int getComment_id() {
        return this.comment_id;
    }

    public int getComment_reply_id() {
        return this.comment_reply_id;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public int getFav_num() {
        return this.fav_num;
    }

    public int getFav_status() {
        return this.fav_status;
    }

    public String getNick() {
        return this.nick;
    }

    public ReplyToCommentBean getReply_to_comment() {
        return this.reply_to_comment;
    }

    public int getStatus() {
        return this.status;
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

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setComment_id(int i2) {
        this.comment_id = i2;
    }

    public void setComment_reply_id(int i2) {
        this.comment_reply_id = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setFav_num(int i2) {
        this.fav_num = i2;
    }

    public void setFav_status(int i2) {
        this.fav_status = i2;
    }

    public void setFloor_host(boolean z2) {
        this.floor_host = z2;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setReply_to_comment(ReplyToCommentBean replyToCommentBean) {
        this.reply_to_comment = replyToCommentBean;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }

    public String toString() {
        return "ReplyArrBean{nick='" + this.nick + "', avatar='" + this.avatar + "', book_id=" + this.book_id + ", content='" + this.content + "', user_id=" + this.user_id + ", comment_id=" + this.comment_id + ", floor_host=" + this.floor_host + ", fav_status=" + this.fav_status + ", created_at=" + this.created_at + ", comment_reply_id=" + this.comment_reply_id + ", reply_to_comment=" + this.reply_to_comment + '}';
    }

    public ReplyArrBean(String str, String str2, int i2, String str3, int i3, int i4, boolean z2, int i5, ReplyToCommentBean replyToCommentBean, int i6, String str4, int i7, int i8) {
        this.nick = str;
        this.avatar = str2;
        this.book_id = i2;
        this.content = str3;
        this.user_id = i3;
        this.comment_id = i4;
        this.floor_host = z2;
        this.comment_reply_id = i5;
        this.reply_to_comment = replyToCommentBean;
        this.fav_num = i6;
        this.created_at = str4;
        this.fav_status = i7;
        this.status = i8;
    }
}
