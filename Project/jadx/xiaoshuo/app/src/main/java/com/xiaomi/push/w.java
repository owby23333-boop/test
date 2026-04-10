package com.xiaomi.push;

import android.util.Log;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f8335a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f8335a = map;
        map.put("FFD8FF", "jpg");
        map.put("89504E47", "png");
        map.put("47494638", "gif");
        map.put("474946", "gif");
        map.put("424D", "bmp");
    }

    public static long a(File file) {
        long jA = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i = 0; i < fileArrListFiles.length; i++) {
                jA += fileArrListFiles[i].isDirectory() ? a(fileArrListFiles[i]) : fileArrListFiles[i].length();
            }
        } catch (Exception e) {
            Log.e("FileUtils", "Get folder size error: " + e.getMessage());
        }
        return jA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m818a(File file) {
        long length;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                length = a(file);
            } else {
                length = file.length();
            }
            return length < 104857600;
        } catch (Exception e) {
            Log.e("FileUtils", "Check if internal file can be written error :" + e.getMessage());
            return false;
        }
    }
}
