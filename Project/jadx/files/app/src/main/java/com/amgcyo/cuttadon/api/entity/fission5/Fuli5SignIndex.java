package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Fuli5SignIndex implements Serializable {
    private int balance_gold;
    private String balance_money;
    private String earnings;
    private int sigin_log_id;
    private List<Fuli5SignInDataBean> signin_data;
    private String signin_day;
    private int signin_state;
    private String signin_tips;
    private String signin_tips2;
    private int signin_total;
    private int video_amount;

    public int getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public int getSigin_log_id() {
        return this.sigin_log_id;
    }

    public List<Fuli5SignInDataBean> getSignin_data() {
        return this.signin_data;
    }

    public String getSignin_day() {
        return this.signin_day;
    }

    public int getSignin_state() {
        return this.signin_state;
    }

    public String getSignin_tips() {
        return this.signin_tips;
    }

    public String getSignin_tips2() {
        return this.signin_tips2;
    }

    public int getSignin_total() {
        return this.signin_total;
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

    public void setEarnings(String str) {
        this.earnings = str;
    }

    public void setSigin_log_id(int i2) {
        this.sigin_log_id = i2;
    }

    public void setSignin_data(List<Fuli5SignInDataBean> list) {
        this.signin_data = list;
    }

    public void setSignin_day(String str) {
        this.signin_day = str;
    }

    public void setSignin_state(int i2) {
        this.signin_state = i2;
    }

    public void setSignin_tips(String str) {
        this.signin_tips = str;
    }

    public void setSignin_tips2(String str) {
        this.signin_tips2 = str;
    }

    public void setSignin_total(int i2) {
        this.signin_total = i2;
    }

    public void setVideo_amount(int i2) {
        this.video_amount = i2;
    }
}
