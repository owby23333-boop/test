package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class ad {
    private String a(String str) {
        int i2;
        try {
            File file = new File(str);
            if (!file.exists() || !file.canRead()) {
                return null;
            }
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            String str2 = null;
            do {
                i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                str2 = new String(bArr, 0, i2);
            } while (i2 <= 0);
            fileInputStream.close();
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        if ("nokia".equalsIgnoreCase(Build.MANUFACTURER) && ("Nokia_N1".equalsIgnoreCase(Build.DEVICE) || "N1".equalsIgnoreCase(Build.MODEL))) {
            return false;
        }
        try {
            Process processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), com.anythink.expressad.foundation.g.a.bN));
            while (true) {
                String line = bufferedReader.readLine();
                if (TextUtils.isEmpty(line)) {
                    break;
                }
                stringBuffer.append(line);
            }
            bufferedReader.close();
            String lowerCase = stringBuffer.toString().toLowerCase();
            if (lowerCase.contains("intel") || lowerCase.contains("x86")) {
                return true;
            }
            return lowerCase.contains("amd");
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean a() {
        try {
            String strA = a("/proc/tty/drivers");
            boolean z2 = !TextUtils.isEmpty(strA) && strA.contains("goldfish");
            if (z2) {
                return z2;
            }
            String strA2 = a("/proc/cpuinfo");
            if (TextUtils.isEmpty(strA2)) {
                return z2;
            }
            if (strA2.contains("goldfish")) {
                return true;
            }
            return z2;
        } catch (Exception unused) {
            return false;
        }
    }
}
