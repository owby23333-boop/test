package com.amgcyo.cuttadon.api.entity.other;

import com.chad.library.adapter.base.d.b;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkAreaCodeBean implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private int itemType;
    private int len;
    private String name;
    private String regexp_literal;
    private String short_name;
    private String tel;
    private String word;

    public MkAreaCodeBean(String str, String str2, String str3, String str4, int i2) {
        this.regexp_literal = str;
        this.short_name = str2;
        this.name = str3;
        this.tel = str4;
        this.len = i2;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public int getLen() {
        return this.len;
    }

    public String getName() {
        return this.name;
    }

    public String getRegexp_literal() {
        return this.regexp_literal;
    }

    public String getShort_name() {
        return this.short_name;
    }

    public String getTel() {
        return this.tel;
    }

    public String getWord() {
        return this.word;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setLen(int i2) {
        this.len = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRegexp_literal(String str) {
        this.regexp_literal = str;
    }

    public void setShort_name(String str) {
        this.short_name = str;
    }

    public void setTel(String str) {
        this.tel = str;
    }

    public void setWord(String str) {
        this.word = str;
    }

    public MkAreaCodeBean() {
    }
}
