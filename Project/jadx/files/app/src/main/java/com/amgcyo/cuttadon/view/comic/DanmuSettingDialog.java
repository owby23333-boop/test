package com.amgcyo.cuttadon.view.comic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.comic.ScaleSeekBar;
import com.fatcatfat.io.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DanmuSettingDialog extends com.google.android.material.bottomsheet.a {
    private View D;
    private MkComicsBaseReaderActivity E;
    private float F;

    @BindView(R.id.alpha_msg)
    TextView alpha_msg;

    @BindView(R.id.seekbar_alpha)
    SeekBar seekbar_alpha;

    @BindView(R.id.seekbar_size)
    ScaleSeekBar seekbar_size;

    @BindView(R.id.seekbar_speed)
    ScaleSeekBar seekbar_speed;

    @BindView(R.id.size_msg)
    TextView size_msg;

    @BindView(R.id.speed_msg)
    TextView speed_msg;

    @BindView(R.id.switch_danmu)
    Switch switch_danmu;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            int i3 = (int) (i2 / DanmuSettingDialog.this.F);
            if (i3 <= 0) {
                i3 = 1;
            }
            DanmuSettingDialog.this.alpha_msg.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i3)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            DanmuSettingDialog.this.E.notifyDanmuSetItemChanged(seekBar.getProgress(), 0, 0);
        }
    }

    public DanmuSettingDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, i2);
        this.F = 2.55f;
        a(context);
    }

    @SuppressLint({"SetTextI18n"})
    private void c() {
        this.switch_danmu.setChecked(this.E.isDanmuOpen);
        this.switch_danmu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.view.comic.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(compoundButton, z2);
            }
        });
        float f2 = this.E.alpha;
        this.seekbar_alpha.setProgress((int) f2);
        this.alpha_msg.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f2 / this.F))));
        this.seekbar_alpha.setOnSeekBarChangeListener(new a());
        this.seekbar_size.setLevel(this.E.level);
        this.seekbar_speed.setLevel(this.E.speed);
        d(this.E.level);
        c(this.E.speed);
        this.seekbar_size.setScaleSeekBarListener(new ScaleSeekBar.b() { // from class: com.amgcyo.cuttadon.view.comic.d
            @Override // com.amgcyo.cuttadon.view.comic.ScaleSeekBar.b
            public final void a(int i2) {
                this.a.a(i2);
            }
        });
        this.seekbar_speed.setScaleSeekBarListener(new ScaleSeekBar.b() { // from class: com.amgcyo.cuttadon.view.comic.c
            @Override // com.amgcyo.cuttadon.view.comic.ScaleSeekBar.b
            public final void a(int i2) {
                this.a.b(i2);
            }
        });
    }

    private void d(int i2) {
        a(i2, this.size_msg, "小", "较小", "标准", "较大", "大");
    }

    @OnClick({R.id.view_tr})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.view_tr) {
            return;
        }
        dismiss();
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

    private void a(Context context) {
        this.E = (MkComicsBaseReaderActivity) context;
        this.D = LayoutInflater.from(context).inflate(R.layout.reading_menu_danmu_set_vertical_layout, (ViewGroup) null);
        setContentView(this.D);
        ButterKnife.bind(this, this.D);
        c();
    }

    public /* synthetic */ void b(int i2) {
        c(i2);
        this.E.notifyDanmuSetItemChanged(-1.0f, 0, i2);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isPressed()) {
            this.E.switchDanmuStates();
        }
    }

    public /* synthetic */ void a(int i2) {
        d(i2);
        this.E.notifyDanmuSetItemChanged(-1.0f, i2, 0);
    }

    private void a(int i2, TextView textView, String str, String str2, String str3, String str4, String str5) {
        if (i2 == 1) {
            textView.setText(str);
            return;
        }
        if (i2 == 2) {
            textView.setText(str2);
            return;
        }
        if (i2 == 3) {
            textView.setText(str3);
        } else if (i2 == 4) {
            textView.setText(str4);
        } else {
            if (i2 != 5) {
                return;
            }
            textView.setText(str5);
        }
    }

    private void c(int i2) {
        a(i2, this.speed_msg, "0.5X", "0.75X", "1.0X", "1.25X", "1.5X");
    }
}
