package com.amgcyo.cuttadon.api.entity.other;

import android.text.TextUtils;
import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BgmMp3 implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private String authorName;
    private String createTime;
    private String desc;
    private int itemType;
    private String name;

    public String getAuthorName() {
        return this.authorName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDesc() {
        return !TextUtils.isEmpty(this.desc) ? this.desc : "暂无描述";
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getName() {
        return this.name;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }
}
