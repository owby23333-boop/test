package com.kwad.components.core.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.page.recycle.DetailWebRecycleView;
import com.kwad.components.core.page.recycle.e;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.umeng.message.proguard.ad;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    private WebView Lk;
    private FeedVideoView Ll;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ImageView mWebTipBarCloseBtn;
    private LinearLayout mWebTipBarLayout;
    private TextView mWebTipBarTitle;

    static class a extends com.kwad.components.core.page.recycle.d {
        e Lo;
        AdTemplate mAdTemplate;
        private Context mContext;

        a(AdTemplate adTemplate, Context context, e eVar) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.Lo = eVar;
        }

        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i2) {
            super.onBindViewHolder(cVar, i2);
        }

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c b(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                View viewA = com.kwad.sdk.i.a.a(this.mContext, R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a(new com.kwad.components.core.page.a.b());
                return new com.kwad.components.core.page.recycle.c(viewA, presenter, this.Lo);
            }
            if (i2 != 0) {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 64.0f)));
                return new com.kwad.components.core.page.recycle.c(view, new Presenter(), this.Lo);
            }
            FeedVideoView feedVideoView = new FeedVideoView(viewGroup.getContext());
            Presenter presenter2 = new Presenter();
            presenter2.a(new com.kwad.components.core.page.a.a());
            return new com.kwad.components.core.page.recycle.c(feedVideoView, presenter2, this.Lo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i2) {
            return i2;
        }
    }

    public static b L(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(View view) {
        this.mWebTipBarLayout = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.mWebTipBarTitle = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        this.mWebTipBarCloseBtn = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.mWebTipBarCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        boolean zBm = com.kwad.sdk.core.response.a.a.bm(adInfoCb);
        String strBi = com.kwad.sdk.core.response.a.a.bi(adInfoCb);
        if (!zBm) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(strBi);
        this.mWebTipBarTitle.setSelected(true);
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.mAdTemplate, recyclerView.getContext(), new e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }

    @Override // com.kwad.components.core.l.f, com.kwad.sdk.h.kwai.b
    public final boolean bX() {
        WebView webView = this.Lk;
        if (webView != null && webView.canGoBack()) {
            this.Lk.goBack();
            return true;
        }
        FeedVideoView feedVideoView = this.Ll;
        if (feedVideoView != null) {
            return feedVideoView.rP();
        }
        return false;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        this.mAdTemplate = adTemplate;
        this.mAdTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.l.f, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) oV();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    com.kwad.sdk.core.d.b.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + viewHolderFindViewHolderForAdapterPosition.itemView.getHeight() + ad.f20406s);
                    detailWebRecycleView.setTopViewHeight(viewHolderFindViewHolderForAdapterPosition.itemView.getHeight());
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view2 instanceof FeedVideoView) {
                        b.this.Ll = (FeedVideoView) view2;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.Lk = (WebView) view3.findViewById(R.id.ksad_video_webView);
                    b.this.w(view3);
                }
                com.kwad.sdk.core.d.b.d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final int or() {
        return R.layout.ksad_detail_webview;
    }

    public final void setApkDownloadHelper(com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
