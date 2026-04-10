package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    private static final l a;

    static {
        l lVar = null;
        try {
            lVar = (l) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (lVar == null) {
            lVar = new l();
        }
        a = lVar;
    }

    public static kotlin.reflect.c a(Class cls) {
        return a.a(cls);
    }

    @SinceKotlin(version = "1.4")
    public static kotlin.reflect.e b(Class cls) {
        return a.a(cls, "");
    }

    @SinceKotlin(version = "1.1")
    public static String a(Lambda lambda) {
        return a.a(lambda);
    }

    public static KMutableProperty0 a(MutablePropertyReference0 mutablePropertyReference0) {
        a.a(mutablePropertyReference0);
        return mutablePropertyReference0;
    }
}
