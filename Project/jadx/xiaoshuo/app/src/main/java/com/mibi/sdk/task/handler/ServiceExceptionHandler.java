package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ServerException;
import com.mibi.sdk.task.R;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

/* JADX INFO: loaded from: classes16.dex */
public class ServiceExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public ServiceExceptionHandler(Context context) {
        this.mContext = context;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!(th instanceof ServerException)) {
            throw new IllegalStateException();
        }
        if (!bundle.containsKey(CommonConstants.KEY_ERR_CODE)) {
            bundle.putInt(CommonConstants.KEY_ERR_CODE, 6);
        }
        String str = this.mContext.getString(R.string.mibi_error_server_summary) + ((ServerException) th).getResponseCode();
        if (!bundle.containsKey(CommonConstants.KEY_ERR_DESC)) {
            bundle.putString(CommonConstants.KEY_ERR_DESC, str);
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public Class<? extends PaymentException> registeredException() {
        return ServerException.class;
    }
}
