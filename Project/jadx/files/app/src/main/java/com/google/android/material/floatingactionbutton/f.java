package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.a.h;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

/* JADX INFO: compiled from: MotionStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
interface f {
    void a();

    void a(@Nullable h hVar);

    void a(@Nullable ExtendedFloatingActionButton.j jVar);

    void b();

    AnimatorSet c();

    void d();

    @Nullable
    h e();

    boolean f();

    @AnimatorRes
    int g();

    List<Animator.AnimatorListener> h();

    void onAnimationStart(Animator animator);
}
