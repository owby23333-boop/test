package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.i.c;
import com.google.android.material.i.d;
import com.google.android.material.internal.i;
import com.google.android.material.internal.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements i.b {

    @StyleRes
    private static final int I = R$style.Widget_MaterialComponents_Badge;

    @AttrRes
    private static final int J = R$attr.badgeStyle;
    private float A;
    private float B;
    private int C;
    private float D;
    private float E;
    private float F;

    @Nullable
    private WeakReference<View> G;

    @Nullable
    private WeakReference<FrameLayout> H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final WeakReference<Context> f14981s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f14982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    private final i f14983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    private final Rect f14984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final float f14985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f14986x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f14987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    private final SavedState f14988z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int A;
        private boolean B;

        @Dimension(unit = 1)
        private int C;

        @Dimension(unit = 1)
        private int D;

        @Dimension(unit = 1)
        private int E;

        @Dimension(unit = 1)
        private int F;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @ColorInt
        private int f14989s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @ColorInt
        private int f14990t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f14991u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f14992v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f14993w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @Nullable
        private CharSequence f14994x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @PluralsRes
        private int f14995y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        @StringRes
        private int f14996z;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(@NonNull Context context) {
            this.f14991u = 255;
            this.f14992v = -1;
            this.f14990t = new d(context, R$style.TextAppearance_MaterialComponents_Badge).a.getDefaultColor();
            this.f14994x = context.getString(R$string.mtrl_badge_numberless_content_description);
            this.f14995y = R$plurals.mtrl_badge_content_description;
            this.f14996z = R$string.mtrl_exceed_max_badge_number_content_description;
            this.B = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.f14989s);
            parcel.writeInt(this.f14990t);
            parcel.writeInt(this.f14991u);
            parcel.writeInt(this.f14992v);
            parcel.writeInt(this.f14993w);
            parcel.writeString(this.f14994x.toString());
            parcel.writeInt(this.f14995y);
            parcel.writeInt(this.A);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
            parcel.writeInt(this.E);
            parcel.writeInt(this.F);
            parcel.writeInt(this.B ? 1 : 0);
        }

        protected SavedState(@NonNull Parcel parcel) {
            this.f14991u = 255;
            this.f14992v = -1;
            this.f14989s = parcel.readInt();
            this.f14990t = parcel.readInt();
            this.f14991u = parcel.readInt();
            this.f14992v = parcel.readInt();
            this.f14993w = parcel.readInt();
            this.f14994x = parcel.readString();
            this.f14995y = parcel.readInt();
            this.A = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readInt();
            this.E = parcel.readInt();
            this.F = parcel.readInt();
            this.B = parcel.readInt() != 0;
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ View f14997s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ FrameLayout f14998t;

        a(View view, FrameLayout frameLayout) {
            this.f14997s = view;
            this.f14998t = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            BadgeDrawable.this.a(this.f14997s, this.f14998t);
        }
    }

    private BadgeDrawable(@NonNull Context context) {
        this.f14981s = new WeakReference<>(context);
        l.b(context);
        Resources resources = context.getResources();
        this.f14984v = new Rect();
        this.f14982t = new MaterialShapeDrawable();
        this.f14985w = resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.f14987y = resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.f14986x = resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        this.f14983u = new i(this);
        this.f14983u.b().setTextAlign(Paint.Align.CENTER);
        this.f14988z = new SavedState(context);
        j(R$style.TextAppearance_MaterialComponents_Badge);
    }

    @NonNull
    static BadgeDrawable a(@NonNull Context context, @NonNull SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.a(savedState);
        return badgeDrawable;
    }

    private void b(Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray typedArrayC = l.c(context, attributeSet, R$styleable.Badge, i2, i3, new int[0]);
        g(typedArrayC.getInt(R$styleable.Badge_maxCharacterCount, 4));
        if (typedArrayC.hasValue(R$styleable.Badge_number)) {
            h(typedArrayC.getInt(R$styleable.Badge_number, 0));
        }
        c(a(context, typedArrayC, R$styleable.Badge_backgroundColor));
        if (typedArrayC.hasValue(R$styleable.Badge_badgeTextColor)) {
            e(a(context, typedArrayC, R$styleable.Badge_badgeTextColor));
        }
        d(typedArrayC.getInt(R$styleable.Badge_badgeGravity, 8388661));
        f(typedArrayC.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0));
        i(typedArrayC.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0));
        typedArrayC.recycle();
    }

    private void j(@StyleRes int i2) {
        Context context = this.f14981s.get();
        if (context == null) {
            return;
        }
        a(new d(context, i2));
    }

    private void k() {
        Double.isNaN(e());
        this.C = ((int) Math.pow(10.0d, r0 - 1.0d)) - 1;
    }

    @Nullable
    public FrameLayout c() {
        WeakReference<FrameLayout> weakReference = this.H;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void d(int i2) {
        if (this.f14988z.A != i2) {
            this.f14988z.A = i2;
            WeakReference<View> weakReference = this.G;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.G.get();
            WeakReference<FrameLayout> weakReference2 = this.H;
            a(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f14982t.draw(canvas);
        if (h()) {
            a(canvas);
        }
    }

    public void e(@ColorInt int i2) {
        this.f14988z.f14990t = i2;
        if (this.f14983u.b().getColor() != i2) {
            this.f14983u.b().setColor(i2);
            invalidateSelf();
        }
    }

    public int f() {
        if (h()) {
            return this.f14988z.f14992v;
        }
        return 0;
    }

    @NonNull
    public SavedState g() {
        return this.f14988z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f14988z.f14991u;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14984v.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14984v.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h() {
        return this.f14988z.f14992v != -1;
    }

    public void i(int i2) {
        this.f14988z.D = i2;
        j();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.i.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f14988z.f14991u = i2;
        this.f14983u.b().setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void c(@ColorInt int i2) {
        this.f14988z.f14989s = i2;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
        if (this.f14982t.f() != colorStateListValueOf) {
            this.f14982t.a(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public void g(int i2) {
        if (this.f14988z.f14993w != i2) {
            this.f14988z.f14993w = i2;
            k();
            this.f14983u.a(true);
            j();
            invalidateSelf();
        }
    }

    public void h(int i2) {
        int iMax = Math.max(0, i2);
        if (this.f14988z.f14992v != iMax) {
            this.f14988z.f14992v = iMax;
            this.f14983u.a(true);
            j();
            invalidateSelf();
        }
    }

    @NonNull
    public static BadgeDrawable a(@NonNull Context context) {
        return a(context, null, J, I);
    }

    @NonNull
    private String i() {
        if (f() <= this.C) {
            return NumberFormat.getInstance().format(f());
        }
        Context context = this.f14981s.get();
        return context == null ? "" : context.getString(R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.C), "+");
    }

    private void j() {
        Context context = this.f14981s.get();
        WeakReference<View> weakReference = this.G;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f14984v);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.H;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || com.google.android.material.badge.a.a) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        a(context, rect2, view);
        com.google.android.material.badge.a.a(this.f14984v, this.A, this.B, this.E, this.F);
        this.f14982t.a(this.D);
        if (rect.equals(this.f14984v)) {
            return;
        }
        this.f14982t.setBounds(this.f14984v);
    }

    public void f(int i2) {
        this.f14988z.C = i2;
        j();
    }

    @NonNull
    private static BadgeDrawable a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.b(context, attributeSet, i2, i3);
        return badgeDrawable;
    }

    public int e() {
        return this.f14988z.f14993w;
    }

    public void a(boolean z2) {
        setVisible(z2, false);
        this.f14988z.B = z2;
        if (!com.google.android.material.badge.a.a || c() == null || z2) {
            return;
        }
        ((ViewGroup) c().getParent()).invalidate();
    }

    public int d() {
        return this.f14988z.C;
    }

    private void a(@NonNull SavedState savedState) {
        g(savedState.f14993w);
        if (savedState.f14992v != -1) {
            h(savedState.f14992v);
        }
        c(savedState.f14989s);
        e(savedState.f14990t);
        d(savedState.A);
        f(savedState.C);
        i(savedState.D);
        a(savedState.E);
        b(savedState.F);
        a(savedState.B);
    }

    private static void b(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    @Nullable
    public CharSequence b() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (h()) {
            if (this.f14988z.f14995y <= 0 || (context = this.f14981s.get()) == null) {
                return null;
            }
            if (f() <= this.C) {
                return context.getResources().getQuantityString(this.f14988z.f14995y, f(), Integer.valueOf(f()));
            }
            return context.getString(this.f14988z.f14996z, Integer.valueOf(this.C));
        }
        return this.f14988z.f14994x;
    }

    private static int a(Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        return c.a(context, typedArray, i2).getDefaultColor();
    }

    public void a(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.G = new WeakReference<>(view);
        if (com.google.android.material.badge.a.a && frameLayout == null) {
            a(view);
        } else {
            this.H = new WeakReference<>(frameLayout);
        }
        if (!com.google.android.material.badge.a.a) {
            b(view);
        }
        j();
        invalidateSelf();
    }

    private void a(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.H;
            if (weakReference == null || weakReference.get() != viewGroup) {
                b(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R$id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.H = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }

    void b(int i2) {
        this.f14988z.F = i2;
        j();
    }

    @Override // com.google.android.material.internal.i.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    void a(int i2) {
        this.f14988z.E = i2;
        j();
    }

    private void a(@Nullable d dVar) {
        Context context;
        if (this.f14983u.a() == dVar || (context = this.f14981s.get()) == null) {
            return;
        }
        this.f14983u.a(dVar, context);
        j();
    }

    private void a(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i2 = this.f14988z.D + this.f14988z.F;
        int i3 = this.f14988z.A;
        if (i3 != 8388691 && i3 != 8388693) {
            this.B = rect.top + i2;
        } else {
            this.B = rect.bottom - i2;
        }
        if (f() <= 9) {
            this.D = !h() ? this.f14985w : this.f14986x;
            float f2 = this.D;
            this.F = f2;
            this.E = f2;
        } else {
            this.D = this.f14986x;
            this.F = this.D;
            this.E = (this.f14983u.a(i()) / 2.0f) + this.f14987y;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(h() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
        int i4 = this.f14988z.C + this.f14988z.E;
        int i5 = this.f14988z.A;
        if (i5 != 8388659 && i5 != 8388691) {
            this.A = ViewCompat.getLayoutDirection(view) == 0 ? ((rect.right + this.E) - dimensionPixelSize) - i4 : (rect.left - this.E) + dimensionPixelSize + i4;
        } else {
            this.A = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.E) + dimensionPixelSize + i4 : ((rect.right + this.E) - dimensionPixelSize) - i4;
        }
    }

    private void a(Canvas canvas) {
        Rect rect = new Rect();
        String strI = i();
        this.f14983u.b().getTextBounds(strI, 0, strI.length(), rect);
        canvas.drawText(strI, this.A, this.B + (rect.height() / 2), this.f14983u.b());
    }
}
