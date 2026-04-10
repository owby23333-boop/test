package com.bytedance.msdk.dl.z;

import android.app.Activity;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends a {
    private com.bytedance.msdk.z.g.m kb;

    public fo(com.bytedance.msdk.dl.m.g.z zVar) {
        super(zVar);
    }

    private com.bytedance.msdk.z.g.gc aq() {
        return (com.bytedance.msdk.z.g.gc) this.e;
    }

    @Override // com.bytedance.msdk.g.dl
    public Integer m() {
        return com.bytedance.msdk.core.z.z.gc.z(lw(), this.fo);
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(ViewGroup viewGroup) {
        super.z(viewGroup);
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6152).z(Void.class).z(20060, viewGroup).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(ViewGroup viewGroup, Activity activity) {
        super.z(viewGroup, activity);
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6154).z(Void.class).z(20060, viewGroup).z(20033, activity).g());
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.msdk.dl.z.a
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(u());
        }
        int iIntValue = 0;
        if (i == 1009) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.z.g.m mVar = this.kb;
                if (!(mVar instanceof com.bytedance.msdk.api.a.z.fo.g)) {
                    return null;
                }
                ((com.bytedance.msdk.api.a.z.fo.g) mVar).a();
                return null;
            }
            if (aq() == null) {
                return null;
            }
            aq().a();
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
        if (i == 1011) {
            boolean zBooleanValue = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue) {
                com.bytedance.msdk.z.g.m mVar2 = this.kb;
                if (!(mVar2 instanceof com.bytedance.msdk.api.a.z.fo.g)) {
                    return null;
                }
                ((com.bytedance.msdk.api.a.z.fo.g) mVar2).g(2);
                return null;
            }
            if (aq() == null) {
                return null;
            }
            aq().g(2);
            return null;
        }
        if (i == 1008) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.z.g.m mVar3 = this.kb;
                if (!(mVar3 instanceof com.bytedance.msdk.api.a.z.fo.g)) {
                    return null;
                }
                ((com.bytedance.msdk.api.a.z.fo.g) mVar3).gc();
                return null;
            }
            if (aq() == null) {
                return null;
            }
            aq().gc();
            return null;
        }
        if (i == 1019) {
            boolean zBooleanValue2 = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue2) {
                com.bytedance.msdk.z.g.m mVar4 = this.kb;
                if (!(mVar4 instanceof com.bytedance.msdk.api.a.z.fo.g)) {
                    return null;
                }
                ((com.bytedance.msdk.api.a.z.fo.g) mVar4).z(1);
                return null;
            }
            if (aq() == null) {
                return null;
            }
            aq().z(1);
            return null;
        }
        if (i == 1074) {
            if (aq() != null) {
                return (T) aq().getActivity();
            }
            return null;
        }
        if (i == 1051) {
            aq();
            return null;
        }
        if (i == 1052) {
            aq();
            return null;
        }
        if (i == 6156) {
            if (aq() == null) {
                return null;
            }
            aq().dl();
            return null;
        }
        if (i != 8111) {
            return null;
        }
        z(pluginValueSet.doubleValue(8016));
        return null;
    }
}
