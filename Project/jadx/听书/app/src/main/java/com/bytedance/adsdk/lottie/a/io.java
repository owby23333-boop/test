package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.g.gz;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class io {
    static com.bytedance.adsdk.lottie.model.g.gz z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        String strNextName;
        jsonReader.beginObject();
        gz.z zVar = null;
        com.bytedance.adsdk.lottie.model.z.gz gzVarGc = null;
        com.bytedance.adsdk.lottie.model.z.a aVarG = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    aVarG = a.g(jsonReader, mVar);
                    break;
                case "pt":
                    gzVarGc = a.gc(jsonReader, mVar);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            zVar = gz.z.MASK_MODE_ADD;
                            break;
                        case "i":
                            mVar.z("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            zVar = gz.z.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            zVar = gz.z.MASK_MODE_NONE;
                            break;
                        case "s":
                            zVar = gz.z.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.bytedance.adsdk.lottie.gc.gc.g("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            zVar = gz.z.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.g.gz(zVar, gzVarGc, aVarG, zNextBoolean);
    }
}
