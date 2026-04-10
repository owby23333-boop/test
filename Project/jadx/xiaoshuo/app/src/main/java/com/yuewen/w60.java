package com.yuewen;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.duokan.core.app.ManagedContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes12.dex */
public class w60 {
    public static boolean r = true;
    public static boolean s = true;
    public static final /* synthetic */ boolean t = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x60 f19381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f19382b;
    public y60 c;
    public final CopyOnWriteArrayList<w60> d;
    public final CopyOnWriteArrayList<w60> e;
    public final fc2 f;
    public y60 g;
    public WeakReference<w60> h;
    public View i;
    public boolean j;
    public boolean k;
    public boolean l;
    public ArrayList<Runnable> m;
    public ArrayList<Runnable> n;
    public List o;
    public boolean p;
    public final Set<Runnable> q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w60.this.m != null) {
                Iterator it = w60.this.m.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                w60.this.m = null;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w60.this.n != null) {
                Iterator it = w60.this.n.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                w60.this.n = null;
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w60.this.p = false;
            w60.this.Tc();
            w60.this.g();
        }
    }

    public class d implements y60 {
        public d() {
        }

        @Override // com.yuewen.y60
        public boolean a(w60 w60Var, int i) {
            return w60.this.g.a(w60.this, i);
        }

        @Override // com.yuewen.y60
        public boolean b(w60 w60Var) {
            return w60.this.g != null ? w60.this.g.b(w60.this) : w60.this.md();
        }

        @Override // com.yuewen.y60
        public boolean c(w60 w60Var) {
            return w60.this.te(w60Var);
        }

        @Override // com.yuewen.y60
        public boolean d(w60 w60Var) {
            if (c04.h()) {
                c04.s(getClass().getSimpleName() + "---requestHideMenu ---");
            }
            if (w60.this.g != null) {
                return w60.this.g.d(w60.this);
            }
            if (w60.this.Kd()) {
                return w60.this.ld();
            }
            return false;
        }

        @Override // com.yuewen.y60
        public int e(w60 w60Var) {
            return w60.this.g.e(w60.this);
        }

        @Override // com.yuewen.y60
        public boolean f() {
            return false;
        }

        @Override // com.yuewen.y60
        public xv1 getContext() {
            return w60.this.f19381a;
        }

        @Override // com.yuewen.y60
        public y60 getParent() {
            return w60.this.g;
        }
    }

    public w60(xv1 xv1Var, int i) {
        this(xv1Var);
        Ge(i);
    }

    private final void jd(boolean z) {
        we(z);
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().jd(z);
        }
    }

    public w60 Ad() {
        int iXd = xd();
        return iXd > 0 ? wd(iXd - 1) : this;
    }

    public void Ae(Runnable runnable) {
        ArrayList<Runnable> arrayList = this.m;
        if (arrayList == null) {
            runnable.run();
        } else {
            arrayList.add(runnable);
        }
    }

    public <E> List<E> Bd() {
        return this.o;
    }

    public void Be(Runnable runnable) {
        ArrayList<Runnable> arrayList = this.n;
        if (arrayList == null) {
            runnable.run();
        } else {
            arrayList.add(runnable);
        }
    }

    public final void Cd() {
        this.j = true;
        Nd(this.l);
        this.l = false;
        for (w60 w60Var : this.e) {
            if (!w60Var.Gd()) {
                w60Var.Cd();
            }
        }
        this.f.m();
    }

    public final boolean Ce(String str, Runnable runnable) {
        if (Gd()) {
            runnable.run();
            return true;
        }
        this.f.f(str, runnable);
        return false;
    }

    public final void Dd() {
        CopyOnWriteArrayList<w60> copyOnWriteArrayList = this.e;
        ListIterator<w60> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous().Dd();
        }
        this.j = false;
        me();
    }

    public final boolean De(String str, Runnable runnable) {
        if (Gd()) {
            runnable.run();
            return true;
        }
        this.f.h(str, runnable);
        return false;
    }

    public final View Ed(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(getContext()).inflate(i, viewGroup);
    }

    public final void Ee(Runnable runnable) {
        rv1.m(runnable);
    }

    public final View Fd(int i, ViewGroup viewGroup, boolean z) {
        return LayoutInflater.from(getContext()).inflate(i, viewGroup, z);
    }

    public final void Fe(Runnable runnable, long j) {
        rv1.n(runnable, j);
    }

    public boolean Gd() {
        return this.j;
    }

    public final void Ge(int i) {
        He(i, null);
    }

    public final boolean Hd(Runnable runnable) {
        return this.f.j(runnable);
    }

    public final void He(int i, ViewGroup viewGroup) {
        this.i = LayoutInflater.from(getContext()).inflate(i, viewGroup, false);
    }

    public boolean Id() {
        return this.l;
    }

    public final void Ie(View view) {
        this.i = view;
    }

    public boolean Jd() {
        return this.k;
    }

    public final void Je(y60 y60Var) {
        if (this.g != y60Var) {
            this.g = y60Var;
            if (y60Var == null) {
                ed();
            }
            if (P()) {
                dd();
            }
        }
    }

    public final boolean Kd() {
        w60 w60VarLd = Ld();
        return w60VarLd == this ? le() : w60VarLd != null && w60VarLd.Kd();
    }

    public Runnable Ke(List list) {
        this.m = new ArrayList<>();
        this.o = list;
        return new a();
    }

    public final w60 Ld() {
        WeakReference<w60> weakReference = this.h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Runnable Le() {
        this.n = new ArrayList<>();
        return new c();
    }

    public y60 Md() {
        return new d();
    }

    public boolean Me() {
        return this.p;
    }

    public void Nd(boolean z) {
        if (z) {
            qt1.a("DK-Controller", "currentController:(" + getClass().getSimpleName() + ".java:0) onActive " + getClass().getCanonicalName());
        }
    }

    public final boolean Od(Activity activity) {
        if (activity == getActivity() && Gd()) {
            return kd();
        }
        return false;
    }

    public final boolean P() {
        for (y60 parent = this.g; parent != null; parent = parent.getParent()) {
            if (parent.f()) {
                return true;
            }
        }
        return false;
    }

    public final void Pd(Activity activity, Configuration configuration) {
        if (activity != getActivity()) {
            return;
        }
        Xc(configuration);
    }

    public final void Qc(Runnable runnable) {
        this.q.add(runnable);
    }

    public void Qd(Configuration configuration) {
    }

    public final boolean Rc(w60 w60Var) {
        if (this.d.contains(w60Var)) {
            return false;
        }
        this.d.add(w60Var);
        w60Var.Je(this.c);
        return true;
    }

    public final void Rd(Activity activity, Bundle bundle) {
        if (activity != getActivity()) {
            return;
        }
        Yc(bundle);
    }

    public final void Sc(boolean z) {
        if (this.k == z) {
            return;
        }
        this.k = z;
        m1(z);
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().Sc(z);
        }
    }

    public void Sd(Bundle bundle) {
    }

    public void Tc() {
        this.o = null;
        rv1.m(new b());
    }

    public void Td() {
    }

    public final boolean Uc(w60 w60Var) {
        if (Vc(w60Var)) {
            return true;
        }
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            if (it.next().Uc(w60Var)) {
                return true;
            }
        }
        return false;
    }

    public final void Ud(Activity activity) {
        if (activity != getActivity()) {
            return;
        }
        Zc();
    }

    public final boolean Vc(w60 w60Var) {
        return w60Var.td() == this.c;
    }

    public final boolean Vd() {
        if (Kd()) {
            return ld();
        }
        return false;
    }

    public final void Wc(w60 w60Var) {
        if (w60Var == null || w60Var.td() != this.c) {
            return;
        }
        this.e.remove(w60Var);
        if (w60Var.Gd()) {
            w60Var.Dd();
        }
    }

    public final boolean Wd(Activity activity, int i, KeyEvent keyEvent) {
        if (activity == getActivity() && Gd()) {
            return fd(i, keyEvent);
        }
        return false;
    }

    public final void Xc(Configuration configuration) {
        Qd(configuration);
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().Xc(configuration);
        }
    }

    public final boolean Xd(Activity activity, int i, KeyEvent keyEvent) {
        if (activity == getActivity() && Gd()) {
            return gd(i, keyEvent);
        }
        return false;
    }

    public final void Yc(Bundle bundle) {
        Sd(bundle);
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().Yc(bundle);
        }
    }

    public final void Yd(Activity activity, boolean z) {
        if (activity != getActivity()) {
            return;
        }
        hd(z);
    }

    public final void Zc() {
        Td();
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().Zc();
        }
    }

    public void Zd() {
    }

    public final void ad() {
        Zd();
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().ad();
        }
    }

    public final void ae(Activity activity) {
        if (activity != getActivity()) {
            return;
        }
        ad();
        Dd();
    }

    public final void bd(int i, int i2, Intent intent) {
        be(i, i2, intent);
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().bd(i, i2, intent);
        }
    }

    public void be(int i, int i2, Intent intent) {
    }

    public final void cd() {
        de();
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().cd();
        }
    }

    public final void ce(Activity activity, int i, int i2, Intent intent) {
        if (activity != getActivity()) {
            return;
        }
        bd(i, i2, intent);
    }

    public final void d4(w60 w60Var) {
        if (w60Var == null || w60Var.td() != this.c) {
            return;
        }
        this.e.remove(w60Var);
        this.e.add(w60Var);
        if (!this.j || w60Var.Gd()) {
            return;
        }
        w60Var.Cd();
    }

    public final void dd() {
        je();
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().dd();
        }
    }

    public void de() {
    }

    public final void ed() {
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().ed();
        }
        if (!this.q.isEmpty()) {
            Iterator<Runnable> it2 = this.q.iterator();
            while (it2.hasNext()) {
                it2.next().run();
            }
        }
        ne();
    }

    public final void ee(Activity activity) {
        if (activity != getActivity()) {
            return;
        }
        cd();
        Cd();
    }

    public final boolean fd(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        CopyOnWriteArrayList<w60> copyOnWriteArrayList = this.e;
        ListIterator<w60> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().fd(i, keyEvent)) {
                return true;
            }
        }
        return pe(i, keyEvent);
    }

    public void fe(Bundle bundle) {
    }

    public boolean g() {
        y60 y60Var = this.g;
        if (y60Var != null) {
            return y60Var.c(this);
        }
        return false;
    }

    public final boolean gd(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return !Kd() ? md() : ld();
        }
        CopyOnWriteArrayList<w60> copyOnWriteArrayList = this.e;
        ListIterator<w60> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().gd(i, keyEvent)) {
                return true;
            }
        }
        return qe(i, keyEvent);
    }

    public final boolean ge() {
        return md();
    }

    public final Activity getActivity() {
        return this.f19382b;
    }

    public final View getContentView() {
        return this.i;
    }

    public final ManagedContext getContext() {
        return this.f19381a;
    }

    public final void hd(boolean z) {
        re(z);
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().hd(z);
        }
    }

    public final void he(Activity activity, int i) {
        if (activity != getActivity()) {
            return;
        }
        id(i);
    }

    public final void id(int i) {
        ve(i);
        Iterator<w60> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().id(i);
        }
    }

    public final void ie(Activity activity, boolean z) {
        if (activity != getActivity()) {
            return;
        }
        jd(z);
    }

    public void je() {
    }

    public final boolean kd() {
        if (se()) {
            return true;
        }
        CopyOnWriteArrayList<w60> copyOnWriteArrayList = this.e;
        ListIterator<w60> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().kd()) {
                return true;
            }
        }
        return ke();
    }

    public boolean ke() {
        if (!Kd()) {
            return false;
        }
        ld();
        return true;
    }

    public final boolean ld() {
        w60 w60VarLd = Ld();
        return w60VarLd != this ? w60VarLd.ld() : oe();
    }

    public boolean le() {
        return true;
    }

    public void m1(boolean z) {
    }

    public final boolean md() {
        if (Kd()) {
            return true;
        }
        CopyOnWriteArrayList<w60> copyOnWriteArrayList = this.e;
        ListIterator<w60> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            w60 w60VarPrevious = listIterator.previous();
            if (w60VarPrevious.md()) {
                this.h = new WeakReference<>(w60VarPrevious);
                return true;
            }
        }
        if (!ue()) {
            return false;
        }
        this.h = new WeakReference<>(this);
        return true;
    }

    public void me() {
    }

    public final w60 nd(View view) {
        for (w60 w60Var : this.d) {
            if (w60Var.getContentView() == view) {
                return w60Var;
            }
        }
        return null;
    }

    public void ne() {
    }

    public final <T extends View> T od(int i) {
        View view = this.i;
        T t2 = view != null ? (T) view.findViewById(i) : null;
        return t2 == null ? (T) getActivity().findViewById(i) : t2;
    }

    public boolean oe() {
        return false;
    }

    public final void p5() {
        y60 y60Var = this.g;
        if (y60Var != null) {
            y60Var.b(this);
        } else {
            md();
        }
    }

    public final String pd(int i, Object... objArr) {
        return qd(vd(i), objArr);
    }

    public boolean pe(int i, KeyEvent keyEvent) {
        return false;
    }

    public final String qd(String str, Object... objArr) {
        return String.format(str, objArr);
    }

    public boolean qe(int i, KeyEvent keyEvent) {
        return false;
    }

    public void rd() {
    }

    public void re(boolean z) {
    }

    public final void s8() {
        if (getActivity().isFinishing()) {
            return;
        }
        getActivity().onBackPressed();
    }

    public final Drawable sd(int i) {
        return ContextCompat.getDrawable(getContext(), i);
    }

    public boolean se() {
        return false;
    }

    public final y60 td() {
        return this.g;
    }

    public boolean te(w60 w60Var) {
        return g();
    }

    public final Resources ud() {
        return getContext().getResources();
    }

    public boolean ue() {
        return false;
    }

    public final String vd(int i) {
        return ud().getString(i);
    }

    public void ve(int i) {
    }

    public final w60 wd(int i) {
        return this.d.get(i);
    }

    public void we(boolean z) {
    }

    public final int xd() {
        return this.d.size();
    }

    public final boolean xe(w60 w60Var) {
        if (!this.d.contains(w60Var)) {
            return false;
        }
        Wc(w60Var);
        this.d.remove(w60Var);
        w60Var.Je(null);
        return true;
    }

    public final CopyOnWriteArrayList<w60> yd() {
        return this.d;
    }

    public final void ye() {
        y60 y60Var = this.g;
        if (y60Var != null) {
            y60Var.d(this);
        } else if (Kd()) {
            ld();
        }
    }

    public String zd() {
        return null;
    }

    public final boolean ze(Runnable runnable) {
        if (Gd()) {
            runnable.run();
            return true;
        }
        this.f.b(runnable);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w60(xv1 xv1Var) {
        this.d = new CopyOnWriteArrayList<>();
        this.e = new CopyOnWriteArrayList<>();
        this.f = new fc2();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = true;
        this.l = true;
        this.p = true;
        this.q = new HashSet();
        if (xv1Var == null) {
            return;
        }
        x60 x60Var = new x60(xv1Var);
        this.f19381a = x60Var;
        this.f19382b = qd.c(x60Var);
        this.c = Md();
        if (this instanceof w01) {
            getContext().registerLocalFeature((w01) this);
        }
    }
}
