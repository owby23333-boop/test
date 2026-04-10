package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WithDrawBean implements Serializable {
    private List<ApBean> ap;
    private String balance_gold;
    private String balance_money;
    private String earnings;
    private String notice;
    private List<String> notices;
    private List<WpBean> wp;

    public List<ApBean> getAp() {
        return this.ap;
    }

    public String getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public String getNotice() {
        return this.notice;
    }

    public List<String> getNotices() {
        return this.notices;
    }

    public List<WpBean> getWp() {
        return this.wp;
    }

    public void setAp(List<ApBean> list) {
        this.ap = list;
    }

    public void setBalance_gold(String str) {
        this.balance_gold = str;
    }

    public void setBalance_money(String str) {
        this.balance_money = str;
    }

    public void setEarnings(String str) {
        this.earnings = str;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setNotices(List<String> list) {
        this.notices = list;
    }

    public void setWp(List<WpBean> list) {
        this.wp = list;
    }
}
