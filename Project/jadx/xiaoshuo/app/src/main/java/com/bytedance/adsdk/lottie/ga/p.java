package com.bytedance.adsdk.lottie.ga;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class p implements j<Integer> {
    public static final p e = new p();

    private p() {
    }

    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Integer bf(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        double dNextDouble = jsonReader.nextDouble();
        double dNextDouble2 = jsonReader.nextDouble();
        double dNextDouble3 = jsonReader.nextDouble();
        double dNextDouble4 = jsonReader.peek() == JsonToken.NUMBER ? jsonReader.nextDouble() : 1.0d;
        if (z) {
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
