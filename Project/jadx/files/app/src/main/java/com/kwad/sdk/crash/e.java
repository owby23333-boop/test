package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private com.kwad.sdk.crash.a.b aqB;
    private c aqC;
    private long aqD;

    static class a {
        private static final e aqE = new e(0);
    }

    private e() {
        this.aqB = new com.kwad.sdk.crash.a.b();
        this.aqC = new c.a().zI();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e zJ() {
        return a.aqE;
    }

    public final void a(@NonNull c cVar) {
        this.aqC = cVar;
        this.aqD = SystemClock.elapsedRealtime();
        this.aqB.a(cVar.aqh, cVar.aqi);
    }

    public final void b(int i2, ExceptionMessage exceptionMessage) {
        f fVarZG = this.aqC.zG();
        if (fVarZG != null) {
            fVarZG.a(i2, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aqC.aqf.aqS;
    }

    public final Context getContext() {
        return this.aqC.context;
    }

    public final String getSdkVersion() {
        return this.aqC.aqe.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aqC.zH();
    }

    public final String[] zK() {
        return this.aqB.zX();
    }

    public final String[] zL() {
        return this.aqB.zL();
    }

    public final String zM() {
        return this.aqC.aqe.aqV;
    }

    public final int zN() {
        return this.aqC.aqe.aqZ;
    }

    public final c zO() {
        return this.aqC;
    }

    public final h zP() {
        return this.aqC.aqg;
    }

    public final long zQ() {
        return SystemClock.elapsedRealtime() - this.aqD;
    }
}
