package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bs {
    public final String a;
    public final byte b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19584c;

    public bs() {
        this("", (byte) 0, 0);
    }

    public boolean a(bs bsVar) {
        return this.a.equals(bsVar.a) && this.b == bsVar.b && this.f19584c == bsVar.f19584c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bs) {
            return a((bs) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.f19584c + ">";
    }

    public bs(String str, byte b, int i2) {
        this.a = str;
        this.b = b;
        this.f19584c = i2;
    }
}
