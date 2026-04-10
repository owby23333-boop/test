package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class wp implements xl<Float> {
    public static final wp z = new wp();

    private wp() {
    }

    @Override // com.bytedance.adsdk.lottie.a.xl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Float g(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(js.g(jsonReader) * f);
    }
}
