package com.amgcyo.cuttadon.api.entity.other;

import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CentertCommentBean implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private String avatar;
    private int book_id;
    private String book_name;
    private String comment_content;
    private int comment_id;
    private String comment_reply_content;
    private int comment_reply_id;
    private String created_at;
    private int form;
    private int itemType;
    private String nick_name;
    private int user_id;

    public String getAvatar() {
        return this.avatar;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public String getBook_name() {
        return this.book_name;
    }

    public String getComment_content() {
        return this.comment_content;
    }

    public int getComment_id() {
        return this.comment_id;
    }

    public String getComment_reply_content() {
        return this.comment_reply_content;
    }

    public int getComment_reply_id() {
        return this.comment_reply_id;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public int getForm() {
        return this.form;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getNick_name() {
        return this.nick_name;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setBook_name(String str) {
        this.book_name = str;
    }

    public void setComment_content(String str) {
        this.comment_content = str;
    }

    public void setComment_id(int i2) {
        this.comment_id = i2;
    }

    public void setComment_reply_content(String str) {
        this.comment_reply_content = str;
    }

    public void setComment_reply_id(int i2) {
        this.comment_reply_id = i2;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setNick_name(String str) {
        this.nick_name = str;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }
}
