package com.amgcyo.cuttadon.api.entity.fission5;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Fuli5TaskBean implements Serializable {
    private int amount;
    private int amount_type;
    private String button;
    private int button_type;
    private String desc;
    private int read_min;
    private int state;
    private int tid;
    private String title;

    public int getAmount() {
        return this.amount;
    }

    public int getAmount_type() {
        return this.amount_type;
    }

    public String getButton() {
        return this.button;
    }

    public int getButton_type() {
        return this.button_type;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getRead_min() {
        return this.read_min;
    }

    public int getState() {
        return this.state;
    }

    public int getTid() {
        return this.tid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAmount(int i2) {
        this.amount = i2;
    }

    public void setAmount_type(int i2) {
        this.amount_type = i2;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setButton_type(int i2) {
        this.button_type = i2;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setRead_min(int i2) {
        this.read_min = i2;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setTid(int i2) {
        this.tid = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @NonNull
    public String toString() {
        return "Fuli5TaskBean{tid=" + this.tid + ", title='" + this.title + "', desc='" + this.desc + "', amount=" + this.amount + ", amount_type=" + this.amount_type + ", button='" + this.button + "', state=" + this.state + ", read_min=" + this.read_min + '}';
    }
}
