package com.bytedance.adsdk.lottie.ga;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class f implements j<Integer> {
    public static final f e = new f();

    private f() {
    }

    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Integer bf(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(k.bf(jsonReader) * f));
    }
}
