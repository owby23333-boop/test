package b;

import com.alipay.sdk.app.OpenAuthTask;
import com.mibi.sdk.common.CommonConstants;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    /* JADX INFO: Fake field, exist only in values array */
    MIPUSH_RECEIVED(1002),
    /* JADX INFO: Fake field, exist only in values array */
    BROADCAST_SENT(1003),
    RETRIEVAL_START(1004),
    RETRIEVAL_SUCCESS(1),
    RETRIEVAL_FAILED(2),
    BAD_PARAMETERS(4000),
    ZIP_FINISH(2001),
    ZIP_FAIL(OpenAuthTask.NOT_INSTALLED),
    /* JADX INFO: Fake field, exist only in values array */
    UPLOAD_FINISH(2002),
    /* JADX INFO: Fake field, exist only in values array */
    UPLOAD_FAIL(4002),
    /* JADX INFO: Fake field, exist only in values array */
    APP_NOT_INSTALLED(4003),
    WRITE_TO_MARKET_FINISH(CommonConstants.Mgc.DUPLICATE_RECHARGE_ERROR),
    WRITE_TO_MARKET_FAIL(4004),
    NO_MARKET_URI(4005),
    TIME_EXPIRED(4006),
    /* JADX INFO: Fake field, exist only in values array */
    EXCEPTION(4999);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1611a;

    d(int i) {
        this.f1611a = i;
    }
}
