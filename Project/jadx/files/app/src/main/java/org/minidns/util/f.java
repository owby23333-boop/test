package org.minidns.util;

/* JADX INFO: compiled from: PlatformDetection.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static Boolean a;

    public static boolean a() {
        if (a == null) {
            try {
                Class.forName("android.Manifest");
                a = true;
            } catch (Exception unused) {
                a = false;
            }
        }
        return a.booleanValue();
    }
}
