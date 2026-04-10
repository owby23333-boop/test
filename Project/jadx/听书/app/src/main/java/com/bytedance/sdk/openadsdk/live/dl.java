package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.dl.a;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class dl implements Function<SparseArray<Object>, Object> {
    private static final dl z = new dl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile g f1440a;
    private Map<String, String> dl;
    private volatile Function<SparseArray<Object>, Object> g;

    private dl() {
    }

    public static dl z() {
        return z;
    }

    public static Function<SparseArray<Object>, Object> z(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new z(iLiveAdCustomConfig);
    }

    public void z(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.dl = map;
    }

    private Map<String, String> g(Map map) {
        Object obj = map.get("live_tob_init_extra");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new HashMap();
    }

    private void dl(Map map) {
        ILiveHostContextParam.Builder builderAddHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get(NativeUnifiedADAppInfoImpl.Keys.APP_NAME))).setChannel(String.valueOf(map.get("channel"))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.dl.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (dl.this.g == null) {
                    return null;
                }
                return dl.this.g.apply(com.bykv.z.z.z.z.dl.z().z(0, str).z(1, map2).z(-99999987, 0).g().sparseArray());
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.bytedance.sdk.openadsdk.live.z.z(a(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.z.g(this.g)).addHostInitExtra(g(map));
        Map<String, String> map2 = this.dl;
        if (map2 != null) {
            builderAddHostInitExtra.addHostInitExtra(map2);
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.dl.2
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                m.g("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.g.z();
                if (dl.this.f1440a != null) {
                    dl.this.f1440a.z(2, null, false);
                }
                dl.this.dl = null;
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                m.z("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                if (dl.this.f1440a != null) {
                    dl.this.f1440a.z(-3, str, false);
                }
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            builderAddHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean zBooleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        m.z("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.g.z(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), builderAddHostInitExtra, iLiveInitCallback, zBooleanValue)), " subProcess=", Boolean.valueOf(zBooleanValue));
    }

    public <T> T z(int i, Map<String, Object> map) {
        if (i == 0) {
            if (!com.bytedance.sdk.openadsdk.live.g.z(getContext(map.get(d.R)), z(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i == 7) {
            return (T) gc(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) m(map);
    }

    private Function<SparseArray<Object>, Object> a(Map map) {
        return pf.z(map.get("c_control"));
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Bundle z(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    private Object gc(Map<String, Object> map) {
        String str;
        try {
            str = (String) map.get("expand_method_name");
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get("expand_method_param");
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] instanceof Function) {
                        objArr[i] = new com.bytedance.sdk.openadsdk.live.z((Function) objArr[i]);
                    }
                }
                return liveRoomService.callExpandMethod(str, objArr);
            }
            return liveRoomService.callExpandMethod(str, new Object[0]);
        } catch (Throwable th2) {
            th = th2;
            z("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
            m.g("TTLiveSDkBridge", th);
            return null;
        }
    }

    private Boolean m(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get(d.R));
            Uri uri = Uri.parse(str);
            if (uri != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.g.z(context, uri));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            z("handleLiveScheme", th);
            m.g("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    public static void z(String str, Throwable th) {
        try {
            TTAdManager adManager = TTAdSdk.getAdManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", str);
            if (th != null) {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, Log.getStackTraceString(th));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", "exception");
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } catch (Exception e) {
            m.g("TTLiveSDkBridge", e);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        int iIntValue = valueSetG.intValue(-99999987);
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 2);
            return sparseArray2;
        }
        if (iIntValue == 5) {
            dl((Map) valueSetG.objectValue(0, Map.class));
            return null;
        }
        if (iIntValue == 9) {
            this.g = pf.z(valueSetG.objectValue(0, Object.class));
            if (this.f1440a != null) {
                if (this.f1440a.z != 2 && this.f1440a.z != -3) {
                    if (this.f1440a.z != 0) {
                        this.f1440a.z(this.f1440a.z, null, null, null, true);
                    }
                } else {
                    this.f1440a.z(this.f1440a.z, this.f1440a.g, true);
                }
            } else {
                this.f1440a = new g();
                Function<SparseArray<Object>, Object> functionZ = pf.z(a.z().apply(com.bykv.z.z.z.z.dl.z(2).z(0, 4).z(-99999987, 10).g().sparseArray()));
                ValueSet valueSetG2 = com.bykv.z.z.z.z.dl.z(2).z(-99999987, 106).z(0, this.f1440a).g();
                if (functionZ != null) {
                    functionZ.apply(valueSetG2.sparseArray());
                }
            }
            return null;
        }
        return z(iIntValue, (Map<String, Object>) valueSetG.objectValue(0, Map.class));
    }

    private static final class z implements Function<SparseArray<Object>, Object> {
        private ILiveAdCustomConfig z;

        z(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.z = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
            if (iIntValue == -99999986) {
                return com.bykv.z.z.z.z.dl.z().z(10000, 1).g().sparseArray();
            }
            if (iIntValue == 0) {
                return Integer.valueOf(this.z.openLR((String) sparseArray.get(0)));
            }
            if (iIntValue == 1) {
                return this.z.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
            }
            if (iIntValue == 2) {
                return this.z.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
            }
            if (iIntValue == 3) {
                return this.z.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
            }
            if (iIntValue == 4) {
                this.z.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                return null;
            }
            if (iIntValue != 5) {
                return null;
            }
            return this.z;
        }
    }

    private final class g implements TTPluginListener {
        String g;
        int z;

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        private g() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            z(i, classLoader, resources, bundle, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.z = i;
            if (dl.this.g != null) {
                dl.this.g.apply(com.bykv.z.z.z.z.dl.z().z(0, i).z(1, classLoader).z(2, resources).z(3, bundle).z(4, dl.this.z(z)).z(-99999987, 3).g().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(int i, String str, boolean z) {
            this.z = i;
            this.g = str;
            if (dl.this.g != null) {
                com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z().z(0, i);
                if (str != null) {
                    dlVarZ.z(1, str);
                }
                dlVarZ.z(2, dl.this.z(z)).z(-99999987, 2);
                dl.this.g.apply(dlVarZ.g().sparseArray());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map z(boolean z2) {
        HashMap map = new HashMap();
        map.put("onlyUpdateState", Boolean.valueOf(z2));
        return map;
    }
}
