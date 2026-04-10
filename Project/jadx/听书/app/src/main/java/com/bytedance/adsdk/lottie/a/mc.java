package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class mc implements xl<com.bytedance.adsdk.lottie.m.a> {
    public static final mc z = new mc();

    private mc() {
    }

    @Override // com.bytedance.adsdk.lottie.a.xl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.m.a g(JsonReader jsonReader, float f) throws IOException {
        boolean z2 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z2) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z2) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.lottie.m.a((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
