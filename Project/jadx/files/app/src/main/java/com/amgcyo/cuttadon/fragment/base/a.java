package com.amgcyo.cuttadon.fragment.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.view.dialog.d1;
import com.amgcyo.cuttadon.widget.ui.b;
import java.util.List;
import l.b.a.j;
import me.jessyan.art.base.f.i;
import me.jessyan.art.f.g;
import me.jessyan.art.f.h;
import me.jessyan.art.mvp.Message;
import me.jessyan.art.mvp.c;
import me.jessyan.art.mvp.e;

/* JADX INFO: compiled from: MkBaseArtFragment.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<P extends c> extends Fragment implements i<P>, e {
    private static long F;
    private Handler A;
    protected int B;
    private d1 C;
    public boolean D;
    private b.c E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private me.jessyan.art.d.j.a<String, Object> f3724s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected Context f3725t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected P f3726u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f3727v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected me.jessyan.art.c.e.c f3728w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f3729x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected boolean f3730y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f3731z;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.fragment.base.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MkBaseArtFragment.java */
    class RunnableC0089a implements Runnable {
        RunnableC0089a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i();
        }
    }

    /* JADX INFO: compiled from: MkBaseArtFragment.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(true);
        }
    }

    public a() {
        getClass().getSimpleName();
        this.f3729x = true;
        this.f3730y = false;
        this.f3731z = false;
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        if (isAdded()) {
            List<Fragment> fragments = getChildFragmentManager().getFragments();
            if (fragments.isEmpty()) {
                return;
            }
            for (Fragment fragment : fragments) {
                if ((fragment instanceof a) && fragment.isAdded() && !fragment.isHidden() && fragment.getUserVisibleHint()) {
                    ((a) fragment).c(z2);
                }
            }
        }
    }

    private void c(boolean z2) {
        if ((z2 && o()) || this.f3731z == z2) {
            return;
        }
        this.f3731z = z2;
        if (!z2) {
            b(false);
            g();
        } else if (isAdded()) {
            if (this.f3729x) {
                f();
                a(true);
                this.f3729x = false;
            } else {
                a(false);
            }
            h();
            l();
        }
    }

    private void l() {
        m().post(new b());
    }

    private Handler m() {
        if (this.A == null) {
            this.A = new Handler(Looper.getMainLooper());
        }
        return this.A;
    }

    protected static boolean n() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = jCurrentTimeMillis - F < 500;
        F = jCurrentTimeMillis;
        return z2;
    }

    private boolean o() {
        if (getParentFragment() instanceof a) {
            return !((a) r0).p();
        }
        return false;
    }

    private boolean p() {
        return this.f3731z;
    }

    public void a(boolean z2) {
    }

    @Override // me.jessyan.art.mvp.e
    public void addBookToShelfV6(Message message) {
        Context context = this.f3725t;
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).addBookToShelfV6(message);
        } else {
            a("参数异常！");
        }
    }

    protected void f() {
    }

    @Override // me.jessyan.art.mvp.e
    public void finishReadActivity() {
    }

    public void g() {
    }

    @Override // me.jessyan.art.mvp.e
    public Context getHostContext() {
        return this.f3725t;
    }

    public void h() {
    }

    public void handleMessage(@NonNull Message message) {
    }

    @Override // me.jessyan.art.mvp.e
    public void hideLoading() {
        try {
            if (this.C == null || !this.C.isShowing()) {
                return;
            }
            this.C.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void i() {
        this.E.f();
    }

    public void j() {
        this.E.e();
    }

    public void k() {
        showLoading("");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f3730y = true;
        if (isHidden() || !getUserVisibleHint()) {
            return;
        }
        c(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f3725t = context;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.f3727v;
        if (view != null) {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f3727v);
            }
        } else {
            this.f3727v = layoutInflater.inflate(a(), (ViewGroup) null);
        }
        this.E = com.amgcyo.cuttadon.widget.ui.b.b().a(this.f3727v).a(new RunnableC0089a());
        return this.E.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f3730y = false;
        this.f3729x = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3725t = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
        if (z2) {
            c(false);
        } else {
            c(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f3731z && getUserVisibleHint()) {
            c(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f3729x || isHidden() || this.f3731z || !getUserVisibleHint()) {
            return;
        }
        c(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f3728w = me.jessyan.art.f.e.a(this.f3725t).imageLoader();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (this.f3726u == null) {
            this.f3726u = obtainPresenter();
        }
    }

    @Override // me.jessyan.art.base.f.i
    @NonNull
    public synchronized me.jessyan.art.d.j.a<String, Object> provideCache() {
        if (this.f3724s == null) {
            this.f3724s = me.jessyan.art.f.e.a(getActivity()).a().a(me.jessyan.art.d.j.b.f21179e);
        }
        return this.f3724s;
    }

    @Override // me.jessyan.art.base.f.i
    public void setPresenter(@Nullable P p2) {
        this.f3726u = p2;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (this.f3730y) {
            if (z2 && !this.f3731z) {
                c(true);
            } else {
                if (z2 || !this.f3731z) {
                    return;
                }
                c(false);
            }
        }
    }

    @Override // me.jessyan.art.mvp.e
    public void showEmpty() {
        this.E.d();
    }

    @Override // me.jessyan.art.mvp.e
    public void showLoadSuccess() {
        this.E.f();
    }

    @Override // me.jessyan.art.mvp.e
    public void showLoading(String str) {
        if (this.C == null) {
            d1.b bVar = new d1.b(this.f3725t);
            bVar.b(true);
            bVar.a(false);
            this.C = bVar.a();
        }
        this.C.show();
    }

    @Override // me.jessyan.art.mvp.e
    public void showLoginDialog(@NonNull String str) {
    }

    @Override // me.jessyan.art.mvp.e
    public void showMessage(@NonNull String str) {
        g.a(str);
        j.a((CharSequence) str);
    }

    @Override // me.jessyan.art.mvp.e
    public void showToasyErrorMessage(@NonNull String str) {
        a(str);
    }

    @Override // me.jessyan.art.base.f.i
    public boolean useEventBus() {
        return true;
    }

    protected void a(LinearLayout linearLayout) {
        linearLayout.setVisibility(0);
        this.B = h.a(this.f3725t);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = this.B;
        linearLayout.setLayoutParams(layoutParams);
        h.c((Activity) this.f3725t);
        h.a((Activity) this.f3725t);
    }

    protected void b(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(0);
        }
    }

    protected void a(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(8);
        }
    }

    public void b(@NonNull String str) {
        o.f(str);
    }

    public void a(@NonNull String str) {
        o.e(str);
    }
}
