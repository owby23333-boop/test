package xcrash;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes9.dex */
public final class XCrash {
    private static String appId = null;
    private static String appVersion = null;
    private static String crashPath = null;
    private static Semaphore initSemaphore = null;
    private static boolean initialized = false;
    private static String logDir;
    private static Context tempContext;
    private static ILogger logger = new DefaultLogger();
    private static boolean hookSet = false;
    private static Thread.UncaughtExceptionHandler defaultHandler = null;
    private static Thread.UncaughtExceptionHandler fcHandler = new Thread.UncaughtExceptionHandler() { // from class: xcrash.XCrash.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) throws Throwable {
            try {
                if (!XCrash.initGetCalled()) {
                    InitParameters initParameters = new InitParameters();
                    initParameters.setNativeDumpAllThreads(false);
                    initParameters.setLogDir(XCrash.crashPath);
                    initParameters.setNativeDumpMap(false);
                    initParameters.setNativeDumpFds(false);
                    initParameters.setJavaDumpAllThreads(false);
                    XCrash.init(XCrash.tempContext, initParameters);
                }
                XCrash.initSemaphore.acquire();
                JavaCrashHandler.getInstance().setDefaultHandler(XCrash.defaultHandler);
                JavaCrashHandler.getInstance().uncaughtException(thread, th);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static class InitParameters {
        String appVersion = null;
        String logDir = null;
        int logFileMaintainDelayMs = 5000;
        ILogger logger = null;
        ILibLoader libLoader = null;
        int placeholderCountMax = 0;
        int placeholderSizeKb = 128;
        boolean enableJavaCrashHandler = true;
        boolean javaRethrow = true;
        int javaLogCountMax = 10;
        int javaLogcatSystemLines = 50;
        int javaLogcatEventsLines = 50;
        int javaLogcatMainLines = 200;
        boolean javaDumpFds = true;
        boolean javaDumpNetworkInfo = true;
        boolean javaDumpAllThreads = true;
        int javaDumpAllThreadsCountMax = 0;
        String[] javaDumpAllThreadsWhiteList = null;
        ICrashCallback javaCallback = null;
        boolean enableNativeCrashHandler = true;
        boolean nativeRethrow = true;
        int nativeLogCountMax = 10;
        int nativeLogcatSystemLines = 50;
        int nativeLogcatEventsLines = 50;
        int nativeLogcatMainLines = 200;
        boolean nativeDumpElfHash = true;
        boolean nativeDumpMap = true;
        boolean nativeDumpFds = true;
        boolean nativeDumpNetworkInfo = true;
        boolean nativeDumpAllThreads = true;
        int nativeDumpAllThreadsCountMax = 0;
        String[] nativeDumpAllThreadsWhiteList = null;
        ICrashCallback nativeCallback = null;
        boolean enableAnrHandler = true;
        boolean anrRethrow = true;
        boolean anrCheckProcessState = true;
        int anrLogCountMax = 10;
        int anrLogcatSystemLines = 50;
        int anrLogcatEventsLines = 50;
        int anrLogcatMainLines = 200;
        boolean anrDumpFds = true;
        boolean anrDumpNetworkInfo = true;
        ICrashCallback anrCallback = null;

        public InitParameters disableAnrCrashHandler() {
            this.enableAnrHandler = false;
            return this;
        }

        public InitParameters disableJavaCrashHandler() {
            this.enableJavaCrashHandler = false;
            return this;
        }

        public InitParameters disableNativeCrashHandler() {
            this.enableNativeCrashHandler = false;
            return this;
        }

        public InitParameters enableAnrCrashHandler() {
            this.enableAnrHandler = true;
            return this;
        }

        public InitParameters enableJavaCrashHandler() {
            this.enableJavaCrashHandler = true;
            return this;
        }

        public InitParameters enableNativeCrashHandler() {
            this.enableNativeCrashHandler = true;
            return this;
        }

        public InitParameters setAnrCallback(ICrashCallback iCrashCallback) {
            this.anrCallback = iCrashCallback;
            return this;
        }

        public InitParameters setAnrCheckProcessState(boolean z) {
            this.anrCheckProcessState = z;
            return this;
        }

        public InitParameters setAnrDumpFds(boolean z) {
            this.anrDumpFds = z;
            return this;
        }

        public InitParameters setAnrDumpNetwork(boolean z) {
            this.anrDumpNetworkInfo = z;
            return this;
        }

        public InitParameters setAnrLogCountMax(int i) {
            if (i < 1) {
                i = 1;
            }
            this.anrLogCountMax = i;
            return this;
        }

        public InitParameters setAnrLogcatEventsLines(int i) {
            this.anrLogcatEventsLines = i;
            return this;
        }

        public InitParameters setAnrLogcatMainLines(int i) {
            this.anrLogcatMainLines = i;
            return this;
        }

        public InitParameters setAnrLogcatSystemLines(int i) {
            this.anrLogcatSystemLines = i;
            return this;
        }

        public InitParameters setAnrRethrow(boolean z) {
            this.anrRethrow = z;
            return this;
        }

        public InitParameters setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public InitParameters setJavaCallback(ICrashCallback iCrashCallback) {
            this.javaCallback = iCrashCallback;
            return this;
        }

        public InitParameters setJavaDumpAllThreads(boolean z) {
            this.javaDumpAllThreads = z;
            return this;
        }

        public InitParameters setJavaDumpAllThreadsCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.javaDumpAllThreadsCountMax = i;
            return this;
        }

        public InitParameters setJavaDumpAllThreadsWhiteList(String[] strArr) {
            this.javaDumpAllThreadsWhiteList = strArr;
            return this;
        }

        public InitParameters setJavaDumpFds(boolean z) {
            this.javaDumpFds = z;
            return this;
        }

        public InitParameters setJavaDumpNetworkInfo(boolean z) {
            this.javaDumpNetworkInfo = z;
            return this;
        }

        public InitParameters setJavaLogCountMax(int i) {
            if (i < 1) {
                i = 1;
            }
            this.javaLogCountMax = i;
            return this;
        }

        public InitParameters setJavaLogcatEventsLines(int i) {
            this.javaLogcatEventsLines = i;
            return this;
        }

        public InitParameters setJavaLogcatMainLines(int i) {
            this.javaLogcatMainLines = i;
            return this;
        }

        public InitParameters setJavaLogcatSystemLines(int i) {
            this.javaLogcatSystemLines = i;
            return this;
        }

        public InitParameters setJavaRethrow(boolean z) {
            this.javaRethrow = z;
            return this;
        }

        public InitParameters setLibLoader(ILibLoader iLibLoader) {
            this.libLoader = iLibLoader;
            return this;
        }

        public InitParameters setLogDir(String str) {
            this.logDir = str;
            return this;
        }

        public InitParameters setLogFileMaintainDelayMs(int i) {
            if (i < 0) {
                i = 0;
            }
            this.logFileMaintainDelayMs = i;
            return this;
        }

        public InitParameters setLogger(ILogger iLogger) {
            this.logger = iLogger;
            return this;
        }

        public InitParameters setNativeCallback(ICrashCallback iCrashCallback) {
            this.nativeCallback = iCrashCallback;
            return this;
        }

        public InitParameters setNativeDumpAllThreads(boolean z) {
            this.nativeDumpAllThreads = z;
            return this;
        }

        public InitParameters setNativeDumpAllThreadsCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.nativeDumpAllThreadsCountMax = i;
            return this;
        }

        public InitParameters setNativeDumpAllThreadsWhiteList(String[] strArr) {
            this.nativeDumpAllThreadsWhiteList = strArr;
            return this;
        }

        public InitParameters setNativeDumpElfHash(boolean z) {
            this.nativeDumpElfHash = z;
            return this;
        }

        public InitParameters setNativeDumpFds(boolean z) {
            this.nativeDumpFds = z;
            return this;
        }

        public InitParameters setNativeDumpMap(boolean z) {
            this.nativeDumpMap = z;
            return this;
        }

        public InitParameters setNativeDumpNetwork(boolean z) {
            this.nativeDumpNetworkInfo = z;
            return this;
        }

        public InitParameters setNativeLogCountMax(int i) {
            if (i < 1) {
                i = 1;
            }
            this.nativeLogCountMax = i;
            return this;
        }

        public InitParameters setNativeLogcatEventsLines(int i) {
            this.nativeLogcatEventsLines = i;
            return this;
        }

        public InitParameters setNativeLogcatMainLines(int i) {
            this.nativeLogcatMainLines = i;
            return this;
        }

        public InitParameters setNativeLogcatSystemLines(int i) {
            this.nativeLogcatSystemLines = i;
            return this;
        }

        public InitParameters setNativeRethrow(boolean z) {
            this.nativeRethrow = z;
            return this;
        }

        public InitParameters setPlaceholderCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.placeholderCountMax = i;
            return this;
        }

