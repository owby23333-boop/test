package com.bytedance.sdk.openadsdk.api.e;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadController;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e implements Bridge {
    private DownloadController e;

    public e(DownloadController downloadController) {
        this.e = downloadController;
    }

    public int bf() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    public boolean bh() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 223317) {
            if (valueSet == null) {
                return null;
            }
            bf(((Boolean) valueSet.objectValue(223323, Boolean.class)).booleanValue());
            return null;
        }
        switch (i) {
            case 223311:
                if (valueSet != null) {
                    e(((Integer) valueSet.objectValue(223320, Integer.class)).intValue());
                }
                break;
            case 223312:
                if (valueSet != null) {
                    bf(((Integer) valueSet.objectValue(223321, Integer.class)).intValue());
                }
                break;
            case 223313:
                if (valueSet != null) {
                    e(((Boolean) valueSet.objectValue(223322, Boolean.class)).booleanValue());
                }
                break;
        }
        return null;
    }

    public boolean d() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    public int e() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    public boolean ga() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    public JSONObject m() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    public Object p() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    public boolean s() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    public boolean t() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    public boolean tg() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    public boolean v() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bytedance.sdk.openadsdk.api.tg.e().e(223300, e()).e(223301, bf()).e(223302, d()).e(223303, tg()).e(223304, ga()).e(223305, vn()).e(223306, p()).e(223307, v()).e(223308, zk()).e(223309, m()).e(2233010, wu()).e(223309, m()).e(223314, xu()).e(223315, bh()).e(223316, t()).e(223318, s()).e(223319, w()).bf();
    }

    public int vn() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    public boolean w() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    public Object wu() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }

    public boolean xu() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    public int zk() {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    public void bf(int i) {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            downloadController.setLinkMode(i);
        }
    }

    public void e(int i) {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            downloadController.setDownloadMode(i);
        }
    }

    public void bf(boolean z) {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z);
        }
    }

    public void e(boolean z) {
        DownloadController downloadController = this.e;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z);
        }
    }
}
