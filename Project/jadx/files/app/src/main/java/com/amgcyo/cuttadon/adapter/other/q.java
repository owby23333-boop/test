package com.amgcyo.cuttadon.adapter.other;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.reader.TtsEngineBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkTtsEngineAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends BaseQuickAdapter<TtsEngineBean, com.chad.library.adapter.base.b> {
    private int K;

    public q(@Nullable List<TtsEngineBean> list) {
        super(R.layout.item_shelf_sort, list);
    }

    public void e(int i2) {
        this.K = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, TtsEngineBean ttsEngineBean) {
        TextView textView = (TextView) bVar.a(R.id.item_text);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_selected);
        textView.setText(ttsEngineBean.getTitle());
        if (ttsEngineBean.getTts_type() == this.K) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }
}
