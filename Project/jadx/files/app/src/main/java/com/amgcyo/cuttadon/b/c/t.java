package com.amgcyo.cuttadon.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkHotSearchMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends com.chad.library.adapter.base.a<MkBook, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c L;
    private boolean M;
    private boolean N;
    private boolean O;

    public t(List<MkBook> list, me.jessyan.art.c.e.c cVar) {
        super(list);
        this.L = cVar;
        b(1, R.layout.item_hot_ranking_list);
        b(2, R.layout.item_hot_ranking_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        final Context context = bVar.itemView.getContext();
        final NewApiAd newApiAd = mkBook.getNewApiAd();
        if (newApiAd != null) {
            ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
            TextView textView = (TextView) bVar.a(R.id.tv_bookName);
            TextView textView2 = (TextView) bVar.a(R.id.tv_position);
            TextView textView3 = (TextView) bVar.a(R.id.tv_book_content);
            TextView textView4 = (TextView) bVar.a(R.id.tv_authorName);
            TextView textView5 = (TextView) bVar.a(R.id.tv_redu);
            textView.setText(newApiAd.getName());
            textView4.setText(newApiAd.getAuthor());
            textView3.setText(newApiAd.getDesc());
            String image = newApiAd.getImage();
            textView5.setVisibility(8);
            if (TextUtils.isEmpty(image)) {
                imageView.setImageResource(R.drawable.icon_pic_def);
            } else {
                this.L.a(context, ImageConfigImpl.builder().url(image).imageRadius(8).imageView(imageView).build());
            }
            textView2.setVisibility(8);
            com.amgcyo.cuttadon.h.h.c.a(context, "OWNADSHOW", newApiAd, newApiAd.getLocation(), newApiAd.getOwnerType());
            bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.amgcyo.cuttadon.h.h.a.a(context, newApiAd);
                }
            });
        }
    }

    private void c(com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        int adapterPosition = bVar.getAdapterPosition();
        Context context = bVar.itemView.getContext();
        ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
        TextView textView = (TextView) bVar.a(R.id.tv_bookName);
        TextView textView2 = (TextView) bVar.a(R.id.tv_position);
        TextView textView3 = (TextView) bVar.a(R.id.tv_book_content);
        TextView textView4 = (TextView) bVar.a(R.id.tv_authorName);
        TextView textView5 = (TextView) bVar.a(R.id.tv_redu);
        textView.setText(mkBook.getName());
        String strA = com.amgcyo.cuttadon.f.o.a(mkBook.getStatus());
        int form = mkBook.getForm();
        if (1 == form) {
            String strA2 = com.amgcyo.cuttadon.f.o.a(mkBook.getWords_number(), (Integer) 2);
            if (this.O) {
                textView4.setText(String.format("%s · %s · %s", mkBook.getStype(), strA, strA2));
            } else {
                textView4.setText(String.format("%s · %s · %s", mkBook.getLtype(), strA, strA2));
            }
        } else {
            textView4.setText(String.format(Locale.getDefault(), "%s · %d话", strA, Integer.valueOf(mkBook.getChapter_count())));
        }
        if (this.N) {
            String author = mkBook.getAuthor();
            if (TextUtils.isEmpty(author)) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
                textView3.setText(author);
            }
        } else {
            textView3.setText(mkBook.getRemark());
        }
        textView5.setText(mkBook.getHotSize());
        if (TextUtils.isEmpty(mkBook.getImage())) {
            imageView.setImageResource(R.drawable.icon_pic_def);
        } else {
            this.L.a(context, ImageConfigImpl.builder().url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(form), mkBook.getImage())).imageRadius(10).form(form).imageView(imageView).build());
        }
        if (this.M) {
            textView2.setVisibility(0);
            textView2.setTextSize(2, 16.0f);
            textView2.setText(String.format("%s分", mkBook.getScore()));
        } else {
            if (adapterPosition >= 10) {
                textView2.setVisibility(8);
                return;
            }
            textView2.setVisibility(0);
            if (adapterPosition < 3) {
                textView2.setTextColor(context.getResources().getColor(R.color.color_EC5C07));
            } else {
                textView2.setTextColor(context.getResources().getColor(R.color.cac9c9));
            }
            textView2.setText(String.format("%s", Integer.valueOf(adapterPosition + 1)));
            textView2.setTextSize(2, 18.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        int itemViewType = bVar.getItemViewType();
        if (itemViewType == 1) {
            b(bVar, mkBook);
        } else {
            if (itemViewType != 2) {
                return;
            }
            c(bVar, mkBook);
        }
    }

    public t(List<MkBook> list, boolean z2, boolean z3, boolean z4, me.jessyan.art.c.e.c cVar) {
        super(list);
        this.L = cVar;
        this.M = z2;
        this.N = z3;
        this.O = z4;
        b(1, R.layout.item_hot_ranking_list);
        b(2, R.layout.item_hot_ranking_list);
    }
}
