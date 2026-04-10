package com.amgcyo.cuttadon.activity.user;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.SearchView;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.amgcyo.cuttadon.view.slideview.SideBarLayout;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkAreaCodeActivity_ViewBinding extends BaseRefreshMoreRecyclerActivity_ViewBinding {
    private MkAreaCodeActivity b;

    @UiThread
    public MkAreaCodeActivity_ViewBinding(MkAreaCodeActivity mkAreaCodeActivity, View view) {
        super(mkAreaCodeActivity, view);
        this.b = mkAreaCodeActivity;
        mkAreaCodeActivity.sidebarView = (SideBarLayout) Utils.findRequiredViewAsType(view, R.id.sidebar, "field 'sidebarView'", SideBarLayout.class);
        mkAreaCodeActivity.toolbar_title = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.toolbar_title, "field 'toolbar_title'", CustomTextView.class);
        mkAreaCodeActivity.searchHolder = (SearchView) Utils.findRequiredViewAsType(view, R.id.searchHolder, "field 'searchHolder'", SearchView.class);
        mkAreaCodeActivity.iv_search = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_search, "field 'iv_search'", ImageView.class);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        MkAreaCodeActivity mkAreaCodeActivity = this.b;
        if (mkAreaCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        mkAreaCodeActivity.sidebarView = null;
        mkAreaCodeActivity.toolbar_title = null;
        mkAreaCodeActivity.searchHolder = null;
        mkAreaCodeActivity.iv_search = null;
        super.unbind();
    }
}
