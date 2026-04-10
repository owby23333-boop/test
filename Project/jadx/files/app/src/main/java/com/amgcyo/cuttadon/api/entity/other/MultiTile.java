package com.amgcyo.cuttadon.api.entity.other;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MultiTile implements Serializable {
    public boolean cateDeatilMore;
    public int category;
    public String desc;
    public boolean isRankIndex;
    public boolean isRecommend;
    public boolean isShudan;
    public boolean isSortBook;
    public int ltype_id;
    public List<MkLtypeListBean> ltype_list;
    public String more;
    public String name;
    public String name_1;
    public int sexInt;
    public String sexStr;
    public int style;
    public int type_id;

    public MultiTile(boolean z2, String str, int i2, int i3, int i4) {
        this.cateDeatilMore = z2;
        this.name = str;
        this.sexInt = i2;
        this.ltype_id = i3;
        this.style = i4;
    }

    public int getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public String getName_1() {
        return this.name_1;
    }

    public int getType_id() {
        return this.type_id;
    }

    public void setCategory(int i2) {
        this.category = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setName_1(String str) {
        this.name_1 = str;
    }

    public void setType_id(int i2) {
        this.type_id = i2;
    }

    @NonNull
    public String toString() {
        return "MultiTile{name='" + this.name + "', id=" + this.type_id + ", category=" + this.category + ", more='" + this.more + "'}";
    }

    public MultiTile() {
    }

    public MultiTile(String str) {
        this.name = str;
    }

    public MultiTile(String str, int i2) {
        this.name = str;
        this.category = i2;
    }

    public MultiTile(String str, int i2, String str2) {
        this.name = str;
        this.category = i2;
        this.more = str2;
    }

    public MultiTile(int i2, String str, String str2, String str3, boolean z2) {
        this.category = i2;
        this.name = str;
        this.more = str2;
        this.isShudan = z2;
        this.sexStr = str3;
        if ("male".equals(str3)) {
            this.sexInt = 1;
            return;
        }
        if ("female".equals(str3)) {
            this.sexInt = 2;
        } else if ("comics".equals(str3)) {
            this.sexInt = 5;
        } else {
            this.sexInt = 1;
        }
    }

    public MultiTile(String str, int i2, boolean z2) {
        this.name = str;
        this.category = i2;
        this.isRecommend = z2;
    }

    public MultiTile(String str, int i2, String str2, String str3) {
        this.name = str;
        this.category = i2;
        this.more = str3;
        this.sexStr = str2;
    }

    public MultiTile(String str, int i2, String str2, String str3, boolean z2) {
        this.name = str;
        this.category = i2;
        this.more = str3;
        this.sexStr = str2;
        this.isRecommend = z2;
    }

    public MultiTile(boolean z2, String str, int i2, String str2, String str3) {
        this.name = str;
        this.category = i2;
        this.more = str3;
        this.sexStr = str2;
        this.isRankIndex = z2;
    }

    public MultiTile(String str, int i2, String str2, String str3, String str4, List<MkLtypeListBean> list, boolean z2) {
        this.name = str;
        if ("male".equals(str2)) {
            this.sexInt = 1;
        } else if ("female".equals(str2)) {
            this.sexInt = 2;
        } else if ("comics".equals(str2)) {
            this.sexInt = 5;
        } else {
            this.sexInt = 0;
        }
        this.category = i2;
        this.more = str3;
        this.sexStr = str2;
        this.desc = str4;
        this.ltype_list = list;
        this.isSortBook = z2;
    }

    public MultiTile(String str, int i2, int i3, String str2) {
        this.name = str;
        this.type_id = i2;
        this.category = i3;
        this.more = str2;
    }
}
