package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class e extends g {
    private static volatile e z;

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ File a() {
        return super.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ List a(String str) {
        return super.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ boolean a(int i) {
        return super.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ File dl() {
        return super.dl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ List dl(String str) {
        return super.dl(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void dl(int i) {
        super.dl(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ boolean e(int i) {
        return super.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ gk fo(int i) {
        return super.fo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ js g() {
        return super.g();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.e.dl g(String str, String str2) {
        return super.g(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ List g(String str) {
        return super.g(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void g(int i) {
        super.g(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void g(List list) {
        super.g((List<String>) list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void gc(int i) {
        super.gc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void gc(String str) {
        super.gc(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.e.dl gz(int i) {
        return super.gz(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ boolean i(int i) {
        return super.i(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    @Deprecated
    public /* bridge */ /* synthetic */ void kb(int i) {
        super.kb(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ int m(int i) {
        return super.m(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void uy(int i) {
        super.uy(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.a.q wp(int i) {
        return super.wp(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ int z(String str, String str2) {
        return super.z(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ List z(String str) {
        return super.z(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void z() {
        super.z();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void z(int i) {
        super.z(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    @Deprecated
    public /* bridge */ /* synthetic */ void z(int i, hh hhVar) {
        super.z(i, hhVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    @Deprecated
    public /* bridge */ /* synthetic */ void z(int i, hh hhVar, boolean z2) {
        super.z(i, hhVar, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void z(int i, boolean z2) {
        super.z(i, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void z(com.ss.android.socialbase.downloader.a.wp wpVar) {
        super.z(wpVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void z(js jsVar) {
        super.z(jsVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ void z(List list) {
        super.z((List<String>) list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public /* bridge */ /* synthetic */ boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return super.z(dlVar);
    }

    static {
        dl.z(new zw());
        z = null;
    }

    private e() {
    }

    public static synchronized void z(gz gzVar, boolean z2) {
        if (gzVar == null) {
            return;
        }
        if (z == null) {
            z = gzVar.l();
        } else if (!dl.vm()) {
            dl.z(gzVar);
        } else {
            if (z2) {
                dl.g(gzVar);
            }
        }
    }

    e(gz gzVar) {
        dl.z(gzVar);
    }

    public static e g(Context context) {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    dl.z(context);
                    z = new e();
                }
            }
        }
        return z;
    }
}
