package com.amgcyo.cuttadon.utils.otherutils;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import com.amgcyo.cuttadon.widget.ui.HProgressBarWithNumber;
import java.util.LinkedList;

/* JADX INFO: compiled from: CompatUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static void a(@ColorRes int i2, ImageView... imageViewArr) {
        for (ImageView imageView : imageViewArr) {
            imageView.setColorFilter(i2);
        }
    }

    public static void b(View view, k kVar) {
        if (view == null || kVar == null || !(view instanceof ViewGroup)) {
            return;
        }
        view.setBackgroundColor(kVar.f4406j);
        LinkedList linkedList = new LinkedList();
        linkedList.add((ViewGroup) view);
        while (!linkedList.isEmpty()) {
            ViewGroup viewGroup = (ViewGroup) linkedList.removeFirst();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    linkedList.addLast((ViewGroup) childAt);
                } else if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(kVar.a);
                } else if (childAt instanceof ImageView) {
                    ((ImageView) childAt).setColorFilter(kVar.a);
                } else if (childAt instanceof SeekBar) {
                    SeekBar seekBar = (SeekBar) childAt;
                    LayerDrawable layerDrawable = (LayerDrawable) seekBar.getProgressDrawable();
                    Drawable drawable = layerDrawable.getDrawable(0);
                    if (drawable != null) {
                        drawable.setColorFilter(kVar.f4399c, PorterDuff.Mode.SRC);
                    }
                    Drawable drawable2 = layerDrawable.getDrawable(1);
                    if (drawable2 != null) {
                        drawable2.setColorFilter(kVar.a, PorterDuff.Mode.SRC);
                    }
                    Drawable thumb = seekBar.getThumb();
                    if (thumb != null) {
                        thumb.setColorFilter(kVar.f4400d, PorterDuff.Mode.SRC);
                    }
                } else if (childAt instanceof HProgressBarWithNumber) {
                    HProgressBarWithNumber hProgressBarWithNumber = (HProgressBarWithNumber) childAt;
                    hProgressBarWithNumber.setmReachedBarColor(kVar.f4407k);
                    hProgressBarWithNumber.setmUnReachedBarColor(kVar.f4407k);
                    hProgressBarWithNumber.setmTextColor(kVar.f4407k);
                }
            }
        }
    }

    public static void a(View view, k kVar) {
        if (view == null || kVar == null || !(view instanceof ViewGroup)) {
            return;
        }
        view.setBackgroundColor(kVar.f4406j);
        LinkedList linkedList = new LinkedList();
        linkedList.add((ViewGroup) view);
        while (!linkedList.isEmpty()) {
            ViewGroup viewGroup = (ViewGroup) linkedList.removeFirst();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    linkedList.addLast((ViewGroup) childAt);
                } else if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(kVar.a);
                } else if (!(childAt instanceof ImageView)) {
                    if (childAt instanceof SeekBar) {
                        SeekBar seekBar = (SeekBar) childAt;
                        LayerDrawable layerDrawable = (LayerDrawable) seekBar.getProgressDrawable();
                        Drawable drawable = layerDrawable.getDrawable(0);
                        if (drawable != null) {
                            drawable.setColorFilter(kVar.f4399c, PorterDuff.Mode.SRC);
                        }
                        Drawable drawable2 = layerDrawable.getDrawable(1);
                        if (drawable2 != null) {
                            drawable2.setColorFilter(kVar.a, PorterDuff.Mode.SRC);
                        }
                        Drawable thumb = seekBar.getThumb();
                        if (thumb != null) {
                            thumb.setColorFilter(kVar.f4400d, PorterDuff.Mode.SRC);
                        }
                    } else if (childAt instanceof HProgressBarWithNumber) {
                        HProgressBarWithNumber hProgressBarWithNumber = (HProgressBarWithNumber) childAt;
                        hProgressBarWithNumber.setmReachedBarColor(kVar.f4407k);
                        hProgressBarWithNumber.setmUnReachedBarColor(kVar.f4407k);
                        hProgressBarWithNumber.setmTextColor(kVar.f4407k);
                    }
                }
            }
        }
    }

    public static Drawable a(@NonNull Drawable drawable, int i2) {
        try {
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawableWrap, i2);
            return drawableWrap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
