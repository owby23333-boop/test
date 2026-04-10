package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ServerErrorCodeException;
import com.mibi.sdk.task.R;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

/* JADX INFO: loaded from: classes16.dex */
public class ServerErrorCodeExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public ServerErrorCodeExceptionHandler(Context context) {
        this.mContext = context;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        boolean zHandleServerErrorCodeError;
        if (!(th instanceof ServerErrorCodeException)) {
            throw new IllegalStateException();
        }
        ServerErrorCodeException serverErrorCodeException = (ServerErrorCodeException) th;
        int serverErrorCode = serverErrorCodeException.getServerErrorCode();
        if (serverErrorCode == 1992) {
            zHandleServerErrorCodeError = handleCallerVerifyError();
        } else if (serverErrorCode == 1993) {
            zHandleServerErrorCodeError = handleAccountFrozenError();
        } else if (serverErrorCode == 1569) {
            zHandleServerErrorCodeError = handleOrderExpiredError();
        } else if (serverErrorCode == 8000) {
            zHandleServerErrorCodeError = handleProcessExpiredError();
        } else {
            zHandleServerErrorCodeError = handleServerErrorCodeError(serverErrorCode, this.mContext.getString(R.string.mibi_error_server_summary), serverErrorCodeException.getResult());
        }
        if (zHandleServerErrorCodeError) {
            return true;
        }
        if (!bundle.containsKey(CommonConstants.KEY_ERR_CODE)) {
            bundle.putInt(CommonConstants.KEY_ERR_CODE, serverErrorCode);
        }
        if (!bundle.containsKey(CommonConstants.KEY_ERR_DESC)) {
            String serverErrorDesc = serverErrorCodeException.getServerErrorDesc();
            if (TextUtils.isEmpty(serverErrorDesc)) {
                serverErrorDesc = this.mContext.getString(R.string.mibi_error_server_summary);
            }
            bundle.putString(CommonConstants.KEY_ERR_DESC, serverErrorDesc);
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }

    public boolean handleAccountFrozenError() {
        return false;
    }

    public boolean handleCallerVerifyError() {
        return false;
    }

    public boolean handleOrderExpiredError() {
        return false;
    }

    public boolean handleProcessExpiredError() {
        return false;
    }

    public boolean handleServerErrorCodeError(int i, String str, Object obj) {
        return false;
    }

    @Override // com.mibi.sdk.task.handler.ExceptionDispatcher.ExceptionHandler
    public Class<? extends PaymentException> registeredException() {
        return ServerErrorCodeException.class;
    }
}
