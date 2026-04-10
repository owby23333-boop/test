package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes4.dex */
public class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2202a;
    public final byte b;
    public final short c;

    public bq() {
        this("", (byte) 0, (short) 0);
    }

    public bq(String str, byte b, short s) {
        this.f2202a = str;
        this.b = b;
        this.c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f2202a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }

    public boolean a(bq bqVar) {
        return this.b == bqVar.b && this.c == bqVar.c;
    }
}
