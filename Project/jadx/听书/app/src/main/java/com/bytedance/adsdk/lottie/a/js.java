package com.bytedance.adsdk.lottie.a;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class js {
    static int z(JsonReader jsonReader) throws IOException {
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

    static List<PointF> z(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(g(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.a.js$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[JsonToken.values().length];
            z = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static PointF g(JsonReader jsonReader, float f) throws IOException {
        int i = AnonymousClass1.z[jsonReader.peek().ordinal()];
        if (i == 1) {
            return dl(jsonReader, f);
        }
        if (i == 2) {
            return a(jsonReader, f);
        }
        if (i == 3) {
            return gc(jsonReader, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    private static PointF dl(JsonReader jsonReader, float f) throws IOException {
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(fNextDouble * f, fNextDouble2 * f);
    }

    private static PointF a(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(fNextDouble * f, fNextDouble2 * f);
    }

    private static PointF gc(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginObject();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("x")) {
                fG = g(jsonReader);
            } else if (strNextName.equals("y")) {
                fG2 = g(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(fG * f, fG2 * f);
    }

    static float g(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int i = AnonymousClass1.z[jsonTokenPeek.ordinal()];
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
        throw new IllegalArgumentException("Unknown value for token of type ".concat(String.valueOf(jsonTokenPeek)));
    }
}
