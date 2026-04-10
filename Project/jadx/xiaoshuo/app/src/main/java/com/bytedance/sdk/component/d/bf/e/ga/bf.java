package com.bytedance.sdk.component.d.bf.e.ga;

/* JADX INFO: loaded from: classes.dex */
public enum bf {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int p;

    bf(int i) {
        this.p = i;
    }

    public static bf e(int i) {
        try {
            for (bf bfVar : values()) {
                if (bfVar.p == i) {
                    return bfVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
