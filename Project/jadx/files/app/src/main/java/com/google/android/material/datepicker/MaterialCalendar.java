package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends com.google.android.material.datepicker.k<S> {

    @VisibleForTesting
    static final Object D = "MONTHS_VIEW_GROUP_TAG";

    @VisibleForTesting
    static final Object E = "NAVIGATION_PREV_TAG";

    @VisibleForTesting
    static final Object F = "NAVIGATION_NEXT_TAG";

    @VisibleForTesting
    static final Object G = "SELECTOR_TOGGLE_TAG";
    private RecyclerView A;
    private View B;
    private View C;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @StyleRes
    private int f15245t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private DateSelector<S> f15246u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private CalendarConstraints f15247v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private Month f15248w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CalendarSelector f15249x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.google.android.material.datepicker.b f15250y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RecyclerView f15251z;

    enum CalendarSelector {
        DAY,
        YEAR
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f15255s;

        a(int i2) {
            this.f15255s = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.A.smoothScrollToPosition(this.f15255s);
        }
    }

    class b extends AccessibilityDelegateCompat {
        b(MaterialCalendar materialCalendar) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    class c extends l {
        final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i2, boolean z2, int i3) {
            super(context, i2, z2);
            this.a = i3;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.a == 0) {
                iArr[0] = MaterialCalendar.this.A.getWidth();
                iArr[1] = MaterialCalendar.this.A.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.A.getHeight();
                iArr[1] = MaterialCalendar.this.A.getHeight();
            }
        }
    }

    class d implements k {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.k
        public void a(long j2) {
            if (MaterialCalendar.this.f15247v.a().f(j2)) {
                MaterialCalendar.this.f15246u.g(j2);
                Iterator<com.google.android.material.datepicker.j<S>> it = MaterialCalendar.this.f15334s.iterator();
                while (it.hasNext()) {
                    it.next().a(MaterialCalendar.this.f15246u.m());
                }
                MaterialCalendar.this.A.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f15251z != null) {
                    MaterialCalendar.this.f15251z.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    class e extends RecyclerView.ItemDecoration {
        private final Calendar a = n.f();
        private final Calendar b = n.f();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof o) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                o oVar = (o) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : MaterialCalendar.this.f15246u.j()) {
                    Long l2 = pair.first;
                    if (l2 != null && pair.second != null) {
                        this.a.setTimeInMillis(l2.longValue());
                        this.b.setTimeInMillis(pair.second.longValue());
                        int iA = oVar.a(this.a.get(1));
                        int iA2 = oVar.a(this.b.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iA);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iA2);
                        int spanCount = iA / gridLayoutManager.getSpanCount();
                        int spanCount2 = iA2 / gridLayoutManager.getSpanCount();
                        int i2 = spanCount;
                        while (i2 <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i2) != null) {
                                canvas.drawRect(i2 == spanCount ? viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2) : 0, r9.getTop() + MaterialCalendar.this.f15250y.f15301d.b(), i2 == spanCount2 ? viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - MaterialCalendar.this.f15250y.f15301d.a(), MaterialCalendar.this.f15250y.f15305h);
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    class f extends AccessibilityDelegateCompat {
        f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setHintText(MaterialCalendar.this.C.getVisibility() == 0 ? MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection));
        }
    }

    class g extends RecyclerView.OnScrollListener {
        final /* synthetic */ com.google.android.material.datepicker.i a;
        final /* synthetic */ MaterialButton b;

        g(com.google.android.material.datepicker.i iVar, MaterialButton materialButton) {
            this.a = iVar;
            this.b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                CharSequence text = this.b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            int iFindFirstVisibleItemPosition = i2 < 0 ? MaterialCalendar.this.k().findFirstVisibleItemPosition() : MaterialCalendar.this.k().findLastVisibleItemPosition();
            MaterialCalendar.this.f15248w = this.a.a(iFindFirstVisibleItemPosition);
            this.b.setText(this.a.b(iFindFirstVisibleItemPosition));
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.l();
        }
    }

    class i implements View.OnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.i f15260s;

        i(com.google.android.material.datepicker.i iVar) {
            this.f15260s = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindFirstVisibleItemPosition = MaterialCalendar.this.k().findFirstVisibleItemPosition() + 1;
            if (iFindFirstVisibleItemPosition < MaterialCalendar.this.A.getAdapter().getItemCount()) {
                MaterialCalendar.this.a(this.f15260s.a(iFindFirstVisibleItemPosition));
            }
        }
    }

    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.i f15262s;

        j(com.google.android.material.datepicker.i iVar) {
            this.f15262s = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindLastVisibleItemPosition = MaterialCalendar.this.k().findLastVisibleItemPosition() - 1;
            if (iFindLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.a(this.f15262s.a(iFindLastVisibleItemPosition));
            }
        }
    }

    interface k {
        void a(long j2);
    }

    @NonNull
    private RecyclerView.ItemDecoration m() {
        return new e();
    }

    @Nullable
    CalendarConstraints g() {
        return this.f15247v;
    }

    com.google.android.material.datepicker.b h() {
        return this.f15250y;
    }

    @Nullable
    Month i() {
        return this.f15248w;
    }

    @Nullable
    public DateSelector<S> j() {
        return this.f15246u;
    }

    @NonNull
    LinearLayoutManager k() {
        return (LinearLayoutManager) this.A.getLayoutManager();
    }

    void l() {
        CalendarSelector calendarSelector = this.f15249x;
        if (calendarSelector == CalendarSelector.YEAR) {
            a(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            a(CalendarSelector.YEAR);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f15245t = bundle.getInt("THEME_RES_ID_KEY");
        this.f15246u = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f15247v = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f15248w = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f15245t);
        this.f15250y = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month monthE = this.f15247v.e();
        if (MaterialDatePicker.f(contextThemeWrapper)) {
            i2 = R$layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = R$layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.e());
        gridView.setNumColumns(monthE.f15280v);
        gridView.setEnabled(false);
        this.A = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_months);
        this.A.setLayoutManager(new c(getContext(), i3, false, i3));
        this.A.setTag(D);
        com.google.android.material.datepicker.i iVar = new com.google.android.material.datepicker.i(contextThemeWrapper, this.f15246u, this.f15247v, new d());
        this.A.setAdapter(iVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        this.f15251z = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        RecyclerView recyclerView = this.f15251z;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f15251z.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f15251z.setAdapter(new o(this));
            this.f15251z.addItemDecoration(m());
        }
        if (viewInflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            a(viewInflate, iVar);
        }
        if (!MaterialDatePicker.f(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.A);
        }
        this.A.scrollToPosition(iVar.a(this.f15248w));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f15245t);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f15246u);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f15247v);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f15248w);
    }

    private void c(int i2) {
        this.A.post(new a(i2));
    }

    @NonNull
    public static <T> MaterialCalendar<T> a(@NonNull DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.d());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    void a(Month month) {
        com.google.android.material.datepicker.i iVar = (com.google.android.material.datepicker.i) this.A.getAdapter();
        int iA = iVar.a(month);
        int iA2 = iA - iVar.a(this.f15248w);
        boolean z2 = Math.abs(iA2) > 3;
        boolean z3 = iA2 > 0;
        this.f15248w = month;
        if (z2 && z3) {
            this.A.scrollToPosition(iA - 3);
            c(iA);
        } else if (z2) {
            this.A.scrollToPosition(iA + 3);
            c(iA);
        } else {
            c(iA);
        }
    }

    @Px
    static int a(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    void a(CalendarSelector calendarSelector) {
        this.f15249x = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f15251z.getLayoutManager().scrollToPosition(((o) this.f15251z.getAdapter()).a(this.f15248w.f15279u));
            this.B.setVisibility(0);
            this.C.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.B.setVisibility(8);
            this.C.setVisibility(0);
            a(this.f15248w);
        }
    }

    private void a(@NonNull View view, @NonNull com.google.android.material.datepicker.i iVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(G);
        ViewCompat.setAccessibilityDelegate(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.month_navigation_previous);
        materialButton2.setTag(E);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.month_navigation_next);
        materialButton3.setTag(F);
        this.B = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.C = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        a(CalendarSelector.DAY);
        materialButton.setText(this.f15248w.c(view.getContext()));
        this.A.addOnScrollListener(new g(iVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(iVar));
        materialButton2.setOnClickListener(new j(iVar));
    }

    @Override // com.google.android.material.datepicker.k
    public boolean a(@NonNull com.google.android.material.datepicker.j<S> jVar) {
        return super.a(jVar);
    }
}
