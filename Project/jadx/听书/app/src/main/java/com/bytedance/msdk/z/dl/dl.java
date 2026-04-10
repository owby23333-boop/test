package com.bytedance.msdk.z.dl;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ls.dl.dl.z f500a = new com.bytedance.sdk.openadsdk.ls.dl.dl.z(com.bytedance.msdk.core.z.kb().ti().sparseArray());
    private PluginValueSet dl;
    private PluginValueSet g;
    private Function<SparseArray<Object>, Object> gc;
    private PluginValueSet z;

    private dl(SparseArray<Object> sparseArray) {
        this.gc = null;
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        this.z = pluginValueSetG;
        if (pluginValueSetG != null) {
            this.dl = com.bytedance.sdk.openadsdk.ls.dl.a.z(8457, pluginValueSetG);
            PluginValueSet pluginValueSetZ = com.bytedance.sdk.openadsdk.ls.dl.a.z(8475, this.z);
            this.g = pluginValueSetZ;
            if (pluginValueSetZ != null) {
                this.gc = (Function) pluginValueSetZ.objectValue(8311, Function.class);
            }
        }
        t();
    }

    private void t() {
        y();
        ec();
        vm();
    }

    private void vm() {
        com.bytedance.msdk.z.gc.dl.g("---------  sdk 聚合信息 start ----");
        com.bytedance.msdk.z.gc.dl.g("getHttps：" + lq());
        com.bytedance.msdk.z.gc.dl.g("getWxAppId：" + mc());
        com.bytedance.msdk.z.gc.dl.g("getPublisherDid：" + un());
        com.bytedance.msdk.z.gc.dl.g("isOpenAdnTest：" + ti());
        com.bytedance.msdk.z.gc.dl.g("getMediationConfigUserInfoForSegment：" + eo());
        com.bytedance.msdk.z.gc.dl.g("getLocalExtra：" + oq());
        com.bytedance.msdk.z.gc.dl.g("getCustomLocalConfig：" + wj());
        com.bytedance.msdk.z.gc.dl.g("getOpensdkVer：" + na());
        com.bytedance.msdk.z.gc.dl.g("isWxInstalled：" + xl());
        com.bytedance.msdk.z.gc.dl.g("isSupportH265：" + j());
        com.bytedance.msdk.z.gc.dl.g("isSupportSplashZoomout：" + gp());
        com.bytedance.msdk.z.gc.dl.g("---------  sdk 聚合信息 end ----");
    }

    private void y() {
        com.bytedance.msdk.z.gc.dl.g("---------  sdk 初始化信息 start ----");
        com.bytedance.msdk.z.gc.dl.g("isDebug：" + h());
        com.bytedance.msdk.z.gc.dl.g("getClassName：" + z());
        com.bytedance.msdk.z.gc.dl.g("getAppId：" + g());
        com.bytedance.msdk.z.gc.dl.g("getAppName：" + dl());
        com.bytedance.msdk.z.gc.dl.g("getADNName：" + a());
        com.bytedance.msdk.z.gc.dl.g("getAppKey：" + gc());
        com.bytedance.msdk.z.gc.dl.g("getInitCallback：" + m());
        com.bytedance.msdk.z.gc.dl.g("getAgeGroup：" + uf());
        com.bytedance.msdk.z.gc.dl.g("isCustom：" + sy());
        com.bytedance.msdk.z.gc.dl.g("getCustomInitMap：" + hh());
        com.bytedance.msdk.z.gc.dl.g("getCustomGMConfiguration：" + l());
        com.bytedance.msdk.z.gc.dl.g("getGromoreVersion：" + gk());
        com.bytedance.msdk.z.gc.dl.g("getMap：" + x());
        com.bytedance.msdk.z.gc.dl.g("---------  sdk 初始化信息 end ----");
    }

    private void ec() {
        com.bytedance.msdk.z.gc.dl.g("---------  sdk 隐私设置 start ----");
        com.bytedance.msdk.z.gc.dl.g("isCanUseLocation：" + fo());
        a aVarPf = pf();
        com.bytedance.msdk.z.gc.dl.g("getLocation：".concat(String.valueOf(aVarPf)));
        if (aVarPf != null) {
            com.bytedance.msdk.z.gc.dl.g("getLocation getLatitude：" + aVarPf.z());
            com.bytedance.msdk.z.gc.dl.g("getLocation getLongitude：" + aVarPf.g());
        }
        com.bytedance.msdk.z.gc.dl.g("appList：" + kb());
        com.bytedance.msdk.z.gc.dl.g("isCanUsePhoneState：" + gz());
        com.bytedance.msdk.z.gc.dl.g("isLimitPersonalAds：" + e());
        com.bytedance.msdk.z.gc.dl.g("getDevImei：" + ls());
        com.bytedance.msdk.z.gc.dl.g("isCanUseWifiState：" + zw());
        com.bytedance.msdk.z.gc.dl.g("getMacAddress：" + q());
        com.bytedance.msdk.z.gc.dl.g("userPrivacyConfig：" + iq());
        com.bytedance.msdk.z.gc.dl.g("isCanUseWriteExternal：" + uy());
        com.bytedance.msdk.z.gc.dl.g("isCanUseAndroidId：" + i());
        com.bytedance.msdk.z.gc.dl.g("getAndroidId：" + fv());
        List<String> listIo = io();
        com.bytedance.msdk.z.gc.dl.g("getAppList：".concat(String.valueOf(listIo)));
        if (listIo != null) {
            Iterator<String> it = listIo.iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.z.gc.dl.g("getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> listP = p();
        com.bytedance.msdk.z.gc.dl.g("getDevImeis：".concat(String.valueOf(listP)));
        if (listP != null) {
            Iterator<String> it2 = listP.iterator();
            while (it2.hasNext()) {
                com.bytedance.msdk.z.gc.dl.g("getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        com.bytedance.msdk.z.gc.dl.g("getDevOaid：" + tb());
        com.bytedance.msdk.z.gc.dl.g("isCanUseOaid：" + js());
        com.bytedance.msdk.z.gc.dl.g("isCanUseMacAddress：" + wp());
        com.bytedance.msdk.z.gc.dl.g("isProgrammaticRecommend：" + v());
        com.bytedance.msdk.z.gc.dl.g("---------  sdk 隐私设置 end ----");
    }

    public static dl z(SparseArray<Object> sparseArray) {
        return new dl(sparseArray);
    }

    public void g(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        this.g = pluginValueSetG;
        if (pluginValueSetG != null) {
            this.gc = (Function) pluginValueSetG.objectValue(8311, Function.class);
        }
        ec();
    }

    private boolean bv() {
        PluginValueSet pluginValueSet = this.z;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    public String z() {
        return bv() ? this.z.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String g() {
        if (bv()) {
            return this.z.stringValue(3);
        }
        return null;
    }

    public String dl() {
        return bv() ? this.z.stringValue(8) : "";
    }

    public String a() {
        return bv() ? this.z.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String gc() {
        return bv() ? this.z.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public Function<SparseArray<Object>, Object> m() {
        if (bv()) {
            return (Function) this.z.objectValue(8300, Function.class);
        }
        return null;
    }

    public boolean e() {
        PluginValueSet pluginValueSetG;
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return false;
        }
        return pluginValueSetG.booleanValue(8027);
    }

    public boolean gz() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean fo() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean uy() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean kb() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean wp() {
        return zw();
    }

    public boolean i() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean v() {
        PluginValueSet pluginValueSetG;
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return true;
        }
        return pluginValueSetG.booleanValue(8028);
    }

    public a pf() {
        if (gb() == -1.0d || gb() == -1.0d) {
            return null;
        }
        return new a() { // from class: com.bytedance.msdk.z.dl.dl.1
            @Override // com.bytedance.msdk.z.dl.a
            public double z() {
                return dl.this.gb();
            }

            @Override // com.bytedance.msdk.z.dl.a
            public double g() {
                return dl.this.jq();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double gb() {
        Function function;
        PluginValueSet pluginValueSetG;
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetG.doubleValue(8481);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double jq() {
        Function function;
        PluginValueSet pluginValueSetG;
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetG.doubleValue(8482);
    }

    public String ls() {
        PluginValueSet pluginValueSet = this.g;
        return pluginValueSet != null ? pluginValueSet.stringValue(8484) : "";
    }

    public List<String> p() {
        PluginValueSet pluginValueSetG;
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function != null && (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) != null) {
            return (List) pluginValueSetG.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String fv() {
        PluginValueSet pluginValueSet = this.g;
        return pluginValueSet != null ? pluginValueSet.stringValue(8485) : "";
    }

    public boolean js() {
        PluginValueSet pluginValueSetG;
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return true;
        }
        return pluginValueSetG.booleanValue(8478);
    }

    public String tb() {
        PluginValueSet pluginValueSet = this.g;
        return pluginValueSet != null ? pluginValueSet.stringValue(8486) : "";
    }

    public String q() {
        PluginValueSet pluginValueSet = this.g;
        return pluginValueSet != null ? pluginValueSet.stringValue(8487) : "";
    }

    public Map<String, Object> iq() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean zw() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8480);
        }
        return true;
    }

    public List<String> io() {
        PluginValueSet pluginValueSetG;
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function != null && (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) != null) {
            return (List) pluginValueSetG.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public int uf() {
        return this.f500a.i();
    }

    public boolean sy() {
        if (bv()) {
            return this.z.booleanValue(8098);
        }
        return false;
    }

    public Map hh() {
        if (bv()) {
            return (Map) this.z.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> l() {
        if (bv()) {
            return (Function) this.z.objectValue(8401, Function.class);
        }
        return null;
    }

    public boolean h() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(1);
        }
        return false;
    }

    public String gk() {
        PluginValueSet pluginValueSet = this.z;
        return pluginValueSet != null ? pluginValueSet.stringValue(8411) : "";
    }

    public Map x() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean lq() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8458);
        }
        return false;
    }

    public String mc() {
        PluginValueSet pluginValueSet = this.dl;
        return pluginValueSet != null ? pluginValueSet.stringValue(8459) : "";
    }

    public String un() {
        PluginValueSet pluginValueSet = this.dl;
        return pluginValueSet != null ? pluginValueSet.stringValue(8460) : "";
    }

    public boolean ti() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8461);
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> eo() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return (Function) pluginValueSet.objectValue(8310, Function.class);
        }
        return null;
    }

    public Map oq() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject wj() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return (JSONObject) pluginValueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String na() {
        PluginValueSet pluginValueSet = this.dl;
        return pluginValueSet != null ? pluginValueSet.stringValue(8464) : "";
    }

    public boolean xl() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean j() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean gp() {
        PluginValueSet pluginValueSet = this.dl;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8467);
        }
        return false;
    }
}
