package com.bytedance.msdk.dl.dl.g.z.z;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.g.g.z;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends g {
    private volatile com.bytedance.msdk.dl.z.z.dl fo;

    public gc(String str, com.bytedance.msdk.dl.z.g gVar) {
        super(str, gVar);
    }

    public void z(double d, Map<String, Object> map) {
        if (!g()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter callLoadSuccess");
            if (this.fo == null) {
                this.fo = new com.bytedance.msdk.dl.z.z.m(this, this.dl);
            }
            z(this.fo, d, map);
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void dl() {
        if (this.fo == null) {
            this.fo = new com.bytedance.msdk.dl.z.z.m(this, this.dl);
        }
        z(this.fo, (com.bytedance.msdk.api.z) null);
    }

    public void a() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.1
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    gc.this.g(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.1.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.a.z zVar = (com.bytedance.msdk.api.a.z.a.z) gc.this.fo.li();
                            if (zVar != null) {
                                zVar.g_();
                            }
                        }
                    });
                }
            });
        }
    }

    public void gc() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.2
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    gc.this.dl(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.2.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.a.z zVar = (com.bytedance.msdk.api.a.z.a.z) gc.this.fo.li();
                            if (zVar != null) {
                                zVar.h_();
                            }
                        }
                    });
                }
            });
        }
    }

    public void v() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.3
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.a.z zVar = (com.bytedance.msdk.api.a.z.a.z) gc.this.fo.li();
                    if (zVar != null) {
                        zVar.dl();
                    }
                }
            });
        }
    }

    public void pf() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.4
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.a.z zVar = (com.bytedance.msdk.api.a.z.a.z) gc.this.fo.li();
                    if (zVar != null) {
                        zVar.a();
                    }
                }
            });
        }
    }

    public void ls() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.5
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.a.z zVar = (com.bytedance.msdk.api.a.z.a.z) gc.this.fo.li();
                    if (zVar != null) {
                        zVar.gc();
                    }
                }
            });
        }
    }

    public void p() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.6
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.a.z zVar = (com.bytedance.msdk.api.a.z.a.z) gc.this.fo.li();
                    if (zVar != null) {
                        zVar.m();
                    }
                }
            });
        }
    }

    public void z(final com.bytedance.msdk.api.dl.z zVar) {
        if (zVar == null || this.fo == null) {
            return;
        }
        z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.7
            @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
            public void z() {
                com.bytedance.msdk.api.a.z.a.z zVar2 = (com.bytedance.msdk.api.a.z.a.z) gc.this.fo.li();
                if (zVar2 != null) {
                    zVar2.z(zVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.z.g
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            z(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            z(dDoubleValue, map);
        } else if (i == 8112) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callAdVideoCache");
            dl();
        } else if (i == 1008) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callFullVideoAdShow");
            a();
        } else if (i == 1009) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callFullVideoAdClick");
            gc();
        } else if (i == 1014) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callFullVideoAdClosed");
            v();
        } else if (i == 1026) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callFullVideoComplete");
            pf();
        } else if (i == 1021) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callFullVideoError");
            ls();
        } else if (i == 1037) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callFullVideoSkippedVideo");
            p();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
            final float fFloatValue = pluginValueSet.floatValue(8018);
            final String strStringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom full loader : callFullVideoRewardVerify rewardVerify:" + zBooleanValue + " amount:" + fFloatValue + " name:" + strStringValue2 + " map:" + map2);
            z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gc.8
                @Override // com.bytedance.msdk.api.dl.z
                public boolean z() {
                    return zBooleanValue;
                }

                @Override // com.bytedance.msdk.api.dl.z
                public float g() {
                    return fFloatValue;
                }

                @Override // com.bytedance.msdk.api.dl.z
                public String dl() {
                    return strStringValue2;
                }

                @Override // com.bytedance.msdk.api.dl.z
                public Map<String, Object> a() {
                    return map2;
                }
            });
        }
        return null;
    }
}
