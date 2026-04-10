package com.bytedance.adsdk.lottie.ga;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class xu implements j<Float> {
    public static final xu e = new xu();

    private xu() {
    }

    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Float bf(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(k.bf(jsonReader) * f);
    }
}
