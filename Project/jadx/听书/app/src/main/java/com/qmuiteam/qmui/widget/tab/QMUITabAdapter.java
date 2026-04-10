package com.qmuiteam.qmui.widget.tab;

import android.view.ViewGroup;
import com.qmuiteam.qmui.widget.QMUIItemViewsAdapter;
import com.qmuiteam.qmui.widget.tab.QMUITabView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITabAdapter extends QMUIItemViewsAdapter<QMUITab, QMUITabView> implements QMUITabView.Callback {
    private QMUIBasicTabSegment mTabSegment;

    @Override // com.qmuiteam.qmui.widget.tab.QMUITabView.Callback
    public void onLongClick(QMUITabView qMUITabView) {
    }

    public QMUITabAdapter(QMUIBasicTabSegment qMUIBasicTabSegment, ViewGroup viewGroup) {
        super(viewGroup);
        this.mTabSegment = qMUIBasicTabSegment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.QMUIItemViewsAdapter
    public QMUITabView createView(ViewGroup viewGroup) {
        return new QMUITabView(viewGroup.getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.QMUIItemViewsAdapter
    public final void bind(QMUITab qMUITab, QMUITabView qMUITabView, int i) {
        onBindTab(qMUITab, qMUITabView, i);
        qMUITabView.setCallback(this);
        if (qMUITabView.getSelectFraction() != 0.0f || qMUITabView.isSelected()) {
            qMUITabView.setSelected(false);
            qMUITabView.setSelectFraction(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.QMUIItemViewsAdapter
    public void onViewRecycled(QMUITabView qMUITabView) {
        qMUITabView.setSelected(false);
        qMUITabView.setSelectFraction(0.0f);
        qMUITabView.setCallback(null);
    }

    protected void onBindTab(QMUITab qMUITab, QMUITabView qMUITabView, int i) {
        qMUITabView.bind(qMUITab);
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUITabView.Callback
    public void onClick(QMUITabView qMUITabView) {
        this.mTabSegment.onClickTab(qMUITabView, getViews().indexOf(qMUITabView));
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUITabView.Callback
    public void onDoubleClick(QMUITabView qMUITabView) {
        this.mTabSegment.onDoubleClick(getViews().indexOf(qMUITabView));
    }
}
