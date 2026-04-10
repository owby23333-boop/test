package com.bytedance.adsdk.g;

import com.bytedance.adsdk.ugeno.a.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.adsdk.ugeno.a.z {
    @Override // com.bytedance.adsdk.ugeno.a.z
    public z.InterfaceC0043z z(String str) {
        return z.z(str);
    }

    static class z implements z.InterfaceC0043z {
        private String g;
        private com.bytedance.adsdk.g.g.z z;

        private z(String str) {
            this.g = str;
            this.z = com.bytedance.adsdk.g.g.z.z(str);
        }

        public static z z(String str) {
            return new z(str);
        }

        @Override // com.bytedance.adsdk.ugeno.a.z.InterfaceC0043z
        public Object z(JSONObject jSONObject) {
            com.bytedance.adsdk.g.g.z zVar = this.z;
            if (zVar == null) {
                return this.g;
            }
            Object objZ = zVar.z(jSONObject);
            if (objZ instanceof String) {
                return objZ;
            }
            if (objZ instanceof com.bytedance.adsdk.g.g.z.z) {
                return String.valueOf(kb.z((com.bytedance.adsdk.g.g.z.z) objZ));
            }
            return String.valueOf(objZ);
        }
    }
}
