package com.amgcyo.cuttadon.view.comic.recyclerviewpager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewUtils {
    public static View a(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (a(recyclerView, childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public static int b(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (a(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static View c(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (b(recyclerView, childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public static int d(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (b(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static boolean a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int width = iArr[0] + (recyclerView.getWidth() / 2);
        if (childCount > 0) {
            view.getLocationOnScreen(iArr2);
            if (iArr2[0] <= width && iArr2[0] + view.getWidth() >= width) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int height = iArr[1] + (recyclerView.getHeight() / 2);
        if (childCount <= 0) {
            return false;
        }
        view.getLocationOnScreen(iArr2);
        return iArr2[1] <= height && iArr2[1] + view.getHeight() >= height;
    }
}
