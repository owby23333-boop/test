package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.g.js;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class na {
    static com.bytedance.adsdk.lottie.model.g.js z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String strNextString = null;
        js.z zVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    gVarZ2 = a.z(jsonReader, mVar, false);
                    break;
                case "m":
                    zVarZ = js.z.z(jsonReader.nextInt());
                    break;
                case "o":
                    gVarZ3 = a.z(jsonReader, mVar, false);
                    break;
                case "s":
                    gVarZ = a.z(jsonReader, mVar, false);
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
        return new com.bytedance.adsdk.lottie.model.g.js(strNextString, zVarZ, gVarZ, gVarZ2, gVarZ3, zNextBoolean);
    }
}
