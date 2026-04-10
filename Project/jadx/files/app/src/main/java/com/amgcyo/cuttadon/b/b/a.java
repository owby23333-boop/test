package com.amgcyo.cuttadon.b.b;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5TaskBean;
import com.amgcyo.cuttadon.f.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.b;
import com.fatcatfat.io.R;
import java.util.Locale;

/* JADX INFO: compiled from: MkFission5Adapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends BaseQuickAdapter<Fuli5TaskBean, b> {
    public a() {
        super(R.layout.item_task_fuli5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull b bVar, Fuli5TaskBean fuli5TaskBean) {
        TextView textView = (TextView) bVar.a(R.id.tv_task_title);
        TextView textView2 = (TextView) bVar.a(R.id.tv_task_action);
        TextView textView3 = (TextView) bVar.a(R.id.tv_task_integral);
        TextView textView4 = (TextView) bVar.a(R.id.tv_task_remark);
        ImageView imageView = (ImageView) bVar.a(R.id.img_type);
        textView.setText(fuli5TaskBean.getTitle());
        textView4.setText(fuli5TaskBean.getDesc());
        if (2 == fuli5TaskBean.getAmount_type()) {
            imageView.setImageResource(R.drawable.task_hb);
            textView3.setText(String.format(Locale.getDefault(), "%d元", Integer.valueOf(fuli5TaskBean.getAmount())));
            textView3.setTextColor(o.b(R.color.color_fa6725));
        } else if (1 == fuli5TaskBean.getAmount_type()) {
            imageView.setImageResource(R.drawable.task_jb);
            textView3.setText(String.format(Locale.getDefault(), "%d金币", Integer.valueOf(fuli5TaskBean.getAmount())));
            textView3.setTextColor(o.b(R.color.color_f3b757));
        }
        textView2.setText(fuli5TaskBean.getButton());
        bVar.a(R.id.tv_task_action);
    }
}
