package com.ss.android.socialbase.appdownloader.gc;

import android.content.Context;
import com.ss.android.socialbase.downloader.a.gc;

/* JADX INFO: loaded from: classes4.dex */
public class g extends gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2035a;
    private String dl;
    private com.ss.android.socialbase.downloader.notification.z e;
    private int g;
    private String gc;
    private String m;
    private Context z;

    public g(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.z = context.getApplicationContext();
        } else {
            this.z = com.ss.android.socialbase.downloader.downloader.dl.xl();
        }
        this.g = i;
        this.dl = str;
        this.f2035a = str2;
        this.gc = str3;
        this.m = str4;
    }

    public g(com.ss.android.socialbase.downloader.notification.z zVar) {
        this.z = com.ss.android.socialbase.downloader.downloader.dl.xl();
        this.e = zVar;
    }

    @Override // com.ss.android.socialbase.downloader.a.gc
    public com.ss.android.socialbase.downloader.notification.z z() {
        com.ss.android.socialbase.downloader.notification.z zVar = this.e;
        return (zVar != null || this.z == null) ? zVar : new z(this.z, this.g, this.dl, this.f2035a, this.gc, this.m);
    }

    @Override // com.ss.android.socialbase.downloader.a.gc, com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || dlVar.cb()) {
            return;
        }
        super.z(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.gc, com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || dlVar.cb()) {
            return;
        }
        super.g(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.gc, com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void a(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || dlVar.cb()) {
            return;
        }
        super.a(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.gc, com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || dlVar.cb()) {
            return;
        }
        super.dl(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.gc, com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void gc(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || this.z == null) {
            return;
        }
        if (dlVar.k() && (!dlVar.cb() || !dlVar.o())) {
            super.gc(dlVar);
        }
        if (dlVar.o()) {
            com.ss.android.socialbase.appdownloader.m.g.z(dlVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.gc, com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        if (dlVar == null || this.z == null || !dlVar.k() || dlVar.cb()) {
            return;
        }
        super.z(dlVar, zVar);
    }
}
