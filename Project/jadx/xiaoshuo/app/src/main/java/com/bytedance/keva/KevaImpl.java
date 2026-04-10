package com.bytedance.keva;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.bytedance.keva.Keva;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
abstract class KevaImpl extends Keva {
    static final Executor sExecutor;
    static final KevaMonitor sMonitor;
    private static final String sPortedSpRepoName;
    private static final HashMap<String, Keva> sRepoMap;
    private static final File sSharedPrefsDir;
    volatile long mHandle;
    private final boolean mIsMultiProcess;
    private final int mMode;
    private final String mName;
    final HashMap<String, KevaValueWrapper> mValueMap = new HashMap<>();
    private final List<Keva.OnChangeListener> mChangeListeners = new ArrayList();
    private List<KevaValueWrapper> mDuplicatedOldWrappers = new ArrayList();

    public static class KevaValueWrapper {
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;
    }

    public static class PortedSpRepoHolder {
        private static final KevaImpl sInstance;
        private static final Map<String, ?> sPortedSpMap;

        static {
            KevaMultiProcessImpl kevaMultiProcessImpl = new KevaMultiProcessImpl(KevaImpl.sPortedSpRepoName, 1);
            sInstance = kevaMultiProcessImpl;
            kevaMultiProcessImpl.init(true);
            sPortedSpMap = kevaMultiProcessImpl.buildNewMap(new HashMap());
        }

        private PortedSpRepoHolder() {
        }
    }

    public interface PrivateConstants {
        public static final int BLOCK_TYPE_BYTES = 0;
        public static final int BLOCK_TYPE_OBJECT = 4;
        public static final int BLOCK_TYPE_STRING_ARRAY = 3;
        public static final int BLOCK_TYPE_STRING_UTF16 = 2;
        public static final int BLOCK_TYPE_STRING_UTF8 = 1;
        public static final String EMPTY_STRING = "";
        public static final int EXT_TYPE_BYTES = 7;
        public static final int EXT_TYPE_OBJECT = 71;
        public static final int EXT_TYPE_STRING_ARRAY = 55;
        public static final int EXT_TYPE_STRING_UTF16 = 39;
        public static final int EXT_TYPE_STRING_UTF8 = 23;
        public static final String FILES_DIR_NAME = "files";
        public static final String KEVA = "keva";
        public static final String LIB_NAME = "keva";
        public static final String PORTED_SP = "keva_porting_sp";
        public static final int REPORT_VALUE_SIZE_THRESHOLD = 10000;
        public static final String SP_DIR_NAME = "shared_prefs";
        public static final int TYPE_BOOL = 2;
        public static final int TYPE_BYTES = 7;
        public static final int TYPE_DOUBLE = 5;
        public static final int TYPE_FLOAT = 4;
        public static final int TYPE_INT = 1;
        public static final int TYPE_INVALID = 0;
        public static final int TYPE_LONG = 3;
        public static final int TYPE_STRING = 6;
    }

