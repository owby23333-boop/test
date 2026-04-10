package com.amgcyo.cuttadon.adapter.cleanup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: classes.dex */
public class CleanupBeanItemViewBinder extends b<ShelfCategory, ViewHolder> {
    private a b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_root)
        LinearLayout ll_root;

        @BindView(R.id.tv_cleanup_num)
        TextView tv_cleanup_num;

        @BindView(R.id.tv_cleanup_title)
        TextView tv_cleanup_title;

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
            viewHolder.tv_cleanup_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cleanup_title, "field 'tv_cleanup_title'", TextView.class);
            viewHolder.tv_cleanup_num = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cleanup_num, "field 'tv_cleanup_num'", TextView.class);
            viewHolder.ll_root = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root, "field 'll_root'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.tv_cleanup_title = null;
            viewHolder.tv_cleanup_num = null;
            viewHolder.ll_root = null;
        }
    }

    public interface a {
        void a(ShelfCategory shelfCategory);
    }

    public CleanupBeanItemViewBinder(a aVar) {
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.cleanup_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final ShelfCategory shelfCategory) {
        viewHolder.tv_cleanup_title.setText(g.u(shelfCategory.getCategoryName()));
        viewHolder.tv_cleanup_num.setText(String.format(Locale.getDefault(), "(共%d本)", Integer.valueOf(shelfCategory.getCategoryCount())));
        viewHolder.ll_root.setSelected(shelfCategory.isSelected());
        viewHolder.ll_root.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.cleanup.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3050s.a(shelfCategory, view);
            }
        });
    }

    public /* synthetic */ void a(ShelfCategory shelfCategory, View view) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(shelfCategory);
        }
    }
}
