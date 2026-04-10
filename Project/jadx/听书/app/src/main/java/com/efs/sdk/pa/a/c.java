package com.efs.sdk.pa.a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.media3.exoplayer.ExoPlayer;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.pa.PA;
import com.efs.sdk.pa.PAANRListener;
import com.efs.sdk.pa.PAMsgListener;
import com.efs.sdk.pa.a.b;
import com.efs.sdk.pa.a.g;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements PA {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1622a;
    private e c;
    private f d;
    private a e;
    private boolean h;
    private boolean i;
    private Looper b = Looper.myLooper();
    private b f = new b();
    private g g = new g();

    @Override // com.efs.sdk.pa.PA
    public final void unregisterPAANRListener() {
    }

    public c(boolean z) {
        this.i = z;
    }

    @Override // com.efs.sdk.pa.PA
    public final void start() {
        if (this.i || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.h = true;
            e eVar = this.c;
            if (eVar != null) {
                this.b.setMessageLogging(eVar);
            }
            a aVar = this.e;
            if (aVar == null || !aVar.f) {
                return;
            }
            aVar.f = false;
            aVar.g.post(aVar.m);
            aVar.j = SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void stop() {
        this.h = false;
        this.b.setMessageLogging(null);
        a aVar = this.e;
        if (aVar != null) {
            aVar.f = true;
            aVar.g.removeCallbacksAndMessages(null);
            aVar.f1616a = true;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalFPS(String str, View view) {
        if (this.h) {
            b bVar = this.f;
            if (str == null || str.trim().length() == 0 || view == null || bVar.f1619a.get(str) != null) {
                return;
            }
            b.a aVar = new b.a((byte) 0);
            if (view != null) {
                aVar.d = view;
                b.a.AnonymousClass1 anonymousClass1 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.efs.sdk.pa.a.b.a.1
                    AnonymousClass1() {
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public final boolean onPreDraw() {
                        a.this.b++;
                        return true;
                    }
                };
                aVar.c = anonymousClass1;
                aVar.d.getViewTreeObserver().addOnPreDrawListener(anonymousClass1);
                aVar.f1620a = System.currentTimeMillis();
            }
            bVar.f1619a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final int endCalFPS(String str) {
        if (!this.h) {
            return -1;
        }
        b bVar = this.f;
        if (str != null && str.trim().length() != 0) {
            b.a aVar = bVar.f1619a.get(str);
            if (aVar == null) {
                return 0;
            }
            if (aVar.d != null && aVar.c != null) {
                aVar.d.getViewTreeObserver().removeOnPreDrawListener(aVar.c);
            }
            bVar.f1619a.remove(str);
            int iCurrentTimeMillis = (int) (aVar.b / ((System.currentTimeMillis() - aVar.f1620a) / 1000.0f));
            i = iCurrentTimeMillis > 0 ? iCurrentTimeMillis : 0;
            if (bVar.b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",fps=" + i);
            }
        }
        return i;
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalTime(String str) {
        if (this.h) {
            g gVar = this.g;
            if (str == null || str.trim().length() == 0 || gVar.f1625a.get(str) != null) {
                return;
            }
            g.a aVar = new g.a((byte) 0);
            aVar.f1626a = System.currentTimeMillis();
            gVar.f1625a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final long endCalTime(String str) {
        if (!this.h) {
            return -1L;
        }
        g gVar = this.g;
        long jCurrentTimeMillis = 0;
        if (str != null && str.trim().length() != 0) {
            g.a aVar = gVar.f1625a.get(str);
            if (aVar == null) {
                return 0L;
            }
            gVar.f1625a.remove(str);
            jCurrentTimeMillis = System.currentTimeMillis() - aVar.f1626a;
            if (gVar.b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",consumeTime=" + jCurrentTimeMillis);
            }
        }
        return jCurrentTimeMillis;
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableLog(boolean z) {
        this.f1622a = z;
        this.f.b = z;
        this.g.b = z;
        f fVar = this.d;
        if (fVar != null) {
            fVar.b = z;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableDumpToFile(String str) {
        FileOutputStream fileOutputStream;
        f fVar = this.d;
        if (fVar == null || str == null || str.trim().length() == 0) {
            return;
        }
        fVar.c = str;
        if (fVar.d == null) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception unused) {
                fileOutputStream = null;
            }
            try {
                fVar.d = new BufferedOutputStream(fileOutputStream);
            } catch (Exception unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.c == null) {
            this.c = new e();
        }
        this.b.setMessageLogging(this.c);
        if (this.d == null) {
            this.d = new f();
        }
        this.d.b = this.f1622a;
        this.d.f1624a = pAMsgListener;
        e eVar = this.c;
        eVar.f1623a.add(this.d);
    }

    @Override // com.efs.sdk.pa.PA
    public final void unRegisterPAMsgListener() {
        f fVar = this.d;
        if (fVar != null) {
            fVar.f1624a = null;
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.f1623a.remove(this.d);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j) {
        registerPAANRListener(context, pAANRListener, j, Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j, Thread thread) {
        if (this.e == null) {
            if (thread != null) {
                this.e = new a((Application) context.getApplicationContext(), j);
            } else {
                this.e = new a((Application) context.getApplicationContext(), j, false);
            }
        }
        this.e.h = pAANRListener;
    }
}
