package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static final Set<Long> checkedHandleSet;
    private static MMKVHandler gCallbackHandler;
    private static MMKVContentChangeNotification gContentChangeNotify;
    private static boolean gWantLogReDirecting;
    private static final MMKVLogLevel[] index2LogLevel;
    private static boolean isProcessModeCheckerEnabled;
    private static final EnumMap<MMKVLogLevel, Integer> logLevel2Index;
    private static final HashMap<String, Parcelable.Creator<?>> mCreators;
    private static final EnumMap<MMKVRecoverStrategic, Integer> recoverIndex = new EnumMap<>(MMKVRecoverStrategic.class);
    private static String rootDir;
    private final long nativeHandle;

    /* JADX INFO: renamed from: com.tencent.mmkv.MMKV$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mmkv$MMKVLogLevel = new int[MMKVLogLevel.values().length];

        static {
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface LibLoader {
        void loadLibrary(String str);
    }

    static {
        recoverIndex.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        recoverIndex.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        logLevel2Index = new EnumMap<>(MMKVLogLevel.class);
        logLevel2Index.put(MMKVLogLevel.LevelDebug, 0);
        logLevel2Index.put(MMKVLogLevel.LevelInfo, 1);
        logLevel2Index.put(MMKVLogLevel.LevelWarning, 2);
        logLevel2Index.put(MMKVLogLevel.LevelError, 3);
        logLevel2Index.put(MMKVLogLevel.LevelNone, 4);
        index2LogLevel = new MMKVLogLevel[]{MMKVLogLevel.LevelDebug, MMKVLogLevel.LevelInfo, MMKVLogLevel.LevelWarning, MMKVLogLevel.LevelError, MMKVLogLevel.LevelNone};
        checkedHandleSet = new HashSet();
        rootDir = null;
        isProcessModeCheckerEnabled = true;
        mCreators = new HashMap<>();
        gWantLogReDirecting = false;
    }

    private MMKV(long j2) {
        this.nativeHandle = j2;
    }

    private native long actualSize(long j2);

    private static MMKV checkProcessMode(long j2, String str, int i2) throws RuntimeException {
        String str2;
        if (j2 == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
        }
        if (!isProcessModeCheckerEnabled) {
            return new MMKV(j2);
        }
        synchronized (checkedHandleSet) {
            if (!checkedHandleSet.contains(Long.valueOf(j2))) {
                if (!checkProcessMode(j2)) {
                    if (i2 == 1) {
                        str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                    } else {
                        str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                    }
                    throw new IllegalArgumentException(str2);
                }
                checkedHandleSet.add(Long.valueOf(j2));
            }
        }
        return new MMKV(j2);
    }

    private static native boolean checkProcessMode(long j2);

    private native boolean containsKey(long j2, String str);

    private native long count(long j2);

    private static native long createNB(int i2);

    @Nullable
    public static NativeBuffer createNativeBuffer(int i2) {
        long jCreateNB = createNB(i2);
        if (jCreateNB <= 0) {
            return null;
        }
        return new NativeBuffer(jCreateNB, i2);
    }

    private native boolean decodeBool(long j2, String str, boolean z2);

    @Nullable
    private native byte[] decodeBytes(long j2, String str);

    private native double decodeDouble(long j2, String str, double d2);

    private native float decodeFloat(long j2, String str, float f2);

    private native int decodeInt(long j2, String str, int i2);

    private native long decodeLong(long j2, String str, long j3);

    @Nullable
    private native String decodeString(long j2, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j2, String str);

    public static MMKV defaultMMKV() throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native void destroyNB(long j2, int i2);

    public static void destroyNativeBuffer(NativeBuffer nativeBuffer) {
        destroyNB(nativeBuffer.pointer, nativeBuffer.size);
    }

    public static void disableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = false;
        }
    }

    private static String doInitialize(String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        if (libLoader != null) {
            libLoader.loadLibrary("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(str, logLevel2Int(mMKVLogLevel));
        rootDir = str;
        return rootDir;
    }

    public static void enableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = true;
        }
    }

    private native boolean encodeBool(long j2, String str, boolean z2);

    private native boolean encodeBytes(long j2, String str, @Nullable byte[] bArr);

    private native boolean encodeDouble(long j2, String str, double d2);

    private native boolean encodeFloat(long j2, String str, float f2);

    private native boolean encodeInt(long j2, String str, int i2);

    private native boolean encodeLong(long j2, String str, long j3);

    private native boolean encodeSet(long j2, String str, @Nullable String[] strArr);

    private native boolean encodeString(long j2, String str, @Nullable String str2);

    private static native long getDefaultMMKV(int i2, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i2, int i3, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i2, @Nullable String str2, @Nullable String str3);

    private static native long getMMKVWithIDAndSize(String str, int i2, int i3, @Nullable String str2);

    public static String getRootDir() {
        return rootDir;
    }

    public static String initialize(Context context) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo);
    }

    public static boolean isFileValid(String str) {
        return isFileValid(str, null);
    }

    public static native boolean isFileValid(String str, @Nullable String str2);

    private static native void jniInitialize(String str, int i2);

    private static int logLevel2Int(MMKVLogLevel mMKVLogLevel) {
        int i2 = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[mMKVLogLevel.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 != 3) {
            return i2 != 4 ? 1 : 4;
        }
        return 3;
    }

    private static void mmkvLogImp(int i2, String str, int i3, String str2, String str3) {
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null && gWantLogReDirecting) {
            mMKVHandler.mmkvLog(index2LogLevel[i2], str, i3, str2, str3);
            return;
        }
        int i4 = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[index2LogLevel[i2].ordinal()];
        if (i4 == 1 || i4 == 2 || i4 != 3) {
        }
    }

    public static MMKV mmkvWithAshmemFD(String str, int i2, int i3, String str2) throws RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i2, i3, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public static MMKV mmkvWithAshmemID(Context context, String str, int i2, int i3, @Nullable String str2) throws RuntimeException {
        MMKV mmkv;
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String processNameByPID = MMKVContentProvider.getProcessNameByPID(context, Process.myPid());
        if (processNameByPID == null || processNameByPID.length() == 0) {
            simpleLog(MMKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (processNameByPID.contains(":")) {
            Uri uriContentUri = MMKVContentProvider.contentUri(context);
            if (uriContentUri == null) {
                simpleLog(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            simpleLog(MMKVLogLevel.LevelInfo, "getting parcelable mmkv in process, Uri = " + uriContentUri);
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", i2);
            bundle.putInt("KEY_MODE", i3);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            Bundle bundleCall = context.getContentResolver().call(uriContentUri, "mmkvFromAshmemID", str, bundle);
            if (bundleCall != null) {
                bundleCall.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelableMMKV = (ParcelableMMKV) bundleCall.getParcelable("KEY");
                if (parcelableMMKV != null && (mmkv = parcelableMMKV.toMMKV()) != null) {
                    simpleLog(MMKVLogLevel.LevelInfo, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    return mmkv;
                }
            }
        }
        simpleLog(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i2, i3 | 8, str2);
        if (mMKVWithIDAndSize != 0) {
            return new MMKV(mMKVWithIDAndSize);
        }
        throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + str + "]");
    }

    public static MMKV mmkvWithID(String str) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, 1, null, null), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static void onContentChangedByOuterProcess(String str) {
        MMKVContentChangeNotification mMKVContentChangeNotification = gContentChangeNotify;
        if (mMKVContentChangeNotification != null) {
            mMKVContentChangeNotification.onContentChangedByOuterProcess(str);
        }
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategicOnMMKVCRCCheckFail = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategicOnMMKVCRCCheckFail = mMKVHandler.onMMKVCRCCheckFail(str);
        }
        simpleLog(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategicOnMMKVCRCCheckFail);
        Integer num = recoverIndex.get(mMKVRecoverStrategicOnMMKVCRCCheckFail);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategicOnMMKVFileLengthError = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategicOnMMKVFileLengthError = mMKVHandler.onMMKVFileLengthError(str);
        }
        simpleLog(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategicOnMMKVFileLengthError);
        Integer num = recoverIndex.get(mMKVRecoverStrategicOnMMKVFileLengthError);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static void registerContentChangeNotify(MMKVContentChangeNotification mMKVContentChangeNotification) {
        gContentChangeNotify = mMKVContentChangeNotification;
        setWantsContentChangeNotify(gContentChangeNotify != null);
    }

    public static void registerHandler(MMKVHandler mMKVHandler) {
        gCallbackHandler = mMKVHandler;
        if (gCallbackHandler.wantLogRedirecting()) {
            setCallbackHandler(true, true);
            gWantLogReDirecting = true;
        } else {
            setCallbackHandler(false, true);
            gWantLogReDirecting = false;
        }
    }

    private native void removeValueForKey(long j2, String str);

    private static native void setCallbackHandler(boolean z2, boolean z3);

    private static native void setLogLevel(int i2);

    public static void setLogLevel(MMKVLogLevel mMKVLogLevel) {
        setLogLevel(logLevel2Int(mMKVLogLevel));
    }

    private static native void setWantsContentChangeNotify(boolean z2);

    private static void simpleLog(MMKVLogLevel mMKVLogLevel, String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = logLevel2Index.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private native void sync(boolean z2);

    private native long totalSize(long j2);

    public static void unregisterContentChangeNotify() {
        gContentChangeNotify = null;
        setWantsContentChangeNotify(false);
    }

    public static void unregisterHandler() {
        gCallbackHandler = null;
        setCallbackHandler(false, false);
        gWantLogReDirecting = false;
    }

    private native int valueSize(long j2, String str, boolean z2);

    public static native String version();

    private native int writeValueToNB(long j2, String str, long j3, int i2);

    public long actualSize() {
        return actualSize(this.nativeHandle);
    }

    @Nullable
    public native String[] allKeys();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public void async() {
        sync(false);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return containsKey(str);
    }

    public boolean containsKey(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public long count() {
        return count(this.nativeHandle);
    }

    @Nullable
    public native String cryptKey();

    public boolean decodeBool(String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    @Nullable
    public byte[] decodeBytes(String str) {
        return decodeBytes(str, (byte[]) null);
    }

    public double decodeDouble(String str) {
        return decodeDouble(this.nativeHandle, str, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
    }

    public float decodeFloat(String str) {
        return decodeFloat(this.nativeHandle, str, 0.0f);
    }

    public int decodeInt(String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public long decodeLong(String str) {
        return decodeLong(this.nativeHandle, str, 0L);
    }

    @Nullable
    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        return (T) decodeParcelable(str, cls, null);
    }

    @Nullable
    public String decodeString(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    @Nullable
    public Set<String> decodeStringSet(String str) {
        return decodeStringSet(str, (Set<String>) null);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public boolean encode(String str, boolean z2) {
        return encodeBool(this.nativeHandle, str, z2);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z2) {
        return decodeBool(this.nativeHandle, str, z2);
    }

    public byte[] getBytes(String str, @Nullable byte[] bArr) {
        return decodeBytes(str, bArr);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return decodeStringSet(str, set);
    }

    public int getValueActualSize(String str) {
        return valueSize(this.nativeHandle, str, true);
    }

    public int getValueSize(String str) {
        return valueSize(this.nativeHandle, str, false);
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                if (value instanceof Boolean) {
                    encodeBool(this.nativeHandle, key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    encodeInt(this.nativeHandle, key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    encodeLong(this.nativeHandle, key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    encodeFloat(this.nativeHandle, key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    encodeDouble(this.nativeHandle, key, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    encodeString(this.nativeHandle, key, (String) value);
                } else if (value instanceof Set) {
                    encode(key, (Set<String>) value);
                } else {
                    simpleLog(MMKVLogLevel.LevelError, "unknown type: " + value.getClass());
                }
            }
        }
        return all.size();
    }

    public native void lock();

    public native String mmapID();

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z2) {
        encodeBool(this.nativeHandle, str, z2);
        return this;
    }

    public SharedPreferences.Editor putBytes(String str, @Nullable byte[] bArr) {
        encode(str, bArr);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        encodeFloat(this.nativeHandle, str, f2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        encodeInt(this.nativeHandle, str, i2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        encodeLong(this.nativeHandle, str, j2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        encode(str, set);
        return this;
    }

    public native boolean reKey(@Nullable String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        removeValueForKey(str);
        return this;
    }

    public void removeValueForKey(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public native void removeValuesForKeys(String[] strArr);

    public void sync() {
        sync(true);
    }

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public int writeValueToNativeBuffer(String str, NativeBuffer nativeBuffer) {
        return writeValueToNB(this.nativeHandle, str, nativeBuffer.pointer, nativeBuffer.size);
    }

    public boolean decodeBool(String str, boolean z2) {
        return decodeBool(this.nativeHandle, str, z2);
    }

    @Nullable
    public byte[] decodeBytes(String str, @Nullable byte[] bArr) {
        byte[] bArrDecodeBytes = decodeBytes(this.nativeHandle, str);
        return bArrDecodeBytes != null ? bArrDecodeBytes : bArr;
    }

    public double decodeDouble(String str, double d2) {
        return decodeDouble(this.nativeHandle, str, d2);
    }

    public float decodeFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    public int decodeInt(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    public long decodeLong(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    @Nullable
    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, @Nullable T t2) {
        byte[] bArrDecodeBytes;
        Parcelable.Creator<?> creator;
        if (cls == null || (bArrDecodeBytes = decodeBytes(this.nativeHandle, str)) == null) {
            return t2;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
        parcelObtain.setDataPosition(0);
        try {
            String string = cls.toString();
            synchronized (mCreators) {
                creator = mCreators.get(string);
                if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                    mCreators.put(string, creator);
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(parcelObtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + string);
        } catch (Exception e2) {
            simpleLog(MMKVLogLevel.LevelError, e2.toString());
            return t2;
        } finally {
            parcelObtain.recycle();
        }
    }

    @Nullable
    public String decodeString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Nullable
    public Set<String> decodeStringSet(String str, @Nullable Set<String> set) {
        return decodeStringSet(str, set, HashSet.class);
    }

    public boolean encode(String str, int i2) {
        return encodeInt(this.nativeHandle, str, i2);
    }

    @Nullable
    public Set<String> decodeStringSet(String str, @Nullable Set<String> set, Class<? extends Set> cls) {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (strArrDecodeStringSet == null) {
            return set;
        }
        try {
            Set<String> setNewInstance = cls.newInstance();
            setNewInstance.addAll(Arrays.asList(strArrDecodeStringSet));
            return setNewInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public boolean encode(String str, long j2) {
        return encodeLong(this.nativeHandle, str, j2);
    }

    public static String initialize(Context context, MMKVLogLevel mMKVLogLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, mMKVLogLevel);
    }

    public boolean encode(String str, float f2) {
        return encodeFloat(this.nativeHandle, str, f2);
    }

    public static MMKV defaultMMKV(int i2, @Nullable String str) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(i2, str), "DefaultMMKV", i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str, int i2) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i2, null, null), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String str, double d2) {
        return encodeDouble(this.nativeHandle, str, d2);
    }

    public static String initialize(Context context, LibLoader libLoader) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", libLoader, MMKVLogLevel.LevelInfo);
    }

    public boolean encode(String str, @Nullable String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean encode(String str, @Nullable Set<String> set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public boolean encode(String str, @Nullable byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    public static String initialize(Context context, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", libLoader, mMKVLogLevel);
    }

    public static MMKV mmkvWithID(String str, int i2, @Nullable String str2) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i2, str2, null), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String str, @Nullable Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, null);
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, parcelable.describeContents());
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return encodeBytes(this.nativeHandle, str, bArrMarshall);
    }

    public static String initialize(Context context, String str) {
        return initialize(context, str, null, MMKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, String str, MMKVLogLevel mMKVLogLevel) {
        return initialize(context, str, null, mMKVLogLevel);
    }

    public static MMKV mmkvWithID(String str, String str2) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, 1, null, str2), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static String initialize(Context context, String str, LibLoader libLoader) {
        return initialize(context, str, libLoader, MMKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            disableProcessModeChecker();
        } else {
            enableProcessModeChecker();
        }
        return doInitialize(str, libLoader, mMKVLogLevel);
    }

    public static MMKV mmkvWithID(String str, int i2, @Nullable String str2, String str3) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i2, str2, str3), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    @Deprecated
    public static String initialize(String str) {
        return doInitialize(str, null, MMKVLogLevel.LevelInfo);
    }

    @Deprecated
    public static String initialize(String str, MMKVLogLevel mMKVLogLevel) {
        return doInitialize(str, null, mMKVLogLevel);
    }

    @Deprecated
    public static String initialize(String str, LibLoader libLoader) {
        return doInitialize(str, libLoader, MMKVLogLevel.LevelInfo);
    }

    @Deprecated
    public static String initialize(String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        return doInitialize(str, libLoader, mMKVLogLevel);
    }
}
