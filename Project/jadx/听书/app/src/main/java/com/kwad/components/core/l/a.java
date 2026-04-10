package com.kwad.components.core.l;

import com.kwad.sdk.core.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat Rq = new SimpleDateFormat("yyyy-MM-dd");
    public int Rr;
    public long Rs;

    public final boolean k(int i, int i2) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.Rs > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = Rq.format(new Date(this.Rs));
            String str2 = Rq.format(new Date(jCurrentTimeMillis));
            c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + str + ", currentDate: " + str2);
            if (!str.equals(str2)) {
                this.Rr = 0;
                qr();
                return true;
            }
            long j = this.Rs + (((long) i) * 60 * 60 * 1000);
            c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.Rr);
            if (j >= jCurrentTimeMillis || this.Rr > i2) {
                return false;
            }
            qr();
            return true;
        }
        qr();
        return true;
    }

    public final void qr() {
        this.Rs = System.currentTimeMillis();
        this.Rr++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Rs + ", currentActiveCount " + this.Rr);
    }
}
