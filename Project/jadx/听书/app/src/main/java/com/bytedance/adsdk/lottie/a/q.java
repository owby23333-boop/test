package com.bytedance.adsdk.lottie.a;

import android.util.JsonReader;
import android.util.JsonToken;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class q {
    static <T> List<com.bytedance.adsdk.lottie.m.z<T>> z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, float f, xl<T> xlVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            mVar.z("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(t.f1872a)) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(tb.z(jsonReader, mVar, f, xlVar, false, z));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(tb.z(jsonReader, mVar, f, xlVar, true, z));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(tb.z(jsonReader, mVar, f, xlVar, false, z));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        z(arrayList);
        return arrayList;
    }

    public static <T> void z(List<? extends com.bytedance.adsdk.lottie.m.z<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.lottie.m.z<T> zVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.lottie.m.z<T> zVar2 = list.get(i2);
            zVar.e = Float.valueOf(zVar2.m);
            if (zVar.g == null && zVar2.z != null) {
                zVar.g = zVar2.z;
                if (zVar instanceof com.bytedance.adsdk.lottie.z.g.fo) {
                    ((com.bytedance.adsdk.lottie.z.g.fo) zVar).z();
                }
            }
        }
        com.bytedance.adsdk.lottie.m.z<T> zVar3 = list.get(i);
        if ((zVar3.z == null || zVar3.g == null) && list.size() > 1) {
            list.remove(zVar3);
        }
    }
}
