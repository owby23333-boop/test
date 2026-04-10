package com.amgcyo.cuttadon.activity.read;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.LocalMp3Bean;
import com.amgcyo.cuttadon.f.s.a;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MkSettingBgmActivity extends BaseTitleBarActivity {

    @BindView(R.id.cb_bgm_switch)
    CheckBox cbBgmSwitch;

    @BindView(R.id.ll_find_bgm)
    LinearLayout llFindBgm;

    @BindView(R.id.ll_selector_bgm)
    LinearLayout llSelectorBgm;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f2721n0;

    @BindView(R.id.seekBar_bgm)
    SeekBar seekBarBgm;

    @BindView(R.id.tv_bgm_volume)
    TextView tvBgmVolume;

    @BindView(R.id.tv_current_gbm_name)
    TextView tvCurrentGbmName;

    class a implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        a(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            MkSettingBgmActivity mkSettingBgmActivity = MkSettingBgmActivity.this;
            if (mkSettingBgmActivity.f2721n0 == 0) {
                mkSettingBgmActivity.showMessage("请先开启朗读时播放背景音乐");
                MkSettingBgmActivity.this.seekBarBgm.setProgress(this.a);
                return;
            }
            int progress = seekBar.getProgress();
            String str = "音量值：" + progress;
            int i2 = this.b;
            if (progress > i2) {
                progress = i2;
            }
            TextView textView = MkSettingBgmActivity.this.tvBgmVolume;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "背景音乐音量：%d", Integer.valueOf(progress)));
            }
            float f2 = progress / 100.0f;
            String str2 = "展示给用户看的：" + progress + " 程序记录的：" + f2;
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("tts_bgm_volume_float", f2);
            me.jessyan.art.d.f.a().a(1, "tts_bgm");
        }
    }

    class b implements com.hjq.permissions.a {
        b() {
        }

        @Override // com.hjq.permissions.a
        public void a(List<String> list, boolean z2) {
            MkSettingBgmActivity.this.showMessage("获取权限失败，请手动授予权限!");
            com.hjq.permissions.f.a((Activity) MkSettingBgmActivity.this, list);
        }

        @Override // com.hjq.permissions.a
        public void b(List<String> list, boolean z2) {
            MkSettingBgmActivity.this.showMessage("获取权限成功!");
            MkSettingBgmActivity.this.o();
        }
    }

    private void n() {
        if (com.hjq.permissions.f.a(a(), com.hjq.permissions.b.a)) {
            o();
            return;
        }
        com.lxj.xpopup.a.a(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        String str = "“" + com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "”" + com.amgcyo.cuttadon.f.o.d(R.string.read_storge_tip);
        a.b bVar = new a.b(a());
        bVar.d(false);
        bVar.a((CharSequence) "温馨提示", (CharSequence) str, (CharSequence) "取消", (CharSequence) "去设置", new com.lxj.xpopup.c.c() { // from class: com.amgcyo.cuttadon.activity.read.b1
            @Override // com.lxj.xpopup.c.c
            public final void onConfirm() {
                this.a.p();
            }
        }, (com.lxj.xpopup.c.a) null, false).u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(new Intent(this.f2277w, (Class<?>) MkMp3FileScanerActivity.class), new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.read.d1
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent) {
                this.a.b(i2, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.hjq.permissions.f fVarA = com.hjq.permissions.f.a((FragmentActivity) this);
        fVarA.a(com.hjq.permissions.b.a);
        fVarA.a(new b());
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void b(int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        LocalMp3Bean localMp3Bean = (LocalMp3Bean) intent.getSerializableExtra("LocalMp3Bean");
        if (localMp3Bean == null) {
            showMessage("mp3文件获取失败!");
            return;
        }
        this.tvCurrentGbmName.setText(localMp3Bean.getName());
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("tts_mp3_path", localMp3Bean.getPath());
        showMessage("已选择“" + localMp3Bean.getName() + "”");
        me.jessyan.art.d.f.a().a(1, "tts_bgm");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "设置朗读背景音乐";
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        final com.amgcyo.cuttadon.view.read.page.k kVarC = com.amgcyo.cuttadon.view.read.page.k.c(this);
        this.f2721n0 = kVarC.p();
        String str = "ttsBgm:" + this.f2721n0;
        String strD = com.amgcyo.cuttadon.utils.otherutils.g0.a().d("tts_mp3_path");
        if (!TextUtils.isEmpty(strD)) {
            this.tvCurrentGbmName.setText(strD.substring(strD.lastIndexOf("/") + 1));
        }
        this.seekBarBgm.getThumb().setColorFilter(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        this.seekBarBgm.getProgressDrawable().setColorFilter(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        this.seekBarBgm.setMax(100);
        int iA = (int) (com.amgcyo.cuttadon.utils.otherutils.g0.a().a("tts_bgm_volume_float", 0.1f) * 100.0f);
        this.seekBarBgm.setProgress(iA);
        TextView textView = this.tvBgmVolume;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "背景音乐音量：%d", Integer.valueOf(iA)));
        }
        this.seekBarBgm.setOnSeekBarChangeListener(new a(iA, 100));
        this.cbBgmSwitch.setChecked(this.f2721n0 == 1);
        this.cbBgmSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.read.c1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(kVarC, compoundButton, z2);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_bgm_setting;
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

    @OnClick({R.id.ll_selector_bgm, R.id.ll_find_bgm})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.ll_find_bgm) {
            startActivity(new Intent(this, (Class<?>) MkMp3RecomActivity.class));
        } else {
            if (id != R.id.ll_selector_bgm) {
                return;
            }
            if (this.f2721n0 == 0) {
                showMessage("请先开启朗读时播放背景音乐");
            } else {
                n();
            }
        }
    }

    public /* synthetic */ void a(com.amgcyo.cuttadon.view.read.page.k kVar, CompoundButton compoundButton, boolean z2) {
        int i2 = this.f2721n0;
        if (i2 == 0) {
            me.jessyan.art.d.f.a().a(1, "tts_bgm");
            kVar.i(1);
            this.cbBgmSwitch.setChecked(true);
            this.f2721n0 = 1;
            return;
        }
        if (i2 == 1) {
            kVar.i(0);
            this.f2721n0 = 0;
            me.jessyan.art.d.f.a().a(0, "tts_bgm");
            this.cbBgmSwitch.setChecked(false);
        }
    }
}
