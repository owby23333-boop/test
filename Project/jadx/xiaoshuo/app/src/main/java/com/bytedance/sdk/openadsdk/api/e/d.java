package com.bytedance.sdk.openadsdk.api.e;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class d implements Bridge {
    private DownloadModel e;

    public d(DownloadModel downloadModel) {
        this.e = downloadModel;
    }

    public String a() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public IDownloadFileUriProvider b() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public List<String> bf() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public boolean bh() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public boolean bm() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public com.ss.android.download.api.model.tg bx() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 223417:
                f();
                return null;
            case 223419:
                dt();
                return null;
            case 223420:
                pe();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) e((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public int cv() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    public String d() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    public void dt() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public String e() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    public void f() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public DeepLink fy() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public String ga() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    public List<String> h() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public int hb() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    public boolean i() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public String j() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public JSONObject k() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public String l() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public String lc() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public Map<String, String> m() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public long p() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    public void pe() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public int q() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public boolean r() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public boolean rb() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    public int rm() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public String rt() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public boolean s() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public boolean t() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public long tg() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    public String uk() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    public String v() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bytedance.sdk.openadsdk.api.tg.e().e(223400, e()).e(223401, bf()).e(223402, d()).e(223403, tg()).e(223404, ga()).e(223405, vn()).e(223406, p()).e(223407, v()).e(223408, zk()).e(223409, m()).e(223410, wu()).e(223411, xu()).e(223412, bh()).e(223413, t()).e(223414, s()).e(223415, w()).e(223416, l()).e(223418, k()).e(223421, y()).e(223422, cv()).e(223423, wl()).e(223424, za()).e(223425, lc()).e(223426, a()).e(223427, uk()).e(223428, fy()).e(223429, h()).e(223430, x()).e(223431, hb()).e(223432, bx()).e(223433, bm()).e(223434, b()).e(223435, r()).e(223436, rm()).e(223437, q()).e(223438, rt()).e(223432, j()).e(223433, i()).e(223434, yl()).e(223435, rb()).bf();
    }

    public long vn() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public String w() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public String wl() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public boolean wu() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    public JSONObject x() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public boolean xu() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public boolean y() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    public boolean yl() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public boolean za() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public String zk() {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public DownloadModel e(String str) {
        DownloadModel downloadModel = this.e;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }
}
