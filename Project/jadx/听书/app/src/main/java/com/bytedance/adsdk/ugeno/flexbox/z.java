package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
interface z {
    int g(int i, int i2, int i3);

    View g(int i);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<dl> getFlexLinesInternal();

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

    void setFlexLines(List<dl> list);

    int z(int i, int i2, int i3);

    int z(View view);

    int z(View view, int i, int i2);

    View z(int i);

    void z(View view, int i, int i2, dl dlVar);

    void z(dl dlVar);

    boolean z();
}
