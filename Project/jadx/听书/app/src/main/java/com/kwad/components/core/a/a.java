package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private String Ne;
    private String Nf;
    private long Ng;
    private long Nh;
    private Timer Ni;
    private boolean Nj = false;
    private final long period;

    /* JADX INFO: renamed from: com.kwad.components.core.a.a$a, reason: collision with other inner class name */
    static final class C0321a {
        private static final a Nl = new a();
    }

    public static a nX() {
        return C0321a.Nl;
    }

    public a() {
        this.Ng = -1L;
        try {
            this.Ng = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.Ng = System.currentTimeMillis();
            c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(e.Fa());
        d dVar = new d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.au();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.av();
            }
        };
        b.Ho();
        b.a(dVar);
    }

    public final void au() {
        if (this.Nj) {
            return;
        }
        this.Nj = true;
        if (this.period <= 0) {
            return;
        }
        this.Ni = new Timer();
        av(1);
        TimerTask timerTask = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.av(2);
            }
        };
        try {
            Timer timer = this.Ni;
            long j = this.period;
            timer.schedule(timerTask, j, j);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        this.Nj = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.Ni;
        if (timer != null) {
            timer.cancel();
        }
        av(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.Ng;
        this.Ng = jElapsedRealtime;
        if (i == 1) {
            this.Nh = 0L;
            this.Nf = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.Ne)) {
                this.Ne = this.Nf;
            }
        }
        this.Nh++;
        n nVar = new n(10220L);
        nVar.aDb = this.Nh;
        if (j > 0) {
            nVar.aHK = j;
        }
        nVar.aHL = i;
        nVar.Ne = this.Ne;
        nVar.Nf = this.Nf;
        g.a(nVar);
    }
}
