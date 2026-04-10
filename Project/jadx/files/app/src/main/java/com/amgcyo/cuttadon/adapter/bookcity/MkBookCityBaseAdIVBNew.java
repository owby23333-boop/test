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
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBookCityBaseAdIVBNew extends me.drakeet.multitype.b<NormalAdParams, ViewHolder> {
    private int b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fl_ad)
        AdFrameLayout adFrameLayout;

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
            viewHolder.adFrameLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_ad, "field 'adFrameLayout'", AdFrameLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.adFrameLayout = null;
        }
    }

    public MkBookCityBaseAdIVBNew(Context context) {
        this.b = (int) com.amgcyo.cuttadon.utils.otherutils.n.d(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.book_city_item_adview, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull NormalAdParams normalAdParams) {
        if (normalAdParams.getAdWidth() > 0) {
            int iA = com.amgcyo.cuttadon.utils.otherutils.n.a((this.b - r0) / 2);
            String str = "setMarginsPx:" + iA;
            com.amgcyo.cuttadon.f.o.a(viewHolder.adFrameLayout, iA, 0, iA, 0);
        }
        viewHolder.adFrameLayout.b(normalAdParams);
    }
}
