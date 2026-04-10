package de.robv.android.xposed;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StrictMode;
import de.robv.android.xposed.XSharedPreferences;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class XSharedPreferences implements SharedPreferences {
    private static final String TAG = "XSharedPreferences";
    private static Loader sLoader = Loader.SYNC;
    private final File mFile;
    private long mFileSize;
    private long mLastModified;
    private boolean mLoaded;
    private Map<String, Object> mMap;

    public interface Loader {
        public static final Loader SYNC = new Loader() { // from class: de.robv.android.xposed.XSharedPreferences$Loader$$ExternalSyntheticLambda0
            @Override // de.robv.android.xposed.XSharedPreferences.Loader
            public final void run(XSharedPreferences xSharedPreferences, Runnable runnable) {
                XSharedPreferences.Loader.lambda$static$0(xSharedPreferences, runnable);
            }
        };
        public static final Loader ASYNC = new Loader() { // from class: de.robv.android.xposed.XSharedPreferences$Loader$$ExternalSyntheticLambda1
            @Override // de.robv.android.xposed.XSharedPreferences.Loader
            public final void run(XSharedPreferences xSharedPreferences, Runnable runnable) {
                new Thread("XSharedPreferences-load") { // from class: de.robv.android.xposed.XSharedPreferences.Loader.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        synchronized (xSharedPreferences) {
                            runnable.run();
                        }
                    }
                }.start();
            }
        };

        static /* synthetic */ void lambda$static$0(XSharedPreferences xSharedPreferences, Runnable runnable) {
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                runnable.run();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        }

        void run(XSharedPreferences xSharedPreferences, Runnable runnable);
    }

    public XSharedPreferences(File file) {
        this.mLoaded = false;
        this.mFile = file;
        startLoadFromDisk();
    }

    public XSharedPreferences(String str) {
        this(str, str + "_preferences");
    }

    public XSharedPreferences(String str, String str2) {
        this.mLoaded = false;
        this.mFile = new File(Environment.getDataDirectory(), "data/" + str + "/shared_prefs/" + str2 + ".xml");
        startLoadFromDisk();
    }

    private void awaitLoadedLocked() {
        while (!this.mLoaded) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0050 A[EXC_TOP_SPLITTER, PHI: r3
  0x0050: PHI (r3v9 java.io.BufferedInputStream) = (r3v8 java.io.BufferedInputStream), (r3v11 java.io.BufferedInputStream) binds: [B:27:0x003e, B:39:0x004e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadFromDiskLocked() throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r7.mLoaded
            if (r0 == 0) goto L6
            goto L78
        L6:
            java.io.File r0 = r7.mFile
            long r0 = r0.lastModified()
            r2 = 0
            long r3 = r7.mLastModified     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 org.xmlpull.v1.XmlPullParserException -> L34 java.io.FileNotFoundException -> L4c
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L16
            java.util.Map<java.lang.String, java.lang.Object> r2 = r7.mMap     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 org.xmlpull.v1.XmlPullParserException -> L34 java.io.FileNotFoundException -> L4c
            goto L55
        L16:
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 org.xmlpull.v1.XmlPullParserException -> L34 java.io.FileNotFoundException -> L4c
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 org.xmlpull.v1.XmlPullParserException -> L34 java.io.FileNotFoundException -> L4c
            java.io.File r5 = r7.mFile     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 org.xmlpull.v1.XmlPullParserException -> L34 java.io.FileNotFoundException -> L4c
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 org.xmlpull.v1.XmlPullParserException -> L34 java.io.FileNotFoundException -> L4c
            r5 = 4096(0x1000, float:5.74E-42)
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 org.xmlpull.v1.XmlPullParserException -> L34 java.io.FileNotFoundException -> L4c
            abygdfh.a.a()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a org.xmlpull.v1.XmlPullParserException -> L2c java.io.FileNotFoundException -> L2e
            throw r2     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a org.xmlpull.v1.XmlPullParserException -> L2c java.io.FileNotFoundException -> L2e
        L28:
            r0 = move-exception
            goto L44
        L2a:
            r4 = move-exception
            goto L37
        L2c:
            r4 = move-exception
            goto L37
        L2e:
            r4 = move-exception
            goto L4e
        L30:
            r0 = move-exception
            goto L43
        L32:
            r3 = move-exception
            goto L35
        L34:
            r3 = move-exception
        L35:
            r4 = r3
            r3 = r2
        L37:
            java.lang.String r5 = "XSharedPreferences"
            java.lang.String r6 = "getSharedPreferences"
            android.util.Log.w(r5, r6, r4)     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L55
            goto L50
        L41:
            r0 = move-exception
            r2 = r3
        L43:
            r3 = r2
        L44:
            if (r3 == 0) goto L4b
            r3.close()     // Catch: java.io.IOException -> L4a
            goto L4b
        L4a:
            r1 = move-exception
        L4b:
            throw r0
        L4c:
            r3 = move-exception
            r3 = r2
        L4e:
            if (r3 == 0) goto L55
        L50:
            r3.close()     // Catch: java.io.IOException -> L54
            goto L55
        L54:
            r3 = move-exception
        L55:
            r3 = 1
            r7.mLoaded = r3
            if (r2 == 0) goto L68
            r7.mMap = r2
            r7.mLastModified = r0
            java.io.File r0 = r7.mFile
            long r0 = r0.length()
            r7.mFileSize = r0
            goto L6f
        L68:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r7.mMap = r0
        L6f:
            boolean r0 = java.lang.Thread.holdsLock(r7)
            if (r0 == 0) goto L78
            r7.notifyAll()
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: de.robv.android.xposed.XSharedPreferences.loadFromDiskLocked():void");
    }

    public static void setLoader(Loader loader) {
        sLoader = loader;
    }

    private void startLoadFromDisk() {
        synchronized (this) {
            this.mLoaded = false;
        }
        sLoader.run(this, new Runnable() { // from class: de.robv.android.xposed.XSharedPreferences$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.loadFromDiskLocked();
            }
        });
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        synchronized (this) {
            awaitLoadedLocked();
            zContainsKey = this.mMap.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public SharedPreferences.Editor edit() {
        throw new UnsupportedOperationException("read-only implementation");
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap map;
        synchronized (this) {
            awaitLoadedLocked();
            map = new HashMap(this.mMap);
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            awaitLoadedLocked();
            Boolean bool = (Boolean) this.mMap.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public File getFile() {
        return this.mFile;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        synchronized (this) {
            awaitLoadedLocked();
            Float f2 = (Float) this.mMap.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        synchronized (this) {
            awaitLoadedLocked();
            Integer num = (Integer) this.mMap.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        synchronized (this) {
            awaitLoadedLocked();
            Long l = (Long) this.mMap.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        synchronized (this) {
            awaitLoadedLocked();
            String str3 = (String) this.mMap.get(str);
            if (str3 != null) {
                str2 = str3;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        synchronized (this) {
            awaitLoadedLocked();
            Set<String> set2 = (Set) this.mMap.get(str);
            if (set2 != null) {
                set = set2;
            }
        }
        return set;
    }

    public synchronized boolean hasFileChanged() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            boolean z = true;
            if (!this.mFile.exists()) {
                return true;
            }
            if (this.mFile.lastModified() == this.mLastModified) {
                if (this.mFile.length() == this.mFileSize) {
                    z = false;
                }
            }
            return z;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public boolean makeWorldReadable() {
        if (this.mFile.exists()) {
            return this.mFile.setReadable(true, false);
        }
        return false;
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }

    public synchronized void reload() {
        if (hasFileChanged()) {
            startLoadFromDisk();
        }
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }
}
