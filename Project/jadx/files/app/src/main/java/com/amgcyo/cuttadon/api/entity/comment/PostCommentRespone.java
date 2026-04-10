package com.amgcyo.cuttadon.api.entity.comment;

/* JADX INFO: loaded from: classes.dex */
public class PostCommentRespone extends BaseCommentBean {
    private int book_id;
    private String book_name;
    private String comment_avatar;
    private String comment_content;
    private String comment_created_at;
    private boolean comment_floor_host;
    private String comment_nick;
    private int comment_reply_id;
    private int comment_user_id;
    private int fav_num;
    private int fav_status;
    private boolean floor_host;
    private int pid;
    private ReplyToCommentBean reply_to_comment;
    private int status;

    public int getBook_id() {
        return this.book_id;
    }

    public String getBook_name() {
        return this.book_name;
    }

    public String getComment_avatar() {
        return this.comment_avatar;
    }

    public String getComment_content() {
        return this.comment_content;
    }

    public String getComment_created_at() {
        return this.comment_created_at;
    }

    public String getComment_nick() {
        return this.comment_nick;
    }

    public int getComment_reply_id() {
        return this.comment_reply_id;
    }

    public int getComment_user_id() {
        return this.comment_user_id;
    }

    public int getFav_num() {
        return this.fav_num;
    }

    public int getFav_status() {
        return this.fav_status;
    }

    public int getPid() {
        return this.pid;
    }

    public ReplyToCommentBean getReply_to_comment() {
        return this.reply_to_comment;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isComment_floor_host() {
        return this.comment_floor_host;
    }

    public boolean isFloor_host() {
        return this.floor_host;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setBook_name(String str) {
        this.book_name = str;
    }

    public void setComment_avatar(String str) {
        this.comment_avatar = str;
    }

    public void setComment_content(String str) {
        this.comment_content = str;
    }

    public void setComment_created_at(String str) {
        this.comment_created_at = str;
    }

    public void setComment_floor_host(boolean z2) {
        this.comment_floor_host = z2;
    }

    public void setComment_nick(String str) {
        this.comment_nick = str;
    }

    public void setComment_reply_id(int i2) {
        this.comment_reply_id = i2;
    }

    public void setComment_user_id(int i2) {
        this.comment_user_id = i2;
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

    public void setPid(int i2) {
        this.pid = i2;
    }

    public void setReply_to_comment(ReplyToCommentBean replyToCommentBean) {
        this.reply_to_comment = replyToCommentBean;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "PostCommentRespone{comment_reply_id=" + this.comment_reply_id + ", book_id=" + this.book_id + ", book_name='" + this.book_name + "', floor_host=" + this.floor_host + ", pid=" + this.pid + ", status=" + this.status + ", fav_num=" + this.fav_num + ", fav_status=" + this.fav_status + ", reply_to_comment=" + this.reply_to_comment + ", comment_content='" + this.comment_content + "', comment_user_id=" + this.comment_user_id + ", comment_created_at='" + this.comment_created_at + "', comment_nick='" + this.comment_nick + "', comment_avatar='" + this.comment_avatar + "', comment_floor_host=" + this.comment_floor_host + '}';
    }
}
