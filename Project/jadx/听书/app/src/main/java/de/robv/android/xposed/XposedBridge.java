package de.robv.android.xposed;

import android.util.Log;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodHook.Unhook;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import top.canyie.pine.Pine;
import top.canyie.pine.callback.MethodHook;
import top.canyie.pine.xposed.PineXposed;

/* JADX INFO: loaded from: classes5.dex */
public final class XposedBridge {
    public static final String TAG = "PineXposed";
    private static String[] sSupportedFeatures = new String[0];
    public static final ClassLoader BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();

    @Deprecated
    public static int XPOSED_BRIDGE_VERSION = 90;
    private static final Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> sHookedMethodCallbacks = new HashMap();
    private static HookProvider hookProvider = HookProvider.PINE;

    public static final class CopyOnWriteSortedSet<E> {
        private volatile transient Object[] elements = Pine.EMPTY_OBJECT_ARRAY;

        private int indexOf(Object obj) {
            for (int i = 0; i < this.elements.length; i++) {
                if (obj.equals(this.elements[i])) {
                    return i;
                }
            }
            return -1;
        }

        public synchronized boolean add(E e) {
            if (indexOf(e) >= 0) {
                return false;
            }
            Object[] objArr = new Object[this.elements.length + 1];
            System.arraycopy(this.elements, 0, objArr, 0, this.elements.length);
            objArr[this.elements.length] = e;
            Arrays.sort(objArr);
            this.elements = objArr;
            return true;
        }

        public Object[] getSnapshot() {
            return this.elements;
        }

        public synchronized boolean remove(E e) {
            int iIndexOf = indexOf(e);
            if (iIndexOf == -1) {
                return false;
            }
            Object[] objArr = new Object[this.elements.length - 1];
            System.arraycopy(this.elements, 0, objArr, 0, iIndexOf);
            System.arraycopy(this.elements, iIndexOf + 1, objArr, iIndexOf, (this.elements.length - iIndexOf) - 1);
            this.elements = objArr;
            return true;
        }
    }

    public static final class Handler extends MethodHook {
        private final CopyOnWriteSortedSet<XC_MethodHook> callbacks;
        private final ThreadLocal<ExtData> extDataHolder = new ThreadLocal<>();

        public static final class ExtData {
            int afterIdx;
            Object[] callbacks;
            XC_MethodHook.MethodHookParam param;
        }

        public Handler(CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet) {
            this.callbacks = copyOnWriteSortedSet;
        }

        @Override // top.canyie.pine.callback.MethodHook
        public void afterCall(Pine.CallFrame callFrame) {
            Object[] objArr;
            ExtData extData = this.extDataHolder.get();
            if (extData == null || (objArr = extData.callbacks) == null) {
                return;
            }
            XC_MethodHook.MethodHookParam methodHookParam = extData.param;
            int i = extData.afterIdx;
            methodHookParam.thisObject = callFrame.thisObject;
            methodHookParam.args = callFrame.args;
            if (callFrame.hasThrowable()) {
                methodHookParam.setThrowable(callFrame.getThrowable());
            } else {
                methodHookParam.setResult(callFrame.getResult());
            }
            do {
                Object result = methodHookParam.getResult();
                Throwable throwable = methodHookParam.getThrowable();
                try {
                    ((XC_MethodHook) objArr[i]).afterHookedMethod(methodHookParam);
                } catch (Throwable th) {
                    XposedBridge.log(th);
                    if (throwable == null) {
                        methodHookParam.setResult(result);
                    } else {
                        methodHookParam.setThrowable(throwable);
                    }
                }
                i--;
            } while (i >= 0);
            callFrame.thisObject = methodHookParam.thisObject;
            callFrame.args = methodHookParam.args;
            if (methodHookParam.hasThrowable()) {
                callFrame.setThrowable(methodHookParam.getThrowable());
            } else {
                callFrame.setResult(methodHookParam.getResult());
            }
            extData.callbacks = null;
            extData.param = null;
            extData.afterIdx = 0;
        }

