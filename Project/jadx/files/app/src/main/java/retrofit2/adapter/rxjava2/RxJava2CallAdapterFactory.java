package retrofit2.adapter.rxjava2;

import androidx.annotation.Nullable;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes4.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;

    @Nullable
    private final Scheduler scheduler;

    private RxJava2CallAdapterFactory(@Nullable Scheduler scheduler, boolean z2) {
        this.scheduler = scheduler;
        this.isAsync = z2;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            return new RxJava2CallAdapterFactory(scheduler, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type parameterUpperBound;
        boolean z2;
        boolean z3;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean z4 = rawType == Flowable.class;
        boolean z5 = rawType == Single.class;
        boolean z6 = rawType == Maybe.class;
        if (rawType != Observable.class && !z4 && !z5 && !z6) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z4 ? !z5 ? z6 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound2);
        if (rawType2 == Response.class) {
            if (!(parameterUpperBound2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound2);
            z2 = false;
        } else {
            if (rawType2 != Result.class) {
                parameterUpperBound = parameterUpperBound2;
                z2 = false;
                z3 = true;
                return new RxJava2CallAdapter(parameterUpperBound, this.scheduler, this.isAsync, z2, z3, z4, z5, z6, false);
            }
            if (!(parameterUpperBound2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound2);
            z2 = true;
        }
        z3 = false;
        return new RxJava2CallAdapter(parameterUpperBound, this.scheduler, this.isAsync, z2, z3, z4, z5, z6, false);
    }
}
