package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ComicSourceBean implements Serializable {
    private boolean enable;
    private String sourceId;
    private String title;

    public String getSourceId() {
        return this.sourceId;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z2) {
        this.enable = z2;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "ComicSourceBean{enable=" + this.enable + ", title='" + this.title + "', sourceId='" + this.sourceId + "'}";
    }
}
