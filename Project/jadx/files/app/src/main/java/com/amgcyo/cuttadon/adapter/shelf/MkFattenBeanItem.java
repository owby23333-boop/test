package com.amgcyo.cuttadon.adapter.shelf;

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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.bookcity.MkBookFattenActivity;
import com.amgcyo.cuttadon.api.entity.other.MkFattenBean;
import com.amgcyo.cuttadon.fragment.books.MkBookshelfFragment;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkFattenBeanItem extends me.drakeet.multitype.b<MkFattenBean, com.amgcyo.cuttadon.adapter.other.p> {
    private me.jessyan.art.c.e.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MkBookshelfFragment f3105c;

    class GridViewHolder extends com.amgcyo.cuttadon.adapter.other.p {

        @BindView(R.id.iv_bookImg0)
        ImageView iv_bookImg0;

        @BindView(R.id.iv_bookImg1)
        ImageView iv_bookImg1;

        @BindView(R.id.iv_bookImg2)
        ImageView iv_bookImg2;

        @BindView(R.id.iv_bookImg3)
        ImageView iv_bookImg3;

        @BindView(R.id.tv_bookName_grid)
        TextView tvBookName;

        @BindView(R.id.tv_time_list)
        TextView tvTimeList;

        GridViewHolder(MkFattenBeanItem mkFattenBeanItem, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class GridViewHolder_ViewBinding implements Unbinder {
        private GridViewHolder a;

        @UiThread
        public GridViewHolder_ViewBinding(GridViewHolder gridViewHolder, View view) {
            this.a = gridViewHolder;
            gridViewHolder.iv_bookImg0 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg0, "field 'iv_bookImg0'", ImageView.class);
            gridViewHolder.iv_bookImg1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg1, "field 'iv_bookImg1'", ImageView.class);
            gridViewHolder.iv_bookImg2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg2, "field 'iv_bookImg2'", ImageView.class);
            gridViewHolder.iv_bookImg3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg3, "field 'iv_bookImg3'", ImageView.class);
            gridViewHolder.tvBookName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName_grid, "field 'tvBookName'", TextView.class);
            gridViewHolder.tvTimeList = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time_list, "field 'tvTimeList'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            GridViewHolder gridViewHolder = this.a;
            if (gridViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            gridViewHolder.iv_bookImg0 = null;
            gridViewHolder.iv_bookImg1 = null;
            gridViewHolder.iv_bookImg2 = null;
            gridViewHolder.iv_bookImg3 = null;
            gridViewHolder.tvBookName = null;
            gridViewHolder.tvTimeList = null;
        }
    }

    class ListViewHolder extends com.amgcyo.cuttadon.adapter.other.p {

        @BindView(R.id.iv_bookImg0)
        ImageView iv_bookImg0;

        @BindView(R.id.iv_bookImg1)
        ImageView iv_bookImg1;

        @BindView(R.id.iv_bookImg2)
        ImageView iv_bookImg2;

        @BindView(R.id.iv_bookImg3)
        ImageView iv_bookImg3;

        @BindView(R.id.shelf_more)
        ImageView shelf_more;

        @BindView(R.id.shelf_status)
        View shelf_status;

        @BindView(R.id.tv_bookName)
        TextView tvBookName;

        @BindView(R.id.tv_percent_list)
        TextView tvPercentList;

        @BindView(R.id.tv_time_list)
        TextView tvTimeList;

        ListViewHolder(MkFattenBeanItem mkFattenBeanItem, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ListViewHolder_ViewBinding implements Unbinder {
        private ListViewHolder a;

        @UiThread
        public ListViewHolder_ViewBinding(ListViewHolder listViewHolder, View view) {
            this.a = listViewHolder;
            listViewHolder.iv_bookImg0 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg0, "field 'iv_bookImg0'", ImageView.class);
            listViewHolder.iv_bookImg1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg1, "field 'iv_bookImg1'", ImageView.class);
            listViewHolder.iv_bookImg2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg2, "field 'iv_bookImg2'", ImageView.class);
            listViewHolder.iv_bookImg3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg3, "field 'iv_bookImg3'", ImageView.class);
            listViewHolder.shelf_more = (ImageView) Utils.findRequiredViewAsType(view, R.id.shelf_more, "field 'shelf_more'", ImageView.class);
            listViewHolder.tvBookName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName, "field 'tvBookName'", TextView.class);
            listViewHolder.tvPercentList = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_percent_list, "field 'tvPercentList'", TextView.class);
            listViewHolder.tvTimeList = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time_list, "field 'tvTimeList'", TextView.class);
            listViewHolder.shelf_status = Utils.findRequiredView(view, R.id.shelf_status, "field 'shelf_status'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ListViewHolder listViewHolder = this.a;
            if (listViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            listViewHolder.iv_bookImg0 = null;
            listViewHolder.iv_bookImg1 = null;
            listViewHolder.iv_bookImg2 = null;
            listViewHolder.iv_bookImg3 = null;
            listViewHolder.shelf_more = null;
            listViewHolder.tvBookName = null;
            listViewHolder.tvPercentList = null;
            listViewHolder.tvTimeList = null;
            listViewHolder.shelf_status = null;
        }
    }

    public MkFattenBeanItem(MkBookshelfFragment mkBookshelfFragment, me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
        this.f3105c = mkBookshelfFragment;
    }

    public /* synthetic */ void b(MkFattenBean mkFattenBean, Context context, View view) {
        a(mkFattenBean, context);
    }

    public /* synthetic */ void b(View view) {
        MkBookshelfFragment mkBookshelfFragment = this.f3105c;
        if (mkBookshelfFragment != null) {
            mkBookshelfFragment.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public com.amgcyo.cuttadon.adapter.other.p a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.item_shelf_list_fatten, viewGroup, false);
        if (this.f3105c.G == 1) {
            return new GridViewHolder(this, layoutInflater.inflate(R.layout.item_shelf_grid_fatten, viewGroup, false));
        }
        return new ListViewHolder(this, viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull com.amgcyo.cuttadon.adapter.other.p pVar, @NonNull MkFattenBean mkFattenBean) {
        int i2 = this.f3105c.G;
        if (i2 == 0) {
            a((ListViewHolder) pVar, mkFattenBean);
        } else if (i2 == 1) {
            a((GridViewHolder) pVar, mkFattenBean);
        }
    }

    private void a(GridViewHolder gridViewHolder, final MkFattenBean mkFattenBean) {
        final Context context = gridViewHolder.itemView.getContext();
        List<String> categoryPics = mkFattenBean.getCategoryPics();
        gridViewHolder.iv_bookImg0.setImageResource(R.drawable.category1);
        gridViewHolder.iv_bookImg1.setImageResource(R.drawable.category2);
        gridViewHolder.iv_bookImg2.setImageResource(R.drawable.category3);
        gridViewHolder.iv_bookImg3.setImageResource(R.drawable.category4);
        ImageView[] imageViewArr = {gridViewHolder.iv_bookImg0, gridViewHolder.iv_bookImg1, gridViewHolder.iv_bookImg2, gridViewHolder.iv_bookImg3};
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(categoryPics)) {
            if (categoryPics.size() > 4) {
                categoryPics = categoryPics.subList(0, 4);
            }
            for (int i2 = 0; i2 < categoryPics.size(); i2++) {
                this.b.a(context, ImageConfigImpl.builder().placeholder(R.drawable.icon_pic_def).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkFattenBean.getForm()), categoryPics.get(i2))).imageView(imageViewArr[i2]).build());
            }
        }
        gridViewHolder.tvBookName.setText(mkFattenBean.getTitle());
        gridViewHolder.tvTimeList.setText(String.format(Locale.getDefault(), "%d本%s在养肥...", Integer.valueOf(mkFattenBean.getFattenCount()), 1 == mkFattenBean.getForm() ? "书" : "漫画"));
        gridViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3115s.a(mkFattenBean, context, view);
            }
        });
        gridViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.f
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f3121s.a(view);
            }
        });
    }

    public /* synthetic */ void a(MkFattenBean mkFattenBean, Context context, View view) {
        a(mkFattenBean, context);
    }

    public /* synthetic */ boolean a(View view) {
        MkBookshelfFragment mkBookshelfFragment = this.f3105c;
        if (mkBookshelfFragment == null) {
            return true;
        }
        mkBookshelfFragment.l();
        return true;
    }

    private void a(ListViewHolder listViewHolder, final MkFattenBean mkFattenBean) {
        final Context context = listViewHolder.itemView.getContext();
        List<String> categoryPics = mkFattenBean.getCategoryPics();
        listViewHolder.iv_bookImg0.setImageResource(R.drawable.category1);
        listViewHolder.iv_bookImg1.setImageResource(R.drawable.category2);
        listViewHolder.iv_bookImg2.setImageResource(R.drawable.category3);
        listViewHolder.iv_bookImg3.setImageResource(R.drawable.category4);
        ImageView[] imageViewArr = {listViewHolder.iv_bookImg0, listViewHolder.iv_bookImg1, listViewHolder.iv_bookImg2, listViewHolder.iv_bookImg3};
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(categoryPics)) {
            if (categoryPics.size() > 4) {
                categoryPics = categoryPics.subList(0, 4);
            }
            for (int i2 = 0; i2 < categoryPics.size(); i2++) {
                this.b.a(context, ImageConfigImpl.builder().placeholder(R.drawable.icon_pic_def).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkFattenBean.getForm()), categoryPics.get(i2))).imageView(imageViewArr[i2]).build());
            }
        }
        listViewHolder.tvBookName.setText(mkFattenBean.getTitle());
        String str = 1 == mkFattenBean.getForm() ? "书" : "漫画";
        listViewHolder.tvPercentList.setText(String.format(Locale.getDefault(), "%d本%s在养肥...", Integer.valueOf(mkFattenBean.getFattenCount()), str));
        if (mkFattenBean.getFattenedCount() > 0) {
            listViewHolder.tvTimeList.setVisibility(0);
            listViewHolder.tvTimeList.setText(String.format(Locale.getDefault(), "%d本%s已养肥", Integer.valueOf(mkFattenBean.getFattenedCount()), str));
            listViewHolder.shelf_status.setVisibility(0);
        } else {
            listViewHolder.tvTimeList.setVisibility(4);
            listViewHolder.shelf_status.setVisibility(4);
        }
        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3118s.b(mkFattenBean, context, view);
            }
        });
        listViewHolder.shelf_more.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3114s.b(view);
            }
        });
    }

    private void a(MkFattenBean mkFattenBean, Context context) {
        if (mkFattenBean == null || context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("form", mkFattenBean.getForm());
        r0.startActivity(context, bundle, MkBookFattenActivity.class);
    }
}
