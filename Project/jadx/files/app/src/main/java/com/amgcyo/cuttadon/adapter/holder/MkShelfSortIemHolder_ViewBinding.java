package com.amgcyo.cuttadon.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkShelfSortIemHolder_ViewBinding implements Unbinder {
    private MkShelfSortIemHolder a;

    @UiThread
    public MkShelfSortIemHolder_ViewBinding(MkShelfSortIemHolder mkShelfSortIemHolder, View view) {
        this.a = mkShelfSortIemHolder;
        mkShelfSortIemHolder.itemText = (TextView) Utils.findRequiredViewAsType(view, R.id.item_text, "field 'itemText'", TextView.class);
        mkShelfSortIemHolder.ivSelected = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_selected, "field 'ivSelected'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkShelfSortIemHolder mkShelfSortIemHolder = this.a;
        if (mkShelfSortIemHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkShelfSortIemHolder.itemText = null;
        mkShelfSortIemHolder.ivSelected = null;
    }
}
