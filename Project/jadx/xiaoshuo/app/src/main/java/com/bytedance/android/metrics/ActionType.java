package com.bytedance.android.metrics;

/* JADX INFO: loaded from: classes.dex */
public enum ActionType {
    CLICK,
    DRAW;

    public String lowerName() {
        return name().toLowerCase();
    }
}
