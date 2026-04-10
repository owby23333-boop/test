package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements a<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f1674c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f1675d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f1676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f1677f;
    private int a = 0;
    private int b = 0;

    public b(Context context) {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g a(java.lang.String r3, byte[] r4, java.util.Map<java.lang.String, java.lang.String> r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r2 = this;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b r5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b()
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a r5 = r5.a()
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c r5 = r5.c()
            r5.b(r3)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J()
            java.lang.String r3 = r3.q()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L2a
            java.lang.String r0 = "X-Tt-Env"
            r5.a(r0, r3)
            java.lang.String r3 = "x-use-ppe"
            java.lang.String r0 = "1"
            r5.a(r3, r0)
        L2a:
            java.lang.String r3 = com.bytedance.msdk.base.b.b
            java.lang.String r0 = "User-Agent"
            r5.a(r0, r3)
            r5.a(r6, r4)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b r3 = r5.b()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L90
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4d
            java.lang.String r0 = r3.a()     // Catch: org.json.JSONException -> L4d
            r6.<init>(r0)     // Catch: org.json.JSONException -> L4d
            boolean r6 = r2.b(r6)     // Catch: org.json.JSONException -> L4d
            if (r6 == 0) goto L90
            r6 = 1
            goto L91
        L4d:
            r6 = move-exception
            int r0 = r2.b
            int r1 = r0 + 1
            r2.b = r1
            r1 = 20
            if (r0 >= r1) goto L72
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exception: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "doUploadAdEvent"
            a(r1, r0)
        L72:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ignore:"
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "uploadEvent"
            com.bytedance.msdk.adapter.util.Logger.e(r1, r0)
            r6.printStackTrace()
        L90:
            r6 = 0
        L91:
            if (r3 == 0) goto L98
            int r0 = r3.b()
            goto L99
        L98:
            r0 = 0
        L99:
            if (r6 != 0) goto La3
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto La3
            java.lang.String r3 = "server say not success"
            r5 = 1
            goto Lac
        La3:
            if (r3 == 0) goto Laa
            java.lang.String r3 = r3.d()
            goto Lac
        Laa:
            java.lang.String r3 = "error unknown"
        Lac:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g r4 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g
            r4.<init>(r6, r0, r3, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.a(java.lang.String, byte[], java.util.Map, java.lang.String):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0026 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(boolean r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "4"
            java.lang.String r1 = "1"
            r2 = 0
            if (r4 == 0) goto L15
            boolean r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1675d
            if (r4 == 0) goto Le
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1675d = r2
            goto L1b
        Le:
            boolean r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1677f
            if (r4 == 0) goto L24
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1677f = r2
            goto L2b
        L15:
            boolean r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1674c
            if (r4 == 0) goto L1d
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1674c = r2
        L1b:
            r0 = r1
            goto L2b
        L1d:
            boolean r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1676e
            if (r4 == 0) goto L24
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1676e = r2
            goto L2b
        L24:
            if (r5 == 0) goto L29
            java.lang.String r0 = "3"
            goto L2b
        L29:
            java.lang.String r0 = "2"
        L2b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.a(boolean, boolean):java.lang.String");
    }

    private Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        return map;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String strA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a();
                    String str = 2 + strA + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONObject.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(strA));
                    if (TextUtils.isEmpty(str)) {
                        jSONObject2.put("message", jSONObject.toString());
                        jSONObject2.put("cypher", 0);
                    } else {
                        jSONObject2.put("message", str);
                        jSONObject2.put("cypher", 2);
                    }
                } catch (Throwable unused) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    public static void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("v3_Id", str);
            jSONObject.putOpt("v3_err_msg", str2);
            e0.a(jSONObject);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r2, int r3) {
        /*
            java.lang.String r0 = "encrypt"
            if (r2 == 0) goto Lf
            if (r3 <= 0) goto Lf
            int r1 = r2.length     // Catch: java.lang.Throwable -> L2b
            if (r1 == r3) goto La
            goto Lf
        La:
            byte[] r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.q.a(r2, r3)     // Catch: java.lang.Throwable -> L2b
            goto L48
        Lf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r3.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = "inputData is "
            r3.append(r1)     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L1e
            java.lang.String r2 = "null"
            goto L20
        L1e:
            java.lang.String r2 = "0"
        L20:
            r3.append(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L2b
            a(r0, r2)     // Catch: java.lang.Throwable -> L2b
            goto L47
        L2b:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "exception: "
            r3.append(r1)
            java.lang.String r1 = r2.toString()
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            a(r0, r3)
            r2.printStackTrace()
        L47:
            r2 = 0
        L48:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.a(byte[], int):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g b(java.lang.String r3, byte[] r4, java.util.Map<java.lang.String, java.lang.String> r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r2 = this;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b r5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b()
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a r5 = r5.a()
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c r5 = r5.c()
            r5.b(r3)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J()
            java.lang.String r3 = r3.q()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L2a
            java.lang.String r0 = "X-Tt-Env"
            r5.a(r0, r3)
            java.lang.String r3 = "x-use-ppe"
            java.lang.String r0 = "1"
            r5.a(r3, r0)
        L2a:
            java.lang.String r3 = com.bytedance.msdk.base.b.b
            java.lang.String r0 = "User-Agent"
            r5.a(r0, r3)
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r0 = "union_sdk_encode"
            r5.a(r3, r0)
            r5.a(r6, r4)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b r3 = r5.b()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L98
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L55
            java.lang.String r0 = r3.a()     // Catch: org.json.JSONException -> L55
            r6.<init>(r0)     // Catch: org.json.JSONException -> L55
            boolean r6 = r2.b(r6)     // Catch: org.json.JSONException -> L55
            if (r6 == 0) goto L98
            r6 = 1
            goto L99
        L55:
            r6 = move-exception
            int r0 = r2.b
            int r1 = r0 + 1
            r2.b = r1
            r1 = 20
            if (r0 >= r1) goto L7a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exception: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "doUploadAdEvent"
            a(r1, r0)
        L7a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ignore:"
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "uploadEvent"
            com.bytedance.msdk.adapter.util.Logger.e(r1, r0)
            r6.printStackTrace()
        L98:
            r6 = 0
        L99:
            if (r3 == 0) goto La0
            int r0 = r3.b()
            goto La1
        La0:
            r0 = 0
        La1:
            if (r6 != 0) goto Lab
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto Lab
            java.lang.String r3 = "server say not success"
            r5 = 1
            goto Lb4
        Lab:
            if (r3 == 0) goto Lb2
            java.lang.String r3 = r3.d()
            goto Lb4
        Lb2:
            java.lang.String r3 = "error unknown"
        Lb4:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g r4 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g
            r4.<init>(r6, r0, r3, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.b(java.lang.String, byte[], java.util.Map, java.lang.String):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g");
    }

    private String b(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().b);
            }
            jSONObject.put("stats_list", jSONArray);
            JSONObject jSONObjectA = a(jSONObject);
            jSONObjectA.putOpt("ad_sdk_version", "3.9.0.2");
            return jSONObjectA.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/octet-stream;tt-data=a");
        return map;
    }

    private boolean b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("code") != 20000) {
                    if ("success".equals(jSONObject.optString("message"))) {
                    }
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] c(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> r3) throws java.lang.Throwable {
        /*
            r2 = this;
            byte[] r3 = r2.e(r3)
            java.lang.String r0 = "buildAdEventV3Body"
            if (r3 != 0) goto Lf
            java.lang.String r1 = "zipData is null"
        Lb:
            a(r0, r1)
            goto L16
        Lf:
            int r1 = r3.length
            if (r1 > 0) goto L16
            java.lang.String r1 = "zipData len 0"
            goto Lb
        L16:
            int r1 = r3.length
            byte[] r3 = a(r3, r1)
            if (r3 != 0) goto L23
            java.lang.String r1 = "data is null"
        L1f:
            a(r0, r1)
            goto L29
        L23:
            int r1 = r3.length
            if (r1 > 0) goto L29
            java.lang.String r1 = "data len 0"
            goto L1f
        L29:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.c(java.util.List):byte[]");
    }

    private byte[] d(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
        try {
            return a(c.a(f(list)).toString());
        } catch (Throwable th) {
            a("buildAdEventV3Body2", "exception: " + th.toString());
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v9 */
    private byte[] e(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) throws Throwable {
        GZIPOutputStream byteArray = 0;
        GZIPOutputStream gZIPOutputStream = null;
        byteArray = 0;
        byteArray = 0;
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObjectF = f(list);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            try {
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(jSONObjectF.toString().getBytes());
                            gZIPOutputStream2.close();
                        } catch (Exception e2) {
                            e = e2;
                            gZIPOutputStream = gZIPOutputStream2;
                            a("buildAdEventV3BodyRaw", "exception: " + e.toString());
                            e.printStackTrace();
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            return byteArray;
                        } catch (Throwable th) {
                            th = th;
                            byteArray = gZIPOutputStream2;
                            if (byteArray != 0) {
                                try {
                                    byteArray.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return byteArray;
    }

    private JSONObject f(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", n.j());
            jSONObject.put("client_ip", n.a());
            jSONObject.put("header", n.i());
            JSONArray jSONArray = new JSONArray();
            Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().b);
            }
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            a("getAdEventV3Json", "exception: " + e2.toString());
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[Catch: all -> 0x0148, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0148, blocks: (B:5:0x000e, B:8:0x0016, B:9:0x0024, B:11:0x002a, B:13:0x0034, B:14:0x0038, B:15:0x003c, B:17:0x0042, B:20:0x004b, B:26:0x005f, B:29:0x0069, B:43:0x00ea, B:21:0x004f, B:23:0x0055), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea A[Catch: all -> 0x0148, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0148, blocks: (B:5:0x000e, B:8:0x0016, B:9:0x0024, B:11:0x002a, B:13:0x0034, B:14:0x0038, B:15:0x003c, B:17:0x0042, B:20:0x004b, B:26:0x005f, B:29:0x0069, B:43:0x00ea, B:21:0x004f, B:23:0x0055), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0154  */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g a(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> r19) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.a(java.util.List):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.g");
    }

    public byte[] a(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }
}
