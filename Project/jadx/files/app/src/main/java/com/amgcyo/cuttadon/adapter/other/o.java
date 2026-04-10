package com.amgcyo.cuttadon.adapter.other;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkShudanlistMuiltQuickAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends com.chad.library.adapter.base.a<ShudanListData, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c L;

    public o(List<ShudanListData> list, me.jessyan.art.c.e.c cVar) {
        super(list);
        this.L = cVar;
        b(2, R.layout.book_city_booklist_holder);
    }

    private void b(com.chad.library.adapter.base.b bVar, ShudanListData shudanListData) {
        Context context = bVar.itemView.getContext();
        CustomTextView customTextView = (CustomTextView) bVar.a(R.id.tv_bookName);
        TextView textView = (TextView) bVar.a(R.id.tv_book_content);
        TextView textView2 = (TextView) bVar.a(R.id.book_count);
        TextView textView3 = (TextView) bVar.a(R.id.book_coll_count);
        ImageView imageView = (ImageView) bVar.a(R.id.image_left);
        ImageView imageView2 = (ImageView) bVar.a(R.id.image_center);
        ImageView imageView3 = (ImageView) bVar.a(R.id.image_right);
        List<String> images = shudanListData.getImages();
        ImageView[] imageViewArr = {imageView, imageView2, imageView3};
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(images)) {
            for (ImageView imageView4 : imageViewArr) {
                this.L.a(context, ImageConfigImpl.builder().imageView(imageView4).build());
            }
        } else {
            for (int i2 = 0; i2 < images.size(); i2++) {
                String str = images.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    this.L.a(context, ImageConfigImpl.builder().url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.E(), str)).imageView(imageViewArr[i2]).build());
                }
            }
        }
        customTextView.setText(shudanListData.getTitle());
        textView.setText(shudanListData.getRemark());
        textView2.setText(String.format(Locale.getDefault(), "共%d本书", Integer.valueOf(shudanListData.getBook_count())));
        textView3.setText(String.format(Locale.getDefault(), "%d人已收藏", Integer.valueOf(shudanListData.getFav_count())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, ShudanListData shudanListData) {
        if (bVar.getItemViewType() == 2) {
            b(bVar, shudanListData);
        }
    }
}
