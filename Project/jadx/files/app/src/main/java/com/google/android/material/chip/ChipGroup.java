package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int F = R$style.Widget_MaterialComponents_ChipGroup;

    @Nullable
    private c A;
    private final b B;

    @NonNull
    private d C;

    @IdRes
    private int D;
    private boolean E;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Dimension
    private int f15176w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Dimension
    private int f15177x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f15178y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f15179z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }
    }

    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z2) {
            if (ChipGroup.this.E) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.f15179z) {
                ChipGroup.this.b(compoundButton.getId(), true);
                ChipGroup.this.a(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z2) {
                if (ChipGroup.this.D == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (ChipGroup.this.D != -1 && ChipGroup.this.D != id && ChipGroup.this.f15178y) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.b(chipGroup.D, false);
                }
                ChipGroup.this.setCheckedId(id);
            }
        }
    }

    public interface c {
        void a(ChipGroup chipGroup, @IdRes int i2);
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f15180s;

        private d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).a(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.B);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f15180s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f15180s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i2) {
        a(i2, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.D;
                if (i3 != -1 && this.f15178y) {
                    b(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @IdRes
    public int getCheckedChipId() {
        if (this.f15178y) {
            return this.D;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f15178y) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.f15176w;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.f15177x;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.D;
        if (i2 != -1) {
            b(i2, true);
            setCheckedId(this.D);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), a() ? getChipCount() : -1, false, c() ? 1 : 2));
    }

    public void setChipSpacing(@Dimension int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(@Dimension int i2) {
        if (this.f15176w != i2) {
            this.f15176w = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(@DimenRes int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(@Dimension int i2) {
        if (this.f15177x != i2) {
            this.f15177x = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(c cVar) {
        this.A = cVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.C.f15180s = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z2) {
        this.f15179z = z2;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z2) {
        super.setSingleLine(z2);
    }

    public void setSingleSelection(boolean z2) {
        if (this.f15178y != z2) {
            this.f15178y = z2;
            b();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipGroupStyle);
    }

    public boolean c() {
        return this.f15178y;
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(@BoolRes int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, F), attributeSet, i2);
        this.B = new b();
        this.C = new d();
        this.D = -1;
        this.E = false;
        TypedArray typedArrayC = l.c(getContext(), attributeSet, R$styleable.ChipGroup, i2, F, new int[0]);
        int dimensionPixelOffset = typedArrayC.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayC.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayC.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayC.getBoolean(R$styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayC.getBoolean(R$styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayC.getBoolean(R$styleable.ChipGroup_selectionRequired, false));
        int resourceId = typedArrayC.getResourceId(R$styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.D = resourceId;
        }
        typedArrayC.recycle();
        super.setOnHierarchyChangeListener(this.C);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void b() {
        this.E = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.E = false;
        setCheckedId(-1);
    }

    public void a(@IdRes int i2) {
        int i3 = this.D;
        if (i2 == i3) {
            return;
        }
        if (i3 != -1 && this.f15178y) {
            b(i3, false);
        }
        if (i2 != -1) {
            b(i2, true);
        }
        setCheckedId(i2);
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        this.D = i2;
        c cVar = this.A;
        if (cVar != null && this.f15178y && z2) {
            cVar.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@IdRes int i2, boolean z2) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById instanceof Chip) {
            this.E = true;
            ((Chip) viewFindViewById).setChecked(z2);
            this.E = false;
        }
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean a() {
        return super.a();
    }

    int b(@Nullable View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                if (((Chip) getChildAt(i3)) == view) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }
}
