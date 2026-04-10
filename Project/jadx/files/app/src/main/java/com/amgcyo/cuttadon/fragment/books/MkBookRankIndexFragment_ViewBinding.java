package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBookRankIndexFragment_ViewBinding implements Unbinder {
    private MkBookRankIndexFragment a;

    @UiThread
    public MkBookRankIndexFragment_ViewBinding(MkBookRankIndexFragment mkBookRankIndexFragment, View view) {
        this.a = mkBookRankIndexFragment;
        mkBookRankIndexFragment.left_rv_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.left_rv_view, "field 'left_rv_view'", RecyclerView.class);
        mkBookRankIndexFragment.right_rv_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.right_rv_view, "field 'right_rv_view'", RecyclerView.class);
        mkBookRankIndexFragment.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
        mkBookRankIndexFragment.adFrameLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_ad, "field 'adFrameLayout'", AdFrameLayout.class);
        mkBookRankIndexFragment.ll_line = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_line, "field 'll_line'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBookRankIndexFragment mkBookRankIndexFragment = this.a;
        if (mkBookRankIndexFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBookRankIndexFragment.left_rv_view = null;
        mkBookRankIndexFragment.right_rv_view = null;
        mkBookRankIndexFragment.mRefreshView = null;
        mkBookRankIndexFragment.adFrameLayout = null;
        mkBookRankIndexFragment.ll_line = null;
    }
}
