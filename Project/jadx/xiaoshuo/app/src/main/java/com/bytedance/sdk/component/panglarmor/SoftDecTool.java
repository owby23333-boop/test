package com.bytedance.sdk.component.panglarmor;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.hardware.display.DisplayManager;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SoftDecTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f2096a = false;
    private static int bf = 0;
    private static volatile Throwable bh = null;
    private static String d = "";
    private static long e = 0;
    public static volatile boolean f = false;
    private static String ga = null;
    public static volatile boolean h = false;
    private static String m = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAq2McHs8OR+UWXltf\njH/bmYT3Hb8LqR3zBWDNcWILrsnH6Z6m27WEvnheCc+cj4C/FeESA3/4NlSatE92\n8H5RkQIDAQABAkEAl9Ae5Jt8hurCOaqupIHNP9usGclUxuUkk6r/0GOM/bGDoyAz\ntcg3Py8AgUMLXQ7oCcTNbMVdQkmq75VF0CMvkQIhAN0+qNpyKVoqnItYOV51wKnS\nUiHsTrXma8fqGcJJZrhvAiEAxk9uI6pa15ZIcpNfZii72EOXBS4qCRv3XtdDEfVs\nlf8CIQChtTO7fmelJLII0zITTaPFPBmV+99H6qPqmbu8GuQ+dwIgF/vHQDz8G5Kr\nVGAKa5qFjVQvUYsRvmRJeIjkLanW5hUCIQC08JyiKPKlSbbdy8ARR6CNvhPtKbOL\nzkES4zlsXAvlww==";
    private static volatile boolean p = false;
    private static bf t = null;
    private static Application tg = null;
    private static volatile DisplayManager.DisplayListener v = null;
    private static boolean vn = false;
    private static volatile boolean wu = false;
    private static volatile boolean xu = false;
    private static String zk = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==";

    public static String a(Application application, String str) {
        tg = application;
        ga = str;
        final Handler handlerE = v.e();
        handlerE.post(new Runnable() { // from class: com.bytedance.sdk.component.panglarmor.SoftDecTool.2
            @Override // java.lang.Runnable
            public void run() {
                Throwable th;
                try {
                    bf unused = SoftDecTool.t = bf.e(SoftDecTool.tg);
                    SoftDecTool.bf(handlerE);
                    tg.e(SoftDecTool.tg);
                    Object[] objArrA = SoftDecTool.a(1001, new Object[]{SoftDecTool.tg});
                    if (((Integer) objArrA[0]).intValue() != 4) {
                        if (((Integer) objArrA[0]).intValue() == 0) {
                            String unused2 = SoftDecTool.d = String.valueOf(objArrA[1]);
                            return;
                        }
                        return;
                    }
                    Object obj = objArrA[1];
                    Throwable th2 = null;
                    if (obj == null) {
                        if (SoftDecTool.bh != null) {
                            th = SoftDecTool.bh;
                            Throwable unused3 = SoftDecTool.bh = null;
                        }
                        String unused4 = SoftDecTool.d = SoftDecTool.bf(th2, 4);
                    }
                    th = (Throwable) obj;
                    Throwable unused5 = SoftDecTool.bh = null;
                    th2 = th;
                    String unused42 = SoftDecTool.d = SoftDecTool.bf(th2, 4);
                } catch (Throwable th3) {
                    String unused6 = SoftDecTool.d = SoftDecTool.bf(th3, 3);
                }
            }
        });
        return TextUtils.isEmpty(d) ? "eyJzdHRzIjoxfQ==" : d;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[SYNTHETIC] */
    @com.bytedance.component.sdk.annotation.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglarmor.SoftDecTool.b():int");
    }

    private static native String b(int i, Object[] objArr);

    @DungeonFlag
    public static void c(final MotionEvent motionEvent, final Object obj) {
        if (motionEvent == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            v.e().post(new Runnable() { // from class: com.bytedance.sdk.component.panglarmor.SoftDecTool.4
                @Override // java.lang.Runnable
                public void run() {
                    SoftDecTool.a(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), obj});
                }
            });
        }
    }

    public static String ccc(String str, long j) {
        try {
            bf bfVar = t;
            if (bfVar != null) {
                return bfVar.e(str, j);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @DungeonFlag
    public static boolean detectHostLocalIp(final String str) {
        try {
            v.e().post(new Runnable() { // from class: com.bytedance.sdk.component.panglarmor.SoftDecTool.1
                @Override // java.lang.Runnable
                public void run() {
                    String hostAddress;
                    try {
                        hostAddress = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception unused) {
                        hostAddress = "";
                    }
                    if (hostAddress.equals("127.0.0.1") || hostAddress.equals("::1")) {
                        boolean unused2 = SoftDecTool.vn = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        return vn;
    }

    @DungeonFlag
    public static PrivateKey getPrivateKey() throws Exception {
        try {
            return KeyFactory.getInstance(com.alipay.sdk.m.p.d.f1901a).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(m.getBytes(Charset.forName("UTF-8")), 0)));
        } catch (Exception e2) {
            throw new Exception("Init public key failed", e2);
        }
    }

    @DungeonFlag
    public static PublicKey getPublicKey() throws Exception {
        return KeyFactory.getInstance(com.alipay.sdk.m.p.d.f1901a).generatePublic(new X509EncodedKeySpec(Base64.decode(zk.getBytes(Charset.forName("UTF-8")), 2)));
    }

    @DungeonFlag
    public static synchronized int h(String str, boolean z) {
        Application application = tg;
        if (application == null) {
            return -1;
        }
        try {
            SharedPreferences sharedPreferences = application.getSharedPreferences("softdec", 0);
            int i = sharedPreferences.getInt(str, 0);
            if (!z) {
                return i;
            }
            int i2 = i + 1;
            sharedPreferences.edit().putInt(str, i2).apply();
            return i2;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    @DungeonFlag
    public static String i() {
        Application application = tg;
        if (application == null) {
            return "-1";
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) application.getSystemService("accessibility");
            TreeSet treeSet = new TreeSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getInstalledAccessibilityServiceList()) {
                treeSet.add(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
            }
            JSONArray jSONArray = new JSONArray((Collection) treeSet);
            SharedPreferences sharedPreferences = tg.getSharedPreferences("softdec", 0);
            String string = jSONArray.toString();
            String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String string2 = sharedPreferences.getString("iacba", "");
            String string3 = sharedPreferences.getString("date", "1970-01-01");
            if (string2.equals(jSONArray.toString()) && str.equals(string3)) {
                return "2";
            }
            sharedPreferences.edit().putString("iacba", string).apply();
            sharedPreferences.edit().putString("date", str).apply();
            return string;
        } catch (Throwable th) {
            th.printStackTrace();
            return "-1";
        }
    }

    @DungeonFlag
    public static String p() {
        Application application = tg;
        return application == null ? "-1" : application.getFilesDir().getPath();
    }

    @DungeonFlag
    public static String s() {
        PackageInfo packageInfo;
        Application application = tg;
        if (application == null) {
            return "-1";
        }
        try {
            packageInfo = application.getPackageManager().getPackageInfo(tg.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr.length > 0) {
                try {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(byteArray);
                    return e(messageDigest.digest());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return "-1";
    }

    @DungeonFlag
    public static String signMD5withRSA(String str) throws Exception {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(com.alipay.sdk.m.p.d.f1901a).generatePrivate(new PKCS8EncodedKeySpec(getPrivateKey().getEncoded()));
        java.security.Signature signature = java.security.Signature.getInstance("Sha1withRSA");
        signature.initSign(privateKeyGeneratePrivate);
        signature.update(str.getBytes());
        return Base64.encodeToString(signature.sign(), 2);
    }

    @DungeonFlag
    public static boolean signVerifyMD5withRSA(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(com.alipay.sdk.m.p.d.f1901a).generatePublic(new X509EncodedKeySpec(getPublicKey().getEncoded()));
        java.security.Signature signature = java.security.Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    @DungeonFlag
    public static int sp() {
        Application application = tg;
        if (application == null) {
            return -1;
        }
        return application.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
    }

    @DungeonFlag
    public static void src(long j, int i) {
        e = j;
        bf = i;
    }

    @DungeonFlag
    public static int ta() {
        Application application = tg;
        if (application == null) {
            return -1;
        }
        return application.getApplicationInfo().targetSdkVersion;
    }

    @DungeonFlag
    public static long tft() {
        return e;
    }

    @DungeonFlag
    public static int trc() {
        return bf;
    }

    @DungeonFlag
    public static int u() {
        Application application = tg;
        if (application == null) {
            return -1;
        }
        UsbAccessory[] accessoryList = ((UsbManager) application.getSystemService("usb")).getAccessoryList();
        return (accessoryList == null || accessoryList.length == 0) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void bf(Handler handler) {
        if (p) {
            return;
        }
        p = true;
        if (v == null) {
            v = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglarmor.SoftDecTool.3
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                    if (i != 0) {
                        try {
                            SoftDecTool.a(1003, new Object[]{Integer.valueOf(i), SoftDecTool.tg});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    if (i != 0) {
                        try {
                            SoftDecTool.a(1005, new Object[]{Integer.valueOf(i), SoftDecTool.tg});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                    if (i != 0) {
                        try {
                            SoftDecTool.a(1004, new Object[]{Integer.valueOf(i), SoftDecTool.tg});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            };
        }
        ((DisplayManager) tg.getSystemService("display")).registerDisplayListener(v, handler);
    }

    public static synchronized Object[] a(int i, Object[] objArr) {
        if (xu) {
            return new Object[]{4, null};
        }
        if (!wu) {
            try {
                System.loadLibrary("panglarmor");
                wu = true;
            } catch (Throwable th) {
                xu = true;
                bh = th;
                return new Object[]{4, th};
            }
        }
        return new Object[]{0, b(i, objArr)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String bf(Throwable th, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", i);
            if (th != null) {
                jSONObject.put("exception:", th.toString());
                jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
                jSONObject.put("cause:", String.valueOf(th.getCause()));
            }
            d = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
            d = "eyJzdHRzIjozfQ==";
        }
        return d;
    }

    @DungeonFlag
    private static String e(Context context, String str) {
        return context.getFilesDir().getParent() + "/pangle_p/com.byted.pangle/version-" + str + "/apk/base-1.apk";
    }

    @DungeonFlag
    private static String e(InputStream inputStream) {
        int i;
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i3 = b2 & 255;
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UnsupportedEncodingException", e2);
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException("NoSuchAlgorithmException", e4);
        }
    }

    @DungeonFlag
    private static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            if (Integer.toHexString(bArr[i] & 255).length() == 1) {
                sb.append("0");
                sb.append(Integer.toHexString(bArr[i] & 255));
            } else {
                sb.append(Integer.toHexString(bArr[i] & 255));
            }
            if (bArr.length - 1 != i) {
                sb.append(":");
            }
        }
        return sb.toString().toUpperCase();
    }
}
