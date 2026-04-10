package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class b implements DownloadEventConfig {
    private String b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17932e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f17933h;
    private String hj;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private String f17934io;
    private String jb;
    private Object je;
    private String ko;
    private boolean lc;
    private String lz;
    private String mb;
    private boolean nk;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f17935o;
    private boolean ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f17936u;
    private String ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f17937x;

    public static final class mb {
        private String b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f17938e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f17939h;
        private String hj;

        /* JADX INFO: renamed from: io, reason: collision with root package name */
        private String f17940io;
        private String jb;
        private Object je;
        private String ko;
        private boolean lc;
        private String lz;
        private String mb;
        private boolean nk;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f17941o;
        private boolean ox;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private String f17942u;
        private String ww;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private String f17943x;

        public b mb() {
            return new b(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.mb;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f17936u;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.ko;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f17933h;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.hj;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.je;
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
        return this.f17932e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f17937x;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.ox;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.nk;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public b() {
    }

    private b(mb mbVar) {
        this.mb = mbVar.mb;
        this.ox = mbVar.ox;
        this.b = mbVar.b;
        this.hj = mbVar.hj;
        this.f17933h = mbVar.f17939h;
        this.f17936u = mbVar.f17942u;
        this.ko = mbVar.ko;
        this.ww = mbVar.ww;
        this.lz = mbVar.lz;
        this.f17937x = mbVar.f17943x;
        this.jb = mbVar.jb;
        this.je = mbVar.je;
        this.nk = mbVar.nk;
        this.f17935o = mbVar.f17941o;
        this.lc = mbVar.lc;
        this.f17934io = mbVar.f17940io;
        this.f17932e = mbVar.f17938e;
    }
}
