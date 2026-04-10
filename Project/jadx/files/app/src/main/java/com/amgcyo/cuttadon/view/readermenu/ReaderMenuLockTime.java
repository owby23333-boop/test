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
import com.amgcyo.cuttadon.view.read.page.k;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ReaderMenuLockTime extends FrameLayout implements View.OnClickListener, com.amgcyo.cuttadon.g.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private LinearLayout f5350s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f5351t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f5352u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f5353v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f5354w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f5355x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private k f5356y;

    class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Runnable f5357s;

        a(ReaderMenuLockTime readerMenuLockTime, Runnable runnable) {
            this.f5357s = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5357s.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ReaderMenuLockTime(@NonNull Context context) {
        this(context, null);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mk_view_menu_locktime, (ViewGroup) this, true);
        this.f5350s = (LinearLayout) findViewById(R.id.layout_locktime);
        this.f5351t = (TextView) findViewById(R.id.textView_locktime1);
        this.f5352u = (TextView) findViewById(R.id.textView_locktime2);
        this.f5353v = (TextView) findViewById(R.id.textView_locktime3);
        this.f5354w = (TextView) findViewById(R.id.textView_locktime4);
        this.f5355x = (TextView) findViewById(R.id.textView_locktime5);
        this.f5351t.setOnClickListener(this);
        this.f5352u.setOnClickListener(this);
        this.f5353v.setOnClickListener(this);
        this.f5354w.setOnClickListener(this);
        this.f5355x.setOnClickListener(this);
        this.f5356y = k.c(context);
    }

    private MkNovelBaseReaderActivity getActivity() {
        return (MkNovelBaseReaderActivity) getContext();
    }

    public void b() {
        this.f5350s.setTranslationY(r0.getMeasuredHeight());
        this.f5350s.animate().translationY(0.0f).setListener(null);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.textView_locktime1) {
            a(0, view);
            return;
        }
        if (id == R.id.textView_locktime2) {
            a(1, view);
            return;
        }
        if (id == R.id.textView_locktime3) {
            a(2, view);
        } else if (id == R.id.textView_locktime4) {
            a(3, view);
        } else if (id == R.id.textView_locktime5) {
            a(4, view);
        }
    }

    public ReaderMenuLockTime(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void b(Runnable runnable) {
        this.f5350s.animate().translationY(this.f5350s.getMeasuredHeight()).setListener(new a(this, runnable));
    }

    public void a(Runnable runnable) {
        this.f5350s.setTranslationY(0.0f);
        b(runnable);
    }

    public void a() {
        try {
            com.amgcyo.cuttadon.utils.otherutils.k readerColorStyle = ((MkNovelBaseReaderActivity) getContext()).getReaderColorStyle();
            if (readerColorStyle == null) {
                return;
            }
            m.a(this.f5350s, readerColorStyle);
            this.f5351t.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5352u.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5353v.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5354w.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
            this.f5355x.setBackground(k0.a().a(getActivity(), readerColorStyle.f4407k));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int iL = this.f5356y.l();
        if (iL == 1) {
            a(this.f5352u);
            return;
        }
        if (iL == 2) {
            a(this.f5353v);
            return;
        }
        if (iL == 3) {
            a(this.f5354w);
        } else if (iL != 4) {
            a(this.f5351t);
        } else {
            a(this.f5355x);
        }
    }

    private void a(View view) {
        this.f5351t.setEnabled(true);
        this.f5352u.setEnabled(true);
        this.f5353v.setEnabled(true);
        this.f5354w.setEnabled(true);
        this.f5355x.setEnabled(true);
        view.setEnabled(false);
    }

    private void a(int i2, View view) {
        a(view);
        this.f5356y.h(i2);
        if (i2 < 0 || i2 > 5) {
            i2 = 0;
        }
        getActivity().applyLockTime(i2);
    }
}
