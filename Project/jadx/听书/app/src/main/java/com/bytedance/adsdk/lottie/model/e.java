package com.bytedance.adsdk.lottie.model;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class e<T> {
    T g;
    T z;

    public void z(T t, T t2) {
        this.z = t;
        this.g = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return g(pair.first, this.z) && g(pair.second, this.g);
    }

    private static boolean g(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.z;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.g;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.z + " " + this.g + "}";
    }
}
