package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f16068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f16069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f16070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f16071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f16072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f16073h;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f16074s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ View f16075t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ View f16076u;

        a(FabTransformationBehavior fabTransformationBehavior, boolean z2, View view, View view2) {
            this.f16074s = z2;
            this.f16075t = view;
            this.f16076u = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f16074s) {
                return;
            }
            this.f16075t.setVisibility(4);
            this.f16076u.setAlpha(1.0f);
            this.f16076u.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f16074s) {
                this.f16075t.setVisibility(0);
                this.f16076u.setAlpha(0.0f);
                this.f16076u.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ View f16077s;

        b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f16077s = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f16077s.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.b f16078s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ Drawable f16079t;

        c(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.b bVar, Drawable drawable) {
            this.f16078s = bVar;
            this.f16079t = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f16078s.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f16078s.setCircularRevealOverlayDrawable(this.f16079t);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.b f16080s;

        d(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.b bVar) {
            this.f16080s = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.e revealInfo = this.f16080s.getRevealInfo();
            revealInfo.f15223c = Float.MAX_VALUE;
            this.f16080s.setRevealInfo(revealInfo);
        }
    }

    protected static class e {

        @Nullable
        public h a;
        public j b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.f16068c = new Rect();
        this.f16069d = new RectF();
        this.f16070e = new RectF();
        this.f16071f = new int[2];
    }

    private void a(@NonNull View view, @NonNull View view2, boolean z2, @NonNull e eVar, @NonNull List<Animator> list) {
        float fC = c(view, view2, eVar.b);
        float fD = d(view, view2, eVar.b);
        Pair<i, i> pairA = a(fC, fD, z2, eVar);
        i iVar = (i) pairA.first;
        i iVar2 = (i) pairA.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z2) {
            fC = this.f16072g;
        }
        fArr[0] = fC;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z2) {
            fD = this.f16073h;
        }
        fArr2[0] = fD;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a((Animator) objectAnimatorOfFloat);
        iVar2.a((Animator) objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    private void c(View view, @NonNull View view2, boolean z2, boolean z3, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z2) {
            if (!z3) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.a.b("elevation").a((Animator) objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(View view, View view2, boolean z2, boolean z3, @NonNull e eVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof com.google.android.material.circularreveal.b) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.b bVar = (com.google.android.material.circularreveal.b) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z2) {
                if (!z3) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(this, view2));
            eVar.a.b("iconFade").a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(this, bVar, drawable));
        }
    }

    protected abstract e a(Context context, boolean z2);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet b(@NonNull View view, @NonNull View view2, boolean z2, boolean z3) {
        e eVarA = a(view2.getContext(), z2);
        if (z2) {
            this.f16072g = view.getTranslationX();
            this.f16073h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z2, z3, eVarA, arrayList, arrayList2);
        }
        RectF rectF = this.f16069d;
        a(view, view2, z2, z3, eVarA, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        a(view, view2, z2, eVarA, arrayList);
        d(view, view2, z2, z3, eVarA, arrayList, arrayList2);
        a(view, view2, z2, z3, eVarA, fWidth, fHeight, arrayList, arrayList2);
        b(view, view2, z2, z3, eVarA, arrayList, arrayList2);
        a(view, view2, z2, z3, eVarA, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z2, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16068c = new Rect();
        this.f16069d = new RectF();
        this.f16070e = new RectF();
        this.f16071f = new int[2];
    }

    private float c(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float fCenterX;
        float fCenterX2;
        float f2;
        RectF rectF = this.f16069d;
        RectF rectF2 = this.f16070e;
        a(view, rectF);
        b(view2, rectF2);
        int i2 = jVar.a & 7;
        if (i2 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i2 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else if (i2 == 5) {
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        } else {
            f2 = 0.0f;
            return f2 + jVar.b;
        }
        f2 = fCenterX - fCenterX2;
        return f2 + jVar.b;
    }

    private void a(@NonNull View view, @NonNull View view2, boolean z2, boolean z3, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fC = c(view, view2, eVar.b);
        float fD = d(view, view2, eVar.b);
        Pair<i, i> pairA = a(fC, fD, z2, eVar);
        i iVar = (i) pairA.first;
        i iVar2 = (i) pairA.second;
        if (z2) {
            if (!z3) {
                view2.setTranslationX(-fC);
                view2.setTranslationY(-fD);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            a(view2, eVar, iVar, iVar2, -fC, -fD, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fC);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fD);
        }
        iVar.a((Animator) objectAnimatorOfFloat);
        iVar2.a((Animator) objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private float d(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float fCenterY;
        float fCenterY2;
        float f2;
        RectF rectF = this.f16069d;
        RectF rectF2 = this.f16070e;
        a(view, rectF);
        b(view2, rectF2);
        int i2 = jVar.a & 112;
        if (i2 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i2 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else if (i2 == 80) {
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f14921c;
        }
        f2 = fCenterY - fCenterY2;
        return f2 + jVar.f14921c;
    }

    @Nullable
    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(@NonNull View view, View view2, boolean z2, boolean z3, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof com.google.android.material.circularreveal.b) {
            com.google.android.material.circularreveal.b bVar = (com.google.android.material.circularreveal.b) view2;
            int iB = b(view);
            int i2 = 16777215 & iB;
            if (z2) {
                if (!z3) {
                    bVar.setCircularRevealScrimColor(iB);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(bVar, b.d.a, i2);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(bVar, b.d.a, iB);
            }
            objectAnimatorOfInt.setEvaluator(com.google.android.material.a.c.a());
            eVar.a.b(com.anythink.expressad.foundation.h.i.f10646d).a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(@NonNull View view, View view2, boolean z2, boolean z3, @NonNull e eVar, float f2, float f3, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof com.google.android.material.circularreveal.b) {
            com.google.android.material.circularreveal.b bVar = (com.google.android.material.circularreveal.b) view2;
            float fA = a(view, view2, eVar.b);
            float fB = b(view, view2, eVar.b);
            ((FloatingActionButton) view).a(this.f16068c);
            float fWidth = this.f16068c.width() / 2.0f;
            i iVarB = eVar.a.b("expansion");
            if (z2) {
                if (!z3) {
                    bVar.setRevealInfo(new b.e(fA, fB, fWidth));
                }
                if (z3) {
                    fWidth = bVar.getRevealInfo().f15223c;
                }
                animatorA = com.google.android.material.circularreveal.a.a(bVar, fA, fB, com.google.android.material.h.a.a(fA, fB, 0.0f, 0.0f, f2, f3));
                animatorA.addListener(new d(this, bVar));
                a(view2, iVarB.a(), (int) fA, (int) fB, fWidth, list);
            } else {
                float f4 = bVar.getRevealInfo().f15223c;
                Animator animatorA2 = com.google.android.material.circularreveal.a.a(bVar, fA, fB, fWidth);
                int i2 = (int) fA;
                int i3 = (int) fB;
                a(view2, iVarB.a(), i2, i3, f4, list);
                a(view2, iVarB.a(), iVarB.b(), eVar.a.a(), i2, i3, fWidth, list);
                animatorA = animatorA2;
            }
            iVarB.a(animatorA);
            list.add(animatorA);
            list2.add(com.google.android.material.circularreveal.a.a(bVar));
        }
    }

    private void b(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f16071f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private float b(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f16069d;
        RectF rectF2 = this.f16070e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int b(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, View view2, boolean z2, boolean z3, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupA;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.b) && CircularRevealHelper.f15212j == 0) || (viewGroupA = a(view2)) == null) {
                return;
            }
            if (z2) {
                if (!z3) {
                    com.google.android.material.a.d.a.set(viewGroupA, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupA, com.google.android.material.a.d.a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupA, com.google.android.material.a.d.a, 0.0f);
            }
            eVar.a.b("contentFade").a((Animator) objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    @NonNull
    private Pair<i, i> a(float f2, float f3, boolean z2, @NonNull e eVar) {
        i iVarB;
        i iVarB2;
        if (f2 == 0.0f || f3 == 0.0f) {
            iVarB = eVar.a.b("translationXLinear");
            iVarB2 = eVar.a.b("translationYLinear");
        } else if ((z2 && f3 < 0.0f) || (!z2 && f3 > 0.0f)) {
            iVarB = eVar.a.b("translationXCurveUpwards");
            iVarB2 = eVar.a.b("translationYCurveUpwards");
        } else {
            iVarB = eVar.a.b("translationXCurveDownwards");
            iVarB2 = eVar.a.b("translationYCurveDownwards");
        }
        return new Pair<>(iVarB, iVarB2);
    }

    private void a(@NonNull View view, @NonNull RectF rectF) {
        b(view, rectF);
        rectF.offset(this.f16072g, this.f16073h);
    }

    private float a(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f16069d;
        RectF rectF2 = this.f16070e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private void a(@NonNull View view, @NonNull e eVar, @NonNull i iVar, @NonNull i iVar2, float f2, float f3, float f4, float f5, @NonNull RectF rectF) {
        float fA = a(eVar, iVar, f2, f4);
        float fA2 = a(eVar, iVar2, f3, f5);
        Rect rect = this.f16068c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f16069d;
        rectF2.set(rect);
        RectF rectF3 = this.f16070e;
        b(view, rectF3);
        rectF3.offset(fA, fA2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(@NonNull e eVar, @NonNull i iVar, float f2, float f3) {
        long jA = iVar.a();
        long jB = iVar.b();
        i iVarB = eVar.a.b("expansion");
        return com.google.android.material.a.a.a(f2, f3, iVar.c().getInterpolation((((iVarB.a() + iVarB.b()) + 17) - jA) / jB));
    }

    @Nullable
    private ViewGroup a(@NonNull View view) {
        View viewFindViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return c(viewFindViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return c(view);
        }
        return c(((ViewGroup) view).getChildAt(0));
    }

    private void a(View view, long j2, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j2 <= 0) {
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        animatorCreateCircularReveal.setStartDelay(0L);
        animatorCreateCircularReveal.setDuration(j2);
        list.add(animatorCreateCircularReveal);
    }

    private void a(View view, long j2, long j3, long j4, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                animatorCreateCircularReveal.setStartDelay(j5);
                animatorCreateCircularReveal.setDuration(j4 - j5);
                list.add(animatorCreateCircularReveal);
            }
        }
    }
}
