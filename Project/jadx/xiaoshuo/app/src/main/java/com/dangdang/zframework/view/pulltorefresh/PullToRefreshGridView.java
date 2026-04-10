package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.GridView;
import com.dangdang.zframework.R;
import com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase;

/* JADX INFO: loaded from: classes10.dex */
public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {

    public class InternalGridView extends GridView implements EmptyViewMethodAccessor {
        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.AdapterView, com.dangdang.zframework.view.pulltorefresh.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            PullToRefreshGridView.this.setEmptyView(view);
        }

        @Override // com.dangdang.zframework.view.pulltorefresh.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    public PullToRefreshGridView(Context context) {
        super(context);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshAdapterViewBase, android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return null;
    }

    public void init(PullToRefreshBase.OnRefreshListener onRefreshListener) {
        setOnRefreshListener(onRefreshListener);
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase
    public final GridView createRefreshableView(Context context, AttributeSet attributeSet) {
        InternalGridView internalGridView = new InternalGridView(context, attributeSet);
        internalGridView.setId(R.id.gridview);
        return internalGridView;
    }

    public PullToRefreshGridView(Context context, int i) {
        super(context, i);
    }
}
