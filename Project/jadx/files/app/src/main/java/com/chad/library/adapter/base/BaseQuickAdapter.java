package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseQuickAdapter<T, K extends com.chad.library.adapter.base.b> extends RecyclerView.Adapter<K> {
    private boolean A;
    private boolean B;
    private k C;
    private RecyclerView D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private j I;
    private l J;
    private boolean a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.chad.library.adapter.base.e.a f14716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f14717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f14719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h f14720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private f f14721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Interpolator f14724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14725m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f14726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.chad.library.adapter.base.c.b f14727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.chad.library.adapter.base.c.b f14728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LinearLayout f14729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LinearLayout f14730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private FrameLayout f14731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f14732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f14733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f14734v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected Context f14735w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f14736x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected LayoutInflater f14737y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected List<T> f14738z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationType {
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseQuickAdapter.this.f14716d.f() == 3) {
                BaseQuickAdapter.this.p();
            }
            if (BaseQuickAdapter.this.f14718f && BaseQuickAdapter.this.f14716d.f() == 4) {
                BaseQuickAdapter.this.p();
            }
        }
    }

    class b extends GridLayoutManager.SpanSizeLookup {
        final /* synthetic */ GridLayoutManager a;
        final /* synthetic */ GridLayoutManager.SpanSizeLookup b;

        b(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.a = gridLayoutManager;
            this.b = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            int itemViewType = BaseQuickAdapter.this.getItemViewType(i2);
            if (itemViewType == 273 && BaseQuickAdapter.this.j()) {
                return 1;
            }
            if (itemViewType == 819 && BaseQuickAdapter.this.i()) {
                return 1;
            }
            return BaseQuickAdapter.this.I == null ? BaseQuickAdapter.this.b(itemViewType) ? this.a.getSpanCount() : this.b.getSpanSize(i2) : BaseQuickAdapter.this.b(itemViewType) ? this.a.getSpanCount() : BaseQuickAdapter.this.I.a(this.a, i2 - BaseQuickAdapter.this.c());
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.chad.library.adapter.base.b f14741s;

        c(com.chad.library.adapter.base.b bVar) {
            this.f14741s = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition = this.f14741s.getAdapterPosition();
            if (adapterPosition == -1) {
                return;
            }
            BaseQuickAdapter.this.b(view, adapterPosition - BaseQuickAdapter.this.c());
        }
    }

    class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.chad.library.adapter.base.b f14743s;

        d(com.chad.library.adapter.base.b bVar) {
            this.f14743s = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int adapterPosition = this.f14743s.getAdapterPosition();
            if (adapterPosition == -1) {
                return false;
            }
            return BaseQuickAdapter.this.c(view, adapterPosition - BaseQuickAdapter.this.c());
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseQuickAdapter.this.f14717e != null) {
                BaseQuickAdapter.this.f14717e.a();
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface f {
        void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface g {
        void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    public interface h {
        boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    public interface i {
        void a();
    }

    public interface j {
        int a(GridLayoutManager gridLayoutManager, int i2);
    }

    public interface k {
        void a();
    }

    public interface l {
        void a(TextView textView, TextView textView2);
    }

    public BaseQuickAdapter(@LayoutRes int i2, @Nullable List<T> list) {
        this.a = false;
        this.b = false;
        this.f14715c = false;
        this.f14716d = new com.chad.library.adapter.base.e.b();
        this.f14718f = false;
        this.f14722j = true;
        this.f14723k = false;
        this.f14724l = new LinearInterpolator();
        this.f14725m = 300;
        this.f14726n = -1;
        this.f14728p = new com.chad.library.adapter.base.c.a();
        this.f14732t = true;
        this.E = 1;
        this.F = 1;
        this.f14738z = list == null ? new ArrayList<>() : list;
        if (i2 != 0) {
            this.f14736x = i2;
        }
    }

    private void e(int i2) {
        if (u() != 0 && i2 >= getItemCount() - this.E && this.f14716d.f() == 1) {
            this.f14716d.a(2);
            if (this.f14715c) {
                return;
            }
            this.f14715c = true;
            if (h() != null) {
                h().post(new e());
                return;
            }
            i iVar = this.f14717e;
            if (iVar != null) {
                iVar.a();
            }
        }
    }

    private void f(int i2) {
        k kVar;
        if (!k() || l() || i2 > this.F || (kVar = this.C) == null) {
            return;
        }
        kVar.a();
    }

    private void g(int i2) {
        List<T> list = this.f14738z;
        if ((list == null ? 0 : list.size()) == i2) {
            notifyDataSetChanged();
        }
    }

    private int s() {
        int i2 = 1;
        if (a() != 1) {
            return c() + this.f14738z.size();
        }
        if (this.f14733u && c() != 0) {
            i2 = 2;
        }
        if (this.f14734v) {
            return i2;
        }
        return -1;
    }

    private int t() {
        return (a() != 1 || this.f14733u) ? 0 : -1;
    }

    private int u() {
        if (this.f14717e == null || !this.b) {
            return 0;
        }
        return ((this.a || !this.f14716d.j()) && this.f14738z.size() != 0) ? 1 : 0;
    }

    protected abstract void a(@NonNull K k2, T t2);

    protected void a(@NonNull K k2, T t2, @NonNull List<Object> list) {
    }

    protected boolean b(int i2) {
        return i2 == 1365 || i2 == 273 || i2 == 819 || i2 == 546;
    }

    @NonNull
    public List<T> getData() {
        return this.f14738z;
    }

    @Nullable
    public T getItem(@IntRange(from = 0) int i2) {
        if (i2 < 0 || i2 >= this.f14738z.size()) {
            return null;
        }
        return this.f14738z.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i2 = 1;
        if (1 != a()) {
            return u() + c() + this.f14738z.size() + b();
        }
        if (this.f14733u && c() != 0) {
            i2 = 2;
        }
        return (!this.f14734v || b() == 0) ? i2 : i2 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (a() == 1) {
            boolean z2 = this.f14733u && c() != 0;
            if (i2 != 0) {
                return i2 != 1 ? i2 != 2 ? 1365 : 819 : z2 ? 1365 : 819;
            }
            if (z2) {
                return com.umeng.commonsdk.stateless.b.a;
            }
            return 1365;
        }
        int iC = c();
        if (i2 < iC) {
            return com.umeng.commonsdk.stateless.b.a;
        }
        int i3 = i2 - iC;
        int size = this.f14738z.size();
        return i3 < size ? a(i3) : i3 - size < b() ? 819 : 546;
    }

    protected RecyclerView h() {
        return this.D;
    }

    public boolean i() {
        return this.H;
    }

    public boolean j() {
        return this.G;
    }

    public boolean k() {
        return this.A;
    }

    public boolean l() {
        return this.B;
    }

    public void m() {
        if (u() == 0) {
            return;
        }
        this.f14715c = false;
        this.a = true;
        this.f14716d.a(1);
        notifyItemChanged(d());
    }

    public void n() {
        a(false);
    }

    public void o() {
        if (u() == 0) {
            return;
        }
        this.f14715c = false;
        this.f14716d.a(3);
        notifyItemChanged(d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new b(gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    public void p() {
        if (this.f14716d.f() == 2) {
            return;
        }
        this.f14716d.a(1);
        notifyItemChanged(d());
    }

    public void q() {
        this.f14723k = true;
    }

    public void r() {
        if (c() == 0) {
            return;
        }
        this.f14729q.removeAllViews();
        int iT = t();
        if (iT != -1) {
            notifyItemRemoved(iT);
        }
    }

    private void b(RecyclerView recyclerView) {
        this.D = recyclerView;
    }

    public void a(RecyclerView recyclerView) {
        if (h() == recyclerView) {
            throw new IllegalStateException("Don't bind twice");
        }
        b(recyclerView);
        h().setAdapter(this);
    }

    public int c() {
        LinearLayout linearLayout = this.f14729q;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int d() {
        return c() + this.f14738z.size() + b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2, @NonNull List list) {
        a((com.chad.library.adapter.base.b) viewHolder, i2, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public K onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        K k2;
        this.f14735w = viewGroup.getContext();
        this.f14737y = LayoutInflater.from(this.f14735w);
        if (i2 == 273) {
            ViewParent parent = this.f14729q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f14729q);
            }
            k2 = (K) c((View) this.f14729q);
        } else if (i2 == 546) {
            k2 = (K) a(viewGroup);
        } else if (i2 == 819) {
            ViewParent parent2 = this.f14730r.getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(this.f14730r);
            }
            k2 = (K) c((View) this.f14730r);
        } else if (i2 != 1365) {
            k2 = (K) d(viewGroup, i2);
            a((com.chad.library.adapter.base.b) k2);
        } else {
            ViewParent parent3 = this.f14731s.getParent();
            if (parent3 instanceof ViewGroup) {
                ((ViewGroup) parent3).removeView(this.f14731s);
            }
            k2 = (K) c((View) this.f14731s);
        }
        k2.a(this);
        return k2;
    }

    private void b(i iVar) {
        this.f14717e = iVar;
        this.a = true;
        this.b = true;
        this.f14715c = false;
    }

    public boolean c(View view, int i2) {
        return g().a(this, view, i2);
    }

    public void d(@IntRange(from = 0) int i2) {
        this.f14738z.remove(i2);
        int iC = i2 + c();
        notifyItemRemoved(iC);
        g(0);
        notifyItemRangeChanged(iC, this.f14738z.size() - iC);
    }

    public final h g() {
        return this.f14720h;
    }

    protected K c(View view) {
        K k2;
        Class clsA = null;
        for (Class<?> superclass = getClass(); clsA == null && superclass != null; superclass = superclass.getSuperclass()) {
            clsA = a((Class) superclass);
        }
        if (clsA == null) {
            k2 = (K) new com.chad.library.adapter.base.b(view);
        } else {
            k2 = (K) a(clsA, view);
        }
        return k2 != null ? k2 : (K) new com.chad.library.adapter.base.b(view);
    }

    public final g f() {
        return this.f14719g;
    }

    @Deprecated
    public void a(i iVar) {
        b(iVar);
    }

    public void a(i iVar, RecyclerView recyclerView) {
        b(iVar);
        if (h() == null) {
            b(recyclerView);
        }
    }

    public void b(String str) {
        if (u() == 0) {
            return;
        }
        this.f14715c = false;
        this.f14716d.a(3, str);
        notifyItemChanged(d());
    }

    protected K d(ViewGroup viewGroup, int i2) {
        return (K) a(viewGroup, this.f14736x);
    }

    public void d(View view) {
        boolean z2;
        int itemCount = getItemCount();
        int i2 = 0;
        if (this.f14731s == null) {
            this.f14731s = new FrameLayout(view.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = layoutParams2.width;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = layoutParams2.height;
            }
            this.f14731s.setLayoutParams(layoutParams);
            z2 = true;
        } else {
            z2 = false;
        }
        this.f14731s.removeAllViews();
        this.f14731s.addView(view);
        this.f14732t = true;
        if (z2 && a() == 1) {
            if (this.f14733u && c() != 0) {
                i2 = 1;
            }
            if (getItemCount() > itemCount) {
                notifyItemInserted(i2);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void a(com.chad.library.adapter.base.e.a aVar) {
        this.f14716d = aVar;
    }

    public void c(int i2) {
        this.f14723k = true;
        this.f14727o = null;
        if (i2 == 1) {
            this.f14728p = new com.chad.library.adapter.base.c.a();
            return;
        }
        if (i2 == 2) {
            this.f14728p = new com.chad.library.adapter.base.c.c();
            return;
        }
        if (i2 == 3) {
            this.f14728p = new com.chad.library.adapter.base.c.d();
        } else if (i2 == 4) {
            this.f14728p = new com.chad.library.adapter.base.c.e();
        } else {
            if (i2 != 5) {
                return;
            }
            this.f14728p = new com.chad.library.adapter.base.c.f();
        }
    }

    public void a(boolean z2) {
        if (u() == 0) {
            return;
        }
        this.f14715c = false;
        this.a = false;
        this.f14716d.a(z2);
        if (z2) {
            notifyItemRemoved(d());
        } else {
            this.f14716d.a(4);
            notifyItemChanged(d());
        }
    }

    public void b(boolean z2) {
        int iU = u();
        this.b = z2;
        int iU2 = u();
        if (iU == 1) {
            if (iU2 == 0) {
                notifyItemRemoved(d());
            }
        } else if (iU2 == 1) {
            this.f14716d.a(1);
            notifyItemInserted(d());
        }
    }

    @Nullable
    public final f e() {
        return this.f14721i;
    }

    private int c(T t2) {
        List<T> list;
        if (t2 == null || (list = this.f14738z) == null || list.isEmpty()) {
            return -1;
        }
        return this.f14738z.indexOf(t2);
    }

    public void b(@NonNull Collection<? extends T> collection) {
        List<T> list = this.f14738z;
        if (collection != list) {
            list.clear();
            this.f14738z.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public BaseQuickAdapter(@Nullable List<T> list) {
        this(0, list);
    }

    public void a(String str) {
        if (u() == 0) {
            return;
        }
        this.f14715c = false;
        this.a = true;
        this.f14716d.a(1, str);
        notifyItemChanged(d());
    }

    public BaseQuickAdapter(@LayoutRes int i2) {
        this(i2, null);
    }

    public int b() {
        LinearLayout linearLayout = this.f14730r;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NonNull K k2) {
        super.onViewAttachedToWindow(k2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType != 1365 && itemViewType != 273 && itemViewType != 819 && itemViewType != 546) {
            b((RecyclerView.ViewHolder) k2);
        } else {
            a((RecyclerView.ViewHolder) k2);
        }
    }

    public void a(int i2, int i3) {
        if (u() == 0) {
            return;
        }
        this.f14715c = false;
        this.a = true;
        this.f14716d.a(1, i2, i3);
        notifyItemChanged(d());
    }

    public void b(View view, int i2) {
        f().onItemClick(this, view, i2);
    }

    public int b(View view) {
        return a(view, -1);
    }

    public void a(@Nullable List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f14738z = list;
        if (this.f14717e != null) {
            this.a = true;
            this.b = true;
            this.f14715c = false;
            this.f14716d.a(1);
        }
        this.f14726n = -1;
        notifyDataSetChanged();
    }

    public int b(View view, int i2, int i3) {
        int iT;
        if (this.f14729q == null) {
            this.f14729q = new LinearLayout(view.getContext());
            if (i3 == 1) {
                this.f14729q.setOrientation(1);
                this.f14729q.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.f14729q.setOrientation(0);
                this.f14729q.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        int childCount = this.f14729q.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.f14729q.addView(view, i2);
        if (this.f14729q.getChildCount() == 1 && (iT = t()) != -1) {
            notifyItemInserted(iT);
        }
        return i2;
    }

    public void a(@IntRange(from = 0) int i2, @NonNull T t2) {
        this.f14738z.add(i2, t2);
        notifyItemInserted(i2 + c());
        g(1);
    }

    private void b(RecyclerView.ViewHolder viewHolder) {
        if (this.f14723k) {
            if (!this.f14722j || viewHolder.getLayoutPosition() > this.f14726n) {
                com.chad.library.adapter.base.c.b bVar = this.f14727o;
                if (bVar == null) {
                    bVar = this.f14728p;
                }
                for (Animator animator : bVar.a(viewHolder.itemView)) {
                    a(animator, viewHolder.getLayoutPosition());
                }
                this.f14726n = viewHolder.getLayoutPosition();
            }
        }
    }

    public void a(@NonNull T t2) {
        this.f14738z.add(t2);
        notifyItemInserted(this.f14738z.size() + c());
        g(1);
    }

    public void a(@IntRange(from = 0) int i2, @NonNull Collection<? extends T> collection) {
        this.f14738z.addAll(i2, collection);
        notifyItemRangeInserted(i2 + c(), collection.size());
        g(collection.size());
    }

    public void a(@NonNull Collection<? extends T> collection) {
        this.f14738z.addAll(collection);
        notifyItemRangeInserted((this.f14738z.size() - collection.size()) + c(), collection.size());
        g(collection.size());
    }

    public int b(@NonNull T t2) {
        int iC = c(t2);
        if (iC == -1) {
            return -1;
        }
        int iC2 = t2 instanceof com.chad.library.adapter.base.d.a ? ((com.chad.library.adapter.base.d.a) t2).c() : Integer.MAX_VALUE;
        if (iC2 == 0) {
            return iC;
        }
        if (iC2 == -1) {
            return -1;
        }
        while (iC >= 0) {
            T t3 = this.f14738z.get(iC);
            if (t3 instanceof com.chad.library.adapter.base.d.a) {
                com.chad.library.adapter.base.d.a aVar = (com.chad.library.adapter.base.d.a) t3;
                if (aVar.c() >= 0 && aVar.c() < iC2) {
                    return iC;
                }
            }
            iC--;
        }
        return -1;
    }

    public int a() {
        FrameLayout frameLayout = this.f14731s;
        return (frameLayout == null || frameLayout.getChildCount() == 0 || !this.f14732t || this.f14738z.size() != 0) ? 0 : 1;
    }

    protected int a(int i2) {
        return super.getItemViewType(i2);
    }

    private K a(ViewGroup viewGroup) {
        View viewA = a(this.f14716d.a(), viewGroup);
        if (this.J != null) {
            try {
                this.J.a((TextView) viewA.findViewById(this.f14716d.i()), (TextView) viewA.findViewById(this.f14716d.c()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        K k2 = (K) c(viewA);
        k2.itemView.setOnClickListener(new a());
        return k2;
    }

    protected void a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull K k2, int i2) {
        f(i2);
        e(i2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType == 0) {
            a(k2, getItem(i2 - c()));
            return;
        }
        if (itemViewType != 273) {
            if (itemViewType == 546) {
                this.f14716d.a(k2);
            } else {
                if (itemViewType == 819 || itemViewType == 1365) {
                    return;
                }
                a(k2, getItem(i2 - c()));
            }
        }
    }

    public void a(@NonNull K k2, int i2, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(k2, i2);
            return;
        }
        f(i2);
        e(i2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType != 273) {
            if (itemViewType == 546) {
                this.f14716d.a(k2);
            } else {
                if (itemViewType == 819 || itemViewType == 1365) {
                    return;
                }
                a(k2, getItem(i2 - c()), list);
            }
        }
    }

    protected void a(K k2) {
        if (k2 == null) {
            return;
        }
        View view = k2.itemView;
        if (f() != null) {
            view.setOnClickListener(new c(k2));
        }
        if (g() != null) {
            view.setOnLongClickListener(new d(k2));
        }
    }

    protected K a(ViewGroup viewGroup, int i2) {
        return (K) c(a(i2, viewGroup));
    }

    private K a(Class cls, View view) {
        try {
            if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(getClass(), View.class);
                declaredConstructor.setAccessible(true);
                return (K) declaredConstructor.newInstance(this, view);
            }
            Constructor<T> declaredConstructor2 = cls.getDeclaredConstructor(View.class);
            declaredConstructor2.setAccessible(true);
            return (K) declaredConstructor2.newInstance(view);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private Class a(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (com.chad.library.adapter.base.b.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            } else if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    Class cls3 = (Class) rawType;
                    if (com.chad.library.adapter.base.b.class.isAssignableFrom(cls3)) {
                        return cls3;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    public int a(View view, int i2) {
        return b(view, i2, 1);
    }

    public int a(View view) {
        return a(view, -1, 1);
    }

    public int a(View view, int i2, int i3) {
        int iS;
        if (this.f14730r == null) {
            this.f14730r = new LinearLayout(view.getContext());
            if (i3 == 1) {
                this.f14730r.setOrientation(1);
                this.f14730r.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.f14730r.setOrientation(0);
                this.f14730r.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        int childCount = this.f14730r.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.f14730r.addView(view, i2);
        if (this.f14730r.getChildCount() == 1 && (iS = s()) != -1) {
            notifyItemInserted(iS);
        }
        return i2;
    }

    protected void a(Animator animator, int i2) {
        animator.setDuration(this.f14725m).start();
        animator.setInterpolator(this.f14724l);
    }

    protected View a(@LayoutRes int i2, ViewGroup viewGroup) {
        return this.f14737y.inflate(i2, viewGroup, false);
    }

    public void a(l lVar) {
        this.J = lVar;
    }

    public void a(@Nullable g gVar) {
        this.f14719g = gVar;
    }

    public void a(f fVar) {
        this.f14721i = fVar;
    }
}
