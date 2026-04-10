package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bw;

/* JADX INFO: loaded from: classes2.dex */
class by extends Handler {
    final /* synthetic */ bw a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    by(bw bwVar, Looper looper) {
        super(looper);
        this.a = bwVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = message.getData().getString(bw.f12980n);
        bu buVar = (bu) message.getData().getParcelable(bw.f12979m);
        if (!bw.f12977k.equals(string)) {
            this.a.f12992z.a(bw.a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.a.a(false);
            if (this.a.A) {
                this.a.A = false;
                this.a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        bp bpVar = new bp(buVar.e(), this.a.f12991y, buVar);
        try {
            try {
                if (this.a.f12988u == bw.f12986t) {
                    bpVar.a();
                    bpVar.a(bw.f());
                    if (bw.f12982p != null) {
                        bw.f12982p.b = buVar.b();
                    }
                    this.a.l();
                    if (this.a.A) {
                        this.a.A = false;
                        this.a.a(this.a.p(), "load remote file just downloaded");
                    }
                } else {
                    this.a.a(bpVar);
                    bpVar.a(bw.f());
                    this.a.a(true);
                }
            } catch (bw.a e2) {
                String str = "download apk file failed: " + e2.toString();
                this.a.a(false);
                this.a.f12992z.a(bw.a, str);
            }
        } finally {
            bpVar.delete();
        }
    }
}
