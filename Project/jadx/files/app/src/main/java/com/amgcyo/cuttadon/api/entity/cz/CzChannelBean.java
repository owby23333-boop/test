package com.amgcyo.cuttadon.api.entity.cz;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CzChannelBean implements Serializable {
    private String channel_id;
    private String pay_id;
    private String pay_img;
    private String pay_name;
    private int pos;
    private boolean selected;

    public String getChannel_id() {
        return this.channel_id;
    }

    public String getPay_id() {
        return this.pay_id;
    }

    public String getPay_img() {
        return this.pay_img;
    }

    public String getPay_name() {
        return this.pay_name;
    }

    public int getPos() {
        return this.pos;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setChannel_id(String str) {
        this.channel_id = str;
    }

    public void setPay_id(String str) {
        this.pay_id = str;
    }

    public void setPay_img(String str) {
        this.pay_img = str;
    }

    public void setPay_name(String str) {
        this.pay_name = str;
    }

    public void setPos(int i2) {
        this.pos = i2;
    }

    public void setSelected(boolean z2) {
        this.selected = z2;
    }
}
