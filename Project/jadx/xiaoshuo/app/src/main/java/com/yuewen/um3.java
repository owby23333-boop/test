package com.yuewen;

/* JADX INFO: loaded from: classes17.dex */
public class um3 {
    public static boolean a(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            qt1.b("SoLoader", "An exception occurs", e);
            return false;
        }
    }
}
