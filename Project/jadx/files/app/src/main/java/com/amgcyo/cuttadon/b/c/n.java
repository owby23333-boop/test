package com.amgcyo.cuttadon.b.c;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkAreaCodeMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends com.chad.library.adapter.base.a<MkAreaCodeBean, com.chad.library.adapter.base.b> {
    public n(List<MkAreaCodeBean> list) {
        super(list);
        b(2, R.layout.item_areacode_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, MkAreaCodeBean mkAreaCodeBean) {
        TextView textView = (TextView) bVar.a(R.id.reg_code);
        TextView textView2 = (TextView) bVar.a(R.id.tv_key);
        TextView textView3 = (TextView) bVar.a(R.id.reg_from);
        textView.setText(String.format("+%s", mkAreaCodeBean.getTel()));
        textView3.setText(mkAreaCodeBean.getName());
        if (bVar.getLayoutPosition() == 0) {
            bVar.a(R.id.tv_key).setVisibility(0);
        } else {
            try {
                if (((MkAreaCodeBean) this.f14738z.get(bVar.getLayoutPosition())).getWord().equals(((MkAreaCodeBean) this.f14738z.get(bVar.getLayoutPosition() - 1)).getWord())) {
                    bVar.a(R.id.tv_key).setVisibility(8);
                } else {
                    bVar.a(R.id.tv_key).setVisibility(0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String word = mkAreaCodeBean.getWord();
        if ("#".equals(word)) {
            textView2.setText("常用国家/地区");
        } else {
            textView2.setText(word);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, MkAreaCodeBean mkAreaCodeBean) {
        if (bVar.getItemViewType() != 2) {
            return;
        }
        b(bVar, mkAreaCodeBean);
    }
}
