package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.PasswordErrorException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.R;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

/* JADX INFO: loaded from: classes16.dex */
public class PasswordErrorExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    public static final int PASS_WORD_ERROR = 3;
    private Context mContext;

    public PasswordErrorExceptionHandler(Context context) {
        this.mContext = context;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey(CommonConstants.KEY_ERR_CODE)) {
            bundle.putInt(CommonConstants.KEY_ERR_CODE, 3);
        }
        if (!bundle.containsKey(CommonConstants.KEY_ERR_DESC)) {
            bundle.putString(CommonConstants.KEY_ERR_DESC, this.mContext.getString(R.string.mibi_password_error));
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public Class<? extends Throwable> registeredException() {
        return PasswordErrorException.class;
    }
}
