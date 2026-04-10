package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class eo {
    static com.bytedance.adsdk.lottie.model.g.ls z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.g.dl dlVarZ = gz.z(jsonReader, mVar);
                        if (dlVarZ != null) {
                            arrayList.add(dlVarZ);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.g.ls(strNextString, arrayList, zNextBoolean);
    }
}
