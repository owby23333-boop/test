package com.ss.android.socialbase.downloader.fo.z;

import com.google.common.net.HttpHeaders;
import com.ss.android.socialbase.downloader.e.gc;
import com.ss.android.socialbase.downloader.fo.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements e {
    private static final ArrayList<String> gc;
    protected List<gc> dl;
    private int e;
    private boolean fo;
    protected final long g;
    private long gz;
    private e kb;
    private boolean uy;
    protected final String z;
    private Map<String, String> m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Object f2077a = new Object();

    public boolean z(int i) {
        return i >= 200 && i < 300;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        gc = arrayList;
        arrayList.add(HttpHeaders.CONTENT_LENGTH);
        arrayList.add(HttpHeaders.CONTENT_RANGE);
        arrayList.add(HttpHeaders.TRANSFER_ENCODING);
        arrayList.add(HttpHeaders.ACCEPT_RANGES);
        arrayList.add("Etag");
        arrayList.add(HttpHeaders.CONTENT_DISPOSITION);
    }

    public dl(String str, List<gc> list, long j) {
        this.z = str;
        this.dl = list;
        this.g = j;
    }

    public void z() throws Exception {
        if (this.m != null) {
            return;
        }
        try {
            this.uy = true;
            this.kb = com.ss.android.socialbase.downloader.downloader.dl.z(this.z, this.dl);
            synchronized (this.f2077a) {
                if (this.kb != null) {
                    HashMap map = new HashMap();
                    this.m = map;
                    z(this.kb, map);
                    this.e = this.kb.g();
                    this.gz = System.currentTimeMillis();
                    this.fo = z(this.e);
                }
                this.uy = false;
                this.f2077a.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f2077a) {
                if (this.kb != null) {
                    HashMap map2 = new HashMap();
                    this.m = map2;
                    z(this.kb, map2);
                    this.e = this.kb.g();
                    this.gz = System.currentTimeMillis();
                    this.fo = z(this.e);
                }
                this.uy = false;
                this.f2077a.notifyAll();
                throw th;
            }
        }
    }

    private void z(e eVar, Map<String, String> map) {
        if (eVar == null || map == null) {
            return;
        }
        for (String str : gc) {
            map.put(str, eVar.z(str));
        }
    }

    public void a() throws InterruptedException {
        synchronized (this.f2077a) {
            if (this.uy && this.m == null) {
                this.f2077a.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.fo.e
    public String z(String str) {
        Map<String, String> map = this.m;
        if (map != null) {
            return map.get(str);
        }
        e eVar = this.kb;
        if (eVar != null) {
            return eVar.z(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.fo.e
    public int g() throws IOException {
        return this.e;
    }

    @Override // com.ss.android.socialbase.downloader.fo.e
    public void dl() {
        e eVar = this.kb;
        if (eVar != null) {
            eVar.dl();
        }
    }

    public boolean gc() {
        return this.fo;
    }

    public boolean m() {
        return System.currentTimeMillis() - this.gz < g.g;
    }

    public boolean e() {
        return this.uy;
    }

    public List<gc> gz() {
        return this.dl;
    }

    public Map<String, String> fo() {
        return this.m;
    }
}
