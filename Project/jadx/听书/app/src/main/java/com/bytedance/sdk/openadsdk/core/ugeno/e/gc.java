package com.bytedance.sdk.openadsdk.core.ugeno.e;

import com.bytedance.sdk.openadsdk.core.io.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    public interface z {
        void z(JSONObject jSONObject);
    }

    public static void z(com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar, z zVar2) {
        if (zVar == null) {
            if (zVar2 != null) {
                zVar2.z(null);
            }
        } else {
            z(zVar.dl(), zVar.z(), zVar.g(), zVar2);
        }
    }

    public static void z(String str, String str2, String str3, final z zVar) {
        JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.ugeno.e.z().z(str2, str3);
        if (jSONObjectZ == null) {
            com.bytedance.sdk.openadsdk.core.io.g.z(str, str2, str3, new g.InterfaceC0179g() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.gc.1
                @Override // com.bytedance.sdk.openadsdk.core.io.g.InterfaceC0179g
                public void z(JSONObject jSONObject) {
                    z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z(jSONObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.io.g.InterfaceC0179g
                public void z() {
                    z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z(null);
                    }
                }
            });
        } else if (zVar != null) {
            zVar.z(jSONObjectZ);
        }
    }
}
