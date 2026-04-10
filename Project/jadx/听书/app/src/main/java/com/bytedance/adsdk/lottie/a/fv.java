package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class fv implements xl<Integer> {
    public static final fv z = new fv();

    private fv() {
    }

    @Override // com.bytedance.adsdk.lottie.a.xl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Integer g(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(js.g(jsonReader) * f));
    }
}
