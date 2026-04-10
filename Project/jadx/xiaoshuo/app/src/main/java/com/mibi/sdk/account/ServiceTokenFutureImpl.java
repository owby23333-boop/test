package com.mibi.sdk.account;

import com.mibi.sdk.common.account.IServiceTokenFuture;
import com.mibi.sdk.common.account.IServiceTokenResult;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class ServiceTokenFutureImpl implements IServiceTokenFuture {
    private ServiceTokenFuture mServiceTokenFuture;

    public ServiceTokenFutureImpl(ServiceTokenFuture serviceTokenFuture) {
        this.mServiceTokenFuture = serviceTokenFuture;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenFuture
    public IServiceTokenResult get() {
        throw null;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenFuture
    public boolean isCancelled() {
        ServiceTokenFuture serviceTokenFuture = this.mServiceTokenFuture;
        return serviceTokenFuture != null && serviceTokenFuture.isCancelled();
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenFuture
    public boolean isDone() {
        ServiceTokenFuture serviceTokenFuture = this.mServiceTokenFuture;
        return serviceTokenFuture != null && serviceTokenFuture.isDone();
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenFuture
    public IServiceTokenResult get(long j, TimeUnit timeUnit) {
        return new ServiceTokenResultImpl(this.mServiceTokenFuture.get(j, timeUnit));
    }
}
