package com.amgcyo.cuttadon.b.c;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.MkFeedbackHisBean;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: MkFeedBackMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class s extends com.chad.library.adapter.base.a<MkFeedbackHisBean, com.chad.library.adapter.base.b> {
    public s(List<MkFeedbackHisBean> list, me.jessyan.art.c.e.c cVar) {
        super(list);
        b(2, R.layout.item_feed_back_his_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, MkFeedbackHisBean mkFeedbackHisBean) {
        Context context = bVar.itemView.getContext();
        TextView textView = (TextView) bVar.a(R.id.tv_feedback_title);
        TextView textView2 = (TextView) bVar.a(R.id.tv_feedback_status);
        TextView textView3 = (TextView) bVar.a(R.id.tv_feedback_time);
        TextView textView4 = (TextView) bVar.a(R.id.tv_feedback_content);
        textView.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_title), mkFeedbackHisBean.getContent()));
        if (mkFeedbackHisBean.getStatus() == 2) {
            textView2.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_status), "已处理"));
            textView2.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            textView4.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_content), mkFeedbackHisBean.getReply()));
            textView4.setVisibility(0);
            bVar.itemView.setOnClickListener(null);
        } else {
            bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.amgcyo.cuttadon.f.o.b("还在处理中!请耐心等待...");
                }
            });
            textView2.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_status), "未处理"));
            textView2.setTextColor(context.getResources().getColor(R.color.text_66));
            textView4.setText("");
            textView4.setVisibility(8);
        }
        textView3.setText(String.format(Locale.CHINA, context.getString(R.string.feedback_time), mkFeedbackHisBean.getCreated_at()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, MkFeedbackHisBean mkFeedbackHisBean) {
        if (bVar.getItemViewType() == 2) {
            b(bVar, mkFeedbackHisBean);
        }
    }
}
