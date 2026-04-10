package com.yuewen;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes12.dex */
public class by2 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f9470b;

    public interface a {
        void a(long j);
    }

    public by2(int i, a aVar) {
        super(Long.MAX_VALUE, i);
        this.f9469a = i;
        this.f9470b = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        a aVar = this.f9470b;
        if (aVar != null) {
            aVar.a(this.f9469a);
        }
    }
}
