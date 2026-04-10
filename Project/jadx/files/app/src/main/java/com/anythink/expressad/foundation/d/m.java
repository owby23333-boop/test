package com.anythink.expressad.foundation.d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Serializable {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10318c;

    private m(String str, String str2, int i2) {
        this.b = str;
        this.a = str2;
        this.f10318c = i2;
    }

    private String a() {
        return this.a;
    }

    private String b() {
        return this.b;
    }

    private void a(String str) {
        this.a = str;
    }

    private void b(String str) {
        this.b = str;
    }
}
