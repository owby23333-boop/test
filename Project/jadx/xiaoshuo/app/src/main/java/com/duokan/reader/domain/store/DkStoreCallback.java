package com.duokan.reader.domain.store;

import com.duokan.reader.domain.payment.PaymentResult;
import com.yuewen.ng2;

/* JADX INFO: loaded from: classes3.dex */
public interface DkStoreCallback {

    public enum AbortPayErrorCode {
        NORMAL,
        REPEAT_PAY
    }

    void a(ng2 ng2Var, boolean z);

    void b(ng2 ng2Var, String str);

    void c(ng2 ng2Var, PaymentResult paymentResult);

    void d(ng2 ng2Var, String str, AbortPayErrorCode abortPayErrorCode);
}
