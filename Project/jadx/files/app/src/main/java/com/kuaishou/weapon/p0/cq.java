package com.kuaishou.weapon.p0;

/* JADX INFO: loaded from: classes2.dex */
public class cq {
    private static volatile boolean a = false;
    private static volatile boolean b = true;

    static {
        try {
            a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            a = false;
        }
        b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return a;
    }

    public static boolean b() {
        return b;
    }
}
