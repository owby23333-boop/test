package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.gc;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.api.plugin.uy;
import com.bytedance.sdk.openadsdk.api.z;
import com.bytedance.sdk.openadsdk.live.dl;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TTAdSdk {
    public static final String BRANCH = "";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "0053168ac6";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = true;
    public static final boolean IS_P = false;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final boolean PC_BOOST_ABI = false;
    public static final String PLUGIN_ADAPTER_PACKAGE_NAME = "com.byted.mixed";
    public static final int SDK_VERSION_CODE = 7105;
    public static final String SDK_VERSION_NAME = "7.1.0.5";
    public static final String S_C = "main";
    private static volatile TTAdConfig g;
    private static final z z = new uy();

    public interface Callback extends InitCallback {
    }

    @Deprecated
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    @Deprecated
    public static boolean isInitSuccess() {
        z zVar = z;
        if (zVar != null) {
            return zVar.z();
        }
        return false;
    }

    public static boolean isSdkReady() {
        z zVar = z;
        if (zVar != null) {
            return zVar.z();
        }
        return false;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        g = tTAdConfig;
        z(context, g);
        return true;
    }

    public static void start(Callback callback) {
        z(g, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        z zVar = z;
        if (zVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            zVar.z(TTAppContextHolder.getContext(), g, callback);
        }
    }

    private static void z(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            m.z();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            m.g("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        z(context, "Context is null, please check.");
        z(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static TTAdManager getAdManager() {
        z zVar = z;
        if (zVar != null) {
            return zVar.g();
        }
        return null;
    }

    public static IMediationManager getMediationManager() {
        if (z != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean isOpenMediationMap() {
        TTAdManager adManager = getAdManager();
        if (adManager == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_name", "use_mediation_map");
        Map map = (Map) adManager.getExtra(Map.class, bundle);
        if (map == null || !(map.get("use_mediation_map") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) map.get("use_mediation_map")).booleanValue();
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        z.dl dlVarG;
        if (gc.z() || tTAdConfig == null || (dlVarG = z.g()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (!bundle.keySet().isEmpty()) {
            dlVarG.getExtra(SparseArray.class, bundle);
        }
        IMediationManager mediationManager = getMediationManager();
        if (mediationManager != null) {
            if (tTAdConfig.getCustomController() != null) {
                mediationManager.updatePrivacyConfig(tTAdConfig.getCustomController());
            }
            Map<String, Object> initExtra = tTAdConfig.getInitExtra();
            if (initExtra == null || initExtra.isEmpty()) {
                return;
            }
            mediationManager.updateLocalExtra(tTAdConfig.getInitExtra());
        }
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        if (gc.z() || tTAdConfig == null || (initExtra = tTAdConfig.getInitExtra()) == null) {
            return;
        }
        Object obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE);
        if (obj instanceof Map) {
            dl.z().z((Map<String, String>) obj);
        }
    }

    public static View getEcMallBackUpView() {
        z.dl dlVarG = z.g();
        if (dlVarG == null) {
            return null;
        }
        return (View) dlVarG.getExtra(View.class, null);
    }

    public static void updatePaid(boolean z2) {
        z.dl dlVarG = z.g();
        if (dlVarG == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z2);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        dlVarG.getExtra(SparseArray.class, bundle);
    }

    private static void z(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
