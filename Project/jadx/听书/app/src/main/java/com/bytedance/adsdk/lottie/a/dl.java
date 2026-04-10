package com.bytedance.adsdk.lottie.a;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static com.bytedance.adsdk.lottie.model.z.wp z(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.lottie.model.z.g gVar = null;
        com.bytedance.adsdk.lottie.model.z.gc gcVarZ = null;
        com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVarG = null;
        com.bytedance.adsdk.lottie.model.z.e eVarA = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ2 = null;
        com.bytedance.adsdk.lottie.model.z.a aVarG = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ3 = null;
        com.bytedance.adsdk.lottie.model.z.g gVarZ4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(t.f1872a)) {
                            gcVarZ = z.z(jsonReader, mVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    aVarG = a.g(jsonReader, mVar);
                    continue;
                    break;
                case "p":
                    iVarG = z.g(jsonReader, mVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    eVarA = a.a(jsonReader, mVar);
                    continue;
                    break;
                case "eo":
                    gVarZ4 = a.z(jsonReader, mVar, false);
                    continue;
                    break;
                case "rz":
                    mVar.z("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    gVarZ2 = a.z(jsonReader, mVar, false);
                    continue;
                    break;
                case "sk":
                    gVarZ = a.z(jsonReader, mVar, false);
                    continue;
                    break;
                case "so":
                    gVarZ3 = a.z(jsonReader, mVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.bytedance.adsdk.lottie.model.z.g gVarZ5 = a.z(jsonReader, mVar, false);
            if (gVarZ5.dl().isEmpty()) {
                gVarZ5.dl().add(new com.bytedance.adsdk.lottie.m.z(mVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(mVar.e())));
            } else if (((com.bytedance.adsdk.lottie.m.z) gVarZ5.dl().get(0)).z == 0) {
                gVarZ5.dl().set(0, new com.bytedance.adsdk.lottie.m.z(mVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(mVar.e())));
            }
            gVar = gVarZ5;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (z(gcVarZ)) {
            gcVarZ = null;
        }
        return new com.bytedance.adsdk.lottie.model.z.wp(gcVarZ, z(iVarG) ? null : iVarG, z(eVarA) ? null : eVarA, z(gVar) ? null : gVar, aVarG, gVarZ3, gVarZ4, g(gVarZ) ? null : gVarZ, dl(gVarZ2) ? null : gVarZ2);
    }

    private static boolean z(com.bytedance.adsdk.lottie.model.z.gc gcVar) {
        if (gcVar != null) {
            return gcVar.g() && gcVar.dl().get(0).z.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean z(com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVar) {
        if (iVar != null) {
            return !(iVar instanceof com.bytedance.adsdk.lottie.model.z.fo) && iVar.g() && iVar.dl().get(0).z.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean z(com.bytedance.adsdk.lottie.model.z.g gVar) {
        if (gVar != null) {
            return gVar.g() && ((Float) ((com.bytedance.adsdk.lottie.m.z) gVar.dl().get(0)).z).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean z(com.bytedance.adsdk.lottie.model.z.e eVar) {
        if (eVar != null) {
            return eVar.g() && ((com.bytedance.adsdk.lottie.m.a) ((com.bytedance.adsdk.lottie.m.z) eVar.dl().get(0)).z).g(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean g(com.bytedance.adsdk.lottie.model.z.g gVar) {
        if (gVar != null) {
            return gVar.g() && ((Float) ((com.bytedance.adsdk.lottie.m.z) gVar.dl().get(0)).z).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean dl(com.bytedance.adsdk.lottie.model.z.g gVar) {
        if (gVar != null) {
            return gVar.g() && ((Float) ((com.bytedance.adsdk.lottie.m.z) gVar.dl().get(0)).z).floatValue() == 0.0f;
        }
        return true;
    }
}
