package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static com.bytedance.adsdk.lottie.model.z.kb z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.z.kb kbVarG = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                kbVarG = g(jsonReader, mVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return kbVarG == null ? new com.bytedance.adsdk.lottie.model.z.kb(null, null, null, null) : kbVarG;
    }

    private static com.bytedance.adsdk.lottie.model.z.kb g(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.z.z zVarE = null;
        com.bytedance.adsdk.lottie.model.z.z zVarE2 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    gVarZ2 = a.z(jsonReader, mVar);
                    break;
                case "fc":
                    zVarE = a.e(jsonReader, mVar);
                    break;
                case "sc":
                    zVarE2 = a.e(jsonReader, mVar);
                    break;
                case "sw":
                    gVarZ = a.z(jsonReader, mVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.z.kb(zVarE, zVarE2, gVarZ, gVarZ2);
    }
}
