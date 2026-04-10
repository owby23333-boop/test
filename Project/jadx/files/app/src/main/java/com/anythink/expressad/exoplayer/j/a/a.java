package com.anythink.expressad.exoplayer.j.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.j.a.a$a, reason: collision with other inner class name */
    public static class C0200a extends IOException {
        public C0200a(String str) {
            super(str);
        }

        public C0200a(Throwable th) {
            super(th);
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    e a(String str, long j2);

    @NonNull
    NavigableSet<e> a(String str);

    @NonNull
    NavigableSet<e> a(String str, b bVar);

    void a();

    void a(e eVar);

    void a(File file);

    void a(String str, k kVar);

    boolean a(String str, long j2, long j3);

    long b(String str);

    long b(String str, long j2, long j3);

    @Nullable
    e b(String str, long j2);

    Set<String> b();

    void b(e eVar);

    void b(String str, b bVar);

    long c();

    i c(String str);

    File c(String str, long j2);

    void d(String str, long j2);
}
