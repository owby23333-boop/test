package com.amgcyo.cuttadon.api.entity.bookcity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BaseMaleFemaleBean implements Serializable {
    private String rank_id;
    private String rank_title;

    public String getRank_id() {
        return this.rank_id;
    }

    public String getRank_title() {
        return this.rank_title;
    }

    public void setRank_id(String str) {
        this.rank_id = str;
    }

    public void setRank_title(String str) {
        this.rank_title = str;
    }
}
