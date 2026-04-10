package com.bytedance.adsdk.lottie.a;

import android.graphics.Path;
import android.util.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class ls {
    static com.bytedance.adsdk.lottie.model.g.gc z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        int iNextInt;
        com.bytedance.adsdk.lottie.model.z.a aVarG = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.g.e eVar = null;
        com.bytedance.adsdk.lottie.model.z.dl dlVarZ = null;
        com.bytedance.adsdk.lottie.model.z.m mVarDl = null;
        com.bytedance.adsdk.lottie.model.z.m mVarDl2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            iNextInt = -1;
            switch (strNextName) {
                case "e":
                    mVarDl2 = a.dl(jsonReader, mVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(t.f1872a)) {
                            dlVarZ = a.z(jsonReader, mVar, iNextInt);
                        } else if (strNextName2.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    aVarG = a.g(jsonReader, mVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    mVarDl = a.dl(jsonReader, mVar);
                    break;
                case "t":
                    eVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.g.e.LINEAR : com.bytedance.adsdk.lottie.model.g.e.RADIAL;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.g.gc(strNextString, eVar, fillType, dlVarZ, aVarG == null ? new com.bytedance.adsdk.lottie.model.z.a(Collections.singletonList(new com.bytedance.adsdk.lottie.m.z(100))) : aVarG, mVarDl, mVarDl2, null, null, zNextBoolean);
    }
}
