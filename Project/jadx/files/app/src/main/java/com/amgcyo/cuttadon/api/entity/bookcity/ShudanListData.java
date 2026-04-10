package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.chad.library.adapter.base.d.b;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShudanListData extends MkBook implements Serializable, b {
    private int category;
    private List<MkBook> data;
    private List<String> images;
    private int list_id;
    private int more;
    private String path;
    private int style;
    private String sub_name;
    private String title;

    public int getCategory() {
        return this.category;
    }

    public List<MkBook> getData() {
        return this.data;
    }

    public List<String> getImages() {
        return this.images;
    }

    public int getList_id() {
        return this.list_id;
    }

    public int getMore() {
        return this.more;
    }

    public String getPath() {
        return this.path;
    }

    public int getStyle() {
        return this.style;
    }

    public String getSub_name() {
        return this.sub_name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCategory(int i2) {
        this.category = i2;
    }

    public void setData(List<MkBook> list) {
        this.data = list;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public void setList_id(int i2) {
        this.list_id = i2;
    }

    public void setMore(int i2) {
        this.more = i2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setStyle(int i2) {
        this.style = i2;
    }

    public void setSub_name(String str) {
        this.sub_name = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
