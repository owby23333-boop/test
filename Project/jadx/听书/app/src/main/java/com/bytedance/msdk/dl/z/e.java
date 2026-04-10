package com.bytedance.msdk.dl.z;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.e.uy;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.ls.dl.g.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.o;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    private com.bytedance.sdk.openadsdk.js.z.g.z.z kb;
    private com.bytedance.msdk.dl.dl.g.z.dl wp;

    public e(com.bytedance.msdk.dl.m.g.z zVar, com.bytedance.msdk.dl.dl.g.z.dl dlVar) {
        super(zVar);
        this.wp = dlVar;
    }

    @Override // com.bytedance.msdk.dl.z.a
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8130) {
            if (hy() == 5) {
                if (j() == 5) {
                    if (this.m != null) {
                        this.m.z(null);
                    }
                } else if (this.z != null) {
                    this.z.z(null);
                }
            } else if (hy() == 9 && this.m != null) {
                this.m.z(null);
            }
        } else if (i == 8113) {
            if (hy() == 5) {
                if (j() == 5) {
                    if (this.m != null) {
                        this.m.z();
                    }
                } else if (this.z != null) {
                    this.z.z();
                }
            } else if (hy() == 9 && this.m != null) {
                this.m.z();
            }
        } else if (i == 8131) {
            if (this.wp != null) {
                this.wp.z(this, pluginValueSet.stringValue(8036));
            }
        } else if (i == 8132) {
            if (this.uy != null) {
                com.bytedance.msdk.core.g.z.z(this.uy.g());
            }
            if (this.kb != null) {
                this.kb.z(pluginValueSet.intValue(8038), pluginValueSet.stringValue(8039), false);
            }
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            if (hy() == 5) {
                if (j() == 5) {
                    if (this.m instanceof com.bytedance.msdk.api.a.z.dl.a) {
                        ((com.bytedance.msdk.api.a.z.dl.a) this.m).z(fFloatValue, fFloatValue2);
                    }
                } else if (this.z instanceof com.bytedance.msdk.api.a.z.e.m) {
                    ((com.bytedance.msdk.api.a.z.e.m) this.z).z(fFloatValue, fFloatValue2);
                }
            } else if (hy() == 9 && (this.m instanceof com.bytedance.msdk.api.a.z.dl.a)) {
                ((com.bytedance.msdk.api.a.z.dl.a) this.m).z(fFloatValue, fFloatValue2);
            }
        } else if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (hy() == 5) {
                if (j() == 5) {
                    if (this.m instanceof com.bytedance.msdk.api.a.z.dl.a) {
                        ((com.bytedance.msdk.api.a.z.dl.a) this.m).z(view, strStringValue, iIntValue);
                    }
                } else if (this.z instanceof com.bytedance.msdk.api.a.z.e.m) {
                    ((com.bytedance.msdk.api.a.z.e.m) this.z).z(view, strStringValue, iIntValue);
                }
            } else if (hy() == 9 && (this.m instanceof com.bytedance.msdk.api.a.z.dl.a)) {
                ((com.bytedance.msdk.api.a.z.dl.a) this.m).z(view, strStringValue, iIntValue);
            }
        } else if (i == 8140) {
            String strStringValue2 = pluginValueSet.stringValue(8045);
            String strStringValue3 = pluginValueSet.stringValue(8046);
            int iIntValue2 = pluginValueSet.intValue(8047);
            String strStringValue4 = pluginValueSet.stringValue(8048);
            String strStringValue5 = pluginValueSet.stringValue(8049);
            String strStringValue6 = pluginValueSet.stringValue(8050);
            int iIntValue3 = pluginValueSet.intValue(8051);
            int iIntValue4 = pluginValueSet.intValue(8052);
            List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
            String strStringValue7 = pluginValueSet.stringValue(8054);
            boolean zBooleanValue = pluginValueSet.booleanValue(8055);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            String strStringValue9 = pluginValueSet.stringValue(8057);
            Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
            String strStringValue10 = pluginValueSet.stringValue(8058);
            double dDoubleValue = pluginValueSet.doubleValue(8016);
            boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
            int iIntValue5 = pluginValueSet.intValue(8060);
            String strStringValue11 = pluginValueSet.stringValue(8061);
            String strStringValue12 = pluginValueSet.stringValue(8061);
            long jLongValue = pluginValueSet.longValue(8078);
            String strStringValue13 = pluginValueSet.stringValue(8079);
            Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
            String strStringValue14 = pluginValueSet.stringValue(8080);
            String strStringValue15 = pluginValueSet.stringValue(8081);
            double dDoubleValue2 = pluginValueSet.doubleValue(8082);
            int iIntValue6 = pluginValueSet.intValue(8059);
            String strStringValue16 = pluginValueSet.stringValue(8551);
            String strStringValue17 = pluginValueSet.stringValue(8559);
            int iIntValue7 = pluginValueSet.intValue(8553);
            x(strStringValue2);
            lq(strStringValue3);
            tb(iIntValue2);
            hh(strStringValue4);
            mc(strStringValue5);
            l(strStringValue6);
            js(iIntValue3);
            fv(iIntValue4);
            z(list);
            gk(strStringValue7);
            gz(zBooleanValue);
            iq(strStringValue8);
            zw(strStringValue9);
            if (TextUtils.equals(zx(), "baidu")) {
                z(MediationConstant.BAIDU_DISLIKE_INFO, objObjectValue);
            }
            v(strStringValue10);
            z(dDoubleValue);
            e(zBooleanValue2);
            kb(iIntValue5);
            h(strStringValue11);
            q(strStringValue12);
            g(jLongValue);
            io(strStringValue13);
            gc(map);
            uf(strStringValue14);
            sy(strStringValue15);
            a(dDoubleValue2);
            wp(iIntValue6);
            wp(strStringValue16);
            uy(strStringValue17);
            g(iIntValue7);
        } else {
            if (i == 8143) {
                return (T) Double.valueOf(u());
            }
            if (i == 8145) {
                if (this.g != null) {
                    this.g.g();
                }
            } else if (i == 8146) {
                if (this.g != null) {
                    this.g.dl();
                }
            } else if (i == 8118) {
                if (this.g != null) {
                    this.g.gc();
                }
            } else if (i == 8117) {
                int iIntValue8 = pluginValueSet.intValue(8014);
                String strStringValue18 = pluginValueSet.stringValue(8015);
                if (this.g != null) {
                    this.g.z(new com.bytedance.msdk.api.z(iIntValue8, strStringValue18));
                }
            } else if (i == 8150) {
                if (this.g != null) {
                    this.g.a();
                }
            } else if (i == 1025) {
                if (this.g != null) {
                    this.g.z(pluginValueSet.longValue(8072), pluginValueSet.longValue(8073));
                }
            } else if (i == 8152) {
                if (this.dl != null) {
                    this.dl.z();
                }
            } else if (i == 8153) {
                if (this.dl != null) {
                    this.dl.g();
                }
            } else if (i == 8187) {
                if (this.dl != null) {
                    this.dl.z(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.intValue(8064), pluginValueSet.intValue(8065), "", "");
                }
            } else if (i == 8155) {
                if (this.dl != null) {
                    this.dl.z(pluginValueSet.longValue(8062), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8156) {
                if (this.dl != null) {
                    this.dl.z(pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8157) {
                if (this.dl != null) {
                    this.dl.g(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8158) {
                if (this.dl != null) {
                    this.dl.z(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else {
                if (i == 8160) {
                    return (T) Boolean.valueOf(ti());
                }
                if (i == 6069) {
                    return (T) Integer.valueOf(nh());
                }
                if (i == 8185) {
                    com.bytedance.sdk.openadsdk.js.z.g.z.z zVar = this.kb;
                    if (zVar != null) {
                        zVar.z();
                    }
                } else if (i == 8184) {
                    com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = this.kb;
                    if (zVar2 != null) {
                        zVar2.g();
                    }
                } else {
                    if (i == 8196) {
                        return (T) Boolean.valueOf(tc());
                    }
                    if (i == 8197) {
                        if (this.f461a != null) {
                            this.f461a.z();
                        }
                    } else if (i == 8227) {
                        if (pluginValueSet != null) {
                            a((Map<String, Object>) pluginValueSet.objectValue(8075, Map.class));
                        }
                    } else if (i == 6107 && this.gc != null) {
                        this.gc.z(pluginValueSet.intValue(20055));
                    }
                }
            }
        }
        return (T) com.bytedance.msdk.core.ls.z.z(cls);
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        this.kb = zVar;
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6085).z(Void.class).z(20033, activity).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void kb() {
        super.kb();
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6083).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public View fo() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6081).z(View.class).g());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.fo();
    }

    @Override // com.bytedance.msdk.g.dl
    public View uy() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6164).z(View.class).g());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.uy();
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean tb() {
        try {
            if (this.fo != null) {
                Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8135).z(Boolean.class).g());
                if (objApply instanceof Boolean) {
                    return ((Boolean) objApply).booleanValue();
                }
                return false;
            }
        } catch (Exception unused) {
        }
        return super.tb();
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        return com.bytedance.msdk.core.z.z.gc.z(lw(), this.fo);
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, uy uyVar, List<View> list4) {
        super.z(activity, viewGroup, list, list2, list3, uyVar, list4);
        g(activity, viewGroup, list, list2, list3, uyVar, list4);
    }

    private void g(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, uy uyVar, List<View> list4) {
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8159).z(Void.class).z(20033, activity).z(8067, viewGroup).z(8068, list).z(8069, list2).z(8070, list3).z(8071, uy.z(uyVar)).z(8053, list4).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public String mn() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8147).z(String.class).g());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.mn();
    }

    @Override // com.bytedance.msdk.g.dl
    public int jz() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8161).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.jz();
    }

    @Override // com.bytedance.msdk.g.dl
    public int oz() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8162).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.jz();
    }

    @Override // com.bytedance.msdk.g.dl
    public String e() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8163).z(String.class).g());
            return objApply instanceof String ? objApply.toString() : "";
        }
        return super.e();
    }

    @Override // com.bytedance.msdk.g.dl
    public wp c() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8269).z(Map.class).g());
            if (objApply instanceof Map) {
                Map map = (Map) objApply;
                Object obj = map.get("imgUrl");
                final Object obj2 = map.get(MediaFormat.KEY_WIDTH);
                final Object obj3 = map.get(MediaFormat.KEY_HEIGHT);
                final Object obj4 = map.get("valid");
                final Object obj5 = map.get("duration");
                if (obj instanceof String) {
                    final String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        return new wp() { // from class: com.bytedance.msdk.dl.z.e.1
                            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
                            public int z() {
                                Object obj6 = obj3;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
                            public int g() {
                                Object obj6 = obj2;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
                            public String dl() {
                                return str;
                            }

                            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
                            public double a() {
                                Object obj6 = obj5;
                                if (obj6 instanceof Double) {
                                    return ((Double) obj6).doubleValue();
                                }
                                return 0.0d;
                            }

                            @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
                            public boolean gc() {
                                Object obj6 = obj4;
                                return (obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue();
                            }
                        };
                    }
                }
            }
        }
        return super.c();
    }

    @Override // com.bytedance.msdk.g.dl
    public Bitmap mj() {
        if (TextUtils.equals(lw(), MediationConstant.ADN_GDT) && com.bytedance.msdk.core.z.z.gc.z(MediationConstant.ADN_GDT)) {
            return tb.a(com.bytedance.msdk.core.g.getContext(), "tt_adapter_gdt_logo");
        }
        if (TextUtils.equals(lw(), MediationConstant.ADN_KS) && com.bytedance.msdk.core.z.z.gc.z(MediationConstant.ADN_KS)) {
            return tb.a(com.bytedance.msdk.core.g.getContext(), "tt_adapter_ks_logo");
        }
        if (TextUtils.equals(lw(), "baidu") && com.bytedance.msdk.core.z.z.gc.z("baidu")) {
            return tb.a(com.bytedance.msdk.core.g.getContext(), "tt_adapter_baidu_logo");
        }
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8267).z(Bitmap.class).g());
            if (objApply instanceof Bitmap) {
                return (Bitmap) objApply;
            }
            return null;
        }
        return super.mj();
    }

    @Override // com.bytedance.msdk.g.dl
    public double no() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8268).z(Double.class).g());
            if (objApply instanceof Double) {
                return ((Double) objApply).doubleValue();
            }
            return 0.0d;
        }
        return super.no();
    }

    @Override // com.bytedance.msdk.g.dl
    public com.bytedance.msdk.api.a.z.e.gc gz() {
        if (this.fo == null) {
            return null;
        }
        Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8320).z(Function.class).g());
        if (objApply instanceof Function) {
            return com.bytedance.msdk.core.z.z.z((Function) objApply);
        }
        return null;
    }

    @Override // com.bytedance.msdk.g.dl
    public void z() {
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8191).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void g() {
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8192).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void dl() {
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6093).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public int a() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(o.a.q).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.a();
    }
}
