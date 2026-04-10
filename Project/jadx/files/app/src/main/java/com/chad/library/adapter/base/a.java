package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import anet.channel.util.ErrorConstant;
import com.chad.library.adapter.base.b;
import com.chad.library.adapter.base.d.b;
import java.util.List;

/* JADX INFO: compiled from: BaseMultiItemQuickAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T extends com.chad.library.adapter.base.d.b, K extends b> extends BaseQuickAdapter<T, K> {
    private SparseIntArray K;

    public a(List<T> list) {
        super(list);
    }

    private int e(int i2) {
        return this.K.get(i2, ErrorConstant.ERROR_IO_EXCEPTION);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int a(int i2) {
        T t2 = this.f14738z.get(i2);
        if (t2 != null) {
            return t2.getItemType();
        }
        return -255;
    }

    protected void b(int i2, @LayoutRes int i3) {
        if (this.K == null) {
            this.K = new SparseIntArray();
        }
        this.K.put(i2, i3);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected K d(ViewGroup viewGroup, int i2) {
        return a(viewGroup, e(i2));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void d(@IntRange(from = 0) int i2) {
        List<T> list = this.f14738z;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return;
        }
        T t2 = this.f14738z.get(i2);
        if (t2 instanceof com.chad.library.adapter.base.d.a) {
            a((com.chad.library.adapter.base.d.a) t2, i2);
        }
        a((com.chad.library.adapter.base.d.b) t2);
        super.d(i2);
    }

    protected void a(com.chad.library.adapter.base.d.a aVar, int i2) {
        List listB;
        if (!aVar.a() || (listB = aVar.b()) == null || listB.size() == 0) {
            return;
        }
        int size = listB.size();
        for (int i3 = 0; i3 < size; i3++) {
            d(i2 + 1);
        }
    }

    protected void a(T t2) {
        com.chad.library.adapter.base.d.a aVar;
        int iB = b(t2);
        if (iB < 0 || (aVar = (com.chad.library.adapter.base.d.a) this.f14738z.get(iB)) == t2) {
            return;
        }
        aVar.b().remove(t2);
    }
}
