package com.amgcyo.cuttadon.api.entity.bookcity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BookStoreMaleBean implements Serializable {
    private List<RankBean> rank;

    public List<RankBean> getRank() {
        return this.rank;
    }

    public void setRank(List<RankBean> list) {
        this.rank = list;
    }
}
