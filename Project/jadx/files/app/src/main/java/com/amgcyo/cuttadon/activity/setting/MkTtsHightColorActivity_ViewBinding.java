package com.amgcyo.cuttadon.activity.setting;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.colorpicker.XColorPicker;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkTtsHightColorActivity_ViewBinding implements Unbinder {
    private MkTtsHightColorActivity a;

    @UiThread
    public MkTtsHightColorActivity_ViewBinding(MkTtsHightColorActivity mkTtsHightColorActivity, View view) {
        this.a = mkTtsHightColorActivity;
        mkTtsHightColorActivity.tvThemeTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_theme_title, "field 'tvThemeTitle'", TextView.class);
        mkTtsHightColorActivity.xcolorpicker = (XColorPicker) Utils.findRequiredViewAsType(view, R.id.xcolorpicker, "field 'xcolorpicker'", XColorPicker.class);
        mkTtsHightColorActivity.tvTest = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_test, "field 'tvTest'", TextView.class);
        mkTtsHightColorActivity.ll_read_bg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_read_bg, "field 'll_read_bg'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkTtsHightColorActivity mkTtsHightColorActivity = this.a;
        if (mkTtsHightColorActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkTtsHightColorActivity.tvThemeTitle = null;
        mkTtsHightColorActivity.xcolorpicker = null;
        mkTtsHightColorActivity.tvTest = null;
        mkTtsHightColorActivity.ll_read_bg = null;
    }
}
