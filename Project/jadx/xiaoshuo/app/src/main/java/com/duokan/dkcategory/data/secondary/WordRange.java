package com.duokan.dkcategory.data.secondary;

import com.duokan.core.app.AppWrapper;
import com.yuewen.gs2;

/* JADX INFO: loaded from: classes13.dex */
public enum WordRange {
    ALL("", AppWrapper.v().getResources().getString(gs2.r.N4)),
    WITHIN_100M("0,1000000", "100万字以内"),
    BETWEEN_100_300M("1000000,3000000", "100-300万字"),
    OVER_300M("3000000", "300万字以上");

    private final String key;
    private final String label;

    WordRange(String key, String label) {
        this.key = key;
        this.label = label;
    }

    public String getKey() {
        return this.key;
    }

    public String getLabel() {
        return this.label;
    }
}
