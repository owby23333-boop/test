package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.api.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private String a;
    private int b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f1419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1422i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1416c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1417d = 0;
    public int ifTest = 0;

    public static AdSlot getShallowCopy(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()).setSupportDeepLink(adSlot.isSupportDeepLink()).setAdCount(adSlot.getAdCount()).setRewardName(adSlot.getRewardName()).setRewardAmount(adSlot.getRewardAmount()).setMediaExtra(adSlot.getMediaExtra()).setCustomData(adSlot.getCustomData()).setUserID(adSlot.getUserID()).setOrientation(adSlot.getOrientation()).setAdType(adSlot.getAdType()).setTTVideoOption(adSlot.getTTVideoOption()).setTTRequestExtraParams(adSlot.getReuestParam()).setAdStyleType(adSlot.getAdStyleType()).setBannerSize(adSlot.getBannerSize()).setAdmobNativeAdOptions(adSlot.getAdmobNativeAdOptions()).setGdtNativeAdLogoParams(adSlot.getGdtNativeAdLogoParams()).setSplashButtonType(adSlot.getSplashButtonType()).setDownloadType(adSlot.getDownloadType()).setBidNotify(adSlot.isBidNotify()).setForceLoadBottom(adSlot.isForceLoadBottom()).setTestSlotId(adSlot.getTestSlotId()).setV2Request(adSlot.isV2Request());
        AdSlot adSlotBuild = builder.build();
        List<String> listA = l.a();
        l.b(listA, "mAdWidth");
        l.b(listA, "mAdHeight");
        l.b(listA, "mSupportDeepLink");
        l.b(listA, "mAdCount");
        l.b(listA, "mRewardName");
        l.b(listA, "mRewardAmount");
        l.b(listA, "mMediaExtra");
        l.b(listA, "mCustomData");
        l.b(listA, "mUserID");
        l.b(listA, "mOrientation");
        l.b(listA, "mAdType");
        l.b(listA, "mTTVideoOption");
        l.b(listA, "mRequestParams");
        l.b(listA, "mAdStyleType");
        l.b(listA, "mBannerSize");
        l.b(listA, "mAdmobNativeAdOptions");
        l.b(listA, "gdtNativeAdLogoParams");
        l.b(listA, "mSplashButtonType");
        l.b(listA, "mDownloadType");
        l.b(listA, "mBidNotify");
        l.b(listA, "mForceLoadBottom");
        l.b(listA, "mTestSlotId");
        l.b(listA, "mV2Request");
        adSlotBuild.setAdUnitId(adSlot.getAdUnitId());
        l.b(listA, "mAdUnitId");
        adSlotBuild.setVersion(adSlot.getVersion());
        l.b(listA, "version");
        adSlotBuild.setWaterfallId(adSlot.getWaterfallId());
        l.b(listA, "waterfallId");
        adSlotBuild.setAdloadSeq(adSlot.getAdloadSeq());
        l.b(listA, "mAdloadSeq");
        adSlotBuild.setLinkedId(adSlot.getLinkedId());
        l.b(listA, "mLinkedId");
        adSlotBuild.setSegmentId(adSlot.getSegmentId());
        l.b(listA, "segmentId");
        adSlotBuild.setSegmentVersion(adSlot.getSegmentVersion());
        l.b(listA, "segmentVersion");
        adSlotBuild.setReqType(adSlot.getReqType());
        l.b(listA, "reqType");
        adSlotBuild.setmWaterfallExtra(adSlot.getmWaterfallExtra());
        l.b(listA, "mWaterfallExtra");
        adSlotBuild.setTransparentParams(adSlot.getTransparentParams());
        l.b(listA, "mTransparentParams");
        adSlotBuild.setIfTest(adSlot.getIfTest());
        l.b(listA, "ifTest");
        adSlotBuild.setBidFloor(adSlot.getBidFloor());
        l.b(listA, "mBidFloor");
        adSlotBuild.setParalleType(adSlot.getParalleType());
        l.b(listA, "mParalleType");
        adSlotBuild.setReqParallelNum(adSlot.getReqParallelNum());
        l.b(listA, "mReqParallelNum");
        adSlotBuild.setSplashShakeButton(adSlot.getSplashShakeButton());
        l.b(listA, "mSplashShakeButton");
        adSlotBuild.setNetWorkNum("network_ad_num_" + adSlot.getNetWorkNum());
        l.b(listA, "mNetWorkNum");
        adSlotBuild.setScenarioId(adSlot.getScenarioId());
        l.b(listA, "mScenarioId");
        l.a(listA, "AdSlot");
        return adSlotBuild;
    }

    public int getAdloadSeq() {
        return this.b;
    }

    public int getIfTest() {
        return this.ifTest;
    }

    public String getLinkedId() {
        return this.a;
    }

    public int getNetWorkNum() {
        return this.f1422i;
    }

    public int getPrimeRitReqType() {
        return this.f1416c;
    }

    public int getReqType() {
        return this.f1417d;
    }

    public int getSegmentId() {
        return this.f1418e;
    }

    public String getSegmentVersion() {
        return this.f1419f;
    }

    public String getTransparentParams() {
        return this.f1420g;
    }

    public String getmWaterfallExtra() {
        return this.f1421h;
    }

    public void setAdloadSeq(int i2) {
        this.b = i2;
    }

    public void setIfTest(int i2) {
        this.ifTest = i2;
    }

    public void setLinkedId(String str) {
        this.a = str;
    }

    public void setNetWorkNum(String str) {
        this.f1422i = t.a(str);
    }

    public void setPrimeRitReqType(int i2) {
        this.f1416c = i2;
    }

    public void setReqType(int i2) {
        this.f1417d = i2;
    }

    public void setSegmentId(int i2) {
        this.f1418e = i2;
    }

    public void setSegmentVersion(String str) {
        this.f1419f = str;
    }

    public void setTransparentParams(String str) {
        this.f1420g = str;
    }

    public void setmWaterfallExtra(String str) {
        this.f1421h = str;
    }
}
