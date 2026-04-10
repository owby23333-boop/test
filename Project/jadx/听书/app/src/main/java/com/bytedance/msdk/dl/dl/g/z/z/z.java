package com.bytedance.msdk.dl.dl.g.z.z;

import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.g.g.z;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private com.bytedance.msdk.dl.z.z.dl fo;

    public z(String str, com.bytedance.msdk.dl.z.g gVar) {
        super(str, gVar);
    }

    public void z(double d, Map<String, Object> map) {
        if (!g()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter callLoadSuccess");
            com.bytedance.msdk.dl.z.z.g gVar = new com.bytedance.msdk.dl.z.z.g(this, this.dl);
            this.fo = gVar;
            gVar.dl(this.gc);
            this.fo.v(this.f444a.sy());
            if (d > 0.0d && fo() == 1) {
                this.fo.z(d);
            }
            if (map != null) {
                this.gc.putAll(map);
            }
            this.fo.a(this.gc);
            z(this.fo);
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void dl() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.z.1
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.z.z zVar = (com.bytedance.msdk.api.a.z.z.z) z.this.fo.li();
                    if (zVar != null) {
                        zVar.g(null);
                    }
                }
            });
        }
    }

    public void a() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.z.2
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    z.this.dl(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.z.2.1
                        @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                        public void z() {
                            com.bytedance.msdk.api.a.z.z.z zVar = (com.bytedance.msdk.api.a.z.z.z) z.this.fo.li();
                            if (zVar != null) {
                                zVar.z((View) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void gc() {
        if (this.fo != null) {
            z(new z.InterfaceC0068z() { // from class: com.bytedance.msdk.dl.dl.g.z.z.z.3
                @Override // com.bytedance.msdk.api.a.z.g.g.z.InterfaceC0068z
                public void z() {
                    com.bytedance.msdk.api.a.z.z.z zVar = (com.bytedance.msdk.api.a.z.z.z) z.this.fo.li();
                    if (zVar != null) {
                        zVar.f_();
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
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom banner loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            z(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom banner loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            z(dDoubleValue, map);
        } else if (i == 1008) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom banner loader : callBannerAdShow");
            dl();
        } else if (i == 1009) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom banner loader : callBannerAdClick");
            a();
        } else if (i == 1014) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom banner loader : callBannerAdClosed");
            gc();
        }
        return null;
    }
}
