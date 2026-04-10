package com.ss.android.socialbase.downloader.e;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2069a;
    public final int dl;
    public final com.ss.android.socialbase.downloader.fo.e g;
    private long gc;
    public final String z;

    public m(String str, com.ss.android.socialbase.downloader.fo.e eVar) throws IOException {
        this.z = str;
        this.dl = eVar.g();
        this.g = eVar;
    }

    public boolean z() {
        return com.ss.android.socialbase.downloader.pf.m.dl(this.dl);
    }

    public boolean g() {
        return com.ss.android.socialbase.downloader.pf.m.z(this.dl, this.g.z(HttpHeaders.ACCEPT_RANGES));
    }

    public String dl() {
        return this.g.z("Etag");
    }

    public String a() {
        return this.g.z(HttpHeaders.CONTENT_TYPE);
    }

    public String gc() {
        return com.ss.android.socialbase.downloader.pf.m.g(this.g, HttpHeaders.CONTENT_RANGE);
    }

    public String m() {
        String strG = com.ss.android.socialbase.downloader.pf.m.g(this.g, "last-modified");
        return TextUtils.isEmpty(strG) ? com.ss.android.socialbase.downloader.pf.m.g(this.g, HttpHeaders.LAST_MODIFIED) : strG;
    }

    public String e() {
        return com.ss.android.socialbase.downloader.pf.m.g(this.g, HttpHeaders.CACHE_CONTROL);
    }

    public long gz() {
        if (this.f2069a <= 0) {
            this.f2069a = com.ss.android.socialbase.downloader.pf.m.z(this.g);
        }
        return this.f2069a;
    }

    public boolean fo() {
        if (com.ss.android.socialbase.downloader.pf.z.z(8)) {
            return com.ss.android.socialbase.downloader.pf.m.dl(this.g);
        }
        return com.ss.android.socialbase.downloader.pf.m.g(gz());
    }

    public long uy() {
        if (this.gc <= 0) {
            if (!fo()) {
                String strGc = gc();
                if (!TextUtils.isEmpty(strGc)) {
                    this.gc = com.ss.android.socialbase.downloader.pf.m.g(strGc);
                }
            } else {
                this.gc = -1L;
            }
        }
        return this.gc;
    }

    public long kb() {
        return com.ss.android.socialbase.downloader.pf.m.fo(e());
    }
}
