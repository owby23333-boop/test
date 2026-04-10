package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.g.fv;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class wj {
    static com.bytedance.adsdk.lottie.model.g.fv z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        int i;
        com.bytedance.adsdk.lottie.model.z.g gVarZ;
        int i2;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.g gVar = null;
        com.bytedance.adsdk.lottie.model.z.z zVarE = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
        fv.z zVar = null;
        fv.g gVar2 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.lottie.model.z.a aVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            i = 1;
            switch (strNextName) {
                case "c":
                    zVarE = a.e(jsonReader, mVar);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        gVarZ = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals(t.h)) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                gVarZ = a.z(jsonReader, mVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                i2 = 1;
                                mVar.z(true);
                                arrayList.add(gVarZ);
                                i = i2;
                                break;
                            case "o":
                                gVar = gVarZ;
                                i = 1;
                                break;
                            default:
                                i2 = 1;
                                i = i2;
                                break;
                        }
                    }
                    int i3 = i;
                    jsonReader.endArray();
                    if (arrayList.size() != i3) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                case "o":
                    aVar = a.g(jsonReader, mVar);
                    continue;
                    break;
                case "w":
                    gVarZ2 = a.z(jsonReader, mVar);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    zVar = fv.z.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    gVar2 = fv.g.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (aVar == null) {
            aVar = new com.bytedance.adsdk.lottie.model.z.a(Collections.singletonList(new com.bytedance.adsdk.lottie.m.z(100)));
        }
        return new com.bytedance.adsdk.lottie.model.g.fv(strNextString, gVar, arrayList, zVarE, aVar, gVarZ2, zVar, gVar2, fNextDouble, zNextBoolean);
    }
}
