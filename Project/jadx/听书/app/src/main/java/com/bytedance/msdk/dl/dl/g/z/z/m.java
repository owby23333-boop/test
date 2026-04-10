package com.bytedance.msdk.dl.dl.g.z.z;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.g.g.z;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g {
    private com.bytedance.msdk.dl.z.z.dl fo;

    public m(String str, com.bytedance.msdk.dl.z.g gVar) {
        super(str, gVar);
    }

    public void z(double d, Map<String, Object> map) {
        if (!g()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter callLoadSuccess");
            com.bytedance.msdk.dl.z.z.e eVar = new com.bytedance.msdk.dl.z.z.e(this, this.dl);
            this.fo = eVar;
            z(eVar, d, map);
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void dl() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.m.1
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    m.this.g(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.m.1.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.gc.z zVar = (com.bytedance.msdk.api.a.z.gc.z) m.this.fo.li();
                            if (zVar != null) {
                                zVar.z();
                            }
                        }
                    });
                }
            });
        }
    }

    public void a() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.m.2
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    m.this.dl(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.m.2.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.gc.z zVar = (com.bytedance.msdk.api.a.z.gc.z) m.this.fo.li();
                            if (zVar != null) {
                                zVar.g();
                            }
                        }
                    });
                }
            });
        }
    }

    public void gc() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.m.3
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gc.z zVar = (com.bytedance.msdk.api.a.z.gc.z) m.this.fo.li();
                    if (zVar != null) {
                        zVar.dl();
                    }
                }
            });
        }
    }

    public void v() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.m.4
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gc.z zVar = (com.bytedance.msdk.api.a.z.gc.z) m.this.fo.li();
                    if (zVar != null) {
                        zVar.a();
                    }
                }
            });
        }
    }

    public void pf() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.m.5
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.gc.z zVar = (com.bytedance.msdk.api.a.z.gc.z) m.this.fo.li();
                    if (zVar != null) {
                        zVar.gc();
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
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom interstitial loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            z(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom interstitial loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            z(dDoubleValue, map);
        } else if (i == 1008) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom interstitial loader : callInterstitialShow");
            dl();
        } else if (i == 1009) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdClick");
            a();
        } else if (i == 1014) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom interstitial loader : callInterstitialClosed");
            gc();
        } else if (i == 1015) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdOpened");
            v();
        } else if (i == 1016) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdLeftApplication");
            pf();
        }
        return null;
    }
}
