package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public class ReadMoreSettingDialog extends com.google.android.material.bottomsheet.a {
    private View D;
    private MkComicsBaseReaderActivity E;

    @BindView(R.id.cb_cross_mode_read)
    CheckBox cbCrossModeRead;

    @BindView(R.id.cb_left_mode_read)
    CheckBox cbLeftModeRead;

    @BindView(R.id.cb_right_mode_read)
    CheckBox cbRightModeRead;

    @BindView(R.id.cb_vertical_mode_read)
    CheckBox cbVerticalModeRead;

    @BindView(R.id.tv_more_setting)
    TextView tvMoreSetting;

    public ReadMoreSettingDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, i2);
        a(context);
    }

    private void a(Context context) {
        this.E = (MkComicsBaseReaderActivity) context;
        this.D = LayoutInflater.from(context).inflate(R.layout.dialog_read_more_setting, (ViewGroup) null);
        setContentView(this.D);
        ButterKnife.bind(this, this.D);
        c();
    }

    private void c() {
        MkComicsBaseReaderActivity mkComicsBaseReaderActivity = this.E;
        int i2 = mkComicsBaseReaderActivity.mode;
        int i3 = mkComicsBaseReaderActivity.orientation;
        int i4 = mkComicsBaseReaderActivity.turn;
        if (1 != i2) {
            this.cbVerticalModeRead.setEnabled(true);
            if (i4 == 0) {
                this.cbRightModeRead.setChecked(true);
                this.cbRightModeRead.setEnabled(false);
                this.cbLeftModeRead.setChecked(false);
                this.cbLeftModeRead.setEnabled(true);
                return;
            }
            this.cbRightModeRead.setChecked(false);
            this.cbRightModeRead.setEnabled(true);
            this.cbLeftModeRead.setChecked(true);
            this.cbLeftModeRead.setEnabled(false);
            return;
        }
        if (1 == i3) {
            this.cbCrossModeRead.setChecked(false);
            this.cbCrossModeRead.setEnabled(true);
            this.cbVerticalModeRead.setChecked(true);
            this.cbVerticalModeRead.setEnabled(false);
        } else {
            this.cbCrossModeRead.setChecked(true);
            this.cbCrossModeRead.setEnabled(false);
            this.cbVerticalModeRead.setChecked(false);
            this.cbVerticalModeRead.setEnabled(true);
        }
        this.cbRightModeRead.setChecked(false);
        this.cbLeftModeRead.setChecked(false);
        this.cbRightModeRead.setEnabled(true);
        this.cbLeftModeRead.setEnabled(true);
    }

    @OnClick({R.id.view_tr, R.id.ll_more_setting, R.id.cb_right_mode_read, R.id.cb_left_mode_read, R.id.cb_vertical_mode_read, R.id.cb_cross_mode_read})
    public void onViewClicked(View view) {
        dismiss();
        int id = view.getId();
        if (id == R.id.ll_more_setting) {
            this.E.openComicSettingActivity();
        }
        if (id == R.id.view_tr) {
            dismiss();
            return;
        }
        switch (id) {
            case R.id.cb_cross_mode_read /* 2131296782 */:
                this.E.swtichReadModel(2, 0);
                break;
            case R.id.cb_left_mode_read /* 2131296783 */:
                this.E.swtichReadModel(1, 1);
                break;
            case R.id.cb_right_mode_read /* 2131296784 */:
                this.E.swtichReadModel(0, 1);
                break;
            case R.id.cb_vertical_mode_read /* 2131296785 */:
                this.E.swtichReadModel(2, 1);
                break;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            View view = (View) this.D.getParent();
            if (view != null) {
                view.setBackgroundResource(R.color.colorTransparent);
                BottomSheetBehavior bottomSheetBehaviorB = BottomSheetBehavior.b(view);
                bottomSheetBehaviorB.f(4);
                bottomSheetBehaviorB.d(n.a(this.E));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.show();
    }
}
