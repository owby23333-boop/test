package com.amgcyo.cuttadon.api.entity.other;

import android.text.TextUtils;
import java.io.File;
import java.io.Serializable;
import me.jessyan.art.b.c;

/* JADX INFO: loaded from: classes.dex */
public class MkCatalog implements Serializable {
    private boolean cacheExists;
    private int catalogId;
    private boolean is_content;
    private String name;
    private boolean onErrorReturn;
    private String path;
    private long updated_at;
    private String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MkCatalog.class != obj.getClass()) {
            return false;
        }
        MkCatalog mkCatalog = (MkCatalog) obj;
        if (mkCatalog.getPath() == null) {
            return false;
        }
        String str = this.path;
        if (str != null && !"".equals(str)) {
            return this.path.equals(mkCatalog.path);
        }
        String str2 = mkCatalog.path;
        return str2 == null || "".equals(str2);
    }

    public int getCatalogId() {
        return this.catalogId;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? this.name : c.a().a(this.name);
    }

    public String getPath() {
        return this.path;
    }

    public long getUpdated_at() {
        return this.updated_at;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.path) && new File(this.path).exists();
    }

    public boolean isCacheExists() {
        return this.cacheExists;
    }

    public boolean isIs_content() {
        return this.is_content;
    }

    public boolean isOnErrorReturn() {
        return this.onErrorReturn;
    }

    public void setCacheExists(boolean z2) {
        this.cacheExists = z2;
    }

    public void setCatalogId(int i2) {
        this.catalogId = i2;
    }

    public void setIs_content(boolean z2) {
        this.is_content = z2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnErrorReturn(boolean z2) {
        this.onErrorReturn = z2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setUpdated_at(long j2) {
        this.updated_at = j2;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
