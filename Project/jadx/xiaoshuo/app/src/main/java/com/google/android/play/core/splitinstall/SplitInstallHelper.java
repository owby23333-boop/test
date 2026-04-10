package com.google.android.play.core.splitinstall;

import android.content.Context;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes7.dex */
public class SplitInstallHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.splitcompat.b.b f6958a = new com.google.android.play.core.splitcompat.b.b("SplitInstallHelper");

    private SplitInstallHelper() {
    }

    public static void loadLibrary(Context context, String str) {
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e) {
            String str2 = context.getApplicationInfo().nativeLibraryDir;
            String strMapLibraryName = System.mapLibraryName(str);
            boolean z = true;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(strMapLibraryName).length());
            sb.append(str2);
            sb.append("/");
            sb.append(strMapLibraryName);
            String string = sb.toString();
            if (new File(string).exists()) {
                System.load(string);
            } else {
                z = false;
            }
            if (!z) {
                throw e;
            }
        }
    }

    public static void updateAppInfo(Context context) {
        com.google.android.play.core.splitcompat.b.b bVar = f6958a;
        bVar.a("Calling dispatchPackageBroadcast!", new Object[0]);
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method method = cls.getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mAppThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objInvoke);
            obj.getClass().getMethod("dispatchPackageBroadcast", Integer.TYPE, String[].class).invoke(obj, 3, new String[]{context.getPackageName()});
            bVar.a("Calling dispatchPackageBroadcast", new Object[0]);
        } catch (Exception e) {
            f6958a.a(e, "Update app info with dispatchPackageBroadcast failed!", new Object[0]);
        }
    }
}
