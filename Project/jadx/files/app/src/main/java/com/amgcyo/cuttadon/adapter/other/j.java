package com.amgcyo.cuttadon.adapter.other;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.comic.SearchHotkeyBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkHotKeyWordsSearchAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends BaseQuickAdapter<SearchHotkeyBean, com.chad.library.adapter.base.b> {
    public j() {
        super(R.layout.item_search);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, SearchHotkeyBean searchHotkeyBean) {
        TextView textView = (TextView) bVar.a(R.id.tv_position);
        TextView textView2 = (TextView) bVar.a(R.id.tv_title);
        int adapterPosition = bVar.getAdapterPosition() + 1;
        if (adapterPosition == 1) {
            textView.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        } else if (adapterPosition == 2) {
            textView.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.color_2));
        } else if (adapterPosition == 3) {
            textView.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.color_3));
        } else {
            textView.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.color_CCCCCC));
        }
        textView2.setText(searchHotkeyBean.getKeyWord());
        textView.setText(String.valueOf(adapterPosition));
    }
}
