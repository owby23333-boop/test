package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class un implements xl<com.bytedance.adsdk.lottie.model.g.v> {
    public static final un z = new un();

    private un() {
    }

    @Override // com.bytedance.adsdk.lottie.a.xl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.g.v g(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listZ = null;
        List<PointF> listZ2 = null;
        List<PointF> listZ3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "c":
                        zNextBoolean = jsonReader.nextBoolean();
                        break;
                    case "i":
                        listZ2 = js.z(jsonReader, f);
                        break;
                    case "o":
                        listZ3 = js.z(jsonReader, f);
                        break;
                    case "v":
                        listZ = js.z(jsonReader, f);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listZ == null || listZ2 == null || listZ3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listZ.isEmpty()) {
                    return new com.bytedance.adsdk.lottie.model.g.v(new PointF(), false, Collections.emptyList());
                }
                int size = listZ.size();
                PointF pointF = listZ.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listZ.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.model.z(com.bytedance.adsdk.lottie.gc.gz.z(listZ.get(i2), listZ3.get(i2)), com.bytedance.adsdk.lottie.gc.gz.z(pointF2, listZ2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listZ.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.model.z(com.bytedance.adsdk.lottie.gc.gz.z(listZ.get(i3), listZ3.get(i3)), com.bytedance.adsdk.lottie.gc.gz.z(pointF3, listZ2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.lottie.model.g.v(pointF, zNextBoolean, arrayList);
            }
        }
    }
}
