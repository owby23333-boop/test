package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class gz {
    static com.bytedance.adsdk.lottie.model.g.dl z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        com.bytedance.adsdk.lottie.model.g.dl dlVarZ;
        String strNextString;
        jsonReader.beginObject();
        int iNextInt = 2;
        while (true) {
            dlVarZ = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("d")) {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                iNextInt = jsonReader.nextInt();
            }
        }
        if (strNextString == null) {
            return null;
        }
        strNextString.hashCode();
        switch (strNextString) {
            case "el":
                dlVarZ = m.z(jsonReader, mVar, iNextInt);
                break;
            case "fl":
                dlVarZ = ti.z(jsonReader, mVar);
                break;
            case "gf":
                dlVarZ = ls.z(jsonReader, mVar);
                break;
            case "gr":
                dlVarZ = eo.z(jsonReader, mVar);
                break;
            case "gs":
                dlVarZ = p.z(jsonReader, mVar);
                break;
            case "mm":
                dlVarZ = uf.z(jsonReader);
                mVar.z("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case "rc":
                dlVarZ = gk.z(jsonReader, mVar);
                break;
            case "rd":
                dlVarZ = lq.z(jsonReader, mVar);
                break;
            case "rp":
                dlVarZ = x.z(jsonReader, mVar);
                break;
            case "sh":
                dlVarZ = oq.z(jsonReader, mVar);
                break;
            case "sr":
                dlVarZ = h.z(jsonReader, mVar, iNextInt);
                break;
            case "st":
                dlVarZ = wj.z(jsonReader, mVar);
                break;
            case "tm":
                dlVarZ = na.z(jsonReader, mVar);
                break;
            case "tr":
                dlVarZ = dl.z(jsonReader, mVar);
                break;
            default:
                com.bytedance.adsdk.lottie.gc.gc.g("Unknown shape type ".concat(String.valueOf(strNextString)));
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return dlVarZ;
    }
}
