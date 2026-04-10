package com.amgcyo.cuttadon.api.entity.cz;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CzPayDataBean implements Serializable {
    private int amount;
    private int day;
    private int id;
    private String money;
    private String name;
    private int recommend;
    private String remark;
    private boolean selected;

    public int getAmount() {
        return this.amount;
    }

    public int getDay() {
        return this.day;
    }

    public int getId() {
        return this.id;
    }

    public String getMoney() {
        return this.money;
    }

    public String getName() {
        return this.name;
    }

    public int getRecommend() {
        return this.recommend;
    }

    public String getRemark() {
        return this.remark;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setAmount(int i2) {
        this.amount = i2;
    }

    public void setDay(int i2) {
        this.day = i2;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setMoney(String str) {
        this.money = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRecommend(int i2) {
        this.recommend = i2;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSelected(boolean z2) {
        this.selected = z2;
    }
}
