package com.bytedance.adsdk.lottie.a;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.model.layer.gz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.common.base.Ascii;
import com.umeng.analytics.pro.an;
import com.xuexiang.xupdate.utils.ShellUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class iq {
    public static com.bytedance.adsdk.lottie.model.layer.gz z(com.bytedance.adsdk.lottie.m mVar) {
        Rect rectA = mVar.a();
        return new com.bytedance.adsdk.lottie.model.layer.gz(Collections.emptyList(), mVar, "__container", -1L, gz.z.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.lottie.model.z.wp(), 0, 0, 0, 0.0f, 0.0f, rectA.width(), rectA.height(), null, null, Collections.emptyList(), gz.g.NONE, null, false, null, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.lottie.model.layer.gz z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        ArrayList arrayList;
        gz.g gVar = gz.g.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        gz.g gVar2 = gVar;
        gz.z zVar = null;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.wp wpVarZ = null;
        com.bytedance.adsdk.lottie.model.z.uy uyVarM = null;
        com.bytedance.adsdk.lottie.model.z.kb kbVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        com.bytedance.adsdk.lottie.model.g.z zVarZ = null;
        uy uyVarZ = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fE = 0.0f;
        long jNextInt2 = -1;
        float fNextDouble4 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        float fNextDouble5 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 2;
                    }
                    break;
                case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID /* 116 */:
                    if (strNextName.equals(an.aI)) {
                        b = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals("w")) {
                        b = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b = 6;
                    }
                    break;
                case 3324:
                    if (strNextName.equals(LiveConfigKey.HIGH)) {
                        b = 7;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b = 8;
                    }
                    break;
                case 3432:
                    if (strNextName.equals(MediationConstant.ADN_KS)) {
                        b = 9;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 10;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        b = 11;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 12;
                    }
                    break;
                case 3669:
                    if (strNextName.equals(ShellUtils.COMMAND_SH)) {
                        b = 13;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b = 14;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b = 15;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = 16;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b = 17;
                    }
                    break;
                case 3712:
                    if (strNextName.equals(TtmlNode.TAG_TT)) {
                        b = Ascii.DC2;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        b = 19;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = Ascii.DC4;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = Ascii.NAK;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = Ascii.SYN;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.g.dl dlVarZ = gz.z(jsonReader, mVar);
                        if (dlVarZ != null) {
                            arrayList3.add(dlVarZ);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.lottie.gc.fo.z()));
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                kbVarZ = g.z(jsonReader, mVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals("d")) {
                            uyVarM = a.m(jsonReader, mVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.lottie.gc.fo.z()));
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList4.add(jsonReader.nextString());
                            } else if (strNextName3.equals("ty")) {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    zVarZ = gc.z(jsonReader, mVar);
                                } else if (iNextInt3 == 25) {
                                    uyVarZ = new kb().z(jsonReader, mVar);
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    mVar.z("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList4)));
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    break;
                case 9:
                    wpVarZ = dl.z(jsonReader, mVar);
                    break;
                case 10:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 11:
                    fE = (float) jsonReader.nextDouble();
                    break;
                case 12:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 13:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.gc.fo.z());
                    break;
                case 14:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    iNextInt = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.gc.fo.z());
                    break;
                case 17:
                    gVarZ = a.z(jsonReader, mVar, false);
                    break;
                case 18:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= gz.g.values().length) {
                        mVar.z("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    } else {
                        gVar2 = gz.g.values()[iNextInt4];
                        int i = AnonymousClass1.z[gVar2.ordinal()];
                        if (i == 1) {
                            mVar.z("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            mVar.z("Unsupported matte type: Luma Inverted");
                        }
                        mVar.z(1);
                    }
                    break;
                case 19:
                    int iNextInt5 = jsonReader.nextInt();
                    if (iNextInt5 < gz.z.UNKNOWN.ordinal()) {
                        zVar = gz.z.values()[iNextInt5];
                    } else {
                        zVar = gz.z.UNKNOWN;
                    }
                    break;
                case 20:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 21:
                    strNextString = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(io.z(jsonReader, mVar));
                    }
                    mVar.z(arrayList2.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList5 = new ArrayList();
        if (fNextDouble5 > 0.0f) {
            arrayList = arrayList2;
            arrayList5.add(new com.bytedance.adsdk.lottie.m.z(mVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble5)));
        } else {
            arrayList = arrayList2;
        }
        if (fE <= 0.0f) {
            fE = mVar.e();
        }
        arrayList5.add(new com.bytedance.adsdk.lottie.m.z(mVar, fValueOf2, fValueOf2, null, fNextDouble5, Float.valueOf(fE)));
        arrayList5.add(new com.bytedance.adsdk.lottie.m.z(mVar, fValueOf, fValueOf, null, fE, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            mVar.z("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.lottie.model.layer.gz(arrayList3, mVar, strNextString2, jNextInt, zVar, jNextInt2, strNextString, arrayList, wpVarZ, iNextInt, iNextInt2, color, fNextDouble4, fNextDouble, fNextDouble2, fNextDouble3, uyVarM, kbVarZ, arrayList5, gVar2, gVarZ, zNextBoolean, zVarZ, uyVarZ);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.a.iq$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[gz.g.values().length];
            z = iArr;
            try {
                iArr[gz.g.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[gz.g.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
