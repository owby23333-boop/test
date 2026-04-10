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
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkFattenItem extends me.drakeet.multitype.b<MkBook, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.a f3106c;

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_bookImg)
        ImageView ivBookImg;

        @BindView(R.id.shelf_more)
        TextView shelf_more;

        @BindView(R.id.tv_bookName)
        TextView tvBookName;

        @BindView(R.id.tv_percent_list)
        TextView tvPercentList;

        ViewHolder(MkFattenItem mkFattenItem, View view) {
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
            viewHolder.tvBookName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName, "field 'tvBookName'", TextView.class);
            viewHolder.shelf_more = (TextView) Utils.findRequiredViewAsType(view, R.id.shelf_more, "field 'shelf_more'", TextView.class);
            viewHolder.tvPercentList = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_percent_list, "field 'tvPercentList'", TextView.class);
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
            viewHolder.tvBookName = null;
            viewHolder.shelf_more = null;
            viewHolder.tvPercentList = null;
        }
    }

    public MkFattenItem(me.jessyan.art.c.e.c cVar, com.amgcyo.cuttadon.g.a aVar) {
        this.b = cVar;
        this.f3106c = aVar;
    }

    public /* synthetic */ void b(MkBook mkBook, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3106c;
        if (aVar != null) {
            aVar.onItemClick(mkBook);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(this, layoutInflater.inflate(R.layout.item_shelf_list_fattenbook, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final MkBook mkBook) {
        Context context = viewHolder.itemView.getContext();
        viewHolder.tvBookName.setText(mkBook.getName());
        viewHolder.tvPercentList.setText(String.format(Locale.getDefault(), "养了%d章未读", Integer.valueOf(mkBook.getFatten_num())));
        this.b.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(viewHolder.ivBookImg).build());
        viewHolder.shelf_more.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3122s.a(mkBook, view);
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3124s.b(mkBook, view);
            }
        });
    }

    public /* synthetic */ void a(MkBook mkBook, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3106c;
        if (aVar != null) {
            aVar.moreClickListener(mkBook);
        }
    }
}
