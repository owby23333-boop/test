package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    private final int uy;

    a(int i) {
        this.uy = i;
    }

    public int z() {
        return this.uy;
    }
}
