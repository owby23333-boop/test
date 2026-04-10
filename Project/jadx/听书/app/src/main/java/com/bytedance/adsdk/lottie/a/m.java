package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class m {
    static com.bytedance.adsdk.lottie.model.g.g z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, int i) throws IOException {
        boolean z = i == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVarG = null;
        com.bytedance.adsdk.lottie.model.z.m mVarDl = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    iVarG = z.g(jsonReader, mVar);
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
        return new com.bytedance.adsdk.lottie.model.g.g(strNextString, iVarG, mVarDl, z, zNextBoolean);
    }
}
