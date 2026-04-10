package androidx.window.reflection;

import android.util.Log;
import androidx.media3.exoplayer.offline.DownloadService;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ReflectionUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\n\u001a\u00020\u00042\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0000¢\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\rH\u0000¢\u0006\u0002\b\u0012J'\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0001¢\u0006\u0002\b\u0017J\u001d\u0010\u0018\u001a\u00020\u0004*\u00020\b2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\rH\u0000¢\u0006\u0002\b\u001aJ\u001d\u0010\u0018\u001a\u00020\u0004*\u00020\b2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001aR\u001c\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006\u001c"}, d2 = {"Landroidx/window/reflection/ReflectionUtils;", "", "()V", "isPublic", "", "Ljava/lang/reflect/Constructor;", "isPublic$window_release", "(Ljava/lang/reflect/Constructor;)Z", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Z", "checkIsPresent", "classLoader", "Lkotlin/Function0;", "Ljava/lang/Class;", "checkIsPresent$window_release", "validateImplementation", "implementation", DownloadService.KEY_REQUIREMENTS, "validateImplementation$window_release", "validateReflection", "errorMessage", "", "block", "validateReflection$window_release", "doesReturn", "clazz", "doesReturn$window_release", "Lkotlin/reflect/KClass;", "window_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE = new ReflectionUtils();

    private ReflectionUtils() {
    }

    public final boolean checkIsPresent$window_release(Function0<? extends Class<?>> classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        try {
            classLoader.invoke();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean validateReflection$window_release$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return validateReflection$window_release(str, function0);
    }

    @JvmStatic
    public static final boolean validateReflection$window_release(String errorMessage, Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            boolean zBooleanValue = block.invoke().booleanValue();
            if (!zBooleanValue && errorMessage != null) {
                Log.e("ReflectionGuard", errorMessage);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("ClassNotFound: ");
            if (errorMessage == null) {
                errorMessage = "";
            }
            Log.e("ReflectionGuard", sb.append(errorMessage).toString());
            return false;
        } catch (NoSuchMethodException unused2) {
            StringBuilder sb2 = new StringBuilder("NoSuchMethod: ");
            if (errorMessage == null) {
                errorMessage = "";
            }
            Log.e("ReflectionGuard", sb2.append(errorMessage).toString());
            return false;
        }
    }

    public final boolean isPublic$window_release(Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "<this>");
        return Modifier.isPublic(constructor.getModifiers());
    }

    public final boolean isPublic$window_release(Method method) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }

    public final boolean doesReturn$window_release(Method method, KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return doesReturn$window_release(method, JvmClassMappingKt.getJavaClass((KClass) clazz));
    }

    public final boolean doesReturn$window_release(Method method, Class<?> clazz) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return method.getReturnType().equals(clazz);
    }

    public final boolean validateImplementation$window_release(final Class<?> implementation, Class<?> requirements) {
        Intrinsics.checkNotNullParameter(implementation, "implementation");
        Intrinsics.checkNotNullParameter(requirements, "requirements");
        Method[] methods = requirements.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "requirements.methods");
        for (final Method method : methods) {
            if (!validateReflection$window_release(implementation.getName() + '#' + method.getName() + " is not valid", new Function0<Boolean>() { // from class: androidx.window.reflection.ReflectionUtils$validateImplementation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Removed duplicated region for block: B:7:0x003b  */
                @Override // kotlin.jvm.functions.Function0
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
                    /*
                        r4 = this;
                        java.lang.Class<?> r0 = r1
                        java.lang.reflect.Method r1 = r2
                        java.lang.String r1 = r1.getName()
                        java.lang.reflect.Method r2 = r2
                        java.lang.Class[] r2 = r2.getParameterTypes()
                        int r3 = r2.length
                        java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
                        java.lang.Class[] r2 = (java.lang.Class[]) r2
                        java.lang.reflect.Method r0 = r0.getMethod(r1, r2)
                        androidx.window.reflection.ReflectionUtils r1 = androidx.window.reflection.ReflectionUtils.INSTANCE
                        java.lang.String r2 = "implementedMethod"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                        boolean r1 = r1.isPublic$window_release(r0)
                        if (r1 == 0) goto L3b
                        androidx.window.reflection.ReflectionUtils r1 = androidx.window.reflection.ReflectionUtils.INSTANCE
                        java.lang.reflect.Method r2 = r2
                        java.lang.Class r2 = r2.getReturnType()
                        java.lang.String r3 = "it.returnType"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                        boolean r0 = r1.doesReturn$window_release(r0, r2)
                        if (r0 == 0) goto L3b
                        r0 = 1
                        goto L3c
                    L3b:
                        r0 = 0
                    L3c:
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.window.reflection.ReflectionUtils$validateImplementation$1$1.invoke():java.lang.Boolean");
                }
            })) {
                return false;
            }
        }
        return true;
    }
}
