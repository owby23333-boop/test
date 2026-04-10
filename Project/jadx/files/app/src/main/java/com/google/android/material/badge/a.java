package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: compiled from: BadgeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalBadgeUtils
public class a {
    public static final boolean a;

    static {
        a = Build.VERSION.SDK_INT < 18;
    }

    public static void a(@NonNull Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }

    public static void b(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.a(view, frameLayout);
    }

    public static void a(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        b(badgeDrawable, view, frameLayout);
        if (badgeDrawable.c() != null) {
            badgeDrawable.c().setForeground(badgeDrawable);
        } else {
            if (a) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void a(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (!a && badgeDrawable.c() == null) {
            view.getOverlay().remove(badgeDrawable);
        } else {
            badgeDrawable.c().setForeground(null);
        }
    }

    @NonNull
    public static ParcelableSparseArray a(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            BadgeDrawable badgeDrawableValueAt = sparseArray.valueAt(i2);
            if (badgeDrawableValueAt != null) {
                parcelableSparseArray.put(iKeyAt, badgeDrawableValueAt.g());
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    @NonNull
    public static SparseArray<BadgeDrawable> a(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i2 = 0; i2 < parcelableSparseArray.size(); i2++) {
            int iKeyAt = parcelableSparseArray.keyAt(i2);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i2);
            if (savedState != null) {
                sparseArray.put(iKeyAt, BadgeDrawable.a(context, savedState));
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }
}
