package com.mibi.sdk.common.exception;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.utils.MibiLog;
import com.xiaomi.ad.common.util.SignatureUtils;

/* JADX INFO: loaded from: classes13.dex */
public abstract class PaymentException extends Exception {
    private static final String SPLIT = "|";
    private static final String TAG = "PaymentException";
    private String mFullIdentifier;

    public PaymentException() {
    }

    public abstract int getErrorCode();

    public String getErrorSummary(Context context) {
        return context.getString(getErrorSummaryRes());
    }

    public abstract int getErrorSummaryRes();

    public String getFullIdentifier() {
        if (TextUtils.isEmpty(this.mFullIdentifier)) {
            String identifier = getIdentifier();
            Throwable cause = getCause();
            if (cause != null && (cause instanceof PaymentException)) {
                identifier = (identifier + "|") + ((PaymentException) cause).getFullIdentifier();
            }
            this.mFullIdentifier = identifier;
        }
        return this.mFullIdentifier;
    }

    public abstract String getIdentifier();

    public Throwable getRootCause() {
        Throwable th = null;
        for (Throwable cause = this; cause != null; cause = cause.getCause()) {
            th = cause;
        }
        return th;
    }

    public String getSimpleStackTrace() {
        StringBuilder sb = new StringBuilder();
        for (Throwable cause = this; cause != null; cause = cause.getCause()) {
            if (cause != this) {
                sb.append("\tCaused by ");
            }
            sb.append(cause.toString() + SignatureUtils.DELIMITER);
        }
        return sb.toString();
    }

    public void print() {
        MibiLog.d(TAG, "error " + getErrorCode());
        if (CommonConstants.DEBUG) {
            printStackTrace();
        } else {
            printSimpleStackTrace();
        }
    }

    public void printSimpleStackTrace() {
        System.err.append((CharSequence) getSimpleStackTrace());
    }

    public PaymentException(String str) {
        super(str);
    }

    public PaymentException(String str, Throwable th) {
        super(str, th);
    }

    public PaymentException(Throwable th) {
        super(th);
    }
}
