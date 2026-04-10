package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class lq {
    static com.bytedance.adsdk.lottie.model.g.i z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "r":
                    gVarZ = a.z(jsonReader, mVar, true);
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
        if (zNextBoolean) {
            return null;
        }
        return new com.bytedance.adsdk.lottie.model.g.i(strNextString, gVarZ);
    }
}
