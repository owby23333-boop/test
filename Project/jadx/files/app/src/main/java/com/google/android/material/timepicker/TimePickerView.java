package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Chip f16052s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Chip f16053t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MaterialButtonToggleGroup f16054u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final View.OnClickListener f16055v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private f f16056w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private g f16057x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private e f16058y;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.f16057x != null) {
                TimePickerView.this.f16057x.a(((Integer) view.getTag(R$id.selection_type)).intValue());
            }
        }
    }

    class b implements MaterialButtonToggleGroup.e {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z2) {
            int i3 = i2 == R$id.material_clock_period_pm_button ? 1 : 0;
            if (TimePickerView.this.f16056w == null || !z2) {
                return;
            }
            TimePickerView.this.f16056w.a(i3);
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
            if (TimePickerView.this.f16058y != null) {
                TimePickerView.this.f16058y.a();
            }
            return zOnDoubleTap;
        }
    }

    class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ GestureDetector f16061s;

        d(TimePickerView timePickerView, GestureDetector gestureDetector) {
            this.f16061s = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f16061s.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface e {
        void a();
    }

    interface f {
        void a(int i2);
    }

    interface g {
        void a(int i2);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            c();
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f16052s.setTag(R$id.selection_type, 12);
        this.f16053t.setTag(R$id.selection_type, 10);
        this.f16052s.setOnClickListener(this.f16055v);
        this.f16053t.setOnClickListener(this.f16055v);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b() {
        d dVar = new d(this, new GestureDetector(getContext(), new c()));
        this.f16052s.setOnTouchListener(dVar);
        this.f16053t.setOnTouchListener(dVar);
    }

    private void c() {
        if (this.f16054u.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(R$id.material_clock_display, ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
            constraintSet.applyTo(this);
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16055v = new a();
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.f16054u = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f16054u.a(new b());
        this.f16052s = (Chip) findViewById(R$id.material_minute_tv);
        this.f16053t = (Chip) findViewById(R$id.material_hour_tv);
        b();
        a();
    }
}
