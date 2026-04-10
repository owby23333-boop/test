package com.bytedance.sdk.component.dl.g.z.gc;

/* JADX INFO: loaded from: classes2.dex */
public enum g {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int e;

    g(int i) {
        this.e = i;
    }

    public static g z(int i) {
        try {
            for (g gVar : values()) {
                if (gVar.e == i) {
                    return gVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
