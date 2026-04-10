package com.bytedance.adsdk.lottie.d;

import android.util.Pair;
import com.alipay.sdk.m.y.l;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class zk<T> {
    T bf;
    T e;

    private static boolean bf(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void e(T t, T t2) {
        this.e = t;
        this.bf = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return bf(pair.first, this.e) && bf(pair.second, this.bf);
    }

    public int hashCode() {
        T t = this.e;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.bf;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.e + " " + this.bf + l.d;
    }
}
