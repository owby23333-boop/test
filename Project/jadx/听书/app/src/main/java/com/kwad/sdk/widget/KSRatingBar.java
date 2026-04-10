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

/* JADX INFO: loaded from: classes4.dex */
public class KSRatingBar extends LinearLayout {
    private boolean bdj;
    private boolean bdk;
    private int bdl;
    private int bdm;
    private a bdn;
    private float bdo;
    private float bdp;
    private float bdq;
    private Drawable bdr;
    private Drawable bds;
    private Drawable bdt;
    private boolean bdu;
    private int y;

    public interface a {
    }

    static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.y;
        kSRatingBar.y = i + 1;
        return i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.bdt = drawable;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.bdn = aVar;
    }

    public void setmClickable(boolean z) {
        this.bdj = z;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.bds = drawable;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.bdr = drawable;
    }

    public void setStarImageWidth(float f) {
        this.bdo = f;
    }

    public void setStarImageHeight(float f) {
        this.bdp = f;
    }

    public void setTotalStarCount(int i) {
        this.bdl = i;
    }

    public void setImagePadding(float f) {
        this.bdq = f;
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.bdu = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.bdt = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.bdr = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.bds = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.bdo = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.bdp = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.bdq = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.bdl = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.bdm = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.bdj = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.bdk = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i = 0; i < this.bdl; i++) {
            ImageView imageViewY = y(context, this.bdu);
            imageViewY.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.bdj) {
                        if (KSRatingBar.this.bdk) {
                            if (KSRatingBar.this.y % 2 == 0) {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            } else {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                            }
                            if (KSRatingBar.this.bdn != null) {
                                if (KSRatingBar.this.y % 2 == 0) {
                                    a unused = KSRatingBar.this.bdn;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                } else {
                                    a unused2 = KSRatingBar.this.bdn;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                }
                            }
                            return;
                        }
                        KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        if (KSRatingBar.this.bdn != null) {
                            a unused3 = KSRatingBar.this.bdn;
                            KSRatingBar.this.indexOfChild(view);
                        }
                    }
                }
            });
            addView(imageViewY);
        }
        setStar(this.bdm);
    }

    private ImageView y(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.bdo), Math.round(this.bdp)));
        imageView.setPadding(0, 0, Math.round(this.bdq), 0);
        if (z) {
            imageView.setImageDrawable(this.bdr);
        } else {
            imageView.setImageDrawable(this.bds);
        }
        return imageView;
    }

    public void setStar(float f) {
        int i = (int) f;
        float fFloatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.bdl;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.bds);
        }
        if (fFloatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.bdt);
            int i4 = this.bdl;
            while (true) {
                i4--;
                if (i4 < 1.0f + f2) {
                    return;
                } else {
                    ((ImageView) getChildAt(i4)).setImageDrawable(this.bdr);
                }
            }
        } else {
            int i5 = this.bdl;
            while (true) {
                i5--;
                if (i5 < f2) {
                    return;
                } else {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.bdr);
                }
            }
        }
    }
}
