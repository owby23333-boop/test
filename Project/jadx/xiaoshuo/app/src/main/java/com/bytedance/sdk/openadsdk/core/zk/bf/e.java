package com.bytedance.sdk.openadsdk.core.zk.bf;

import android.os.Looper;
import com.bytedance.sdk.component.zk.p;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.cv;

/* JADX INFO: loaded from: classes10.dex */
public class e extends p {
    private TTAppDownloadListener bf;
    private long d;
    private String e;
    private String ga;
    private long tg;
    private String vn;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.zk.bf.e$e, reason: collision with other inner class name */
    public static class C0174e {
        private long bf;
        private long d;
        private String e;
        private String ga;
        private String tg;
        private TTAppDownloadListener vn;

        public C0174e bf(long j) {
            this.d = j;
            return this;
        }

        public C0174e d(String str) {
            this.ga = str;
            return this;
        }

        public C0174e e(String str) {
            this.e = str;
            return this;
        }

        public C0174e bf(String str) {
            this.tg = str;
            return this;
        }

        public C0174e e(TTAppDownloadListener tTAppDownloadListener) {
            this.vn = tTAppDownloadListener;
            return this;
        }

        public C0174e e(long j) {
            this.bf = j;
            return this;
        }

        public void e() {
            e eVar = new e("tt_csj_download_thread");
            eVar.vn = this.ga;
            eVar.ga = this.tg;
            eVar.tg = this.d;
            eVar.d = this.bf;
            eVar.e = this.e;
            eVar.bf = this.vn;
            e.bf(eVar);
        }
    }

    public e(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bf == null) {
        }
        String str = this.e;
        str.hashCode();
        switch (str) {
            case "onIdle":
                this.bf.onIdle();
                break;
            case "onInstalled":
                this.bf.onInstalled(this.ga, this.vn);
                break;
            case "onDownloadActive":
                this.bf.onDownloadActive(this.d, this.tg, this.ga, this.vn);
                break;
            case "onDownloadFailed":
                this.bf.onDownloadFailed(this.d, this.tg, this.ga, this.vn);
                break;
            case "onDownloadPaused":
                this.bf.onDownloadPaused(this.d, this.tg, this.ga, this.vn);
                break;
            case "onDownloadFinished":
                this.bf.onDownloadFinished(this.d, this.ga, this.vn);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bf(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            cv.p().post(runnable);
        } else {
            runnable.run();
        }
    }
}
