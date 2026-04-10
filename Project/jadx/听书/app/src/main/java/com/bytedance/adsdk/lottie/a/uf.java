package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.g.fo;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class uf {
    static com.bytedance.adsdk.lottie.model.g.fo z(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        fo.z zVarZ = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    zVarZ = fo.z.z(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.g.fo(strNextString, zVarZ, zNextBoolean);
    }
}
