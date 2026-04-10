package com.bytedance.sdk.gromore.init;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends com.bytedance.sdk.openadsdk.mediation.g.g.a {
    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(Activity activity, List<com.bytedance.sdk.openadsdk.mediation.g.g.gc> list, int i, int i2, Function<SparseArray<Object>, Object> function) {
        com.bytedance.msdk.api.z.g gVarZ;
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager preload activity = " + activity + " list = " + list + " parallelNum = " + i + " requestIntervalS = " + i2 + " classLoader = " + function);
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.sdk.openadsdk.mediation.g.g.gc gcVar : list) {
                if (gcVar != null && (gVarZ = com.bytedance.msdk.api.a.z.z.z(gcVar.z(), gcVar.g(), function)) != null) {
                    arrayList.add(new i(gVarZ, gcVar.dl()));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.api.a.uy.z(activity, arrayList, i, i2);
                return;
            } else {
                com.bytedance.msdk.z.gc.dl.a("TMe", "参数错误");
                return;
            }
        }
        com.bytedance.msdk.z.gc.dl.a("TMe", "参数错误");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(String str) {
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager setPulisherDid configUserInfoForSegment = ".concat(String.valueOf(str)));
        com.bytedance.msdk.api.a.uy.z(str);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(Context context) {
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager requestPermissionIfNecessary context = ".concat(String.valueOf(context)));
        com.bytedance.msdk.api.a.uy.z(context);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(Context context, int[] iArr) {
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager requestPermissionIfNecessary context = " + context + " permissions = " + iArr);
        com.bytedance.msdk.api.a.uy.z(context, iArr);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(int i) {
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager setThemeStatus themeStatus = ".concat(String.valueOf(i)));
        com.bytedance.msdk.api.a.uy.z(i);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public int z(final com.bytedance.sdk.openadsdk.mediation.g.g.z.a aVar) {
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager showOpenOrInstallAppDialog");
        return com.bytedance.msdk.api.a.uy.z(new com.bytedance.msdk.api.a.dl() { // from class: com.bytedance.sdk.gromore.init.gz.1
            @Override // com.bytedance.msdk.api.a.dl
            public void z(int i) {
                com.bytedance.sdk.openadsdk.mediation.g.g.z.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.z(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar) {
        com.bytedance.msdk.api.a.uy.z(g.z(dlVar));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar) {
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager updatePrivacyConfig customController = ".concat(String.valueOf(aVar)));
        com.bytedance.msdk.api.a.uy.z(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(Map<String, Object> map) {
        com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager updateLocalExtra map = ".concat(String.valueOf(map)) == null ? "null" : map.toString());
        com.bytedance.msdk.core.z.kb().g(map);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, final com.bytedance.sdk.openadsdk.mediation.g.g.z.dl dlVar, Function<SparseArray<Object>, Object> function) {
        if (context != null && zVar != null) {
            com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager loadNativeToken context = " + context + " adSlot = " + zVar + " pluginIMediationNativeAdTokenCallback = " + dlVar + " classLoader = " + function);
            com.bytedance.msdk.api.z.g gVarZ = com.bytedance.msdk.api.a.z.z.z(5, zVar, function);
            if (gVarZ != null) {
                final com.bytedance.msdk.dl.a.fo foVar = new com.bytedance.msdk.dl.a.fo(context);
                foVar.z(gVarZ, new com.bytedance.msdk.api.a.z.dl() { // from class: com.bytedance.sdk.gromore.init.gz.2
                    @Override // com.bytedance.msdk.api.a.z.dl
                    public void z(String str) {
                        com.bytedance.sdk.openadsdk.mediation.g.g.z.dl dlVar2 = dlVar;
                        if (dlVar2 != null) {
                            dlVar2.z(str, new com.bytedance.sdk.gromore.z.z.e.a.z(foVar));
                        }
                    }

                    @Override // com.bytedance.msdk.api.a.z.dl
                    public void z(com.bytedance.msdk.api.z zVar2) {
                        com.bytedance.sdk.openadsdk.mediation.g.g.z.dl dlVar2;
                        if (zVar2 == null || (dlVar2 = dlVar) == null) {
                            return;
                        }
                        dlVar2.z(zVar2.z, zVar2.g);
                    }
                });
                return;
            }
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TMe", "参数错误");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, final com.bytedance.sdk.openadsdk.mediation.g.g.z.z zVar2, Function<SparseArray<Object>, Object> function) {
        if (context != null && zVar != null) {
            com.bytedance.msdk.z.gc.dl.g("TMe", "mediationManager loadDrawToken context = " + context + " adSlot = " + zVar + " pluginIMediationDrawAdTokenCallback = " + zVar2 + " classLoader = " + function);
            com.bytedance.msdk.api.z.g gVarZ = com.bytedance.msdk.api.a.z.z.z(9, zVar, function);
            if (gVarZ != null) {
                final com.bytedance.msdk.dl.a.e eVar = new com.bytedance.msdk.dl.a.e(context);
                eVar.z(gVarZ, new com.bytedance.msdk.api.a.z.dl() { // from class: com.bytedance.sdk.gromore.init.gz.3
                    @Override // com.bytedance.msdk.api.a.z.dl
                    public void z(String str) {
                        com.bytedance.sdk.openadsdk.mediation.g.g.z.z zVar3 = zVar2;
                        if (zVar3 != null) {
                            zVar3.z(str, new com.bytedance.sdk.gromore.z.z.e.g.a(eVar));
                        }
                    }

                    @Override // com.bytedance.msdk.api.a.z.dl
                    public void z(com.bytedance.msdk.api.z zVar3) {
                        com.bytedance.sdk.openadsdk.mediation.g.g.z.z zVar4;
                        if (zVar3 == null || (zVar4 = zVar2) == null) {
                            return;
                        }
                        zVar4.z(zVar3.z, zVar3.g);
                    }
                });
                return;
            }
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TMe", "参数错误");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public Map<String, Object> z() {
        com.bytedance.msdk.z.gc.dl.g("TMe", "getMediationExtraInfo");
        return com.bytedance.msdk.api.a.uy.i();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.a
    public Object z(int i, PluginValueSet pluginValueSet) {
        String strDl;
        String strZ;
        if (i == 8259) {
            return z();
        }
        if (i == 1001) {
            return Boolean.valueOf(com.bytedance.msdk.api.a.uy.z());
        }
        if (i == 1002) {
            return Boolean.valueOf(com.bytedance.msdk.api.a.uy.z(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1002)));
        }
        if (i == 1003) {
            return Boolean.valueOf(com.bytedance.msdk.api.a.uy.g(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1003)));
        }
        if (i == 1004) {
            return com.bytedance.msdk.api.a.uy.gc();
        }
        if (i == 1005) {
            return com.bytedance.msdk.api.a.uy.kb();
        }
        if (i == 1006) {
            return com.bytedance.msdk.api.a.uy.uy();
        }
        if (i == 1007) {
            return com.bytedance.msdk.api.a.uy.g((Context) pluginValueSet.objectValue(1004, Context.class));
        }
        if (i == 1008) {
            com.bytedance.msdk.api.a.uy.g(2);
        } else if (i == 1009) {
            com.bytedance.msdk.api.a.uy.wp();
        } else {
            if (i == 1010) {
                return Boolean.valueOf(com.bytedance.msdk.api.a.uy.a(pluginValueSet.stringValue(1001)));
            }
            if (i == 1011) {
                String strStringValue = pluginValueSet.stringValue(1001);
                com.bytedance.msdk.api.a.z.g.m.z zVarGc = com.bytedance.msdk.api.a.uy.gc(strStringValue);
                com.bytedance.msdk.z.z.a aVarM = com.bytedance.msdk.api.a.uy.m(strStringValue);
                if (zVarGc != null) {
                    strDl = zVarGc.dl();
                    strZ = zVarGc.a();
                } else if (aVarM != null) {
                    String strG = aVarM.g();
                    strZ = aVarM.z();
                    strDl = strG;
                } else {
                    strDl = "";
                    strZ = "";
                }
                HashMap map = new HashMap(2);
                map.put("networdSdkVersion", strDl);
                map.put("adapterSdkVersion", strZ);
                return map;
            }
            if (i == 2001) {
                if (pluginValueSet == null) {
                    return null;
                }
                com.bytedance.sdk.gromore.g.z.z((Function<SparseArray<Object>, Object>) pluginValueSet.objectValue(2002, Function.class));
                return com.bytedance.sdk.gromore.g.z.z();
            }
            if (i == 1012) {
                return Boolean.valueOf(com.bytedance.msdk.core.z.kb().zw().dl());
            }
        }
        return null;
    }
}
