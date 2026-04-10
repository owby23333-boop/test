package com.amgcyo.cuttadon.b.a;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.cz.CzChannelBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: CzChanneldataAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends BaseQuickAdapter<CzChannelBean, com.chad.library.adapter.base.b> {
    public a(@Nullable List<CzChannelBean> list) {
        super(R.layout.cz_channel_item, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, CzChannelBean czChannelBean) {
        TextView textView = (TextView) bVar.a(R.id.tv_channel_name);
        String pay_name = czChannelBean.getPay_name();
        textView.setText(pay_name);
        ((CheckBox) bVar.a(R.id.channel_check)).setChecked(czChannelBean.isSelected());
        ImageView imageView = (ImageView) bVar.a(R.id.iv_pay);
        String pay_img = czChannelBean.getPay_img();
        if (TextUtils.isEmpty(pay_img)) {
            imageView.setVisibility(0);
            if (pay_name.contains("支付宝")) {
                imageView.setImageResource(R.drawable.pay_zfb);
                return;
            } else if (pay_name.contains("微信")) {
                imageView.setImageResource(R.drawable.pay_wx);
                return;
            } else {
                imageView.setImageResource(R.drawable.pay_yl);
                return;
            }
        }
        imageView.setVisibility(0);
        if (pay_img.contains("zfb")) {
            imageView.setImageResource(R.drawable.pay_zfb);
        } else if (pay_img.contains("wx")) {
            imageView.setImageResource(R.drawable.pay_wx);
        } else {
            imageView.setImageResource(R.drawable.pay_yl);
        }
    }
}
