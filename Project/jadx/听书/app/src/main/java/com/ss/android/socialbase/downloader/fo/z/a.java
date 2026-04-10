package com.ss.android.socialbase.downloader.fo.z;

import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.e.gc;
import com.ss.android.socialbase.downloader.fo.fo;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class a implements fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2076a;
    private fo dl;
    private final List<gc> g;
    private long gc;
    private InputStream m;
    protected final Object z;

    public boolean z(int i) {
        return i >= 200 && i < 300;
    }

    public void gc() throws InterruptedException {
        synchronized (this.z) {
            if (this.f2076a && this.dl == null) {
                this.z.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.fo.fo
    public InputStream z() throws IOException {
        InputStream inputStream = this.m;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.fo.fo
    public void a() {
        fo foVar = this.dl;
        if (foVar != null) {
            foVar.a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.fo.e
    public String z(String str) {
        fo foVar = this.dl;
        if (foVar != null) {
            return foVar.z(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.fo.e
    public int g() throws IOException {
        fo foVar = this.dl;
        if (foVar != null) {
            return foVar.g();
        }
        return 0;
    }

    public List<gc> m() {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.fo.e
    public void dl() {
        fo foVar = this.dl;
        if (foVar != null) {
            foVar.dl();
        }
    }

    public boolean e() {
        try {
            fo foVar = this.dl;
            if (foVar != null) {
                return z(foVar.g());
            }
            return false;
        } catch (IOException e) {
            wp.z(e);
            return false;
        }
    }

    public boolean gz() {
        return System.currentTimeMillis() - this.gc < g.z;
    }
}
