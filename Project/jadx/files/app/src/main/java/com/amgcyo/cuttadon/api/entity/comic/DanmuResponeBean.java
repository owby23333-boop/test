package com.amgcyo.cuttadon.api.entity.comic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DanmuResponeBean implements Serializable {
    private int danmuCount;
    private HashMap<String, List<DanmakuContent>> hashMap;

    public int getDanmuCount() {
        return this.danmuCount;
    }

    public HashMap<String, List<DanmakuContent>> getHashMap() {
        return this.hashMap;
    }

    public void setDanmuCount(int i2) {
        this.danmuCount = i2;
    }

    public void setHashMap(HashMap<String, List<DanmakuContent>> map) {
        this.hashMap = map;
    }
}
