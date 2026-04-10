package com.bytedance.sdk.component.widget.recycler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends kb {
    private static TimeInterpolator fo;
    private ArrayList<RecyclerView.zw> uy = new ArrayList<>();
    private ArrayList<RecyclerView.zw> kb = new ArrayList<>();
    private ArrayList<g> wp = new ArrayList<>();
    private ArrayList<z> i = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.zw>> z = new ArrayList<>();
    ArrayList<ArrayList<g>> g = new ArrayList<>();
    ArrayList<ArrayList<z>> dl = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<RecyclerView.zw> f825a = new ArrayList<>();
    ArrayList<RecyclerView.zw> gc = new ArrayList<>();
    ArrayList<RecyclerView.zw> m = new ArrayList<>();
    ArrayList<RecyclerView.zw> e = new ArrayList<>();

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public void z() {
        boolean z2 = !this.uy.isEmpty();
        boolean z3 = !this.wp.isEmpty();
        boolean z4 = !this.i.isEmpty();
        boolean z5 = !this.kb.isEmpty();
        if (z2 || z3 || z5 || z4) {
            Iterator<RecyclerView.zw> it = this.uy.iterator();
            while (it.hasNext()) {
                kb(it.next());
            }
            this.uy.clear();
            if (z3) {
                final ArrayList<g> arrayList = new ArrayList<>();
                arrayList.addAll(this.wp);
                this.g.add(arrayList);
                this.wp.clear();
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.dl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (g gVar : arrayList) {
                            dl.this.g(gVar.z, gVar.g, gVar.dl, gVar.f831a, gVar.gc);
                        }
                        arrayList.clear();
                        dl.this.g.remove(arrayList);
                    }
                };
                if (z2) {
                    com.bytedance.sdk.component.widget.recycler.z.dl.e.z(arrayList.get(0).z.z, runnable, e());
                } else {
                    runnable.run();
                }
            }
            if (z4) {
                final ArrayList<z> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.i);
                this.dl.add(arrayList2);
                this.i.clear();
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.dl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            dl.this.z((z) it2.next());
                        }
                        arrayList2.clear();
                        dl.this.dl.remove(arrayList2);
                    }
                };
                if (z2) {
                    com.bytedance.sdk.component.widget.recycler.z.dl.e.z(arrayList2.get(0).z.z, runnable2, e());
                } else {
                    runnable2.run();
                }
            }
            if (z5) {
                final ArrayList<RecyclerView.zw> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.kb);
                this.z.add(arrayList3);
                this.kb.clear();
                Runnable runnable3 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.dl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            dl.this.dl((RecyclerView.zw) it2.next());
                        }
                        arrayList3.clear();
                        dl.this.z.remove(arrayList3);
                    }
                };
                if (!z2 && !z3 && !z4) {
                    runnable3.run();
                } else {
                    com.bytedance.sdk.component.widget.recycler.z.dl.e.z(arrayList3.get(0).z, runnable3, (z2 ? e() : 0L) + Math.max(z3 ? gc() : 0L, z4 ? gz() : 0L));
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.kb
    public boolean z(RecyclerView.zw zwVar) {
        wp(zwVar);
        this.uy.add(zwVar);
        return true;
    }

    private void kb(final RecyclerView.zw zwVar) {
        final View view = zwVar.z;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.m.add(zwVar);
        viewPropertyAnimatorAnimate.setDuration(e()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.dl.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                dl.this.gz(zwVar);
                dl.this.m.remove(zwVar);
                dl.this.dl();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.kb
    public boolean g(RecyclerView.zw zwVar) {
        wp(zwVar);
        zwVar.z.setAlpha(0.0f);
        this.kb.add(zwVar);
        return true;
    }

    void dl(final RecyclerView.zw zwVar) {
        final View view = zwVar.z;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f825a.add(zwVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.dl.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                dl.this.uy(zwVar);
                dl.this.f825a.remove(zwVar);
                dl.this.dl();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.kb
    public boolean z(RecyclerView.zw zwVar, int i, int i2, int i3, int i4) {
        View view = zwVar.z;
        int translationX = i + ((int) zwVar.z.getTranslationX());
        int translationY = i2 + ((int) zwVar.z.getTranslationY());
        wp(zwVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            fo(zwVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.wp.add(new g(zwVar, translationX, translationY, i3, i4));
        return true;
    }

    void g(final RecyclerView.zw zwVar, int i, int i2, int i3, int i4) {
        final View view = zwVar.z;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.gc.add(zwVar);
        viewPropertyAnimatorAnimate.setDuration(gc()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.dl.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                dl.this.fo(zwVar);
                dl.this.gc.remove(zwVar);
                dl.this.dl();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.kb
    public boolean z(RecyclerView.zw zwVar, RecyclerView.zw zwVar2, int i, int i2, int i3, int i4) {
        if (zwVar == zwVar2) {
            return z(zwVar, i, i2, i3, i4);
        }
        float translationX = zwVar.z.getTranslationX();
        float translationY = zwVar.z.getTranslationY();
        float alpha = zwVar.z.getAlpha();
        wp(zwVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        zwVar.z.setTranslationX(translationX);
        zwVar.z.setTranslationY(translationY);
        zwVar.z.setAlpha(alpha);
        if (zwVar2 != null) {
            wp(zwVar2);
            zwVar2.z.setTranslationX(-i5);
            zwVar2.z.setTranslationY(-i6);
            zwVar2.z.setAlpha(0.0f);
        }
        this.i.add(new z(zwVar, zwVar2, i, i2, i3, i4));
        return true;
    }

    void z(final z zVar) {
        RecyclerView.zw zwVar = zVar.z;
        final View view = zwVar == null ? null : zwVar.z;
        RecyclerView.zw zwVar2 = zVar.g;
        final View view2 = zwVar2 != null ? zwVar2.z : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(gz());
            this.e.add(zVar.z);
            duration.translationX(zVar.gc - zVar.dl);
            duration.translationY(zVar.m - zVar.f832a);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.dl.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    dl.this.z(zVar.z, true);
                    dl.this.e.remove(zVar.z);
                    dl.this.dl();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.e.add(zVar.g);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(gz()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.dl.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    dl.this.z(zVar.g, false);
                    dl.this.e.remove(zVar.g);
                    dl.this.dl();
                }
            }).start();
        }
    }

    private void z(List<z> list, RecyclerView.zw zwVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            z zVar = list.get(size);
            if (z(zVar, zwVar) && zVar.z == null && zVar.g == null) {
                list.remove(zVar);
            }
        }
    }

    private void g(z zVar) {
        if (zVar.z != null) {
            z(zVar, zVar.z);
        }
        if (zVar.g != null) {
            z(zVar, zVar.g);
        }
    }

    private boolean z(z zVar, RecyclerView.zw zwVar) {
        boolean z2 = false;
        if (zVar.g == zwVar) {
            zVar.g = null;
        } else {
            if (zVar.z != zwVar) {
                return false;
            }
            zVar.z = null;
            z2 = true;
        }
        zwVar.z.setAlpha(1.0f);
        zwVar.z.setTranslationX(0.0f);
        zwVar.z.setTranslationY(0.0f);
        z(zwVar, z2);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public void a(RecyclerView.zw zwVar) {
        View view = zwVar.z;
        view.animate().cancel();
        int size = this.wp.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.wp.get(size).z == zwVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                fo(zwVar);
                this.wp.remove(size);
            }
        }
        z(this.i, zwVar);
        if (this.uy.remove(zwVar)) {
            view.setAlpha(1.0f);
            gz(zwVar);
        }
        if (this.kb.remove(zwVar)) {
            view.setAlpha(1.0f);
            uy(zwVar);
        }
        for (int size2 = this.dl.size() - 1; size2 >= 0; size2--) {
            ArrayList<z> arrayList = this.dl.get(size2);
            z(arrayList, zwVar);
            if (arrayList.isEmpty()) {
                this.dl.remove(size2);
            }
        }
        for (int size3 = this.g.size() - 1; size3 >= 0; size3--) {
            ArrayList<g> arrayList2 = this.g.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).z == zwVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    fo(zwVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.g.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.z.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.zw> arrayList3 = this.z.get(size5);
            if (arrayList3.remove(zwVar)) {
                view.setAlpha(1.0f);
                uy(zwVar);
                if (arrayList3.isEmpty()) {
                    this.z.remove(size5);
                }
            }
        }
        this.m.remove(zwVar);
        this.f825a.remove(zwVar);
        this.e.remove(zwVar);
        this.gc.remove(zwVar);
        dl();
    }

    private void wp(RecyclerView.zw zwVar) {
        if (fo == null) {
            fo = new ValueAnimator().getInterpolator();
        }
        zwVar.z.animate().setInterpolator(fo);
        a(zwVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean g() {
        return (this.kb.isEmpty() && this.i.isEmpty() && this.wp.isEmpty() && this.uy.isEmpty() && this.gc.isEmpty() && this.m.isEmpty() && this.f825a.isEmpty() && this.e.isEmpty() && this.g.isEmpty() && this.z.isEmpty() && this.dl.isEmpty()) ? false : true;
    }

    void dl() {
        if (g()) {
            return;
        }
        fo();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public void a() {
        int size = this.wp.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = this.wp.get(size);
            View view = gVar.z.z;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            fo(gVar.z);
            this.wp.remove(size);
        }
        for (int size2 = this.uy.size() - 1; size2 >= 0; size2--) {
            gz(this.uy.get(size2));
            this.uy.remove(size2);
        }
        int size3 = this.kb.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.zw zwVar = this.kb.get(size3);
            zwVar.z.setAlpha(1.0f);
            uy(zwVar);
            this.kb.remove(size3);
        }
        for (int size4 = this.i.size() - 1; size4 >= 0; size4--) {
            g(this.i.get(size4));
        }
        this.i.clear();
        if (g()) {
            for (int size5 = this.g.size() - 1; size5 >= 0; size5--) {
                ArrayList<g> arrayList = this.g.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    g gVar2 = arrayList.get(size6);
                    View view2 = gVar2.z.z;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    fo(gVar2.z);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.g.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.z.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.zw> arrayList2 = this.z.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.zw zwVar2 = arrayList2.get(size8);
                    zwVar2.z.setAlpha(1.0f);
                    uy(zwVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.z.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.dl.size() - 1; size9 >= 0; size9--) {
                ArrayList<z> arrayList3 = this.dl.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    g(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.dl.remove(arrayList3);
                    }
                }
            }
            z(this.m);
            z(this.gc);
            z(this.f825a);
            z(this.e);
            fo();
        }
    }

    void z(List<RecyclerView.zw> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).z.animate().cancel();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean z(RecyclerView.zw zwVar, List<Object> list) {
        return !list.isEmpty() || super.z(zwVar, list);
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f832a;
        public int dl;
        public RecyclerView.zw g;
        public int gc;
        public int m;
        public RecyclerView.zw z;

        private z(RecyclerView.zw zwVar, RecyclerView.zw zwVar2) {
            this.z = zwVar;
            this.g = zwVar2;
        }

        z(RecyclerView.zw zwVar, RecyclerView.zw zwVar2, int i, int i2, int i3, int i4) {
            this(zwVar, zwVar2);
            this.dl = i;
            this.f832a = i2;
            this.gc = i3;
            this.m = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.z + ", newHolder=" + this.g + ", fromX=" + this.dl + ", fromY=" + this.f832a + ", toX=" + this.gc + ", toY=" + this.m + '}';
        }
    }

    private static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f831a;
        public int dl;
        public int g;
        public int gc;
        public RecyclerView.zw z;

        g(RecyclerView.zw zwVar, int i, int i2, int i3, int i4) {
            this.z = zwVar;
            this.g = i;
            this.dl = i2;
            this.f831a = i3;
            this.gc = i4;
        }
    }
}
