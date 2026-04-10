package com.xiaomi.phonenum.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.yuewen.i60;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes8.dex */
public class RomUtil {
    public static boolean checkPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private static String getSystemProperty(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return line;
        } catch (IOException unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static boolean isMIUIRom() {
        return (TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name")) && TextUtils.isEmpty(getSystemProperty(i60.w))) ? false : true;
    }
}
