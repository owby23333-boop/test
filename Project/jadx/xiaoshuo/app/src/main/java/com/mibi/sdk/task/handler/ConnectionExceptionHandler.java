package com.mibi.sdk.task.handler;

import android.os.Bundle;
import com.mibi.sdk.common.exception.CertificateDateNotValidException;
import com.mibi.sdk.common.exception.ConnectionException;
import com.mibi.sdk.common.exception.NetworkException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

/* JADX INFO: loaded from: classes16.dex */
public class ConnectionExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!(th instanceof ConnectionException)) {
            throw new IllegalStateException();
        }
        Throwable cause = th.getCause();
        return cause instanceof CertificateDateNotValidException ? exceptionDispatcher.dispatchAs(cause, bundle, CertificateDateNotValidException.class) : exceptionDispatcher.dispatchAs(th, bundle, NetworkException.class);
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public Class<? extends Throwable> registeredException() {
        return ConnectionException.class;
    }
}
