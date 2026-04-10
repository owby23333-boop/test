package com.amgcyo.cuttadon.activity.read;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.SearchView;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkMp3FileScanerActivity_ViewBinding extends BaseRefreshMoreRecyclerActivity_ViewBinding {
    private MkMp3FileScanerActivity b;

    @UiThread
    public MkMp3FileScanerActivity_ViewBinding(MkMp3FileScanerActivity mkMp3FileScanerActivity, View view) {
        super(mkMp3FileScanerActivity, view);
        this.b = mkMp3FileScanerActivity;
        mkMp3FileScanerActivity.toolbar_title = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.toolbar_title, "field 'toolbar_title'", CustomTextView.class);
        mkMp3FileScanerActivity.searchHolder = (SearchView) Utils.findRequiredViewAsType(view, R.id.searchHolder, "field 'searchHolder'", SearchView.class);
        mkMp3FileScanerActivity.iv_search = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_search, "field 'iv_search'", ImageView.class);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        MkMp3FileScanerActivity mkMp3FileScanerActivity = this.b;
        if (mkMp3FileScanerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        mkMp3FileScanerActivity.toolbar_title = null;
        mkMp3FileScanerActivity.searchHolder = null;
        mkMp3FileScanerActivity.iv_search = null;
        super.unbind();
    }
}
