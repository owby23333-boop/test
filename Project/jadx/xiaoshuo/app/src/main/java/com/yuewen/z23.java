package com.yuewen;

import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class z23 extends CountDownTimer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f20673b = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Long> f20674a;

    public z23() {
        super(Long.MAX_VALUE, f20673b);
        this.f20674a = new MutableLiveData<>();
    }

    public MutableLiveData<Long> a() {
        return this.f20674a;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f20674a.postValue(Long.valueOf(j));
    }
}
