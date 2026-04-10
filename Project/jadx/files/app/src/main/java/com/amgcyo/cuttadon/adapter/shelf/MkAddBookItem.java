package com.amgcyo.cuttadon.adapter.shelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.other.MkAddBook;
import com.amgcyo.cuttadon.fragment.books.MkBookshelfFragment;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkAddBookItem extends me.drakeet.multitype.b<MkAddBook, ViewHolder> {
    private MkBookshelfFragment b;

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_add)
        TextView tv_add;

        ViewHolder(MkAddBookItem mkAddBookItem, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.tv_add = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'tv_add'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.tv_add = null;
        }
    }

    public MkAddBookItem(MkBookshelfFragment mkBookshelfFragment) {
        this.b = mkBookshelfFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.item_shelf_list_addbook, viewGroup, false);
        if (this.b.G == 1) {
            viewInflate = layoutInflater.inflate(R.layout.item_shelf_grid_addbook, viewGroup, false);
        }
        return new ViewHolder(this, viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull MkAddBook mkAddBook) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3113s.a(view);
            }
        });
        viewHolder.tv_add.setText(1 == this.b.O ? "添加您喜欢的小说" : "添加您喜欢的漫画");
    }

    public /* synthetic */ void a(View view) {
        this.b.m();
    }
}
