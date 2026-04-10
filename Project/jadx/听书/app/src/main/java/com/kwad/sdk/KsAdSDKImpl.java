package com.kwad.sdk;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@KsAdSdkDynamicImpl(IKsAdSDK.class)
public class KsAdSDKImpl implements IKsAdSDK {
    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i, Map<String, Object> map) {
    }

    private KsAdSDKImpl() {
    }

    static class a {
        private static final KsAdSDKImpl asg = new KsAdSDKImpl();
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    public static KsAdSDKImpl get() {
        return a.asg;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        l lVarCf = l.Cf();
        lVarCf.init(context, sdkConfig);
        if (!lVarCf.Cg()) {
            lVarCf.start();
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void start() {
        l lVarCf = l.Cf();
        if (lVarCf.Cg()) {
            lVarCf.start();
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        l.Cf();
        return l.isDebugLogEnable();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        l.Cf();
        return l.getAppId();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        l.Cf();
        return l.getAppName();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        l.Cf();
        return l.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public KsLoadManager getAdManager() {
        return l.Cf().getAdManager();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        l.Cf().unInit();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        l.Cf();
        return l.getSDKVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        l.Cf();
        return BuildConfig.VERSION_CODE;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        l.Cf();
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return l.Cf().getApiVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return l.Cf().getApiVersionCode();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        l.Cf().setApiVersion(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i) {
        l.Cf().setApiVersionCode(i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        l.Cf();
        l.deleteCache();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        return (T) l.Cf().newComponentProxy(cls, obj);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        l.Cf();
        return (T) l.newInstance(cls);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public JSONObject getAppInfo() {
        l.Cf();
        return l.getAppInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public JSONObject getDeviceInfo() {
        l.Cf();
        return l.getDeviceInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public JSONObject getNetworkInfo() {
        l.Cf();
        return l.getNetworkInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        l.Cf().setIsExternal(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        l.Cf();
        return l.getDid();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        l.Cf();
        l.resumeCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        l.Cf();
        l.pauseCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z) {
        l.Cf().setPersonalRecommend(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z) {
        l.Cf().setProgrammaticRecommend(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z) {
        l.Cf().setAdxEnable(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        l.Cf().setAppTag(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j) {
        l.Cf().setLaunchTime(j);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setInitStartTime(long j) {
        l.Cf().setInitStartTime(j);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i) {
        l.Cf();
        l.setThemeMode(i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z, int i) {
        l.Cf();
        l.setLoadingLottieAnimation(z, i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z, int i) {
        l.Cf();
        l.setLoadingLottieAnimationColor(z, i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            l.Cf();
            l.k((Throwable) obj);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(Map<String, String> map) {
        l.Cf();
        l.e(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        l.Cf();
        return l.ck(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        l.Cf();
        return l.cl(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        l.Cf();
        l.b(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        l.Cf();
        return l.f(str, objArr);
    }

    public SdkConfig getSdkConfig() {
        l.Cf();
        return l.getSdkConfig();
    }
}
