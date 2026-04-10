package com.amgcyo.cuttadon.adapter.other;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;

/* JADX INFO: compiled from: MkBookCityPageAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends FragmentPagerAdapter {
    private String[] a;
    private List<Fragment> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FragmentManager f3085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FragmentTransaction f3086d;

    public e(FragmentManager fragmentManager, String[] strArr, List<Fragment> list) {
        super(fragmentManager);
        this.f3085c = fragmentManager;
        this.a = strArr;
        this.b = list;
    }

    private static String makeFragmentName(int i2, long j2) {
        return "android:switcher:" + i2 + ":" + j2;
    }

    public void a(ViewGroup viewGroup) {
        if (this.f3086d == null) {
            this.f3086d = this.f3085c.beginTransaction();
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            String strMakeFragmentName = makeFragmentName(viewGroup.getId(), getItemId(i2));
            Fragment fragmentFindFragmentByTag = this.f3085c.findFragmentByTag(strMakeFragmentName);
            if (fragmentFindFragmentByTag != null) {
                this.f3086d.remove(fragmentFindFragmentByTag);
                String str = "根据对应的ID，找到fragment，删除:" + strMakeFragmentName;
            }
        }
        this.f3086d.commitNowAllowingStateLoss();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.a.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NonNull
    public Fragment getItem(int i2) {
        return this.b.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return this.a[i2];
    }
}
