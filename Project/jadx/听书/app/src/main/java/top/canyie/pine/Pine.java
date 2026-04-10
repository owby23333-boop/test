package top.canyie.pine;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import top.canyie.pine.callback.MethodHook;
import top.canyie.pine.callback.MethodHook.Unhook;
import top.canyie.pine.entry.Arm64MarshmallowEntry;

/* JADX INFO: loaded from: classes5.dex */
public final class Pine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ARCH_ARM = 1;
    private static final int ARCH_ARM64 = 2;
    private static final int ARCH_X86 = 3;
    private static final String TAG = "Pine";
    private static int arch;
    public static long closeElf;
    public static long findElfSymbol;
    public static long getMethodDeclaringClass;
    private static volatile int hookMode;
    private static volatile boolean initialized;
    public static long openElf;
    public static long resumeVM;
    private static HookListener sHookListener;
    public static long suspendVM;
    public static long syncMethodEntry;
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static final Map<String, Method> sBridgeMethods = new HashMap(8, 2.0f);
    private static final Map<Long, HookRecord> sHookRecords = new ConcurrentHashMap();
    private static final Object sHookLock = new Object();
    private static HookHandler sHookHandler = new HookHandler() { // from class: top.canyie.pine.Pine.1
        @Override // top.canyie.pine.Pine.HookHandler
        public MethodHook.Unhook handleHook(HookRecord hookRecord, MethodHook methodHook, int i, boolean z, boolean z2) {
            if (z) {
                Pine.hookNewMethod(hookRecord, i, z2);
            }
            if (methodHook == null) {
                return null;
            }
            hookRecord.addCallback(methodHook);
            return methodHook.new Unhook(hookRecord);
        }

        @Override // top.canyie.pine.Pine.HookHandler
        public void handleUnhook(HookRecord hookRecord, MethodHook methodHook) {
            hookRecord.removeCallback(methodHook);
        }
    };

    public static class CallFrame {
        public Object[] args;
        private HookRecord hookRecord;
        public final Member method;
        private Object result;
        boolean returnEarly;
        public Object thisObject;
        private Throwable throwable;

        public CallFrame(HookRecord hookRecord, Object obj, Object[] objArr) {
            this.hookRecord = hookRecord;
            this.method = hookRecord.target;
            this.thisObject = obj;
            this.args = objArr;
        }

        public Object getResult() {
            return this.result;
        }

        public Object getResultOrThrowable() throws Throwable {
            Throwable th = this.throwable;
            if (th == null) {
                return this.result;
            }
            throw th;
        }

        public Throwable getThrowable() {
            return this.throwable;
        }

        public boolean hasThrowable() {
            return this.throwable != null;
        }

        public Object invokeOriginalMethod() {
            return Pine.callBackupMethod(this.hookRecord, this.thisObject, this.args);
        }

        public Object invokeOriginalMethod(Object obj, Object... objArr) {
            return Pine.callBackupMethod(this.hookRecord, obj, objArr);
        }

        public void resetResult() {
            this.result = null;
            this.throwable = null;
            this.returnEarly = false;
        }

        public void setResult(Object obj) {
            this.result = obj;
            this.throwable = null;
            this.returnEarly = true;
        }

        public void setResultIfNoException(Object obj) {
            if (this.throwable == null) {
                this.result = obj;
                this.returnEarly = true;
            }
        }

        public void setThrowable(Throwable th) {
            this.throwable = th;
            this.result = null;
            this.returnEarly = true;
        }
    }

    public interface HookHandler {
        MethodHook.Unhook handleHook(HookRecord hookRecord, MethodHook methodHook, int i, boolean z, boolean z2);

        void handleUnhook(HookRecord hookRecord, MethodHook methodHook);
    }

    public interface HookListener {
        void afterHook(Member member, MethodHook.Unhook unhook);

        void beforeHook(Member member, MethodHook methodHook);
    }

    public interface HookMode {
        public static final int AUTO = 0;

        @Deprecated
        public static final int INLINE = 1;
        public static final int INLINE_WITHOUT_JIT = 3;
        public static final int REPLACEMENT = 2;
    }

    public static final class HookRecord {
        public final long artMethod;
        public Method backup;
        public Method bridge;
        private Set<MethodHook> callbacks = new HashSet();
        public boolean isStatic;
        public int paramNumber;
        public Class<?>[] paramTypes;
        public volatile Object paramTypesCache;
        public boolean skipUpdateDeclaringClass;
        public final Member target;
        public long trampoline;

        public HookRecord(Member member, long j) {
            this.target = member;
            this.artMethod = j;
        }

        public synchronized void addCallback(MethodHook methodHook) {
            this.callbacks.add(methodHook);
        }

        public Object callBackup(Object obj, Object... objArr) {
            return Pine.callBackupMethod(this, obj, objArr);
        }

        public synchronized boolean emptyCallbacks() {
            return this.callbacks.isEmpty();
        }

        public synchronized MethodHook[] getCallbacks() {
            Set<MethodHook> set;
            set = this.callbacks;
            return (MethodHook[]) set.toArray(new MethodHook[set.size()]);
        }

        public boolean isPending() {
            return this.backup == null;
        }

        public synchronized void removeCallback(MethodHook methodHook) {
            this.callbacks.remove(methodHook);
        }
    }

    public interface LibLoader {
        void loadLib();
    }

    private Pine() {
        throw new RuntimeException("Use static methods");
    }

    public static Object callBackupMethod(HookRecord hookRecord, Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        Member member = hookRecord.target;
        Method method = hookRecord.backup;
        Class<?> declaringClass = member.getDeclaringClass();
        syncMethodInfo(member, method, hookRecord.skipUpdateDeclaringClass);
        Object objInvoke = method.invoke(obj, objArr);
        declaringClass.getClass();
        return objInvoke;
    }

    public static native long cloneExtras(long j);

    public static boolean compile(Member member) {
        int modifiers = member.getModifiers();
        Class<?> declaringClass = member.getDeclaringClass();
        if (!(member instanceof Method) && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("Only methods and constructors can be compiled: " + member);
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new IllegalArgumentException("Cannot compile abstract methods: " + member);
        }
        if (Modifier.isNative(modifiers) || Proxy.isProxyClass(declaringClass)) {
            return false;
        }
        ensureInitialized();
        return compile0(currentArtThread0(), member);
    }

    private static native boolean compile0(long j, Member member);

    public static native long currentArtThread0();

    public static boolean decompile(Member member, boolean z) {
        int modifiers = member.getModifiers();
        Class<?> declaringClass = member.getDeclaringClass();
        if (!(member instanceof Method) && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("Only methods and constructors can be decompiled: " + member);
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new IllegalArgumentException("Cannot decompile abstract methods: " + member);
        }
        if (Proxy.isProxyClass(declaringClass)) {
            return false;
        }
        ensureInitialized();
        return decompile0(member, z);
    }

    private static native boolean decompile0(Member member, boolean z);

    public static void disableHiddenApiPolicy(boolean z, boolean z2) {
        if (initialized) {
            disableHiddenApiPolicy0(z, z2);
            return;
        }
        PineConfig.disableHiddenApiPolicy = z;
        PineConfig.disableHiddenApiPolicyForPlatformDomain = z2;
        ensureInitialized();
    }

    private static native void disableHiddenApiPolicy0(boolean z, boolean z2);

    @Deprecated
    public static boolean disableJitInline() {
        ensureInitialized();
        return false;
    }

    private static native boolean disableJitInline0();

    public static boolean disableProfileSaver() {
        if (PineConfig.sdkLevel < 24) {
            return false;
        }
        ensureInitialized();
        return disableProfileSaver0();
    }

    private static native boolean disableProfileSaver0();

    private static native void enableFastNative();

    public static void ensureInitialized() {
        if (initialized) {
            return;
        }
        synchronized (Pine.class) {
            if (initialized) {
                return;
            }
            initialize();
            initialized = true;
        }
    }

    public static long getAddress(long j, Object obj) {
        if (obj == null) {
            return 0L;
        }
        return getAddress0(j, obj);
    }

    private static native long getAddress0(long j, Object obj);

    public static native void getArgsArm32(int i, int i2, int[] iArr, int[] iArr2, float[] fArr);

    public static native void getArgsArm64(long j, long j2, boolean[] zArr, long[] jArr, long[] jArr2, double[] dArr);

    public static native void getArgsX86(int i, int[] iArr, int i2);

    public static native long getArtMethod(Member member);

    public static HookHandler getHookHandler() {
        return sHookHandler;
    }

    public static HookListener getHookListener() {
        return sHookListener;
    }

    public static int getHookMode() {
        return hookMode;
    }

    public static HookRecord getHookRecord(long j) {
        HookRecord hookRecord = sHookRecords.get(Long.valueOf(j));
        if (hookRecord != null) {
            return hookRecord;
        }
        throw new AssertionError("No HookRecord found for ArtMethod pointer 0x" + Long.toHexString(j));
    }

    public static Object getObject(long j, long j2) {
        if (j2 == 0) {
            return null;
        }
        return getObject0(j, j2);
    }

    private static native Object getObject0(long j, long j2);

    public static Object handleCall(HookRecord hookRecord, Object obj, Object[] objArr) throws Throwable {
        if (PineConfig.debug) {
            Log.d(TAG, "handleCall for method " + hookRecord.target);
        }
        if (PineConfig.disableHooks || hookRecord.emptyCallbacks()) {
            try {
                return callBackupMethod(hookRecord, obj, objArr);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        }
        CallFrame callFrame = new CallFrame(hookRecord, obj, objArr);
        MethodHook[] callbacks = hookRecord.getCallbacks();
        int i = 0;
        while (true) {
            MethodHook methodHook = callbacks[i];
            try {
                methodHook.beforeCall(callFrame);
            } catch (Throwable th) {
                Log.e(TAG, "Unexpected exception occurred when calling " + methodHook.getClass().getName() + ".beforeCall()", th);
                callFrame.resetResult();
            }
            if (callFrame.returnEarly) {
                i++;
                break;
            }
            i++;
            if (i >= callbacks.length) {
                break;
            }
        }
        if (!callFrame.returnEarly) {
            try {
                callFrame.setResult(callFrame.invokeOriginalMethod());
            } catch (InvocationTargetException e2) {
                callFrame.setThrowable(e2.getTargetException());
            }
        }
        int i2 = i - 1;
        do {
            MethodHook methodHook2 = callbacks[i2];
            Object result = callFrame.getResult();
            Throwable throwable = callFrame.getThrowable();
            try {
                methodHook2.afterCall(callFrame);
            } catch (Throwable th2) {
                Log.e(TAG, "Unexpected exception occurred when calling " + methodHook2.getClass().getName() + ".afterCall()", th2);
                if (throwable == null) {
                    callFrame.setResult(result);
                } else {
                    callFrame.setThrowable(throwable);
                }
            }
            i2--;
        } while (i2 >= 0);
        if (callFrame.hasThrowable()) {
            throw callFrame.getThrowable();
        }
        return callFrame.getResult();
    }

    public static MethodHook.Unhook hook(Member member, MethodHook methodHook) {
        return hook(member, methodHook, true);
    }

    public static MethodHook.Unhook hook(Member member, MethodHook methodHook, boolean z) {
        boolean z2;
        HookRecord hookRecord;
        if (PineConfig.debug) {
            Log.d(TAG, "Hooking method " + member + " with callback " + methodHook);
        }
        if (member == null) {
            throw new NullPointerException("method == null");
        }
        if (methodHook == null) {
            throw new NullPointerException("callback == null");
        }
        int modifiers = member.getModifiers();
        if (member instanceof Method) {
            if (Modifier.isAbstract(modifiers)) {
                throw new IllegalArgumentException("Cannot hook abstract methods: " + member);
            }
            ((Method) member).setAccessible(true);
        } else {
            if (!(member instanceof Constructor)) {
                throw new IllegalArgumentException("Only methods and constructors can be hooked: " + member);
            }
            if (Modifier.isStatic(modifiers)) {
                throw new IllegalArgumentException("Cannot hook class initializer: " + member);
            }
            ((Constructor) member).setAccessible(true);
        }
        ensureInitialized();
        HookListener hookListener = sHookListener;
        if (hookListener != null) {
            hookListener.beforeHook(member, methodHook);
        }
        long artMethod = getArtMethod(member);
        synchronized (sHookLock) {
            Map<Long, HookRecord> map = sHookRecords;
            HookRecord hookRecord2 = map.get(Long.valueOf(artMethod));
            if (hookRecord2 == null) {
                HookRecord hookRecord3 = new HookRecord(member, artMethod);
                map.put(Long.valueOf(artMethod), hookRecord3);
                z2 = true;
                hookRecord = hookRecord3;
            } else {
                z2 = false;
                hookRecord = hookRecord2;
            }
        }
        MethodHook.Unhook unhookHandleHook = sHookHandler.handleHook(hookRecord, methodHook, modifiers, z2, z);
        if (hookListener != null) {
            hookListener.afterHook(member, unhookHandleHook);
        }
        return unhookHandleHook;
    }

    private static native Method hook0(long j, Class<?> cls, HookRecord hookRecord, Member member, Method method, boolean z, boolean z2, boolean z3);

    public static void hookNewMethod(HookRecord hookRecord, int i, boolean z) {
        boolean z2;
        String strConcat;
        Member member = hookRecord.target;
        int i2 = hookMode;
        boolean z3 = i2 == 1 || i2 == 3;
        long jCurrentArtThread0 = currentArtThread0();
        boolean zIsStatic = Modifier.isStatic(i);
        hookRecord.isStatic = zIsStatic;
        if (zIsStatic && z) {
            resolve((Method) member);
            if (PineConfig.sdkLevel >= 29) {
                makeClassesVisiblyInitialized(jCurrentArtThread0);
            }
        }
        Class<?> declaringClass = member.getDeclaringClass();
        boolean zIsNative = Modifier.isNative(i);
        boolean zIsProxyClass = Proxy.isProxyClass(declaringClass);
        if (z3) {
            if (!zIsNative && !zIsProxyClass) {
                if (i2 == 1 && !compile0(jCurrentArtThread0, member)) {
                    Log.w(TAG, "Cannot compile the target method, force replacement mode.");
                }
                z2 = z3;
            }
            z2 = false;
        } else {
            z2 = z3;
        }
        if (member instanceof Method) {
            Method method = (Method) member;
            hookRecord.paramTypes = method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            strConcat = returnType.isPrimitive() ? returnType.getName().concat("Bridge") : "objectBridge";
        } else {
            hookRecord.paramTypes = ((Constructor) member).getParameterTypes();
            strConcat = "voidBridge";
        }
        int length = hookRecord.paramTypes.length;
        hookRecord.paramNumber = length;
        Method bridge = (PineConfig.sdkLevel == 23 && arch == 2) ? Arm64MarshmallowEntry.getBridge(strConcat, length) : sBridgeMethods.get(strConcat);
        hookRecord.bridge = bridge;
        if (bridge == null) {
            throw new AssertionError("Cannot find bridge method for " + member);
        }
        Method methodHook0 = hook0(jCurrentArtThread0, declaringClass, hookRecord, member, bridge, z2, zIsNative, zIsProxyClass);
        if (methodHook0 == null) {
            throw new RuntimeException("Failed to hook method " + member);
        }
        methodHook0.setAccessible(true);
        hookRecord.backup = methodHook0;
    }

    public static Method hookReplace(HookRecord hookRecord, Method method, Method method2, boolean z) {
        boolean z2;
        Member member = hookRecord.target;
        long artMethod = getArtMethod(member);
        Map<Long, HookRecord> map = sHookRecords;
        synchronized (map) {
            if (map.containsKey(Long.valueOf(artMethod))) {
                throw new IllegalStateException("Attempting to re-hook " + member);
            }
            map.put(Long.valueOf(artMethod), hookRecord);
        }
        int modifiers = member.getModifiers();
        int i = hookMode;
        boolean z3 = i != 2;
        long jCurrentArtThread0 = currentArtThread0();
        boolean zIsStatic = Modifier.isStatic(modifiers);
        hookRecord.isStatic = zIsStatic;
        if (zIsStatic && z) {
            resolve((Method) member);
            if (PineConfig.sdkLevel >= 29) {
                makeClassesVisiblyInitialized(jCurrentArtThread0);
            }
        }
        Class<?> declaringClass = member.getDeclaringClass();
        boolean zIsNative = Modifier.isNative(modifiers);
        boolean zIsProxyClass = Proxy.isProxyClass(declaringClass);
        if (z3) {
            if (!zIsNative && !zIsProxyClass) {
                if (i == 1 && !compile0(jCurrentArtThread0, member)) {
                    Log.w(TAG, "Cannot compile the target method, force replacement mode.");
                }
                z2 = z3;
            }
            z2 = false;
        } else {
            z2 = z3;
        }
        hookRecord.bridge = method;
        hookRecord.skipUpdateDeclaringClass = true;
        Method methodHookReplace0 = hookReplace0(jCurrentArtThread0, declaringClass, hookRecord, member, method, method2, z2, zIsNative, zIsProxyClass);
        if (methodHookReplace0 == null) {
            throw new RuntimeException("Failed to hook method " + member);
        }
        methodHookReplace0.setAccessible(true);
        hookRecord.backup = methodHookReplace0;
        return methodHookReplace0;
    }

    private static native Method hookReplace0(long j, Class<?> cls, HookRecord hookRecord, Member member, Method method, Method method2, boolean z, boolean z2, boolean z3);

    private static native void init0(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    private static void initBridgeMethods() {
        String str;
        Class<?>[] clsArr;
        try {
            int i = arch;
            if (i == 2) {
                str = "top.canyie.pine.entry.Arm64Entry";
                Class<?> cls = Long.TYPE;
                clsArr = new Class[]{cls, cls, cls, cls, cls, cls, cls};
            } else if (i == 1) {
                str = "top.canyie.pine.entry.Arm32Entry";
                Class<?> cls2 = Integer.TYPE;
                clsArr = new Class[]{cls2, cls2, cls2};
            } else {
                if (i != 3) {
                    throw new RuntimeException("Unexpected arch " + arch);
                }
                str = "top.canyie.pine.entry.X86Entry";
                Class<?> cls3 = Integer.TYPE;
                clsArr = new Class[]{cls3, cls3, cls3};
            }
            Class<?> cls4 = Class.forName(str, true, Pine.class.getClassLoader());
            String[] strArr = {"voidBridge", "intBridge", "longBridge", "doubleBridge", "floatBridge", "booleanBridge", "byteBridge", "charBridge", "shortBridge", "objectBridge"};
            for (int i2 = 0; i2 < 10; i2++) {
                String str2 = strArr[i2];
                Method declaredMethod = cls4.getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                sBridgeMethods.put(str2, declaredMethod);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to init bridge methods", e);
        }
    }

    private static void initialize() {
        int i = PineConfig.sdkLevel;
        if (i < 19) {
            throw new RuntimeException("Unsupported android sdk level " + i);
        }
        String property = System.getProperty("java.vm.version");
        if (property == null || !property.startsWith("2")) {
            throw new RuntimeException("Only supports ART runtime");
        }
        hookMode = i < 26 ? 3 : 2;
        try {
            LibLoader libLoader = PineConfig.libLoader;
            if (libLoader != null) {
                libLoader.loadLib();
            }
            init0(i, PineConfig.debug, PineConfig.debuggable, PineConfig.antiChecks, PineConfig.disableHiddenApiPolicy, PineConfig.disableHiddenApiPolicyForPlatformDomain);
            initBridgeMethods();
            if (!PineConfig.useFastNative || i < 21) {
                return;
            }
            enableFastNative();
        } catch (Exception e) {
            throw new RuntimeException("Pine init error", e);
        }
    }

    public static Object invokeOriginalMethod(Member member, Object obj, Object... objArr) {
        if (member == null) {
            throw new NullPointerException("method == null");
        }
        boolean z = member instanceof Method;
        if (z) {
            ((Method) member).setAccessible(true);
        } else {
            if (!(member instanceof Constructor)) {
                throw new IllegalArgumentException("method must be of type Method or Constructor");
            }
            ((Constructor) member).setAccessible(true);
        }
        HookRecord hookRecord = sHookRecords.get(Long.valueOf(getArtMethod(member)));
        if (hookRecord != null) {
            if (hookRecord.backup == null) {
                if (!z) {
                    throw new AssertionError();
                }
                resolve((Method) member);
            }
            return callBackupMethod(hookRecord, obj, objArr);
        }
        if (PineConfig.debug) {
            Log.w(TAG, "Attempting to invoke original implementation on a not-hooked method " + member + ". This is undefined behavior and may have side effect (e.g. if other threads hooked the method before we actually call Method.invoke(), the registered hooks will be triggered).", new Throwable("here"));
        }
        if (!(member instanceof Constructor)) {
            return ((Method) member).invoke(obj, objArr);
        }
        if (obj != null) {
            throw new IllegalArgumentException("Cannot invoke a not hooked Constructor with a non-null receiver");
        }
        try {
            return ((Constructor) member).newInstance(objArr);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("invalid Constructor", e);
        }
    }

    public static boolean is64Bit() {
        ensureInitialized();
        return arch == 2;
    }

    public static boolean isHooked(Member member) {
        if ((member instanceof Method) || (member instanceof Constructor)) {
            return sHookRecords.containsKey(Long.valueOf(getArtMethod(member)));
        }
        throw new IllegalArgumentException("Only methods and constructors can be hooked: " + member);
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static void log(String str) {
        if (PineConfig.debug) {
            Log.i(TAG, str);
        }
    }

    public static void log(String str, Object... objArr) {
        if (PineConfig.debug) {
            Log.i(TAG, String.format(str, objArr));
        }
    }

    private static native void makeClassesVisiblyInitialized(long j);

    private static void resolve(Method method) {
        try {
            method.invoke(null, method.getParameterTypes().length > 0 ? null : new Object[1]);
            throw new RuntimeException("No IllegalArgumentException thrown when resolve static method.");
        } catch (IllegalArgumentException e) {
        } catch (Exception e2) {
            throw new RuntimeException("Unknown exception thrown when resolve static method.", e2);
        }
    }

    public static void setDebuggable(boolean z) {
        if (!initialized) {
            synchronized (Pine.class) {
                if (!initialized) {
                    PineConfig.debuggable = z;
                    initialize();
                    initialized = true;
                    return;
                }
            }
        }
        PineConfig.debuggable = z;
        setDebuggable0(z);
    }

    private static native void setDebuggable0(boolean z);

    public static void setHookHandler(HookHandler hookHandler) {
        if (hookHandler == null) {
            throw new NullPointerException("handler == null");
        }
        sHookHandler = hookHandler;
    }

    public static void setHookListener(HookListener hookListener) {
        sHookListener = hookListener;
    }

    public static void setHookMode(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Illegal hookMode " + i);
        }
        if (i == 0) {
            i = PineConfig.sdkLevel < 26 ? 3 : 2;
        }
        hookMode = i;
    }

    public static void setJitCompilationAllowed(boolean z) {
        setJitCompilationAllowed(z, false);
    }

    public static void setJitCompilationAllowed(boolean z, boolean z2) {
        if (PineConfig.sdkLevel < 24) {
            return;
        }
        ensureInitialized();
        setJitCompilationAllowed0(z, z2);
    }

    private static native void setJitCompilationAllowed0(boolean z, boolean z2);

    private static native void syncMethodInfo(Member member, Method method, boolean z);
}
