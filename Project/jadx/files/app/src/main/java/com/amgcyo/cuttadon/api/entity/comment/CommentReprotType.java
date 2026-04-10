package com.amgcyo.cuttadon.api.entity.comment;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CommentReprotType implements Serializable {
    private int comment_id;
    private int comment_reply_id;
    private String report_content;
    private int report_id;

    public CommentReprotType() {
    }

    public int getComment_id() {
        return this.comment_id;
    }

    public int getComment_reply_id() {
        return this.comment_reply_id;
    }

    public String getReport_content() {
        return this.report_content;
    }

    public int getReport_id() {
        return this.report_id;
    }

    public void setComment_id(int i2) {
        this.comment_id = i2;
    }

    public void setComment_reply_id(int i2) {
        this.comment_reply_id = i2;
    }

    public void setReport_content(String str) {
        this.report_content = str;
    }

    public void setReport_id(int i2) {
        this.report_id = i2;
    }

    public CommentReprotType(int i2, String str) {
        this.report_id = i2;
        this.report_content = str;
    }
}
