package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.aj;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final a ayy = new a();

    public final a EM() {
        return this.ayy;
    }

    public final b b(a.C0392a c0392a) {
        this.ayy.Pk = c0392a;
        return this;
    }

    public final b w(int i, int i2) {
        this.ayy.axN = i + "," + i2;
        return this;
    }

    public final b dd(int i) {
        this.ayy.mI = i;
        return this;
    }

    public final b de(int i) {
        this.ayy.axL = i;
        return this;
    }

    public final b df(int i) {
        this.ayy.axM = i;
        return this;
    }

    public final b f(aj.a aVar) {
        this.ayy.mK = aVar;
        return this;
    }

    public final b ds(String str) {
        this.ayy.Pj = str;
        return this;
    }

    public final b dg(int i) {
        this.ayy.downloadSource = i;
        return this;
    }

    public final b dh(int i) {
        this.ayy.aye = i;
        return this;
    }

    public final b dt(String str) {
        this.ayy.ayf = str;
        return this;
    }

    public final b du(String str) {
        this.ayy.ayg = str;
        return this;
    }

    public final b di(int i) {
        this.ayy.ayh = i;
        return this;
    }

    public final b dj(int i) {
        this.ayy.ayi = i;
        return this;
    }

    public final b dk(int i) {
        this.ayy.axW = i;
        return this;
    }

    public final b aw(long j) {
        this.ayy.yU = j;
        return this;
    }

    public final b dl(int i) {
        this.ayy.ayo = i;
        return this;
    }

    public final b l(double d) {
        this.ayy.mL = d;
        return this;
    }

    public final b dv(String str) {
        this.ayy.ayq = str;
        return this;
    }

    public final b dm(int i) {
        this.ayy.ays = i;
        return this;
    }

    public final b dn(int i) {
        this.ayy.cW(i);
        return this;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final b m613do(int i) {
        this.ayy.ayu = i;
        return this;
    }

    public final b dp(int i) {
        this.ayy.Pm = i;
        return this;
    }

    public final b dq(int i) {
        this.ayy.ayw = i;
        return this;
    }

    public final b dr(int i) {
        this.ayy.Pl = i;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        if (this.ayy.Pk == null) {
            this.ayy.Pk = new a.C0392a();
        }
        this.ayy.Pk.a(adTemplate, str, str2, aVar);
        return this;
    }
}
