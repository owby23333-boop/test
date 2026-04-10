package com.amgcyo.cuttadon.activity.bookcity;

import android.R;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;

/* JADX INFO: loaded from: classes.dex */
public class MkBookFattenActivity_ViewBinding implements Unbinder {
    private MkBookFattenActivity a;

    @UiThread
    public MkBookFattenActivity_ViewBinding(MkBookFattenActivity mkBookFattenActivity, View view) {
        this.a = mkBookFattenActivity;
        mkBookFattenActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list, "field 'mRecyclerView'", RecyclerView.class);
        mkBookFattenActivity.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
        mkBookFattenActivity.adFrameLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.fl_ad, "field 'adFrameLayout'", AdFrameLayout.class);
        mkBookFattenActivity.feed_intro_btn = (TextView) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.feed_intro_btn, "field 'feed_intro_btn'", TextView.class);
        mkBookFattenActivity.ll_fatten_info = (LinearLayout) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.ll_fatten_info, "field 'll_fatten_info'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBookFattenActivity mkBookFattenActivity = this.a;
        if (mkBookFattenActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBookFattenActivity.mRecyclerView = null;
        mkBookFattenActivity.mRefreshView = null;
        mkBookFattenActivity.adFrameLayout = null;
        mkBookFattenActivity.feed_intro_btn = null;
        mkBookFattenActivity.ll_fatten_info = null;
    }
}
