package com.bytedance.sdk.openadsdk.v;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static int f1487a = 30;
    protected static int dl = 1;
    public static int e = 1;
    public static int fo = 4;
    protected static String g = null;
    protected static long gc = 15360;
    public static int gz = 2;
    public static int kb = 16;
    public static int m = 0;
    public static int uy = 8;
    public static int wp = 32;
    protected static String z = "images";

    protected static boolean z(Context context, String str) {
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

    protected static File z() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + z);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            g = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    protected static File z(String str) {
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

    protected static Bitmap g(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    protected static File z(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File fileZ = z(str);
            if (fileZ != null && fileZ.exists()) {
                byte[] bArrDecode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(fileZ);
                try {
                    fileOutputStream.write(bArrDecode, 0, bArrDecode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        wp.z(e2);
                    }
                    return fileZ;
                } catch (IOException unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            wp.z(e3);
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
                            wp.z(e4);
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

    public static boolean z(Context context, int i) {
        boolean z2;
        boolean z3;
        if (m == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                z2 = z(context, "android.permission.READ_MEDIA_IMAGES");
                z3 = true;
            } else {
                z2 = z(context, com.kuaishou.weapon.p0.g.i);
                z3 = z(context, com.kuaishou.weapon.p0.g.j);
            }
            boolean z4 = z(context, "android.permission.CAMERA");
            boolean z5 = z(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (z2 && z3) {
                m |= e;
            }
            if (z4 && packageManager.hasSystemFeature("android.hardware.camera")) {
                m |= gz;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                m |= fo;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                m |= uy;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                m |= kb;
            }
            if (z5 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                m |= wp;
            }
        }
        return (m & i) != 0;
    }

    public static boolean z(Context context) {
        boolean z2;
        boolean z3;
        if (Build.VERSION.SDK_INT >= 33) {
            z2 = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z2 = context.checkSelfPermission(com.kuaishou.weapon.p0.g.i) == 0;
            if (context.checkSelfPermission(com.kuaishou.weapon.p0.g.j) != 0) {
                z3 = false;
            }
            return !z3 && z2;
        }
        z3 = true;
        if (z3) {
        }
    }

    public static boolean g(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }
}
