package com.bytedance.adsdk.lottie.ga;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bm implements j<com.bytedance.adsdk.lottie.d.bf.t> {
    public static final bm e = new bm();

    private bm() {
    }

    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.d.bf.t bf(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listE = null;
        List<PointF> listE2 = null;
        List<PointF> listE3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listE == null || listE2 == null || listE3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listE.isEmpty()) {
                    return new com.bytedance.adsdk.lottie.d.bf.t(new PointF(), false, Collections.emptyList());
                }
                int size = listE.size();
                PointF pointF = listE.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listE.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.d.e(com.bytedance.adsdk.lottie.vn.p.e(listE.get(i2), listE3.get(i2)), com.bytedance.adsdk.lottie.vn.p.e(pointF2, listE2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listE.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.d.e(com.bytedance.adsdk.lottie.vn.p.e(listE.get(i3), listE3.get(i3)), com.bytedance.adsdk.lottie.vn.p.e(pointF3, listE2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.lottie.d.bf.t(pointF, zNextBoolean, arrayList);
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listE2 = k.e(jsonReader, f);
                    break;
                case "o":
                    listE3 = k.e(jsonReader, f);
                    break;
                case "v":
                    listE = k.e(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
    }
}
