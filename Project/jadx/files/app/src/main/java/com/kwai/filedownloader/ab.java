package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ab implements w {
    private final SparseArray<Handler> aEQ = new SparseArray<>();

    ab() {
    }

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.w
    public final void H(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.aEQ.get(it.next().intValue()));
        }
    }

    @Override // com.kwai.filedownloader.w
    public final void Hj() {
        for (int i2 = 0; i2 < this.aEQ.size(); i2++) {
            a(this.aEQ.get(this.aEQ.keyAt(i2)));
        }
    }

    @Override // com.kwai.filedownloader.w
    public final int Hk() {
        return this.aEQ.size();
    }

    @Override // com.kwai.filedownloader.w
    public final boolean cA(int i2) {
        return this.aEQ.get(i2) != null;
    }
}
