package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class gk {
    static com.bytedance.adsdk.lottie.model.g.kb z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVarG = null;
        com.bytedance.adsdk.lottie.model.z.m mVarDl = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    iVarG = z.g(jsonReader, mVar);
                    break;
                case "r":
                    gVarZ = a.z(jsonReader, mVar);
                    break;
                case "s":
                    mVarDl = a.dl(jsonReader, mVar);
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
        return new com.bytedance.adsdk.lottie.model.g.kb(strNextString, iVarG, mVarDl, gVarZ, zNextBoolean);
    }
}
