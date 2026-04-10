package com.qq.e.ads.banner2;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface, IBidding, NFBI, IReward {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final UnifiedBannerAD f1909a;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        this.f1909a.destroy();
    }

    public String getAdNetWorkName() {
        return this.f1909a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f1909a.getApkInfoUrl();
    }

    public int getECPM() {
        return this.f1909a.getECPM();
    }

    public String getECPMLevel() {
        return this.f1909a.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        return this.f1909a.getExtraInfo();
    }

    public boolean isValid() {
        return this.f1909a.isValid();
    }

    public void loadAD() {
        this.f1909a.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f1909a.onWindowFocusChanged(z);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.f1909a.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.f1909a.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.f1909a.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f1909a.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f1909a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f1909a.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i) {
        this.f1909a.c(i);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f1909a.setRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f1909a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f1909a = new UnifiedBannerAD(activity, this, str, unifiedBannerADListener);
        a();
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f1909a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f1909a.sendWinNotification(map);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e(getClass().getSimpleName() + "构造函数中 token 参数不可为空");
        }
        this.f1909a = new UnifiedBannerAD(activity, this, str, str2, unifiedBannerADListener);
        a();
    }
}
