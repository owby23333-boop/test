package com.amgcyo.cuttadon.b.d;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkSearchHistoryAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends BaseQuickAdapter<String, com.chad.library.adapter.base.b> {
    public b() {
        super(R.layout.item_search_history);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, String str) {
        ((TextView) bVar.a(R.id.tvAutoCompleteItem)).setText(str);
    }
}
