package com.bytedance.sdk.openadsdk.core.video.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.gc.z;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.sy.dl;
import com.bytedance.sdk.openadsdk.core.sy.gz;
import com.bytedance.sdk.openadsdk.core.sy.kb;
import com.bytedance.sdk.openadsdk.core.sy.v;
import com.bytedance.sdk.openadsdk.core.un;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.m.dl.i;
import com.bytedance.sdk.openadsdk.m.dl.uy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile com.bykv.vk.openvk.component.video.api.gc.z g;
    private static volatile com.bykv.vk.openvk.component.video.api.gc.z z;

    private static boolean dl(a aVar) {
        return true;
    }

    private static boolean g(int i) {
        return i == 8 || i == 7;
    }

    private static boolean z(int i) {
        return i == 3 || i == 4;
    }

    private static com.bykv.vk.openvk.component.video.api.gc.z g(a aVar) {
        if (aVar.fv() == 1) {
            if (g == null) {
                synchronized (g.class) {
                    if (g == null) {
                        g = new com.bytedance.sdk.component.wp.g.g.z();
                    }
                }
            }
            return g;
        }
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new com.bykv.vk.openvk.component.video.z.z.g.z();
                }
            }
        }
        return z;
    }

    private static void g(a aVar, z.InterfaceC0028z interfaceC0028z, na naVar) {
        if (interfaceC0028z != null) {
            interfaceC0028z.z(aVar, -100);
        }
        if (naVar != null) {
            if (g(eo.gz(naVar)) || z(eo.gz(naVar))) {
                z(aVar, naVar, 0L);
            }
        }
    }

    public static void z(final a aVar, final z.InterfaceC0028z interfaceC0028z) {
        if (aVar == null) {
            g(null, interfaceC0028z, null);
            return;
        }
        aVar.ls();
        aVar.m();
        aVar.m();
        aVar.i();
        final na naVarZ = z(aVar);
        if (aVar.m() <= 0 && !aVar.i()) {
            g(aVar, interfaceC0028z, naVarZ);
        } else if (e.z()) {
            e.z(new fo("csj_vPreload") { // from class: com.bytedance.sdk.openadsdk.core.video.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.dl(aVar, interfaceC0028z, naVarZ);
                }
            });
        } else {
            dl(aVar, interfaceC0028z, naVarZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(final a aVar, final z.InterfaceC0028z interfaceC0028z, final na naVar) {
        try {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            int iGz = naVar != null ? eo.gz(naVar) : 0;
            boolean z2 = kb.z();
            if (g(iGz) && z2) {
                if (zw.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null) {
                    z(aVar, interfaceC0028z, naVar, jCurrentTimeMillis, z2);
                    return;
                }
                dl dlVar = (dl) com.bytedance.sdk.openadsdk.ats.dl.z("pitaya");
                if (dlVar != null && dlVar.isPitayaInitSuccess()) {
                    final JSONObject jSONObjectZ = new v().z(aVar);
                    dlVar.runTask("video_cache", jSONObjectZ, new gz() { // from class: com.bytedance.sdk.openadsdk.core.video.a.g.2
                        @Override // com.bytedance.sdk.openadsdk.core.sy.gz
                        protected PluginValueSet z(int i, com.bytedance.sdk.openadsdk.core.sy.fo foVar) {
                            com.bytedance.sdk.openadsdk.core.q.v.z();
                            com.bytedance.sdk.openadsdk.core.q.v.z(foVar == null ? null : foVar.a(), jSONObjectZ);
                            return g.g(i, foVar, aVar, interfaceC0028z, jCurrentTimeMillis, naVar);
                        }
                    });
                    return;
                } else {
                    z(aVar, -1000, -8, "not init", (JSONObject) null, System.currentTimeMillis() - jCurrentTimeMillis);
                    a(aVar, interfaceC0028z, naVar);
                    return;
                }
            }
            z(aVar, interfaceC0028z, naVar, jCurrentTimeMillis, z2);
        } catch (Exception e) {
            wp.dl("pit predict error:" + e.getMessage());
        }
    }

    private static void z(a aVar, z.InterfaceC0028z interfaceC0028z, na naVar, long j, boolean z2) {
        z(aVar, -1000, z2 ? -6 : -9, "bridge is null", (JSONObject) null, System.currentTimeMillis() - j);
        a(aVar, interfaceC0028z, naVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PluginValueSet g(int i, com.bytedance.sdk.openadsdk.core.sy.fo foVar, a aVar, z.InterfaceC0028z interfaceC0028z, long j, na naVar) {
        int i2;
        int i3;
        String string;
        try {
        } catch (Exception e) {
            e.getMessage();
        }
        if (foVar == null) {
            z(aVar, -1000, -2, "resultModel is null", (JSONObject) null, System.currentTimeMillis() - j);
            a(aVar, interfaceC0028z, naVar);
            return null;
        }
        com.bytedance.sdk.openadsdk.ls.z zVarDl = foVar.dl();
        if (zVarDl == null) {
            z(aVar, -1000, -3, "result is null", (JSONObject) null, System.currentTimeMillis() - j);
            a(aVar, interfaceC0028z, naVar);
            return null;
        }
        PluginValueSet pluginValueSetA = zVarDl.a();
        if (pluginValueSetA == null) {
            z(aVar, -1000, -4, "value is null", (JSONObject) null, System.currentTimeMillis() - j);
            a(aVar, interfaceC0028z, naVar);
            return null;
        }
        JSONObject jSONObject = (JSONObject) pluginValueSetA.objectValue(2, JSONObject.class);
        pluginValueSetA.stringValue(5);
        JSONObject jSONObject2 = (JSONObject) pluginValueSetA.objectValue(3, JSONObject.class);
        JSONObject jSONObject3 = (JSONObject) pluginValueSetA.objectValue(4, JSONObject.class);
        if (!zVarDl.z() || jSONObject == null) {
            i2 = -1000;
            i3 = -5;
            string = null;
        } else {
            int iOptInt = jSONObject.optInt("pitaya_cache_size", -1);
            int iOptInt2 = jSONObject.optInt("pitaya_code", 200);
            string = "success";
            v.z(aVar, jSONObject, iOptInt, iOptInt2);
            i2 = iOptInt;
            i3 = iOptInt2;
        }
        if (!zVarDl.z() && jSONObject3 != null) {
            string = jSONObject3.toString();
        }
        z(aVar, i2, i3, string, jSONObject2, System.currentTimeMillis() - j);
        a(aVar, interfaceC0028z, naVar);
        return null;
    }

    private static void z(a aVar, int i, int i2, String str, JSONObject jSONObject, long j) {
        JSONObject jSONObjectZ = aVar.z();
        try {
            jSONObjectZ.put("pitaya_cache_size", i);
            jSONObjectZ.put("pitaya_code", i2);
            jSONObjectZ.put("pitaya_msg", str);
            jSONObjectZ.put("ext_plugin_code", un.g());
            jSONObjectZ.put("package", jSONObject);
            jSONObjectZ.put("run_task_mills", j);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static na z(a aVar) {
        if (aVar == null) {
            return null;
        }
        Object objGc = aVar.gc("material_meta");
        if (objGc instanceof na) {
            return (na) objGc;
        }
        return null;
    }

    private static void a(final a aVar, final z.InterfaceC0028z interfaceC0028z, final na naVar) {
        aVar.m(6000);
        aVar.e(6000);
        aVar.gz(6000);
        if (naVar != null) {
            if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
                return;
            }
            if (aVar.dl() == 400) {
                dl(aVar, naVar);
                return;
            }
            g(aVar, naVar);
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        z.InterfaceC0028z interfaceC0028z2 = new z.InterfaceC0028z() { // from class: com.bytedance.sdk.openadsdk.core.video.a.g.3
            @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
            public void z(a aVar2, int i) {
                z.InterfaceC0028z interfaceC0028z3 = interfaceC0028z;
                if (interfaceC0028z3 != null) {
                    interfaceC0028z3.z(aVar2, i);
                }
                if (naVar != null) {
                    g.z(aVar, naVar, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                wp.z("VideoPreloadUtils", "pit onVideoPreloadSuccess: ", aVar.p());
            }

            @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
            public void z(a aVar2, int i, String str) {
                z.InterfaceC0028z interfaceC0028z3 = interfaceC0028z;
                if (interfaceC0028z3 != null) {
                    interfaceC0028z3.z(aVar2, i, str);
                }
                if (naVar != null) {
                    g.g(aVar, naVar, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                }
                wp.z("VideoPreloadUtils", "pit onVideoPreloadFail: ", aVar.p());
            }

            @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
            public void g(a aVar2, int i) {
                z.InterfaceC0028z interfaceC0028z3 = interfaceC0028z;
                if (interfaceC0028z3 != null) {
                    interfaceC0028z3.z(aVar2, i);
                }
                na naVar2 = naVar;
                if (naVar2 != null) {
                    g.dl(aVar, naVar2);
                }
                wp.z("VideoPreloadUtils", "pit cancel: ", aVar.p());
            }
        };
        try {
            aVar.fv();
            g(aVar).z(zw.getContext(), aVar, interfaceC0028z2);
        } catch (Exception e) {
            if (interfaceC0028z != null) {
                wp.z("VideoPreloadUtils", "pit exception onVideoPreloadFail: ", aVar.p());
                interfaceC0028z.z(aVar, -1, e.getMessage());
            }
            if (naVar != null) {
                g(aVar, naVar, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, e.getMessage());
            }
            wp.z(e);
        }
    }

    private static void g(a aVar, na naVar) {
        if (dl(aVar)) {
            long jWp = aVar.i() ? aVar.wp() : aVar.m();
            String strG = eo.g(naVar);
            JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.m.g.a.z(aVar, null, -1, aVar.fv(), naVar, -1L);
            com.bytedance.sdk.openadsdk.m.dl.wp wpVar = new com.bytedance.sdk.openadsdk.m.dl.wp(aVar.ls(), jWp);
            wpVar.z(aVar);
            com.bytedance.sdk.openadsdk.m.g.a.z((com.bytedance.sdk.openadsdk.m.dl.g<com.bytedance.sdk.openadsdk.m.dl.wp>) new com.bytedance.sdk.openadsdk.m.dl.g(naVar, strG, jSONObjectZ, wpVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(a aVar, na naVar, long j, int i, String str) {
        if (dl(aVar)) {
            String strG = eo.g(naVar);
            JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.m.g.a.z(aVar, null, -1, aVar.fv(), naVar, -1L);
            com.bytedance.sdk.openadsdk.m.dl.kb kbVar = new com.bytedance.sdk.openadsdk.m.dl.kb();
            kbVar.z(aVar.ls());
            kbVar.z(aVar.m());
            kbVar.g(j);
            kbVar.z(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            kbVar.g(str);
            kbVar.dl("");
            kbVar.z(aVar);
            com.bytedance.sdk.openadsdk.m.g.a.dl((com.bytedance.sdk.openadsdk.m.dl.g<com.bytedance.sdk.openadsdk.m.dl.kb>) new com.bytedance.sdk.openadsdk.m.dl.g(naVar, strG, jSONObjectZ, kbVar));
        }
    }

    public static void z(a aVar, na naVar, long j) {
        if (dl(aVar)) {
            String strG = eo.g(naVar);
            JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.m.g.a.z(aVar, null, -1, aVar.fv(), naVar, -1L);
            i iVar = new i();
            iVar.z(aVar.ls());
            iVar.z(aVar.m());
            iVar.g(j);
            iVar.z(aVar);
            if (aVar.iq() == 1) {
                iVar.dl(1L);
            } else {
                iVar.dl(0L);
            }
            com.bytedance.sdk.openadsdk.m.g.a.g((com.bytedance.sdk.openadsdk.m.dl.g<i>) new com.bytedance.sdk.openadsdk.m.dl.g(naVar, strG, jSONObjectZ, iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(a aVar, na naVar) {
        if (dl(aVar)) {
            String strG = eo.g(naVar);
            JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.m.g.a.z(aVar, null, -1, aVar.fv(), naVar, -1L);
            uy uyVar = new uy(aVar.ls(), aVar.m());
            uyVar.z(aVar);
            com.bytedance.sdk.openadsdk.m.g.a.a((com.bytedance.sdk.openadsdk.m.dl.g<uy>) new com.bytedance.sdk.openadsdk.m.dl.g(naVar, strG, jSONObjectZ, uyVar));
        }
    }
}
