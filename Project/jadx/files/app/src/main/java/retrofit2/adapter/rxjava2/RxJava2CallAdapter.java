package retrofit2.adapter.rxjava2;

import androidx.annotation.Nullable;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes4.dex */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;

    @Nullable
    private final Scheduler scheduler;

    RxJava2CallAdapter(Type type, @Nullable Scheduler scheduler, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.responseType = type;
        this.scheduler = scheduler;
        this.isAsync = z2;
        this.isResult = z3;
        this.isBody = z4;
        this.isFlowable = z5;
        this.isSingle = z6;
        this.isMaybe = z7;
        this.isCompletable = z8;
    }

    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        Observable callEnqueueObservable = this.isAsync ? new CallEnqueueObservable(call) : new CallExecuteObservable(call);
        Observable resultObservable = this.isResult ? new ResultObservable(callEnqueueObservable) : this.isBody ? new BodyObservable(callEnqueueObservable, call) : callEnqueueObservable;
        Scheduler scheduler = this.scheduler;
        if (scheduler != null) {
            resultObservable = resultObservable.subscribeOn(scheduler);
        }
        return this.isFlowable ? resultObservable.toFlowable(BackpressureStrategy.LATEST) : this.isSingle ? resultObservable.singleOrError() : this.isMaybe ? resultObservable.singleElement() : this.isCompletable ? resultObservable.ignoreElements() : resultObservable;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
