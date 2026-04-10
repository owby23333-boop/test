package com.amgcyo.cuttadon.fragment.base;

import android.R;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;

/* JADX INFO: loaded from: classes.dex */
public class BaseRefreshMoreRecyclerFragment_ViewBinding implements Unbinder {
    private BaseRefreshMoreRecyclerFragment a;

    @UiThread
    public BaseRefreshMoreRecyclerFragment_ViewBinding(BaseRefreshMoreRecyclerFragment baseRefreshMoreRecyclerFragment, View view) {
        this.a = baseRefreshMoreRecyclerFragment;
        baseRefreshMoreRecyclerFragment.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list, "field 'recyclerView'", RecyclerView.class);
        baseRefreshMoreRecyclerFragment.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
        baseRefreshMoreRecyclerFragment.adFrameLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.fl_ad, "field 'adFrameLayout'", AdFrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BaseRefreshMoreRecyclerFragment baseRefreshMoreRecyclerFragment = this.a;
        if (baseRefreshMoreRecyclerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        baseRefreshMoreRecyclerFragment.recyclerView = null;
        baseRefreshMoreRecyclerFragment.mRefreshView = null;
        baseRefreshMoreRecyclerFragment.adFrameLayout = null;
    }
}