    static {
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = new HashMap<>();
        Executor executor = kevaBuilder.mExecutor;
        if (executor != null) {
            sExecutor = executor;
        } else {
            int iMax = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iMax, iMax, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            sExecutor = threadPoolExecutor;
        }
        String str = kevaBuilder.mPortedRepoName;
        if (str == null) {
            str = PrivateConstants.PORTED_SP;
        }
        sPortedSpRepoName = str;
        Context context = kevaBuilder.mContext;
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(context.getApplicationInfo().dataDir, "files");
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        File file = kevaBuilder.mWorkDir;
        if (file == null) {
            file = new File(filesDir, "keva");
        }
        sSharedPrefsDir = new File(filesDir.getParent(), PrivateConstants.SP_DIR_NAME);
        KevaMonitor kevaMonitor = kevaBuilder.mMonitor;
        if (kevaMonitor == null) {
            kevaMonitor = new KevaMonitor();
        }
        sMonitor = kevaMonitor;
        kevaMonitor.logDebug("Keva version: 1.6.8.SHARED-reduceNativeLog");
        if (!file.exists() && !file.mkdirs()) {
            kevaMonitor.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + file.getPath()));
        }
        try {
            kevaMonitor.loadLibrary("keva");
            initialize(file.getAbsolutePath());
        } catch (Throwable th) {
            th.printStackTrace();
            KevaMonitor kevaMonitor2 = sMonitor;
            kevaMonitor2.logDebug("fail to load so and init");
            kevaMonitor2.reportThrowable(1, null, null, null, th);
        }
    }

    public KevaImpl(String str, int i) {
        this.mName = str;
        this.mMode = i;
        this.mIsMultiProcess = (i & 1) != 0;
    }

    private void addMapObjectWhenLoading(String str, Object obj, long j, int i) {
        List<KevaValueWrapper> list;
        if ("".equals(str)) {
            str = null;
        }
        KevaValueWrapper kevaValueWrapper = new KevaValueWrapper();
        kevaValueWrapper.value = obj;
        kevaValueWrapper.offset = j;
        kevaValueWrapper.type = i;
        if (!this.mIsMultiProcess) {
            kevaValueWrapper.loaded = true;
        }
        KevaValueWrapper kevaValueWrapperPut = this.mValueMap.put(str, kevaValueWrapper);
        if (kevaValueWrapperPut == null || (list = this.mDuplicatedOldWrappers) == null) {
            return;
        }
        list.add(kevaValueWrapperPut);
    }

    public static native void checkReportException(long j);

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle == 0) {
            sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
            return;
        }
        try {
            Iterator<KevaValueWrapper> it = this.mDuplicatedOldWrappers.iterator();
            while (it.hasNext()) {
                eraseUnusedChunk(this.mHandle, it.next().offset);
            }
            this.mDuplicatedOldWrappers = null;
            checkReportException(this.mHandle);
        } catch (Throwable th) {
            sMonitor.reportThrowable(1, this.mName, null, null, th);
        }
    }

    private static native void clear(long j);

    private static native boolean delete(String str);

    private void doLoadRepo(boolean z) {
        try {
            this.mHandle = loadRepo(this.mName, this.mMode, z);
            cleanUpAfterLoadRepo();
            if (z) {
                return;
            }
            sMonitor.onLoadRepo(this.mName, this.mMode);
        } catch (Throwable th) {
            sMonitor.reportThrowable(1, this.mName, null, null, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doPortingFromSp(android.content.Context r20) {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.keva.KevaImpl.doPortingFromSp(android.content.Context):void");
    }

    private native void dump(long j);

    private native void erase(long j, String str, long j2);

    private native void eraseUnusedChunk(long j, long j2);

    private static boolean existSharedPrefs(String str) {
        return new File(sSharedPrefsDir, str + ".xml").exists();
    }

    private Set<String> fetchStringSet(String str, Set<String> set, boolean z) {
        String[] strArrFetchStringArray = fetchStringArray(str, set != null ? (String[]) set.toArray(new String[0]) : null, z);
        if (strArrFetchStringArray != null) {
            return new HashSet(Arrays.asList(strArrFetchStringArray));
        }
        return null;
    }

    public static void forceInitImpl() {
        Log.println(4, KevaConstants.TAG, "force initializing Keva");
    }

    public static KevaImpl getEmptyRepoImpl(String str, int i) {
        if (i < 0 || i >= 2) {
            sMonitor.reportThrowable(1, str, null, null, new IllegalArgumentException("mode is not valid! " + i));
        }
        return (i & 1) == 0 ? new KevaPrivateImpl(str, i) : new KevaMultiProcessImpl(str, i);
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.sInstance;
    }

    public static Keva getRepo(String str, int i) {
        return getRepoImpl(str, i, false);
    }

    public static Keva getRepoFromSp(Context context, String str, int i) {
        return getRepoFromSpImpl(context, str, i, false);
    }

    private static Keva getRepoFromSpImpl(final Context context, final String str, final int i, boolean z) {
        Keva emptyRepoImpl;
        if (isRepoPorted(str)) {
            return getRepo(str, i);
        }
        boolean z2 = true;
        if (!existSharedPrefs(str)) {
            getPortedSpRepo().storeBoolean(str, true);
            return getRepo(str, i);
        }
        sMonitor.logDebug("do poring from sp: " + str);
        HashMap<String, Keva> map = sRepoMap;
        synchronized (map) {
            emptyRepoImpl = map.get(str);
            if (emptyRepoImpl != null) {
                z2 = false;
            }
            if (z2) {
                emptyRepoImpl = z ? getEmptyRepoImpl(str, i) : new KevaFuture(str, i, new Callable<KevaImpl>() { // from class: com.bytedance.keva.KevaImpl.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public KevaImpl call() {
                        KevaImpl emptyRepoImpl2 = KevaImpl.getEmptyRepoImpl(str, i);
                        emptyRepoImpl2.doPortingFromSp(context);
                        return emptyRepoImpl2;
                    }
                });
                map.put(str, emptyRepoImpl);
            }
        }
        if (z2) {
            if (emptyRepoImpl instanceof KevaImpl) {
                try {
                    ((KevaImpl) emptyRepoImpl).doPortingFromSp(context);
                } catch (UnsatisfiedLinkError e) {
                    sMonitor.reportThrowable(1, str, null, null, e);
                }
            }
        } else if (emptyRepoImpl instanceof KevaImpl) {
            ((KevaImpl) emptyRepoImpl).checkMode(i);
        } else {
            ((KevaFuture) emptyRepoImpl).checkMode(i);
        }
        return emptyRepoImpl;
    }

    public static Keva getRepoFromSpSync(Context context, String str, int i) {
        return getRepoFromSpImpl(context, str, i, true);
    }

    private static Keva getRepoImpl(final String str, final int i, boolean z) {
        Keva emptyRepoImpl;
        boolean z2;
        HashMap<String, Keva> map = sRepoMap;
        synchronized (map) {
            emptyRepoImpl = map.get(str);
            z2 = emptyRepoImpl == null;
            if (z2) {
                emptyRepoImpl = z ? getEmptyRepoImpl(str, i) : new KevaFuture(str, i, new Callable<KevaImpl>() { // from class: com.bytedance.keva.KevaImpl.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public KevaImpl call() {
                        KevaImpl emptyRepoImpl2 = KevaImpl.getEmptyRepoImpl(str, i);
                        emptyRepoImpl2.init(false);
                        return emptyRepoImpl2;
                    }
                });
                map.put(str, emptyRepoImpl);
            }
        }
        if (z2) {
            if (!(emptyRepoImpl instanceof KevaFuture)) {
                ((KevaImpl) emptyRepoImpl).init(false);
            }
        } else if (emptyRepoImpl instanceof KevaFuture) {
            ((KevaFuture) emptyRepoImpl).checkMode(i);
        } else {
            ((KevaImpl) emptyRepoImpl).checkMode(i);
        }
        return emptyRepoImpl;
    }

    public static Keva getRepoSync(String str, int i) {
        return getRepoImpl(str, i, true);
    }

    private static native void initialize(String str);

    public static boolean isRepoPorted(String str) {
        if (PortedSpRepoHolder.sPortedSpMap.get(str) != null) {
            return true;
        }
        return getPortedSpRepo().getBoolean(str, false);
    }

    private native long loadRepo(String str, int i, boolean z);

    private void notifyChangeListeners(Keva keva, String str) {
        if (this.mChangeListeners.size() == 0) {
            return;
        }
        Iterator<Keva.OnChangeListener> it = this.mChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onChanged(keva, str);
        }
    }

    private KevaValueWrapper obtainWrapperLocked(String str) {
        KevaValueWrapper kevaValueWrapper = this.mValueMap.get(str);
        if (kevaValueWrapper != null) {
            return kevaValueWrapper;
        }
        KevaValueWrapper kevaValueWrapper2 = new KevaValueWrapper();
        this.mValueMap.put(str, kevaValueWrapper2);
        return kevaValueWrapper2;
    }

    public static void passWarning(int i, String str, String str2, Object obj, String str3) {
        sMonitor.reportWarning(i, str, str2, obj, str3);
    }

    private native int protectPortingInterProcess(String str, boolean z, int i);

    private void reportBigValue(final String str, final Object obj, final int i) {
        if (i > 10000) {
            sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, obj, "value too big, size=" + i);
                }
            });
        }
    }

    private native long storeBoolean(long j, String str, long j2, boolean z);

    private native long storeBytes(long j, String str, long j2, byte[] bArr, int i);

    private void storeBytes(final String str, byte[] bArr, int i, boolean z) {
        final int length;
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            try {
                kevaValueWrapperObtainWrapperLocked.offset = storeBytes(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, bArr, i);
                kevaValueWrapperObtainWrapperLocked.type = (i << 4) | 7;
                if (z) {
                    kevaValueWrapperObtainWrapperLocked.value = null;
                    kevaValueWrapperObtainWrapperLocked.loaded = false;
                } else {
                    kevaValueWrapperObtainWrapperLocked.value = bArr;
                    if (!this.mIsMultiProcess) {
                        kevaValueWrapperObtainWrapperLocked.loaded = true;
                    }
                }
                notifyChangeListeners(this, str);
            } catch (Throwable th) {
                sMonitor.reportThrowable(3, this.mName, str, bArr, th);
            }
        }
        if (bArr == null || (length = bArr.length) <= 10000) {
            return;
        }
        sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.5
            @Override // java.lang.Runnable
            public void run() {
                KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, null, "value too big, size=" + length);
            }
        });
    }

    private native long storeDouble(long j, String str, long j2, double d);

    private native long storeFloat(long j, String str, long j2, float f);

    private native long storeInt(long j, String str, long j2, int i);

    private native long storeLong(long j, String str, long j2, long j3);

    private native long storeString(long j, String str, long j2, String str2);

    private void storeString(final String str, final String str2, boolean z) {
        final int length;
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !kevaValueWrapperObtainWrapperLocked.loaded || kevaValueWrapperObtainWrapperLocked.value == null || !kevaValueWrapperObtainWrapperLocked.value.equals(str2)) {
                try {
                    kevaValueWrapperObtainWrapperLocked.offset = storeString(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, str2);
                    kevaValueWrapperObtainWrapperLocked.type = 6;
                    if (z) {
                        kevaValueWrapperObtainWrapperLocked.value = null;
                        kevaValueWrapperObtainWrapperLocked.loaded = false;
                    } else {
                        kevaValueWrapperObtainWrapperLocked.value = str2;
                        if (!this.mIsMultiProcess) {
                            kevaValueWrapperObtainWrapperLocked.loaded = true;
                        }
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, str2, th);
                }
                if (str2 == null || (length = str2.length()) <= 10000) {
                    return;
                }
                sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.4
                    @Override // java.lang.Runnable
                    public void run() {
                        KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, str2, "value too big, size=" + length);
                    }
                });
            }
        }
    }

    private native long storeStringArray(long j, String str, long j2, String[] strArr, int i);

    private void storeStringArray(final String str, String[] strArr, boolean z) {
        final String string;
        final int length;
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            try {
                kevaValueWrapperObtainWrapperLocked.offset = storeStringArray(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, strArr, 3);
                kevaValueWrapperObtainWrapperLocked.type = 55;
                if (z) {
                    kevaValueWrapperObtainWrapperLocked.value = null;
                    kevaValueWrapperObtainWrapperLocked.loaded = false;
                } else {
                    kevaValueWrapperObtainWrapperLocked.value = strArr;
                    if (!this.mIsMultiProcess) {
                        kevaValueWrapperObtainWrapperLocked.loaded = true;
                    }
                }
                notifyChangeListeners(this, str);
            } catch (Throwable th) {
                sMonitor.reportThrowable(3, this.mName, str, null, th);
            }
        }
        if (strArr == null || (length = (string = Arrays.toString(strArr)).length()) <= 10000) {
            return;
        }
        sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.6
            @Override // java.lang.Runnable
            public void run() {
                KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, string, "value too big, size=" + length);
            }
        });
    }

    private void storeStringSet(String str, Set<String> set, boolean z) {
        String[] strArr;
        if (set != null) {
            strArr = new String[set.size()];
            set.toArray(strArr);
        } else {
            strArr = null;
        }
        storeStringArray(str, strArr, z);
    }

    public void addMapBoolWhenLoading(String str, boolean z, long j) {
        addMapObjectWhenLoading(str, Boolean.valueOf(z), j, 2);
    }

    public void addMapDoubleWhenLoading(String str, double d, long j) {
        addMapObjectWhenLoading(str, Double.valueOf(d), j, 5);
    }

    public void addMapFloatWhenLoading(String str, float f, long j) {
        addMapObjectWhenLoading(str, Float.valueOf(f), j, 4);
    }

    public void addMapIntWhenLoading(String str, int i, long j) {
        addMapObjectWhenLoading(str, Integer.valueOf(i), j, 1);
    }

    public void addMapLongWhenLoading(String str, long j, long j2) {
        addMapObjectWhenLoading(str, Long.valueOf(j), j2, 3);
    }

    public void addMapOffsetWhenLoading(String str, long j, int i) {
        List<KevaValueWrapper> list;
        if ("".equals(str)) {
            str = null;
        }
        KevaValueWrapper kevaValueWrapper = new KevaValueWrapper();
        kevaValueWrapper.offset = j;
        kevaValueWrapper.type = i;
        KevaValueWrapper kevaValueWrapperPut = this.mValueMap.put(str, kevaValueWrapper);
        if (kevaValueWrapperPut == null || (list = this.mDuplicatedOldWrappers) == null) {
            return;
        }
        list.add(kevaValueWrapperPut);
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> map) {
        synchronized (this) {
            for (Map.Entry<String, KevaValueWrapper> entry : this.mValueMap.entrySet()) {
                KevaValueWrapper value = entry.getValue();
                if (value.offset != 0) {
                    String key = entry.getKey();
                    try {
                        if (!value.loaded) {
                            int i = value.type;
                            if (i == 6) {
                                value.value = fetchString(this.mHandle, key, value.offset, null);
                            } else if (i == 7) {
                                value.value = fetchBytes(this.mHandle, key, value.offset, null, 0);
                            } else {
                                if (i == 23 || i == 39) {
                                    throw new UnsupportedOperationException("keva has not implemented type " + value.type);
                                }
                                if (i == 55) {
                                    value.value = fetchStringArray(this.mHandle, key, value.offset, null, 3);
                                } else if (!this.mIsMultiProcess || value.type > 5) {
                                    throw new UnsupportedOperationException("keva has not implemented type " + value.type);
                                }
                            }
                            if (!this.mIsMultiProcess) {
                                value.loaded = true;
                            }
                        }
                        map.put(key, value.value);
                    } catch (Throwable th) {
                        sMonitor.reportThrowable(2, this.mName, key, Long.valueOf(value.offset), th);
                    }
                }
            }
        }
        return map;
    }

    public void checkMode(int i) {
        if (this.mHandle == 0 || this.mMode == i) {
            return;
        }
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + i));
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        synchronized (this) {
            try {
                this.mValueMap.clear();
                clear(this.mHandle);
            } finally {
            }
        }
    }

    public native boolean contains(long j, String str, long j2);

    @Override // com.bytedance.keva.Keva
    public void dump() {
        synchronized (this) {
            sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());
            for (Map.Entry<String, KevaValueWrapper> entry : this.mValueMap.entrySet()) {
                KevaValueWrapper value = entry.getValue();
                String key = entry.getKey();
                sMonitor.logDebug("key: " + key + ", value: " + value.value + ", offset: " + value.offset + ", loaded: " + value.loaded);
            }
            sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());
        }
    }

    public void dumpNative() {
        synchronized (this) {
            dump(this.mHandle);
        }
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String str) {
        KevaValueWrapper kevaValueWrapperObtainWrapperLocked;
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            try {
                kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
                erase(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset);
                kevaValueWrapperObtainWrapperLocked.value = null;
                kevaValueWrapperObtainWrapperLocked.offset = 0L;
            } finally {
            }
            if (!this.mIsMultiProcess) {
                kevaValueWrapperObtainWrapperLocked.loaded = true;
            }
        }
    }

    public native boolean fetchBoolean(long j, String str, long j2, boolean z);

    public abstract boolean fetchBoolean(String str, boolean z);

    public native byte[] fetchBytes(long j, String str, long j2, byte[] bArr, int i);

    public abstract byte[] fetchBytes(String str, byte[] bArr, int i, boolean z);

    public native double fetchDouble(long j, String str, long j2, double d);

    public abstract double fetchDouble(String str, double d);

    public native float fetchFloat(long j, String str, long j2, float f);

    public abstract float fetchFloat(String str, float f);

    public native int fetchInt(long j, String str, long j2, int i);

    public abstract int fetchInt(String str, int i);

    public native long fetchLong(long j, String str, long j2, long j3);

    public abstract long fetchLong(String str, long j);

    public native String fetchString(long j, String str, long j2, String str2);

    public abstract String fetchString(String str, String str2, boolean z);

    public native String[] fetchStringArray(long j, String str, long j2, String[] strArr, int i);

    public abstract String[] fetchStringArray(String str, String[] strArr, boolean z);

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String str, boolean z) {
        boolean zFetchBoolean;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    zFetchBoolean = fetchBoolean(str2, z);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, null, th);
                    return z;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zFetchBoolean;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String str, byte[] bArr) {
        byte[] bArrFetchBytes;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    bArrFetchBytes = fetchBytes(str2, bArr, 0, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, bArr, th);
                    return bArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArrFetchBytes;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String str, byte[] bArr) {
        byte[] bArrFetchBytes;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    bArrFetchBytes = fetchBytes(str2, bArr, 0, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, bArr, th);
                    return bArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArrFetchBytes;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String str, double d) {
        double dFetchDouble;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    dFetchDouble = fetchDouble(str2, d);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Double.valueOf(d), th);
                    return d;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dFetchDouble;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String str, float f) {
        float fFetchFloat;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fFetchFloat = fetchFloat(str2, f);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Float.valueOf(f), th);
                    return f;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fFetchFloat;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String str, int i) {
        int iFetchInt;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    iFetchInt = fetchInt(str2, i);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Integer.valueOf(i), th);
                    return i;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iFetchInt;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String str, long j) {
        long jFetchLong;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    jFetchLong = fetchLong(str2, j);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Long.valueOf(j), th);
                    return j;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jFetchLong;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String str, String str2) {
        String strFetchString;
        if ("".equals(str)) {
            str = null;
        }
        String str3 = str;
        synchronized (this) {
            try {
                try {
                    strFetchString = fetchString(str3, str2, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str3, str2, th);
                    return str2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strFetchString;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String str, String[] strArr) {
        String[] strArrFetchStringArray;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    strArrFetchStringArray = fetchStringArray(str2, strArr, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, strArr, th);
                    return strArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strArrFetchStringArray;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String str, String[] strArr) {
        String[] strArrFetchStringArray;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    strArrFetchStringArray = fetchStringArray(str2, strArr, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, strArr, th);
                    return strArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strArrFetchStringArray;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String str, String str2) {
        String strFetchString;
        if ("".equals(str)) {
            str = null;
        }
        String str3 = str;
        synchronized (this) {
            try {
                try {
                    strFetchString = fetchString(str3, str2, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str3, str2, th);
                    return str2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strFetchString;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setFetchStringSet;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    setFetchStringSet = fetchStringSet(str2, set, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, set, th);
                    return set;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return setFetchStringSet;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String str, Set<String> set) {
        Set<String> setFetchStringSet;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    setFetchStringSet = fetchStringSet(str2, set, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, set, th);
                    return set;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return setFetchStringSet;
    }

    public void init(boolean z) {
        synchronized (this) {
            if (this.mHandle != 0) {
                return;
            }
            doLoadRepo(z);
        }
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    public native void rebuildValueMap(long j);

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener onChangeListener) {
        synchronized (this) {
            if (!this.mChangeListeners.contains(onChangeListener)) {
                this.mChangeListeners.add(onChangeListener);
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String str, boolean z) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !kevaValueWrapperObtainWrapperLocked.loaded || kevaValueWrapperObtainWrapperLocked.value == null || !kevaValueWrapperObtainWrapperLocked.value.equals(Boolean.valueOf(z))) {
                try {
                    kevaValueWrapperObtainWrapperLocked.offset = storeBoolean(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, z);
                    kevaValueWrapperObtainWrapperLocked.value = Boolean.valueOf(z);
                    if (!this.mIsMultiProcess) {
                        kevaValueWrapperObtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Boolean.valueOf(z), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String str, byte[] bArr) {
        storeBytes(str, bArr, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String str, double d) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !kevaValueWrapperObtainWrapperLocked.loaded || kevaValueWrapperObtainWrapperLocked.value == null || !kevaValueWrapperObtainWrapperLocked.value.equals(Double.valueOf(d))) {
                try {
                    kevaValueWrapperObtainWrapperLocked.offset = storeDouble(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, d);
                    kevaValueWrapperObtainWrapperLocked.value = Double.valueOf(d);
                    if (!this.mIsMultiProcess) {
                        kevaValueWrapperObtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Double.valueOf(d), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String str, float f) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !kevaValueWrapperObtainWrapperLocked.loaded || kevaValueWrapperObtainWrapperLocked.value == null || !kevaValueWrapperObtainWrapperLocked.value.equals(Float.valueOf(f))) {
                try {
                    kevaValueWrapperObtainWrapperLocked.offset = storeFloat(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, f);
                    kevaValueWrapperObtainWrapperLocked.value = Float.valueOf(f);
                    if (!this.mIsMultiProcess) {
                        kevaValueWrapperObtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Float.valueOf(f), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String str, int i) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !kevaValueWrapperObtainWrapperLocked.loaded || kevaValueWrapperObtainWrapperLocked.value == null || !kevaValueWrapperObtainWrapperLocked.value.equals(Integer.valueOf(i))) {
                try {
                    kevaValueWrapperObtainWrapperLocked.offset = storeInt(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, i);
                    kevaValueWrapperObtainWrapperLocked.value = Integer.valueOf(i);
                    if (!this.mIsMultiProcess) {
                        kevaValueWrapperObtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Integer.valueOf(i), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String str, long j) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper kevaValueWrapperObtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !kevaValueWrapperObtainWrapperLocked.loaded || kevaValueWrapperObtainWrapperLocked.value == null || !kevaValueWrapperObtainWrapperLocked.value.equals(Long.valueOf(j))) {
                try {
                    kevaValueWrapperObtainWrapperLocked.offset = storeLong(this.mHandle, str, kevaValueWrapperObtainWrapperLocked.offset, j);
                    kevaValueWrapperObtainWrapperLocked.value = Long.valueOf(j);
                    if (!this.mIsMultiProcess) {
                        kevaValueWrapperObtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Long.valueOf(j), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String str, String[] strArr) {
        storeStringArray(str, strArr, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String str, String str2) {
        storeString(str, str2, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String str, Set<String> set) {
        storeStringSet(str, set, true);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener onChangeListener) {
        synchronized (this) {
            this.mChangeListeners.remove(onChangeListener);
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String str, Set<String> set) {
        storeStringSet(str, set, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String str, byte[] bArr) {
        storeBytes(str, bArr, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String str, String[] strArr) {
        storeStringArray(str, strArr, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String str, String str2) {
        storeString(str, str2, false);
    }
}
