package com.amgcyo.cuttadon.adapter.comic;

import android.content.Context;
import android.widget.TextView;
import com.amgcyo.cuttadon.adapter.other.k;
import com.amgcyo.cuttadon.api.entity.comic.ZymkChapter;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkComicCatalogAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends k<ZymkChapter> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3075w;

    public b(Context context, int i2) {
        super(context);
        this.f3073u = i2;
        this.f3074v = o.b(R.color.colorPrimary);
        this.f3075w = o.b(R.color.color_535353);
    }

    @Override // com.amgcyo.cuttadon.adapter.other.k
    public int a(int i2) {
        return R.layout.mk_ac_catalog;
    }

    public void b(int i2) {
        this.f3073u = i2;
        try {
            ((ZymkChapter) this.f3088s.get(i2)).setCacheExists(true);
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
    public void a(int i2, int i3, ZymkChapter zymkChapter, k.a aVar, boolean z2) {
        TextView textView = (TextView) aVar.a(R.id.directory_item_title);
        TextView textView2 = (TextView) aVar.a(R.id.textView_isFree);
        if (zymkChapter.isIs_content()) {
            textView2.setText("");
        } else {
            textView2.setText("章节缺失");
        }
        if (zymkChapter.getIndex() == this.f3073u) {
            textView.setTextColor(this.f3074v);
        } else {
            textView.setTextColor(this.f3075w);
        }
        textView.setText(zymkChapter.getName());
    }
}