        public InitParameters setPlaceholderSizeKb(int i) {
            if (i < 0) {
                i = 0;
            }
            this.placeholderSizeKb = i;
            return this;
        }
    }

    private XCrash() {
    }

    public static String getAppId() {
        return appId;
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static String getLogDir() {
        return logDir;
    }

    public static ILogger getLogger() {
        return logger;
    }

    public static int init(Context context) {
        return init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized boolean initGetCalled() {
        return initialized;
    }

    public static void initHooker(Context context, String str) {
        initSemaphore = new Semaphore(0);
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        tempContext = context;
        crashPath = str;
        try {
            Thread.setDefaultUncaughtExceptionHandler(fcHandler);
            hookSet = true;
        } catch (Exception e) {
            getLogger().e("xcrash", "JavaCrashHandler setDefaultUncaughtExceptionHandler failed", e);
        }
    }

    public static void testJavaCrash(boolean z) throws RuntimeException {
        if (!z) {
            throw new RuntimeException("test java exception");
        }
        Thread thread = new Thread() { // from class: xcrash.XCrash.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                throw new RuntimeException("test java exception");
            }
        };
        thread.setName("xcrash_test_java_thread");
        thread.start();
    }

    public static void testNativeCrash(boolean z) {
        NativeHandler.getInstance().testNativeCrash(z);
    }

    public static synchronized int init(Context context, InitParameters initParameters) {
        String str;
        Context context2;
        int iInitialize;
        if (initialized) {
            return 0;
        }
        initialized = true;
        if (context == null) {
            return -1;
        }
        Context applicationContext = context.getApplicationContext();
        Context context3 = applicationContext != null ? applicationContext : context;
        InitParameters initParameters2 = initParameters == null ? new InitParameters() : initParameters;
        ILogger iLogger = initParameters2.logger;
        if (iLogger != null) {
            logger = iLogger;
        }
        String packageName = context3.getPackageName();
        appId = packageName;
        if (TextUtils.isEmpty(packageName)) {
            appId = "unknown";
        }
        if (TextUtils.isEmpty(initParameters2.appVersion)) {
            initParameters2.appVersion = Util.getAppVersion(context3);
        }
        appVersion = initParameters2.appVersion;
        if (TextUtils.isEmpty(initParameters2.logDir)) {
            initParameters2.logDir = context3.getFilesDir() + "/tombstones";
        }
        logDir = initParameters2.logDir;
        int iMyPid = Process.myPid();
        if (initParameters2.enableJavaCrashHandler || initParameters2.enableAnrHandler) {
            String processName = Util.getProcessName(context3, iMyPid);
            if (initParameters2.enableAnrHandler && (TextUtils.isEmpty(processName) || !processName.equals(packageName))) {
                initParameters2.enableAnrHandler = false;
            }
            str = processName;
        } else {
            str = null;
        }
        FileManager.getInstance().initialize(initParameters2.logDir, initParameters2.javaLogCountMax, initParameters2.nativeLogCountMax, initParameters2.anrLogCountMax, initParameters2.placeholderCountMax, initParameters2.placeholderSizeKb, initParameters2.logFileMaintainDelayMs);
        if ((initParameters2.enableJavaCrashHandler || initParameters2.enableNativeCrashHandler || initParameters2.enableAnrHandler) && (context3 instanceof Application)) {
            ActivityMonitor.getInstance().initialize((Application) context3);
        }
        if (initParameters2.enableJavaCrashHandler) {
            context2 = context3;
            JavaCrashHandler.getInstance().initialize(iMyPid, str, hookSet, appId, initParameters2.appVersion, initParameters2.logDir, initParameters2.javaRethrow, initParameters2.javaLogcatSystemLines, initParameters2.javaLogcatEventsLines, initParameters2.javaLogcatMainLines, initParameters2.javaDumpFds, initParameters2.javaDumpNetworkInfo, initParameters2.javaDumpAllThreads, initParameters2.javaDumpAllThreadsCountMax, initParameters2.javaDumpAllThreadsWhiteList, initParameters2.javaCallback);
        } else {
            context2 = context3;
        }
        boolean z = initParameters2.enableAnrHandler;
        if (initParameters2.enableNativeCrashHandler || z) {
            iInitialize = NativeHandler.getInstance().initialize(context2, initParameters2.libLoader, appId, initParameters2.appVersion, initParameters2.logDir, initParameters2.enableNativeCrashHandler, initParameters2.nativeRethrow, initParameters2.nativeLogcatSystemLines, initParameters2.nativeLogcatEventsLines, initParameters2.nativeLogcatMainLines, initParameters2.nativeDumpElfHash, initParameters2.nativeDumpMap, initParameters2.nativeDumpFds, initParameters2.nativeDumpNetworkInfo, initParameters2.nativeDumpAllThreads, initParameters2.nativeDumpAllThreadsCountMax, initParameters2.nativeDumpAllThreadsWhiteList, initParameters2.nativeCallback, initParameters2.enableAnrHandler, initParameters2.anrRethrow, initParameters2.anrCheckProcessState, initParameters2.anrLogcatSystemLines, initParameters2.anrLogcatEventsLines, initParameters2.anrLogcatMainLines, initParameters2.anrDumpFds, initParameters2.anrDumpNetworkInfo, initParameters2.anrCallback);
        } else {
            iInitialize = 0;
        }
        FileManager.getInstance().maintain();
        Semaphore semaphore = initSemaphore;
        if (semaphore != null) {
            semaphore.release();
        }
        tempContext = null;
        return iInitialize;
    }
}
