package com.kingsoft.iciba.sdk2;

import com.kingsoft.iciba.sdk2.interfaces.IKSCibaQueryResult;
import org.apache.http.client.methods.HttpPost;

/* JADX INFO: loaded from: classes7.dex */
final class e implements Runnable {
    private String w;
    private HttpPost x;
    private IKSCibaQueryResult y;
    private d z;

    public e(d dVar, String str, HttpPost httpPost, IKSCibaQueryResult iKSCibaQueryResult) {
        this.z = dVar;
        this.w = str;
        this.x = httpPost;
        this.y = iKSCibaQueryResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.a(this.z)) {
            d.a(this.z).add(new g(this.z, this.w, this.x, null, this.y));
            d.a(this.z).notify();
        }
    }
}
