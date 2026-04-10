package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.g;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements xl<com.bytedance.adsdk.lottie.model.g> {
    public static final fo z = new fo();

    private fo() {
    }

    @Override // com.bytedance.adsdk.lottie.a.xl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.g g(JsonReader jsonReader, float f) throws IOException {
        g.z zVar = g.z.CENTER;
        jsonReader.beginObject();
        g.z zVar2 = zVar;
        String strNextString = null;
        String strNextString2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iZ = 0;
        int iZ2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "f":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "j":
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 > g.z.CENTER.ordinal() || iNextInt2 < 0) {
                        zVar2 = g.z.CENTER;
                        break;
                    } else {
                        zVar2 = g.z.values()[iNextInt2];
                        break;
                    }
                    break;
                case "s":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "t":
                    strNextString = jsonReader.nextString();
                    break;
                case "fc":
                    iZ = js.z(jsonReader);
                    break;
                case "lh":
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case "ls":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ps":
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case "sc":
                    iZ2 = js.z(jsonReader);
                    break;
                case "sw":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case "sz":
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case "tr":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.g(strNextString, strNextString2, fNextDouble, zVar2, iNextInt, fNextDouble2, fNextDouble3, iZ, iZ2, fNextDouble4, zNextBoolean, pointF, pointF2);
    }
}
