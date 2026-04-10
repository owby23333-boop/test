package com.bytedance.msdk.dl.z.z;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class gc extends gz {
    public gc(com.bytedance.msdk.dl.dl.g.z.z.g gVar, Function<SparseArray<Object>, Object> function) {
        super(gVar, function);
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8127).z(Void.class).z(8034, this).g());
            ey();
        }
    }

    private void ey() {
        PluginValueSet pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(this.uy);
        if (pluginValueSetG != null) {
            Map<String, Object> map = (Map) pluginValueSetG.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class);
            String strStringValue = pluginValueSetG.stringValue(8045);
            String strStringValue2 = pluginValueSetG.stringValue(8046);
            String strStringValue3 = pluginValueSetG.stringValue(8048);
            String strStringValue4 = pluginValueSetG.stringValue(8049);
            String strStringValue5 = pluginValueSetG.stringValue(8050);
            int iIntValue = pluginValueSetG.intValue(8051);
            int iIntValue2 = pluginValueSetG.intValue(8052);
            List<String> list = (List) pluginValueSetG.objectValue(8053, List.class);
            String strStringValue6 = pluginValueSetG.stringValue(8054);
            double dDoubleValue = pluginValueSetG.doubleValue(8016);
            boolean zBooleanValue = pluginValueSetG.booleanValue(8033);
            int iIntValue3 = pluginValueSetG.intValue(8060);
            String strStringValue7 = pluginValueSetG.stringValue(8061);
            double dDoubleValue2 = pluginValueSetG.doubleValue(8082);
            int iIntValue4 = pluginValueSetG.intValue(8420);
            int iIntValue5 = pluginValueSetG.intValue(8421);
            int iIntValue6 = pluginValueSetG.intValue(8059);
            Function function = (Function) pluginValueSetG.objectValue(8315, Function.class);
            if (dDoubleValue > 0.0d) {
                z(dDoubleValue);
            }
            dl(map);
            x(strStringValue);
            lq(strStringValue2);
            hh(strStringValue3);
            l(strStringValue5);
            fv(iIntValue2);
            js(iIntValue);
            h(strStringValue7);
            gk(strStringValue6);
            q(iIntValue4);
            iq(iIntValue5);
            a(dDoubleValue2);
            z(list);
            mc(strStringValue4);
            e(zBooleanValue);
            kb(iIntValue3);
            wp(iIntValue6);
            if (function != null) {
                com.bytedance.msdk.z.a.z.z.z zVar = new com.bytedance.msdk.z.a.z.z.z(function);
                iq(zVar.dl());
                zw(zVar.a());
                g(zVar.gc());
                io(zVar.m());
                uf(zVar.gz());
                sy(zVar.fo());
                gc(zVar.e());
            }
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
        if (this.uy == null) {
            return null;
        }
        Object objApply = this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6072).z(Function.class).z(20033, activity).g());
        if (!(objApply instanceof Function)) {
            return null;
        }
        final com.bytedance.sdk.openadsdk.mediation.g.g.m mVar = new com.bytedance.sdk.openadsdk.mediation.g.g.m((Function) objApply);
        return new com.bytedance.sdk.openadsdk.ls.dl.g.e() { // from class: com.bytedance.msdk.dl.z.z.gc.1
            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public boolean dl() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void g() {
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void z(String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void z() {
                mVar.z();
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
            public void z(com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
                mVar.z(new com.bytedance.msdk.z.a.z.z.g(zVar));
            }
        };
    }

    @Override // com.bytedance.msdk.dl.z.z.dl
    public void z(boolean z, double d, int i, Map<String, Object> map) {
        super.z(z, d, i, map);
        if (this.uy != null) {
            this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8225).z(Void.class).z(8406, Boolean.valueOf(z)).z(8407, Double.valueOf(d)).z(8408, Integer.valueOf(i)).z(8075, map).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public View fo() {
        if (this.uy != null) {
            Object objApply = this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6081).z(View.class).g());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.fo();
    }

    @Override // com.bytedance.msdk.g.dl
    public View uy() {
        if (this.uy != null) {
            Object objApply = this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6164).z(View.class).g());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.uy();
    }

    @Override // com.bytedance.msdk.dl.z.z.gz
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar) {
        if (this.uy != null) {
            this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8159).z(Void.class).z(20033, activity).z(8067, viewGroup).z(8068, list).z(8069, list2).z(8070, list3).z(8071, com.bytedance.msdk.api.a.z.e.uy.z(uyVar)).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public com.bytedance.msdk.api.a.z.e.gc gz() {
        if (this.uy != null) {
            Object objApply = this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8320).z(Function.class).g());
            if (objApply instanceof Function) {
                return com.bytedance.msdk.core.z.z.z((Function) objApply);
            }
        }
        return super.gz();
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean tb() {
        if (this.uy != null) {
            Object objApply = this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8135).z(Boolean.class).g());
            return (objApply instanceof Boolean) && ((Boolean) objApply).booleanValue();
        }
        return super.tb();
    }

    @Override // com.bytedance.msdk.dl.z.z.dl, com.bytedance.msdk.g.dl
    public void ls() {
        if (this.uy != null) {
            this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8149).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.dl.z.z.dl, com.bytedance.msdk.g.dl
    public void p() {
        if (this.uy != null) {
            this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8148).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.dl.z.z.dl, com.bytedance.msdk.g.dl
    public void fv() {
        if (this.uy != null) {
            this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8109).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.dl.z.z.dl, com.bytedance.msdk.g.dl
    public Integer m() {
        if (this.uy != null) {
            Integer numZ = com.bytedance.sdk.openadsdk.core.ti.z.z.z(this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8121).z(Object.class).z(20068, 1).g()));
            if (numZ != null) {
                return numZ;
            }
        }
        return 1;
    }

    @Override // com.bytedance.msdk.g.dl
    public String e() {
        if (this.uy != null) {
            Object objApply = this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8228).z(String.class).g());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.e();
    }

    public void z(View view, String str, int i) {
        if (wp() instanceof com.bytedance.msdk.api.a.z.e.m) {
            try {
                ((com.bytedance.msdk.api.a.z.e.m) wp()).z(view, str, i);
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }

    public void z(float f, float f2) {
        if (wp() instanceof com.bytedance.msdk.api.a.z.e.m) {
            try {
                ((com.bytedance.msdk.api.a.z.e.m) wp()).z(f, f2);
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }

    public void qz() {
        z(new z() { // from class: com.bytedance.msdk.dl.z.z.gc.2
            @Override // com.bytedance.msdk.dl.z.z.z
            public void z() {
                if (gc.this.wp() != null) {
                    gc.this.wp().z(null);
                }
            }
        });
    }

    public void aq() {
        g(new z() { // from class: com.bytedance.msdk.dl.z.z.gc.3
            @Override // com.bytedance.msdk.dl.z.z.z
            public void z() {
                if (gc.this.wp() != null) {
                    gc.this.wp().z();
                }
            }
        });
    }

    public void mk() {
        if (i() != null) {
            i().g();
        }
    }

    public void en() {
        if (i() != null) {
            i().dl();
        }
    }

    public void oc() {
        if (i() != null) {
            i().a();
        }
    }

    public void ou() {
        if (i() != null) {
            i().gc();
        }
    }

    public void z(com.bytedance.msdk.api.a.z.g.z zVar) {
        if (i() != null) {
            i().z(new com.bytedance.msdk.api.z(49012, com.bytedance.msdk.api.z.z(49012), zVar == null ? -1 : zVar.z(), zVar == null ? "" : zVar.g()));
        }
    }

    public void z(long j, long j2) {
        if (i() != null) {
            i().z(j, j2);
        }
    }

    public void bp() {
        if (v() != null) {
            v().z();
        }
    }

    public void z(long j, long j2, String str, String str2) {
        if (v() != null) {
            v().z(j, j2, -1, 1, str, str2);
        }
    }

    public void g(long j, long j2, String str, String str2) {
        if (v() != null) {
            v().z(j, j2, str, str2);
        }
    }

    public void dl(long j, long j2, String str, String str2) {
        if (v() != null) {
            v().g(j, j2, str, str2);
        }
    }

    public void z(long j, String str, String str2) {
        if (v() != null) {
            v().z(j, str, str2);
        }
    }

    public void z(String str, String str2) {
        if (v() != null) {
            v().z(str, str2);
        }
    }

    public void mt() {
        if (js() != null) {
            js().z();
        }
    }

    public void um() {
        if (js() != null) {
            js().g();
        }
    }

    public void z(int i, String str) {
        if (this.fo != null) {
            this.fo.z(this, str);
        }
        if (js() != null) {
            js().z(i, str, false);
        }
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeRenderFail code:" + iIntValue + " msg:" + strStringValue + " view" + view);
            z(view, strStringValue, iIntValue);
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeRenderSuccess width:" + fFloatValue + " height:" + fFloatValue2);
            z(fFloatValue, fFloatValue2);
        } else if (i == 8130) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeAdClick");
            qz();
        } else if (i == 8113) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeAdShow");
            aq();
        } else if (i == 8145) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeVideoStart");
            mk();
        } else if (i == 8146) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeVideoPause");
            en();
        } else if (i == 8150) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeVideoResume");
            oc();
        } else if (i == 8118) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeVideoCompleted");
            ou();
        } else if (i == 8117) {
            int iIntValue2 = pluginValueSet.intValue(8014);
            String strStringValue2 = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeVideoError code:" + iIntValue2 + " msg:" + strStringValue2);
            z(new com.bytedance.msdk.api.a.z.g.z(iIntValue2, strStringValue2));
        } else if (i == 8154) {
            long jLongValue = pluginValueSet.longValue(8072);
            long jLongValue2 = pluginValueSet.longValue(8073);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeVideoError current:" + jLongValue + " duration:" + jLongValue2);
            z(jLongValue, jLongValue2);
        } else if (i == 8152) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeOnIdle");
            bp();
        } else if (i == 8187) {
            long jLongValue3 = pluginValueSet.longValue(8062);
            long jLongValue4 = pluginValueSet.longValue(8063);
            pluginValueSet.intValue(8064);
            pluginValueSet.intValue(8065);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadActive totalBytes:" + jLongValue3 + " curlBytes:" + jLongValue4);
            z(jLongValue3, jLongValue4, "", "");
        } else if (i == 8158) {
            long jLongValue5 = pluginValueSet.longValue(8062);
            long jLongValue6 = pluginValueSet.longValue(8063);
            String strStringValue3 = pluginValueSet.stringValue(8066);
            String strStringValue4 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadPaused totalBytes:" + jLongValue5 + " curlBytes:" + jLongValue6 + " fileName:" + strStringValue3 + " appName:" + strStringValue4);
            g(jLongValue5, jLongValue6, strStringValue3, strStringValue4);
        } else if (i == 8157) {
            long jLongValue7 = pluginValueSet.longValue(8062);
            long jLongValue8 = pluginValueSet.longValue(8063);
            String strStringValue5 = pluginValueSet.stringValue(8066);
            String strStringValue6 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadFailed totalBytes:" + jLongValue7 + " curlBytes:" + jLongValue8 + " fileName:" + strStringValue5 + " appName:" + strStringValue6);
            dl(jLongValue7, jLongValue8, strStringValue5, strStringValue6);
        } else if (i == 8155) {
            long jLongValue9 = pluginValueSet.longValue(8062);
            String strStringValue7 = pluginValueSet.stringValue(8066);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadFinished totalBytes:" + jLongValue9 + " fileName:" + strStringValue7 + " appName:" + strStringValue8);
            z(jLongValue9, strStringValue7, strStringValue8);
        } else if (i == 8156) {
            String strStringValue9 = pluginValueSet.stringValue(8066);
            String strStringValue10 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadFinished  fileName:" + strStringValue9 + " appName:" + strStringValue10);
            z(strStringValue9, strStringValue10);
        } else if (i == 8185) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeDislikeShow");
            mt();
        } else if (i == 8184) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeDislikeCancel");
            um();
        } else if (i != 6085) {
            if (i == 8110) {
                boolean zK = k();
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : isClientBiddingAd :".concat(String.valueOf(zK)));
                return (T) Boolean.valueOf(zK);
            }
            if (i == 8136) {
                boolean zHn = hn();
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : isServerBiddingAd :".concat(String.valueOf(zHn)));
                return (T) Boolean.valueOf(zHn);
            }
            if (i == 8160) {
                boolean zTi = ti();
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : isUseCustomVideo :".concat(String.valueOf(zTi)));
                return (T) Boolean.valueOf(zTi);
            }
            if (i == 8226) {
                int iYt = yt();
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : getBiddingType :".concat(String.valueOf(iYt)));
                return (T) Integer.valueOf(iYt);
            }
            if (i == 8132) {
                int iIntValue3 = pluginValueSet.intValue(8038);
                String strStringValue11 = pluginValueSet.stringValue(8039);
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom feed ad : callNativeDislikeSelected postion:" + iIntValue3 + " value:" + strStringValue11);
                z(iIntValue3, strStringValue11);
            }
        }
        return (T) com.bytedance.msdk.core.ls.z.z(cls);
    }
}
