package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.b.l;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: kotlin.reflect.h, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fJ\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lkotlin/reflect/KMutableProperty0;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty0$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty0$Setter;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    /* JADX INFO: renamed from: kotlin.reflect.h$a */
    /* JADX INFO: compiled from: KProperty.kt */
    public interface a<V> extends KMutableProperty.a<V>, l<V, kotlin.j> {
    }

    @NotNull
    a<V> getSetter();
}
