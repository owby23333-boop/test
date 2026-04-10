package com.yuewen;

import android.os.SystemClock;
import com.yuewen.ei1;
import com.yuewen.q7;

/* JADX INFO: loaded from: classes11.dex */
public class v7<D extends ei1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<D> f18906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q7.a f18907b;
    public long c;

    public interface a<D extends ei1> {
        D a();
    }

    public long a() {
        return this.c;
    }

    public q7.a b() {
        return this.f18907b;
    }

    public D c() {
        a<D> aVar = this.f18906a;
        if (aVar != null) {
            return (D) aVar.a();
        }
        return null;
    }

    public void d(q7.a aVar) {
        this.f18907b = aVar;
    }

    public void e(a<D> aVar) {
        this.f18906a = aVar;
        this.c = SystemClock.elapsedRealtime();
    }
}
