package com.bytedance.embedapplog;

import androidx.annotation.NonNull;
import com.bytedance.embedapplog.util.UriConfig;

/* JADX INFO: loaded from: classes.dex */
public class InitConfig {
    private String bf;
    private String bh;
    private String cv;
    private String d;
    private String dt;
    private String e;
    private String f;
    private String fy;
    private String ga;
    private String h;
    private String k;
    private int l;
    private String m;
    private IPicker p;
    private String pe;
    private int s;
    private String t;
    private String tg;
    private boolean v;
    private String vn;
    private int w;
    private String wl;
    private String wu;
    private ISensitiveInfoProvider x;
    private UriConfig xu;
    private String y;
    private int zk = 0;
    private boolean za = true;
    private boolean lc = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2075a = true;
    private String uk = null;

    public InitConfig(@NonNull String str, @NonNull String str2) {
        this.e = str;
        this.bf = str2;
    }

    public String geCustomerAndroidId() {
        return this.uk;
    }

    public String getAbClient() {
        return this.k;
    }

    public String getAbFeature() {
        return this.y;
    }

    public String getAbGroup() {
        return this.pe;
    }

    public String getAbVersion() {
        return this.dt;
    }

    public String getAid() {
        return this.e;
    }

    public String getAliyunUdid() {
        return this.vn;
    }

    public String getAppBuildSerial() {
        return this.h;
    }

    public String getAppImei() {
        return this.fy;
    }

    public String getAppName() {
        return this.wu;
    }

    public String getChannel() {
        return this.bf;
    }

    public String getGoogleAid() {
        return this.d;
    }

    public String getLanguage() {
        return this.tg;
    }

    public String getManifestVersion() {
        return this.f;
    }

    public int getManifestVersionCode() {
        return this.l;
    }

    public IPicker getPicker() {
        return this.p;
    }

    public int getProcess() {
        return this.zk;
    }

    public String getRegion() {
        return this.ga;
    }

    public String getReleaseBuild() {
        return this.m;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        return this.x;
    }

    public String getTweakedChannel() {
        return this.t;
    }

    public int getUpdateVersionCode() {
        return this.w;
    }

    public UriConfig getUriConfig() {
        return this.xu;
    }

    public String getVersion() {
        return this.bh;
    }

    public int getVersionCode() {
        return this.s;
    }

    public String getVersionMinor() {
        return this.cv;
    }

    public String getZiJieCloudPkg() {
        return this.wl;
    }

    public boolean isAndroidIdEnable() {
        return this.f2075a;
    }

    public boolean isImeiEnable() {
        return this.lc;
    }

    public boolean isMacEnable() {
        return this.za;
    }

    public boolean isPlayEnable() {
        return this.v;
    }

    public InitConfig setAbClient(String str) {
        this.k = str;
        return this;
    }

    public InitConfig setAbFeature(String str) {
        this.y = str;
        return this;
    }

    public InitConfig setAbGroup(String str) {
        this.pe = str;
        return this;
    }

    public InitConfig setAbVersion(String str) {
        this.dt = str;
        return this;
    }

    public InitConfig setAliyunUdid(String str) {
        this.vn = str;
        return this;
    }

    public void setAndroidIdEnable(boolean z) {
        this.f2075a = z;
    }

    public void setAppBuildSerial(String str) {
        this.h = str;
    }

    public void setAppImei(String str) {
        this.fy = str;
    }

    public InitConfig setAppName(String str) {
        this.wu = str;
        return this;
    }

    public void setCustomerAndroidId(String str) {
        this.uk = str;
    }

    @NonNull
    public InitConfig setEnablePlay(boolean z) {
        this.v = z;
        return this;
    }

    @NonNull
    public InitConfig setGoogleAid(String str) {
        this.d = str;
        return this;
    }

    public void setImeiEnable(boolean z) {
        this.lc = z;
    }

    @NonNull
    public InitConfig setLanguage(String str) {
        this.tg = str;
        return this;
    }

    public void setMacEnable(boolean z) {
        this.za = z;
    }

    public InitConfig setManifestVersion(String str) {
        this.f = str;
        return this;
    }

    public InitConfig setManifestVersionCode(int i) {
        this.l = i;
        return this;
    }

    @NonNull
    public InitConfig setPicker(IPicker iPicker) {
        this.p = iPicker;
        return this;
    }

    @NonNull
    public InitConfig setProcess(int i) {
        this.zk = i;
        return this;
    }

    @NonNull
    public InitConfig setRegion(String str) {
        this.ga = str;
        return this;
    }

    @NonNull
    public InitConfig setReleaseBuild(String str) {
        this.m = str;
        return this;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        this.x = iSensitiveInfoProvider;
    }

    public InitConfig setTweakedChannel(String str) {
        this.t = str;
        return this;
    }

    public InitConfig setUpdateVersionCode(int i) {
        this.w = i;
        return this;
    }

    public InitConfig setUriConfig(int i) {
        this.xu = UriConfig.createUriConfig(i);
        return this;
    }

    public InitConfig setVersion(String str) {
        this.bh = str;
        return this;
    }

    public InitConfig setVersionCode(int i) {
        this.s = i;
        return this;
    }

    public InitConfig setVersionMinor(String str) {
        this.cv = str;
        return this;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        this.wl = str;
        return this;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        this.xu = uriConfig;
        return this;
    }
}
