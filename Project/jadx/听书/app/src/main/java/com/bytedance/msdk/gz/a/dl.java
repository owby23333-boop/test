package com.bytedance.msdk.gz.a;

import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.utils.wp;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static Map<String, Object> z;

    public static void z(Map map) {
        z = map;
    }

    public static boolean z() {
        return com.bytedance.msdk.core.z.kb().tb();
    }

    public static class z implements fo {
        @Override // com.bytedance.sdk.component.g.z.fo
        public ls z(fo.z zVar) throws IOException {
            v vVarZ = zVar.z();
            String string = vVarZ.g().toString();
            if (string.contains("/api/ad/union/mediation/config") || string.contains("/api/ad/union/mediation/exchange")) {
                vVarZ = g(zVar);
            }
            return zVar.z(vVarZ);
        }

        private v g(fo.z zVar) {
            try {
                Field field = zVar.getClass().getDeclaredFields()[0];
                field.setAccessible(true);
                Object obj = field.get(zVar);
                Field declaredField = obj.getClass().getDeclaredField("request");
                declaredField.setAccessible(true);
                sy syVar = (sy) declaredField.get(obj);
                declaredField.set(obj, syVar.m().z(String.valueOf(zVar.z().g().e().g("b4oil169.fn.bytedance.net").z("http").g())).g("case-id", (String) dl.z.get("case_id")).z());
                return zVar.z();
            } catch (Throwable th) {
                wp.z(th);
                return zVar.z();
            }
        }
    }
}
