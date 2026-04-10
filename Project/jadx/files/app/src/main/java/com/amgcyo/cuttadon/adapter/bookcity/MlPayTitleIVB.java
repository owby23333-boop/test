package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
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
import com.amgcyo.cuttadon.api.entity.fission5.PlayTitleBean;
import com.amgcyo.cuttadon.view.otherview.LeftDrawableCenterTextView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MlPayTitleIVB extends me.drakeet.multitype.b<PlayTitleBean, ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        LeftDrawableCenterTextView tv_title;

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
            viewHolder.tv_title = (LeftDrawableCenterTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", LeftDrawableCenterTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.tv_title = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.paly_title_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull PlayTitleBean playTitleBean) {
        viewHolder.tv_title.setText(playTitleBean.getTitle());
        Context context = viewHolder.itemView.getContext();
        com.amgcyo.cuttadon.f.o.a(viewHolder.tv_title, context.getResources().getDrawable(playTitleBean.getResId()));
        viewHolder.tv_title.setCompoundDrawablePadding(context.getResources().getDimensionPixelOffset(R.dimen.dimen5dp));
    }
}
