package com.kwad.components.core.l.kwai;

import android.os.SystemClock;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private String NW;
    private long NX;
    private long NY;
    private long NZ;
    private boolean Oa;

    public final void au(String str) {
        this.NW = str;
    }

    public final void pq() {
        if (this.Oa) {
            return;
        }
        this.Oa = true;
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.l.kwai.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.NZ = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void report() {
        b bVar = new b();
        bVar.NW = this.NW;
        long j2 = this.NX;
        bVar.Od = j2 != 0 ? this.NY - j2 : 0L;
        long j3 = this.NY;
        bVar.Oe = j3 != 0 ? this.NZ - j3 : 0L;
        long j4 = this.NX;
        bVar.Oc = j4 != 0 ? this.NZ - j4 : 0L;
        com.kwad.components.core.m.a.pr().a(bVar);
        com.kwad.sdk.core.d.b.d("PageMonitor", bVar.toString());
    }

    public final void s(long j2) {
        this.NX = j2;
        this.NY = SystemClock.uptimeMillis();
    }
}
