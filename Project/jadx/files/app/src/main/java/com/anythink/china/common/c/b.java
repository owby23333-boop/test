package com.anythink.china.common.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String a = "anythink_myoffer_download";

    public static String a() {
        File file = null;
        if (e() == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                File externalFilesDir = e().getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(UUID.randomUUID());
                    File file2 = new File(externalFilesDir, sb.toString());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.mkdirs()) {
                        file2.delete();
                        file = externalFilesDir.getAbsoluteFile();
                    }
                    if (file != null) {
                        file = new File(file, a);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (file == null) {
            file = new File(e().getFilesDir().getAbsoluteFile() + File.separator + a);
        }
        return file.getAbsolutePath();
    }

    private static boolean b() {
        return c() > 104857600;
    }

    private static long c() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (Error unused) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    private static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Error unused) {
            return 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private static Context e() {
        try {
            return n.a().g().getApplicationContext();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean f() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static boolean g() {
        Context contextE = e();
        if (contextE == null) {
            return false;
        }
        try {
            return contextE.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", contextE.getPackageName()) == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static String b(String str) {
        return f.a(str);
    }

    private static File a(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID());
        File file2 = new File(file, sb.toString());
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    public static String a(String str) {
        String strA = a();
        if (strA == null) {
            return null;
        }
        return strA + File.separator + f.a(str);
    }
}
