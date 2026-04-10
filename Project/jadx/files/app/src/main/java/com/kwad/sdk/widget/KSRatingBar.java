package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class KSRatingBar extends LinearLayout {
    private boolean aBQ;
    private boolean aBR;
    private int aBS;
    private int aBT;
    private a aBU;
    private float aBV;
    private float aBW;
    private float aBX;
    private Drawable aBY;
    private Drawable aBZ;
    private Drawable aCa;
    private boolean aCb;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f16967y;

    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16967y = 1;
        this.aCb = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.aCa = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aBY = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aBZ = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aBV = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aBW = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aBX = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aBS = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aBT = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aBQ = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aBR = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i2 = 0; i2 < this.aBS; i2++) {
            ImageView imageViewW = w(context, this.aCb);
            imageViewW.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.aBQ) {
                        if (!KSRatingBar.this.aBR) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.aBU != null) {
                                a unused = KSRatingBar.this.aBU;
                                KSRatingBar.this.indexOfChild(view);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.f16967y % 2 == 0) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        } else {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                        }
                        if (KSRatingBar.this.aBU != null) {
                            int i3 = KSRatingBar.this.f16967y % 2;
                            a unused2 = KSRatingBar.this.aBU;
                            KSRatingBar.this.indexOfChild(view);
                            KSRatingBar.e(KSRatingBar.this);
                        }
                    }
                }
            });
            addView(imageViewW);
        }
        setStar(this.aBT);
    }

    static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i2 = kSRatingBar.f16967y;
        kSRatingBar.f16967y = i2 + 1;
        return i2;
    }

    private ImageView w(Context context, boolean z2) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aBV), Math.round(this.aBW)));
        imageView.setPadding(0, 0, Math.round(this.aBX), 0);
        imageView.setImageDrawable(z2 ? this.aBY : this.aBZ);
        return imageView;
    }

    public void setImagePadding(float f2) {
        this.aBX = f2;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aBU = aVar;
    }

    public void setStar(float f2) {
        int i2 = (int) f2;
        float fFloatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i2))).floatValue();
        int i3 = this.aBS;
        float f3 = i2 > i3 ? i3 : i2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i4 = 0; i4 < f3; i4++) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.aBZ);
        }
        if (fFloatValue > 0.0f) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.aCa);
            int i5 = this.aBS;
            while (true) {
                i5--;
                if (i5 < 1.0f + f3) {
                    return;
                } else {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.aBY);
                }
            }
        } else {
            int i6 = this.aBS;
            while (true) {
                i6--;
                if (i6 < f3) {
                    return;
                } else {
                    ((ImageView) getChildAt(i6)).setImageDrawable(this.aBY);
                }
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aBY = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aBZ = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aCa = drawable;
    }

    public void setStarImageHeight(float f2) {
        this.aBW = f2;
    }

    public void setStarImageWidth(float f2) {
        this.aBV = f2;
    }

    public void setTotalStarCount(int i2) {
        this.aBS = i2;
    }

    public void setmClickable(boolean z2) {
        this.aBQ = z2;
    }
}
