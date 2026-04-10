package com.bytedance.adsdk.lottie.ga;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.component.sdk.annotation.ColorInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.ga.k$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[JsonToken.values().length];
            e = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF bf(JsonReader jsonReader, float f) throws IOException {
        int i = AnonymousClass1.e[jsonReader.peek().ordinal()];
        if (i == 1) {
            return d(jsonReader, f);
        }
        if (i == 2) {
            return tg(jsonReader, f);
        }
        if (i == 3) {
            return ga(jsonReader, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    private static PointF d(JsonReader jsonReader, float f) throws IOException {
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(fNextDouble * f, fNextDouble2 * f);
    }

    @ColorInt
    public static int e(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    private static PointF ga(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginObject();
        float fBf = 0.0f;
        float fBf2 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("x")) {
                fBf = bf(jsonReader);
            } else if (strNextName.equals("y")) {
                fBf2 = bf(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(fBf * f, fBf2 * f);
    }

    private static PointF tg(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(fNextDouble * f, fNextDouble2 * f);
    }

    public static float bf(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int i = AnonymousClass1.e[jsonTokenPeek.ordinal()];
        if (i == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i == 2) {
            jsonReader.beginArray();
            float fNextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return fNextDouble;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + jsonTokenPeek);
    }

    public static List<PointF> e(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(bf(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }
}
