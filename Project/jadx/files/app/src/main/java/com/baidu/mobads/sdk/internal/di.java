package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes2.dex */
class di extends CountDownTimer {
    final /* synthetic */ dg a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    di(dg dgVar, long j2, long j3) {
        super(j2, j3);
        this.a = dgVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.a.b.a("CountDownTimer finished");
        this.a.c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        int i2 = (int) (j2 / 1000);
        this.a.f13100d.setText(String.valueOf(i2 <= 5 ? i2 : 5));
    }
}
