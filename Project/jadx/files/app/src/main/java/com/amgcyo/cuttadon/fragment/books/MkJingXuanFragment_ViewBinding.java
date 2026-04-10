package com.amgcyo.cuttadon.fragment.books;

import android.R;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/* JADX INFO: loaded from: classes.dex */
public class MkJingXuanFragment_ViewBinding implements Unbinder {
    private MkJingXuanFragment a;

    @UiThread
    public MkJingXuanFragment_ViewBinding(MkJingXuanFragment mkJingXuanFragment, View view) {
        this.a = mkJingXuanFragment;
        mkJingXuanFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list, "field 'mRecyclerView'", RecyclerView.class);
        mkJingXuanFragment.ll_root = (LinearLayout) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.ll_root, "field 'll_root'", LinearLayout.class);
        mkJingXuanFragment.mRefreshView = (TwinklingRefreshLayout) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.swipe_refresh_layout, "field 'mRefreshView'", TwinklingRefreshLayout.class);
        mkJingXuanFragment.shimmerframelayout = (FrameLayout) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.shimmerframelayout, "field 'shimmerframelayout'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkJingXuanFragment mkJingXuanFragment = this.a;
        if (mkJingXuanFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkJingXuanFragment.mRecyclerView = null;
        mkJingXuanFragment.ll_root = null;
        mkJingXuanFragment.mRefreshView = null;
        mkJingXuanFragment.shimmerframelayout = null;
    }
}
