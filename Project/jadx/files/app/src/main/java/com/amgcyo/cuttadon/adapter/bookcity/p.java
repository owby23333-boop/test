package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: HotBookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends BaseQuickAdapter<MkBook, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c K;

    public p(@Nullable List<MkBook> list, me.jessyan.art.c.e.c cVar, String str) {
        super(R.layout.bookcity_v7style2_item, list);
        this.K = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, final MkBook mkBook) {
        ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
        TextView textView = (TextView) bVar.a(R.id.tv_book_rank);
        TextView textView2 = (TextView) bVar.a(R.id.tv_bookName);
        TextView textView3 = (TextView) bVar.a(R.id.tv_score);
        final Context context = bVar.itemView.getContext();
        this.K.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(imageView).build());
        int position = mkBook.getPosition();
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(position)));
        if (position == 1) {
            textView.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        } else if (position == 2) {
            textView.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.color_2));
        } else if (position != 3) {
            textView.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.color_CCCCCC));
        } else {
            textView.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.color_3));
        }
        textView2.setText(mkBook.getName());
        textView3.setText(String.format("%s分", mkBook.getScore()));
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context2 = context;
                MkBook mkBook2 = mkBook;
                r0.a(context2, mkBook2.getBook_id(), mkBook2.getForm());
            }
        });
    }
}
