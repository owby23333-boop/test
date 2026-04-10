package com.xiaomi.passport.servicetoken;

import android.os.RemoteException;
import com.xiaomi.accountsdk.futureservice.ClientFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes8.dex */
public class ServiceTokenFuture extends ClientFuture<ServiceTokenResult, ServiceTokenResult> {

    public static abstract class ServiceTokenCallback implements ClientFuture.ClientCallback<ServiceTokenResult> {
        @Override // com.xiaomi.accountsdk.futureservice.ClientFuture.ClientCallback
        public final void call(ClientFuture<?, ServiceTokenResult> clientFuture) {
            call((ServiceTokenFuture) clientFuture);
        }

        public abstract void call(ServiceTokenFuture serviceTokenFuture);
    }

    public ServiceTokenFuture(ClientFuture.ClientCallback<ServiceTokenResult> clientCallback) {
        super(clientCallback);
    }

    private ServiceTokenResult getInternal(Long l, TimeUnit timeUnit) {
        try {
            return (l == null || timeUnit == null) ? (ServiceTokenResult) super.get() : (ServiceTokenResult) super.get(l.longValue(), timeUnit);
        } catch (InterruptedException e) {
            return new ServiceTokenResult.Builder(null).errorCode(ServiceTokenResult.ErrorCode.ERROR_CANCELLED).errorMessage(e.getMessage()).build();
        } catch (ExecutionException e2) {
            e = e2;
            if (e.getCause() instanceof RemoteException) {
                return new ServiceTokenResult.Builder(null).errorCode(ServiceTokenResult.ErrorCode.ERROR_REMOTE_EXCEPTION).errorMessage(e.getMessage()).build();
            }
            if (e.getCause() != null) {
                e = e.getCause();
            }
            return new ServiceTokenResult.Builder(null).errorCode(ServiceTokenResult.ErrorCode.ERROR_UNKNOWN).errorMessage(e.getMessage()).build();
        } catch (TimeoutException unused) {
            return new ServiceTokenResult.Builder(null).errorCode(ServiceTokenResult.ErrorCode.ERROR_TIME_OUT).errorMessage("time out after " + l + " " + timeUnit).build();
        }
    }

    @Override // com.xiaomi.accountsdk.futureservice.ClientFuture
    public ServiceTokenResult convertServerDataToClientData(ServiceTokenResult serviceTokenResult) throws Throwable {
        return serviceTokenResult;
    }

    @Override // com.xiaomi.accountsdk.futureservice.ClientFuture
    public void interpretExecutionException(ExecutionException executionException) throws Exception {
        throw new IllegalStateException("not going here");
    }

    @Override // com.xiaomi.accountsdk.futureservice.ClientFuture, java.util.concurrent.FutureTask, java.util.concurrent.Future
    public ServiceTokenResult get() {
        return getInternal(null, null);
    }

    @Override // com.xiaomi.accountsdk.futureservice.ClientFuture, java.util.concurrent.FutureTask, java.util.concurrent.Future
    public ServiceTokenResult get(long j, TimeUnit timeUnit) {
        return getInternal(Long.valueOf(j), timeUnit);
    }
}
