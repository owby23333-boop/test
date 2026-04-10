package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final ListPopupWindow f15899s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final AccessibilityManager f15900t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    private final Rect f15901u;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            MaterialAutoCompleteTextView.this.a(i2 < 0 ? MaterialAutoCompleteTextView.this.f15899s.getSelectedItem() : MaterialAutoCompleteTextView.this.getAdapter().getItem(i2));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i2 < 0) {
                    view = MaterialAutoCompleteTextView.this.f15899s.getSelectedView();
                    i2 = MaterialAutoCompleteTextView.this.f15899s.getSelectedItemPosition();
                    j2 = MaterialAutoCompleteTextView.this.f15899s.getSelectedItemId();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f15899s.getListView(), view, i2, j2);
            }
            MaterialAutoCompleteTextView.this.f15899s.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    private int b() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutA = a();
        int i2 = 0;
        if (adapter == null || textInputLayoutA == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f15899s.getSelectedItemPosition()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutA);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable background = this.f15899s.getBackground();
        if (background != null) {
            background.getPadding(this.f15901u);
            Rect rect = this.f15901u;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutA.getEndIconView().getMeasuredWidth();
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayoutA = a();
        return (textInputLayoutA == null || !textInputLayoutA.d()) ? super.getHint() : textInputLayoutA.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutA = a();
        if (textInputLayoutA != null && textInputLayoutA.d() && super.getHint() == null && com.google.android.material.internal.d.c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), b()), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t2) {
        super.setAdapter(t2);
        this.f15899s.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f15900t;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f15899s.show();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, 0), attributeSet, i2);
        this.f15901u = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i2, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayC.hasValue(R$styleable.MaterialAutoCompleteTextView_android_inputType) && typedArrayC.getInt(R$styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f15900t = (AccessibilityManager) context2.getSystemService("accessibility");
        this.f15899s = new ListPopupWindow(context2);
        this.f15899s.setModal(true);
        this.f15899s.setAnchorView(this);
        this.f15899s.setInputMethodMode(2);
        this.f15899s.setAdapter(getAdapter());
        this.f15899s.setOnItemClickListener(new a());
        typedArrayC.recycle();
    }

    @Nullable
    private TextInputLayout a() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }
}
