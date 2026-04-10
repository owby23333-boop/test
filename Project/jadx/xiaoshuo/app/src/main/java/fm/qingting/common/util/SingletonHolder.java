package fm.qingting.common.util;

import com.yuewen.openapi.track.TrackConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H$¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\tR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0088\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Lfm/qingting/common/util/SingletonHolder;", "Singleton", "Param", "", "()V", "instance", "Ljava/lang/Object;", "createInstance", TrackConstants.PARAM, "(Ljava/lang/Object;)Ljava/lang/Object;", "getInstance", "arg", "commonutils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class SingletonHolder<Singleton, Param> {

    @Nullable
    private volatile Singleton instance;

    public abstract Singleton createInstance(Param param);

    public final Singleton getInstance(Param arg) {
        Singleton singletonCreateInstance;
        Singleton singleton = this.instance;
        if (singleton != null) {
            return singleton;
        }
        synchronized (this) {
            singletonCreateInstance = this.instance;
            if (singletonCreateInstance == null) {
                singletonCreateInstance = createInstance(arg);
                this.instance = singletonCreateInstance;
            }
        }
        return singletonCreateInstance;
    }
}
