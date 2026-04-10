package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.bytedance.sdk.openadsdk.mediation.z.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MediationInitConfig {
    private static String z = "MEDIATION_LOG";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ValueSet f1464a;
    private ValueSet dl;
    private ValueSet g;

    private MediationInitConfig(ValueSet valueSet) {
        this.g = valueSet;
        if (valueSet != null) {
            this.f1464a = dl.z((SparseArray<Object>) valueSet.objectValue(8457, SparseArray.class)).g();
            this.dl = dl.z((SparseArray<Object>) this.g.objectValue(8475, SparseArray.class)).g();
        }
        z();
    }

    private void z() {
        dl();
        a();
        g();
    }

    private void g() {
        m.dl(z, "---------  sdk 聚合信息 start ----");
        m.dl(z, "getHttps：" + getHttps());
        m.dl(z, "getWxAppId：" + getWxAppId());
        m.dl(z, "getPublisherDid：" + getPublisherDid());
        m.dl(z, "isOpenAdnTest：" + isOpenAdnTest());
        m.dl(z, "getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        m.dl(z, "getLocalExtra：" + getLocalExtra());
        m.dl(z, "getCustomLocalConfig：" + getCustomLocalConfig());
        m.dl(z, "getOpensdkVer：" + getOpensdkVer());
        m.dl(z, "isWxInstalled：" + isWxInstalled());
        m.dl(z, "isSupportH265：" + isSupportH265());
        m.dl(z, "isSupportSplashZoomout：" + isSupportSplashZoomout());
        m.dl(z, "---------  sdk 聚合信息 end ----");
    }

    private void dl() {
        m.dl(z, "---------  sdk 初始化信息 start ----");
        m.dl(z, "isDebug：" + isDebug());
        m.dl(z, "getClassName：" + getClassName());
        m.dl(z, "getAppId：" + getAppId());
        m.dl(z, "getAppName：" + getAppName());
        m.dl(z, "getADNName：" + getADNName());
        m.dl(z, "getAppKey：" + getAppKey());
        m.dl(z, "getInitCallback：" + getInitCallback());
        m.dl(z, "getAgeGroup：" + getAgeGroup());
        m.dl(z, "isCustom：" + isCustom());
        m.dl(z, "getCustomInitConfig：" + getCustomInitConfig());
        m.dl(z, "getCustomInitMap：" + getCustomInitMap());
        m.dl(z, "getCustomGMConfiguration：" + getCustomGMConfiguration());
        m.dl(z, "getKsAdapterVersion：" + getKsAdapterVersion());
        m.dl(z, "getGromoreVersion：" + getGromoreVersion());
        m.dl(z, "getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        m.dl(z, "getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        m.dl(z, "getGdtAdapterVersion：" + getGdtAdapterVersion());
        m.dl(z, "getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        m.dl(z, "getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        m.dl(z, "getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        m.dl(z, "getUnityAdapterVersion：" + getUnityAdapterVersion());
        m.dl(z, "getMap：" + getInitAdnMap());
        m.dl(z, "---------  sdk 初始化信息 end ----");
    }

    private void a() {
        m.dl(z, "---------  sdk 隐私设置 start ----");
        m.dl(z, "isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            m.dl(z, "getLocation getLatitude：" + location.getLatitude());
            m.dl(z, "getLocation getLongitude：" + location.getLongitude());
        } else {
            m.dl(z, "getLocation is null");
        }
        m.dl(z, "appList：" + appList());
        m.dl(z, "isCanUsePhoneState：" + isCanUsePhoneState());
        m.dl(z, "isLimitPersonalAds：" + isLimitPersonalAds());
        m.dl(z, "getDevImei：" + getDevImei());
        m.dl(z, "isCanUseWifiState：" + isCanUseWifiState());
        m.dl(z, "getMacAddress：" + getMacAddress());
        m.dl(z, "isCanUseWriteExternal：" + isCanUseWriteExternal());
        m.dl(z, "isCanUseAndroidId：" + isCanUseAndroidId());
        m.dl(z, "getAndroidId：" + getAndroidId());
        m.dl(z, "isCanUseMessage：" + isCanUseMessage());
        List<String> appList = getAppList();
        m.dl(z, "getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                m.dl(z, "getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        m.dl(z, "getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                m.dl(z, "getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        m.dl(z, "getDevOaid：" + getDevOaid());
        m.dl(z, "isCanUseOaid：" + isCanUseOaid());
        m.dl(z, "isCanUseMacAddress：" + isCanUseMacAddress());
        m.dl(z, "isProgrammaticRecommend：" + isProgrammaticRecommend());
        m.dl(z, "isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        m.dl(z, "---------  sdk 隐私设置 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.dl = valueSet;
        a();
    }

    public ValueSet getValueSet() {
        return this.g;
    }

    private boolean gc() {
        ValueSet valueSet = this.g;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getClassName() {
        return gc() ? this.g.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String getAppId() {
        if (gc()) {
            return this.g.stringValue(3);
        }
        return null;
    }

    public String getAppName() {
        return gc() ? this.g.stringValue(8) : "";
    }

    public String getADNName() {
        return gc() ? this.g.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getAppKey() {
        return gc() ? this.g.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public Function getInitCallback() {
        if (gc()) {
            return g.z(this.g.objectValue(8300, Object.class));
        }
        return null;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> functionZ;
        ValueSet valueSet = this.dl;
        if (valueSet == null || (functionZ = g.z(valueSet.objectValue(8311, Object.class))) == null) {
            return false;
        }
        Object obj = functionZ instanceof Supplier ? ((Supplier) functionZ).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean appList() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> functionZ;
        ValueSet valueSet = this.dl;
        if (valueSet == null || (functionZ = g.z(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionZ instanceof Supplier ? ((Supplier) functionZ).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> functionZ;
        ValueSet valueSet = this.dl;
        if (valueSet != null && (functionZ = g.z(valueSet.objectValue(8312, Object.class))) != null) {
            Object obj = functionZ instanceof Supplier ? ((Supplier) functionZ).get() : null;
            if (obj instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) obj;
                final double dDoubleValue = ((Double) MediationValueUtil.objectValue(sparseArray.get(8481), Double.class, Double.valueOf(0.0d))).doubleValue();
                final double dDoubleValue2 = ((Double) MediationValueUtil.objectValue(sparseArray.get(8482), Double.class, Double.valueOf(0.0d))).doubleValue();
                return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLatitude() {
                        return dDoubleValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLongitude() {
                        return dDoubleValue2;
                    }
                };
            }
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.dl;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> functionZ;
        ValueSet valueSet = this.dl;
        if (valueSet != null && (functionZ = g.z(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionZ instanceof Supplier ? ((Supplier) functionZ).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAndroidId() {
        ValueSet valueSet = this.dl;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> functionZ;
        ValueSet valueSet = this.dl;
        if (valueSet == null || (functionZ = g.z(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionZ instanceof Supplier ? ((Supplier) functionZ).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public String getDevOaid() {
        ValueSet valueSet = this.dl;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getMacAddress() {
        ValueSet valueSet = this.dl;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> functionZ;
        ValueSet valueSet = this.dl;
        if (valueSet != null && (functionZ = g.z(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionZ instanceof Supplier ? ((Supplier) functionZ).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean isCanUseMessage() {
        ValueSet valueSet = this.dl;
        if (valueSet != null) {
            return valueSet.booleanValue(8562);
        }
        return true;
    }

    public int getAgeGroup() {
        if (gc()) {
            return this.g.intValue(7);
        }
        return 0;
    }

    public boolean isCustom() {
        if (gc()) {
            return this.g.booleanValue(8098);
        }
        return false;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (gc()) {
            return (MediationCustomInitConfig) this.g.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (gc()) {
            return dl.z((SparseArray<Object>) this.g.objectValue(8545, SparseArray.class)).g();
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (gc()) {
            return (Map) this.g.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function getCustomGMConfiguration() {
        if (gc()) {
            return g.z(this.g.objectValue(8401, Object.class));
        }
        return null;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.g;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.g;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.g;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean getHttps() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.f1464a;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.f1464a;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return g.z(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.f1464a;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.f1464a;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public String getAdapterManagerClassName() {
        ValueSet valueSet = this.g;
        if (valueSet != null) {
            return valueSet.stringValue(8560);
        }
        return null;
    }
}
