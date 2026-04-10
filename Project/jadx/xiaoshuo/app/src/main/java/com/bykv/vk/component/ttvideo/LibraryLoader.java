package com.bykv.vk.component.ttvideo;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.log.MyLog;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private static Loader sLoader;

    public interface Loader {
        void loadLibrary(String str) throws Exception;

        void loadLibraryFromPath(String str) throws Exception;
    }

    public static void loadLibrary(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        if (loader == null) {
            System.loadLibrary(str);
            return;
        }
        MyLog.d(TAG, "Loading [" + str + "] with external loader " + loader);
        loader.loadLibrary(str);
    }

    public static void loadLibraryFromPath(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new Exception("Not found library '" + str + "' file.");
        }
        if (loader == null) {
            System.load(file.getAbsolutePath());
            return;
        }
        MyLog.d(TAG, "Loading [" + file.getAbsolutePath() + "] with external loader " + loader);
        loader.loadLibraryFromPath(file.getAbsolutePath());
    }

    public static void setupLibraryLoader(Loader loader) {
        sLoader = loader;
    }
}
