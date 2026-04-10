package com.amgcyo.cuttadon.view.comic;

import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class DanmuSettingDialog_ViewBinding implements Unbinder {
    private DanmuSettingDialog a;
    private View b;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ DanmuSettingDialog f4461s;

        a(DanmuSettingDialog_ViewBinding danmuSettingDialog_ViewBinding, DanmuSettingDialog danmuSettingDialog) {
            this.f4461s = danmuSettingDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4461s.onViewClicked(view);
        }
    }

    @UiThread
    public DanmuSettingDialog_ViewBinding(DanmuSettingDialog danmuSettingDialog, View view) {
        this.a = danmuSettingDialog;
        danmuSettingDialog.seekbar_alpha = (SeekBar) Utils.findRequiredViewAsType(view, R.id.seekbar_alpha, "field 'seekbar_alpha'", SeekBar.class);
        danmuSettingDialog.seekbar_size = (ScaleSeekBar) Utils.findRequiredViewAsType(view, R.id.seekbar_size, "field 'seekbar_size'", ScaleSeekBar.class);
        danmuSettingDialog.seekbar_speed = (ScaleSeekBar) Utils.findRequiredViewAsType(view, R.id.seekbar_speed, "field 'seekbar_speed'", ScaleSeekBar.class);
        danmuSettingDialog.switch_danmu = (Switch) Utils.findRequiredViewAsType(view, R.id.switch_danmu, "field 'switch_danmu'", Switch.class);
        danmuSettingDialog.alpha_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.alpha_msg, "field 'alpha_msg'", TextView.class);
        danmuSettingDialog.size_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.size_msg, "field 'size_msg'", TextView.class);
        danmuSettingDialog.speed_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.speed_msg, "field 'speed_msg'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.view_tr, "method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, danmuSettingDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DanmuSettingDialog danmuSettingDialog = this.a;
        if (danmuSettingDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        danmuSettingDialog.seekbar_alpha = null;
        danmuSettingDialog.seekbar_size = null;
        danmuSettingDialog.seekbar_speed = null;
        danmuSettingDialog.switch_danmu = null;
        danmuSettingDialog.alpha_msg = null;
        danmuSettingDialog.size_msg = null;
        danmuSettingDialog.speed_msg = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
