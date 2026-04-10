package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;

/* JADX INFO: compiled from: Intrinsics.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    private i() {
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static String a(String str, Object obj) {
        return str + obj;
    }

    public static void a() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        a(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static <T extends Throwable> T a(T t2) {
        a((Throwable) t2, i.class.getName());
        return t2;
    }

    static <T extends Throwable> T a(T t2, String str) {
        StackTraceElement[] stackTrace = t2.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t2.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t2;
    }
}
