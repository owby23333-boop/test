package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkQiushuFragemnt_ViewBinding implements Unbinder {
    private MkQiushuFragemnt a;

    @UiThread
    public MkQiushuFragemnt_ViewBinding(MkQiushuFragemnt mkQiushuFragemnt, View view) {
        this.a = mkQiushuFragemnt;
        mkQiushuFragemnt.head = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.head, "field 'head'", RelativeLayout.class);
        mkQiushuFragemnt.tb_select = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tb_select, "field 'tb_select'", XTabLayout.class);
        mkQiushuFragemnt.vp_classify = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_classify, "field 'vp_classify'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkQiushuFragemnt mkQiushuFragemnt = this.a;
        if (mkQiushuFragemnt == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkQiushuFragemnt.head = null;
        mkQiushuFragemnt.tb_select = null;
        mkQiushuFragemnt.vp_classify = null;
    }
}
