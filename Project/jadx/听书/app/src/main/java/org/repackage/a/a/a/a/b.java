package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

/* JADX INFO: compiled from: OpenIDHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f2545a;

    public b(c cVar) {
        this.f2545a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2545a.f2546a = a.AbstractBinderC0510a.a(iBinder);
        synchronized (this.f2545a.d) {
            this.f2545a.d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2545a.f2546a = null;
    }
}
