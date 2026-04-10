package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ZymkChapter implements Serializable {
    private boolean cacheExists;
    private int count;
    private transient int danmuCount;
    private int id;
    private int index;
    private boolean is_content;
    private String name;
    private String path;
    private transient boolean requestDanmu;
    private boolean reward;
    private long updated_at;
    private String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ZymkChapter.class != obj.getClass()) {
            return false;
        }
        ZymkChapter zymkChapter = (ZymkChapter) obj;
        if (zymkChapter.getPath() == null) {
            return false;
        }
        String str = this.path;
        if (str == null || "".equals(str)) {
            String str2 = zymkChapter.path;
            if (str2 != null && !"".equals(str2)) {
                return false;
            }
        } else if (!this.path.equals(zymkChapter.path)) {
            return false;
        }
        return true;
    }

    public int getCount() {
        return this.count;
    }

    public int getDanmuCount() {
        return this.danmuCount;
    }

    public int getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
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

    public boolean isCacheExists() {
        return this.cacheExists;
    }

    public boolean isIs_content() {
        return this.is_content;
    }

    public boolean isRequestDanmu() {
        return this.requestDanmu;
    }

    public boolean isReward() {
        return this.reward;
    }

    public void setCacheExists(boolean z2) {
        this.cacheExists = z2;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public void setDanmuCount(int i2) {
        this.danmuCount = i2;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setIs_content(boolean z2) {
        this.is_content = z2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setRequestDanmu(boolean z2) {
        this.requestDanmu = z2;
    }

    public void setReward(boolean z2) {
        this.reward = z2;
    }

    public void setUpdated_at(long j2) {
        this.updated_at = j2;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
