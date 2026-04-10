package com.bytedance.adsdk.lottie.a;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.m;
import com.bytedance.adsdk.lottie.model.layer.gz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zw {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.lottie.m z(JsonReader jsonReader) throws IOException {
        float f;
        byte b;
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
        LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gz> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.lottie.model.a> sparseArray = new SparseArray<>();
        m.a aVar = new m.a();
        m.g gVar = new m.g();
        m.dl dlVar = new m.dl();
        m.z zVar = new m.z();
        com.bytedance.adsdk.lottie.m mVar = new com.bytedance.adsdk.lottie.m();
        jsonReader.beginObject();
        String strNextString = null;
        int iNextInt = 0;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b2 = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    f = fZ;
                    if (strNextName.equals("assets")) {
                        b2 = 0;
                    }
                    break;
                case -1109732030:
                    f = fZ;
                    if (strNextName.equals("layers")) {
                        b2 = 1;
                    }
                    break;
                case -865448777:
                    f = fZ;
                    if (strNextName.equals("globalEvent")) {
                        b2 = 2;
                    }
                    break;
                case 104:
                    f = fZ;
                    if (strNextName.equals("h")) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS /* 118 */:
                    f = fZ;
                    if (strNextName.equals("v")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case 119:
                    f = fZ;
                    if (strNextName.equals("w")) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3208:
                    f = fZ;
                    if (strNextName.equals("dl")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 3276:
                    f = fZ;
                    if (strNextName.equals("fr")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 3292:
                    f = fZ;
                    if (strNextName.equals("gc")) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 3367:
                    f = fZ;
                    if (strNextName.equals("ip")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 3553:
                    f = fZ;
                    if (strNextName.equals("op")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 3002509:
                    f = fZ;
                    if (strNextName.equals("area")) {
                        b = 11;
                        b2 = b;
                    }
                    break;
                case 94623709:
                    f = fZ;
                    if (strNextName.equals("chars")) {
                        b = 12;
                        b2 = b;
                    }
                    break;
                case 97615364:
                    f = fZ;
                    if (strNextName.equals("fonts")) {
                        b = 13;
                        b2 = b;
                    }
                    break;
                case 110364485:
                    f = fZ;
                    if (strNextName.equals("timer")) {
                        b = 14;
                        b2 = b;
                    }
                    break;
                case 839250809:
                    f = fZ;
                    if (strNextName.equals("markers")) {
                        b = 15;
                        b2 = b;
                    }
                    break;
                default:
                    f = fZ;
                    break;
            }
            switch (b2) {
                case 0:
                    z(jsonReader, mVar, map, map2);
                    break;
                case 1:
                    z(jsonReader, mVar, arrayList, longSparseArray);
                    break;
                case 2:
                    z(jsonReader, dlVar);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.lottie.gc.fo.z(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        mVar.z("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 5:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    z(jsonReader, gVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    z(jsonReader, zVar);
                    break;
                case 12:
                    z(jsonReader, mVar, sparseArray);
                    break;
                case 13:
                    z(jsonReader, map3);
                    break;
                case 14:
                    z(jsonReader, aVar);
                    break;
                case 15:
                    z(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            fZ = f;
        }
        float f2 = fZ;
        jsonReader.endObject();
        mVar.z(new Rect(0, 0, (int) (iNextInt * f2), (int) (iNextInt2 * f2)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, aVar, strNextString, gVar, dlVar, zVar);
        return mVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void z(android.util.JsonReader r6, com.bytedance.adsdk.lottie.m.z r7) {
        /*
            r6.beginObject()     // Catch: java.lang.Exception -> L71
        L3:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L6d
            java.lang.String r0 = r6.nextName()     // Catch: java.lang.Exception -> L71
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L71
            r2 = 104(0x68, float:1.46E-43)
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r2) goto L3a
            switch(r1) {
                case 119: goto L30;
                case 120: goto L26;
                case 121: goto L1c;
                default: goto L1b;
            }     // Catch: java.lang.Exception -> L71
        L1b:
            goto L44
        L1c:
            java.lang.String r1 = "y"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = r5
            goto L45
        L26:
            java.lang.String r1 = "x"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = 0
            goto L45
        L30:
            java.lang.String r1 = "w"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = r4
            goto L45
        L3a:
            java.lang.String r1 = "h"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = r3
            goto L45
        L44:
            r0 = -1
        L45:
            if (r0 == 0) goto L66
            if (r0 == r5) goto L5f
            if (r0 == r4) goto L58
            if (r0 == r3) goto L51
            r6.skipValue()     // Catch: java.lang.Exception -> L71
            goto L3
        L51:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.f158a = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L58:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.dl = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L5f:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.g = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L66:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.z = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L6d:
            r6.endObject()     // Catch: java.lang.Exception -> L71
            return
        L71:
            r6 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.z(android.util.JsonReader, com.bytedance.adsdk.lottie.m$z):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void z(android.util.JsonReader r7, com.bytedance.adsdk.lottie.m.dl r8) {
        /*
            r7.beginObject()     // Catch: java.lang.Exception -> L93
        L3:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L93
            if (r0 == 0) goto L8f
            java.lang.String r0 = r7.nextName()     // Catch: java.lang.Exception -> L93
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L93
            r2 = 3239(0xca7, float:4.539E-42)
            r3 = 2
            r4 = -1
            r5 = 0
            r6 = 1
            if (r1 == r2) goto L38
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L2e
            r2 = 3237004(0x31648c, float:4.536009E-39)
            if (r1 == r2) goto L24
            goto L42
        L24:
            java.lang.String r1 = "inel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L93
            if (r0 == 0) goto L42
            r0 = r5
            goto L43
        L2e:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L93
            if (r0 == 0) goto L42
            r0 = r3
            goto L43
        L38:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L93
            if (r0 == 0) goto L42
            r0 = r6
            goto L43
        L42:
            r0 = r4
        L43:
            if (r0 == 0) goto L5b
            if (r0 == r6) goto L54
            if (r0 == r3) goto L4d
            r7.skipValue()     // Catch: java.lang.Exception -> L93
            goto L3
        L4d:
            org.json.JSONArray r0 = a(r7)     // Catch: java.lang.Exception -> L93
            r8.dl = r0     // Catch: java.lang.Exception -> L93
            goto L3
        L54:
            java.lang.String r0 = r7.nextString()     // Catch: java.lang.Exception -> L93
            r8.z = r0     // Catch: java.lang.Exception -> L93
            goto L3
        L5b:
            int[][] r0 = new int[r6][]     // Catch: java.lang.Exception -> L93
            int[] r1 = new int[]{r4, r4}     // Catch: java.lang.Exception -> L93
            r0[r5] = r1     // Catch: java.lang.Exception -> L93
            r8.g = r0     // Catch: java.lang.Exception -> L93
            r7.beginArray()     // Catch: java.lang.Exception -> L93
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L93
            if (r0 == 0) goto L8a
            r7.beginArray()     // Catch: java.lang.Exception -> L93
            r0 = r5
        L72:
            if (r0 >= r3) goto L87
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> L93
            if (r1 == 0) goto L84
            int[][] r1 = r8.g     // Catch: java.lang.Exception -> L93
            r1 = r1[r5]     // Catch: java.lang.Exception -> L93
            int r2 = r7.nextInt()     // Catch: java.lang.Exception -> L93
            r1[r0] = r2     // Catch: java.lang.Exception -> L93
        L84:
            int r0 = r0 + 1
            goto L72
        L87:
            r7.endArray()     // Catch: java.lang.Exception -> L93
        L8a:
            r7.endArray()     // Catch: java.lang.Exception -> L93
            goto L3
        L8f:
            r7.endObject()     // Catch: java.lang.Exception -> L93
            return
        L93:
            r7 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.z(android.util.JsonReader, com.bytedance.adsdk.lottie.m$dl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void z(android.util.JsonReader r7, com.bytedance.adsdk.lottie.m.g r8) {
        /*
            r7.beginObject()     // Catch: java.lang.Exception -> L92
        L3:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L8e
            java.lang.String r0 = r7.nextName()     // Catch: java.lang.Exception -> L92
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L92
            r2 = 3139(0xc43, float:4.399E-42)
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == r2) goto L53
            r2 = 3232(0xca0, float:4.529E-42)
            if (r1 == r2) goto L49
            r2 = 3571(0xdf3, float:5.004E-42)
            if (r1 == r2) goto L3f
            r2 = 3666(0xe52, float:5.137E-42)
            if (r1 == r2) goto L35
            r2 = 98713(0x18199, float:1.38326E-40)
            if (r1 == r2) goto L2b
            goto L5d
        L2b:
            java.lang.String r1 = "cpf"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = r3
            goto L5e
        L35:
            java.lang.String r1 = "se"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = 0
            goto L5e
        L3f:
            java.lang.String r1 = "pc"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = r4
            goto L5e
        L49:
            java.lang.String r1 = "ee"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = r5
            goto L5e
        L53:
            java.lang.String r1 = "be"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = r6
            goto L5e
        L5d:
            r0 = -1
        L5e:
            if (r0 == 0) goto L86
            if (r0 == r6) goto L7e
            if (r0 == r5) goto L77
            if (r0 == r4) goto L70
            if (r0 == r3) goto L6c
            r7.skipValue()     // Catch: java.lang.Exception -> L92
            goto L3
        L6c:
            g(r7, r8)     // Catch: java.lang.Exception -> L92
            goto L3
        L70:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L92
            r8.f157a = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L77:
            java.util.Map r0 = g(r7)     // Catch: java.lang.Exception -> L92
            r8.dl = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L7e:
            java.util.Map r0 = g(r7)     // Catch: java.lang.Exception -> L92
            r8.g = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L86:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L92
            r8.z = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L8e:
            r7.endObject()     // Catch: java.lang.Exception -> L92
            return
        L92:
            r7 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.z(android.util.JsonReader, com.bytedance.adsdk.lottie.m$g):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(android.util.JsonReader r5, com.bytedance.adsdk.lottie.m.g r6) {
        /*
            r5.beginObject()     // Catch: java.io.IOException -> L63
        L3:
            boolean r0 = r5.hasNext()     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L5f
            java.lang.String r0 = r5.nextName()     // Catch: java.io.IOException -> L63
            int r1 = r0.hashCode()     // Catch: java.io.IOException -> L63
            r2 = 3239(0xca7, float:4.539E-42)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L35
            r2 = 3276(0xccc, float:4.59E-42)
            if (r1 == r2) goto L2b
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L21
            goto L3f
        L21:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L3f
            r0 = r3
            goto L40
        L2b:
            java.lang.String r1 = "fr"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L3f
            r0 = 0
            goto L40
        L35:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L3f
            r0 = r4
            goto L40
        L3f:
            r0 = -1
        L40:
            if (r0 == 0) goto L58
            if (r0 == r4) goto L51
            if (r0 == r3) goto L4a
            r5.skipValue()     // Catch: java.io.IOException -> L63
            goto L3
        L4a:
            org.json.JSONArray r0 = a(r5)     // Catch: java.io.IOException -> L63
            r6.e = r0     // Catch: java.io.IOException -> L63
            goto L3
        L51:
            java.lang.String r0 = r5.nextString()     // Catch: java.io.IOException -> L63
            r6.m = r0     // Catch: java.io.IOException -> L63
            goto L3
        L58:
            int r0 = r5.nextInt()     // Catch: java.io.IOException -> L63
            r6.gc = r0     // Catch: java.io.IOException -> L63
            goto L3
        L5f:
            r5.endObject()     // Catch: java.io.IOException -> L63
            return
        L63:
            r5 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.g(android.util.JsonReader, com.bytedance.adsdk.lottie.m$g):void");
    }

    private static Map<String, Object> g(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("lel")) {
                map.put("lel", a(jsonReader));
            } else if (strNextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    if (strNextName2.equals(LiveConfigKey.HIGH)) {
                        try {
                            jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void z(android.util.JsonReader r6, com.bytedance.adsdk.lottie.m.a r7) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.z(android.util.JsonReader, com.bytedance.adsdk.lottie.m$a):void");
    }

    private static String[] dl(JsonReader jsonReader) {
        String[] strArr = null;
        try {
            jsonReader.beginArray();
            strArr = new String[3];
            for (int i = 0; i < 3; i++) {
                if (jsonReader.hasNext()) {
                    strArr[i] = jsonReader.nextString();
                }
            }
            jsonReader.endArray();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return strArr;
    }

    private static void z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, List<com.bytedance.adsdk.lottie.model.layer.gz> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gz> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.layer.gz gzVarZ = iq.z(jsonReader, mVar);
            if (gzVarZ.kb() == gz.z.IMAGE) {
                i++;
            }
            list.add(gzVarZ);
            longSparseArray.put(gzVarZ.gc(), gzVarZ);
            if (i > 4) {
                com.bytedance.adsdk.lottie.gc.gc.g("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, Map<String, List<com.bytedance.adsdk.lottie.model.layer.gz>> map, Map<String, com.bytedance.adsdk.lottie.fo> map2) throws IOException {
        int i;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<fo.g> listGc = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayA = null;
            String strNextString6 = null;
            String strNextString7 = null;
            fo.z zVar = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.model.layer.gz gzVarZ = iq.z(jsonReader, mVar);
                            longSparseArray.put(gzVarZ.gc(), gzVarZ);
                            arrayList.add(gzVarZ);
                            iNextInt = iNextInt;
                        }
                        i = iNextInt;
                        jsonReader.endArray();
                        iNextInt = i;
                        break;
                    case "ugen_v":
                        strNextString7 = jsonReader.nextString();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "el":
                        strNextString5 = jsonReader.nextString();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    case "rc":
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            i = iNextInt;
                            iNextInt = i;
                            break;
                        } else {
                            fo.z zVar2 = new fo.z();
                            jsonReader.beginObject();
                            z(jsonReader, zVar2);
                            jsonReader.endObject();
                            zVar = zVar2;
                            break;
                        }
                        break;
                    case "tc":
                        jsonReader.beginArray();
                        listGc = gc(jsonReader);
                        jsonReader.endArray();
                        break;
                    case "lel":
                        jSONArrayA = a(jsonReader);
                        break;
                    case "md5":
                        strNextString6 = jsonReader.nextString();
                        break;
                    case "rel":
                        strNextString4 = jsonReader.nextString();
                        break;
                    case "inel":
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i2 = 0; i2 < 2; i2++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i2] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        i = iNextInt;
                        iNextInt = i;
                        break;
                }
            }
            int i3 = iNextInt;
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.bytedance.adsdk.lottie.fo foVar = new com.bytedance.adsdk.lottie.fo(i3, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listGc, strNextString5, iArr, jSONArrayA, strNextString6, strNextString7, zVar);
                map2.put(foVar.kb(), foVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONArray a(android.util.JsonReader r8) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r8.beginArray()     // Catch: java.lang.Exception -> L71
        L8:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Exception -> L71
            if (r1 == 0) goto L6d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L71
            r1.<init>()     // Catch: java.lang.Exception -> L71
            r0.put(r1)     // Catch: java.lang.Exception -> L71
            r8.beginObject()     // Catch: java.lang.Exception -> L71
        L19:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Exception -> L71
            if (r2 == 0) goto L69
            java.lang.String r2 = r8.nextName()     // Catch: java.lang.Exception -> L71
            int r3 = r2.hashCode()     // Catch: java.lang.Exception -> L71
            r4 = 3324(0xcfc, float:4.658E-42)
            java.lang.String r5 = "vid"
            java.lang.String r6 = "hd"
            r7 = 1
            if (r3 == r4) goto L3e
            r4 = 116753(0x1c811, float:1.63606E-40)
            if (r3 == r4) goto L36
            goto L46
        L36:
            boolean r2 = r2.equals(r5)     // Catch: java.lang.Exception -> L71
            if (r2 == 0) goto L46
            r2 = 0
            goto L47
        L3e:
            boolean r2 = r2.equals(r6)     // Catch: java.lang.Exception -> L71
            if (r2 == 0) goto L46
            r2 = r7
            goto L47
        L46:
            r2 = -1
        L47:
            if (r2 == 0) goto L5c
            if (r2 == r7) goto L4f
            r8.skipValue()     // Catch: java.lang.Exception -> L71
            goto L19
        L4f:
            int r2 = r8.nextInt()     // Catch: org.json.JSONException -> L57 java.lang.Exception -> L71
            r1.put(r6, r2)     // Catch: org.json.JSONException -> L57 java.lang.Exception -> L71
            goto L19
        L57:
            r2 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r2)     // Catch: java.lang.Exception -> L71
            goto L19
        L5c:
            java.lang.String r2 = r8.nextString()     // Catch: org.json.JSONException -> L64 java.lang.Exception -> L71
            r1.put(r5, r2)     // Catch: org.json.JSONException -> L64 java.lang.Exception -> L71
            goto L19
        L64:
            r2 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r2)     // Catch: java.lang.Exception -> L71
            goto L19
        L69:
            r8.endObject()     // Catch: java.lang.Exception -> L71
            goto L8
        L6d:
            r8.endArray()     // Catch: java.lang.Exception -> L71
            goto L75
        L71:
            r8 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r8)
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.a(android.util.JsonReader):org.json.JSONArray");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void z(android.util.JsonReader r6, com.bytedance.adsdk.lottie.fo.z r7) {
        /*
        L0:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L88
            java.lang.String r0 = r6.nextName()     // Catch: java.lang.Exception -> L89
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L89
            r2 = -2128704353(0xffffffff811e8c9f, float:-2.9120907E-38)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r1 == r2) goto L25
            r2 = 3308(0xcec, float:4.635E-42)
            if (r1 == r2) goto L1b
            goto L2f
        L1b:
            java.lang.String r1 = "gs"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L2f
            r0 = r4
            goto L30
        L25:
            java.lang.String r1 = "is_secondary"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L2f
            r0 = r3
            goto L30
        L2f:
            r0 = r5
        L30:
            if (r0 == 0) goto L80
            if (r0 == r4) goto L38
            r6.skipValue()     // Catch: java.lang.Exception -> L89
            goto L0
        L38:
            android.util.JsonToken r0 = r6.peek()     // Catch: java.lang.Exception -> L89
            android.util.JsonToken r1 = android.util.JsonToken.NULL     // Catch: java.lang.Exception -> L89
            if (r0 != r1) goto L44
            r6.nextNull()     // Catch: java.lang.Exception -> L89
            goto L0
        L44:
            com.bytedance.adsdk.lottie.fo$z$z r0 = new com.bytedance.adsdk.lottie.fo$z$z     // Catch: java.lang.Exception -> L89
            r0.<init>()     // Catch: java.lang.Exception -> L89
            r7.z = r0     // Catch: java.lang.Exception -> L89
            r6.beginObject()     // Catch: java.lang.Exception -> L89
        L4e:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L7c
            java.lang.String r0 = r6.nextName()     // Catch: java.lang.Exception -> L89
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L89
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L61
            goto L6b
        L61:
            java.lang.String r1 = "r"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L89
            if (r0 == 0) goto L6b
            r0 = r3
            goto L6c
        L6b:
            r0 = r5
        L6c:
            if (r0 == 0) goto L72
            r6.skipValue()     // Catch: java.lang.Exception -> L89
            goto L4e
        L72:
            com.bytedance.adsdk.lottie.fo$z$z r0 = r7.z     // Catch: java.lang.Exception -> L89
            double r1 = r6.nextDouble()     // Catch: java.lang.Exception -> L89
            float r1 = (float) r1     // Catch: java.lang.Exception -> L89
            r0.z = r1     // Catch: java.lang.Exception -> L89
            goto L4e
        L7c:
            r6.endObject()     // Catch: java.lang.Exception -> L89
            goto L0
        L80:
            boolean r0 = r6.nextBoolean()     // Catch: java.lang.Exception -> L89
            r7.g = r0     // Catch: java.lang.Exception -> L89
            goto L0
        L88:
            return
        L89:
            r6 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.z(android.util.JsonReader, com.bytedance.adsdk.lottie.fo$z):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.bytedance.adsdk.lottie.fo.g> gc(android.util.JsonReader r9) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.gc(android.util.JsonReader):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.adsdk.lottie.fo.g.z m(android.util.JsonReader r5) {
        /*
            com.bytedance.adsdk.lottie.fo$g$z r0 = new com.bytedance.adsdk.lottie.fo$g$z     // Catch: java.lang.Exception -> L4f
            r0.<init>()     // Catch: java.lang.Exception -> L4f
            r5.beginObject()     // Catch: java.lang.Exception -> L4f
        L8:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Exception -> L4f
            if (r1 == 0) goto L4b
            java.lang.String r1 = r5.nextName()     // Catch: java.lang.Exception -> L4f
            int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L4f
            r3 = 99
            r4 = 1
            if (r2 == r3) goto L2a
            r3 = 3706(0xe7a, float:5.193E-42)
            if (r2 == r3) goto L20
            goto L34
        L20:
            java.lang.String r2 = "tn"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L4f
            if (r1 == 0) goto L34
            r1 = 0
            goto L35
        L2a:
            java.lang.String r2 = "c"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L4f
            if (r1 == 0) goto L34
            r1 = r4
            goto L35
        L34:
            r1 = -1
        L35:
            if (r1 == 0) goto L44
            if (r1 == r4) goto L3d
            r5.skipValue()     // Catch: java.lang.Exception -> L4f
            goto L8
        L3d:
            java.lang.String r1 = r5.nextString()     // Catch: java.lang.Exception -> L4f
            r0.g = r1     // Catch: java.lang.Exception -> L4f
            goto L8
        L44:
            int r1 = r5.nextInt()     // Catch: java.lang.Exception -> L4f
            r0.z = r1     // Catch: java.lang.Exception -> L4f
            goto L8
        L4b:
            r5.endObject()     // Catch: java.lang.Exception -> L4f
            return r0
        L4f:
            r5 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r5)
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.a.zw.m(android.util.JsonReader):com.bytedance.adsdk.lottie.fo$g$z");
    }

    private static void z(JsonReader jsonReader, Map<String, com.bytedance.adsdk.lottie.model.dl> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.dl dlVarZ = v.z(jsonReader);
                    map.put(dlVarZ.g(), dlVarZ);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, SparseArray<com.bytedance.adsdk.lottie.model.a> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.a aVarZ = i.z(jsonReader, mVar);
            sparseArray.put(aVarZ.hashCode(), aVarZ);
        }
        jsonReader.endArray();
    }

    private static void z(JsonReader jsonReader, List<com.bytedance.adsdk.lottie.model.m> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.lottie.model.m(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
