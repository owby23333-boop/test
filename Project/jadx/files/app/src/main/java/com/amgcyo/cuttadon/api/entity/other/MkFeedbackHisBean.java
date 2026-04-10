package com.amgcyo.cuttadon.api.entity.other;

import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkFeedbackHisBean implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private String accepted_at;
    private String contact_info;
    private String content;
    private String created_at;
    private int itemType;
    private String reply;
    private int status;

    public MkFeedbackHisBean(int i2) {
        this.itemType = i2;
    }

    public String getAccepted_at() {
        return this.accepted_at;
    }

    public String getContact_info() {
        return this.contact_info;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getReply() {
        return this.reply;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAccepted_at(String str) {
        this.accepted_at = str;
    }

    public void setContact_info(String str) {
        this.contact_info = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setReply(String str) {
        this.reply = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
