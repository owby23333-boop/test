package com.amgcyo.cuttadon.api.entity.bookcity.v4;

import com.amgcyo.cuttadon.api.entity.other.MkBook;

/* JADX INFO: loaded from: classes.dex */
public class ItemsGrid4Book extends MkBook {
    private int id;

    public ItemsGrid4Book(int i2, int i3, String str, String str2, int i4) {
        super(i3, str, str2, i4);
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public ItemsGrid4Book(int i2, int i3, String str, String str2, String str3) {
        super(i2, i3, str, str2, str3);
    }
}
