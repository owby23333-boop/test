package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes3.dex */
public class bp {
    public final String a;
    public final byte b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f19582c;

    public bp() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bp bpVar) {
        return this.b == bpVar.b && this.f19582c == bpVar.f19582c;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.f19582c) + ">";
    }

    public bp(String str, byte b, short s2) {
        this.a = str;
        this.b = b;
        this.f19582c = s2;
    }
}
