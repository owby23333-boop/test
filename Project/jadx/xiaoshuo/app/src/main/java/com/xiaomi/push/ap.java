package com.xiaomi.push;

import android.os.IBinder;
import com.xiaomi.push.an;

/* JADX INFO: loaded from: classes8.dex */
class ap implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBinder f7797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ an.a f140a;

    public ap(an.a aVar, IBinder iBinder) {
        this.f140a = aVar;
        this.f7797a = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            an.this.f138a = an.b.a(this.f7797a);
            an.this.f139b = an.b.m196a(this.f7797a);
            an.this.b();
            an.this.f134a = 2;
            synchronized (an.this.f137a) {
                try {
                    an.this.f137a.notifyAll();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            an.this.b();
            an.this.f134a = 2;
            synchronized (an.this.f137a) {
                try {
                    an.this.f137a.notifyAll();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            an.this.b();
            an.this.f134a = 2;
            synchronized (an.this.f137a) {
                try {
                    an.this.f137a.notifyAll();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
    }
}
