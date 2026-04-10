package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class gc {
    static com.bytedance.adsdk.lottie.model.g.z z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        com.bytedance.adsdk.lottie.model.g.z zVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.g.z zVarG = g(jsonReader, mVar);
                    if (zVarG != null) {
                        zVar = zVarG;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return zVar;
    }

    private static com.bytedance.adsdk.lottie.model.g.z g(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.g.z zVar = null;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("v")) {
                    if (z) {
                        zVar = new com.bytedance.adsdk.lottie.model.g.z(a.z(jsonReader, mVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (strNextName.equals("ty")) {
                    if (jsonReader.nextInt() == 0) {
                        z = true;
                    }
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return zVar;
        }
    }
}
