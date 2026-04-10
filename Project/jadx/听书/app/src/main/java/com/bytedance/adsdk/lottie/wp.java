package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class wp<V> {
    private final Throwable g;
    private final V z;

    public wp(V v) {
        this.z = v;
        this.g = null;
    }

    public wp(Throwable th) {
        this.g = th;
        this.z = null;
    }

    public V z() {
        return this.z;
    }

    public Throwable g() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wp)) {
            return false;
        }
        wp wpVar = (wp) obj;
        if (z() != null && z().equals(wpVar.z())) {
            return true;
        }
        if (g() == null || wpVar.g() == null) {
            return false;
        }
        return g().toString().equals(g().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{z(), g()});
    }
}
