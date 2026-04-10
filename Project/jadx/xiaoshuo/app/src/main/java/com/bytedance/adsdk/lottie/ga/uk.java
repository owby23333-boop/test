package com.bytedance.adsdk.lottie.ga;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class uk implements j<PointF> {
    public static final uk e = new uk();

    private uk() {
    }

    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public PointF bf(JsonReader jsonReader, float f) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek != JsonToken.BEGIN_ARRAY && jsonTokenPeek != JsonToken.BEGIN_OBJECT) {
            if (jsonTokenPeek == JsonToken.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + jsonTokenPeek);
        }
        return k.bf(jsonReader, f);
    }
}
