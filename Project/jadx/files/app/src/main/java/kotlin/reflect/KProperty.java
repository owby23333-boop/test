package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: renamed from: kotlin.reflect.i, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u000e\u000fR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\u000bR\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/KProperty;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/KCallable;", "getter", "Lkotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "isConst", "", "isConst$annotations", "()V", "()Z", "isLateinit", "isLateinit$annotations", "Accessor", "Getter", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public interface KProperty<V> extends kotlin.reflect.b<V> {

    /* JADX INFO: renamed from: kotlin.reflect.i$a */
    /* JADX INFO: compiled from: KProperty.kt */
    public interface a<V> {
    }

    /* JADX INFO: renamed from: kotlin.reflect.i$b */
    /* JADX INFO: compiled from: KProperty.kt */
    public interface b<V> extends a<V>, f<V> {
    }

    boolean isConst();

    boolean isLateinit();
}
