package com.amgcyo.cuttadon.api.entity.other;

import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class LocalMp3Bean implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private int itemType;
    private String name;
    private String path;

    public LocalMp3Bean() {
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public LocalMp3Bean(String str, String str2) {
        this.name = str;
        this.path = str2;
    }
}
