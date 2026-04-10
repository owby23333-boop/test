package com.funny.audio.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.funny.audio.view.core.BaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b¨\u0006\n"}, d2 = {"Lcom/funny/audio/view/ViewUtils;", "", "()V", "createPageAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Lcom/funny/audio/view/core/BaseFragment;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();

    private ViewUtils() {
    }

    public final PagerAdapter createPageAdapter(final FragmentManager manager, final List<BaseFragment<?>> fragments) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        return new FragmentPagerAdapter(manager) { // from class: com.funny.audio.view.ViewUtils$createPageAdapter$adapter$1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return fragments.size();
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        };
    }
}
