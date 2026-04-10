package com.qmuiteam.qmui.widget;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIPagerAdapter extends PagerAdapter {
    private SparseArray<Object> mScrapItems = new SparseArray<>();

    public interface Action {
        boolean call(Object obj);
    }

    protected abstract void destroy(ViewGroup viewGroup, int i, Object obj);

    protected abstract Object hydrate(ViewGroup viewGroup, int i);

    protected abstract void populate(ViewGroup viewGroup, Object obj, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Object objHydrate = this.mScrapItems.get(i);
        if (objHydrate == null) {
            objHydrate = hydrate(viewGroup, i);
            this.mScrapItems.put(i, objHydrate);
        }
        populate(viewGroup, objHydrate, i);
        return objHydrate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        destroy(viewGroup, i, obj);
    }

    public void each(Action action) {
        int size = this.mScrapItems.size();
        for (int i = 0; i < size && !action.call(this.mScrapItems.valueAt(i)); i++) {
        }
    }
}
