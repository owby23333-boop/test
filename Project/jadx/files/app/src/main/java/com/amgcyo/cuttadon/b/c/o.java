package com.amgcyo.cuttadon.b.c;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.BgmMp3;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkBgmMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends com.chad.library.adapter.base.a<BgmMp3, com.chad.library.adapter.base.b> {
    public o(List<BgmMp3> list) {
        super(list);
        b(2, R.layout.item_feed_back_his_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, BgmMp3 bgmMp3) {
        TextView textView = (TextView) bVar.a(R.id.tv_feedback_title);
        TextView textView2 = (TextView) bVar.a(R.id.tv_feedback_status);
        textView.setText(String.format("推荐者:%s", bgmMp3.getAuthorName()));
        textView2.setText(String.format("音乐名字:%s", bgmMp3.getName()));
        TextView textView3 = (TextView) bVar.a(R.id.tv_feedback_content);
        ((TextView) bVar.a(R.id.tv_feedback_time)).setText(bgmMp3.getCreateTime());
        textView3.setText(String.format("介绍:%s", bgmMp3.getDesc()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, BgmMp3 bgmMp3) {
        if (bVar.getItemViewType() != 2) {
            return;
        }
        b(bVar, bgmMp3);
    }
}
