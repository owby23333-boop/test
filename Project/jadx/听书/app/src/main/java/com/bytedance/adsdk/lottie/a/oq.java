package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class oq {
    static com.bytedance.adsdk.lottie.model.g.p z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.gz gzVarGc = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ks":
                    gzVarGc = a.gc(jsonReader, mVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.g.p(strNextString, iNextInt, gzVarGc, zNextBoolean);
    }
}
