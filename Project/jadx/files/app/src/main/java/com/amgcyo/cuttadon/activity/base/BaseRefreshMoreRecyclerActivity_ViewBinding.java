package com.amgcyo.cuttadon.activity.base;

import android.R;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;

/* JADX INFO: loaded from: classes.dex */
public class BaseRefreshMoreRecyclerActivity_ViewBinding implements Unbinder {
    private BaseRefreshMoreRecyclerActivity a;

    @UiThread
    public BaseRefreshMoreRecyclerActivity_ViewBinding(BaseRefreshMoreRecyclerActivity baseRefreshMoreRecyclerActivity, View view) {
        this.a = baseRefreshMoreRecyclerActivity;
        baseRefreshMoreRecyclerActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list, "field 'recyclerView'", RecyclerView.class);
        baseRefreshMoreRecyclerActivity.ll_list_root = (LinearLayout) Utils.findOptionalViewAsType(view, com.fatcatfat.io.R.id.ll_list_root, "field 'll_list_root'", LinearLayout.class);
        baseRefreshMoreRecyclerActivity.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
        baseRefreshMoreRecyclerActivity.adFrameLayout = (AdFrameLayout) Utils.findOptionalViewAsType(view, com.fatcatfat.io.R.id.fl_ad, "field 'adFrameLayout'", AdFrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BaseRefreshMoreRecyclerActivity baseRefreshMoreRecyclerActivity = this.a;
        if (baseRefreshMoreRecyclerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        baseRefreshMoreRecyclerActivity.recyclerView = null;
        baseRefreshMoreRecyclerActivity.ll_list_root = null;
        baseRefreshMoreRecyclerActivity.mRefreshView = null;
        baseRefreshMoreRecyclerActivity.adFrameLayout = null;
    }
}
