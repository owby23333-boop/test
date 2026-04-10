package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.g.uy;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class h {
    static com.bytedance.adsdk.lottie.model.g.uy z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, int i) throws IOException {
        boolean zNextBoolean = false;
        boolean z = i == 3;
        String strNextString = null;
        uy.z zVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVarG = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ3 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ4 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ5 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ6 = null;
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
                case "r":
                    gVarZ2 = a.z(jsonReader, mVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    gVarZ3 = a.z(jsonReader, mVar);
                    break;
                case "is":
                    gVarZ5 = a.z(jsonReader, mVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    gVarZ4 = a.z(jsonReader, mVar);
                    break;
                case "os":
                    gVarZ6 = a.z(jsonReader, mVar, false);
                    break;
                case "pt":
                    gVarZ = a.z(jsonReader, mVar, false);
                    break;
                case "sy":
                    zVarZ = uy.z.z(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.g.uy(strNextString, zVarZ, gVarZ, iVarG, gVarZ2, gVarZ3, gVarZ4, gVarZ5, gVarZ6, zNextBoolean, z);
    }
}
