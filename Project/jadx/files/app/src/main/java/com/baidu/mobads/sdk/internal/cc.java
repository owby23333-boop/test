package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.am;

/* JADX INFO: loaded from: classes2.dex */
class cc implements am.b {
    final /* synthetic */ double a;
    final /* synthetic */ bw b;

    cc(bw bwVar, double d2) {
        this.b = bwVar;
        this.a = d2;
    }

    @Override // com.baidu.mobads.sdk.internal.am.b
    public void a(String str, String str2) {
        this.b.f12990w = new bu(str);
        double dB = cj.b();
        float f2 = this.b.m().getFloat(bw.f12969c, 0.0f);
        Boolean boolValueOf = Boolean.valueOf(((float) this.b.f12990w.b()) == f2);
        Boolean boolValueOf2 = Boolean.valueOf(dB <= this.b.f12990w.b() && Math.floor(dB) == Math.floor(this.b.f12990w.b()));
        this.b.f12992z.a(bw.a, "try to download apk badVer=" + f2 + ", isBad=" + boolValueOf + ", compatible=" + boolValueOf2);
        if (this.a < this.b.f12990w.b() && this.b.f12990w != null && this.b.f12990w.a().booleanValue() && boolValueOf2.booleanValue() && !boolValueOf.booleanValue()) {
            bw bwVar = this.b;
            bwVar.a(bwVar.f12990w);
        } else if (this.b.A) {
            this.b.A = false;
            this.b.a(false, "Refused to download remote for version...");
        }
    }

    @Override // com.baidu.mobads.sdk.internal.am.b
    public void a(String str, int i2) {
        if (this.b.A) {
            this.b.A = false;
            this.b.a(false, "remote update Network access failed");
        }
    }
}
