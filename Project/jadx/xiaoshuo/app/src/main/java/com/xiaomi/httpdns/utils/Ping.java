package com.xiaomi.httpdns.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes8.dex */
public class Ping {
    public static int a(String str) throws InterruptedException, IOException {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Runtime runtime = Runtime.getRuntime();
        String strTrim = str.trim();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Process processExec = runtime.exec(strTrim);
        processExec.waitFor();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        bufferedReader.close();
        String strTrim2 = sb.toString().toLowerCase().trim();
        if (!TextUtils.isEmpty(strTrim2) && strTrim2.indexOf("bytes from ") > 0) {
            return (int) (jElapsedRealtime2 - jElapsedRealtime);
        }
        return -1;
    }
}
