package com.bumptech.glide.load.engine.y;

import android.util.Log;
import com.bumptech.glide.k.a;
import com.bumptech.glide.load.engine.y.a;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: DiskLruCacheWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements a {
    private final File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f13634c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.k.a f13636e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f13635d = new c();
    private final j a = new j();

    @Deprecated
    protected e(File file, long j2) {
        this.b = file;
        this.f13634c = j2;
    }

    public static a a(File file, long j2) {
        return new e(file, j2);
    }

    private synchronized void b() {
        this.f13636e = null;
    }

    @Override // com.bumptech.glide.load.engine.y.a
    public synchronized void clear() {
        try {
            try {
                a().delete();
            } catch (IOException unused) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
        } finally {
            b();
        }
    }

    @Override // com.bumptech.glide.load.engine.y.a
    public void delete(com.bumptech.glide.load.c cVar) {
        try {
            a().d(this.a.a(cVar));
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        }
    }

    private synchronized com.bumptech.glide.k.a a() throws IOException {
        if (this.f13636e == null) {
            this.f13636e = com.bumptech.glide.k.a.a(this.b, 1, 1, this.f13634c);
        }
        return this.f13636e;
    }

    @Override // com.bumptech.glide.load.engine.y.a
    public File a(com.bumptech.glide.load.c cVar) {
        String strA = this.a.a(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            String str = "Get: Obtained: " + strA + " for for Key: " + cVar;
        }
        try {
            a.e eVarC = a().c(strA);
            if (eVarC != null) {
                return eVarC.a(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.y.a
    public void a(com.bumptech.glide.load.c cVar, a.b bVar) {
        com.bumptech.glide.k.a aVarA;
        String strA = this.a.a(cVar);
        this.f13635d.a(strA);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                String str = "Put: Obtained: " + strA + " for for Key: " + cVar;
            }
            try {
                aVarA = a();
            } catch (IOException unused) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
            if (aVarA.c(strA) != null) {
                return;
            }
            a.c cVarB = aVarA.b(strA);
            if (cVarB != null) {
                try {
                    if (bVar.a(cVarB.a(0))) {
                        cVarB.c();
                    }
                    cVarB.b();
                    return;
                } catch (Throwable th) {
                    cVarB.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + strA);
        } finally {
            this.f13635d.b(strA);
        }
    }
}
