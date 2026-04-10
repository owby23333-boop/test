package com.kwad.components.core.i;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat Kd = new SimpleDateFormat("yyyy-MM-dd");
    public int Ke;
    public long Kf;

    public final boolean h(int i2, int i3) {
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i2 + ", forceActiveThreshold: " + i3);
        if (this.Kf <= 0) {
            nZ();
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = Kd.format(new Date(this.Kf));
        String str2 = Kd.format(new Date(jCurrentTimeMillis));
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + str + ", currentDate: " + str2);
        if (!str.equals(str2)) {
            this.Ke = 0;
            nZ();
            return true;
        }
        long j2 = this.Kf + (((long) i2) * 60 * 60 * 1000);
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j2 + ", currentActiveCount: " + this.Ke);
        if (j2 >= jCurrentTimeMillis || this.Ke > i3) {
            return false;
        }
        nZ();
        return true;
    }

    public final void nZ() {
        this.Kf = System.currentTimeMillis();
        this.Ke++;
        com.kwad.sdk.core.d.b.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Kf + ", currentActiveCount " + this.Ke);
    }
}
