package com.bytedance.msdk.dl.z;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.umeng.analytics.pro.o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends a {
    public gz(com.bytedance.msdk.dl.m.g.z zVar) {
        super(zVar);
    }

    private com.bytedance.msdk.api.a.z.gz.z aq() {
        return (com.bytedance.msdk.api.a.z.gz.z) this.e;
    }

    private com.bytedance.msdk.api.a.z.gz.z mk() {
        return (com.bytedance.msdk.api.a.z.gz.z) this.gz;
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

    @Override // com.bytedance.msdk.g.dl
    public boolean bb() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(o.a.B).z(Boolean.class).g());
            if (objApply instanceof Boolean) {
                return ((Boolean) objApply).booleanValue();
            }
            return super.bb();
        }
        return super.bb();
    }

    @Override // com.bytedance.msdk.dl.z.a
    public <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8115) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                aq().j_();
            }
        } else if (i == 8116) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                aq().dl();
            }
        } else if (i == 8117) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                aq().gc();
            }
        } else if (i == 8118) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                aq().a();
            }
        } else if (i == 8119) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                aq().m();
            }
        } else if (i == 8230) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                aq().i_();
            }
        } else if (i == 8231) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
                final float fIntValue = pluginValueSet.intValue(8018);
                final String strStringValue2 = pluginValueSet.stringValue(8019);
                Map map = (Map) pluginValueSet.objectValue(8020, Map.class);
                final HashMap map2 = new HashMap();
                if (map != null) {
                    map2.putAll(map);
                }
                com.bytedance.msdk.api.dl.z zVar = new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.z.gz.1
                    @Override // com.bytedance.msdk.api.dl.z
                    public boolean z() {
                        return zBooleanValue;
                    }

                    @Override // com.bytedance.msdk.api.dl.z
                    public float g() {
                        return fIntValue;
                    }

                    @Override // com.bytedance.msdk.api.dl.z
                    public String dl() {
                        return strStringValue2;
                    }

                    @Override // com.bytedance.msdk.api.dl.z
                    public Map<String, Object> a() {
                        return map2;
                    }
                };
                com.bytedance.sdk.gromore.z.z.gc.a.z(zVar, "GMRewardAd reward verify");
                aq().z(zVar);
            }
        } else if (i == 1017) {
            if (this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                int iIntValue = 0;
                if (pluginValueSet != null) {
                    iIntValue = pluginValueSet.intValue(8014, 0);
                    strStringValue = pluginValueSet.stringValue(8015);
                } else {
                    strStringValue = "";
                }
                aq().z(new com.bytedance.msdk.api.z(iIntValue, strStringValue));
            }
        } else if (i == 8232) {
            if (this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                mk().j_();
            }
        } else if (i == 8233) {
            if (this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                mk().dl();
            }
        } else if (i == 8234) {
            if (this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                mk().gc();
            }
        } else if (i == 8235) {
            if (this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                mk().a();
            }
        } else if (i == 8236) {
            if (this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                mk().m();
            }
        } else if (i == 8237) {
            if (this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                mk().i_();
            }
        } else if (i == 8238) {
            if (this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                final boolean zBooleanValue2 = pluginValueSet.booleanValue(8017);
                final float fIntValue2 = pluginValueSet.intValue(8018);
                final String strStringValue3 = pluginValueSet.stringValue(8019);
                Map map3 = (Map) pluginValueSet.objectValue(8020, Map.class);
                final HashMap map4 = new HashMap();
                if (map3 != null) {
                    map4.putAll(map3);
                }
                com.bytedance.msdk.api.dl.z zVar2 = new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.z.gz.2
                    @Override // com.bytedance.msdk.api.dl.z
                    public boolean z() {
                        return zBooleanValue2;
                    }

                    @Override // com.bytedance.msdk.api.dl.z
                    public float g() {
                        return fIntValue2;
                    }

                    @Override // com.bytedance.msdk.api.dl.z
                    public String dl() {
                        return strStringValue3;
                    }

                    @Override // com.bytedance.msdk.api.dl.z
                    public Map<String, Object> a() {
                        return map4;
                    }
                };
                com.bytedance.sdk.gromore.z.z.gc.a.z(zVar2, "GMRewardAd play again reward verify");
                mk().z(zVar2);
            }
        } else if (i == 8111) {
            z(pluginValueSet.doubleValue(8016));
        }
        return (T) com.bytedance.msdk.core.ls.z.z(cls);
    }
}
