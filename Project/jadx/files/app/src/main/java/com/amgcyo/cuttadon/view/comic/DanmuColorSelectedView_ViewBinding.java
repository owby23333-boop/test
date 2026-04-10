package com.amgcyo.cuttadon.view.comic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class DanmuColorSelectedView_ViewBinding implements Unbinder {
    private DanmuColorSelectedView a;

    @UiThread
    public DanmuColorSelectedView_ViewBinding(DanmuColorSelectedView danmuColorSelectedView, View view) {
        this.a = danmuColorSelectedView;
        danmuColorSelectedView.tv_inside = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_inside, "field 'tv_inside'", TextView.class);
        danmuColorSelectedView.iv_inside = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_inside, "field 'iv_inside'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DanmuColorSelectedView danmuColorSelectedView = this.a;
        if (danmuColorSelectedView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        danmuColorSelectedView.tv_inside = null;
        danmuColorSelectedView.iv_inside = null;
    }
}
