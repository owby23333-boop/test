package com.amgcyo.cuttadon.b.c;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.bookcity.BaseMaleFemaleBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkLeftAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends BaseQuickAdapter<BaseMaleFemaleBean, com.chad.library.adapter.base.b> {
    private String K;

    public u() {
        super(R.layout.book_rank_left_list);
    }

    public void c(String str) {
        this.K = str;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, BaseMaleFemaleBean baseMaleFemaleBean) {
        TextView textView = (TextView) bVar.a(R.id.left_txt_title);
        if (TextUtils.isEmpty(this.K) || !this.K.equals(baseMaleFemaleBean.getRank_id())) {
            textView.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.color_848484));
        } else {
            textView.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        }
        textView.setText(baseMaleFemaleBean.getRank_title());
    }
}
