package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class ViewPager2Delegate extends ViewPager2 implements a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f13035m = "getScrollState";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f13036n = "getCurrentItem";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f13037o = "setCurrentItem";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f13038p = "setOrientation";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f13039q = "setAdapter";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f13040r = "setOffscreenPageLimit";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final b f13041s;

    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        this.f13041s = b.a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                ViewPager2Delegate.this.f13041s.a("onOverScrollEnd");
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                ViewPager2Delegate.this.f13041s.a("onOverScrollStart");
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                ViewPager2Delegate.this.f13041s.a("onPageScrollStateChanged", Integer.valueOf(i2));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i2, float f2, int i3) {
                ViewPager2Delegate.this.f13041s.a("onPageScrolled", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2Delegate.this.f13041s.a("onPageSelected", Integer.valueOf(i2));
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f13041s.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f13041s.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f13041s.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f13041s.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f13041s.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f13041s.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f13035m.equals(str2)) {
            return Integer.valueOf(getScrollState());
        }
        if (f13036n.equals(str2)) {
            return Integer.valueOf(getCurrentItem());
        }
        if (f13037o.equals(str2) && b.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setCurrentItem(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f13038p.equals(str2) && b.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOrientation(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f13039q.equals(str2) && b.a(objArr, (Class<?>[]) new Class[]{RecyclerView.Adapter.class})) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if (!f13040r.equals(str2) || !b.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            return null;
        }
        setOffscreenPageLimit(((Integer) objArr[0]).intValue());
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f13041s.setTarget(obj);
    }
}
