package com.bytedance.adsdk.lottie.ga;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class bx implements j<com.bytedance.adsdk.lottie.p.tg> {
    public static final bx e = new bx();

    private bx() {
    }

    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.p.tg bf(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.lottie.p.tg((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
