package com.amgcyo.cuttadon.adapter.shelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.other.MkAddBook;
import com.amgcyo.cuttadon.view.dialog.n1;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkAddBookDialogItem extends me.drakeet.multitype.b<MkAddBook, ViewHolder> {
    private n1.c b;

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_add)
        ImageView iv_add;

        ViewHolder(MkAddBookDialogItem mkAddBookDialogItem, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.iv_add = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_add, "field 'iv_add'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.iv_add = null;
        }
    }

    public MkAddBookDialogItem(n1.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(this, layoutInflater.inflate(R.layout.item_shelf_category_grid, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull MkAddBook mkAddBook) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3112s.a(view);
            }
        });
    }

    public /* synthetic */ void a(View view) {
        n1.c cVar = this.b;
        if (cVar != null) {
            cVar.a();
        }
    }
}
