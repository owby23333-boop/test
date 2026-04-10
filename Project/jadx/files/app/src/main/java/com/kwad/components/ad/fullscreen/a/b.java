package com.kwad.components.ad.fullscreen.a;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat go = new SimpleDateFormat("yyyy-MM-dd");
    public long gp;
    public int gq;

    public b() {
        this.gp = -1L;
        this.gq = -1;
    }

    public b(long j2, int i2) {
        this.gp = -1L;
        this.gq = -1;
        this.gp = j2;
        this.gq = 1;
    }

    public final boolean e(long j2) {
        long j3 = this.gp;
        if (j3 > 0 && j2 > 0) {
            try {
                return go.format(new Date(j3)).equals(go.format(new Date(j2)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public final boolean z(int i2) {
        int i3 = this.gq;
        return i3 > 0 && i3 >= i2;
    }
}
