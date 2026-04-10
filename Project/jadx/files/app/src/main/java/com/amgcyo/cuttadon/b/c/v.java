package com.amgcyo.cuttadon.b.c;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.LocalMp3Bean;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkLocalMp3MuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class v extends com.chad.library.adapter.base.a<LocalMp3Bean, com.chad.library.adapter.base.b> {
    private String L;

    public v(List<LocalMp3Bean> list, String str) {
        super(list);
        this.L = str;
        b(2, R.layout.item_local_mp3_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, LocalMp3Bean localMp3Bean) {
        TextView textView = (TextView) bVar.a(R.id.tv_feedback_title);
        TextView textView2 = (TextView) bVar.a(R.id.tv_feedback_status);
        TextView textView3 = (TextView) bVar.a(R.id.tv_current_gbm_name);
        textView.setText(localMp3Bean.getName());
        textView2.setText(localMp3Bean.getPath());
        if (TextUtils.isEmpty(this.L)) {
            textView3.setVisibility(8);
        } else if (this.L.equals(localMp3Bean.getPath())) {
            textView3.setVisibility(0);
        } else {
            textView3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, LocalMp3Bean localMp3Bean) {
        if (bVar.getItemViewType() != 2) {
            return;
        }
        b(bVar, localMp3Bean);
    }
}
