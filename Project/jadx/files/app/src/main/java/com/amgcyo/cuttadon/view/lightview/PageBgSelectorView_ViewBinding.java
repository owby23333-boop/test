package com.amgcyo.cuttadon.view.lightview;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class PageBgSelectorView_ViewBinding implements Unbinder {
    private PageBgSelectorView a;

    @UiThread
    public PageBgSelectorView_ViewBinding(PageBgSelectorView pageBgSelectorView, View view) {
        this.a = pageBgSelectorView;
        pageBgSelectorView.riWgInside = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.riWgInside, "field 'riWgInside'", RoundedImageView.class);
        pageBgSelectorView.ivWgCenter = (ImageView) Utils.findRequiredViewAsType(view, R.id.ivWgCenter, "field 'ivWgCenter'", ImageView.class);
        pageBgSelectorView.riWgOutside = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.riWgOutside, "field 'riWgOutside'", RoundedImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PageBgSelectorView pageBgSelectorView = this.a;
        if (pageBgSelectorView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        pageBgSelectorView.riWgInside = null;
        pageBgSelectorView.ivWgCenter = null;
        pageBgSelectorView.riWgOutside = null;
    }
}
