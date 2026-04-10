package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValueMetaData.java */
/* JADX INFO: loaded from: classes4.dex */
public class bj implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2192a;
    public final byte b;
    private final String c;
    private final boolean d;

    public bj(byte b, boolean z) {
        this.b = b;
        this.f2192a = false;
        this.c = null;
        this.d = z;
    }

    public bj(byte b) {
        this(b, false);
    }

    public bj(byte b, String str) {
        this.b = b;
        this.f2192a = true;
        this.c = str;
        this.d = false;
    }

    public boolean a() {
        return this.f2192a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.d;
    }
}
