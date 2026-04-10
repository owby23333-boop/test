package com.lcodecore.tkrefreshlayout.h;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: ScrollingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static boolean a(View view, int i2) {
        if (view instanceof AbsListView) {
            return a((AbsListView) view);
        }
        if (view instanceof RecyclerView) {
            return a((RecyclerView) view);
        }
        if (view instanceof WebView) {
            return a((WebView) view, i2);
        }
        if (view instanceof ViewGroup) {
            return a((ViewGroup) view);
        }
        return false;
    }

    public static boolean b(View view, int i2) {
        return view instanceof AbsListView ? b((AbsListView) view) : view instanceof RecyclerView ? b((RecyclerView) view) : view != null && Math.abs(view.getScrollY()) <= i2 * 2;
    }

    public static void c(View view, int i2) {
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).scrollBy(0, i2);
            return;
        }
        if (view instanceof ScrollView) {
            ((ScrollView) view).smoothScrollBy(0, i2);
        } else {
            if (view instanceof AbsListView) {
                ((AbsListView) view).smoothScrollBy(i2, 0);
                return;
            }
            try {
                view.getClass().getDeclaredMethod("smoothScrollBy", Integer.class, Integer.class).invoke(view, 0, Integer.valueOf(i2));
            } catch (Exception unused) {
                view.scrollBy(0, i2);
            }
        }
    }

    public static boolean b(AbsListView absListView) {
        if (absListView != null) {
            int top = absListView.getChildCount() > 0 ? absListView.getChildAt(0).getTop() - absListView.getPaddingTop() : 0;
            if (absListView.getFirstVisiblePosition() == 0 && top == 0) {
                return true;
            }
        }
        return false;
    }

    private static int a(RecyclerView.LayoutParams layoutParams) {
        try {
            Field declaredField = RecyclerView.LayoutParams.class.getDeclaredField("mDecorInsets");
            declaredField.setAccessible(true);
            return ((Rect) declaredField.get(layoutParams)).top;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean b(RecyclerView recyclerView) {
        int top;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null || layoutManager.getItemCount() == 0) {
                return true;
            }
            if (recyclerView.getChildCount() > 0) {
                View childAt = recyclerView.getChildAt(0);
                if (childAt != null && childAt.getMeasuredHeight() >= recyclerView.getMeasuredHeight()) {
                    if (Build.VERSION.SDK_INT < 14) {
                        return !ViewCompat.canScrollVertically(recyclerView, -1) && recyclerView.getScrollY() <= 0;
                    }
                    return !ViewCompat.canScrollVertically(recyclerView, -1);
                }
                View childAt2 = recyclerView.getChildAt(0);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt2.getLayoutParams();
                top = ((childAt2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - a(layoutParams)) - recyclerView.getPaddingTop();
            } else {
                top = 0;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() < 1 && top == 0) {
                    return true;
                }
            } else if ((layoutManager instanceof StaggeredGridLayoutManager) && ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(null)[0] < 1 && top == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(WebView webView, int i2) {
        return webView != null && (((float) webView.getContentHeight()) * webView.getScale()) - ((float) (webView.getHeight() + webView.getScrollY())) <= ((float) (i2 * 2));
    }

    public static boolean a(ViewGroup viewGroup) {
        View childAt = viewGroup.getChildAt(0);
        return childAt != null && childAt.getMeasuredHeight() <= viewGroup.getScrollY() + viewGroup.getHeight();
    }

    public static boolean a(AbsListView absListView) {
        return absListView != null && absListView.getAdapter() != null && absListView.getChildCount() > 0 && absListView.getLastVisiblePosition() == ((ListAdapter) absListView.getAdapter()).getCount() - 1 && absListView.getChildAt(absListView.getChildCount() - 1).getBottom() <= absListView.getMeasuredHeight();
    }

    public static boolean a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && layoutManager.getItemCount() != 0) {
            if (layoutManager instanceof LinearLayoutManager) {
                View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                if (childAt != null && childAt.getMeasuredHeight() >= recyclerView.getMeasuredHeight()) {
                    if (Build.VERSION.SDK_INT < 14) {
                        return !ViewCompat.canScrollVertically(recyclerView, 1) && recyclerView.getScrollY() >= 0;
                    }
                    return !ViewCompat.canScrollVertically(recyclerView, 1);
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
                    return true;
                }
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArrFindLastCompletelyVisibleItemPositions = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null);
                int itemCount = staggeredGridLayoutManager.getItemCount() - 1;
                for (int i2 : iArrFindLastCompletelyVisibleItemPositions) {
                    if (i2 == itemCount) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
