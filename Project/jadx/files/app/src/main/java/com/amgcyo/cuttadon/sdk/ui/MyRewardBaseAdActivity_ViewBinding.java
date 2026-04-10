package com.amgcyo.cuttadon.sdk.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.LabelTextView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MyRewardBaseAdActivity_ViewBinding implements Unbinder {
    private MyRewardBaseAdActivity a;

    @UiThread
    public MyRewardBaseAdActivity_ViewBinding(MyRewardBaseAdActivity myRewardBaseAdActivity, View view) {
        this.a = myRewardBaseAdActivity;
        myRewardBaseAdActivity.ll_continue_root = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_continue_root, "field 'll_continue_root'", LinearLayout.class);
        myRewardBaseAdActivity.continue_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.continue_img, "field 'continue_img'", ImageView.class);
        myRewardBaseAdActivity.labeltextview = (LabelTextView) Utils.findRequiredViewAsType(view, R.id.labeltextview, "field 'labeltextview'", LabelTextView.class);
        myRewardBaseAdActivity.material_background = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.material_background, "field 'material_background'", LinearLayout.class);
        myRewardBaseAdActivity.dialog_message = (TextView) Utils.findRequiredViewAsType(view, R.id.dialog_message, "field 'dialog_message'", TextView.class);
        myRewardBaseAdActivity.dialog_tv_ok = (TextView) Utils.findRequiredViewAsType(view, R.id.dialog_tv_ok, "field 'dialog_tv_ok'", TextView.class);
        myRewardBaseAdActivity.cons_root_have_net = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cons_root_have_net, "field 'cons_root_have_net'", ConstraintLayout.class);
        myRewardBaseAdActivity.tv_look_video_have_net = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_look_video_have_net, "field 'tv_look_video_have_net'", TextView.class);
        myRewardBaseAdActivity.tv_tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tv_tip'", TextView.class);
        myRewardBaseAdActivity.tv_not_have_net = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_not_have_net, "field 'tv_not_have_net'", TextView.class);
        myRewardBaseAdActivity.tv_read_time_have_net = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_read_time_have_net, "field 'tv_read_time_have_net'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyRewardBaseAdActivity myRewardBaseAdActivity = this.a;
        if (myRewardBaseAdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        myRewardBaseAdActivity.ll_continue_root = null;
        myRewardBaseAdActivity.continue_img = null;
        myRewardBaseAdActivity.labeltextview = null;
        myRewardBaseAdActivity.material_background = null;
        myRewardBaseAdActivity.dialog_message = null;
        myRewardBaseAdActivity.dialog_tv_ok = null;
        myRewardBaseAdActivity.cons_root_have_net = null;
        myRewardBaseAdActivity.tv_look_video_have_net = null;
        myRewardBaseAdActivity.tv_tip = null;
        myRewardBaseAdActivity.tv_not_have_net = null;
        myRewardBaseAdActivity.tv_read_time_have_net = null;
    }
}
