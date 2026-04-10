package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.model.z.g f139a;
    private com.bytedance.adsdk.lottie.model.z.g dl;
    private com.bytedance.adsdk.lottie.model.z.g g;
    private com.bytedance.adsdk.lottie.model.z.g gc;
    private com.bytedance.adsdk.lottie.model.z.z z;

    uy z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    g(jsonReader, mVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        if (this.z == null || this.g == null || this.dl == null || this.f139a == null || this.gc == null) {
            return null;
        }
        return new uy(this.z, this.g, this.dl, this.f139a, this.gc);
    }

    private void g(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.f139a = a.z(jsonReader, mVar);
                        break;
                    case "Opacity":
                        this.g = a.z(jsonReader, mVar, false);
                        break;
                    case "Direction":
                        this.dl = a.z(jsonReader, mVar, false);
                        break;
                    case "Shadow Color":
                        this.z = a.e(jsonReader, mVar);
                        break;
                    case "Softness":
                        this.gc = a.z(jsonReader, mVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
