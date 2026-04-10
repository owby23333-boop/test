package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.je;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb implements je.mb {
    private static final String mb = "mb";
    private static mb ox;
    private com.ss.android.downloadlib.utils.je b = new com.ss.android.downloadlib.utils.je(Looper.getMainLooper(), this);
    private long hj;

    private mb() {
    }

    public static mb mb() {
        if (ox == null) {
            synchronized (mb.class) {
                if (ox == null) {
                    ox = new mb();
                }
            }
        }
        return ox;
    }

    public void mb(@NonNull DownloadInfo downloadInfo, long j2, long j3, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.model.mb mbVar = new com.ss.android.downloadlib.addownload.model.mb(downloadInfo.getId(), j2, j3, str, str2, str3, str4);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.u.hj.je() || com.ss.android.socialbase.appdownloader.u.hj.nk()) && SystemUtils.checkServiceExists(x.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (DownloadUtils.getBoolean(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.b.obtainMessage(200, mbVar);
                messageObtainMessage.arg1 = 2;
                this.b.sendMessageDelayed(messageObtainMessage, r1.optInt("check_silent_install_interval", BaseConstants.Time.MINUTE));
                return;
            }
            com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(mbVar.ox);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put(EventConstants.ExtraJson.KEY_TYPE, "miui_silent_install");
                jSONObject.put(EventConstants.ExtraJson.KEY_MESSAGE, "miui_silent_install_failed: has not started service");
                i2 = 5;
            } catch (Exception unused) {
            }
            x.u().mb(null, new BaseException(i2, jSONObject.toString()), i2);
            AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.ANTI_HIJACK_RESULT, jSONObject, oxVarHj);
        }
        if (com.ss.android.downloadlib.utils.hj.b()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.hj;
            long jHj = com.ss.android.downloadlib.utils.hj.hj();
            if (jCurrentTimeMillis < com.ss.android.downloadlib.utils.hj.h()) {
                long jH = com.ss.android.downloadlib.utils.hj.h() - jCurrentTimeMillis;
                jHj += jH;
                this.hj = System.currentTimeMillis() + jH;
            } else {
                this.hj = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.utils.je jeVar = this.b;
            jeVar.sendMessageDelayed(jeVar.obtainMessage(200, mbVar), jHj);
        }
    }

    private void mb(com.ss.android.downloadlib.addownload.model.mb mbVar, int i2) {
        if (x.jb() == null || x.jb().mb() || mbVar == null) {
            return;
        }
        if (2 == i2) {
            com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(mbVar.ox);
            JSONObject jSONObject = new JSONObject();
            int i3 = -1;
            try {
                jSONObject.put(EventConstants.ExtraJson.KEY_TYPE, "miui_silent_install");
                if (com.ss.android.downloadlib.utils.jb.hj(x.getContext(), mbVar.hj)) {
                    jSONObject.put(EventConstants.ExtraJson.KEY_MESSAGE, "miui_silent_install_succeed");
                    i3 = 4;
                } else {
                    jSONObject.put(EventConstants.ExtraJson.KEY_MESSAGE, "miui_silent_install_failed: has started service");
                    i3 = 5;
                }
            } catch (Exception unused) {
            }
            x.u().mb(null, new BaseException(i3, jSONObject.toString()), i3);
            AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.ANTI_HIJACK_RESULT, jSONObject, oxVarHj);
        }
        if (com.ss.android.downloadlib.utils.jb.hj(x.getContext(), mbVar.hj)) {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALLED, mbVar.ox);
            return;
        }
        if (!com.ss.android.downloadlib.utils.jb.mb(mbVar.ko)) {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALL_LOST, mbVar.ox);
        } else if (com.ss.android.downloadlib.addownload.mb.mb.mb().mb(mbVar.hj)) {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALL_CONFLICT, mbVar.ox);
        } else {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALL_START, mbVar.ox);
            com.ss.android.socialbase.appdownloader.hj.mb(x.getContext(), (int) mbVar.mb);
        }
    }

    @Override // com.ss.android.downloadlib.utils.je.mb
    public void mb(Message message) {
        if (message.what != 200) {
            return;
        }
        mb((com.ss.android.downloadlib.addownload.model.mb) message.obj, message.arg1);
    }
}
