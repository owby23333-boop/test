package com.kingsoft.iciba.sdk2;

import com.kingsoft.iciba.sdk2.interfaces.IKSCibaQueryResult;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpPost;

/* JADX INFO: loaded from: classes7.dex */
final class f implements Runnable {
    private ArrayList A;
    private String w;
    private HttpPost x;
    private IKSCibaQueryResult y;
    private d z;

    public f(d dVar, String str, HttpPost httpPost, ArrayList arrayList, IKSCibaQueryResult iKSCibaQueryResult) {
        this.z = dVar;
        this.w = str;
        this.x = httpPost;
        this.A = arrayList;
        this.y = iKSCibaQueryResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.a(this.z)) {
            d.a(this.z).add(new g(this.z, this.w, this.x, this.A, this.y));
            d.a(this.z).notify();
        }
    }
}
