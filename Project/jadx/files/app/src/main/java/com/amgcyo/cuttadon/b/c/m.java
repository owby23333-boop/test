package com.amgcyo.cuttadon.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.MkAddBookHisBean;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: MkAddBookMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends com.chad.library.adapter.base.a<MkAddBookHisBean, com.chad.library.adapter.base.b> {
    public m(List<MkAddBookHisBean> list) {
        super(list);
        b(2, R.layout.item_feed_back_his_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, MkAddBookHisBean mkAddBookHisBean) {
        Context context = bVar.itemView.getContext();
        TextView textView = (TextView) bVar.a(R.id.tv_feedback_title);
        TextView textView2 = (TextView) bVar.a(R.id.tv_feedback_status);
        TextView textView3 = (TextView) bVar.a(R.id.tv_feedback_time);
        ((TextView) bVar.a(R.id.tv_feedback_content)).setVisibility(8);
        textView.setText(String.format("%s\n作者: %s", String.format(Locale.CHINA, context.getString(R.string.addbook_title), mkAddBookHisBean.getName()), mkAddBookHisBean.getAuthor()));
        if (mkAddBookHisBean.getBook_id() > 0) {
            textView2.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_status), "求书成功(点击查看)"));
            textView2.setTextColor(context.getResources().getColor(R.color.accent_orange));
        } else if (TextUtils.isEmpty(mkAddBookHisBean.getMsg())) {
            textView2.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_status), "还在处理中..."));
            textView2.setTextColor(context.getResources().getColor(R.color.a2a9b2));
        } else {
            textView2.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_status), mkAddBookHisBean.getMsg()));
            textView2.setTextColor(context.getResources().getColor(R.color.accent_orange));
        }
        textView3.setText(String.format(Locale.CHINA, context.getString(R.string.addbook_time), mkAddBookHisBean.getCreated_at()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, MkAddBookHisBean mkAddBookHisBean) {
        if (bVar.getItemViewType() != 2) {
            return;
        }
        b(bVar, mkAddBookHisBean);
    }
}
