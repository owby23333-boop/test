package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class ab implements w {
    private final SparseArray<Handler> amA = new SparseArray<>();

    ab() {
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void xO() {
        for (int i = 0; i < this.amA.size(); i++) {
            a(this.amA.get(this.amA.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void q(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.amA.get(it.next().intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int xP() {
        return this.amA.size();
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bA(int i) {
        return this.amA.get(i) != null;
    }

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }
}
