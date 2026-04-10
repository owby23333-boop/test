package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.NoPrivacyRightException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.R;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

/* JADX INFO: loaded from: classes16.dex */
public class NoPrivacyRightExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public NoPrivacyRightExceptionHandler(Context context) {
        this.mContext = context;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        String string = this.mContext.getString(R.string.mibi_error_privacy_summary);
        bundle.putString(CommonConstants.KEY_ERR_DESC, string);
        bundle.putInt(CommonConstants.KEY_ERR_CODE, 18);
        if (handleNoPrivacyRightException(18, string)) {
            return true;
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }

    public boolean handleNoPrivacyRightException(int i, String str) {
        return false;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public Class<? extends PaymentException> registeredException() {
        return NoPrivacyRightException.class;
    }
}
