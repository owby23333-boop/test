package com.bytedance.msdk.dl.dl.g.z.z;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.g.g.z;
import com.bytedance.msdk.dl.z.z.fo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g {
    private volatile com.bytedance.msdk.dl.z.z.dl fo;

    public e(String str, com.bytedance.msdk.dl.z.g gVar) {
        super(str, gVar);
    }

    public void z(double d, Map<String, Object> map) {
        if (!g()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter callLoadSuccess");
            if (this.fo == null) {
                this.fo = new fo(this, this.dl);
            }
            z(this.fo, d, map);
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void dl() {
        if (this.fo == null) {
            this.fo = new fo(this, this.dl);
        }
        z(this.fo, (com.bytedance.msdk.api.z) null);
    }

    public void a() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.1
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    e.this.g(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.1.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.gz.z zVar = (com.bytedance.msdk.api.a.z.gz.z) e.this.fo.li();
                            if (zVar != null) {
                                zVar.i_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void gc() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.2
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    e.this.dl(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.2.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.gz.z zVar = (com.bytedance.msdk.api.a.z.gz.z) e.this.fo.li();
                            if (zVar != null) {
                                zVar.j_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void v() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.3
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gz.z zVar = (com.bytedance.msdk.api.a.z.gz.z) e.this.fo.li();
                    if (zVar != null) {
                        zVar.dl();
                    }
                }
            });
        }
    }

    public final void pf() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.4
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gz.z zVar = (com.bytedance.msdk.api.a.z.gz.z) e.this.fo.li();
                    if (zVar != null) {
                        zVar.a();
                    }
                }
            });
        }
    }

    public final void ls() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.5
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gz.z zVar = (com.bytedance.msdk.api.a.z.gz.z) e.this.fo.li();
                    if (zVar != null) {
                        zVar.gc();
                    }
                }
            });
        }
    }

    public final void p() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.6
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gz.z zVar = (com.bytedance.msdk.api.a.z.gz.z) e.this.fo.li();
                    if (zVar != null) {
                        zVar.m();
                    }
                }
            });
        }
    }

    public final void z(final com.bytedance.msdk.api.dl.z zVar) {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.7
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gz.z zVar2 = (com.bytedance.msdk.api.a.z.gz.z) e.this.fo.li();
                    if (zVar2 != null) {
                        zVar2.z(zVar);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.z.g
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            z(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            z(dDoubleValue, map);
        } else if (i == 8112) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callAdVideoCache");
            dl();
        } else if (i == 1008) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callRewardedAdShow");
            a();
        } else if (i == 1009) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callRewardClick");
            gc();
        } else if (i == 1014) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callRewardedAdClosed");
            v();
        } else if (i == 1026) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callRewardVideoComplete");
            pf();
        } else if (i == 1021) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callRewardVideoError");
            ls();
        } else if (i == 1037) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callRewardSkippedVideo");
            p();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
            final float fFloatValue = pluginValueSet.floatValue(8018);
            final String strStringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom reward loader : callRewardVerify rewardVerify:" + zBooleanValue + " amount:" + fFloatValue + " name:" + strStringValue2 + " map:" + map2);
            z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.e.8
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
