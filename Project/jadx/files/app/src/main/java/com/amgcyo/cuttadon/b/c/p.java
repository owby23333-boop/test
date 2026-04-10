package com.amgcyo.cuttadon.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkBookListMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends com.chad.library.adapter.base.a<MkBook, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c L;
    private boolean M;

    public p(List<MkBook> list, me.jessyan.art.c.e.c cVar) {
        super(list);
        this.L = cVar;
        b(3, R.layout.item_author_list);
        b(1, R.layout.item_book_list);
        b(2, R.layout.item_book_list);
    }

    private void b(com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        final Context context = bVar.itemView.getContext();
        final NewApiAd newApiAd = mkBook.getNewApiAd();
        if (newApiAd != null) {
            TextView textView = (TextView) bVar.a(R.id.tv_bookName);
            ((ImageView) bVar.a(R.id.tv_ad_solgan)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.ll_root);
            ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
            TextView textView2 = (TextView) bVar.a(R.id.tv_book_content);
            ((TextView) bVar.a(R.id.tv_authorName)).setText(String.format("%s%s%s", newApiAd.getAuthor(), " · ", newApiAd.getType()));
            textView.setText(newApiAd.getName());
            textView2.setText(newApiAd.getDesc());
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.amgcyo.cuttadon.h.h.a.a(context, newApiAd);
                }
            });
            String image = newApiAd.getImage();
            if (!TextUtils.isEmpty(image)) {
                this.L.a(context, ImageConfigImpl.builder().imageRadius(8).placeholder(R.color.color_5_0c000000).url(image).imageView(imageView).build());
            }
            com.amgcyo.cuttadon.h.h.c.a(context, "OWNADSHOW", newApiAd, newApiAd.getLocation(), newApiAd.getOwnerType());
        }
    }

    private void c(com.chad.library.adapter.base.b bVar, final MkBook mkBook) {
        TextView textView = (TextView) bVar.a(R.id.tv_authorName);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.ll_root);
        final String name = mkBook.getName();
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.b.c.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3594s.a(name, mkBook, view);
            }
        });
        textView.setText(name);
    }

    private void d(com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        Context context = bVar.itemView.getContext();
        ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
        ((ImageView) bVar.a(R.id.tv_ad_solgan)).setVisibility(8);
        TextView textView = (TextView) bVar.a(R.id.tv_bookName);
        TextView textView2 = (TextView) bVar.a(R.id.tv_authorName);
        TextView textView3 = (TextView) bVar.a(R.id.tv_status);
        if (this.M) {
            textView3.setVisibility(3 == mkBook.getForm() ? 0 : 8);
        } else {
            textView3.setVisibility(8);
        }
        TextView textView4 = (TextView) bVar.a(R.id.tv_redu);
        TextView textView5 = (TextView) bVar.a(R.id.tv_book_content);
        CharSequence highLightBookName = mkBook.getHighLightBookName();
        if (highLightBookName != null) {
            textView.setText(highLightBookName);
        } else {
            textView.setText(mkBook.getName());
        }
        CharSequence hotSize = mkBook.getHotSize();
        if (TextUtils.isEmpty(hotSize)) {
            textView4.setVisibility(8);
        } else {
            textView4.setText(hotSize);
            textView4.setVisibility(0);
        }
        int form = mkBook.getForm();
        textView5.setText(mkBook.getRemark());
        String author = mkBook.getAuthor();
        if (1 == form) {
            textView2.setText(String.format("%s\u3000 %s · %s", author, mkBook.getStype(), com.amgcyo.cuttadon.f.o.a(mkBook.getStatus())));
        } else if (TextUtils.isEmpty(author)) {
            textView2.setText(String.format("%s话 · %s", Integer.valueOf(mkBook.getChapter_count()), com.amgcyo.cuttadon.f.o.a(mkBook.getStatus())));
        } else {
            textView2.setText(String.format("%s\u3000 %s话 · %s", author, Integer.valueOf(mkBook.getChapter_count()), com.amgcyo.cuttadon.f.o.a(mkBook.getStatus())));
        }
        this.L.a(context, ImageConfigImpl.builder().imageRadius(8).form(form).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(form), mkBook.getImage())).imageView(imageView).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        int itemViewType = bVar.getItemViewType();
        if (itemViewType == 1) {
            b(bVar, mkBook);
        } else if (itemViewType == 2) {
            d(bVar, mkBook);
        } else {
            if (itemViewType != 3) {
                return;
            }
            c(bVar, mkBook);
        }
    }

    public p(List<MkBook> list, me.jessyan.art.c.e.c cVar, boolean z2) {
        super(list);
        this.L = cVar;
        this.M = z2;
        b(3, R.layout.item_author_list);
        b(1, R.layout.item_book_list);
        b(2, R.layout.item_book_list);
    }

    public /* synthetic */ void a(String str, MkBook mkBook, View view) {
        y0.a.a.a("点击的是作者：" + str + " form: " + mkBook.getForm(), new Object[0]);
        r0.a(this.f14735w, str, mkBook.getForm());
    }
}
