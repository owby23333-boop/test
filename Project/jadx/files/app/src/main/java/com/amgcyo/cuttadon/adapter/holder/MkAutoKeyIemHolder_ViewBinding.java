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
public class MkAutoKeyIemHolder_ViewBinding implements Unbinder {
    private MkAutoKeyIemHolder a;

    @UiThread
    public MkAutoKeyIemHolder_ViewBinding(MkAutoKeyIemHolder mkAutoKeyIemHolder, View view) {
        this.a = mkAutoKeyIemHolder;
        mkAutoKeyIemHolder.ivIconSeach = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivIconSeach, "field 'ivIconSeach'", ImageView.class);
        mkAutoKeyIemHolder.tvAutoCompleteItem = (TextView) Utils.findRequiredViewAsType(view, R.id.tvAutoCompleteItem, "field 'tvAutoCompleteItem'", TextView.class);
        mkAutoKeyIemHolder.tv_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'tv_type'", TextView.class);
        mkAutoKeyIemHolder.autoStatus = Utils.findRequiredView(view, R.id.auto_status, "field 'autoStatus'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkAutoKeyIemHolder mkAutoKeyIemHolder = this.a;
        if (mkAutoKeyIemHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkAutoKeyIemHolder.ivIconSeach = null;
        mkAutoKeyIemHolder.tvAutoCompleteItem = null;
        mkAutoKeyIemHolder.tv_type = null;
        mkAutoKeyIemHolder.autoStatus = null;
    }
}
