package com.qmuiteam.qmui.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.qmuiteam.qmui.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIItemViewsAdapter<T, V extends View> {
    private Pools.Pool<V> mCachePool;
    private ViewGroup mParentView;
    private List<T> mItemData = new ArrayList();
    private List<V> mViews = new ArrayList();

    protected abstract void bind(T t, V v, int i);

    protected abstract V createView(ViewGroup viewGroup);

    protected void onViewRecycled(V v) {
    }

    public QMUIItemViewsAdapter(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    public void detach(int i) {
        int size = this.mViews.size();
        while (size > 0 && i > 0) {
            V vRemove = this.mViews.remove(size - 1);
            if (this.mCachePool == null) {
                this.mCachePool = new Pools.SimplePool(12);
            }
            Object tag = vRemove.getTag(R.id.qmui_view_can_not_cache_tag);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                try {
                    onViewRecycled(vRemove);
                    this.mCachePool.release(vRemove);
                } catch (Exception unused) {
                }
            }
            this.mParentView.removeView(vRemove);
            size--;
            i--;
        }
    }

    public void clear() {
        this.mItemData.clear();
        detach(this.mViews.size());
    }

    private V getView() {
        Pools.Pool<V> pool = this.mCachePool;
        V vAcquire = pool != null ? pool.acquire() : null;
        return vAcquire == null ? (V) createView(this.mParentView) : vAcquire;
    }

    public QMUIItemViewsAdapter<T, V> addItem(T t) {
        this.mItemData.add(t);
        return this;
    }

    public void setup() {
        int size = this.mItemData.size();
        int size2 = this.mViews.size();
        if (size2 > size) {
            detach(size2 - size);
        } else if (size2 < size) {
            for (int i = 0; i < size - size2; i++) {
                View view = getView();
                this.mParentView.addView(view);
                this.mViews.add((V) view);
            }
        }
        for (int i2 = 0; i2 < size; i2++) {
            bind(this.mItemData.get(i2), this.mViews.get(i2), i2);
        }
        this.mParentView.invalidate();
        this.mParentView.requestLayout();
    }

    public T getItem(int i) {
        List<T> list = this.mItemData;
        if (list != null && i >= 0 && i < list.size()) {
            return this.mItemData.get(i);
        }
        return null;
    }

    public void replaceItem(int i, T t) throws IllegalAccessException {
        if (i < this.mItemData.size() && i >= 0) {
            this.mItemData.set(i, t);
            return;
        }
        throw new IllegalAccessException("替换数据不存在");
    }

    public List<V> getViews() {
        return this.mViews;
    }

    public int getSize() {
        List<T> list = this.mItemData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
