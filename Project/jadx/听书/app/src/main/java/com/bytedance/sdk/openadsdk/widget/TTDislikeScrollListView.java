package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.core.dislike.z.g;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;

/* JADX INFO: loaded from: classes2.dex */
public class TTDislikeScrollListView extends ListView {
    private AdapterView.OnItemClickListener dl;
    private AdapterView.OnItemClickListener g;
    private g z;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.dl = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeScrollListView.this.getAdapter() != null && TTDislikeScrollListView.this.getAdapter().getItem(i) != null && (TTDislikeScrollListView.this.getAdapter().getItem(i) instanceof m)) {
                    m mVar = (m) TTDislikeScrollListView.this.getAdapter().getItem(i);
                    if (mVar.m()) {
                        return;
                    }
                    if (TTDislikeScrollListView.this.g != null) {
                        TTDislikeScrollListView.this.g.onItemClick(adapterView, view, i, j);
                    }
                    if (TTDislikeScrollListView.this.z != null) {
                        TTDislikeScrollListView.this.z.z(mVar);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        z();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void z() {
        super.setOnItemClickListener(this.dl);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.g = onItemClickListener;
    }

    public void setDislikeController(g gVar) {
        this.z = gVar;
    }
}
