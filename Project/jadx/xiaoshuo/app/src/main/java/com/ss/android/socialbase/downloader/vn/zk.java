package com.ss.android.socialbase.downloader.vn;

import android.util.Log;
import com.market.sdk.utils.Language;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import net.oauth.http.HttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class zk {
    int bf;
    private final long d;
    volatile bh e;
    private volatile long ga;
    private int p;
    private final AtomicLong tg;
    private JSONObject v;
    private long vn;

    public zk(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.tg = atomicLong;
        this.bf = 0;
        this.d = j;
        atomicLong.set(j);
        this.ga = j;
        if (j2 >= j) {
            this.vn = j2;
        } else {
            this.vn = -1L;
        }
    }

    public long bf() {
        long j = this.vn;
        if (j >= this.d) {
            return (j - ga()) + 1;
        }
        return -1L;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.tg.get() - this.d;
    }

    public long ga() {
        bh bhVar = this.e;
        if (bhVar != null) {
            long jTg = bhVar.tg();
            if (jTg > this.ga) {
                return jTg;
            }
        }
        return this.ga;
    }

    public int m() {
        return this.bf;
    }

    public int p() {
        return this.p;
    }

    public long tg() {
        long j = this.tg.get();
        long j2 = this.vn;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public String toString() {
        return "Segment{startOffset=" + this.d + ",\t currentOffset=" + this.tg + ",\t currentOffsetRead=" + ga() + ",\t endOffset=" + this.vn + '}';
    }

    public void v() {
        this.bf++;
    }

    public long vn() {
        return this.vn;
    }

    public JSONObject wu() throws JSONException {
        JSONObject jSONObject = this.v;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.v = jSONObject;
        }
        jSONObject.put("st", d());
        jSONObject.put("cu", tg());
        jSONObject.put(Language.LA_EN, vn());
        return jSONObject;
    }

    public void zk() {
        this.bf--;
    }

    public void d(long j) {
        if (j >= this.d) {
            this.vn = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.vn = j;
        }
    }

    public void e(long j) {
        long j2 = this.d;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.vn;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.tg.set(j);
    }

    public void bf(long j) {
        this.tg.addAndGet(j);
    }

    public void tg(long j) {
        if (j >= this.tg.get()) {
            this.ga = j;
        }
    }

    public void bf(int i) {
        this.bf = i;
    }

    public void e(int i) {
        this.p = i;
    }

    public static String e(List<zk> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<zk>() { // from class: com.ss.android.socialbase.downloader.vn.zk.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int compare(zk zkVar, zk zkVar2) {
                return (int) (zkVar.d() - zkVar2.d());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<zk> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(HttpResponseMessage.EOL);
        }
        return sb.toString();
    }

    public zk(zk zkVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.tg = atomicLong;
        this.bf = 0;
        this.d = zkVar.d;
        this.vn = zkVar.vn;
        atomicLong.set(zkVar.tg.get());
        this.ga = atomicLong.get();
        this.p = zkVar.p;
    }

    public zk(JSONObject jSONObject) {
        this.tg = new AtomicLong();
        this.bf = 0;
        this.d = jSONObject.optLong("st");
        d(jSONObject.optLong(Language.LA_EN));
        e(jSONObject.optLong("cu"));
        tg(tg());
    }
}
