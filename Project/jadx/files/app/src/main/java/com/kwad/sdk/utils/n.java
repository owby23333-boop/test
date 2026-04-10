package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    private static Context ayj;
    public static com.kwad.sdk.g.kwai.d ayk;

    static class a extends com.kwad.sdk.g.kwai.a {
        public a() {
            CX();
        }

        private void CX() {
            this.awS = new ArrayList();
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.1
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    int i2 = (Build.PRODUCT.contains(com.baidu.mobads.sdk.internal.bj.f12909g) || Build.PRODUCT.contains("Andy") || Build.PRODUCT.contains("ttVM_Hdragon") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("Droid4X") || Build.PRODUCT.contains("nox") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("aries")) ? 1 : 0;
                    if (Build.MANUFACTURER.equals("unknown") || Build.MANUFACTURER.equals("Genymotion") || Build.MANUFACTURER.contains("Andy") || Build.MANUFACTURER.contains("MIT") || Build.MANUFACTURER.contains("nox") || Build.MANUFACTURER.contains("TiantianVM")) {
                        i2++;
                    }
                    if (Build.BRAND.equals("generic") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("TTVM") || Build.BRAND.contains("Andy")) {
                        i2++;
                    }
                    if (Build.DEVICE.contains("generic") || Build.DEVICE.contains("generic_x86") || Build.DEVICE.contains("Andy") || Build.DEVICE.contains("ttVM_Hdragon") || Build.DEVICE.contains("Droid4X") || Build.DEVICE.contains("nox") || Build.DEVICE.contains("generic_x86_64") || Build.DEVICE.contains("vbox86p") || Build.DEVICE.contains("aries")) {
                        i2++;
                    }
                    if (Build.MODEL.equals(com.baidu.mobads.sdk.internal.bj.f12909g) || Build.MODEL.contains("Emulator") || Build.MODEL.equals("google_sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || Build.MODEL.equals("Android SDK built for x86_64") || Build.MODEL.equals("Android SDK built for x86")) {
                        i2++;
                    }
                    if (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.HARDWARE.contains("nox") || Build.HARDWARE.contains("ttVM_x86")) {
                        i2++;
                    }
                    if (Build.FINGERPRINT.contains("generic/sdk/generic") || Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("generic_x86_64") || Build.FINGERPRINT.contains("generic/google_sdk/generic") || Build.FINGERPRINT.contains("vbox86p") || Build.FINGERPRINT.contains("generic/vbox86p/vbox86p")) {
                        i2++;
                    }
                    try {
                        if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                            i2 += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i2 > 3;
                }
            });
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.2
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    return "1".equals(bb.get("ro.kernel.qemu"));
                }
            });
        }
    }

    static class b extends com.kwad.sdk.g.kwai.a {
    }

    static class c extends com.kwad.sdk.g.kwai.a {
    }

    static class d extends com.kwad.sdk.g.kwai.a {
        public d() {
            CX();
        }

        private void CX() {
            this.awS = new ArrayList();
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.1
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.2
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (new File(strArr[i2] + com.kuaishou.weapon.p0.bh.f16586y).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.3
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    return !TextUtils.isEmpty(n.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bh.f16586y}));
                }
            });
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.4
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    Charset charsetForName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        p.a(file, "ok", charsetForName, false);
                        return p.a(file, charsetForName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    static class e extends com.kwad.sdk.g.kwai.a {
        public e() {
            CX();
        }

        private void CX() {
            this.awS = new ArrayList();
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.1
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    return aj.ah(context, "de.robv.android.xposed.installer") || aj.ah(context, "com.saurik.substrate");
                }
            });
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.2
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e2) {
                        boolean z2 = false;
                        int i2 = 0;
                        for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                                z2 = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z2 = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("main")) {
                                z2 = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("handleHookedMethod")) {
                                z2 = true;
                            }
                        }
                        return z2;
                    }
                }
            });
            this.awS.add(new com.kwad.sdk.g.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.3
                @Override // com.kwad.sdk.g.kwai.a
                public final boolean bD(Context context) throws Throwable {
                    BufferedReader bufferedReader;
                    FileReader fileReader;
                    Throwable th;
                    HashSet<String> hashSet;
                    boolean z2 = false;
                    try {
                        hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                    } catch (Exception unused) {
                        bufferedReader = null;
                        fileReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        fileReader = null;
                    }
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                    } catch (Exception unused2) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                        throw th;
                    }
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.endsWith(".so") || line.endsWith(".jar")) {
                                hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                            }
                        } catch (Exception unused3) {
                        } catch (Throwable th4) {
                            th = th4;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                            throw th;
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                        return z2;
                    }
                    for (String str : hashSet) {
                        if (str.contains("com.saurik.substrate")) {
                            Log.wtf("HookDetection", "Substrate shared object found: " + str);
                            z2 = true;
                        }
                        if (str.contains("XposedBridge.jar")) {
                            Log.wtf("HookDetection", "Xposed JAR found: " + str);
                            z2 = true;
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z2;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.g.kwai.d CW() {
        if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sP()) {
            return null;
        }
        if (ayk != null) {
            return ayk;
        }
        com.kwad.sdk.g.kwai.d dVar = new com.kwad.sdk.g.kwai.d(ayj);
        boolean zBC = new d().bC(ayj);
        boolean zBC2 = new e().bC(ayj);
        boolean zBC3 = new b().bC(ayj);
        boolean zBC4 = new a().bC(ayj);
        boolean zBC5 = new c().bC(ayj);
        dVar.bl(zBC);
        dVar.bm(zBC2);
        dVar.bn(zBC3);
        dVar.bp(zBC4);
        dVar.bq(zBC5);
        ayk = dVar;
        return dVar;
    }

    public static synchronized void bW(Context context) {
        if (context == null) {
            return;
        }
        ayj = context.getApplicationContext();
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
