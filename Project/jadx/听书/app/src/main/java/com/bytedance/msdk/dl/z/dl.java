package com.bytedance.msdk.dl.z;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.e.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends a {
    public dl(com.bytedance.msdk.dl.m.g.z zVar) {
        super(zVar);
    }

    private com.bytedance.msdk.api.a.z.z.z aq() {
        return (com.bytedance.msdk.api.a.z.z.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        return com.bytedance.msdk.core.z.z.gc.z(lw(), this.fo);
    }

    @Override // com.bytedance.msdk.g.dl
    public String mn() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8147).z(String.class).g());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        }
        return super.mn();
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
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, uy uyVar, List<View> list4) {
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8159).z(Void.class).z(20033, activity).z(8067, viewGroup).z(8068, list).z(8069, list2).z(8070, list3).z(8071, uy.z(uyVar)).g());
        }
    }

    @Override // com.bytedance.msdk.dl.z.a
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 1008) {
            if (!(this.e instanceof com.bytedance.msdk.api.a.z.z.z)) {
                return null;
            }
            aq().g(null);
            return null;
        }
        if (i != 1009) {
            if (i != 1014) {
                if (i == 1016) {
                    boolean z = this.e instanceof com.bytedance.msdk.api.a.z.z.z;
                } else if (i == 8111) {
                    z(pluginValueSet.doubleValue(8016));
                } else if (i == 8140) {
                    String strStringValue = pluginValueSet.stringValue(8045);
                    String strStringValue2 = pluginValueSet.stringValue(8046);
                    int iIntValue = pluginValueSet.intValue(8047);
                    String strStringValue3 = pluginValueSet.stringValue(8048);
                    String strStringValue4 = pluginValueSet.stringValue(8049);
                    String strStringValue5 = pluginValueSet.stringValue(8050);
                    int iIntValue2 = pluginValueSet.intValue(8051);
                    int iIntValue3 = pluginValueSet.intValue(8052);
                    List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
                    String strStringValue6 = pluginValueSet.stringValue(8054);
                    boolean zBooleanValue = pluginValueSet.booleanValue(8055);
                    String strStringValue7 = pluginValueSet.stringValue(8056);
                    String strStringValue8 = pluginValueSet.stringValue(8057);
                    Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
                    String strStringValue9 = pluginValueSet.stringValue(8058);
                    double dDoubleValue = pluginValueSet.doubleValue(8016);
                    boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
                    int iIntValue4 = pluginValueSet.intValue(8060);
                    String strStringValue10 = pluginValueSet.stringValue(8061);
                    String strStringValue11 = pluginValueSet.stringValue(8061);
                    long jLongValue = pluginValueSet.longValue(8078);
                    String strStringValue12 = pluginValueSet.stringValue(8079);
                    Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
                    String strStringValue13 = pluginValueSet.stringValue(8080);
                    String strStringValue14 = pluginValueSet.stringValue(8081);
                    double dDoubleValue2 = pluginValueSet.doubleValue(8082);
                    int iIntValue5 = pluginValueSet.intValue(8059);
                    String strStringValue15 = pluginValueSet.stringValue(8551);
                    String strStringValue16 = pluginValueSet.stringValue(8559);
                    x(strStringValue);
                    lq(strStringValue2);
                    tb(iIntValue);
                    hh(strStringValue3);
                    mc(strStringValue4);
                    l(strStringValue5);
                    js(iIntValue2);
                    fv(iIntValue3);
                    z(list);
                    gk(strStringValue6);
                    gz(zBooleanValue);
                    iq(strStringValue7);
                    zw(strStringValue8);
                    if (TextUtils.equals(zx(), "baidu")) {
                        z(MediationConstant.BAIDU_DISLIKE_INFO, objObjectValue);
                    }
                    v(strStringValue9);
                    z(dDoubleValue);
                    e(zBooleanValue2);
                    kb(iIntValue4);
                    wp(iIntValue5);
                    h(strStringValue10);
                    q(strStringValue11);
                    g(jLongValue);
                    io(strStringValue12);
                    gc(map);
                    uf(strStringValue13);
                    sy(strStringValue14);
                    a(dDoubleValue2);
                    wp(strStringValue15);
                    uy(strStringValue16);
                } else if (i == 8207) {
                    v(pluginValueSet.stringValue(8058));
                }
            } else if (this.e instanceof com.bytedance.msdk.api.a.z.z.z) {
                if (this.uy != null) {
                    com.bytedance.msdk.core.g.z.z(this.uy.g());
                }
                aq().f_();
            }
        } else if (this.e instanceof com.bytedance.msdk.api.a.z.z.z) {
            aq().z((View) null);
            return null;
        }
        return null;
    }
}
