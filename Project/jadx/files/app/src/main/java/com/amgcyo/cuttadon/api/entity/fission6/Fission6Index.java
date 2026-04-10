package com.amgcyo.cuttadon.api.entity.fission6;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Fission6Index implements Serializable {
    private String avatar;
    private String coder_number;
    private int fission_count;
    private String fission_day;
    private int master_user_id;
    private String remark;
    private int user_id;

    public Fission6Index(int i2) {
        this.user_id = i2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getCoder_number() {
        return this.coder_number;
    }

    public int getFission_count() {
        return this.fission_count;
    }

    public String getFission_day() {
        return this.fission_day;
    }

    public int getMaster_user_id() {
        return this.master_user_id;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setCoder_number(String str) {
        this.coder_number = str;
    }

    public void setFission_count(int i2) {
        this.fission_count = i2;
    }

    public void setFission_day(String str) {
        this.fission_day = str;
    }

    public void setMaster_user_id(int i2) {
        this.master_user_id = i2;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }

    public Fission6Index() {
    }
}
