package com.qmuiteam.qmui.widget.section;

import android.view.View;
import android.view.ViewGroup;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUISection.Model;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIDefaultStickySectionAdapter<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>> extends QMUIStickySectionAdapter<H, T, QMUIStickySectionAdapter.ViewHolder> {
    public QMUIDefaultStickySectionAdapter() {
    }

    public QMUIDefaultStickySectionAdapter(boolean z) {
        super(z);
    }

    @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter
    protected QMUIStickySectionAdapter.ViewHolder onCreateSectionLoadingViewHolder(ViewGroup viewGroup) {
        return new QMUIStickySectionAdapter.ViewHolder(new View(viewGroup.getContext()));
    }

    @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter
    protected QMUIStickySectionAdapter.ViewHolder onCreateCustomItemViewHolder(ViewGroup viewGroup, int i) {
        return new QMUIStickySectionAdapter.ViewHolder(new View(viewGroup.getContext()));
    }
}
