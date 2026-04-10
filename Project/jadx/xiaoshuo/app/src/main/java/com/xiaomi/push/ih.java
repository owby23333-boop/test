package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public enum ih {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f553a;

    ih(int i) {
        this.f553a = i;
    }

    public int a() {
        return this.f553a;
    }

    public static ih a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
