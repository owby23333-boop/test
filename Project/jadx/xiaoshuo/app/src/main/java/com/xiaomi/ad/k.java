package com.xiaomi.ad;

import android.util.Pair;

/* JADX INFO: loaded from: classes5.dex */
public class k extends Pair<String, String> {
    public k(String str, String str2) {
        super(str, str2);
        if (str == null) {
            throw new IllegalArgumentException("key may not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("value may not be null");
        }
    }

    public String a() {
        return (String) ((Pair) this).first;
    }

    public String b() {
        return (String) ((Pair) this).second;
    }
}
