package com.amgcyo.cuttadon.b.a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.cz.CzPayDataBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: CzPaydataAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends BaseQuickAdapter<CzPayDataBean, com.chad.library.adapter.base.b> {
    private int K;
    private int L;
    private int M;

    public b(@Nullable List<CzPayDataBean> list) {
        super(R.layout.cz_package_item, list);
        this.K = n.c(MkApplication.getAppContext());
        this.M = n.a(10.0f);
        this.L = 19;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, CzPayDataBean czPayDataBean) {
        RelativeLayout relativeLayout = (RelativeLayout) bVar.a(R.id.rl_cz_root);
        int i2 = this.L;
        o.a(relativeLayout, 0, i2, 0, i2);
        int size = getData().size();
        int i3 = size <= 3 ? (this.K - (this.M * (size + 1))) / size : this.M + (this.K / 3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.rightMargin = this.M;
        bVar.itemView.setLayoutParams(layoutParams);
        ((TextView) bVar.a(R.id.tv_month)).setText(czPayDataBean.getName());
        ((TextView) bVar.a(R.id.tv_remark)).setText(czPayDataBean.getRemark());
        ((TextView) bVar.a(R.id.tv_money)).setText(String.format("￥%s", czPayDataBean.getMoney()));
        ImageView imageView = (ImageView) bVar.a(R.id.iv_recommend);
        if (czPayDataBean.getRecommend() > 0) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) bVar.a(R.id.iv_selected);
        if (czPayDataBean.isSelected()) {
            imageView2.setVisibility(0);
            relativeLayout.setBackgroundResource(R.drawable.border_checked);
        } else {
            imageView2.setVisibility(8);
            relativeLayout.setBackgroundResource(R.drawable.border_unchecked);
        }
    }
}
