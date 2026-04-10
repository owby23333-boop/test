package com.amgcyo.cuttadon.adapter.other;

import android.content.Context;
import android.widget.TextView;
import com.amgcyo.cuttadon.adapter.other.k;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkNovelCatalogAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends k<MkCatalog> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3092w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3093x;

    public l(Context context, int i2) {
        super(context);
        this.f3090u = i2;
        this.f3091v = com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary);
        this.f3092w = com.amgcyo.cuttadon.f.o.b(R.color.text_33);
        this.f3093x = com.amgcyo.cuttadon.f.o.b(R.color.color_50_1A1A1A);
    }

    @Override // com.amgcyo.cuttadon.adapter.other.k
    public int a(int i2) {
        return R.layout.mk_ac_catalog;
    }

    public void b(int i2) {
        this.f3090u = i2;
        try {
            ((MkCatalog) this.f3088s.get(i2)).setCacheExists(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        notifyDataSetChanged();
    }

    @Override // com.amgcyo.cuttadon.adapter.other.k, android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return 0;
    }

    @Override // com.amgcyo.cuttadon.adapter.other.k
    public void a(int i2, int i3, MkCatalog mkCatalog, k.a aVar, boolean z2) {
        TextView textView = (TextView) aVar.a(R.id.directory_item_title);
        TextView textView2 = (TextView) aVar.a(R.id.textView_isFree);
        if (!mkCatalog.isIs_content()) {
            textView2.setText("章节缺失");
        } else if (mkCatalog.isCacheExists()) {
            textView2.setText("已缓存");
        } else {
            textView2.setText("");
        }
        if (mkCatalog.getCatalogId() == this.f3090u) {
            textView.setTextColor(this.f3091v);
        } else {
            textView.setTextColor(this.f3092w);
        }
        textView2.setTextColor(this.f3093x);
        textView.setText(mkCatalog.getName());
    }

    public void a(int i2, int i3) {
        this.f3091v = i2;
        this.f3092w = i3;
        this.f3093x = com.amgcyo.cuttadon.f.o.b(R.color.color_50_1A1A1A);
        if (com.amgcyo.cuttadon.utils.otherutils.g.h0()) {
            this.f3093x = i3;
        }
    }
}
