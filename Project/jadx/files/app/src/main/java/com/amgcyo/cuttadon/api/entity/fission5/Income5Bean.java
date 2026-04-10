package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Income5Bean implements Serializable {
    private String balance_gold;
    private String balance_money;
    private String earnings;
    private List<EarningsList> lists;

    public String getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public List<EarningsList> getLists() {
        return this.lists;
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

    public void setLists(List<EarningsList> list) {
        this.lists = list;
    }
}
