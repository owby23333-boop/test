package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.e;
import d.a.i;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b extends e.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Future<i> f543s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    NetworkResponse f544t;

    public b(Future<i> future) {
        this.f543s = future;
    }

    @Override // anetwork.channel.aidl.e
    public NetworkResponse a(long j2) throws RemoteException {
        Future<i> future = this.f543s;
        if (future == null) {
            NetworkResponse networkResponse = this.f544t;
            return networkResponse != null ? networkResponse : new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
        try {
            return (NetworkResponse) future.get(j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            if ("NO SUPPORT".equalsIgnoreCase(e2.getMessage())) {
                ALog.e("anet.ParcelableFutureResponse", "[get]有listener将不支持future.get()方法，如有需要请listener传入null", null, e2, new Object[0]);
            }
            return new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
    }

    @Override // anetwork.channel.aidl.e
    public boolean cancel(boolean z2) throws RemoteException {
        Future<i> future = this.f543s;
        if (future == null) {
            return true;
        }
        return future.cancel(z2);
    }

    @Override // anetwork.channel.aidl.e
    public boolean isCancelled() throws RemoteException {
        Future<i> future = this.f543s;
        if (future == null) {
            return true;
        }
        return future.isCancelled();
    }

    @Override // anetwork.channel.aidl.e
    public boolean isDone() throws RemoteException {
        Future<i> future = this.f543s;
        if (future == null) {
            return true;
        }
        return future.isDone();
    }
}
