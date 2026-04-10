package com.amgcyo.cuttadon.adapter.comic;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.detail.MkBookDetailActivity;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkRelevantBookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends BaseQuickAdapter<MkBook, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c K;

    public d(@Nullable List<MkBook> list, me.jessyan.art.c.e.c cVar) {
        super(R.layout.relevantbook_item, list);
        this.K = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, final MkBook mkBook) {
        TextView textView = (TextView) bVar.a(R.id.tv_bookName);
        ((TextView) bVar.a(R.id.tv_book_content)).setText(mkBook.getRemark());
        TextView textView2 = (TextView) bVar.a(R.id.tv_authorname);
        TextView textView3 = (TextView) bVar.a(R.id.tv_book_status);
        String author = mkBook.getAuthor();
        if (TextUtils.isEmpty(author)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(author);
        }
        TextView textView4 = (TextView) bVar.a(R.id.tv_chapter_count);
        textView3.setText(o.a(mkBook.getStatus()));
        ((TextView) bVar.a(R.id.tv_score)).setText(String.format("%s分", mkBook.getScore()));
        if (3 == mkBook.getForm()) {
            textView4.setText(String.format(Locale.getDefault(), "%d话", Integer.valueOf(mkBook.getChapter_count())));
        } else {
            textView4.setText(mkBook.getLtype());
        }
        ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
        textView.setText(mkBook.getName());
        this.K.a(this.f14735w, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", g.e(mkBook.getForm()), mkBook.getImage())).form(mkBook.getForm()).imageView(imageView).build());
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.comic.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3071s.a(mkBook, view);
            }
        });
    }

    public /* synthetic */ void a(MkBook mkBook, View view) {
        Context context = this.f14735w;
        if (context instanceof MkBookDetailActivity) {
            ((MkBookDetailActivity) context).finish();
        }
        r0.a(this.f14735w, mkBook.getBook_id(), mkBook.getForm());
    }
}
