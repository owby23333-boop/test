package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TxStepBean implements Serializable {
    private String arrive_account;
    private String arrive_datetime;
    private String arrive_money;
    private int balance_gold;
    private String balance_money;
    private String earnings;
    private String invitation_button;
    private List<ScheduleBean> schedule;
    private int state;

    public String getArrive_account() {
        return this.arrive_account;
    }

    public String getArrive_datetime() {
        return this.arrive_datetime;
    }

    public String getArrive_money() {
        return this.arrive_money;
    }

    public int getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public String getInvitation_button() {
        return this.invitation_button;
    }

    public List<ScheduleBean> getSchedule() {
        return this.schedule;
    }

    public int getState() {
        return this.state;
    }

    public void setArrive_account(String str) {
        this.arrive_account = str;
    }

    public void setArrive_datetime(String str) {
        this.arrive_datetime = str;
    }

    public void setArrive_money(String str) {
        this.arrive_money = str;
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

    public void setInvitation_button(String str) {
        this.invitation_button = str;
    }

    public void setSchedule(List<ScheduleBean> list) {
        this.schedule = list;
    }

    public void setState(int i2) {
        this.state = i2;
    }
}
