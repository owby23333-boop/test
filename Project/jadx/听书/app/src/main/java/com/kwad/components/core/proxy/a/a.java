package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private String WH;
    private long WI;
    private long WJ;
    private long WK;
    private boolean WL;
    private c WM;

    public a(c cVar) {
        this.WM = cVar;
    }

    public final void aC(String str) {
        this.WH = str;
    }

    public final void L(long j) {
        this.WI = j;
        this.WJ = SystemClock.uptimeMillis();
    }

    public final void sd() {
        if (this.WL) {
            return;
        }
        this.WL = true;
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.WK = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.WM;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }

    public final void report() {
        b bVar = new b();
        bVar.WH = this.WH;
        long j = this.WI;
        bVar.WP = j != 0 ? this.WJ - j : 0L;
        long j2 = this.WJ;
        bVar.WQ = j2 != 0 ? this.WK - j2 : 0L;
        long j3 = this.WI;
        bVar.WO = j3 != 0 ? this.WK - j3 : 0L;
        com.kwad.components.core.p.a.se().a(bVar);
        com.kwad.sdk.core.d.c.d("PageMonitor", bVar.toString());
    }
}
