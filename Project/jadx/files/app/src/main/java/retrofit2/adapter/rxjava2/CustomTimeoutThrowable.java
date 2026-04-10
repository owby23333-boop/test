package retrofit2.adapter.rxjava2;

import retrofit2.Call;

/* JADX INFO: loaded from: classes4.dex */
public class CustomTimeoutThrowable extends Throwable {
    public final Call call;

    CustomTimeoutThrowable(Throwable th, Call call) {
        super(th);
        this.call = call;
    }

    public Call getCall() {
        return this.call;
    }
}
