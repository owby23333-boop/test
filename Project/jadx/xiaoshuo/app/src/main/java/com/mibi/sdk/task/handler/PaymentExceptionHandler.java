package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.R;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

/* JADX INFO: loaded from: classes16.dex */
public abstract class PaymentExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    protected Context mContext;

    public PaymentExceptionHandler(Context context) {
        this.mContext = context;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey(CommonConstants.KEY_ERR_CODE)) {
            bundle.putInt(CommonConstants.KEY_ERR_CODE, 5);
        }
        if (!bundle.containsKey(CommonConstants.KEY_ERR_DESC)) {
            bundle.putString(CommonConstants.KEY_ERR_DESC, this.mContext.getString(R.string.mibi_error_auth_summary));
        }
        handleError(bundle.getInt(CommonConstants.KEY_ERR_CODE), bundle.getString(CommonConstants.KEY_ERR_DESC) + "[" + ((PaymentException) th).getFullIdentifier() + "]", th);
        return true;
    }

    public abstract void handleError(int i, String str, Throwable th);

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public Class<? extends Throwable> registeredException() {
        return PaymentException.class;
    }
}
