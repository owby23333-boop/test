package com.bytedance.sdk.openadsdk.api.e;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadEventConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class bf implements Bridge {
    private DownloadEventConfig e;

    public bf(DownloadEventConfig downloadEventConfig) {
        this.e = downloadEventConfig;
    }

    public String bf() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public boolean bh() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 223515) {
            if (valueSet == null) {
                return null;
            }
            e(((Integer) valueSet.objectValue(223516, Integer.class)).intValue());
            return null;
        }
        if (i != 223517 || valueSet == null) {
            return null;
        }
        e((String) valueSet.objectValue(223518, String.class));
        return null;
    }

    public String d() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    public String e() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    public String ga() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    public Object m() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public String p() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    public JSONObject s() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    public JSONObject t() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public String tg() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    public String v() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bytedance.sdk.openadsdk.api.tg.e().e(223500, e()).e(223501, bf()).e(223502, d()).e(223503, tg()).e(223504, ga()).e(223505, vn()).e(223506, p()).e(223507, v()).e(223508, zk()).e(223509, m()).e(223510, wu()).e(223511, xu()).e(223512, bh()).e(223513, t()).e(223514, s()).bf();
    }

    public String vn() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public int wu() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    public boolean xu() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public String zk() {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public void e(int i) {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i);
        }
    }

    public void e(String str) {
        DownloadEventConfig downloadEventConfig = this.e;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }
}
