package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[] f15446v = {R.attr.state_checked};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f15447s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f15448t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15449u;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f15450s;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel) {
            this.f15450s = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f15450s ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel);
        }
    }

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(CheckableImageButton.this.a());
            accessibilityNodeInfoCompat.setChecked(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f15448t;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f15447s;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        return this.f15447s ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + f15446v.length), f15446v) : super.onCreateDrawableState(i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f15450s);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15450s = this.f15447s;
        return savedState;
    }

    public void setCheckable(boolean z2) {
        if (this.f15448t != z2) {
            this.f15448t = z2;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (!this.f15448t || this.f15447s == z2) {
            return;
        }
        this.f15447s = z2;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z2) {
        this.f15449u = z2;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        if (this.f15449u) {
            super.setPressed(z2);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f15447s);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15448t = true;
        this.f15449u = true;
        ViewCompat.setAccessibilityDelegate(this, new a());
    }
}
