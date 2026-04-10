package com.amgcyo.cuttadon.activity.base;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class BaseXTablayoutActivity_ViewBinding implements Unbinder {
    private BaseXTablayoutActivity a;

    @UiThread
    public BaseXTablayoutActivity_ViewBinding(BaseXTablayoutActivity baseXTablayoutActivity, View view) {
        this.a = baseXTablayoutActivity;
        baseXTablayoutActivity.vpClassify = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_classify, "field 'vpClassify'", ViewPager.class);
        baseXTablayoutActivity.adFrameLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_ad, "field 'adFrameLayout'", AdFrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BaseXTablayoutActivity baseXTablayoutActivity = this.a;
        if (baseXTablayoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        baseXTablayoutActivity.vpClassify = null;
        baseXTablayoutActivity.adFrameLayout = null;
    }
}
