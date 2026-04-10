package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.NetworkException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.R;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

/* JADX INFO: loaded from: classes16.dex */
public class NetworkExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public NetworkExceptionHandler(Context context) {
        this.mContext = context;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey(CommonConstants.KEY_ERR_CODE)) {
            bundle.putInt(CommonConstants.KEY_ERR_CODE, 3);
        }
        if (!bundle.containsKey(CommonConstants.KEY_ERR_DESC)) {
            bundle.putString(CommonConstants.KEY_ERR_DESC, this.mContext.getString(R.string.mibi_error_network_summary));
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public Class<? extends Throwable> registeredException() {
        return NetworkException.class;
    }
}
