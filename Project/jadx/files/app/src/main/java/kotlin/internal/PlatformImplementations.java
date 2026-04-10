package kotlin.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: kotlin.internal.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public class PlatformImplementations {

    /* JADX INFO: renamed from: kotlin.internal.a$a */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    private static final class a {

        @JvmField
        @Nullable
        public static final Method a;

        static {
            Method method;
            new a();
            Method[] methods = Throwable.class.getMethods();
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = methods[i2];
                if (i.a((Object) method.getName(), (Object) "addSuppressed") && i.a((Class) kotlin.collections.c.e(method.getParameterTypes()), Throwable.class)) {
                    break;
                } else {
                    i2++;
                }
            }
            a = method;
            int length2 = methods.length;
            for (int i3 = 0; i3 < length2 && !i.a((Object) methods[i3].getName(), (Object) "getSuppressed"); i3++) {
            }
        }

        private a() {
        }
    }

    public void a(@NotNull Throwable th, @NotNull Throwable th2) throws IllegalAccessException, InvocationTargetException {
        Method method = a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
