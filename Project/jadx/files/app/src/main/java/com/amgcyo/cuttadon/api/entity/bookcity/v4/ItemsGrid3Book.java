package com.amgcyo.cuttadon.api.entity.bookcity.v4;

import com.amgcyo.cuttadon.api.entity.other.MkBook;

/* JADX INFO: loaded from: classes.dex */
public class ItemsGrid3Book extends MkBook {
    private int id;

    public ItemsGrid3Book(int i2, int i3, String str, String str2, int i4) {
        super(i3, str, str2, i4);
        this.id = i2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public ItemsGrid3Book(int i2, int i3, int i4, String str, String str2, String str3) {
        super(i3, i4, str, str2, str3);
        this.id = i2;
    }
}
