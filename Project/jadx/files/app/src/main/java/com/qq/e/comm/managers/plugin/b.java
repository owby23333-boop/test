package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class b {
    private static volatile String a;

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            a = Application.getProcessName();
            return a;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        a = next.processName;
                        return a;
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public static synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = a;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        boolean zEndsWith = str2.endsWith("_");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(zEndsWith ? "" : "_");
        String strA = null;
        try {
            String str3 = new String(str2);
            try {
                strA = d.a(MessageDigest.getInstance("MD5").digest(str3.getBytes("UTF-8")));
            } catch (Exception unused) {
                strA = str3;
            }
        } catch (Exception unused2) {
        }
        sb.append(strA);
        return sb.toString();
    }

    static void a(Context context, File file, File file2) throws Exception {
        Throwable th;
        InputStream inputStreamOpen;
        FileOutputStream fileOutputStream;
        boolean zA;
        AssetManager assets = context.getAssets();
        InputStream inputStream = null;
        try {
            h.a();
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                String str = "Asset Error " + ((list == null || list.length <= 0) ? "no asset" : TextUtils.join(",", list));
                GDTLogger.e(str);
                throw new Exception(str);
            }
            String str2 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str3 = Sig.ASSET_PLUGIN_SIG;
            if (str3 == null) {
                str3 = "";
            }
            h.a(SDKStatus.getBuildInPluginVersion() + "#####" + str3, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                zA = h.a(assets.open(str2), file);
                fileOutputStream = null;
            } else {
                inputStreamOpen = assets.open(str2);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    try {
                        GDTLogger.e("插件加载失败", th);
                        throw th;
                    } finally {
                        a(inputStreamOpen);
                        a(fileOutputStream);
                    }
                }
                try {
                    byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                    byte[] bArr = new byte[1024];
                    int length = bytes.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = inputStreamOpen.read(bArr);
                        if (i4 <= 0) {
                            break;
                        }
                        int i5 = i3;
                        int i6 = i2;
                        int i7 = 0;
                        while (i7 < i4) {
                            int i8 = i6 + 1;
                            if (i6 >= 64) {
                                bArr[i7] = (byte) (bArr[i7] ^ bytes[i5 % length]);
                                i5++;
                            }
                            i7++;
                            i6 = i8;
                        }
                        fileOutputStream.write(bArr, 0, i4);
                        i2 = i6;
                        i3 = i5;
                    }
                    inputStream = inputStreamOpen;
                    zA = true;
                } catch (Throwable th3) {
                    th = th3;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (!zA) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpen = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
