package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class x {
    static com.bytedance.adsdk.lottie.model.g.wp z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
        com.bytedance.adsdk.lottie.model.z.wp wpVarZ = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    gVarZ = a.z(jsonReader, mVar, false);
                    break;
                case "o":
                    gVarZ2 = a.z(jsonReader, mVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    wpVarZ = dl.z(jsonReader, mVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.g.wp(strNextString, gVarZ, gVarZ2, wpVarZ, zNextBoolean);
    }
}
