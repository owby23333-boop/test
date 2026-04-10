package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class OpenBoxBean implements Serializable {
    private int balance_gold;
    private String balance_money;
    private int log_amount;
    private int log_id;
    private String log_tips;
    private int log_type;
    private String treasure_chest_datetime;
    private int video_amount;

    public int getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public int getLog_amount() {
        return this.log_amount;
    }

    public int getLog_id() {
        return this.log_id;
    }

    public String getLog_tips() {
        return this.log_tips;
    }

    public int getLog_type() {
        return this.log_type;
    }

    public String getTreasure_chest_datetime() {
        return this.treasure_chest_datetime;
    }

    public int getVideo_amount() {
        return this.video_amount;
    }

    public void setBalance_gold(int i2) {
        this.balance_gold = i2;
    }

    public void setBalance_money(String str) {
        this.balance_money = str;
    }

    public void setLog_amount(int i2) {
        this.log_amount = i2;
    }

    public void setLog_id(int i2) {
        this.log_id = i2;
    }

    public void setLog_tips(String str) {
        this.log_tips = str;
    }

    public void setLog_type(int i2) {
        this.log_type = i2;
    }

    public void setTreasure_chest_datetime(String str) {
        this.treasure_chest_datetime = str;
    }

    public void setVideo_amount(int i2) {
        this.video_amount = i2;
    }
}
