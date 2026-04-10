package com.amgcyo.cuttadon.adapter.bookcity;

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
import com.amgcyo.cuttadon.api.entity.bookcity.v7.style.V7Style2Rank;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkV7Style2RankBookData extends me.drakeet.multitype.b<V7Style2Rank, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_bookImg)
        ImageView iv_bookImg;

        @BindView(R.id.tv_bookName)
        TextView tv_bookName;

        @BindView(R.id.tv_book_rank)
        TextView tv_book_rank;

        @BindView(R.id.tv_score)
        TextView tv_score;

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
            viewHolder.tv_score = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_score, "field 'tv_score'", TextView.class);
            viewHolder.tv_book_rank = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_book_rank, "field 'tv_book_rank'", TextView.class);
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
            viewHolder.tv_score = null;
            viewHolder.tv_book_rank = null;
        }
    }

    public MkV7Style2RankBookData(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.bookcity_v7style2_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final V7Style2Rank v7Style2Rank) {
        final Context context = viewHolder.itemView.getContext();
        this.b.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(v7Style2Rank.getForm()), v7Style2Rank.getImage())).imageView(viewHolder.iv_bookImg).build());
        int id = v7Style2Rank.getId();
        viewHolder.tv_book_rank.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(id)));
        if (id == 1) {
            viewHolder.tv_book_rank.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        } else if (id == 2) {
            viewHolder.tv_book_rank.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.color_2));
        } else if (id != 3) {
            viewHolder.tv_book_rank.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.color_CCCCCC));
        } else {
            viewHolder.tv_book_rank.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.color_3));
        }
        viewHolder.tv_bookName.setText(v7Style2Rank.getName());
        viewHolder.tv_score.setText(String.format("%s分", v7Style2Rank.getScore()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context2 = context;
                V7Style2Rank v7Style2Rank2 = v7Style2Rank;
                r0.a(context2, v7Style2Rank2.getBook_id(), v7Style2Rank2.getForm());
            }
        });
    }
}
