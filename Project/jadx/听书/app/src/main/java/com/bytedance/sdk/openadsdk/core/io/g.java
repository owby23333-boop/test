package com.bytedance.sdk.openadsdk.core.io;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.ugeno.e;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.io.g$g, reason: collision with other inner class name */
    public interface InterfaceC0179g {
        void z();

        void z(JSONObject jSONObject);
    }

    public interface z {
        void z(int i, String str);

        void z(JSONObject jSONObject);
    }

    public static void z(com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar, InterfaceC0179g interfaceC0179g) {
        if (zVar != null) {
            z(zVar.dl(), zVar.z(), zVar.g(), interfaceC0179g);
        } else if (interfaceC0179g != null) {
            interfaceC0179g.z();
        }
    }

    public static void z(String str, final String str2, final String str3, final InterfaceC0179g interfaceC0179g) {
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0179g != null) {
                interfaceC0179g.z();
            }
        } else {
            com.bytedance.sdk.component.fo.g.dl dlVarDl = gc.z().g().dl();
            dlVarDl.z(str);
            dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.io.g.1
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    if (gVar == null) {
                        return;
                    }
                    if (gVar.gz()) {
                        String strA = gVar.a();
                        e.z().z(str2, str3, strA);
                        if (interfaceC0179g != null) {
                            try {
                                interfaceC0179g.z(new JSONObject(strA));
                                return;
                            } catch (JSONException e) {
                                wp.z(e);
                                interfaceC0179g.z();
                                return;
                            }
                        }
                        return;
                    }
                    InterfaceC0179g interfaceC0179g2 = interfaceC0179g;
                    if (interfaceC0179g2 != null) {
                        interfaceC0179g2.z();
                    }
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    InterfaceC0179g interfaceC0179g2 = interfaceC0179g;
                    if (interfaceC0179g2 != null) {
                        interfaceC0179g2.z();
                    }
                }
            });
        }
    }

    public static void z(na naVar, JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.js.dl dlVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (dlVar == null) {
            return;
        }
        if (naVar != null) {
            try {
                if (!TextUtils.isEmpty(naVar.vk())) {
                    int iGz = eo.gz(naVar);
                    com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = naVar.lw();
                    if (gVarLw != null) {
                        gVar = gVarLw;
                    }
                    j jVar = new j();
                    jVar.f1172a = 2;
                    if (vm.m(naVar) != null) {
                        jVar.m = 2;
                    }
                    JSONObject jSONObjectRw = naVar.rw();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        Iterator<String> itKeys = jSONObjectRw.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject2.put(next, jSONObjectRw.opt(next));
                        }
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                    if (jSONObject != null) {
                        Iterator<String> itKeys2 = jSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            jSONObject2.put(next2, jSONObject.opt(next2));
                        }
                    }
                    jVar.wp = jSONObject2;
                    zw.z().z(gVar, jVar, iGz, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.io.g.2
                        @Override // com.bytedance.sdk.openadsdk.core.sy.g
                        public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                            dlVar.z(false, null, false);
                            gVar2.z(i);
                            com.bytedance.sdk.openadsdk.core.iq.g.z(gVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.sy.g
                        public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                            if (zVar.g() != null && !zVar.g().isEmpty()) {
                                dlVar.z(true, zVar.g(), false);
                                return;
                            }
                            dlVar.z(false, null, false);
                            gVar2.z(-3);
                            com.bytedance.sdk.openadsdk.core.iq.g.z(gVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e2) {
                wp.dl("PageNetUtils", "get ads error", e2);
                return;
            }
        }
        dlVar.z(false, null, false);
    }

    public static void z(String str, final z zVar) {
        com.bytedance.sdk.component.fo.g.dl dlVarDl = gc.z().g().dl();
        dlVarDl.z(str);
        dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.io.g.3
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (gVar != null && gVar.gz()) {
                    try {
                        JSONObject jSONObject = new JSONObject(gVar.a());
                        z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.z(jSONObject);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        wp.z(e);
                        return;
                    }
                }
                z zVar3 = zVar;
                if (zVar3 == null || gVar == null) {
                    return;
                }
                zVar3.z(gVar.z(), gVar.g());
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z(601, iOException.getMessage());
                }
            }
        });
    }
}
