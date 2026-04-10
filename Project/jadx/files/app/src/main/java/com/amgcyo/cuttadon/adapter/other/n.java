package com.amgcyo.cuttadon.adapter.other;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.activity.bookcity.MkThemeDetailActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkShudanQuickAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends BaseQuickAdapter<ShudanListData, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c K;

    public n(me.jessyan.art.c.e.c cVar) {
        super(R.layout.book_city_theme_list);
        this.K = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, final ShudanListData shudanListData) {
        final Context context = bVar.itemView.getContext();
        TextView textView = (TextView) bVar.a(R.id.tv_bookName);
        TextView textView2 = (TextView) bVar.a(R.id.book_coll_count);
        TextView textView3 = (TextView) bVar.a(R.id.tv_book_content);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_bookImg);
        textView.setText(shudanListData.getTitle());
        textView3.setText(shudanListData.getRemark());
        textView2.setText(String.format(Locale.getDefault(), "%d本书 · %d人收藏", Integer.valueOf(shudanListData.getBook_count()), Integer.valueOf(shudanListData.getFav_count())));
        String image = shudanListData.getImage();
        if (!TextUtils.isEmpty(image)) {
            this.K.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.E(), image)).imageView(imageView).build());
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.other.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.a(shudanListData, context, view);
            }
        });
    }

    static /* synthetic */ void a(ShudanListData shudanListData, Context context, View view) {
        String path = shudanListData.getPath();
        if (path == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("theme_path", path);
        bundle.putBoolean("theme_base_info", false);
        r0.startActivity(context, bundle, MkThemeDetailActivity.class);
    }
}
