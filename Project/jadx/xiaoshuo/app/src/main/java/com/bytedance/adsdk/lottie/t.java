package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class t<V> {
    private final Throwable bf;
    private final V e;

    public t(V v) {
        this.e = v;
        this.bf = null;
    }

    public Throwable bf() {
        return this.bf;
    }

    public V e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (e() != null && e().equals(tVar.e())) {
            return true;
        }
        if (bf() == null || tVar.bf() == null) {
            return false;
        }
        return bf().toString().equals(bf().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{e(), bf()});
    }

    public t(Throwable th) {
        this.bf = th;
        this.e = null;
    }
}
