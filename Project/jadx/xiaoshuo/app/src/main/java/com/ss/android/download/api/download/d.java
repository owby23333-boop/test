package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class d implements DownloadEventConfig {
    private boolean bf;
    private boolean bh;
    private String d;
    private String e;
    private String ga;
    private String l;
    private String m;
    private String p;
    private boolean s;
    private boolean t;
    private String tg;
    private String v;
    private String vn;
    private String w;
    private String wu;
    private Object xu;
    private String zk;

    public static final class e {
        private boolean bf;
        private boolean bh;
        private String d;
        private String e;
        private String ga;
        private String l;
        private String m;
        private String p;
        private boolean s;
        private boolean t;
        private String tg;
        private String v;
        private String vn;
        private String w;
        private String wu;
        private Object xu;
        private String zk;

        public d e() {
            return new d(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.vn;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.p;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.d;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.ga;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.tg;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.xu;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.l;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.bf;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.bh;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public d() {
    }

    private d(e eVar) {
        this.e = eVar.e;
        this.bf = eVar.bf;
        this.d = eVar.d;
        this.tg = eVar.tg;
        this.ga = eVar.ga;
        this.vn = eVar.vn;
        this.p = eVar.p;
        this.v = eVar.v;
        this.zk = eVar.zk;
        this.m = eVar.m;
        this.wu = eVar.wu;
        this.xu = eVar.xu;
        this.bh = eVar.bh;
        this.t = eVar.t;
        this.s = eVar.s;
        this.w = eVar.w;
        this.l = eVar.l;
    }
}
