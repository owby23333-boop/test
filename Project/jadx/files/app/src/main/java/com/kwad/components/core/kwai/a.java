package com.kwad.components.core.kwai;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private String HD;
    private String HE;
    private long HF;
    private long HG;
    private Timer HH;
    private boolean HI = false;
    private final long period;

    /* JADX INFO: renamed from: com.kwad.components.core.kwai.a$a, reason: collision with other inner class name */
    static final class C0401a {
        private static final a HK = new a();
    }

    public a() {
        this.HF = -1L;
        try {
            this.HF = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.HF = System.currentTimeMillis();
            b.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(d.um());
        com.kwad.sdk.core.b.d dVar = new com.kwad.sdk.core.b.d() { // from class: com.kwad.components.core.kwai.a.1
            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.mp();
            }

            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.fc();
            }
        };
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(int i2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - this.HF;
        this.HF = jElapsedRealtime;
        if (i2 == 1) {
            this.HG = 0L;
            this.HE = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.HD)) {
                this.HD = this.HE;
            }
        }
        this.HG++;
        q qVar = new q(10220L);
        qVar.aes = this.HG;
        if (j2 > 0) {
            qVar.ajo = j2;
        }
        qVar.ajp = i2;
        qVar.HD = this.HD;
        qVar.HE = this.HE;
        h.a(qVar);
    }

    public static a mo() {
        return C0401a.HK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp() {
        this.HI = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.HH;
        if (timer != null) {
            timer.cancel();
        }
        am(3);
    }

    public final void fc() {
        if (this.HI) {
            return;
        }
        this.HI = true;
        if (this.period <= 0) {
            return;
        }
        this.HH = new Timer();
        am(1);
        try {
            this.HH.schedule(new TimerTask() { // from class: com.kwad.components.core.kwai.a.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    a.this.am(2);
                }
            }, this.period, this.period);
        } catch (Throwable unused) {
        }
    }
}
