package com.ss.android.downloadlib.addownload.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h implements com.ss.android.downloadad.api.mb.mb {
    public DownloadEventConfig b;
    public DownloadController hj;
    public long mb;
    public DownloadModel ox;

    public h() {
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean b() {
        return this.ox.isAd();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadEventConfig df() {
        return this.b;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean e() {
        return this.hj.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadModel g() {
        return this.ox;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int gm() {
        return this.b.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String h() {
        return this.ox.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String hj() {
        return this.ox.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject io() {
        return this.b.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject jb() {
        return this.b.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public long je() {
        return this.ox.getExtraValue();
    }

    public boolean jq() {
        if (on()) {
            return false;
        }
        if (!this.ox.isAd()) {
            return this.ox instanceof AdDownloadModel;
        }
        DownloadModel downloadModel = this.ox;
        return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.b instanceof AdDownloadEventConfig) && (this.hj instanceof AdDownloadController);
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject ko() {
        return this.ox.getExtra();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject l() {
        return this.ox.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public Object lc() {
        return this.b.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String lz() {
        return this.b.getRefer();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int m() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String mb() {
        return this.ox.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean nk() {
        return this.b.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public List<String> o() {
        return this.ox.getClickTrackUrl();
    }

    public boolean on() {
        DownloadModel downloadModel;
        if (this.mb == 0 || (downloadModel = this.ox) == null || this.b == null || this.hj == null) {
            return true;
        }
        return downloadModel.isAd() && this.mb <= 0;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public long ox() {
        return this.ox.getId();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadController r() {
        return this.hj;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String u() {
        if (this.ox.getDeepLink() != null) {
            return this.ox.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int ww() {
        if (this.hj.getDownloadMode() == 2) {
            return 2;
        }
        return this.ox.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String x() {
        return this.b.getClickButtonTag();
    }

    public h(long j2, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.mb = j2;
        this.ox = downloadModel;
        this.b = downloadEventConfig;
        this.hj = downloadController;
    }
}
