package kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
final class SynchronizedLazyImpl<T> implements d<T>, Serializable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private kotlin.jvm.b.a<? extends T> f20935s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile Object f20936t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Object f20937u;

    public SynchronizedLazyImpl(@NotNull kotlin.jvm.b.a<? extends T> aVar, @Nullable Object obj) {
        this.f20935s = aVar;
        this.f20936t = i.a;
        this.f20937u = obj == null ? this : obj;
    }

    public boolean f() {
        return this.f20936t != i.a;
    }

    @Override // kotlin.d
    public T getValue() {
        T tInvoke;
        T t2 = (T) this.f20936t;
        if (t2 != i.a) {
            return t2;
        }
        synchronized (this.f20937u) {
            tInvoke = (T) this.f20936t;
            if (tInvoke == i.a) {
                tInvoke = this.f20935s.invoke();
                this.f20936t = tInvoke;
                this.f20935s = null;
            }
        }
        return tInvoke;
    }

    @NotNull
    public String toString() {
        return f() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(kotlin.jvm.b.a aVar, Object obj, int i2, kotlin.jvm.internal.f fVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
