package com.bytedance.msdk.gc.g;

import android.os.SystemClock;
import com.bytedance.msdk.gc.gc;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.mc;
import com.bytedance.msdk.gz.pf;
import com.bytedance.msdk.gz.zw;
import com.bytedance.msdk.z.gc.dl;
import com.bytedance.sdk.component.utils.wp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z<com.bytedance.msdk.gc.z> {
    private static volatile boolean g = true;
    public static volatile boolean z;
    private int dl = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f469a = 0;

    @Override // com.bytedance.msdk.gc.g.z
    public boolean z() {
        com.bytedance.sdk.component.a.z zVarM = mc.m();
        return (com.bytedance.msdk.core.g.g().g() || zVarM == null || !zVarM.getArmorLoadStatus()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.gc.gc z(java.lang.String r4, byte[] r5, boolean r6) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.gc.g.g.z(java.lang.String, byte[], boolean):com.bytedance.msdk.gc.gc");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.gc.gc z(java.lang.String r5, byte[] r6) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.gc.g.g.z(java.lang.String, byte[]):com.bytedance.msdk.gc.gc");
    }

    @Override // com.bytedance.msdk.gc.g.z
    public gc z(List<com.bytedance.msdk.gc.z> list) {
        gc gcVarZ;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (list == null) {
            return null;
        }
        boolean z2 = true;
        try {
            if (list.isEmpty()) {
                return null;
            }
            dl.g("TTMediationSDK", "--==-- v3: " + list.size());
            boolean z3 = z();
            byte[] bArrZ = z(list, z3);
            if (bArrZ != null && bArrZ.length > 0) {
                gcVarZ = z(com.bytedance.msdk.core.dl.g(), bArrZ, z3);
            } else {
                gcVarZ = z(com.bytedance.msdk.core.dl.g(), a(list));
            }
            if (list.size() < com.bytedance.msdk.core.g.g().sy()) {
                z2 = false;
            }
            l.z(gcVarZ.z, list.size(), z(z2), SystemClock.elapsedRealtime() - jElapsedRealtime, gcVarZ.g + "::" + gcVarZ.dl);
            return gcVarZ;
        } catch (Throwable th) {
            int i = this.dl;
            this.dl = i + 1;
            if (i < 20) {
                z("uploadEvent", "exception: " + th.toString());
            }
            dl.a("ReportNetApiImpl", "uploadEvent error:");
            wp.z(th);
            l.z(false, 0, z(z2), SystemClock.elapsedRealtime() - jElapsedRealtime, "-1::" + th);
            return new gc(false, 509, "service_busy", false);
        }
    }

    private String z(boolean z2) {
        if (g) {
            g = false;
            return "1";
        }
        if (!z) {
            return z2 ? "3" : "2";
        }
        z = false;
        return "4";
    }

    private byte[] g(List<com.bytedance.msdk.gc.z> list) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObjectDl = dl(list);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(jSONObjectDl.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        z("buildAdEventV3BodyRaw", "exception: " + e.toString());
                        wp.z(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e2) {
                                wp.z(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                wp.z(e4);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private JSONObject dl(List<com.bytedance.msdk.gc.z> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", io.gk());
            jSONObject.put("client_ip", io.iq());
            jSONObject.put("header", zw.g());
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.msdk.gc.z> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().g);
            }
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException e) {
            z("getAdEventV3Json", "exception: " + e.toString());
            wp.z(e);
        }
        return jSONObject;
    }

    private byte[] z(List<com.bytedance.msdk.gc.z> list, boolean z2) throws Throwable {
        byte[] bArrZ;
        byte[] bArrG = g(list);
        if (bArrG == null) {
            z("buildAdEventV3Body", "zipData is null");
        } else if (bArrG.length <= 0) {
            z("buildAdEventV3Body", "zipData len 0");
        }
        com.bytedance.sdk.component.a.z zVarM = mc.m();
        if (z2) {
            bArrZ = zVarM.encrypt(bArrG);
        } else {
            bArrZ = z(bArrG, bArrG.length);
        }
        if (bArrZ == null) {
            z("buildAdEventV3Body", "data is null");
        } else if (bArrZ.length <= 0) {
            z("buildAdEventV3Body", "data len 0");
        }
        return bArrZ;
    }

    private byte[] a(List<com.bytedance.msdk.gc.z> list) {
        try {
            return z(com.bytedance.msdk.gz.dl.z(dl(list)).toString());
        } catch (Throwable th) {
            z("buildAdEventV3Body2", "exception: " + th.toString());
            wp.z(th);
            return null;
        }
    }

    private byte[] z(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    private byte[] z(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return pf.z(bArr, i);
                }
            } catch (Throwable th) {
                z("encrypt", "exception: " + th.toString());
                wp.z(th);
                return null;
            }
        }
        z("encrypt", "inputData is " + (bArr == null ? "null" : "0"));
        return null;
    }

    public static void z(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("v3_Id", str);
            jSONObject.putOpt("v3_err_msg", str2);
            l.z(jSONObject);
        } catch (Throwable unused) {
        }
    }

    private boolean z(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("code") != 20000) {
                    return "success".equals(jSONObject.optString("message"));
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
