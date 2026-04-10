package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment_ViewBinding;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkHotSearchFragment_ViewBinding extends BaseRefreshMoreRecyclerFragment_ViewBinding {
    private MkHotSearchFragment b;

    @UiThread
    public MkHotSearchFragment_ViewBinding(MkHotSearchFragment mkHotSearchFragment, View view) {
        super(mkHotSearchFragment, view);
        this.b = mkHotSearchFragment;
        mkHotSearchFragment.tvData = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_data, "field 'tvData'", TextView.class);
        mkHotSearchFragment.rl_timedata = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_timedata, "field 'rl_timedata'", RelativeLayout.class);
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        MkHotSearchFragment mkHotSearchFragment = this.b;
        if (mkHotSearchFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        mkHotSearchFragment.tvData = null;
        mkHotSearchFragment.rl_timedata = null;
        super.unbind();
    }
}
