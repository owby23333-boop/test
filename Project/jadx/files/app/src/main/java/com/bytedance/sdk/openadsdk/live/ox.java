package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveRoomService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.live.base.api.callback.Callback;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.b;
import com.bytedance.sdk.openadsdk.api.plugin.u;
import com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ox extends com.bytedance.sdk.openadsdk.downloadnew.mb implements Bridge, Serializable {
    private ITTLiveTokenInjectionAuth lz;
    private static final ox ox = new ox();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean hj = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicBoolean f14713h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final AtomicBoolean f14714u = new AtomicBoolean(false);
    public static mb mb = null;
    private ITTLiveConfig ko = null;
    private JSONObject ww = null;

    private ox() {
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        ITTLiveConfig iTTLiveConfig;
        Plugin plugin;
        com.bytedance.sdk.openadsdk.api.mb.b("TTLiveSDkBridge", "hasLiveSDKInited：" + f14714u.get() + ", hasLiveInstalled：" + hj.get());
        if (this.ko != null) {
            str = "GeneralAppId：" + this.ko.getGeneralAppId() + "，isValid：" + this.ko.isValid();
        } else {
            str = null;
        }
        com.bytedance.sdk.openadsdk.api.mb.b("TTLiveSDkBridge", str);
        if (f14714u.get() || !hj.get() || (iTTLiveConfig = this.ko) == null || !iTTLiveConfig.isValid() || (plugin = Zeus.getPlugin("com.byted.live.lite")) == null || f14713h.get()) {
            return;
        }
        f14713h.set(true);
        if (!com.bytedance.sdk.openadsdk.live.mb.b(plugin.getVersion())) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live sdk init crash more than consecutive 5 times , live plugin had uninstalled ! App cold start will request new live plugin ！");
            com.bytedance.sdk.openadsdk.live.mb.hj(plugin.getVersion());
            f14713h.set(false);
            return;
        }
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(this.ko.getAppName()).setChannel(this.ko.getChannel()).setIsDebug(this.ko.isDebug()).setECHostAppId(this.ko.getECHostAppId()).setPartner(this.ko.getPartner()).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.ox.2
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return "pangle";
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str2, Object... objArr) {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                byte b2 = -1;
                if (str2.hashCode() == -955478604 && str2.equals("getBiddingToken")) {
                    b2 = 0;
                }
                if (b2 != 0) {
                    return null;
                }
                return ox.this.mb(objArr);
            }
        }).setPartnerSecret(this.ko.getPartnerSecret()).setHostPermission(this.ko.getHostPermission()).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.mb(this.ko.getLiveHostAction()));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.lz;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.ox(iTTLiveTokenInjectionAuth));
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.ox.3
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public final void onLiveInitFinish() {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "onLiveInitFinish - live sdk init succeed！");
                com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "execute commerce initLiveCommerce method start");
                com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "execute commerce initLiveCommerce end , result: " + com.bytedance.sdk.openadsdk.live.mb.mb());
                ox.f14714u.set(true);
                ox.this.ww();
                if (ox.mb != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_SDK_INIT_STATUS, ox.f14714u.get());
                    ox.mb.onEvent(2, bundle);
                }
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        com.bytedance.sdk.openadsdk.live.mb.mb(plugin.getVersion());
        StringBuilder sb = new StringBuilder();
        sb.append("execute live sdk initLive method start, GeneralAppId:");
        ITTLiveConfig iTTLiveConfig2 = this.ko;
        sb.append(iTTLiveConfig2 != null ? iTTLiveConfig2.getGeneralAppId() : null);
        com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", sb.toString());
        Context context = TTAppContextHolder.getContext();
        ITTLiveConfig iTTLiveConfig3 = this.ko;
        com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: " + com.bytedance.sdk.openadsdk.live.mb.mb(context, iTTLiveConfig3 != null ? iTTLiveConfig3.getGeneralAppId() : null, hostActionParam, iLiveInitCallback));
        f14713h.set(false);
        com.bytedance.sdk.openadsdk.live.mb.ox((long) plugin.getVersion());
    }

    private void ko() {
        try {
            LivePluginHelper.getLiveRoomService().callExpandMethod("warmingUpBeforeEnter", new Object[0]);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.mb("TTLiveSDkBridge", th);
        }
    }

    private Boolean u() {
        try {
            Object objCallExpandMethod = LivePluginHelper.getLiveRoomService().callExpandMethod("hasAuthenticated", new Object[0]);
            if (objCallExpandMethod != null && (objCallExpandMethod instanceof Boolean)) {
                return (Boolean) objCallExpandMethod;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.mb("TTLiveSDkBridge", th);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww() {
        if (mb != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("live_plugin_installed", hj.get());
                bundle.putBoolean("live_plugin_inited", f14714u.get());
                mb.onEvent(3, bundle);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 5) {
            init((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (i2 != 6) {
            return (T) callMethod(cls, i2, (Map) valueSet.objectValue(0, Map.class));
        }
        Object objObjectValue = valueSet.objectValue(0, Object.class);
        if (objObjectValue instanceof TTAdEvent) {
            subscribe((TTAdEvent) valueSet.objectValue(0, TTAdEvent.class));
        } else if (objObjectValue instanceof EventListener) {
            mb = new mb((EventListener) objObjectValue);
            ww();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        if (i2 == 0) {
            return !f14714u.get() ? (T) 1 : !com.bytedance.sdk.openadsdk.live.mb.mb(getContext(map.get("context")), mb(map.get(TTLiveConstants.BUNDLE_KEY))) ? (T) 2 : (T) 0;
        }
        if (i2 == 1) {
            return (T) f14714u;
        }
        if (i2 == 2) {
            mb(map);
            return null;
        }
        if (i2 != 3) {
            return i2 != 4 ? (T) super.callMethod(cls, i2, map) : (T) u();
        }
        ko();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        return (T) super.getObj(cls, i2, map);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
        ITTLiveConfig iTTLiveConfig = this.ko;
        if (iTTLiveConfig != null && iTTLiveConfig.isValid() && !TextUtils.isEmpty(this.ko.getGeneralAppId()) && !TextUtils.isEmpty(this.ko.getPartner()) && !TextUtils.isEmpty(this.ko.getPartnerSecret())) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "The configuration has been obtained. Do not repeat initialization");
            return;
        }
        Serializable serializable = bundle.getSerializable(TTLiveConstants.LIVE_INIT_CONFIG_KEY);
        if (serializable instanceof ITTLiveConfig) {
            this.ko = (ITTLiveConfig) serializable;
        }
        try {
            this.ww = new JSONObject(bundle.getString(TTLiveConstants.LIVE_INIT_EXTRA_KEY));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        h();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(TTAdEvent tTAdEvent) {
        mb = new mb(tTAdEvent);
        ww();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private static final class mb implements TTAdEvent {
        private TTAdEvent mb;
        private EventListener ox;

        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i2, Bundle bundle) {
            TTAdEvent tTAdEvent = this.mb;
            if (tTAdEvent != null) {
                tTAdEvent.onEvent(i2, bundle);
            }
            if (this.ox != null) {
                this.ox.onEvent(i2, com.bytedance.sdk.openadsdk.api.ox.mb().mb(0).mb(true).mb(b.mb().mb(0, bundle).ox()).ox());
            }
        }

        private mb(TTAdEvent tTAdEvent) {
            this.mb = tTAdEvent;
        }

        private mb(EventListener eventListener) {
            this.ox = eventListener;
        }
    }

    public static ox mb() {
        return ox;
    }

    public void mb(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.lz = iTTLiveTokenInjectionAuth;
    }

    public void mb(u uVar, Bundle bundle) {
        if (b.get()) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live PL is loading...just wait");
            return;
        }
        if (hj.get()) {
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live PL already loaded, dont load again");
            return;
        }
        TTPluginListener tTPluginListener = new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.ox.1
            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public Bundle config() {
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle2) {
                if (1000 == i2) {
                    com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "live PL install success ， try to init live sdk");
                    ox.hj.set(true);
                    ox.b.set(false);
                    ox.this.h();
                } else if (1001 == i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("live PL install failed, errorCode: ");
                    sb.append(bundle2 == null ? null : bundle2.get("code"));
                    com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", sb.toString());
                    ox.hj.set(false);
                    ox.b.set(false);
                }
                ox.this.ww();
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public String packageName() {
                return null;
            }
        };
        b.set(true);
        hj.set(false);
        com.bytedance.sdk.openadsdk.live.mb.mb(uVar, bundle, tTPluginListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object mb(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                Integer num = (Integer) objArr[0];
                TTAdManager adManager = TTAdSdk.getAdManager();
                if (adManager != null) {
                    return adManager.getBiddingToken(new AdSlot.Builder().setAdType(num.intValue()).build());
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private void mb(Map<String, Object> map) {
        try {
            long jLongValue = ((Long) map.get(TTLiveConstants.ROOMID_KEY)).longValue();
            Object obj = map.get("event");
            final mb mbVar = obj instanceof TTAdEvent ? new mb((TTAdEvent) obj) : new mb((EventListener) obj);
            IOuterLiveRoomService liveRoomService = LivePluginHelper.getLiveRoomService();
            System.currentTimeMillis();
            Object objCallExpandMethod = liveRoomService.callExpandMethod("checkRoomAlive", new Callback<Boolean>() { // from class: com.bytedance.sdk.openadsdk.live.ox.4
                @Override // com.bytedance.android.live.base.api.callback.Callback
                /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
                public void invoke(Boolean bool) {
                    if (mbVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(TTLiveConstants.PARAMS_LIVE_ROOM_STATUS, bool.booleanValue());
                        mbVar.onEvent(0, bundle);
                    }
                }
            }, Long.valueOf(jLongValue), 300);
            if (objCallExpandMethod == null) {
                synchronized (mbVar) {
                    try {
                        mbVar.notifyAll();
                    } catch (Throwable unused) {
                    }
                }
            }
            com.bytedance.sdk.openadsdk.api.mb.ox("TTLiveSDkBridge", "has checkRoomAlive :" + objCallExpandMethod);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.mb("TTLiveSDkBridge", "getRoomState: exception:", th);
        }
    }

    private Bundle mb(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }
}
