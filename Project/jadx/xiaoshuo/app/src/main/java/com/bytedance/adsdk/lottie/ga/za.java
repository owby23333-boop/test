package com.bytedance.adsdk.lottie.ga;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.d.bf.zk;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class za {
    public static com.bytedance.adsdk.lottie.d.bf.zk e(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        zk.e eVarE = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    eVarE = zk.e.e(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.d.bf.zk(strNextString, eVarE, zNextBoolean);
    }
}
