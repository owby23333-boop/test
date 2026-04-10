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
public class MkFattenNumHolder_ViewBinding implements Unbinder {
    private MkFattenNumHolder a;

    @UiThread
    public MkFattenNumHolder_ViewBinding(MkFattenNumHolder mkFattenNumHolder, View view) {
        this.a = mkFattenNumHolder;
        mkFattenNumHolder.itemText = (TextView) Utils.findRequiredViewAsType(view, R.id.item_text, "field 'itemText'", TextView.class);
        mkFattenNumHolder.ivSelected = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_selected, "field 'ivSelected'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkFattenNumHolder mkFattenNumHolder = this.a;
        if (mkFattenNumHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkFattenNumHolder.itemText = null;
        mkFattenNumHolder.ivSelected = null;
    }
}
