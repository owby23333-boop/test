package com.bytedance.msdk.dl.z;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class m extends a {
    public m(com.bytedance.msdk.dl.m.g.z zVar) {
        super(zVar);
    }

    private com.bytedance.msdk.api.a.z.gc.z aq() {
        return (com.bytedance.msdk.api.a.z.gc.z) this.e;
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        return com.bytedance.msdk.core.z.z.gc.z(lw(), this.fo);
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(Activity activity, Object obj, String str) {
        super.z(activity, obj, str);
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8113).z(Void.class).z(20033, activity).g());
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

    @Override // com.bytedance.msdk.dl.z.a
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(u());
        }
        if (i == 8111) {
            if (pluginValueSet == null) {
                return null;
            }
            if (!qz() && !wx()) {
                return null;
            }
            z(pluginValueSet.doubleValue(8016));
            return null;
        }
        int iIntValue = 0;
        if (i == 8129) {
            if (pluginValueSet == null) {
                return null;
            }
            e(Boolean.valueOf(pluginValueSet.booleanValue(8033, false)).booleanValue());
            return null;
        }
        if (i == 1008) {
            if (aq() == null) {
                return null;
            }
            aq().z();
            return null;
        }
        if (i == 1017) {
            if (aq() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                iIntValue = pluginValueSet.intValue(8014, 0);
                strStringValue = pluginValueSet.stringValue(8015);
            } else {
                strStringValue = "";
            }
            aq().z(new com.bytedance.msdk.api.z(iIntValue, strStringValue));
            return null;
        }
        if (i == 1009) {
            if (aq() == null) {
                return null;
            }
            aq().g();
            return null;
        }
        if (i == 1014) {
            if (aq() == null) {
                return null;
            }
            aq().dl();
            return null;
        }
        if (i == 1015) {
            if (aq() == null) {
                return null;
            }
            aq().a();
            return null;
        }
        if (i != 1016 || aq() == null) {
            return null;
        }
        aq().gc();
        return null;
    }
}
