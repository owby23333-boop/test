package com.amgcyo.cuttadon.adapter.other;

import android.view.View;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.adapter.holder.MkShelfSortIemHolder;
import com.amgcyo.cuttadon.api.entity.other.ShelfSortBean;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkShelfSortAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends me.jessyan.art.base.d<ShelfSortBean> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3094d;

    public m(List<ShelfSortBean> list, String str) {
        super(list);
        this.f3094d = str;
    }

    @Override // me.jessyan.art.base.d
    public int a(int i2) {
        return R.layout.item_shelf_sort;
    }

    @Override // me.jessyan.art.base.d
    @NonNull
    public me.jessyan.art.base.c<ShelfSortBean> a(@NonNull View view, int i2) {
        return new MkShelfSortIemHolder(view, this.f3094d);
    }
}
