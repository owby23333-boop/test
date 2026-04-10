package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValueMetaData.java */
/* JADX INFO: loaded from: classes3.dex */
public class bi implements Serializable {
    private final boolean a;
    public final byte b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19541d;

    public bi(byte b, boolean z2) {
        this.b = b;
        this.a = false;
        this.f19540c = null;
        this.f19541d = z2;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.f19540c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.f19541d;
    }

    public bi(byte b) {
        this(b, false);
    }

    public bi(byte b, String str) {
        this.b = b;
        this.a = true;
        this.f19540c = str;
        this.f19541d = false;
    }
}
