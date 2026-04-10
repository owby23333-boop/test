package com.funny.audio.view.bookshelf;

import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.angcyo.tablayout.DslTabLayout;
import com.angcyo.tablayout.delegate.ViewPager1Delegate;
import com.funny.audio.AppManager;
import com.funny.audio.ad.AdManager;
import com.funny.audio.ad.AdSetting;
import com.funny.audio.ad.loader.InterstitialAdListener;
import com.funny.audio.ad.loader.InterstitialAdLoader;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.FragmentBookshelfBinding;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.ViewUtils;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BookshelfFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/funny/audio/view/bookshelf/BookshelfFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentBookshelfBinding;", "()V", "initData", "", "initStatusBar", "initTab", "initView", "view", "Landroid/view/View;", "loadInterstitialAd", "onResume", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BookshelfFragment extends BaseFragment<FragmentBookshelfBinding> {
    @Override // com.funny.audio.view.core.BaseFragment
    public void initData() {
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initStatusBar();
        initTab();
    }

    private final void initTab() {
        DslTabLayout dslTabLayout = getBd().lyTab;
        Intrinsics.checkNotNullExpressionValue(dslTabLayout, "bd.lyTab");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CollectFragment());
        arrayList.add(new HistoryFragment());
        QMUIViewPager qMUIViewPager = getBd().viewPager;
        Intrinsics.checkNotNullExpressionValue(qMUIViewPager, "bd.viewPager");
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        qMUIViewPager.setAdapter(viewUtils.createPageAdapter(childFragmentManager, arrayList));
        qMUIViewPager.setOffscreenPageLimit(2);
        qMUIViewPager.setSwipeable(true);
        ViewPager1Delegate.Companion.install$default(ViewPager1Delegate.INSTANCE, qMUIViewPager, dslTabLayout, null, 4, null);
        ImageView imageView = getBd().ivSearch;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.ivSearch");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.BookshelfFragment.initTab.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NavigationUtils.INSTANCE.toSearch(BookshelfFragment.this.getActivity());
            }
        }, 1, null);
    }

    private final void initStatusBar() {
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils statusBarUtils = StatusBarUtils.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            statusBarUtils.setStatusBarDarkMode(fragmentActivityRequireActivity);
            return;
        }
        StatusBarUtils statusBarUtils2 = StatusBarUtils.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
        statusBarUtils2.setStatusBarLightMode(fragmentActivityRequireActivity2);
    }

    @Override // com.funny.audio.view.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            loadInterstitialAd();
        } catch (Exception unused) {
        }
    }

    private final void loadInterstitialAd() {
        InterstitialAdLoader bookshelfInterstitialAdLoader;
        final AdSetting setting = AdManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (AdManager.INSTANCE.getShow() && setting.getBookshelfInterstitialAd().getShow()) {
            if ((!setting.getPureModeRewardAd().getShow() || setting.getPureTime().getValueLong() <= jCurrentTimeMillis) && jCurrentTimeMillis - setting.getResumeBookshelfTime() > setting.getBookshelfInterstitialAd().getShowInterval() && (bookshelfInterstitialAdLoader = AdManager.INSTANCE.getBookshelfInterstitialAdLoader()) != null) {
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                bookshelfInterstitialAdLoader.showWithLoad(fragmentActivityRequireActivity, null, new InterstitialAdListener() { // from class: com.funny.audio.view.bookshelf.BookshelfFragment.loadInterstitialAd.1
                    @Override // com.funny.audio.ad.loader.InterstitialAdListener
                    public void onAdClose() {
                    }

                    @Override // com.funny.audio.ad.loader.InterstitialAdListener
                    public void onAdShow() {
                        setting.setResumeBookshelfTime(System.currentTimeMillis());
                    }
                });
            }
        }
    }
}
