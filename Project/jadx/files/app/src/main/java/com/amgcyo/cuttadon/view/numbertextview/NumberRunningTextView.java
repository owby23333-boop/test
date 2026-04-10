package com.amgcyo.cuttadon.view.numbertextview;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.utils.otherutils.g;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class NumberRunningTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4894t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4895u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4896v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4897w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4898x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private DecimalFormat f4899y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f4900z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            String str = NumberRunningTextView.this.f4899y.format(Double.parseDouble(((BigDecimal) valueAnimator.getAnimatedValue()).toString()));
            if (!NumberRunningTextView.this.f4894t) {
                NumberRunningTextView.this.setText(str);
            } else {
                NumberRunningTextView.this.setText(g.a(str));
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NumberRunningTextView.this.setText(String.valueOf(((Integer) valueAnimator.getAnimatedValue()).intValue()));
        }
    }

    public NumberRunningTextView(Context context) {
        this(context, null);
    }

    private void c(String str) {
        int i2 = this.f4893s;
        if (i2 == 0) {
            a(str);
        } else if (i2 == 1) {
            b(str);
        }
    }

    public void setContent(String str) {
        if (this.f4895u) {
            if (TextUtils.isEmpty(this.f4900z)) {
                this.f4900z = str;
                c(str);
                return;
            } else if (this.f4900z.equals(str)) {
                return;
            } else {
                this.f4900z = str;
            }
        }
        c(str);
    }

    public NumberRunningTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public void a(String str) {
        try {
            BigDecimal bigDecimal = new BigDecimal(str.replace(",", "").replace("-", ""));
            if (bigDecimal.floatValue() < this.f4898x) {
                setText(str);
                return;
            }
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new com.amgcyo.cuttadon.view.numbertextview.a(), new BigDecimal(0), bigDecimal);
            valueAnimatorOfObject.setDuration(this.f4896v);
            valueAnimatorOfObject.addUpdateListener(new a());
            valueAnimatorOfObject.start();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            setText(str);
        }
    }

    public void b(String str) {
        try {
            int i2 = Integer.parseInt(str.replace(",", "").replace("-", ""));
            if (i2 < this.f4897w) {
                setText(str);
                return;
            }
            new ValueAnimator();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, i2);
            valueAnimatorOfInt.setDuration(this.f4896v);
            valueAnimatorOfInt.addUpdateListener(new b());
            valueAnimatorOfInt.start();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            setText(str);
        }
    }

    public NumberRunningTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4899y = new DecimalFormat("0.00");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NumberRunningTextView);
        this.f4896v = typedArrayObtainStyledAttributes.getInt(2, 1000);
        this.f4893s = typedArrayObtainStyledAttributes.getInt(4, 0);
        this.f4894t = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f4895u = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.f4897w = typedArrayObtainStyledAttributes.getInt(1, 3);
        this.f4898x = typedArrayObtainStyledAttributes.getFloat(0, 0.1f);
        typedArrayObtainStyledAttributes.recycle();
    }
}
