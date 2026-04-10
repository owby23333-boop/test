package com.amgcyo.cuttadon.adapter.shelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.comic.CategoryComicBean;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import com.amgcyo.cuttadon.fragment.books.MkBookshelfFragment;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkShelfCategoryDataItem extends me.drakeet.multitype.b<ShelfCategory, com.amgcyo.cuttadon.adapter.other.p> {
    private MkBookshelfFragment b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected me.jessyan.art.c.e.c f3109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.a f3110d;

    static class BookShelfGridViewHolder extends com.amgcyo.cuttadon.adapter.other.p {

        @BindView(R.id.iv_bookImg0)
        ImageView iv_bookImg0;

        @BindView(R.id.iv_bookImg1)
        ImageView iv_bookImg1;

        @BindView(R.id.iv_bookImg2)
        ImageView iv_bookImg2;

        @BindView(R.id.iv_bookImg3)
        ImageView iv_bookImg3;

        @BindView(R.id.tv_cate_name)
        TextView tv_cate_name;

        @BindView(R.id.tv_count)
        TextView tv_count;
    }

    public class BookShelfGridViewHolder_ViewBinding implements Unbinder {
        private BookShelfGridViewHolder a;

        @UiThread
        public BookShelfGridViewHolder_ViewBinding(BookShelfGridViewHolder bookShelfGridViewHolder, View view) {
            this.a = bookShelfGridViewHolder;
            bookShelfGridViewHolder.iv_bookImg0 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg0, "field 'iv_bookImg0'", ImageView.class);
            bookShelfGridViewHolder.iv_bookImg1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg1, "field 'iv_bookImg1'", ImageView.class);
            bookShelfGridViewHolder.iv_bookImg2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg2, "field 'iv_bookImg2'", ImageView.class);
            bookShelfGridViewHolder.iv_bookImg3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg3, "field 'iv_bookImg3'", ImageView.class);
            bookShelfGridViewHolder.tv_cate_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cate_name, "field 'tv_cate_name'", TextView.class);
            bookShelfGridViewHolder.tv_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tv_count'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BookShelfGridViewHolder bookShelfGridViewHolder = this.a;
            if (bookShelfGridViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            bookShelfGridViewHolder.iv_bookImg0 = null;
            bookShelfGridViewHolder.iv_bookImg1 = null;
            bookShelfGridViewHolder.iv_bookImg2 = null;
            bookShelfGridViewHolder.iv_bookImg3 = null;
            bookShelfGridViewHolder.tv_cate_name = null;
            bookShelfGridViewHolder.tv_count = null;
        }
    }

    static class BookShelfListViewHolder extends com.amgcyo.cuttadon.adapter.other.p {

        @BindView(R.id.iv_bookImg0)
        ImageView iv_bookImg0;

        @BindView(R.id.iv_bookImg1)
        ImageView iv_bookImg1;

        @BindView(R.id.iv_bookImg2)
        ImageView iv_bookImg2;

        @BindView(R.id.iv_bookImg3)
        ImageView iv_bookImg3;

        @BindView(R.id.tv_cate_name)
        TextView tv_cate_name;

        @BindView(R.id.tv_count)
        TextView tv_count;

        @BindView(R.id.tv_time_list)
        TextView tv_time_list;

        BookShelfListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class BookShelfListViewHolder_ViewBinding implements Unbinder {
        private BookShelfListViewHolder a;

        @UiThread
        public BookShelfListViewHolder_ViewBinding(BookShelfListViewHolder bookShelfListViewHolder, View view) {
            this.a = bookShelfListViewHolder;
            bookShelfListViewHolder.iv_bookImg0 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg0, "field 'iv_bookImg0'", ImageView.class);
            bookShelfListViewHolder.iv_bookImg1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg1, "field 'iv_bookImg1'", ImageView.class);
            bookShelfListViewHolder.iv_bookImg2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg2, "field 'iv_bookImg2'", ImageView.class);
            bookShelfListViewHolder.iv_bookImg3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg3, "field 'iv_bookImg3'", ImageView.class);
            bookShelfListViewHolder.tv_cate_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cate_name, "field 'tv_cate_name'", TextView.class);
            bookShelfListViewHolder.tv_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tv_count'", TextView.class);
            bookShelfListViewHolder.tv_time_list = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time_list, "field 'tv_time_list'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BookShelfListViewHolder bookShelfListViewHolder = this.a;
            if (bookShelfListViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            bookShelfListViewHolder.iv_bookImg0 = null;
            bookShelfListViewHolder.iv_bookImg1 = null;
            bookShelfListViewHolder.iv_bookImg2 = null;
            bookShelfListViewHolder.iv_bookImg3 = null;
            bookShelfListViewHolder.tv_cate_name = null;
            bookShelfListViewHolder.tv_count = null;
            bookShelfListViewHolder.tv_time_list = null;
        }
    }

    public MkShelfCategoryDataItem(MkBookshelfFragment mkBookshelfFragment, me.jessyan.art.c.e.c cVar, com.amgcyo.cuttadon.g.a aVar) {
        this.b = mkBookshelfFragment;
        this.f3109c = cVar;
        this.f3110d = aVar;
    }

    public /* synthetic */ boolean b(ShelfCategory shelfCategory, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3110d;
        if (aVar == null) {
            return true;
        }
        aVar.onItemCategoryLongClick(shelfCategory);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public com.amgcyo.cuttadon.adapter.other.p a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.bookshelf_category_list, viewGroup, false);
        if (this.b.G == 1) {
            viewInflate = layoutInflater.inflate(R.layout.bookshelf_category_grid, viewGroup, false);
        }
        return new BookShelfListViewHolder(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull com.amgcyo.cuttadon.adapter.other.p pVar, @NonNull ShelfCategory shelfCategory) {
        a((BookShelfListViewHolder) pVar, shelfCategory);
    }

    private void a(BookShelfListViewHolder bookShelfListViewHolder, final ShelfCategory shelfCategory) {
        Context context = bookShelfListViewHolder.itemView.getContext();
        bookShelfListViewHolder.tv_cate_name.setText(shelfCategory.getCategoryName());
        bookShelfListViewHolder.tv_count.setText(String.format(Locale.getDefault(), "共%d本", Integer.valueOf(shelfCategory.getCategoryCount())));
        int updateCount = shelfCategory.getUpdateCount();
        if (updateCount > 0) {
            bookShelfListViewHolder.tv_time_list.setVisibility(0);
            bookShelfListViewHolder.tv_time_list.setText(String.format(Locale.getDefault(), "%d本书·有更新", Integer.valueOf(updateCount)));
        } else {
            bookShelfListViewHolder.tv_time_list.setVisibility(4);
        }
        List<CategoryComicBean> categoryPics = shelfCategory.getCategoryPics();
        bookShelfListViewHolder.iv_bookImg0.setImageResource(R.drawable.category1);
        bookShelfListViewHolder.iv_bookImg1.setImageResource(R.drawable.category2);
        bookShelfListViewHolder.iv_bookImg2.setImageResource(R.drawable.category3);
        bookShelfListViewHolder.iv_bookImg3.setImageResource(R.drawable.category4);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(categoryPics)) {
            if (categoryPics.size() > 4) {
                categoryPics = categoryPics.subList(0, 4);
            }
            ImageView[] imageViewArr = {bookShelfListViewHolder.iv_bookImg0, bookShelfListViewHolder.iv_bookImg1, bookShelfListViewHolder.iv_bookImg2, bookShelfListViewHolder.iv_bookImg3};
            for (int i2 = 0; i2 < categoryPics.size(); i2++) {
                CategoryComicBean categoryComicBean = categoryPics.get(i2);
                int form = categoryComicBean.getForm();
                this.f3109c.a(context, ImageConfigImpl.builder().form(form).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(form), categoryComicBean.getImgUrl())).imageView(imageViewArr[i2]).build());
            }
        }
        bookShelfListViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3140s.a(shelfCategory, view);
            }
        });
        bookShelfListViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.o
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f3138s.b(shelfCategory, view);
            }
        });
    }

    public /* synthetic */ void a(ShelfCategory shelfCategory, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3110d;
        if (aVar != null) {
            aVar.onItemCategoryClick(shelfCategory);
        }
    }
}
