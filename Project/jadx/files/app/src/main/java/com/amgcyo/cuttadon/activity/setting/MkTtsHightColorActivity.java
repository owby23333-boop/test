package com.amgcyo.cuttadon.activity.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.reader.ReadThemeBean;
import com.amgcyo.cuttadon.utils.otherutils.s0;
import com.amgcyo.cuttadon.view.colorpicker.XColorPicker;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkTtsHightColorActivity extends BaseTitleBarActivity {

    @BindView(R.id.ll_read_bg)
    LinearLayout ll_read_bg;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    String f2856n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    int f2857o0;

    @BindView(R.id.tv_test)
    TextView tvTest;

    @BindView(R.id.tv_theme_title)
    TextView tvThemeTitle;

    @BindView(R.id.xcolorpicker)
    XColorPicker xcolorpicker;

    private void n() {
        if (!TextUtils.isEmpty(this.f2856n0) && this.f2277w != null) {
            showMessage("修改成功");
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b(this.f2856n0, this.f2857o0);
            me.jessyan.art.d.f.a().a(Integer.valueOf(this.f2857o0), "tts_color");
        }
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(int i2, int i3) {
        this.tvTest.setTextColor(i2);
        this.f2857o0 = i2;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "请选择颜色";
    }

    public /* synthetic */ void e(View view) {
        n();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        com.amgcyo.cuttadon.view.read.page.k kVarC = com.amgcyo.cuttadon.view.read.page.k.c(this);
        if (kVarC == null) {
            showMessage("参数异常");
            finish();
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.k kVarH = kVarC.h();
        if (kVarH != null) {
            ReadThemeBean readThemeBeanA = kVarH.a();
            if (readThemeBeanA != null) {
                this.tvThemeTitle.setText(String.format("当前阅读主题：%s", readThemeBeanA.getName()));
                this.f2856n0 = readThemeBeanA.getKey();
                int iB = com.amgcyo.cuttadon.utils.otherutils.g0.a().b(this.f2856n0);
                if (iB == 0) {
                    showMessage("当前主题未设置高亮颜色，使用默认主题色");
                    iB = com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary);
                }
                this.tvTest.setTextColor(iB);
            }
            float fA = s0.a(this.f2277w, kVarC.b(this.f2277w));
            this.tvTest.setTextSize(0, fA);
            this.tvThemeTitle.setTextSize(0, fA);
            this.tvThemeTitle.setTextColor(kVarH.a);
            this.ll_read_bg.setBackgroundColor(kVarH.f4405i);
            this.xcolorpicker.setOnColorSelectListener(new com.amgcyo.cuttadon.view.colorpicker.a() { // from class: com.amgcyo.cuttadon.activity.setting.c0
                @Override // com.amgcyo.cuttadon.view.colorpicker.a
                public final void a(int i2, int i3) {
                    this.a.a(i2, i3);
                }
            });
        }
        this.D.setVisibility(0);
        this.D.setText("确定");
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2860s.e(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.tts_color_activity;
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
}
