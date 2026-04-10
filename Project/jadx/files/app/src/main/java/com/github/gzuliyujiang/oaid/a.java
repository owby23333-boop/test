package com.github.gzuliyujiang.oaid;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.github.gzuliyujiang.oaid.g.l;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: compiled from: DeviceID.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {
    private Application a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14887c;

    /* JADX INFO: compiled from: DeviceID.java */
    private static class b {
        static final a a = new a();
    }

    public static void a(Application application) {
        if (application == null) {
            return;
        }
        a aVar = b.a;
        aVar.a = application;
        String strE = e(application);
        if (TextUtils.isEmpty(strE)) {
            a(application, aVar);
            return;
        }
        aVar.b = strE;
        e.a("Client id is IMEI/MEID: " + aVar.b);
    }

    public static String b() {
        return a(a(), "MD5");
    }

    public static String c() {
        String str = b.a.f14887c;
        return str == null ? "" : str;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String imei = telephonyManager.getImei();
            return TextUtils.isEmpty(imei) ? telephonyManager.getMeid() : imei;
        } catch (Error e2) {
            e.a(e2);
            return "";
        } catch (Exception e3) {
            e.a(e3);
            return "";
        }
    }

    public static String e(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            e.a("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i2 < 23 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return d(context);
        }
        e.a("android.permission.READ_PHONE_STATE not granted");
        return "";
    }

    private static String f(Context context) {
        String line = "";
        if (context == null) {
            return "";
        }
        File fileC = c(context);
        if (fileC != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileC));
                try {
                    line = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e2) {
                e.a(e2);
            }
        }
        e.a("Get uuid from external storage: " + line);
        return line;
    }

    private static String g(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        e.a("Get uuid from shared preferences: " + string);
        return string;
    }

    private static String h(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        e.a("Get uuid from system settings: " + string);
        return string;
    }

    private a() {
    }

    public static String b(Context context) {
        String strH = h(context);
        if (TextUtils.isEmpty(strH)) {
            strH = f(context);
        }
        if (TextUtils.isEmpty(strH)) {
            strH = g(context);
        }
        if (!TextUtils.isEmpty(strH)) {
            return strH;
        }
        String string = UUID.randomUUID().toString();
        e.a("Generate uuid by random: " + string);
        b(context, string);
        c(context, string);
        a(context, string);
        return string;
    }

    private static void c(Context context, String str) {
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(context)) {
            e.a("android.permission.WRITE_SETTINGS not granted");
            return;
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            e.a("Save uuid to system settings: " + str);
        } catch (Exception e2) {
            e.a(e2);
        }
    }

    private static File c(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        boolean z2 = true;
        if (i2 >= 23 && (i2 >= 30 || context == null || context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
            z2 = false;
        }
        if (z2 && "mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    public static String d() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Error e2) {
            e.a(e2);
            return "";
        } catch (Exception e3) {
            e.a(e3);
            return "";
        }
    }

    public static String a() {
        String str = b.a.b;
        return str == null ? "" : str;
    }

    public static void a(Context context, c cVar) {
        l.a(context).a(cVar);
    }

    @SuppressLint({"HardwareIds"})
    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return (string == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    private static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        File fileC = c(context);
        if (fileC == null) {
            e.a("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileC));
            try {
                if (!fileC.exists()) {
                    fileC.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                e.a("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e2) {
            e.a(e2);
        }
    }

    private static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        e.a("Save uuid to shared preferences: " + str);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(str2).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Exception e2) {
            e.a(e2);
            return "";
        }
    }

    @Override // com.github.gzuliyujiang.oaid.c
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new OAIDException("OAID is empty"));
            return;
        }
        this.b = str;
        this.f14887c = str;
        e.a("Client id is OAID/AAID: " + this.b);
    }

    @Override // com.github.gzuliyujiang.oaid.c
    public void a(Exception exc) {
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            this.b = strD;
            e.a("Client id is WidevineID: " + this.b);
            return;
        }
        String strA = a((Context) this.a);
        if (!TextUtils.isEmpty(strA)) {
            this.b = strA;
            e.a("Client id is AndroidID: " + this.b);
            return;
        }
        this.b = b(this.a);
        e.a("Client id is GUID: " + this.b);
    }
}
