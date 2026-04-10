package com.bytedance.adsdk.lottie.ga;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.d.bf;
import com.google.common.base.Ascii;
import com.xiaomi.verificationsdk.internal.Constants;
import com.yuewen.gm;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zk implements j<com.bytedance.adsdk.lottie.d.bf> {
    public static final zk e = new zk();

    private zk() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.lottie.ga.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.d.bf bf(JsonReader jsonReader, float f) throws IOException {
        bf.e eVar = bf.e.CENTER;
        jsonReader.beginObject();
        bf.e eVar2 = eVar;
        String strNextString = null;
        String strNextString2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iE = 0;
        int iE2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b2 = -1;
            switch (strNextName.hashCode()) {
                case 102:
                    if (strNextName.equals(gm.a.f11595a)) {
                        b2 = 0;
                    }
                    break;
                case 106:
                    if (strNextName.equals("j")) {
                        b2 = 1;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b2 = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals(Constants.TIMESTAMP)) {
                        b2 = 3;
                    }
                    break;
                case 3261:
                    if (strNextName.equals("fc")) {
                        b2 = 4;
                    }
                    break;
                case 3452:
                    if (strNextName.equals("lh")) {
                        b2 = 5;
                    }
                    break;
                case 3463:
                    if (strNextName.equals("ls")) {
                        b2 = 6;
                    }
                    break;
                case 3543:
                    if (strNextName.equals("of")) {
                        b2 = 7;
                    }
                    break;
                case 3587:
                    if (strNextName.equals("ps")) {
                        b2 = 8;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b2 = 9;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b2 = 10;
                    }
                    break;
                case 3687:
                    if (strNextName.equals("sz")) {
                        b2 = Ascii.VT;
                    }
                    break;
                case 3710:
                    if (strNextName.equals("tr")) {
                        b2 = Ascii.FF;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 1:
                    int iNextInt2 = jsonReader.nextInt();
                    bf.e eVar3 = bf.e.CENTER;
                    eVar2 = (iNextInt2 <= eVar3.ordinal() && iNextInt2 >= 0) ? bf.e.values()[iNextInt2] : eVar3;
                    break;
                case 2:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    strNextString = jsonReader.nextString();
                    break;
                case 4:
                    iE = k.e(jsonReader);
                    break;
                case 5:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case 9:
                    iE2 = k.e(jsonReader);
                    break;
                case 10:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 11:
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case 12:
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.d.bf(strNextString, strNextString2, fNextDouble, eVar2, iNextInt, fNextDouble2, fNextDouble3, iE, iE2, fNextDouble4, zNextBoolean, pointF, pointF2);
    }
}
