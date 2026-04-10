package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.bookcity.MkThemeDetailActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkBookCityShudanListIVB extends me.drakeet.multitype.b<ShudanListData, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.book_coll_count)
        TextView book_coll_count;

        @BindView(R.id.iv_bookImg)
        ImageView ivBookImg;

        @BindView(R.id.tv_bookName)
        TextView tv_bookName;

        @BindView(R.id.tv_book_content)
        TextView tv_book_content;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.ivBookImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg, "field 'ivBookImg'", ImageView.class);
            viewHolder.tv_bookName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName, "field 'tv_bookName'", TextView.class);
            viewHolder.tv_book_content = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_book_content, "field 'tv_book_content'", TextView.class);
            viewHolder.book_coll_count = (TextView) Utils.findRequiredViewAsType(view, R.id.book_coll_count, "field 'book_coll_count'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.ivBookImg = null;
            viewHolder.tv_bookName = null;
            viewHolder.tv_book_content = null;
            viewHolder.book_coll_count = null;
        }
    }

    public MkBookCityShudanListIVB(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.book_city_theme_list, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final ShudanListData shudanListData) {
        final Context context = viewHolder.itemView.getContext();
        this.b.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.E(), shudanListData.getImage())).imageView(viewHolder.ivBookImg).build());
        viewHolder.tv_bookName.setText(shudanListData.getTitle());
        shudanListData.getTitle();
        viewHolder.tv_book_content.setText(shudanListData.getRemark());
        viewHolder.book_coll_count.setText(String.format(Locale.getDefault(), "%d本书 · %d人收藏", Integer.valueOf(shudanListData.getBook_count()), Integer.valueOf(shudanListData.getFav_count())));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MkBookCityShudanListIVB.a(shudanListData, context, view);
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
