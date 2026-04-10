package com.bytedance.sdk.openadsdk.mb;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.TTAdBridge;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.api.plugin.u;
import com.bytedance.sdk.openadsdk.mb.mb;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ox implements Bridge, TTAdBridge {
    private static volatile ox mb;
    private mb ox = new mb();

    private ox() {
    }

    public static final ox mb() {
        if (mb == null) {
            synchronized (ox.class) {
                if (mb == null) {
                    mb = new ox();
                }
            }
        }
        return mb;
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [T, java.lang.CharSequence, java.lang.String] */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        switch (i2) {
            case 2:
                return (T) this.ox.mb();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
                return (T) Zeus.getPlugin(valueSet.stringValue(0)).mClassLoader;
            case 5:
                return (T) Boolean.valueOf(Zeus.loadPlugin(valueSet.stringValue(0)));
            case 6:
                return (T) Boolean.valueOf(Zeus.isPluginInstalled(valueSet.stringValue(0)));
            case 7:
                return (T) Boolean.valueOf(Zeus.isPluginLoaded(valueSet.stringValue(0)));
            case 8:
                ?? r1 = (T) u.mb(valueSet.stringValue(0));
                return TextUtils.isEmpty(r1) ? "0.0.0.0" : r1;
            case 9:
                Object objObjectValue = valueSet.objectValue(0, Object.class);
                if (objObjectValue instanceof TTAdEvent) {
                    subscribe((TTAdEvent) objObjectValue);
                    return null;
                }
                if (!(objObjectValue instanceof EventListener)) {
                    return null;
                }
                mb((EventListener) objObjectValue);
                return null;
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public String call(int i2, Bundle bundle) {
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [T, java.lang.CharSequence, java.lang.String] */
    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        switch (i2) {
            case 2:
                return (T) this.ox.mb();
            case 3:
                return (T) TTAppContextHolder.getContext();
            case 4:
                return (T) Zeus.getPlugin("com.byted.csj.ext").mClassLoader;
            case 5:
                return (T) Boolean.valueOf(Zeus.loadPlugin("com.byted.csj.ext"));
            case 6:
                return (T) Boolean.valueOf(Zeus.isPluginInstalled("com.byted.csj.ext"));
            case 7:
                return (T) Boolean.valueOf(Zeus.isPluginLoaded("com.byted.csj.ext"));
            case 8:
                ?? r1 = (T) u.mb("com.byted.csj.ext");
                return TextUtils.isEmpty(r1) ? "0.0.0.0" : r1;
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
    }

    public Application.ActivityLifecycleCallbacks ox() {
        return this.ox;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void removeObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void setObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(final TTAdEvent tTAdEvent) {
        this.ox.mb(new mb.InterfaceC0310mb() { // from class: com.bytedance.sdk.openadsdk.mb.ox.1
            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0310mb
            public void mb() {
                tTAdEvent.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0310mb
            public void ox() {
                tTAdEvent.onEvent(1, null);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void unsubscribe(TTAdEvent tTAdEvent) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private void mb(final EventListener eventListener) {
        this.ox.mb(new mb.InterfaceC0310mb() { // from class: com.bytedance.sdk.openadsdk.mb.ox.2
            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0310mb
            public void mb() {
                eventListener.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.mb.mb.InterfaceC0310mb
            public void ox() {
                eventListener.onEvent(1, null);
            }
        });
    }
}
