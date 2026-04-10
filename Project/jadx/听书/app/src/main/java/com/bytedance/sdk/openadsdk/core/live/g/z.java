package com.bytedance.sdk.openadsdk.core.live.g;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.live.z.e;
import com.bytedance.sdk.openadsdk.core.un.l;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.funny.audio.core.utils.FileUtils;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    final e z;

    public z(e eVar) {
        this.z = eVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Object z(PluginValueSet pluginValueSet) {
        String strStringValue = pluginValueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        strStringValue.hashCode();
        switch (strStringValue) {
            case "sendGoldExchangeCoupon":
                dl(pluginValueSet);
                return null;
            case "getBiddingToken":
                return gc(pluginValueSet);
            case "onTaskFinish":
                a(pluginValueSet);
                return null;
            case "onLiveFakeInitFinish":
                g(pluginValueSet);
                return null;
            case "getPanglePluginVersion":
                return 7105;
            case "onAuthCallback":
                e(pluginValueSet);
                return null;
            case "getPangleApiVersion":
                return String.valueOf(gk.dl);
            case "reportPangleEvent":
                m(pluginValueSet);
                return null;
            default:
                return null;
        }
    }

    private void g(PluginValueSet pluginValueSet) {
        String message;
        int i = -3;
        try {
            String str = (String) ((Map) pluginValueSet.objectValue(1, Map.class)).get("success");
            message = null;
            if (str != null) {
                if (Boolean.parseBoolean(str)) {
                    i = 2;
                } else {
                    message = "fake init failed";
                }
            }
        } catch (Exception e) {
            wp.g("LiveServiceBridge", e);
            message = e.getMessage();
        }
        this.z.z(i, message, true);
    }

    private void dl(PluginValueSet pluginValueSet) {
        try {
            this.z.dl((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            wp.g("LiveServiceBridge", e);
        }
    }

    private void a(PluginValueSet pluginValueSet) {
        try {
            this.z.g((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            wp.g("LiveServiceBridge", e);
        }
    }

    private Object gc(PluginValueSet pluginValueSet) {
        try {
            Integer numGz = gz(pluginValueSet);
            if (numGz == null) {
                return null;
            }
            return zw.z().z(l.z(numGz.intValue()));
        } catch (Throwable th) {
            wp.g("TTLiveSDkBridge", "invokeGetBiddingToken failed:" + th.getMessage());
            return null;
        }
    }

    private void m(PluginValueSet pluginValueSet) {
        Map<String, String> map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.z.z(map);
    }

    private void e(PluginValueSet pluginValueSet) {
        try {
            boolean z = true;
            Map map = (Map) pluginValueSet.objectValue(1, Map.class);
            String str = (String) map.get("is_auth");
            e eVar = this.z;
            if (Integer.valueOf(str).intValue() == 0) {
                z = false;
            }
            eVar.z(z, (String) map.get("open_uid"));
        } catch (Exception e) {
            wp.g("LiveServiceBridge", e);
        }
    }

    private Integer gz(PluginValueSet pluginValueSet) {
        String strE = com.bytedance.sdk.openadsdk.core.live.g.z().e();
        if (strE == null) {
            return null;
        }
        if (strE.replaceAll(FileUtils.FILE_EXTENSION_SEPARATOR, "").startsWith("2112")) {
            Object[] objArrArrayValue = pluginValueSet.arrayValue(1, Object[].class);
            if (objArrArrayValue == null || objArrArrayValue.length == 0) {
                return null;
            }
            return (Integer) objArrArrayValue[0];
        }
        Map map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    public void z(boolean z, String str, String str2, Map<String, String> map) {
        final JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!jSONObject.has(entry.getKey())) {
                            jSONObject.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Exception e) {
                wp.z(e);
                return;
            }
        }
        new z.C0178z().z(str).g(str2).dl("umeng").gc(jSONObject.optString("value")).a(jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA)).z(new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.live.g.z.1
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString("ad_extra_data"))) {
                    jSONObject2.put("ad_extra_data", jSONObject.optString("ad_extra_data"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has("is_ad_event")) {
                    return;
                }
                jSONObject2.putOpt("is_ad_event", "1");
            }
        });
    }

    private boolean z(PluginValueSet pluginValueSet, int i) {
        try {
            Map map = (Map) pluginValueSet.objectValue(i, Map.class);
            if (map != null && map.containsKey("onlyUpdateState")) {
                if (Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")))) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        if (iIntValue == 0) {
            return z(pluginValueSetG);
        }
        if (iIntValue == 1) {
            z(pluginValueSetG.booleanValue(0), pluginValueSetG.stringValue(1), pluginValueSetG.stringValue(2), (Map) pluginValueSetG.objectValue(3, Map.class));
        } else if (iIntValue == 2) {
            this.z.z(pluginValueSetG.intValue(0), pluginValueSetG.stringValue(1), z(pluginValueSetG, 2));
        } else if (iIntValue == 3) {
            int iIntValue2 = pluginValueSetG.intValue(0);
            boolean z = z(pluginValueSetG, 4);
            if (1000 == iIntValue2) {
                this.z.z(5, (String) null, z);
                if (!z) {
                    this.z.z();
                }
            } else if (1001 == iIntValue2) {
                this.z.z(-2, pluginValueSetG.stringValue(1), z);
            }
        }
        return null;
    }
}