        @Override // top.canyie.pine.callback.MethodHook
        public void beforeCall(Pine.CallFrame callFrame) {
            Object[] snapshot;
            int length;
            if (PineXposed.disableHooks || (length = (snapshot = this.callbacks.getSnapshot()).length) == 0) {
                return;
            }
            ExtData extData = this.extDataHolder.get();
            if (extData == null) {
                extData = new ExtData();
                this.extDataHolder.set(extData);
            }
            XC_MethodHook.MethodHookParam methodHookParam = new XC_MethodHook.MethodHookParam();
            methodHookParam.method = callFrame.method;
            methodHookParam.thisObject = callFrame.thisObject;
            methodHookParam.args = callFrame.args;
            int i = 0;
            while (true) {
                try {
                    ((XC_MethodHook) snapshot[i]).beforeHookedMethod(methodHookParam);
                } catch (Throwable th) {
                    XposedBridge.log(th);
                    methodHookParam.setResult(null);
                    methodHookParam.returnEarly = false;
                }
                if (methodHookParam.returnEarly) {
                    i++;
                    break;
                } else {
                    i++;
                    if (i >= length) {
                        break;
                    }
                }
            }
            callFrame.thisObject = methodHookParam.thisObject;
            callFrame.args = methodHookParam.args;
            if (methodHookParam.returnEarly) {
                if (methodHookParam.hasThrowable()) {
                    callFrame.setThrowable(methodHookParam.getThrowable());
                } else {
                    callFrame.setResult(methodHookParam.getResult());
                }
            }
            extData.callbacks = snapshot;
            extData.param = methodHookParam;
            extData.afterIdx = i - 1;
        }
    }

    public interface HookProvider {
        public static final HookProvider PINE = new HookProvider() { // from class: de.robv.android.xposed.XposedBridge.HookProvider.1
            @Override // de.robv.android.xposed.XposedBridge.HookProvider
            public void hook(Member member, CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet) {
                Pine.hook(member, new Handler(copyOnWriteSortedSet));
            }

            @Override // de.robv.android.xposed.XposedBridge.HookProvider
            public Object invokeOriginal(Member member, Object obj, Object[] objArr) {
                return Pine.invokeOriginalMethod(member, obj, objArr);
            }
        };

        void hook(Member member, CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet);

        Object invokeOriginal(Member member, Object obj, Object[] objArr);
    }

    private XposedBridge() {
    }

    public static void deoptimizeMethod(Member member) {
        Pine.decompile(member, true);
    }

    public static HookProvider getHookProvider() {
        return hookProvider;
    }

    public static String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    public static int getXposedVersion() {
        return XPOSED_BRIDGE_VERSION;
    }

    public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> cls, XC_MethodHook xC_MethodHook) {
        HashSet hashSet = new HashSet();
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            hashSet.add(hookMethod(constructor, xC_MethodHook));
        }
        return hashSet;
    }

    public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> cls, String str, XC_MethodHook xC_MethodHook) {
        HashSet hashSet = new HashSet();
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str)) {
                hashSet.add(hookMethod(method, xC_MethodHook));
            }
        }
        return hashSet;
    }

    public static XC_MethodHook.Unhook hookMethod(Member member, XC_MethodHook xC_MethodHook) {
        CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet;
        boolean z;
        if (!(member instanceof Method) && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("Only methods and constructors can be hooked: " + member.toString());
        }
        if (Modifier.isAbstract(member.getModifiers())) {
            throw new IllegalArgumentException("Cannot hook abstract methods: " + member.toString());
        }
        Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> map = sHookedMethodCallbacks;
        synchronized (map) {
            copyOnWriteSortedSet = map.get(member);
            if (copyOnWriteSortedSet == null) {
                copyOnWriteSortedSet = new CopyOnWriteSortedSet<>();
                map.put(member, copyOnWriteSortedSet);
                z = true;
            } else {
                z = false;
            }
        }
        copyOnWriteSortedSet.add(xC_MethodHook);
        if (z) {
            hookProvider.hook(member, copyOnWriteSortedSet);
        }
        Objects.requireNonNull(xC_MethodHook);
        return xC_MethodHook.new Unhook(member);
    }

    public static Object invokeOriginalMethod(Member member, Object obj, Object[] objArr) {
        return hookProvider.invokeOriginal(member, obj, objArr);
    }

    public static boolean isFeatureSupported(String str) {
        for (String str2 : sSupportedFeatures) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized void log(String str) {
        Log.i("PineXposed", str);
    }

    public static synchronized void log(Throwable th) {
        Log.e("PineXposed", Log.getStackTraceString(th));
    }

    public static void setHookProvider(HookProvider hookProvider2) {
        hookProvider = hookProvider2;
    }

    public static void setSupportedFeatures(String[] strArr) {
        sSupportedFeatures = strArr;
    }

    public static void setXposedVersion(int i) {
        XPOSED_BRIDGE_VERSION = i;
    }

    @Deprecated
    public static void unhookMethod(Member member, XC_MethodHook xC_MethodHook) {
        Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> map = sHookedMethodCallbacks;
        synchronized (map) {
            CopyOnWriteSortedSet<XC_MethodHook> copyOnWriteSortedSet = map.get(member);
            if (copyOnWriteSortedSet == null) {
                return;
            }
            copyOnWriteSortedSet.remove(xC_MethodHook);
        }
    }
}
