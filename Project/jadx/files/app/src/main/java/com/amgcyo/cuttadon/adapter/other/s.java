package com.amgcyo.cuttadon.adapter.other;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* JADX INFO: compiled from: MkViewPagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class s extends FragmentPagerAdapter {
    private List<Fragment> a;

    public s(Context context, List<Fragment> list, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = list;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        return this.a.get(i2);
    }
}
