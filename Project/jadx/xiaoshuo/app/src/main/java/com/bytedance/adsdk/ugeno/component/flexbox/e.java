package com.bytedance.adsdk.ugeno.component.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface e {
    int bf(int i, int i2, int i3);

    View bf(int i);

    int e(int i, int i2, int i3);

    int e(View view);

    int e(View view, int i, int i2);

    View e(int i);

    void e(int i, View view);

    void e(View view, int i, int i2, d dVar);

    void e(d dVar);

    boolean e();

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<d> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void setFlexLines(List<d> list);
}
