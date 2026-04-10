package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CSJConfig implements AdConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f892a;
    private boolean dl;
    private boolean e;
    private int[] fo;
    private String g;
    private String gc;
    private boolean gz;
    private int i;
    private Map<String, Object> kb;
    private boolean ls;
    private int m;
    private IMediationConfig p;
    private int pf;
    private boolean uy;
    private int v;
    private TTCustomController wp;
    private String z;

    CSJConfig(z zVar) {
        this.dl = false;
        this.m = 0;
        this.e = true;
        this.gz = false;
        this.uy = false;
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f892a = zVar.f893a;
        this.gc = zVar.gc;
        this.m = zVar.m;
        this.e = zVar.e;
        this.gz = zVar.gz;
        this.fo = zVar.fo;
        this.uy = zVar.uy;
        this.wp = zVar.kb;
        this.i = zVar.wp;
        this.pf = zVar.v;
        this.v = zVar.i;
        this.ls = zVar.pf;
        this.p = zVar.ls;
        this.kb = zVar.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.kb;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f892a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.wp;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.pf;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.ls;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.kb;
    }

    public void setAppId(String str) {
        this.z = str;
    }

    public void setAppName(String str) {
        this.g = str;
    }

    public void setPaid(boolean z2) {
        this.dl = z2;
    }

    public void setKeywords(String str) {
        this.f892a = str;
    }

    public void setData(String str) {
        this.gc = str;
    }

    public void setTitleBarTheme(int i) {
        this.m = i;
    }

    public void setAllowShowNotify(boolean z2) {
        this.e = z2;
    }

    public void setDebug(boolean z2) {
        this.gz = z2;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.fo = iArr;
    }

    public void setSupportMultiProcess(boolean z2) {
        this.uy = z2;
    }

    public void setAgeGroup(int i) {
        this.pf = i;
    }

    public void setThemeStatus(int i) {
        this.i = i;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.wp = tTCustomController;
    }

    static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f893a;
        private int[] fo;
        private String g;
        private String gc;
        private TTCustomController kb;
        private IMediationConfig ls;
        private boolean pf;
        private int wp;
        private String z;
        private boolean dl = false;
        private int m = 0;
        private boolean e = true;
        private boolean gz = false;
        private boolean uy = false;
        private int i = 2;
        private int v = 0;
        private Map<String, Object> p = null;

        z() {
        }

        public z z(String str) {
            this.z = str;
            return this;
        }

        public z g(String str) {
            this.g = str;
            return this;
        }

        public z z(boolean z) {
            this.dl = z;
            return this;
        }

        public z dl(String str) {
            this.f893a = str;
            return this;
        }

        public z a(String str) {
            this.gc = str;
            return this;
        }

        public z z(int i) {
            this.m = i;
            return this;
        }

        public z g(boolean z) {
            this.e = z;
            return this;
        }

        public z dl(boolean z) {
            this.gz = z;
            return this;
        }

        public z z(int... iArr) {
            this.fo = iArr;
            return this;
        }

        public z a(boolean z) {
            this.uy = z;
            return this;
        }

        public z z(TTCustomController tTCustomController) {
            this.kb = tTCustomController;
            return this;
        }

        public z g(int i) {
            this.wp = i;
            return this;
        }

        public z dl(int i) {
            this.i = i;
            return this;
        }

        public z a(int i) {
            this.v = i;
            return this;
        }

        public z gc(boolean z) {
            this.pf = z;
            return this;
        }

        public z z(IMediationConfig iMediationConfig) {
            this.ls = iMediationConfig;
            return this;
        }

        public z z(String str, Object obj) {
            if (this.p == null) {
                this.p = new HashMap();
            }
            this.p.put(str, obj);
            return this;
        }
    }
}
