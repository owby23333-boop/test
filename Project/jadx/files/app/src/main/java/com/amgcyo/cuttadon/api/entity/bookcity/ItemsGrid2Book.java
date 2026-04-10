package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.other.MkBook;

/* JADX INFO: loaded from: classes.dex */
public class ItemsGrid2Book extends MkBook {
    private int id;
    private int rank_color;

    public ItemsGrid2Book(int i2, int i3, int i4, String str, String str2, String str3, int i5) {
        super(i3, i4, str, str2, str3);
        this.id = i2;
        this.rank_color = i5;
    }

    public int getId() {
        return this.id;
    }

    public int getRank_color() {
        return this.rank_color;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setRank_color(int i2) {
        this.rank_color = i2;
    }
}
