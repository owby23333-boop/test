package com.duokan.dkcategory.data.secondary;

/* JADX INFO: loaded from: classes13.dex */
public enum SerializeStatus {
    ALL(-1, "全部"),
    END(1, "完结"),
    SERIALIZE(0, "连载");

    private final int key;
    private final String label;

    SerializeStatus(int key, String label) {
        this.key = key;
        this.label = label;
    }

    public int getKey() {
        return this.key;
    }

    public String getLabel() {
        return this.label;
    }
}
