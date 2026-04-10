package com.amgcyo.cuttadon.adapter.bookcity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.other.WanyiwanBean;
import com.amgcyo.cuttadon.view.otherview.WanyiwanView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkWanyiwanIVB extends me.drakeet.multitype.b<WanyiwanBean, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.wanyiwanview)
        WanyiwanView wanyiwanview;

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
            viewHolder.wanyiwanview = (WanyiwanView) Utils.findRequiredViewAsType(view, R.id.wanyiwanview, "field 'wanyiwanview'", WanyiwanView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.wanyiwanview = null;
        }
    }

    public MkWanyiwanIVB(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.mk_wanyiwan_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull WanyiwanBean wanyiwanBean) {
        if (viewHolder.wanyiwanview.a()) {
            return;
        }
        viewHolder.wanyiwanview.a(this.b, wanyiwanBean.getLocation(), viewHolder.itemView.getContext(), wanyiwanBean.getAdCount());
    }
}
