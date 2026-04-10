package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.amgcyo.cuttadon.R$styleable;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class TSnackbar$SnackbarLayout extends LinearLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f5079s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Button f5080t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5081u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5082v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private b f5083w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private a f5084x;

    interface a {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    interface b {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    public TSnackbar$SnackbarLayout(Context context) {
        this(context, null);
    }

    private boolean a(int i2, int i3, int i4) {
        boolean z2;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f5079s.getPaddingTop() == i3 && this.f5079s.getPaddingBottom() == i4) {
            return z2;
        }
        a(this.f5079s, i3, i4);
        return true;
    }

    Button getActionView() {
        return this.f5080t;
    }

    TextView getMessageView() {
        return this.f5079s;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f5084x;
        if (aVar != null) {
            aVar.onViewAttachedToWindow(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f5084x;
        if (aVar != null) {
            aVar.onViewDetachedFromWindow(this);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5079s = (TextView) findViewById(R.id.snackbar_text);
        this.f5080t = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        b bVar;
        super.onLayout(z2, i2, i3, i4, i5);
        if (!z2 || (bVar = this.f5083w) == null) {
            return;
        }
        bVar.a(this, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f5081u
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f5081u
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            r1 = 2131165354(0x7f0700aa, float:1.7944923E38)
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            r2 = 2131165353(0x7f0700a9, float:1.794492E38)
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f5079s
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3e
            r2 = 1
            goto L3f
        L3e:
            r2 = 0
        L3f:
            if (r2 == 0) goto L58
            int r5 = r7.f5082v
            if (r5 <= 0) goto L58
            android.widget.Button r5 = r7.f5080t
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f5082v
            if (r5 <= r6) goto L58
            int r1 = r0 - r1
            boolean r0 = r7.a(r4, r0, r1)
            if (r0 == 0) goto L63
            goto L64
        L58:
            if (r2 == 0) goto L5b
            goto L5c
        L5b:
            r0 = r1
        L5c:
            boolean r0 = r7.a(r3, r0, r0)
            if (r0 == 0) goto L63
            goto L64
        L63:
            r4 = 0
        L64:
            if (r4 == 0) goto L69
            super.onMeasure(r8, r9)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.otherview.TSnackbar$SnackbarLayout.onMeasure(int, int):void");
    }

    void setOnAttachStateChangeListener(a aVar) {
        this.f5084x = aVar;
    }

    void setOnLayoutChangeListener(b bVar) {
        this.f5083w = bVar;
    }

    public TSnackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        this.f5081u = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f5082v = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        setClickable(true);
        LayoutInflater.from(context).inflate(R.layout.mk_view_tsnackbar_content, this);
        ViewCompat.setAccessibilityLiveRegion(this, 1);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private static void a(View view, int i2, int i3) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i2, ViewCompat.getPaddingEnd(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }
}
