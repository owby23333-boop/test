package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class l implements xl<PointF> {
    public static final l z = new l();

    private l() {
    }

    @Override // com.bytedance.adsdk.lottie.a.xl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public PointF g(JsonReader jsonReader, float f) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.BEGIN_ARRAY) {
            return js.g(jsonReader, f);
        }
        if (jsonTokenPeek == JsonToken.BEGIN_OBJECT) {
            return js.g(jsonReader, f);
        }
        if (jsonTokenPeek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(String.valueOf(jsonTokenPeek)));
    }
}
