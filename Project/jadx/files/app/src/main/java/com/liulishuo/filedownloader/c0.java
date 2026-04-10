package com.liulishuo.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: QueuesHandler.java */
/* JADX INFO: loaded from: classes3.dex */
class c0 implements w {
    private final SparseArray<Handler> a = new SparseArray<>();

    c0() {
    }

    @Override // com.liulishuo.filedownloader.w
    public void a(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.a.get(it.next().intValue()));
        }
    }

    @Override // com.liulishuo.filedownloader.w
    public void b() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            a(this.a.get(this.a.keyAt(i2)));
        }
    }

    @Override // com.liulishuo.filedownloader.w
    public int a() {
        return this.a.size();
    }

    private void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.liulishuo.filedownloader.w
    public boolean a(int i2) {
        return this.a.get(i2) != null;
    }

    private void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }
}
