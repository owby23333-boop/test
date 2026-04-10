package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private com.kwad.sdk.crash.b.b aOP;
    private c aOQ;
    private long aOR;

    /* synthetic */ e(byte b) {
        this();
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f fVarLn = this.aOQ.Ln();
        if (fVarLn != null) {
            fVarLn.a(i, exceptionMessage);
        }
    }

    static class a {
        private static final e aOS = new e(0);
    }

    private e() {
        this.aOP = new com.kwad.sdk.crash.b.b();
        this.aOQ = new c.a().Lq();
    }

    public static e Lr() {
        return a.aOS;
    }

    public final String[] Ls() {
        return this.aOP.LE();
    }

    public final String[] Lt() {
        return this.aOP.Lt();
    }

    public final String getAppId() {
        return this.aOQ.aOo.mAppId;
    }

    public final String Lu() {
        return this.aOQ.aOn.aPt;
    }

    public final String getSdkVersion() {
        return this.aOQ.aOn.mSdkVersion;
    }

    public final int Lv() {
        return this.aOQ.aOn.aPx;
    }

    public final void a(c cVar) {
        this.aOQ = cVar;
        this.aOR = SystemClock.elapsedRealtime();
        this.aOP.a(cVar.aOq, cVar.aOr);
    }

    public final Context getContext() {
        return this.aOQ.context;
    }

    public final c Lw() {
        return this.aOQ;
    }

    public final h Lx() {
        return this.aOQ.aOp;
    }

    public final long Ly() {
        return SystemClock.elapsedRealtime() - this.aOR;
    }

    public final boolean isDebug() {
        return this.aOQ.Lo();
    }
}
