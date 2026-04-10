package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static com.bytedance.adsdk.lottie.model.z.gc z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(sy.z(jsonReader, mVar));
            }
            jsonReader.endArray();
            q.z(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.lottie.m.z(js.g(jsonReader, com.bytedance.adsdk.lottie.gc.fo.z())));
        }
        return new com.bytedance.adsdk.lottie.model.z.gc(arrayList);
    }

    static com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> g(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.z.gc gcVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    gcVarZ = z(jsonReader, mVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        gVarZ = a.z(jsonReader, mVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        gVarZ2 = a.z(jsonReader, mVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            mVar.z("Lottie doesn't support expressions.");
        }
        return gcVarZ != null ? gcVarZ : new com.bytedance.adsdk.lottie.model.z.fo(gVarZ, gVarZ2);
    }
}
