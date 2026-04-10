package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.text.TextUtils;
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
import com.amgcyo.cuttadon.api.entity.bookcity.v4.ItemsGrid4Book;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkGrid4BookDataIVB extends me.drakeet.multitype.b<ItemsGrid4Book, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_bookImg)
        ImageView iv_bookImg;

        @BindView(R.id.tv_bookName)
        TextView tv_bookName;

        @BindView(R.id.tv_last_read_chapterName)
        TextView tv_last_read_chapterName;

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
            viewHolder.iv_bookImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg, "field 'iv_bookImg'", ImageView.class);
            viewHolder.tv_bookName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName, "field 'tv_bookName'", TextView.class);
            viewHolder.tv_last_read_chapterName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_last_read_chapterName, "field 'tv_last_read_chapterName'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.iv_bookImg = null;
            viewHolder.tv_bookName = null;
            viewHolder.tv_last_read_chapterName = null;
        }
    }

    public MkGrid4BookDataIVB(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.book_detail_adapter, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final ItemsGrid4Book itemsGrid4Book) {
        final Context context = viewHolder.itemView.getContext();
        this.b.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(itemsGrid4Book.getForm()), itemsGrid4Book.getImage())).imageView(viewHolder.iv_bookImg).build());
        viewHolder.tv_bookName.setText(itemsGrid4Book.getName());
        String author = itemsGrid4Book.getAuthor();
        if (TextUtils.isEmpty(author)) {
            viewHolder.tv_last_read_chapterName.setVisibility(8);
        } else {
            viewHolder.tv_last_read_chapterName.setText(author);
            viewHolder.tv_last_read_chapterName.setVisibility(0);
        }
        viewHolder.tv_last_read_chapterName.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.text_66));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context2 = context;
                ItemsGrid4Book itemsGrid4Book2 = itemsGrid4Book;
                r0.a(context2, itemsGrid4Book2.getBook_id(), itemsGrid4Book2.getForm());
            }
        });
    }
}
