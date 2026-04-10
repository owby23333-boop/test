package com.ss.android.socialbase.downloader.kb;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f2098a;
    private final long dl;
    private int e;
    int g;
    private volatile long gc;
    private JSONObject gz;
    private long m;
    volatile i z;

    public fo(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f2098a = atomicLong;
        this.g = 0;
        this.dl = j;
        atomicLong.set(j);
        this.gc = j;
        if (j2 >= j) {
            this.m = j2;
        } else {
            this.m = -1L;
        }
    }

    public fo(fo foVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f2098a = atomicLong;
        this.g = 0;
        this.dl = foVar.dl;
        this.m = foVar.m;
        atomicLong.set(foVar.f2098a.get());
        this.gc = atomicLong.get();
        this.e = foVar.e;
    }

    public fo(JSONObject jSONObject) {
        this.f2098a = new AtomicLong();
        this.g = 0;
        this.dl = jSONObject.optLong("st");
        dl(jSONObject.optLong("en"));
        z(jSONObject.optLong("cu"));
        a(a());
    }

    public long z() {
        return this.f2098a.get() - this.dl;
    }

    public long g() {
        long j = this.m;
        if (j >= this.dl) {
            return (j - gc()) + 1;
        }
        return -1L;
    }

    public long dl() {
        return this.dl;
    }

    public long a() {
        long j = this.f2098a.get();
        long j2 = this.m;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long gc() {
        i iVar = this.z;
        if (iVar != null) {
            long jA = iVar.a();
            if (jA > this.gc) {
                return jA;
            }
        }
        return this.gc;
    }

    public void z(long j) {
        long j2 = this.dl;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.m;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.f2098a.set(j);
    }

    void g(long j) {
        this.f2098a.addAndGet(j);
    }

    public long m() {
        return this.m;
    }

    void dl(long j) {
        if (j >= this.dl) {
            this.m = j;
            return;
        }
        com.bytedance.sdk.component.utils.wp.g("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.m = j;
        }
    }

    public void a(long j) {
        if (j >= this.f2098a.get()) {
            this.gc = j;
        }
    }

    public int e() {
        return this.e;
    }

    void z(int i) {
        this.e = i;
    }

    void gz() {
        this.g++;
    }

    void fo() {
        this.g--;
    }

    int uy() {
        return this.g;
    }

    void g(int i) {
        this.g = i;
    }

    public String toString() {
        return "Segment{startOffset=" + this.dl + ",\t currentOffset=" + this.f2098a + ",\t currentOffsetRead=" + gc() + ",\t endOffset=" + this.m + '}';
    }

    public static String z(List<fo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<fo>() { // from class: com.ss.android.socialbase.downloader.kb.fo.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compare(fo foVar, fo foVar2) {
                return (int) (foVar.dl() - foVar2.dl());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<fo> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\r\n");
        }
        return sb.toString();
    }

    public JSONObject kb() throws JSONException {
        JSONObject jSONObject = this.gz;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.gz = jSONObject;
        }
        jSONObject.put("st", dl());
        jSONObject.put("cu", a());
        jSONObject.put("en", m());
        return jSONObject;
    }
}
