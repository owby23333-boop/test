package com.baidu.mobads.sdk.internal.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    @NonNull
    private final List<ViewPager2.OnPageChangeCallback> a;

    CompositeOnPageChangeCallback(int i2) {
        this.a = new ArrayList(i2);
    }

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.a.add(onPageChangeCallback);
    }

    void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.a.remove(onPageChangeCallback);
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i2) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i2, float f2, @Px int i3) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i2, f2, i3);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i2) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
