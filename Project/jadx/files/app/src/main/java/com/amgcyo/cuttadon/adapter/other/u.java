package com.amgcyo.cuttadon.adapter.other;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.amgcyo.cuttadon.api.entity.other.EngineInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: TtsEngineListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends BaseQuickAdapter<EngineInfoBean, com.chad.library.adapter.base.b> {
    public u(@Nullable List<EngineInfoBean> list) {
        super(R.layout.view_tts_engine_item, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, EngineInfoBean engineInfoBean) {
        int adapterPosition = bVar.getAdapterPosition();
        int[] iArr = com.amgcyo.cuttadon.utils.otherutils.l.a;
        int i2 = adapterPosition < iArr.length ? iArr[adapterPosition] : SupportMenu.CATEGORY_MASK;
        String zh_cn_name = engineInfoBean.getZh_cn_name();
        GradientDrawable gradientDrawableA = com.amgcyo.cuttadon.f.o.a(-1, -1, 1, (String) null, i2);
        TextView textView = (TextView) bVar.a(R.id.tv_first);
        textView.setText(zh_cn_name.substring(0, 1));
        textView.setBackground(gradientDrawableA);
        ((TextView) bVar.a(R.id.tv_tts_engine)).setText(zh_cn_name);
        ((TextView) bVar.a(R.id.tv_tts_engine_desc)).setText(engineInfoBean.getDesc());
        TextView textView2 = (TextView) bVar.a(R.id.tv_tts_download);
        String btn_title = engineInfoBean.getBtn_title();
        if (TextUtils.isEmpty(btn_title)) {
            textView2.setVisibility(8);
            textView2.setText("");
        } else {
            textView2.setVisibility(0);
            textView2.setText(btn_title);
        }
    }
}
