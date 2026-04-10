package com.bytedance.adsdk.lottie.a;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class ti {
    static com.bytedance.adsdk.lottie.model.g.pf z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        com.bytedance.adsdk.lottie.model.z.a aVar = null;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.z.z zVarE = null;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    zVarE = a.e(jsonReader, mVar);
                    break;
                case "o":
                    aVar = a.g(jsonReader, mVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (aVar == null) {
            aVar = new com.bytedance.adsdk.lottie.model.z.a(Collections.singletonList(new com.bytedance.adsdk.lottie.m.z(100)));
        }
        return new com.bytedance.adsdk.lottie.model.g.pf(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, zVarE, aVar, zNextBoolean2);
    }
}
