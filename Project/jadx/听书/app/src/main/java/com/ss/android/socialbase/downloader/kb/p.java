package com.ss.android.socialbase.downloader.kb;

import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f2102a;
    final String dl;
    private boolean e;
    private String fo;
    final String g;
    private final List<i> gc;
    private int gz;
    private int m;
    private final AtomicLong uy;
    final String z;

    public p(String str, boolean z) {
        this.gc = new ArrayList();
        this.uy = new AtomicLong();
        this.z = str;
        this.f2102a = z;
        this.g = null;
        this.dl = null;
    }

    public p(String str, String str2) {
        this.gc = new ArrayList();
        this.uy = new AtomicLong();
        this.z = str;
        this.f2102a = false;
        this.g = str2;
        this.dl = z(str2);
    }

    private String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    public synchronized void z(i iVar) {
        this.gc.add(iVar);
    }

    public synchronized void g(i iVar) {
        try {
            this.gc.remove(iVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized int z() {
        return this.gc.size();
    }

    public synchronized void g() {
        this.m++;
        this.e = true;
    }

    public synchronized void dl() {
        this.e = false;
    }

    public synchronized boolean a() {
        return this.e;
    }

    public void z(long j) {
        this.uy.addAndGet(j);
    }

    public int hashCode() {
        if (this.gz == 0) {
            this.gz = gc().hashCode();
        }
        return this.gz;
    }

    private String gc() {
        if (this.fo == null) {
            StringBuilder sbAppend = new StringBuilder().append(this.z).append("_");
            String str = this.g;
            if (str == null) {
                str = "";
            }
            this.fo = sbAppend.append(str).append("_").append(this.f2102a).toString();
        }
        return this.fo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return gc().equals(((p) obj).gc());
        }
        return false;
    }

    public String toString() {
        return "UrlRecord{url='" + this.z + "', ip='" + this.g + "', ipFamily='" + this.dl + "', isMainUrl=" + this.f2102a + ", failedTimes=" + this.m + ", isCurrentFailed=" + this.e + '}';
    }
}
