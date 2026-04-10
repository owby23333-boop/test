package com.amgcyo.cuttadon.view.readermenu;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.utils.otherutils.k0;
import com.amgcyo.cuttadon.utils.otherutils.m;
import com.amgcyo.cuttadon.view.read.page.k;
import com.fatcatfat.io.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ReaderMenuAutoRead extends FrameLayout implements View.OnClickListener, com.amgcyo.cuttadon.g.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private k f5340s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LinearLayout f5341t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SeekBar f5342u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f5343v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f5344w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f5345x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageView f5346y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f5347z;

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
            ReaderMenuAutoRead.this.a(seekBar.getProgress() + 1);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ReaderMenuAutoRead.this.getActivity().hideMenuPanel(false);
        }
    }

    class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Runnable f5349s;

        c(ReaderMenuAutoRead readerMenuAutoRead, Runnable runnable) {
            this.f5349s = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5349s.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ReaderMenuAutoRead(@NonNull Context context) {
        this(context, null);
    }

    private void c() {
        getActivity().finishAutoRead();
        getActivity().hideMenuPanel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MkNovelBaseReaderActivity getActivity() {
        return (MkNovelBaseReaderActivity) getContext();
    }

    public void b() {
        this.f5341t.setTranslationY(r0.getMeasuredHeight());
        this.f5341t.animate().translationY(0.0f).setListener(null);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.textView_speedDown) {
            this.f5342u.setProgress(r3.getProgress() - 1);
            a(this.f5342u.getProgress());
        } else if (id == R.id.textView_speedUp) {
            SeekBar seekBar = this.f5342u;
            seekBar.setProgress(seekBar.getProgress() + 1);
            a(this.f5342u.getProgress());
        } else if (id == R.id.layout_finishAuto) {
            c();
        } else if (id == R.id.textView_anim_py) {
            a(3, view);
        } else if (id == R.id.textView_anim_sx) {
            a(4, view);
        }
    }

    public ReaderMenuAutoRead(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mk_view_menu_auto_read, (ViewGroup) this, true);
        this.f5341t = (LinearLayout) findViewById(R.id.layout_autoRead);
        this.f5342u = (SeekBar) findViewById(R.id.seekBar_autoSpeed);
        this.f5345x = (TextView) findViewById(R.id.textView_speedNum);
        this.f5343v = (TextView) findViewById(R.id.textView_anim_sx);
        this.f5344w = (TextView) findViewById(R.id.textView_anim_py);
        this.f5346y = (ImageView) findViewById(R.id.line);
        this.f5347z = (ImageView) findViewById(R.id.iv_exit);
        findViewById(R.id.textView_speedDown).setOnClickListener(this);
        findViewById(R.id.textView_speedUp).setOnClickListener(this);
        findViewById(R.id.layout_finishAuto).setOnClickListener(this);
        this.f5344w.setOnClickListener(this);
        this.f5343v.setOnClickListener(this);
        this.f5342u.setOnSeekBarChangeListener(new a());
        this.f5340s = k.c(context);
        setOnClickListener(new b());
    }

    private void b(Runnable runnable) {
        this.f5341t.animate().translationY(this.f5341t.getMeasuredHeight()).setListener(new c(this, runnable));
    }

    public void a(Runnable runnable) {
        this.f5341t.setTranslationY(0.0f);
        b(runnable);
        if (getActivity().isAutoRead) {
            getActivity().pauseAutoRead(false);
        }
    }

    public void a() {
        try {
            MkNovelBaseReaderActivity activity = getActivity();
            com.amgcyo.cuttadon.utils.otherutils.k readerColorStyle = getActivity().getReaderColorStyle();
            if (readerColorStyle == null) {
                return;
            }
            m.a(this.f5341t, readerColorStyle);
            this.f5344w.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5343v.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5346y.setColorFilter(readerColorStyle.f4407k);
            this.f5347z.setColorFilter(readerColorStyle.f4407k);
            if (activity.isAutoRead) {
                getActivity().pauseAutoRead(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f5342u.setProgress(this.f5340s.c());
        this.f5345x.setText(String.format(Locale.getDefault(), "速度:%d", Integer.valueOf(this.f5342u.getProgress())));
        int iB = this.f5340s.b();
        if (iB == 3) {
            a(this.f5344w);
        } else {
            if (iB != 4) {
                return;
            }
            a(this.f5343v);
        }
    }

    private void a(View view) {
        this.f5344w.setEnabled(true);
        this.f5343v.setEnabled(true);
        view.setEnabled(false);
    }

    private void a(int i2, View view) {
        a(view);
        this.f5340s.b(i2);
        getActivity().startAutoRead(i2, this.f5340s.c(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (i2 < 1 || i2 > 8) {
            return;
        }
        this.f5345x.setText(String.format(Locale.getDefault(), "速度:%d", Integer.valueOf(i2)));
        this.f5340s.c(i2);
        getActivity().startAutoRead(this.f5340s.b(), i2, true);
    }
}
