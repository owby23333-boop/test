package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.g.fv;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class p {
    static com.bytedance.adsdk.lottie.model.g.m z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        boolean z;
        com.bytedance.adsdk.lottie.model.z.g gVar;
        float f;
        fv.z zVar;
        fv.g gVar2;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.g.e eVar = null;
        com.bytedance.adsdk.lottie.model.z.dl dlVarZ = null;
        com.bytedance.adsdk.lottie.model.z.m mVarDl = null;
        com.bytedance.adsdk.lottie.model.z.m mVarDl2 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        fv.z zVar2 = null;
        fv.g gVar3 = null;
        com.bytedance.adsdk.lottie.model.z.g gVar4 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.lottie.model.z.a aVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            z = zNextBoolean;
            gVar = gVar4;
            f = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
                        while (jsonReader.hasNext()) {
                            fv.g gVar5 = gVar3;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            fv.z zVar3 = zVar2;
                            if (strNextName2.equals(t.h)) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                gVarZ2 = a.z(jsonReader, mVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            gVar3 = gVar5;
                            zVar2 = zVar3;
                        }
                        fv.z zVar4 = zVar2;
                        fv.g gVar6 = gVar3;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            gVar = gVarZ2;
                            gVar3 = gVar6;
                            zVar2 = zVar4;
                        } else {
                            if (strNextString2.equals("d") || strNextString2.equals("g")) {
                                mVar.z(true);
                                arrayList.add(gVarZ2);
                            }
                            gVar3 = gVar6;
                            zVar2 = zVar4;
                        }
                    }
                    zVar = zVar2;
                    gVar2 = gVar3;
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        gVar4 = gVar;
                        zNextBoolean = z;
                        gVar3 = gVar2;
                        fNextDouble = f;
                        zVar2 = zVar;
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        zNextBoolean = z;
                        gVar4 = gVar;
                        gVar3 = gVar2;
                        fNextDouble = f;
                        zVar2 = zVar;
                        break;
                    }
                    break;
                case "e":
                    mVarDl2 = a.dl(jsonReader, mVar);
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals(t.f1872a)) {
                            dlVarZ = a.z(jsonReader, mVar, iNextInt);
                        } else if (strNextName3.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "o":
                    aVar = a.g(jsonReader, mVar);
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "s":
                    mVarDl = a.dl(jsonReader, mVar);
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "t":
                    eVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.g.e.LINEAR : com.bytedance.adsdk.lottie.model.g.e.RADIAL;
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "w":
                    gVarZ = a.z(jsonReader, mVar);
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "lc":
                    zVar2 = fv.z.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "lj":
                    gVar3 = fv.g.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = z;
                    gVar4 = gVar;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    zNextBoolean = z;
                    gVar4 = gVar;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    zVar = zVar2;
                    gVar2 = gVar3;
                    gVar4 = gVar;
                    zNextBoolean = z;
                    gVar3 = gVar2;
                    fNextDouble = f;
                    zVar2 = zVar;
                    break;
            }
        }
        fv.z zVar5 = zVar2;
        fv.g gVar7 = gVar3;
        float f2 = fNextDouble;
        com.bytedance.adsdk.lottie.model.z.g gVar8 = gVar4;
        boolean z2 = zNextBoolean;
        if (aVar == null) {
            aVar = new com.bytedance.adsdk.lottie.model.z.a(Collections.singletonList(new com.bytedance.adsdk.lottie.m.z(100)));
        }
        return new com.bytedance.adsdk.lottie.model.g.m(strNextString, eVar, dlVarZ, aVar, mVarDl, mVarDl2, gVarZ, zVar5, gVar7, f2, arrayList, gVar8, z2);
    }
}
