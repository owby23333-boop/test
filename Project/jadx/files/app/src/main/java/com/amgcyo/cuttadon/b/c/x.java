package com.amgcyo.cuttadon.b.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.fatcatfat.io.R;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkReadHistoryMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class x extends com.chad.library.adapter.base.a<LocalReadHistoryBean, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c L;
    private com.amgcyo.cuttadon.g.g M;

    public x(List<LocalReadHistoryBean> list, me.jessyan.art.c.e.c cVar, com.amgcyo.cuttadon.g.g gVar) {
        super(list);
        this.L = cVar;
        this.M = gVar;
        b(2, R.layout.book_historylist_holder);
    }

    private void b(com.chad.library.adapter.base.b bVar, final LocalReadHistoryBean localReadHistoryBean) {
        Context context = bVar.itemView.getContext();
        ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
        TextView textView = (TextView) bVar.a(R.id.tv_bookName);
        TextView textView2 = (TextView) bVar.a(R.id.tv_inshelf);
        TextView textView3 = (TextView) bVar.a(R.id.tv_create_ut);
        TextView textView4 = (TextView) bVar.a(R.id.tv_book_author);
        this.L.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(localReadHistoryBean.getForm()), localReadHistoryBean.getImage())).imageView(imageView).build());
        textView.setText(localReadHistoryBean.getName());
        textView4.setText(localReadHistoryBean.getAuthor());
        textView3.setText(localReadHistoryBean.getCreated_at());
        if (localReadHistoryBean.isInshelf()) {
            textView2.setText("已加书架");
            textView2.setEnabled(false);
            textView2.setTextColor(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.a2a9b2));
        } else {
            textView2.setEnabled(true);
            textView2.setText("加入书架");
            textView2.setTextColor(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3616s.a(localReadHistoryBean, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, LocalReadHistoryBean localReadHistoryBean) {
        if (bVar.getItemViewType() != 2) {
            return;
        }
        b(bVar, localReadHistoryBean);
    }

    public /* synthetic */ void a(LocalReadHistoryBean localReadHistoryBean, View view) {
        com.amgcyo.cuttadon.g.g gVar = this.M;
        if (gVar != null) {
            gVar.a(localReadHistoryBean);
        }
    }
}
