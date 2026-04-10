package com.bytedance.adsdk.lottie.a;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class e implements xl<Integer> {
    public static final e z = new e();

    private e() {
    }

    @Override // com.bytedance.adsdk.lottie.a.xl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Integer g(JsonReader jsonReader, float f) throws IOException {
        boolean z2 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z2) {
            jsonReader.beginArray();
        }
        double dNextDouble = jsonReader.nextDouble();
        double dNextDouble2 = jsonReader.nextDouble();
        double dNextDouble3 = jsonReader.nextDouble();
        double dNextDouble4 = jsonReader.peek() == JsonToken.NUMBER ? jsonReader.nextDouble() : 1.0d;
        if (z2) {
            jsonReader.endArray();
        }
        if (dNextDouble <= 1.0d && dNextDouble2 <= 1.0d && dNextDouble3 <= 1.0d) {
            dNextDouble *= 255.0d;
            dNextDouble2 *= 255.0d;
            dNextDouble3 *= 255.0d;
            if (dNextDouble4 <= 1.0d) {
                dNextDouble4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dNextDouble4, (int) dNextDouble, (int) dNextDouble2, (int) dNextDouble3));
    }
}
