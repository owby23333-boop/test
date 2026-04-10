package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.s;
import com.google.android.material.shape.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final String C = MaterialButtonToggleGroup.class.getSimpleName();
    private static final int D = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private boolean A;

    @IdRes
    private int B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final List<d> f15107s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final c f15108t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final f f15109u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final LinkedHashSet<e> f15110v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Comparator<MaterialButton> f15111w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Integer[] f15112x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f15113y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f15114z;

    class a implements Comparator<MaterialButton> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.b(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private class c implements MaterialButton.a {
        private c() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(@NonNull MaterialButton materialButton, boolean z2) {
            if (MaterialButtonToggleGroup.this.f15113y) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f15114z) {
                MaterialButtonToggleGroup.this.B = z2 ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.d(materialButton.getId(), z2)) {
                MaterialButtonToggleGroup.this.b(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.android.material.shape.c f15116e = new com.google.android.material.shape.a(0.0f);
        com.google.android.material.shape.c a;
        com.google.android.material.shape.c b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.google.android.material.shape.c f15117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.google.android.material.shape.c f15118d;

        d(com.google.android.material.shape.c cVar, com.google.android.material.shape.c cVar2, com.google.android.material.shape.c cVar3, com.google.android.material.shape.c cVar4) {
            this.a = cVar;
            this.b = cVar3;
            this.f15117c = cVar4;
            this.f15118d = cVar2;
        }

        public static d a(d dVar, View view) {
            return s.e(view) ? b(dVar) : c(dVar);
        }

        public static d b(d dVar, View view) {
            return s.e(view) ? c(dVar) : b(dVar);
        }

        public static d c(d dVar) {
            com.google.android.material.shape.c cVar = f15116e;
            return new d(cVar, cVar, dVar.b, dVar.f15117c);
        }

        public static d d(d dVar) {
            com.google.android.material.shape.c cVar = dVar.a;
            com.google.android.material.shape.c cVar2 = f15116e;
            return new d(cVar, cVar2, dVar.b, cVar2);
        }

        public static d a(d dVar) {
            com.google.android.material.shape.c cVar = f15116e;
            return new d(cVar, dVar.f15118d, cVar, dVar.f15117c);
        }

        public static d b(d dVar) {
            com.google.android.material.shape.c cVar = dVar.a;
            com.google.android.material.shape.c cVar2 = dVar.f15118d;
            com.google.android.material.shape.c cVar3 = f15116e;
            return new d(cVar, cVar2, cVar3, cVar3);
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i2, boolean z2);
    }

    private class f implements MaterialButton.b {
        private f() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton materialButton, boolean z2) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private void c(@IdRes int i2, boolean z2) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById instanceof MaterialButton) {
            this.f15113y = true;
            ((MaterialButton) viewFindViewById).setChecked(z2);
            this.f15113y = false;
        }
    }

    private void d() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton materialButtonA = a(i2);
            int iMin = Math.min(materialButtonA.getStrokeWidth(), a(i2 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsA = a(materialButtonA);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(layoutParamsA, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParamsA, -iMin);
                layoutParamsA.topMargin = 0;
            } else {
                layoutParamsA.bottomMargin = 0;
                layoutParamsA.topMargin = -iMin;
                MarginLayoutParamsCompat.setMarginStart(layoutParamsA, 0);
            }
            materialButtonA.setLayoutParams(layoutParamsA);
        }
        c(firstVisibleChildIndex);
    }

    private void e() {
        TreeMap treeMap = new TreeMap(this.f15111w);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(a(i2), Integer.valueOf(i2));
        }
        this.f15112x = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (b(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (b(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && b(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.B = i2;
        b(i2, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.f15108t);
        materialButton.setOnPressedChangeListenerInternal(this.f15109u);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i2, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                d(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            l shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.f15107s.add(new d(shapeAppearanceModel.j(), shapeAppearanceModel.c(), shapeAppearanceModel.l(), shapeAppearanceModel.e()));
            ViewCompat.setAccessibilityDelegate(materialButton, new b());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        e();
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.f15114z) {
            return this.B;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton materialButtonA = a(i2);
            if (materialButtonA.isChecked()) {
                arrayList.add(Integer.valueOf(materialButtonA.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f15112x;
        return (numArr == null || i3 >= numArr.length) ? i3 : numArr[i3].intValue();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.B;
        if (i2 != -1) {
            a(i2, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, b() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        c();
        d();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.b(this.f15108t);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f15107s.remove(iIndexOfChild);
        }
        c();
        d();
    }

    public void setSelectionRequired(boolean z2) {
        this.A = z2;
    }

    public void setSingleSelection(boolean z2) {
        if (this.f15114z != z2) {
            this.f15114z = z2;
            a();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, D), attributeSet, i2);
        this.f15107s = new ArrayList();
        a aVar = null;
        this.f15108t = new c(this, aVar);
        this.f15109u = new f(this, aVar);
        this.f15110v = new LinkedHashSet<>();
        this.f15111w = new a();
        this.f15113y = false;
        TypedArray typedArrayC = com.google.android.material.internal.l.c(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i2, D, new int[0]);
        setSingleSelection(typedArrayC.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.B = typedArrayC.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.A = typedArrayC.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayC.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public boolean b() {
        return this.f15114z;
    }

    private boolean b(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void a() {
        this.f15113y = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton materialButtonA = a(i2);
            materialButtonA.setChecked(false);
            b(materialButtonA.getId(), false);
        }
        this.f15113y = false;
        setCheckedId(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == view) {
                return i2;
            }
            if ((getChildAt(i3) instanceof MaterialButton) && b(i3)) {
                i2++;
            }
        }
        return -1;
    }

    private void c(int i2) {
        if (getChildCount() == 0 || i2 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a(i2).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@IdRes int i2, boolean z2) {
        Iterator<e> it = this.f15110v.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z2);
        }
    }

    public void a(@NonNull e eVar) {
        this.f15110v.add(eVar);
    }

    private MaterialButton a(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    @Nullable
    private d a(int i2, int i3, int i4) {
        d dVar = this.f15107s.get(i2);
        if (i3 == i4) {
            return dVar;
        }
        boolean z2 = getOrientation() == 0;
        if (i2 == i3) {
            return z2 ? d.b(dVar, this) : d.d(dVar);
        }
        if (i2 == i4) {
            return z2 ? d.a(dVar, this) : d.a(dVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i2, boolean z2) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.A && checkedButtonIds.isEmpty()) {
            c(i2, true);
            this.B = i2;
            return false;
        }
        if (z2 && this.f15114z) {
            checkedButtonIds.remove(Integer.valueOf(i2));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                c(iIntValue, false);
                b(iIntValue, false);
            }
        }
        return true;
    }

    @VisibleForTesting
    void c() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton materialButtonA = a(i2);
            if (materialButtonA.getVisibility() != 8) {
                l.b bVarM = materialButtonA.getShapeAppearanceModel().m();
                a(bVarM, a(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonA.setShapeAppearanceModel(bVarM.a());
            }
        }
    }

    private static void a(l.b bVar, @Nullable d dVar) {
        if (dVar == null) {
            bVar.a(0.0f);
            return;
        }
        bVar.d(dVar.a);
        bVar.b(dVar.f15118d);
        bVar.e(dVar.b);
        bVar.c(dVar.f15117c);
    }

    private void a(int i2, boolean z2) {
        MaterialButton materialButton = (MaterialButton) findViewById(i2);
        if (materialButton != null) {
            materialButton.setChecked(z2);
        }
    }

    @NonNull
    private LinearLayout.LayoutParams a(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }
}
