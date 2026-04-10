package com.amgcyo.cuttadon.b.d;

import android.view.View;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.adapter.holder.MkAutoKeyIemHolder;
import com.amgcyo.cuttadon.api.entity.other.MkAutoKeyword;
import com.fatcatfat.io.R;
import me.jessyan.art.base.c;
import me.jessyan.art.base.d;

/* JADX INFO: compiled from: MkAutoCompleteAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends d<MkAutoKeyword> {
    @Override // me.jessyan.art.base.d
    public int a(int i2) {
        return R.layout.item_auto_complete_list;
    }

    @Override // me.jessyan.art.base.d
    @NonNull
    public c<MkAutoKeyword> a(@NonNull View view, int i2) {
        return new MkAutoKeyIemHolder(view);
    }
}
