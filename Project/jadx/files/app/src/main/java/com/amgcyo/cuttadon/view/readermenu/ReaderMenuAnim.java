package com.amgcyo.cuttadon.view.readermenu;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.utils.otherutils.k0;
import com.amgcyo.cuttadon.utils.otherutils.m;
import com.amgcyo.cuttadon.view.read.page.PageMode;
import com.amgcyo.cuttadon.view.read.page.k;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ReaderMenuAnim extends FrameLayout implements View.OnClickListener, com.amgcyo.cuttadon.g.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private LinearLayout f5332s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f5333t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f5334u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f5335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f5336w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f5337x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private k f5338y;

    class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Runnable f5339s;

        a(ReaderMenuAnim readerMenuAnim, Runnable runnable) {
            this.f5339s = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5339s.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ReaderMenuAnim(@NonNull Context context) {
        this(context, null);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mk_view_menu_anim, (ViewGroup) this, true);
        this.f5332s = (LinearLayout) findViewById(R.id.layout_anim);
        this.f5333t = (TextView) findViewById(R.id.textView_anim_fz);
        this.f5334u = (TextView) findViewById(R.id.textView_anim_fg);
        this.f5335v = (TextView) findViewById(R.id.textView_anim_py);
        this.f5336w = (TextView) findViewById(R.id.textView_anim_sx);
        this.f5337x = (TextView) findViewById(R.id.textView_anim_pt);
        this.f5333t.setOnClickListener(this);
        this.f5334u.setOnClickListener(this);
        this.f5335v.setOnClickListener(this);
        this.f5336w.setOnClickListener(this);
        this.f5337x.setOnClickListener(this);
        this.f5338y = k.c(context);
    }

    private MkNovelBaseReaderActivity getActivity() {
        return (MkNovelBaseReaderActivity) getContext();
    }

    public void b() {
        this.f5332s.setTranslationY(r0.getMeasuredHeight());
        this.f5332s.animate().translationY(0.0f).setListener(null);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.textView_anim_fz) {
            a(0, view);
            return;
        }
        if (id == R.id.textView_anim_fg) {
            a(1, view);
            return;
        }
        if (id == R.id.textView_anim_py) {
            a(2, view);
        } else if (id == R.id.textView_anim_sx) {
            a(3, view);
        } else if (id == R.id.textView_anim_pt) {
            a(4, view);
        }
    }

    public ReaderMenuAnim(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void b(Runnable runnable) {
        this.f5332s.animate().translationY(this.f5332s.getMeasuredHeight()).setListener(new a(this, runnable));
    }

    public void a(Runnable runnable) {
        this.f5332s.setTranslationY(0.0f);
        b(runnable);
    }

    public void a() {
        try {
            com.amgcyo.cuttadon.utils.otherutils.k readerColorStyle = ((MkNovelBaseReaderActivity) getContext()).getReaderColorStyle();
            if (readerColorStyle == null) {
                return;
            }
            m.a(this.f5332s, readerColorStyle);
            this.f5333t.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5334u.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5335v.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5336w.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5337x.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int iA = this.f5338y.a();
        if (iA == 1) {
            a(this.f5334u);
            return;
        }
        if (iA == 2) {
            a(this.f5335v);
            return;
        }
        if (iA == 3) {
            a(this.f5336w);
        } else if (iA != 4) {
            a(this.f5333t);
        } else {
            a(this.f5337x);
        }
    }

    private void a(View view) {
        this.f5333t.setEnabled(true);
        this.f5334u.setEnabled(true);
        this.f5335v.setEnabled(true);
        this.f5336w.setEnabled(true);
        this.f5337x.setEnabled(true);
        view.setEnabled(false);
    }

    private void a(int i2, View view) {
        a(view);
        this.f5338y.a(PageMode.values()[i2]);
        this.f5338y.a(i2);
        if (i2 > 5) {
            i2 = 0;
        }
        getActivity().applyAnim(i2);
    }
}
