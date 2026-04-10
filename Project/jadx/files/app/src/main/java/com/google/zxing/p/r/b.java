package com.google.zxing.p.r;

import com.umeng.message.proguard.ad;

/* JADX INFO: compiled from: DataCharacter.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private final int a;
    private final int b;

    public b(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b;
    }

    public final int hashCode() {
        return this.a ^ this.b;
    }

    public final String toString() {
        return this.a + ad.f20405r + this.b + ')';
    }
}
