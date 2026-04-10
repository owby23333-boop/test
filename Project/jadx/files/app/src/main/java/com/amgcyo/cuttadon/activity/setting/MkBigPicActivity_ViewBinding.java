package com.amgcyo.cuttadon.activity.setting;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBigPicActivity_ViewBinding implements Unbinder {
    private MkBigPicActivity a;

    @UiThread
    public MkBigPicActivity_ViewBinding(MkBigPicActivity mkBigPicActivity, View view) {
        this.a = mkBigPicActivity;
        mkBigPicActivity.img_big = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_big, "field 'img_big'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBigPicActivity mkBigPicActivity = this.a;
        if (mkBigPicActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBigPicActivity.img_big = null;
    }
}
