package com.qq.e.ads;

import android.app.Activity;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.LADI;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LiteAbstractAD<T extends LADI> extends AbstractAD<T> implements LADI, DownloadConfirmListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownloadConfirmListener f17697f;

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        T t2 = this.a;
        if (t2 != null) {
            return t2.getApkInfoUrl();
        }
        a("getApkInfoUrl");
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        T t2 = this.a;
        if (t2 != null) {
            return t2.getECPM();
        }
        a("getECPM");
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        T t2 = this.a;
        if (t2 != null) {
            return t2.getECPMLevel();
        }
        a("getECPMLevel");
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        T t2 = this.a;
        if (t2 != null) {
            return t2.getExtraInfo();
        }
        a("getExtraInfo");
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        T t2 = this.a;
        if (t2 != null) {
            return t2.isValid();
        }
        a("isValid");
        return false;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f17697f;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i2, int i3, String str) {
        T t2 = this.a;
        if (t2 != null) {
            t2.sendLossNotification(i2, i3, str);
        } else {
            a("sendLossNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        T t2 = this.a;
        if (t2 != null) {
            t2.sendLossNotification(map);
        } else {
            a("sendLossNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i2) {
        T t2 = this.a;
        if (t2 != null) {
            t2.sendWinNotification(i2);
        } else {
            a("sendWinNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        T t2 = this.a;
        if (t2 != null) {
            t2.sendWinNotification(map);
        } else {
            a("sendWinNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i2) {
        T t2 = this.a;
        if (t2 != null) {
            t2.setBidECPM(i2);
        } else {
            a("setBidECPM");
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f17697f = downloadConfirmListener;
        T t2 = this.a;
        if (t2 != null) {
            t2.setDownloadConfirmListener(this);
        }
    }
}
