package com.amgcyo.cuttadon.b.c;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import com.umeng.message.proguard.ad;
import java.util.List;

/* JADX INFO: compiled from: MkBookSourceMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends BaseQuickAdapter<MkSiteBean, com.chad.library.adapter.base.b> {
    private String K;
    private int L;
    private int M;
    private int N;
    private com.amgcyo.cuttadon.utils.otherutils.k O;

    public q(List<MkSiteBean> list, String str) {
        super(R.layout.item_book_source_list, list);
        this.K = str;
        this.L = MkApplication.getAppContext().getResources().getColor(R.color.colorPrimary);
        this.M = com.amgcyo.cuttadon.f.o.b(R.color.text_33);
        this.N = com.amgcyo.cuttadon.f.o.b(R.color.a2a9b2);
    }

    private void b(com.chad.library.adapter.base.b bVar, MkSiteBean mkSiteBean) {
        String str;
        int adapterPosition = bVar.getAdapterPosition();
        TextView textView = (TextView) bVar.a(R.id.tv_sourceName);
        TextView textView2 = (TextView) bVar.a(R.id.tv_first);
        ImageView imageView = (ImageView) bVar.a(R.id.img_right);
        TextView textView3 = (TextView) bVar.a(R.id.tv_choose);
        TextView textView4 = (TextView) bVar.a(R.id.tv_update);
        TextView textView5 = (TextView) bVar.a(R.id.tv_ischoice);
        TextView textView6 = (TextView) bVar.a(R.id.tv_time);
        SpannableString spannableString = new SpannableString(ad.f20405r + mkSiteBean.getChoose() + "的人选择)");
        com.amgcyo.cuttadon.utils.otherutils.k kVar = this.O;
        if (kVar != null) {
            this.L = kVar.f4402f;
            textView.setTextColor(kVar.a);
            textView4.setTextColor(this.O.b);
            textView3.setTextColor(this.O.b);
            imageView.setColorFilter(this.O.b);
        } else {
            textView.setTextColor(this.M);
            textView4.setTextColor(this.N);
            textView3.setTextColor(this.N);
            imageView.setColorFilter(this.N);
        }
        textView5.setTextColor(this.L);
        spannableString.setSpan(new ForegroundColorSpan(this.L), 1, mkSiteBean.getChoose().length() + 1, 33);
        textView3.setText(spannableString);
        textView6.setText(String.format("%s(", mkSiteBean.getShow_updated_at()));
        textView6.setVisibility(8);
        textView.setText(mkSiteBean.getSite_name());
        int i2 = SupportMenu.CATEGORY_MASK;
        int[] iArr = com.amgcyo.cuttadon.utils.otherutils.l.a;
        if (adapterPosition < iArr.length) {
            i2 = iArr[adapterPosition];
        }
        GradientDrawable gradientDrawableA = com.amgcyo.cuttadon.f.o.a(-1, -1, 1, (String) null, i2);
        textView2.setText(mkSiteBean.getSite_name().substring(0, 1));
        textView2.setBackground(gradientDrawableA);
        if (mkSiteBean.getLast_chapter_name() == null) {
            str = "暂无最新章节";
        } else {
            str = mkSiteBean.getShow_updated_at() + "更新至：" + mkSiteBean.getLast_chapter_name();
        }
        textView4.setText(str);
        if (TextUtils.isEmpty(this.K) || !this.K.equals(mkSiteBean.getSite_id())) {
            textView5.setVisibility(4);
        } else {
            textView5.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, MkSiteBean mkSiteBean) {
        b(bVar, mkSiteBean);
    }

    public q(List<MkSiteBean> list, String str, com.amgcyo.cuttadon.utils.otherutils.k kVar) {
        super(R.layout.item_book_source_list, list);
        this.K = str;
        this.O = kVar;
        this.L = MkApplication.getAppContext().getResources().getColor(R.color.colorPrimary);
        this.M = com.amgcyo.cuttadon.f.o.b(R.color.text_33);
        this.N = com.amgcyo.cuttadon.f.o.b(R.color.a2a9b2);
    }
}
