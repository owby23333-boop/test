package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.internal.s;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Calendar f15264s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f15265t;

    class a extends AccessibilityDelegateCompat {
        a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    private void a(int i2, Rect rect) {
        if (i2 == 33) {
            setSelection(getAdapter().b());
        } else if (i2 == 130) {
            setSelection(getAdapter().a());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas canvas) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int width;
        int i2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        h adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f15325t;
        b bVar = adapter.f15327v;
        Long item = adapter.getItem(adapter.a());
        Long item2 = adapter.getItem(adapter.b());
        for (Pair<Long, Long> pair : dateSelector.j()) {
            Long l2 = pair.first;
            if (l2 != null) {
                if (pair.second != null) {
                    long jLongValue = l2.longValue();
                    long jLongValue2 = pair.second.longValue();
                    if (!a(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                        boolean zE = s.e(this);
                        if (jLongValue < item.longValue()) {
                            iA = adapter.a();
                            iA2 = adapter.b(iA) ? 0 : !zE ? materialCalendarGridView.getChildAt(iA - 1).getRight() : materialCalendarGridView.getChildAt(iA - 1).getLeft();
                        } else {
                            materialCalendarGridView.f15264s.setTimeInMillis(jLongValue);
                            iA = adapter.a(materialCalendarGridView.f15264s.get(5));
                            iA2 = a(materialCalendarGridView.getChildAt(iA));
                        }
                        if (jLongValue2 > item2.longValue()) {
                            iA3 = Math.min(adapter.b(), getChildCount() - 1);
                            iA4 = adapter.c(iA3) ? getWidth() : !zE ? materialCalendarGridView.getChildAt(iA3).getRight() : materialCalendarGridView.getChildAt(iA3).getLeft();
                        } else {
                            materialCalendarGridView.f15264s.setTimeInMillis(jLongValue2);
                            iA3 = adapter.a(materialCalendarGridView.f15264s.get(5));
                            iA4 = a(materialCalendarGridView.getChildAt(iA3));
                        }
                        int itemId = (int) adapter.getItemId(iA);
                        int itemId2 = (int) adapter.getItemId(iA3);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt.getTop() + bVar.a.b();
                            int bottom = childAt.getBottom() - bVar.a.a();
                            if (zE) {
                                int i3 = iA3 > numColumns2 ? 0 : iA4;
                                width = numColumns > iA ? getWidth() : iA2;
                                i2 = i3;
                            } else {
                                i2 = numColumns > iA ? 0 : iA2;
                                width = iA3 > numColumns2 ? getWidth() : iA4;
                            }
                            canvas.drawRect(i2, top, width, bottom, bVar.f15305h);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter = adapter;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z2, int i2, Rect rect) {
        if (z2) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!this.f15265t) {
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        if (i2 < getAdapter().a()) {
            super.setSelection(getAdapter().a());
        } else {
            super.setSelection(i2);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof h)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), h.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15264s = n.f();
        if (MaterialDatePicker.f(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.f15265t = MaterialDatePicker.g(getContext());
        ViewCompat.setAccessibilityDelegate(this, new a(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public h getAdapter() {
        return (h) super.getAdapter();
    }

    private static boolean a(@Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Long l5) {
        return l2 == null || l3 == null || l4 == null || l5 == null || l4.longValue() > l3.longValue() || l5.longValue() < l2.longValue();
    }

    private static int a(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
