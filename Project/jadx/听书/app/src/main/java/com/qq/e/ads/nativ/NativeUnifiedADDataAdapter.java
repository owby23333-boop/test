package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f1926a;
    private NativeADEventListener b;
    private NativeADMediaListener c;
    private DownloadConfirmListener d;
    private NegativeFeedbackListener e;

    /* JADX INFO: loaded from: classes4.dex */
    private class UnifiedAdListener implements ADListener {
        private UnifiedAdListener() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeUnifiedADDataAdapter.this.a(aDEvent) || NativeUnifiedADDataAdapter.this.b(aDEvent)) {
                return;
            }
            NativeUnifiedADDataAdapter.this.c(aDEvent);
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f1926a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener());
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        this.f1926a.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f1926a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f1926a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        this.f1926a.bindImageViews(list, i);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.c = nativeADMediaListener;
        this.f1926a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f1926a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f1926a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f1926a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f1926a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f1926a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.f1926a.getAppMiitInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f1926a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f1926a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f1926a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return this.f1926a.getButtonText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f1926a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        return this.f1926a.getCustomizeVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f1926a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f1926a.getDownloadCount();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f1926a.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f1926a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f1926a.getExtraInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f1926a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f1926a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f1926a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f1926a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f1926a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f1926a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f1926a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f1926a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f1926a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f1926a.isAppAd();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.f1926a.isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.f1926a.isWeChatCanvasAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f1926a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f1926a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f1926a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f1926a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f1926a.resumeVideo();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.f1926a.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.f1926a.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.f1926a.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f1926a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.b = nativeADEventListener;
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.e = negativeFeedbackListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.f1926a.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f1926a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f1926a.stopVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ADEvent aDEvent) {
        if (this.b == null) {
            return false;
        }
        int type = aDEvent.getType();
        if (type == 103) {
            this.b.onADExposed();
            return true;
        }
        if (type == 105) {
            NativeADEventListener nativeADEventListener = this.b;
            if (!(nativeADEventListener instanceof NativeADEventListenerWithClickInfo)) {
                nativeADEventListener.onADClicked();
                return true;
            }
            ((NativeADEventListenerWithClickInfo) this.b).onADClicked((View) aDEvent.getParam(View.class));
            return true;
        }
        if (type != 107) {
            if (type != 111) {
                return false;
            }
            this.b.onADStatusChanged();
            return true;
        }
        Integer num = (Integer) aDEvent.getParam(Integer.class);
        if (num == null) {
            return true;
        }
        this.b.onADError(AdErrorConvertor.formatErrorCode(num.intValue()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ADEvent aDEvent) {
        if (this.c == null) {
            return false;
        }
        switch (aDEvent.getType()) {
            case 201:
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    this.c.onVideoLoaded(num.intValue());
                }
                break;
            case 202:
                this.c.onVideoStart();
                break;
            case 203:
                this.c.onVideoResume();
                break;
            case 204:
                this.c.onVideoPause();
                break;
            case 205:
                this.c.onVideoStop();
                break;
            case 206:
                this.c.onVideoCompleted();
                break;
            case 207:
                Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                if (num2 != null) {
                    this.c.onVideoError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                }
                break;
            case 208:
                this.c.onVideoClicked();
                break;
            case 209:
                this.c.onVideoInit();
                break;
            case 210:
                this.c.onVideoReady();
                break;
            case 211:
                this.c.onVideoLoading();
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(ADEvent aDEvent) {
        if (this.e == null || aDEvent.getType() != 304) {
            return false;
        }
        this.e.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f1926a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        this.f1926a.bindImageViews(list, bArr);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f1926a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f1926a.sendWinNotification(map);
    }
}
