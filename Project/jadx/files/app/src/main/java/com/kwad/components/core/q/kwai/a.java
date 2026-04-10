package com.kwad.components.core.q.kwai;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.a.a;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
public class a extends com.kwad.components.core.j.b<b> {
    private String Pu;
    private boolean Pv;
    private h Pw;
    private int Px;
    private com.kwad.components.core.q.a.a Py;
    private AdTemplate mAdTemplate;
    private AdBaseFrameLayout mRootContainer;
    private StyleTemplate mStyleTemplate;
    private com.kwad.components.core.a.a mTitleBarHelper;
    private static final ConcurrentMap<Integer, Map<String, Object>> Pz = new ConcurrentHashMap();
    private static final AtomicInteger PA = new AtomicInteger(1);

    public static void a(int i2, String str, Object obj) {
        Map<String, Object> map = Pz.get(Integer.valueOf(i2));
        if (map == null) {
            map = new HashMap<>();
            Pz.put(Integer.valueOf(i2), map);
        }
        map.put(str, obj);
    }

    private static void aG(int i2) {
        Map<String, Object> map = Pz.get(Integer.valueOf(i2));
        if (map != null) {
            map.clear();
        }
    }

    private Object ax(String str) {
        return g(this.Px, str);
    }

    private static Object g(int i2, String str) {
        Map<String, Object> map = Pz.get(Integer.valueOf(i2));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.j.b
    /* JADX INFO: renamed from: pS, reason: merged with bridge method [inline-methods] */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.mStyleTemplate = this.mStyleTemplate;
        bVar.mRootContainer = this.mRootContainer;
        bVar.Pw = this.Pw;
        return bVar;
    }

    public static int pT() {
        return PA.incrementAndGet();
    }

    public static void register() {
        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, a.class);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(@Nullable Intent intent) {
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        try {
            StyleTemplate styleTemplate = new StyleTemplate();
            styleTemplate.parseJson(new JSONObject(stringExtra));
            this.mStyleTemplate = styleTemplate;
            String stringExtra2 = getIntent().getStringExtra("tk_ad_template");
            if (TextUtils.isEmpty(stringExtra2)) {
                return true;
            }
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra2));
                this.mAdTemplate = adTemplate;
                return true;
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.Pv = getIntent().getBooleanExtra("show_navigationBar", true);
        this.Pu = getIntent().getStringExtra("title");
        this.Px = getIntent().getIntExtra("tk_id", 0);
        this.mContext = Wrapper.wrapContextIfNeed(getActivity());
        this.Pw = (h) ax("native_intent");
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        if (!this.Pv) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootContainer.getLayoutParams();
            layoutParams.topMargin = 0;
            this.mRootContainer.setLayoutParams(layoutParams);
        }
        this.mTitleBarHelper = new com.kwad.components.core.a.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper.a(new a.InterfaceC0385a() { // from class: com.kwad.components.core.q.kwai.a.1
            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void u(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void v(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.a.b(this.Pu));
        this.mTitleBarHelper.aj(false);
    }

    @Override // com.kwad.components.core.j.b
    public Presenter onCreatePresenter() {
        com.kwad.components.core.q.a.a aVar = new com.kwad.components.core.q.a.a();
        this.Py = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        aG(this.Px);
    }

    @Override // com.kwad.components.core.j.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
