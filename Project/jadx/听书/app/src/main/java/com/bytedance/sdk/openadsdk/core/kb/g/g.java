package com.bytedance.sdk.openadsdk.core.kb.g;

import android.os.Looper;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.q;

/* JADX INFO: loaded from: classes2.dex */
public class g extends fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1230a;
    private long dl;
    private com.bytedance.sdk.openadsdk.core.kb.g.z g;
    private String gc;
    private String m;
    private String z;

    public g(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.g == null) {
        }
        String str = this.z;
        str.hashCode();
        switch (str) {
            case "onIdle":
                this.g.z();
                break;
            case "onInstalled":
                this.g.z(this.gc, this.m);
                break;
            case "onDownloadActive":
                this.g.z(this.dl, this.f1230a, this.gc, this.m);
                break;
            case "onDownloadFailed":
                this.g.dl(this.dl, this.f1230a, this.gc, this.m);
                break;
            case "onDownloadPaused":
                this.g.g(this.dl, this.f1230a, this.gc, this.m);
                break;
            case "onDownloadFinished":
                this.g.z(this.dl, this.gc, this.m);
                break;
        }
    }

    static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1231a;
        private long dl;
        private long g;
        private String gc;
        private com.bytedance.sdk.openadsdk.core.kb.g.z m;
        private String z;

        z() {
        }

        public z z(String str) {
            this.z = str;
            return this;
        }

        public z z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
            this.m = zVar;
            return this;
        }

        public z z(long j) {
            this.g = j;
            return this;
        }

        public z g(long j) {
            this.dl = j;
            return this;
        }

        public z g(String str) {
            this.f1231a = str;
            return this;
        }

        public z dl(String str) {
            this.gc = str;
            return this;
        }

        public void z() {
            g gVar = new g("tt_csj_download_thread");
            gVar.m = this.gc;
            gVar.gc = this.f1231a;
            gVar.f1230a = this.dl;
            gVar.dl = this.g;
            gVar.z = this.z;
            gVar.g = this.m;
            g.g(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            q.m().post(runnable);
        } else {
            runnable.run();
        }
    }
}
