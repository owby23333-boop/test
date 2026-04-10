package com.amgcyo.cuttadon.activity.main;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.fatcatfat.io.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MkNightModelActivity extends BaseTitleBarActivity {

    @BindView(R.id.csb_default)
    TextView csbDefault;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    boolean f2602n0;

    @BindView(R.id.sb_hyms)
    Switch sbHyms;

    @BindView(R.id.sb_yjms)
    Switch sbYjms;

    @BindView(R.id.seekBar_radio)
    SeekBar seekBarRadio;

    @BindView(R.id.tv_blue_radio)
    TextView tvBlueRadio;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            if (z2) {
                if (MkNightModelActivity.this.sbHyms.isChecked()) {
                    int i3 = i2 >= 10 ? i2 : 10;
                    MkNightModelActivity.this.tvBlueRadio.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i3)));
                    com.amgcyo.cuttadon.utils.otherutils.g.o(i3);
                    MkNightModelActivity.this.setChipioAppNightModel();
                    return;
                }
                MkNightModelActivity mkNightModelActivity = MkNightModelActivity.this;
                if (mkNightModelActivity.f2602n0) {
                    return;
                }
                mkNightModelActivity.showMessage("请先开启护眼模式");
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            com.amgcyo.cuttadon.utils.otherutils.g.e(true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g.e(false);
        }
        setChipioAppNightModel();
    }

    public /* synthetic */ void b(CompoundButton compoundButton, boolean z2) {
        com.amgcyo.cuttadon.utils.otherutils.g.d(z2);
        setChipioAppNightModel();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "夜间模式";
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.seekBarRadio.getThumb().setColorFilter(com.amgcyo.cuttadon.f.o.b(R.color.color_EC5C07), PorterDuff.Mode.SRC_ATOP);
        this.seekBarRadio.getProgressDrawable().setColorFilter(com.amgcyo.cuttadon.f.o.b(R.color.color_EC5C07), PorterDuff.Mode.SRC_ATOP);
        this.sbYjms.setChecked(com.amgcyo.cuttadon.utils.otherutils.g.h0());
        this.sbYjms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.main.i0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(compoundButton, z2);
            }
        });
        int iV = com.amgcyo.cuttadon.utils.otherutils.g.v();
        this.seekBarRadio.setProgress(iV);
        this.tvBlueRadio.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(iV)));
        this.sbHyms.setChecked(com.amgcyo.cuttadon.utils.otherutils.g.g0());
        this.sbHyms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.main.h0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.b(compoundButton, z2);
            }
        });
        this.seekBarRadio.setOnSeekBarChangeListener(new a());
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_night_model;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @OnClick({R.id.tv_blue_radio, R.id.csb_default})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.csb_default) {
            return;
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.g0()) {
            showMessage("请先开启护眼模式");
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.g.o(40);
        this.tvBlueRadio.setText(String.format(Locale.getDefault(), "%d%%", 40));
        this.seekBarRadio.setProgress(40);
        setChipioAppNightModel();
    }
}
