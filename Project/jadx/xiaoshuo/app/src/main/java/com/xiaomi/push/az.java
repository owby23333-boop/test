package com.xiaomi.push;

import android.os.IBinder;
import com.xiaomi.push.ax;

/* JADX INFO: loaded from: classes8.dex */
class az implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBinder f7811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ ax.b f162a;

    public az(ax.b bVar, IBinder iBinder) {
        this.f162a = bVar;
        this.f7811a = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String packageName = ax.this.f157a.getPackageName();
            String strB = ax.this.b();
            ax.a aVar = new ax.a();
            aVar.f7809b = ax.c.a(this.f7811a, packageName, strB, "OUID");
            ax.this.f159a = aVar;
            ax.this.m201b();
            ax.this.f156a = 2;
            synchronized (ax.this.f160a) {
                try {
                    ax.this.f160a.notifyAll();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            ax.this.m201b();
            ax.this.f156a = 2;
            synchronized (ax.this.f160a) {
                try {
                    ax.this.f160a.notifyAll();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            ax.this.m201b();
            ax.this.f156a = 2;
            synchronized (ax.this.f160a) {
                try {
                    ax.this.f160a.notifyAll();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
    }
}
