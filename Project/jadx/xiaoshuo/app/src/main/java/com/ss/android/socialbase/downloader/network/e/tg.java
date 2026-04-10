package com.ss.android.socialbase.downloader.network.e;

import com.ss.android.socialbase.downloader.network.zk;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class tg implements zk {
    private final List<com.ss.android.socialbase.downloader.model.d> bf;
    private zk d;
    protected final Object e;
    private long ga;
    private boolean tg;
    private InputStream vn;

    @Override // com.ss.android.socialbase.downloader.network.p
    public int bf() throws IOException {
        zk zkVar = this.d;
        if (zkVar != null) {
            return zkVar.bf();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.p
    public void d() {
        zk zkVar = this.d;
        if (zkVar != null) {
            zkVar.d();
        }
    }

    public boolean e(int i) {
        return i >= 200 && i < 300;
    }

    public void ga() throws InterruptedException {
        synchronized (this.e) {
            if (this.tg && this.d == null) {
                this.e.wait();
            }
        }
    }

    public boolean p() {
        try {
            zk zkVar = this.d;
            if (zkVar != null) {
                return e(zkVar.bf());
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.zk
    public void tg() {
        zk zkVar = this.d;
        if (zkVar != null) {
            zkVar.tg();
        }
    }

    public boolean v() {
        return System.currentTimeMillis() - this.ga < bf.e;
    }

    public List<com.ss.android.socialbase.downloader.model.d> vn() {
        return this.bf;
    }

    @Override // com.ss.android.socialbase.downloader.network.zk
    public InputStream e() throws IOException {
        InputStream inputStream = this.vn;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.p
    public String e(String str) {
        zk zkVar = this.d;
        if (zkVar != null) {
            return zkVar.e(str);
        }
        return null;
    }
}
