package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public enum ii {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f555a;

    ii(int i) {
        this.f555a = i;
    }

    public static ii a(int i) {
        if (i == 1) {
            return INT;
        }
        if (i == 2) {
            return LONG;
        }
        if (i == 3) {
            return STRING;
        }
        if (i != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
