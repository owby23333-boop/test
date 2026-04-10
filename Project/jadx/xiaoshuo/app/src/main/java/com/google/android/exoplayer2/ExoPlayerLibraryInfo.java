package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: loaded from: classes7.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;

    @Deprecated
    public static final String DEFAULT_USER_AGENT;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.14.2";
    public static final int VERSION_INT = 2014002;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.14.2";
    private static final HashSet<String> registeredModules;
    private static String registeredModulesString;

    static {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 57);
        sb.append("ExoPlayerLib/2.14.2 (Linux; Android ");
        sb.append(str);
        sb.append(") ");
        sb.append(VERSION_SLASHY);
        DEFAULT_USER_AGENT = sb.toString();
        registeredModules = new HashSet<>();
        registeredModulesString = "goog.exo.core";
    }

    private ExoPlayerLibraryInfo() {
    }

    public static synchronized void registerModule(String str) {
        if (registeredModules.add(str)) {
            String str2 = registeredModulesString;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
            sb.append(str2);
            sb.append(", ");
            sb.append(str);
            registeredModulesString = sb.toString();
        }
    }

    public static synchronized String registeredModules() {
        return registeredModulesString;
    }
}
