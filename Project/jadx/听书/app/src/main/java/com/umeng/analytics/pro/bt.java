package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: classes4.dex */
public final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2205a;
    public final byte b;
    public final int c;

    public bt() {
        this("", (byte) 0, 0);
    }

    public bt(String str, byte b, int i) {
        this.f2205a = str;
        this.b = b;
        this.c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.f2205a + "' type: " + ((int) this.b) + " seqid:" + this.c + ">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof bt) {
            return a((bt) obj);
        }
        return false;
    }

    public boolean a(bt btVar) {
        return this.f2205a.equals(btVar.f2205a) && this.b == btVar.b && this.c == btVar.c;
    }
}
