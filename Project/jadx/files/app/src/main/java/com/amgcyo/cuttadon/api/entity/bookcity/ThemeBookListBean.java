package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.other.BaseLimit;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThemeBookListBean extends BaseLimit {
    private List<ShudanListData> lists;

    public List<ShudanListData> getLists() {
        return this.lists;
    }

    public void setLists(List<ShudanListData> list) {
        this.lists = list;
    }
}
