package com.amgcyo.cuttadon.api.entity.bookcity.v7.style;

import com.amgcyo.cuttadon.api.entity.other.MkBook;

/* JADX INFO: loaded from: classes.dex */
public class V7Style2Rank extends MkBook {
    private int id;

    public V7Style2Rank(int i2, int i3, int i4, String str, String str2, String str3, String str4) {
        super(i3, i4, str, str2, str3, str4);
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }
}
