package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ComicTags implements Serializable {
    private String tags_desc;
    private int tags_id;
    private String tags_name;

    public String getTags_desc() {
        return this.tags_desc;
    }

    public int getTags_id() {
        return this.tags_id;
    }

    public String getTags_name() {
        return this.tags_name;
    }

    public void setTags_desc(String str) {
        this.tags_desc = str;
    }

    public void setTags_id(int i2) {
        this.tags_id = i2;
    }

    public void setTags_name(String str) {
        this.tags_name = str;
    }
}
