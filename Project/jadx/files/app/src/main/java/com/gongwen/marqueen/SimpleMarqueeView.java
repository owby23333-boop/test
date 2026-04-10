package com.gongwen.marqueen;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleMarqueeView<E> extends MarqueeView<TextView, E> {
    private int A;
    private boolean B;
    private TextUtils.TruncateAt C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ColorStateList f14902y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f14903z;

    public SimpleMarqueeView(Context context) {
        this(context, null);
    }

    private void a(AttributeSet attributeSet) {
        int i2 = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SimpleMarqueeView, 0, 0);
            this.f14902y = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.SimpleMarqueeView_smvTextColor);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SimpleMarqueeView_smvTextSize)) {
                this.f14903z = typedArrayObtainStyledAttributes.getDimension(R$styleable.SimpleMarqueeView_smvTextSize, this.f14903z);
                this.f14903z = com.gongwen.marqueen.d.c.a(getContext(), this.f14903z);
            }
            this.A = typedArrayObtainStyledAttributes.getInt(R$styleable.SimpleMarqueeView_smvTextGravity, this.A);
            this.B = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SimpleMarqueeView_smvTextSingleLine, this.B);
            i2 = typedArrayObtainStyledAttributes.getInt(R$styleable.SimpleMarqueeView_smvTextEllipsize, -1);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.B && i2 < 0) {
            i2 = 3;
        }
        if (i2 == 1) {
            this.C = TextUtils.TruncateAt.START;
        } else if (i2 == 2) {
            this.C = TextUtils.TruncateAt.MIDDLE;
        } else {
            if (i2 != 3) {
                return;
            }
            this.C = TextUtils.TruncateAt.END;
        }
    }

    public void setTextColor(@ColorInt int i2) {
        setTextColor(ColorStateList.valueOf(i2));
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("The type MARQUEE is not supported!");
        }
        this.C = truncateAt;
        a<T, E> aVar = this.f14895s;
        if (aVar != 0) {
            Iterator<E> it = aVar.b().iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setEllipsize(truncateAt);
            }
        }
    }

    public void setTextGravity(int i2) {
        this.A = i2;
        a<T, E> aVar = this.f14895s;
        if (aVar != 0) {
            Iterator<E> it = aVar.b().iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setGravity(this.A);
            }
        }
    }

    public void setTextSingleLine(boolean z2) {
        this.B = z2;
        a<T, E> aVar = this.f14895s;
        if (aVar != 0) {
            Iterator<E> it = aVar.b().iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setSingleLine(this.B);
            }
        }
    }

    public void setTextSize(float f2) {
        this.f14903z = f2;
        a<T, E> aVar = this.f14895s;
        if (aVar != 0) {
            Iterator<E> it = aVar.b().iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setTextSize(f2);
            }
        }
    }

    public SimpleMarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14902y = null;
        this.f14903z = 15.0f;
        this.A = 0;
        this.B = false;
        a(attributeSet);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f14902y = colorStateList;
        a<T, E> aVar = this.f14895s;
        if (aVar != 0) {
            Iterator<E> it = aVar.b().iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setTextColor(this.f14902y);
            }
        }
    }

    @Override // com.gongwen.marqueen.MarqueeView
    protected void a() {
        super.a();
        for (TextView textView : this.f14895s.b()) {
            textView.setTextSize(this.f14903z);
            textView.setGravity(this.A);
            ColorStateList colorStateList = this.f14902y;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            textView.setSingleLine(this.B);
            textView.setEllipsize(this.C);
        }
    }
}
