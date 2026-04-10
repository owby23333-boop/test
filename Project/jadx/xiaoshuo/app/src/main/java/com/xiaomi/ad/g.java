package com.xiaomi.ad;

/* JADX INFO: loaded from: classes5.dex */
public enum g {
    UNKNOWN(-1),
    NETWORK(1),
    TIMEOUT(2),
    INVALID_RESPONSE(3),
    SERVER(4),
    NULL_RESPONSE(5),
    EXCEPTION(6),
    NO_CONTENT(101);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7262a;

    g(int i) {
        this.f7262a = i;
    }

    public int a() {
        return this.f7262a;
    }

    public static g a(int i) {
        for (g gVar : values()) {
            if (i == gVar.f7262a) {
                return gVar;
            }
        }
        return UNKNOWN;
    }
}
