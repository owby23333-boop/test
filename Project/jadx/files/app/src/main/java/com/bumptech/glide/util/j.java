package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MultiClassKey.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private Class<?> a;
    private Class<?> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Class<?> f13900c;

    public j() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.a = cls;
        this.b = cls2;
        this.f13900c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.a.equals(jVar.a) && this.b.equals(jVar.b) && l.b(this.f13900c, jVar.f13900c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Class<?> cls = this.f13900c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }

    public j(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
