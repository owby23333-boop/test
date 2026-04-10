package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static com.bytedance.adsdk.lottie.model.z.g z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return z(jsonReader, mVar, true);
    }

    public static com.bytedance.adsdk.lottie.model.z.g z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, boolean z) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.g(z(jsonReader, z ? com.bytedance.adsdk.lottie.gc.fo.z() : 1.0f, mVar, wp.z));
    }

    static com.bytedance.adsdk.lottie.model.z.a g(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.a(z(jsonReader, mVar, fv.z));
    }

    static com.bytedance.adsdk.lottie.model.z.m dl(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.m(q.z(jsonReader, mVar, com.bytedance.adsdk.lottie.gc.fo.z(), l.z, true));
    }

    static com.bytedance.adsdk.lottie.model.z.e a(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.e(z(jsonReader, mVar, mc.z));
    }

    static com.bytedance.adsdk.lottie.model.z.gz gc(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.gz(z(jsonReader, com.bytedance.adsdk.lottie.gc.fo.z(), mVar, un.z));
    }

    static com.bytedance.adsdk.lottie.model.z.uy m(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.uy(z(jsonReader, com.bytedance.adsdk.lottie.gc.fo.z(), mVar, fo.z));
    }

    static com.bytedance.adsdk.lottie.model.z.z e(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.z(z(jsonReader, mVar, e.z));
    }

    static com.bytedance.adsdk.lottie.model.z.dl z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, int i) throws IOException {
        return new com.bytedance.adsdk.lottie.model.z.dl(z(jsonReader, mVar, new pf(i)));
    }

    private static <T> List<com.bytedance.adsdk.lottie.m.z<T>> z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, xl<T> xlVar) throws IOException {
        return q.z(jsonReader, mVar, 1.0f, xlVar, false);
    }

    private static <T> List<com.bytedance.adsdk.lottie.m.z<T>> z(JsonReader jsonReader, float f, com.bytedance.adsdk.lottie.m mVar, xl<T> xlVar) throws IOException {
        return q.z(jsonReader, mVar, f, xlVar, false);
    }
}
