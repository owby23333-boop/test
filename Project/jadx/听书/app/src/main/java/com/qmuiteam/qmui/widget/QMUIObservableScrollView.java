package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIObservableScrollView extends ScrollView {
    private List<OnScrollChangedListener> mOnScrollChangedListeners;
    private int mScrollOffset;

    public interface OnScrollChangedListener {
        void onScrollChanged(QMUIObservableScrollView qMUIObservableScrollView, int i, int i2, int i3, int i4);
    }

    public QMUIObservableScrollView(Context context) {
        super(context);
        this.mScrollOffset = 0;
    }

    public QMUIObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollOffset = 0;
    }

    public QMUIObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollOffset = 0;
    }

    public void addOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        if (this.mOnScrollChangedListeners == null) {
            this.mOnScrollChangedListeners = new ArrayList();
        }
        if (this.mOnScrollChangedListeners.contains(onScrollChangedListener)) {
            return;
        }
        this.mOnScrollChangedListeners.add(onScrollChangedListener);
    }

    public void removeOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        List<OnScrollChangedListener> list = this.mOnScrollChangedListeners;
        if (list == null) {
            return;
        }
        list.remove(onScrollChangedListener);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mScrollOffset = i2;
        List<OnScrollChangedListener> list = this.mOnScrollChangedListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<OnScrollChangedListener> it = this.mOnScrollChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollChanged(this, i, i2, i3, i4);
        }
    }

    public int getScrollOffset() {
        return this.mScrollOffset;
    }
}
