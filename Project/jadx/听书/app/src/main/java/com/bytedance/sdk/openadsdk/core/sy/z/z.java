package com.bytedance.sdk.openadsdk.core.sy.z;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.fo.g.dl;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ats.a;
import com.bytedance.sdk.openadsdk.core.io.gc;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.sy.g;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.an;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements g {
    private static final FileFilter g = new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.sy.z.z.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith(an.w)) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static volatile z z;

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String g() {
        return "DeviceRate";
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public static long z(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static int dl() {
        int iIntValue = -1;
        for (int i = 0; i < a(); i++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i2 = 0;
                        while (Character.isDigit(bArr[i2]) && i2 < 128) {
                            i2++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i2)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int iZ = z("cpu MHz", fileInputStream2) * 1000;
                if (iZ > iIntValue) {
                    iIntValue = iZ;
                }
                fileInputStream2.close();
            } catch (Throwable th2) {
                fileInputStream2.close();
                throw th2;
            }
        }
        return iIntValue;
    }

    public static int a() {
        try {
            int iG = g("/sys/devices/system/cpu/possible");
            if (iG == -1) {
                iG = g("/sys/devices/system/cpu/present");
            }
            return iG == -1 ? new File("/sys/devices/system/cpu/").listFiles(g).length : iG;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    private static int g(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int iDl = dl(line);
                fileInputStream.close();
                return iDl;
            } finally {
            }
        } catch (IOException unused) {
            return -1;
        }
    }

    private static int dl(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0034, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int z(java.lang.String r6, java.io.FileInputStream r7) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            int r7 = r7.read(r0)     // Catch: java.lang.NumberFormatException -> L37 java.io.IOException -> L39
            r1 = 0
        L9:
            if (r1 >= r7) goto L3d
            r2 = r0[r1]     // Catch: java.lang.NumberFormatException -> L37 java.io.IOException -> L39
            r3 = 10
            if (r2 == r3) goto L13
            if (r1 != 0) goto L34
        L13:
            if (r2 != r3) goto L17
            int r1 = r1 + 1
        L17:
            r2 = r1
        L18:
            if (r2 >= r7) goto L34
            int r3 = r2 - r1
            r4 = r0[r2]     // Catch: java.lang.NumberFormatException -> L37 java.io.IOException -> L39
            char r5 = r6.charAt(r3)     // Catch: java.lang.NumberFormatException -> L37 java.io.IOException -> L39
            if (r4 != r5) goto L34
            int r4 = r6.length()     // Catch: java.lang.NumberFormatException -> L37 java.io.IOException -> L39
            int r4 = r4 + (-1)
            if (r3 != r4) goto L31
            int r6 = z(r0, r2)     // Catch: java.lang.NumberFormatException -> L37 java.io.IOException -> L39
            return r6
        L31:
            int r2 = r2 + 1
            goto L18
        L34:
            int r1 = r1 + 1
            goto L9
        L37:
            r6 = move-exception
            goto L3a
        L39:
            r6 = move-exception
        L3a:
            com.bytedance.sdk.component.utils.wp.z(r6)
        L3d:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sy.z.z.z(java.lang.String, java.io.FileInputStream):int");
    }

    private static int z(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public void gc() {
        if (zw.g().zr() && m()) {
            fo();
        }
        if (zw.g().tk() && e()) {
            gz();
        }
    }

    private void gz() {
        try {
            dl dlVarDl = gc.z().g().dl();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(an.x, "android");
            jSONObject.put("device_model", Build.MODEL);
            dlVarDl.z(Uri.parse(eo.gz("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter("extra", com.bytedance.sdk.component.utils.z.g(jSONObject.toString())).toString());
            com.bytedance.sdk.component.fo.g gVarZ = dlVarDl.z();
            if (gVarZ == null || !gVarZ.gz()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(gVarZ.a());
            if (jSONObject2.optInt("code") == 200) {
                double dOptDouble = jSONObject2.optDouble("score");
                z("bytebench_update_time", String.valueOf(System.currentTimeMillis()));
                z("bytebench_value", String.valueOf(dOptDouble));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("score", dOptDouble);
                v.z().a(jSONObject3);
                return;
            }
            z("bytebench_value", "-1.0");
        } catch (Exception e) {
            wp.z(e);
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("score", -1);
                v.z().a(jSONObject4);
            } catch (JSONException e2) {
                wp.z(e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int fo() {
        /*
            r5 = this;
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.zw.getContext()
            int r0 = g(r0)
            int r1 = uy()
            r2 = 2
            if (r0 == 0) goto L23
            r3 = 1
            if (r0 == r3) goto L23
            if (r1 != 0) goto L15
            goto L23
        L15:
            if (r0 != r2) goto L19
            if (r1 > 0) goto L1f
        L19:
            if (r0 <= r2) goto L21
            if (r1 <= r3) goto L1f
            r2 = 0
            goto L23
        L1f:
            r2 = r3
            goto L23
        L21:
            r2 = -1000(0xfffffffffffffc18, float:NaN)
        L23:
            java.lang.String r3 = "ram_level"
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r5.z(r3, r4)
            java.lang.String r3 = "cpu_level"
            java.lang.String r4 = java.lang.String.valueOf(r1)
            r5.z(r3, r4)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "update_time"
            r5.z(r4, r3)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "ram"
            r3.put(r4, r0)     // Catch: org.json.JSONException -> L57
            java.lang.String r0 = "cpu"
            r3.put(r0, r1)     // Catch: org.json.JSONException -> L57
            java.lang.String r0 = "level"
            r3.put(r0, r2)     // Catch: org.json.JSONException -> L57
            goto L5b
        L57:
            r0 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r0)
        L5b:
            com.bytedance.sdk.openadsdk.core.q.v r0 = com.bytedance.sdk.openadsdk.core.q.v.z()
            r0.dl(r3)
            r5.z(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sy.z.z.fo():int");
    }

    public boolean m() {
        String strZ = z("update_time");
        return strZ.isEmpty() || System.currentTimeMillis() - Long.parseLong(strZ) >= 15552000000L;
    }

    public boolean e() {
        String strZ = z("bytebench_update_time");
        return strZ.isEmpty() || System.currentTimeMillis() - Long.parseLong(strZ) >= 15552000000L;
    }

    private static int g(Context context) {
        long jZ = z(context) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (jZ <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return 0;
        }
        if (jZ <= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
            return 1;
        }
        if (jZ <= 4000) {
            return 2;
        }
        return jZ <= 6000 ? 3 : 4;
    }

    private static int uy() {
        int iDl = dl() / 1000;
        if (iDl <= 1600) {
            return 0;
        }
        if (iDl <= 2000) {
            return 1;
        }
        return iDl <= 2500 ? 2 : 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String z(String str) {
        return a.z(g()).get(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public void z(String str, String str2) {
        a.z(g()).put(str, str2);
    }

    private void z(int i) {
        z("device_level", String.valueOf(i));
        com.bytedance.sdk.openadsdk.core.dl.a.z().gz(i);
    }
}
