package com.amgcyo.cuttadon.view.readermenu;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.activity.read.MkSettingBgmActivity;
import com.amgcyo.cuttadon.activity.setting.MkTtsHightColorActivity;
import com.amgcyo.cuttadon.adapter.other.r;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.m;
import com.amgcyo.cuttadon.view.dialog.m1;
import com.amgcyo.cuttadon.view.read.page.k;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.d.f;

/* JADX INFO: loaded from: classes.dex */
public class ReaderMenuVoice extends FrameLayout implements View.OnClickListener, com.amgcyo.cuttadon.j.e.c {
    private com.amgcyo.cuttadon.utils.event.a A;
    private m1 B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private LinearLayout f5379s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private SeekBar f5380t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f5381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f5382v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f5383w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private k f5384x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    SparseArray<String> f5385y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5386z;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ReaderMenuVoice.this.b(seekBar.getProgress());
        }
    }

    class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Runnable f5387s;

        b(ReaderMenuVoice readerMenuVoice, Runnable runnable) {
            this.f5387s = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5387s.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ReaderMenuVoice(Context context) {
        this(context, null);
    }

    private void b(Runnable runnable) {
        this.f5379s.animate().translationY(this.f5379s.getMeasuredHeight()).setListener(new b(this, runnable));
    }

    private void e() {
        if (getActivity() == null) {
            return;
        }
        getActivity().finishBaiduTtsSpeech();
    }

    private void f() {
        if (this.A == null) {
            this.A = new com.amgcyo.cuttadon.utils.event.a();
        }
        if (this.f5386z) {
            this.f5386z = false;
            this.f5381u.setImageResource(R.drawable.tts_play);
            this.f5382v.setText(o.d(R.string.tts_play));
        } else {
            this.f5386z = true;
            this.f5381u.setImageResource(R.drawable.tts_paused);
            this.f5382v.setText(o.d(R.string.tts_paused));
        }
        this.A.a(this.f5386z);
        f.a().a(this.A, "tag_tts_play_paused");
    }

    private MkNovelBaseReaderActivity getActivity() {
        return (MkNovelBaseReaderActivity) getContext();
    }

    private int getActivityVoiceType() {
        if (getActivity() != null) {
            return getActivity().getVoiceType();
        }
        return -1;
    }

    private void setDefaultSpeed(String str) {
        int iIntValue = Integer.valueOf(str).intValue();
        b(iIntValue);
        SeekBar seekBar = this.f5380t;
        if (seekBar != null) {
            seekBar.setProgress(iIntValue);
        }
    }

    @Override // com.amgcyo.cuttadon.j.e.c
    public void b() {
    }

    public void c() {
        try {
            com.amgcyo.cuttadon.utils.otherutils.k readerColorStyle = ((MkNovelBaseReaderActivity) getContext()).getReaderColorStyle();
            String str = "当前听书类型：" + getActivityVoiceType();
            if (getActivityVoiceType() == 0) {
                String strE = this.f5384x.e();
                this.f5383w.setText(String.format(Locale.getDefault(), "当前语速:%s", strE));
                this.f5380t.setMax(15);
                this.f5380t.setProgress(Integer.valueOf(strE).intValue());
            } else {
                this.f5383w.setText(String.format("当前语速：%s", Float.valueOf(g.Q())));
                this.f5380t.setMax(100);
                this.f5380t.setProgress(g.P());
            }
            boolean zIsListenTobooks = getActivity().isListenTobooks();
            this.f5386z = zIsListenTobooks;
            if (zIsListenTobooks) {
                this.f5381u.setImageResource(R.drawable.tts_paused);
                this.f5382v.setText(o.d(R.string.tts_paused));
            } else {
                this.f5381u.setImageResource(R.drawable.tts_play);
                this.f5382v.setText(o.d(R.string.tts_play));
            }
            String str2 = "listenTobooks:" + zIsListenTobooks;
            if (readerColorStyle != null) {
                m.b(this.f5379s, readerColorStyle);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d() {
        this.f5379s.setTranslationY(r0.getMeasuredHeight());
        this.f5379s.animate().translationY(0.0f).setListener(null);
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_bgm /* 2131297838 */:
                if (getActivity() != null) {
                    getActivity().startActivity(new Intent(getActivity(), (Class<?>) MkSettingBgmActivity.class));
                }
                break;
            case R.id.layout_default_speed /* 2131297841 */:
                if (getActivity() != null) {
                    String str = "默认语速：" + getActivityVoiceType();
                    if (getActivityVoiceType() == 0) {
                        setDefaultSpeed("5");
                    } else if (getActivityVoiceType() == 1) {
                        b(10);
                        SeekBar seekBar = this.f5380t;
                        if (seekBar != null) {
                            seekBar.setProgress(10);
                        }
                    }
                    break;
                }
                break;
            case R.id.layout_finishVoice /* 2131297843 */:
                e();
                break;
            case R.id.layout_high_light /* 2131297844 */:
                if (getActivity() != null) {
                    getActivity().startActivity(new Intent(getActivity(), (Class<?>) MkTtsHightColorActivity.class));
                }
                break;
            case R.id.layout_play_paused /* 2131297849 */:
                f();
                break;
            case R.id.layout_voicer /* 2131297853 */:
                if (getActivity() != null) {
                    m1 m1Var = this.B;
                    if (m1Var != null) {
                        m1Var.show();
                    } else {
                        c(getActivityVoiceType());
                    }
                    break;
                }
                break;
        }
    }

    public ReaderMenuVoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5385y = new SparseArray<>();
        this.f5386z = false;
        a(context);
    }

    private void a(Context context) {
        this.f5385y.put(0, "发音人设置");
        this.f5385y.put(1, "定时朗读设置");
        LayoutInflater.from(context).inflate(R.layout.novel_menu_voice, (ViewGroup) this, true);
        this.f5379s = (LinearLayout) findViewById(R.id.layout_voice);
        this.f5380t = (SeekBar) findViewById(R.id.seekBar_voiceSpeed);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_finishVoice);
        ((LinearLayout) findViewById(R.id.layout_default_speed)).setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.layout_bgm);
        ((LinearLayout) findViewById(R.id.layout_voicer)).setOnClickListener(this);
        ((LinearLayout) findViewById(R.id.layout_play_paused)).setOnClickListener(this);
        this.f5382v = (TextView) findViewById(R.id.tv_play_paused);
        this.f5381u = (ImageView) findViewById(R.id.img_play_paused);
        findViewById(R.id.layout_high_light).setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        this.f5380t.setOnSeekBarChangeListener(new a());
        setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.readermenu.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5406s.a(view);
            }
        });
        this.f5384x = k.c(context);
        this.f5383w = (TextView) findViewById(R.id.tv_speed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        if (getActivity() == null) {
            return;
        }
        int voiceType = getActivity().getVoiceType();
        if (voiceType == 0) {
            String str = "baidu sdk " + i2;
            this.f5384x.b(String.valueOf(i2));
            this.f5383w.setText(String.format(Locale.getDefault(), "当前语速:%d", Integer.valueOf(i2)));
            getActivity().applyBaiduSpeed(i2);
            return;
        }
        if (voiceType != 1) {
            return;
        }
        String str2 = "tts sdk " + i2;
        double d2 = i2;
        Double.isNaN(d2);
        this.f5383w.setText(String.format(Locale.getDefault(), "当前语速:%s", Float.valueOf((float) (d2 / 10.0d))));
        getActivity().applyBaiduSpeed(i2);
    }

    private void c(int i2) {
        if (getActivity() == null) {
            return;
        }
        this.B = new m1(getActivity(), R.style.BottomSheetDialog);
        View viewInflate = View.inflate(getActivity(), R.layout.saltedfish_bottom_sheet, null);
        XTabLayout xTabLayout = (XTabLayout) viewInflate.findViewById(R.id.xtablayout);
        ViewPager viewPager = (ViewPager) viewInflate.findViewById(R.id.pager);
        int size = this.f5385y.size();
        for (int i3 = 0; i3 < size; i3++) {
            XTabLayout.g gVarA = xTabLayout.a();
            gVarA.a(this.f5385y.get(i3));
            xTabLayout.a(gVarA);
        }
        viewPager.setAdapter(new r(getActivity(), this.f5385y, this.f5384x, this, 0, i2));
        xTabLayout.setupWithViewPager(viewPager);
        this.B.a(viewPager);
        this.B.setContentView(viewInflate);
        this.B.show();
    }

    public /* synthetic */ void a(View view) {
        getActivity().hideMenuPanel(false);
    }

    public void a(Runnable runnable) {
        this.f5379s.setTranslationY(0.0f);
        b(runnable);
    }

    public void a(boolean z2) {
        if (this.A == null) {
            this.A = new com.amgcyo.cuttadon.utils.event.a();
        }
        if (z2) {
            this.f5386z = true;
            this.f5381u.setImageResource(R.drawable.tts_paused);
            this.f5382v.setText(o.d(R.string.tts_paused));
            this.A.a(this.f5386z);
        } else {
            this.f5386z = false;
            this.f5381u.setImageResource(R.drawable.tts_play);
            this.f5382v.setText(o.d(R.string.tts_play));
            this.A.a(this.f5386z);
        }
        f.a().a(this.A, "tag_tts_play_paused");
    }

    @Override // com.amgcyo.cuttadon.j.e.c
    public void a(int i2) {
        if (getActivity() != null) {
            getActivity().resetVoiceTime(i2);
        }
    }

    @Override // com.amgcyo.cuttadon.j.e.c
    public void a() {
        if (getActivity() == null) {
            return;
        }
        getActivity().applyBaiduReadVoicer();
    }
}
