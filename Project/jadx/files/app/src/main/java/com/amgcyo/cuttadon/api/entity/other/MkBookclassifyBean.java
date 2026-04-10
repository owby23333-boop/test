package com.amgcyo.cuttadon.api.entity.other;

import com.chad.library.adapter.base.d.b;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkBookclassifyBean implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    private int itemType;
    private String ltype_desc;
    private int ltype_id;
    private String ltype_image;
    private List<MkLtypeListBean> ltype_list;
    private String ltype_name;

    public MkBookclassifyBean(int i2) {
        this.itemType = i2;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getLtype_desc() {
        return this.ltype_desc;
    }

    public int getLtype_id() {
        return this.ltype_id;
    }

    public String getLtype_image() {
        return this.ltype_image;
    }

    public List<MkLtypeListBean> getLtype_list() {
        return this.ltype_list;
    }

    public String getLtype_name() {
        return this.ltype_name;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setLtype_desc(String str) {
        this.ltype_desc = str;
    }

    public void setLtype_id(int i2) {
        this.ltype_id = i2;
    }

    public void setLtype_image(String str) {
        this.ltype_image = str;
    }

    public void setLtype_list(List<MkLtypeListBean> list) {
        this.ltype_list = list;
    }

    public void setLtype_name(String str) {
        this.ltype_name = str;
    }
}
