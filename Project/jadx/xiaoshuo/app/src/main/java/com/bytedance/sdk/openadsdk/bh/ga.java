package com.bytedance.sdk.openadsdk.bh;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: loaded from: classes10.dex */
public class ga {
    protected static String bf = null;
    protected static int d = 1;
    protected static String e = "images";
    protected static long ga = 15360;
    public static int m = 8;
    public static int p = 1;
    protected static int tg = 30;
    public static int v = 2;
    public static int vn = 0;
    public static int wu = 16;
    public static int xu = 32;
    public static int zk = 4;

    public static Bitmap bf(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static boolean e(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @RequiresApi(api = 23)
    public static boolean bf(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static File e() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + e);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            bf = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File e(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + "Camera");
            if (!file.exists()) {
                file.mkdirs();
            }
            Calendar calendar = Calendar.getInstance();
            File file2 = new File(file, (calendar.get(12) + "_" + calendar.get(13) + "_" + calendar.get(14)) + "_" + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File e(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File fileE = e(str);
            if (fileE != null && fileE.exists()) {
                byte[] bArrDecode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(fileE);
                try {
                    fileOutputStream.write(bArrDecode, 0, bArrDecode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return fileE;
                } catch (IOException unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean e(Context context, int i) {
        boolean zE;
        boolean zE2;
        if (vn == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zE = e(context, "android.permission.READ_MEDIA_IMAGES");
                zE2 = true;
            } else {
                zE = e(context, "android.permission.READ_EXTERNAL_STORAGE");
                zE2 = e(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean zE3 = e(context, "android.permission.CAMERA");
            boolean zE4 = e(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zE && zE2) {
                vn |= p;
            }
            if (zE3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                vn |= v;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                vn |= zk;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                vn |= m;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                vn |= wu;
            }
            if (zE4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                vn |= xu;
            }
        }
        return (vn & i) != 0;
    }

    @RequiresApi(api = 23)
    public static boolean e(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z2 = false;
            }
            return z2 && z;
        }
        z2 = true;
        if (z2) {
            return false;
        }
    }
}
