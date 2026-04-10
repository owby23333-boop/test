package com.yuewen;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes5.dex */
public class z81 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f20709a;

    public interface a {
        void a(long j);

        void onFinish();
    }

    public z81(long j, long j2, a aVar) {
        super(j, j2);
        this.f20709a = aVar;
    }

    public static z81 a(long j, a aVar) {
        return new z81(j, 2147483647L, aVar);
    }

    public static z81 b(long j, long j2, a aVar) {
        return new z81(j, j2, aVar);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        a aVar = this.f20709a;
        if (aVar != null) {
            aVar.onFinish();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        a aVar = this.f20709a;
        if (aVar != null) {
            aVar.a(j);
        }
    }
}
