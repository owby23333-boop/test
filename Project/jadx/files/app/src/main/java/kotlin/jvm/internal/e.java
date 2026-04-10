package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CollectionToArray.kt */
/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "CollectionToArray")
public final class e {
    private static final Object[] a = new Object[0];

    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] a(@NotNull Collection<?> collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i4 = 2147483645;
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                    } else if (!it.hasNext()) {
                        return Arrays.copyOf(objArrCopyOf, i3);
                    }
                    i2 = i3;
                }
            }
        }
        return a;
    }

    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] a(@NotNull Collection<?> collection, @Nullable Object[] objArr) {
        Object[] objArrCopyOf;
        if (objArr != null) {
            int size = collection.size();
            int i2 = 0;
            if (size == 0) {
                if (objArr.length <= 0) {
                    return objArr;
                }
                objArr[0] = null;
                return objArr;
            }
            Iterator<?> it = collection.iterator();
            if (!it.hasNext()) {
                if (objArr.length <= 0) {
                    return objArr;
                }
                objArr[0] = null;
                return objArr;
            }
            if (size <= objArr.length) {
                objArrCopyOf = objArr;
            } else {
                Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
                objArrCopyOf = (Object[]) objNewInstance;
            }
            while (true) {
                int i3 = i2 + 1;
                objArrCopyOf[i2] = it.next();
                if (i3 >= objArrCopyOf.length) {
                    if (!it.hasNext()) {
                        return objArrCopyOf;
                    }
                    int i4 = ((i3 * 3) + 1) >>> 1;
                    if (i4 <= i3) {
                        if (i3 >= 2147483645) {
                            throw new OutOfMemoryError();
                        }
                        i4 = 2147483645;
                    }
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                } else if (!it.hasNext()) {
                    if (objArrCopyOf == objArr) {
                        objArr[i3] = null;
                        return objArr;
                    }
                    return Arrays.copyOf(objArrCopyOf, i3);
                }
                i2 = i3;
            }
        } else {
            throw new NullPointerException();
        }
    }
}
