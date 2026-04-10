package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {
    public kotlin.reflect.e a(Class cls, String str) {
        return new j(cls, str);
    }

    public KMutableProperty0 a(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.c a(Class cls) {
        return new ClassReference(cls);
    }

    @SinceKotlin(version = "1.1")
    public String a(Lambda lambda) {
        return a((g) lambda);
    }

    @SinceKotlin(version = "1.3")
    public String a(g gVar) {
        String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
