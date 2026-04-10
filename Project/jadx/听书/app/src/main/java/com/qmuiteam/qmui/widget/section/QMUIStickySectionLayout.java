package com.qmuiteam.qmui.widget.section;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIStickySectionLayout extends QMUIFrameLayout implements QMUIStickySectionAdapter.ViewCallback {
    private List<DrawDecoration> mDrawDecorations;
    private Runnable mPendingScrollAction;
    private RecyclerView mRecyclerView;
    private QMUIStickySectionItemDecoration mStickySectionItemDecoration;
    private int mStickySectionViewHeight;
    private QMUIFrameLayout mStickySectionWrapView;

    public interface DrawDecoration {
        void onDraw(Canvas canvas, QMUIStickySectionLayout qMUIStickySectionLayout);

        void onDrawOver(Canvas canvas, QMUIStickySectionLayout qMUIStickySectionLayout);
    }

    public interface StickySectionWrapViewConfig {
        void config(QMUIFrameLayout qMUIFrameLayout);
    }

    public QMUIStickySectionLayout(Context context) {
        this(context, null);
    }

    public QMUIStickySectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIStickySectionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStickySectionViewHeight = -1;
        this.mPendingScrollAction = null;
        this.mStickySectionWrapView = new QMUIFrameLayout(context);
        RecyclerView recyclerView = new RecyclerView(context);
        this.mRecyclerView = recyclerView;
        addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        addView(this.mStickySectionWrapView, new FrameLayout.LayoutParams(-1, -2));
        this.mStickySectionWrapView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                QMUIStickySectionLayout.this.mStickySectionViewHeight = i5 - i3;
                if (QMUIStickySectionLayout.this.mStickySectionViewHeight <= 0 || QMUIStickySectionLayout.this.mPendingScrollAction == null) {
                    return;
                }
                QMUIStickySectionLayout.this.mPendingScrollAction.run();
                QMUIStickySectionLayout.this.mPendingScrollAction = null;
            }
        });
    }

    public void addDrawDecoration(DrawDecoration drawDecoration) {
        if (this.mDrawDecorations == null) {
            this.mDrawDecorations = new ArrayList();
        }
        this.mDrawDecorations.add(drawDecoration);
    }

    public void removeDrawDecoration(DrawDecoration drawDecoration) {
        List<DrawDecoration> list = this.mDrawDecorations;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mDrawDecorations.remove(drawDecoration);
    }

    public void configStickySectionWrapView(StickySectionWrapViewConfig stickySectionWrapViewConfig) {
        if (stickySectionWrapViewConfig != null) {
            stickySectionWrapViewConfig.config(this.mStickySectionWrapView);
        }
    }

    public QMUIFrameLayout getStickySectionWrapView() {
        return this.mStickySectionWrapView;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public View getStickySectionView() {
        if (this.mStickySectionWrapView.getVisibility() != 0 || this.mStickySectionWrapView.getChildCount() == 0) {
            return null;
        }
        return this.mStickySectionWrapView.getChildAt(0);
    }

    public int getStickyHeaderPosition() {
        QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration = this.mStickySectionItemDecoration;
        if (qMUIStickySectionItemDecoration == null) {
            return -1;
        }
        return qMUIStickySectionItemDecoration.getStickyHeaderViewPosition();
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mRecyclerView.setLayoutManager(layoutManager);
    }

    public <H extends QMUISection.Model<H>, T extends QMUISection.Model<T>, VH extends QMUIStickySectionAdapter.ViewHolder> void setAdapter(QMUIStickySectionAdapter<H, T, VH> qMUIStickySectionAdapter) {
        setAdapter(qMUIStickySectionAdapter, true);
    }

    public <H extends QMUISection.Model<H>, T extends QMUISection.Model<T>, VH extends QMUIStickySectionAdapter.ViewHolder> void setAdapter(final QMUIStickySectionAdapter<H, T, VH> qMUIStickySectionAdapter, boolean z) {
        if (z) {
            QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration = new QMUIStickySectionItemDecoration(this.mStickySectionWrapView, new QMUIStickySectionItemDecoration.Callback<VH>() { // from class: com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout.2
                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void onHeaderVisibilityChanged(boolean z2) {
                }

                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public int getRelativeStickyItemPosition(int i) {
                    return qMUIStickySectionAdapter.getRelativeStickyPosition(i);
                }

                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public boolean isHeaderItem(int i) {
                    return qMUIStickySectionAdapter.getItemViewType(i) == 0;
                }

                /* JADX WARN: Incorrect return type in method signature: (Landroid/view/ViewGroup;I)TVH; */
                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public QMUIStickySectionAdapter.ViewHolder createViewHolder(ViewGroup viewGroup, int i) {
                    return (QMUIStickySectionAdapter.ViewHolder) qMUIStickySectionAdapter.createViewHolder(viewGroup, i);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;I)V */
                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void bindViewHolder(QMUIStickySectionAdapter.ViewHolder viewHolder, int i) {
                    qMUIStickySectionAdapter.bindViewHolder(viewHolder, i);
                }

                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public int getItemViewType(int i) {
                    return qMUIStickySectionAdapter.getItemViewType(i);
                }

                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
                    qMUIStickySectionAdapter.registerAdapterDataObserver(adapterDataObserver);
                }

                @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void invalidate() {
                    QMUIStickySectionLayout.this.mRecyclerView.invalidate();
                }
            });
            this.mStickySectionItemDecoration = qMUIStickySectionItemDecoration;
            this.mRecyclerView.addItemDecoration(qMUIStickySectionItemDecoration);
        }
        qMUIStickySectionAdapter.setViewCallback(this);
        this.mRecyclerView.setAdapter(qMUIStickySectionAdapter);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mStickySectionItemDecoration != null) {
            QMUIFrameLayout qMUIFrameLayout = this.mStickySectionWrapView;
            qMUIFrameLayout.layout(qMUIFrameLayout.getLeft(), this.mStickySectionItemDecoration.getTargetTop(), this.mStickySectionWrapView.getRight(), this.mStickySectionItemDecoration.getTargetTop() + this.mStickySectionWrapView.getHeight());
        }
    }

    @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback
    public void scrollToPosition(final int i, boolean z, final boolean z2) {
        int height;
        this.mPendingScrollAction = null;
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter == null || i < 0 || i >= adapter.getItemCount()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (z) {
                height = 0;
            } else {
                if (this.mStickySectionViewHeight <= 0) {
                    this.mPendingScrollAction = new Runnable() { // from class: com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            QMUIStickySectionLayout.this.scrollToPosition(i, false, z2);
                        }
                    };
                }
                height = this.mStickySectionWrapView.getHeight();
            }
            if (i < iFindFirstCompletelyVisibleItemPosition + 1 || i > iFindLastCompletelyVisibleItemPosition || z2) {
                linearLayoutManager.scrollToPositionWithOffset(i, height);
                return;
            }
            return;
        }
        this.mRecyclerView.scrollToPosition(i);
    }

    @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback
    public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int i) {
        return this.mRecyclerView.findViewHolderForAdapterPosition(i);
    }

    @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback
    public void requestChildFocus(View view) {
        this.mRecyclerView.requestChildFocus(view, null);
    }

    @Override // com.qmuiteam.qmui.layout.QMUIFrameLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        List<DrawDecoration> list = this.mDrawDecorations;
        if (list != null) {
            Iterator<DrawDecoration> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDraw(canvas, this);
            }
        }
        super.dispatchDraw(canvas);
        List<DrawDecoration> list2 = this.mDrawDecorations;
        if (list2 != null) {
            Iterator<DrawDecoration> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().onDrawOver(canvas, this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        List<DrawDecoration> list;
        super.onDescendantInvalidated(view, view2);
        if (view2 != this.mRecyclerView || (list = this.mDrawDecorations) == null || list.isEmpty()) {
            return;
        }
        invalidate();
    }
}
