package com.amgcyo.cuttadon.adapter.shelf;

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
import com.amgcyo.cuttadon.api.entity.comic.CategoryComicBean;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import com.amgcyo.cuttadon.view.dialog.n1;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkShelfCategoryItem extends me.drakeet.multitype.b<ShelfCategory, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n1.c f3111c;

    class ViewHolder extends RecyclerView.ViewHolder {

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

        ViewHolder(MkShelfCategoryItem mkShelfCategoryItem, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.iv_bookImg0 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg0, "field 'iv_bookImg0'", ImageView.class);
            viewHolder.iv_bookImg1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg1, "field 'iv_bookImg1'", ImageView.class);
            viewHolder.iv_bookImg2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg2, "field 'iv_bookImg2'", ImageView.class);
            viewHolder.iv_bookImg3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg3, "field 'iv_bookImg3'", ImageView.class);
            viewHolder.tv_cate_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cate_name, "field 'tv_cate_name'", TextView.class);
            viewHolder.tv_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tv_count'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.iv_bookImg0 = null;
            viewHolder.iv_bookImg1 = null;
            viewHolder.iv_bookImg2 = null;
            viewHolder.iv_bookImg3 = null;
            viewHolder.tv_cate_name = null;
            viewHolder.tv_count = null;
        }
    }

    public MkShelfCategoryItem(me.jessyan.art.c.e.c cVar, n1.c cVar2) {
        this.b = cVar;
        this.f3111c = cVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(this, layoutInflater.inflate(R.layout.layout_shelf_category, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull ShelfCategory shelfCategory) {
        Context context = viewHolder.itemView.getContext();
        final String categoryName = shelfCategory.getCategoryName();
        if (TextUtils.isEmpty(categoryName)) {
            viewHolder.tv_cate_name.setText(com.amgcyo.cuttadon.f.o.d(R.string.book_shelf));
        } else {
            viewHolder.tv_cate_name.setText(categoryName);
        }
        viewHolder.tv_count.setText(String.format(Locale.getDefault(), "共%d本", Integer.valueOf(shelfCategory.getCategoryCount())));
        List<CategoryComicBean> categoryPics = shelfCategory.getCategoryPics();
        ImageView[] imageViewArr = {viewHolder.iv_bookImg0, viewHolder.iv_bookImg1, viewHolder.iv_bookImg2, viewHolder.iv_bookImg3};
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(categoryPics)) {
            if (categoryPics.size() > 4) {
                categoryPics = categoryPics.subList(0, 4);
            }
            for (int i2 = 0; i2 < categoryPics.size(); i2++) {
                CategoryComicBean categoryComicBean = categoryPics.get(i2);
                int form = categoryComicBean.getForm();
                this.b.a(context, ImageConfigImpl.builder().form(form).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(form), categoryComicBean.getImgUrl())).imageView(imageViewArr[i2]).build());
            }
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3142s.a(categoryName, view);
            }
        });
    }

    public /* synthetic */ void a(String str, View view) {
        n1.c cVar = this.f3111c;
        if (cVar != null) {
            cVar.a(str);
        }
    }
}
