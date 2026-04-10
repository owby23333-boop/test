package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Option.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b<Object> f13464e = new a();
    private final T a;
    private final b<T> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile byte[] f13466d;

    /* JADX INFO: compiled from: Option.java */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* JADX INFO: compiled from: Option.java */
    public interface b<T> {
        void update(@NonNull byte[] bArr, @NonNull T t2, @NonNull MessageDigest messageDigest);
    }

    private e(@NonNull String str, @Nullable T t2, @NonNull b<T> bVar) {
        k.a(str);
        this.f13465c = str;
        this.a = t2;
        k.a(bVar);
        this.b = bVar;
    }

    @NonNull
    public static <T> e<T> a(@NonNull String str) {
        return new e<>(str, null, b());
    }

    @NonNull
    private static <T> b<T> b() {
        return (b<T>) f13464e;
    }

    @NonNull
    private byte[] c() {
        if (this.f13466d == null) {
            this.f13466d = this.f13465c.getBytes(c.a);
        }
        return this.f13466d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f13465c.equals(((e) obj).f13465c);
        }
        return false;
    }

    public int hashCode() {
        return this.f13465c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f13465c + "'}";
    }

    public void update(@NonNull T t2, @NonNull MessageDigest messageDigest) {
        this.b.update(c(), t2, messageDigest);
    }

    @NonNull
    public static <T> e<T> a(@NonNull String str, @NonNull T t2) {
        return new e<>(str, t2, b());
    }

    @NonNull
    public static <T> e<T> a(@NonNull String str, @Nullable T t2, @NonNull b<T> bVar) {
        return new e<>(str, t2, bVar);
    }

    @Nullable
    public T a() {
        return this.a;
    }
}
