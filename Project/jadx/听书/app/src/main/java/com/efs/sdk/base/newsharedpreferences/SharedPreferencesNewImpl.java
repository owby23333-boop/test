package com.efs.sdk.base.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.media3.exoplayer.ExoPlayer;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferencesNewImpl implements SharedPreferences {
    private static final String BACKUP_FILE_SUFFIX = ".bak";
    private static final int CONTENT_LENGTH_LOST = 1;
    private static final int CONTENT_OVER_SIZE = 7;
    private static final int DATA_TYPE_ERROR = 8;
    private static final int DATA_TYPE_INVALID = 9;
    private static final long DELAY_TIME_TO_SAVE = 1000;
    private static final byte FINISH_MARK = 18;
    private static final int FINISH_MARK_LENGTH = 1;
    private static final int ID_LENGTH = 4;
    private static final int INIT_EXCEPTION = 10;
    private static final int LOAD_BAK_FILE = 12;
    private static final int MAPPED_BUFFER_ERROR = 4;
    private static final int MAX_HANDLERTHREAD = 3;
    private static final long MAX_LOCK_FILE_TIME = 10000;
    private static final int MAX_NUM = Integer.MAX_VALUE;
    private static final int MAX_TRY_TIME = 6;
    private static final int MIN_INCREASE_LENGTH = 1024;
    private static final int MODIFY_ID_LOST = 2;
    private static final int OTHER_EXCEPTION = 11;
    private static final String TAG = "SharedPreferencesNew";
    private static final long TRY_RELOAD_INTERVAL = 60;
    private static final int TRY_SAVE_TIME_DELAY = 2000;
    private static final int TYPE_CAST_EXCEPTION = 13;
    private static final int VALUE_LOST = 3;
    private static final Object mFileMonitorSyncObj = new Object();
    private static HandlerThread[] mHandlerThreadPool = new HandlerThread[3];
    private static final int mSaveMessageID = 21310;
    private static ExecutorService sCachedThreadPool;
    private String mBackupFilePath;
    private int mCurTryTime;
    private Vector<SharedPreferences.Editor> mEditorList;
    private OnSharedPreferenceErrorListener mErrorListener;
    private File mFile;
    private FileChannel mFileChannel;
    private FileMonitor mFileMonitor;
    private Handler mHandler;
    private boolean mIsSaving;
    private final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    private boolean mLoaded;
    private final LinkedHashMap<String, Object> mMap;
    private MappedByteBuffer mMappedByteBuffer;
    private int mModifyErrorCnt;
    private int mModifyID;
    private RunnableEx mSaveRunnable;
    private final Object mSyncObj;
    private final Object mSyncSaveObj;
    private final Runnable mTryReloadRunnable;
    private long mTryReloadStartTime;

    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i, long j);
    }

    final boolean checkTypeValid(byte b) {
        return b == 4 || b == 2 || b == 1 || b == 3 || b == 5;
    }

    static {
        for (int i = 0; i < 3; i++) {
            mHandlerThreadPool[i] = new HandlerThread("newsp".concat(String.valueOf(i)));
            mHandlerThreadPool[i].start();
        }
        sCachedThreadPool = Executors.newCachedThreadPool();
    }

    class SUPPORTED_TYPE {
        static final byte TYPE_BOOLEAN = 4;
        static final byte TYPE_FLOAT = 2;
        static final byte TYPE_INT = 1;
        static final byte TYPE_LONG = 3;
        static final byte TYPE_STRING = 5;

        private SUPPORTED_TYPE() {
        }
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, null, false);
    }

    public SharedPreferencesNewImpl(File file, boolean z) {
        this(file, 0, null, z);
    }

    public SharedPreferencesNewImpl(File file, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, 0, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, i, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener, boolean z) {
        this.mMap = new LinkedHashMap<>();
        this.mListeners = new ArrayList<>();
        this.mLoaded = true;
        this.mSyncObj = new Object();
        this.mSyncSaveObj = new Object();
        this.mEditorList = new Vector<>();
        this.mIsSaving = false;
        this.mTryReloadRunnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int modifyID = SharedPreferencesNewImpl.this.getModifyID();
                if (modifyID <= 0 || modifyID == SharedPreferencesNewImpl.this.mModifyID) {
                    return;
                }
                SharedPreferencesNewImpl.this.saveInner(false);
            }
        };
        this.mSaveRunnable = new RunnableEx() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferencesNewImpl.this.saveInner(((Boolean) getArg()).booleanValue());
            }
        };
        this.mErrorListener = onSharedPreferenceErrorListener;
        this.mHandler = new Handler(getHandlerThread().getLooper());
        this.mFile = file;
        this.mBackupFilePath = file.getAbsolutePath() + BACKUP_FILE_SUFFIX;
        if (initBuffer()) {
            startLoadFromDisk(z);
        }
        this.mHandler.post(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file2 = new File(SharedPreferencesNewImpl.this.mBackupFilePath);
                    if (file2.exists()) {
                        return;
                    }
                    file2.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap map;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            map = new HashMap(this.mMap);
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    String str3 = (String) this.mMap.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.mFile;
                        String string = sb.append(file != null ? file.getAbsolutePath() : null).append("#").append(str).append(e).toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return str2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Integer num = (Integer) this.mMap.get(str);
                    if (num != null) {
                        i = num.intValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.mFile;
                        String string = sb.append(file != null ? file.getAbsolutePath() : null).append("#").append(str).append(e).toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Long l = (Long) this.mMap.get(str);
                    if (l != null) {
                        j = l.longValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.mFile;
                        String string = sb.append(file != null ? file.getAbsolutePath() : null).append("#").append(str).append(e).toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Float f2 = (Float) this.mMap.get(str);
                    if (f2 != null) {
                        f = f2.floatValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.mFile;
                        String string = sb.append(file != null ? file.getAbsolutePath() : null).append("#").append(str).append(e).toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Boolean bool = (Boolean) this.mMap.get(str);
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.mFile;
                        String string = sb.append(file != null ? file.getAbsolutePath() : null).append("#").append(str).append(e).toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        boolean zContainsKey;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            zContainsKey = this.mMap.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        awaitLoadedLocked();
        return new EditorImpl();
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(onSharedPreferenceChangeListener);
                if (this.mFileMonitor == null) {
                    try {
                        File file = new File(this.mBackupFilePath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.mFileMonitor = new FileMonitor(this.mBackupFilePath, 2);
                }
            }
            synchronized (mFileMonitorSyncObj) {
                this.mFileMonitor.startWatching();
            }
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mFileMonitor != null && this.mListeners.size() <= 0) {
                    this.mFileMonitor.stopWatching();
                }
            }
        }
    }

    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mModified = new HashMap<>();

        public EditorImpl() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this) {
                this.mModified.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this) {
                this.mModified.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this) {
                this.mModified.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.mModified.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.mModified.put(str, null);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            SharedPreferencesNewImpl.this.save(this, false, true, false);
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            SharedPreferencesNewImpl.this.save(this, false, false, true);
        }

        final boolean doClear() {
            boolean z;
            synchronized (this) {
                z = this.mClear;
                this.mClear = false;
            }
            return z;
        }

        final HashMap<String, Object> getAll() {
            HashMap<String, Object> map;
            synchronized (this) {
                map = this.mModified;
            }
            return map;
        }
    }

    private boolean merge(SharedPreferences.Editor editor, Map map, boolean z) {
        if (editor == null) {
            return false;
        }
        EditorImpl editorImpl = (EditorImpl) editor;
        boolean zDoClear = editorImpl.doClear();
        if (zDoClear) {
            map.clear();
            this.mEditorList.clear();
        }
        HashMap<String, Object> all = editorImpl.getAll();
        if (all.size() == 0) {
            return zDoClear;
        }
        synchronized (editor) {
            for (Map.Entry<String, Object> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.remove(key);
                } else {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                    map.put(key, value);
                }
                if (!z) {
                    notifyDataChanged(key);
                }
            }
        }
        return true;
    }

    private void notifyDataChanged(String str) {
        if (this.mListeners.size() > 0) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mListeners.get(i);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReload() {
        if (SystemClock.uptimeMillis() - this.mTryReloadStartTime > TRY_RELOAD_INTERVAL) {
            this.mTryReloadStartTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mTryReloadRunnable);
            this.mHandler.post(this.mTryReloadRunnable);
        }
    }

    private boolean tryReloadWhenSave() {
        int modifyID = getModifyID();
        if (modifyID <= 0 || modifyID == this.mModifyID) {
            return false;
        }
        load(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInner(final boolean z) {
        synchronized (this.mSyncSaveObj) {
            FileLock fileLockLockFile = lockFile(false);
            if (fileLockLockFile != null) {
                try {
                    this.mIsSaving = true;
                    if (tryReloadWhenSave()) {
                        mergeWhenReload();
                        notifyDataChanged(null);
                    }
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        if (onSharedPreferenceErrorListener != null) {
                            onSharedPreferenceErrorListener.onError(th.getMessage(), 11, -1L);
                            try {
                                fileLockLockFile.release();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            fileLockLockFile.release();
                        }
                    } finally {
                        try {
                            fileLockLockFile.release();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        this.mIsSaving = false;
                    }
                }
                synchronized (this.mMap) {
                    if (this.mEditorList.size() <= 0) {
                        return;
                    }
                    saveToMappedBuffer(obtainTotalBytes(), z);
                    backup();
                    try {
                        fileLockLockFile.release();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    this.mIsSaving = false;
                }
            }
            int i = this.mCurTryTime;
            this.mCurTryTime = i + 1;
            if (i < 6) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferencesNewImpl.this.saveInner(z);
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(SharedPreferences.Editor editor, boolean z, boolean z2, boolean z3) {
        if (editor == null) {
            return;
        }
        synchronized (this.mMap) {
            boolean z4 = false;
            this.mCurTryTime = 0;
            if (merge(editor, this.mMap, false)) {
                z4 = true;
            } else if (this.mEditorList.size() == 0) {
                return;
            }
            if (z4) {
                this.mEditorList.add(editor);
            }
            if (z2) {
                saveInner(z);
                return;
            }
            long j = z3 ? 1000L : 0L;
            this.mSaveRunnable.setArg(Boolean.valueOf(z));
            Message messageObtain = Message.obtain(this.mHandler, this.mSaveRunnable);
            messageObtain.what = mSaveMessageID;
            this.mHandler.sendMessageDelayed(messageObtain, j);
        }
    }

    private Pair<Integer, byte[][]> getDataBytes() {
        byte[][] bArr;
        ArrayList arrayList;
        synchronized (this.mMap) {
            bArr = new byte[this.mMap.size() * 5][];
            arrayList = new ArrayList(this.mMap.entrySet());
            this.mEditorList.clear();
        }
        int i = 0;
        int i2 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && str.trim().length() > 0 && value != null) {
                byte[] bytes = str.getBytes();
                byte[] bArrIntToBytes = ByteIntUtils.intToBytes(bytes.length);
                bArr[i2] = bArrIntToBytes;
                bArr[i2 + 1] = bytes;
                int length = i + bArrIntToBytes.length + bytes.length;
                byte[] bytes2 = getBytes(value);
                byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(bytes2.length);
                bArr[i2 + 2] = bArrIntToBytes2;
                bArr[i2 + 3] = bytes2;
                int length2 = length + bArrIntToBytes2.length + bytes2.length;
                bArr[i2 + 4] = new byte[]{(byte) getObjectType(value)};
                i = length2 + 1;
                i2 += 5;
            }
        }
        return new Pair<>(Integer.valueOf(i), bArr);
    }

    private void saveToMappedBuffer(byte[] bArr, boolean z) {
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            safeBufferPut(this.mMappedByteBuffer, bArr);
            if (z) {
                this.mMappedByteBuffer.force();
            }
        }
    }

    private int increaseModifyID() {
        int i = (this.mModifyID + 1) % Integer.MAX_VALUE;
        this.mModifyID = i;
        return i;
    }

    private int getContentLength() {
        if (this.mMappedByteBuffer == null || this.mFileChannel == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int iBytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(4);
            byte b = this.mMappedByteBuffer.get();
            if ((b == 18 || b == getMaskByte(bArr)) && iBytesToInt >= 0) {
                if (iBytesToInt > Integer.MAX_VALUE) {
                    iBytesToInt = Integer.MAX_VALUE;
                }
                return iBytesToInt;
            }
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
            if (onSharedPreferenceErrorListener != null) {
                File file = this.mFile;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.mFile;
                onSharedPreferenceErrorListener.onError(absolutePath, 1, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    private void reallocBuffer() {
        int contentLength;
        if (this.mMappedByteBuffer == null) {
            return;
        }
        synchronized (this.mSyncObj) {
            try {
                contentLength = getContentLength();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (contentLength > this.mMappedByteBuffer.capacity()) {
                allocBuffer(contentLength + 1024);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x00ba A[DONT_GENERATE, FINALLY_INSNS] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void load(boolean r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L6
            r2 = r0
            goto La
        L6:
            java.nio.channels.FileLock r2 = r8.lockFile(r1)
        La:
            if (r2 != 0) goto L15
            if (r9 == 0) goto Lf
            goto L15
        Lf:
            if (r9 != 0) goto L14
            r8.loadFromBakFile()
        L14:
            return
        L15:
            r9 = 0
            r8.reallocBuffer()     // Catch: java.lang.Throwable -> La8
            java.nio.MappedByteBuffer r3 = r8.mMappedByteBuffer     // Catch: java.lang.Throwable -> La8
            if (r3 == 0) goto L8b
            int r3 = r3.capacity()     // Catch: java.lang.Throwable -> La8
            if (r3 != 0) goto L24
            goto L8b
        L24:
            int r3 = r8.getContentLength()     // Catch: java.lang.Throwable -> La8
            long r3 = (long) r3
            r5 = 10
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto L4c
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            if (r9 == 0) goto L3e
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L41
        L3e:
            r8.loadFromBakFile()
        L41:
            if (r2 == 0) goto L4b
            r2.release()     // Catch: java.lang.Exception -> L47
            goto L4b
        L47:
            r9 = move-exception
            r9.printStackTrace()
        L4b:
            return
        L4c:
            int r5 = r8.getModifyID()     // Catch: java.lang.Throwable -> La8
            r8.mModifyID = r5     // Catch: java.lang.Throwable -> La8
            if (r5 <= 0) goto L6c
            java.lang.Object r5 = r8.mSyncObj     // Catch: java.lang.Throwable -> La8
            monitor-enter(r5)     // Catch: java.lang.Throwable -> La8
            java.nio.MappedByteBuffer r6 = r8.mMappedByteBuffer     // Catch: java.lang.Throwable -> L69
            r7 = 10
            r6.position(r7)     // Catch: java.lang.Throwable -> L69
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L69
            int r3 = r3 - r7
            byte[] r0 = new byte[r3]     // Catch: java.lang.Throwable -> L69
            java.nio.MappedByteBuffer r3 = r8.mMappedByteBuffer     // Catch: java.lang.Throwable -> L69
            r8.safeBufferGet(r3, r0)     // Catch: java.lang.Throwable -> L69
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L69
            goto L6c
        L69:
            r3 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L69
            throw r3     // Catch: java.lang.Throwable -> La8
        L6c:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> L71
            goto L75
        L71:
            r1 = move-exception
            r1.printStackTrace()
        L75:
            if (r9 == 0) goto L7d
            if (r0 != 0) goto L80
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L80
        L7d:
            r8.loadFromBakFile()
        L80:
            if (r2 == 0) goto L8a
            r2.release()     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r9 = move-exception
            r9.printStackTrace()
        L8a:
            return
        L8b:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> L90
            goto L94
        L90:
            r0 = move-exception
            r0.printStackTrace()
        L94:
            if (r9 == 0) goto L9a
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L9d
        L9a:
            r8.loadFromBakFile()
        L9d:
            if (r2 == 0) goto La7
            r2.release()     // Catch: java.lang.Exception -> La3
            goto La7
        La3:
            r9 = move-exception
            r9.printStackTrace()
        La7:
            return
        La8:
            r3 = move-exception
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> Lae
            goto Lb2
        Lae:
            r1 = move-exception
            r1.printStackTrace()
        Lb2:
            if (r9 == 0) goto Lba
            if (r0 != 0) goto Lbd
            int r9 = r8.mModifyID
            if (r9 >= 0) goto Lbd
        Lba:
            r8.loadFromBakFile()
        Lbd:
            if (r2 == 0) goto Lc7
            r2.release()     // Catch: java.lang.Exception -> Lc3
            goto Lc7
        Lc3:
            r9 = move-exception
            r9.printStackTrace()
        Lc7:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.load(boolean):void");
    }

    final int getModifyID() {
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        if (this.mMappedByteBuffer == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(5);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int iBytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(9);
            byte b = this.mMappedByteBuffer.get();
            if ((b == 18 || b == getMaskByte(bArr)) && iBytesToInt >= 0) {
                return iBytesToInt;
            }
            int i = this.mModifyErrorCnt + 1;
            this.mModifyErrorCnt = i;
            if (i < 3 && (onSharedPreferenceErrorListener = this.mErrorListener) != null) {
                File file = this.mFile;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.mFile;
                onSharedPreferenceErrorListener.onError(absolutePath, 2, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    private void startLoadFromDisk(boolean z) {
        synchronized (this) {
            this.mLoaded = false;
        }
        Runnable runnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.loadFromDiskLocked();
                }
            }
        };
        if (z) {
            runnable.run();
        } else {
            sCachedThreadPool.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() {
        if (this.mLoaded) {
            return;
        }
        load(false);
        this.mLoaded = true;
        notifyAll();
    }

    private void awaitLoadedLocked() {
        if (!this.mLoaded) {
            synchronized (this) {
                while (!this.mLoaded) {
                    try {
                        wait();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        tryReload();
    }

    private boolean safeBufferGet(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int iPosition = mappedByteBuffer.position();
        if (iPosition + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private MappedByteBuffer allocBuffer(int i) {
        MappedByteBuffer mappedByteBuffer = this.mMappedByteBuffer;
        int iPosition = mappedByteBuffer != null ? mappedByteBuffer.position() : 0;
        try {
            this.mMappedByteBuffer = this.mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MappedByteBuffer mappedByteBuffer2 = this.mMappedByteBuffer;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(iPosition);
        }
        return this.mMappedByteBuffer;
    }

    private boolean initBuffer() {
        boolean zExists = true;
        if (this.mMappedByteBuffer != null) {
            return true;
        }
        try {
            if (!this.mFile.exists()) {
                this.mFile.getParentFile().mkdirs();
                this.mFile.createNewFile();
                zExists = new File(this.mBackupFilePath).exists();
            } else if (this.mFile.length() == 0) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    onSharedPreferenceErrorListener.onError(this.mFile.getAbsolutePath(), 4, this.mFile.length());
                }
                zExists = false;
            }
            this.mFileChannel = new RandomAccessFile(this.mFile, "rw").getChannel();
            allocBuffer(10);
            if (zExists) {
                return zExists;
            }
            initFileHeader();
            return zExists;
        } catch (Exception e) {
            e.printStackTrace();
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
            if (onSharedPreferenceErrorListener2 != null) {
                onSharedPreferenceErrorListener2.onError(this.mFile.getAbsolutePath() + " " + e.getCause(), 10, -1L);
            }
            return false;
        }
    }

    private FileLock lockFile(boolean z) throws IOException {
        FileChannel fileChannel = this.mFileChannel;
        FileLock fileLockTryLock = null;
        if (fileChannel == null) {
            return null;
        }
        if (z) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            while (fileLockTryLock == null) {
                try {
                    fileLockTryLock = this.mFileChannel.tryLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fileLockTryLock == null) {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (SystemClock.uptimeMillis() - jUptimeMillis > 10000) {
                    return fileLockTryLock;
                }
            }
            return fileLockTryLock;
        }
        try {
            return fileChannel.tryLock();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final void setSharedPreferenceErrorListener(OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.mErrorListener = onSharedPreferenceErrorListener;
    }

    private void safeBufferPut(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
            mappedByteBuffer = allocBuffer(mappedByteBuffer.position() + bArr.length + 1024);
        }
        mappedByteBuffer.put(bArr);
    }

    private void mergeWhenReload() {
        synchronized (this.mMap) {
            if (this.mEditorList.size() > 0) {
                Iterator<SharedPreferences.Editor> it = this.mEditorList.iterator();
                while (it.hasNext()) {
                    merge(it.next(), this.mMap, true);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        r3 = r12.mErrorListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        if (r3 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        r5 = r12.mFile;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        r5 = r5.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        r3.onError(r5, 8, r13.length);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseBytesIntoMap(byte[] r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.parseBytesIntoMap(byte[], boolean):boolean");
    }

    private Pair<byte[], Integer> getOneString(byte[] bArr, int i) throws Exception {
        int i2;
        byte[] bArr2;
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, i, bArr3, 0, 4);
        int i3 = i + 4;
        byte b = bArr[i3];
        if (b != 18 && b != getMaskByte(bArr3)) {
            throw new Exception("length string's finish mark missing");
        }
        int i4 = i3 + 1;
        int iBytesToInt = ByteIntUtils.bytesToInt(bArr3);
        if (iBytesToInt < 0 || (i2 = i4 + iBytesToInt) >= bArr.length || iBytesToInt > Integer.MAX_VALUE) {
            throw new Exception("length string is invalid");
        }
        if (iBytesToInt != 0) {
            bArr2 = new byte[iBytesToInt];
            System.arraycopy(bArr, i4, bArr2, 0, iBytesToInt);
            byte b2 = bArr[i2];
            if (b2 != 18 && b2 != getMaskByte(bArr2)) {
                throw new Exception("Stored bytes' finish mark missing");
            }
            i4 = i2;
        } else {
            bArr2 = null;
        }
        return new Pair<>(bArr2, Integer.valueOf(i4 + 1));
    }

    private byte[] obtainTotalBytes() {
        Pair<Integer, byte[][]> dataBytes = getDataBytes();
        int iIntValue = ((Integer) dataBytes.first).intValue() + 10 + (((byte[][]) dataBytes.second).length * 1);
        if (iIntValue > Integer.MAX_VALUE) {
            iIntValue = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[iIntValue];
        byte[] bArrIntToBytes = ByteIntUtils.intToBytes(iIntValue);
        System.arraycopy(bArrIntToBytes, 0, bArr, 0, bArrIntToBytes.length);
        int length = bArrIntToBytes.length + 0;
        bArr[length] = getMaskByte(bArrIntToBytes);
        int i = length + 1;
        byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(increaseModifyID());
        System.arraycopy(bArrIntToBytes2, 0, bArr, i, bArrIntToBytes2.length);
        int length2 = i + bArrIntToBytes2.length;
        bArr[length2] = getMaskByte(bArrIntToBytes2);
        int i2 = length2 + 1;
        byte[][] bArr2 = (byte[][]) dataBytes.second;
        int length3 = bArr2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length3) {
                break;
            }
            byte[] bArr3 = bArr2[i3];
            if (bArr3 != null) {
                if (bArr3.length + i2 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr3, 0, bArr, i2, bArr3.length);
                    int length4 = i2 + bArr3.length;
                    bArr[length4] = getMaskByte(bArr3);
                    i2 = length4 + 1;
                } else {
                    StringBuilder sb = new StringBuilder("Write too much data in ");
                    File file = this.mFile;
                    Log.e(TAG, sb.append(file != null ? file.getAbsolutePath() : null).toString());
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(file2 != null ? file2.getAbsolutePath() : null, 7, -1L);
                    }
                }
            }
            i3++;
        }
        return bArr;
    }

    private void initFileHeader() {
        if (this.mMappedByteBuffer != null) {
            byte[] bArr = new byte[10];
            byte[] bArrIntToBytes = ByteIntUtils.intToBytes(0);
            System.arraycopy(bArrIntToBytes, 0, bArr, 0, 4);
            bArr[4] = getMaskByte(bArrIntToBytes);
            byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(0);
            System.arraycopy(bArrIntToBytes2, 0, bArr, 5, 4);
            bArr[9] = getMaskByte(bArrIntToBytes2);
            this.mMappedByteBuffer.position(0);
            this.mMappedByteBuffer.put(bArr);
        }
    }

    private int getObjectType(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        return obj instanceof Long ? 3 : 0;
    }

    private Object getObjectByType(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            if (i == 5) {
                return new String(bArr);
            }
            boolean z = true;
            if (i == 4) {
                if (bArr[0] != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            if (i == 2) {
                return Float.valueOf(ByteFloatUtils.bytesToFloat(bArr));
            }
            if (i == 1) {
                return Integer.valueOf(ByteIntUtils.bytesToInt(bArr));
            }
            if (i == 3) {
                return Long.valueOf(ByteLongUtils.bytesToLong(bArr));
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private byte[] getBytes(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String) {
                return ((String) obj).getBytes();
            }
            if (obj instanceof Boolean) {
                int i = 1;
                byte[] bArr = new byte[1];
                if (!((Boolean) obj).booleanValue()) {
                    i = 0;
                }
                bArr[0] = (byte) i;
                return bArr;
            }
            if (obj instanceof Float) {
                return ByteFloatUtils.floatToBytes(((Float) obj).floatValue());
            }
            if (obj instanceof Integer) {
                return ByteIntUtils.intToBytes(((Integer) obj).intValue());
            }
            if (obj instanceof Long) {
                return ByteLongUtils.longToBytes(((Long) obj).longValue());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static class ByteLongUtils {
        private ByteLongUtils() {
        }

        public static byte[] longToBytes(long j) {
            return ByteBuffer.allocate(8).putLong(j).array();
        }

        public static long bytesToLong(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }
    }

    static class ByteIntUtils {
        private ByteIntUtils() {
        }

        public static byte[] intToBytes(int i) {
            return ByteBuffer.allocate(4).putInt(i).array();
        }

        public static int bytesToInt(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }
    }

    static class ByteFloatUtils {
        private ByteFloatUtils() {
        }

        public static byte[] floatToBytes(float f) {
            return ByteBuffer.allocate(4).putFloat(f).array();
        }

        public static float bytesToFloat(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }
    }

    private void backup() {
        Throwable th;
        Closeable closeable;
        FileOutputStream fileOutputStream;
        FileChannel channel = null;
        try {
            File file = new File(this.mBackupFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
        }
        try {
            channel = fileOutputStream.getChannel();
            this.mFileChannel.transferTo(0L, this.mMappedByteBuffer.capacity(), channel);
            safeClose(fileOutputStream);
            safeClose(channel);
        } catch (Throwable th3) {
            closeable = channel;
            channel = fileOutputStream;
            th = th3;
            try {
                th.printStackTrace();
            } finally {
                safeClose(channel);
                safeClose(closeable);
            }
        }
    }

    private void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12 */
    private boolean loadFromBakFile() {
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        int length = 0;
        boolean bytesIntoMap = true;
        RandomAccessFile randomAccessFile2 = null;
        byte[] bArr2 = null;
        try {
            randomAccessFile = new RandomAccessFile(this.mBackupFilePath, "r");
        } catch (Throwable th) {
            th = th;
            bArr = null;
        }
        try {
            byte[] bArr3 = new byte[4];
            randomAccessFile.read(bArr3, 0, 4);
            int iBytesToInt = ByteIntUtils.bytesToInt(bArr3);
            if (iBytesToInt <= 10) {
                safeClose(randomAccessFile);
                try {
                    parseBytesIntoMap(null, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
            if (iBytesToInt > Integer.MAX_VALUE) {
                iBytesToInt = Integer.MAX_VALUE;
            }
            if (iBytesToInt > randomAccessFile.length()) {
                iBytesToInt = (int) randomAccessFile.length();
            }
            int i = iBytesToInt - 10;
            bArr2 = new byte[i];
            randomAccessFile.seek(10L);
            randomAccessFile.read(bArr2);
            safeClose(randomAccessFile);
            try {
                bytesIntoMap = parseBytesIntoMap(bArr2, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
            if (onSharedPreferenceErrorListener != null) {
                onSharedPreferenceErrorListener.onError(this.mBackupFilePath + "##" + bytesIntoMap, 12, i);
            }
        } catch (Throwable th2) {
            th = th2;
            bArr = bArr2;
            randomAccessFile2 = randomAccessFile;
            try {
                th.printStackTrace();
                safeClose(randomAccessFile2);
                try {
                    bytesIntoMap = parseBytesIntoMap(bArr, false);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
                if (onSharedPreferenceErrorListener2 != null) {
                    onSharedPreferenceErrorListener2.onError(this.mBackupFilePath + "#" + th.getCause() + "#" + bytesIntoMap, 12, bArr != null ? bArr.length : 0);
                }
            } finally {
            }
        }
        return bytesIntoMap;
    }

    private byte getBCCCode(byte[] bArr) {
        byte b = 0;
        for (byte b2 : bArr) {
            b = (byte) (b ^ b2);
        }
        return b;
    }

    private byte getMaskByte(byte[] bArr) {
        return getBCCCode(bArr);
    }

    final class FileMonitor extends FileObserver {
        public FileMonitor(String str, int i) {
            super(str, i);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, String str) {
            if (SharedPreferencesNewImpl.this.mListeners.size() > 0) {
                SharedPreferencesNewImpl.this.tryReload();
            } else {
                stopWatching();
            }
        }
    }

    final void onDestroy() {
        if (this.mIsSaving || this.mHandler.hasMessages(mSaveMessageID)) {
            saveInner(false);
        }
    }

    private HandlerThread getHandlerThread() {
        int iNextInt = new Random().nextInt();
        if (iNextInt < 0) {
            iNextInt = -iNextInt;
        }
        return mHandlerThreadPool[iNextInt % 3];
    }

    public static abstract class RunnableEx implements Runnable {
        private Object mArg;

        public void setArg(Object obj) {
            this.mArg = obj;
        }

        public Object getArg() {
            return this.mArg;
        }
    }
}
