package com.amgcyo.cuttadon.view.otherview;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.view.otherview.ConsecutiveScrollerLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ScrollUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    static boolean a(View view) {
        return g(view) && (a(view, 1) || a(view, -1));
    }

    static int b(View view) {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(view, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return view.getHeight();
        }
    }

    static int c(View view) {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(view, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return view.getScrollY();
        }
    }

    static int d(View view) {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(view, new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return view.getHeight();
        }
    }

    static int e(View view) {
        if (g(view) && a(view, 1)) {
            return (d(view) - c(view)) - b(view);
        }
        return 0;
    }

    static int f(View view) {
        if (g(view) && a(view, -1)) {
            return -c(view);
        }
        return 0;
    }

    static boolean g(View view) {
        if (view == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConsecutiveScrollerLayout.LayoutParams) {
            return ((ConsecutiveScrollerLayout.LayoutParams) layoutParams).a;
        }
        return true;
    }

    static boolean h(View view) {
        return (view instanceof RecyclerView) || (view instanceof AbsListView);
    }

    static boolean a(View view, int i2) {
        return view instanceof AbsListView ? ((AbsListView) view).canScrollList(i2) : view.canScrollVertically(i2);
    }

    static List<View> a(View view, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        a(arrayList, view, i2, i3);
        return arrayList;
    }

    static boolean b(View view, int i2, int i3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredWidth() + i4 && i3 >= i5 && i3 <= view.getMeasuredHeight() + i5;
    }

    private static void a(List<View> list, View view, int i2, int i3) {
        if (b(view, i2, i3)) {
            list.add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                a(list, viewGroup.getChildAt(i4), i2, i3);
            }
        }
    }

    static int b(View view, MotionEvent motionEvent, int i2) {
        view.getLocationOnScreen(new int[2]);
        return (int) (r0[1] + motionEvent.getY(i2));
    }

    static int a(View view, MotionEvent motionEvent, int i2) {
        view.getLocationOnScreen(new int[2]);
        return (int) (r0[0] + motionEvent.getX(i2));
    }

    static List<Integer> a(List<View> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(c(it.next())));
        }
        return arrayList;
    }

    static boolean a(List<Integer> list, List<Integer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!list.get(i2).equals(list2.get(i2))) {
                return false;
            }
        }
        return true;
    }
}
