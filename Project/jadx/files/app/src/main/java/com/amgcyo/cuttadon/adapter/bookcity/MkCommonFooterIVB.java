package com.amgcyo.cuttadon.adapter.bookcity;

import android.text.TextUtils;
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
import com.amgcyo.cuttadon.api.entity.other.MkCommonFooter;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkCommonFooterIVB extends me.drakeet.multitype.b<MkCommonFooter, ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_bottom_text)
        TextView tv_bottom_text;

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
            viewHolder.tv_bottom_text = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bottom_text, "field 'tv_bottom_text'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.tv_bottom_text = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.common_footer_layout, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull MkCommonFooter mkCommonFooter) {
        if (TextUtils.isEmpty(mkCommonFooter.getFormat())) {
            return;
        }
        viewHolder.tv_bottom_text.setText(mkCommonFooter.getFormat());
    }
}
