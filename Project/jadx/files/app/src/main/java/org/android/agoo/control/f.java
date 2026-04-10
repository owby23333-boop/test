package org.android.agoo.control;

import android.os.RemoteException;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class f implements Runnable {
    final /* synthetic */ AgooFactory.a a;

    f(AgooFactory.a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.ServiceConnection] */
    @Override // java.lang.Runnable
    public void run() {
        String str = "send finish. close this connection";
        String str2 = "AgooFactory";
        int i2 = 0;
        i2 = 0;
        try {
            try {
                ALog.d("AgooFactory", "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
                this.a.f21273d.doSend(this.a.b);
                Object[] objArr = new Object[0];
                ALog.d("AgooFactory", "send finish. close this connection", objArr);
                i2 = objArr;
            } catch (RemoteException e2) {
                ALog.e("AgooFactory", "send error", e2, new Object[0]);
                Object[] objArr2 = new Object[0];
                ALog.d("AgooFactory", "send finish. close this connection", objArr2);
                i2 = objArr2;
            }
            this.a.f21273d = null;
            str = AgooFactory.mContext;
            str2 = this.a.f21274e;
            str.unbindService(str2);
        } catch (Throwable th) {
            ALog.d(str2, str, new Object[i2]);
            this.a.f21273d = null;
            AgooFactory.mContext.unbindService(this.a.f21274e);
            throw th;
        }
    }
}
