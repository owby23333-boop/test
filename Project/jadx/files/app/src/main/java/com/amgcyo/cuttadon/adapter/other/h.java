package com.amgcyo.cuttadon.adapter.other;

import android.view.View;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.adapter.holder.MkFattenNumHolder;
import com.amgcyo.cuttadon.api.entity.other.FattenChapterNum;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkFattenNumAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends me.jessyan.art.base.d<FattenChapterNum> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3087d;

    public h(List<FattenChapterNum> list, int i2) {
        super(list);
        this.f3087d = i2;
    }

    @Override // me.jessyan.art.base.d
    public int a(int i2) {
        return R.layout.item_shelf_sort;
    }

    @Override // me.jessyan.art.base.d
    @NonNull
    public me.jessyan.art.base.c<FattenChapterNum> a(@NonNull View view, int i2) {
        return new MkFattenNumHolder(view, this.f3087d);
    }
}
