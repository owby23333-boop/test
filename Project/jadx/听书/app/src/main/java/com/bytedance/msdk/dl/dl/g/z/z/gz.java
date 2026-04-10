package com.bytedance.msdk.dl.dl.g.z.z;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.g.g.z;
import com.bytedance.msdk.dl.z.z.uy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends g {
    private com.bytedance.msdk.dl.z.z.dl fo;

    public gz(String str, com.bytedance.msdk.dl.z.g gVar) {
        super(str, gVar);
    }

    public void z(double d, Map<String, Object> map) {
        if (!g()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter callLoadSuccess");
            uy uyVar = new uy(this, this.dl);
            this.fo = uyVar;
            z(uyVar, d, map);
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void dl() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gz.1
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    gz.this.dl(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gz.1.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.fo.g gVar = (com.bytedance.msdk.api.a.z.fo.g) gz.this.fo.li();
                            if (gVar != null) {
                                gVar.a();
                            }
                        }
                    });
                }
            });
        }
    }

    public void a() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gz.2
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    gz.this.g(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gz.2.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.fo.g gVar = (com.bytedance.msdk.api.a.z.fo.g) gz.this.fo.li();
                            if (gVar != null) {
                                gVar.gc();
                            }
                        }
                    });
                }
            });
        }
    }

    public void gc() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gz.3
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.fo.g gVar = (com.bytedance.msdk.api.a.z.fo.g) gz.this.fo.li();
                    if (gVar != null) {
                        gVar.z(1);
                    }
                }
            });
        }
    }

    public void v() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.gz.4
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.fo.g gVar = (com.bytedance.msdk.api.a.z.fo.g) gz.this.fo.li();
                    if (gVar != null) {
                        gVar.g(2);
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
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom splash loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            z(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom splash loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            z(dDoubleValue, map);
        } else if (i == 1009) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom splash loader : callSplashAdClicked");
            dl();
        } else if (i == 1008) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom splash loader : callSplashAdShow");
            a();
        } else if (i == 1019) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom splash loader : callSplashAdSkip");
            gc();
        } else if (i == 1011) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom splash loader : callSplashAdDismiss");
            v();
        }
        return null;
    }
}
