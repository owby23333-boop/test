package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: compiled from: TypeIntrinsics.java */
/* JADX INFO: loaded from: classes3.dex */
public class n {
    private static <T extends Throwable> T a(T t2) {
        i.a((Throwable) t2, n.class.getName());
        return t2;
    }

    public static List b(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            a(e2);
            throw null;
        }
    }

    public static void a(Object obj, String str) {
        a((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        throw null;
    }

    public static void a(String str) {
        a(new ClassCastException(str));
        throw null;
    }

    public static ClassCastException a(ClassCastException classCastException) {
        a(classCastException);
        throw classCastException;
    }

    public static List a(Object obj) {
        if (obj instanceof kotlin.jvm.internal.o.a) {
            a(obj, "kotlin.collections.MutableList");
            throw null;
        }
        return b(obj);
    }
}
