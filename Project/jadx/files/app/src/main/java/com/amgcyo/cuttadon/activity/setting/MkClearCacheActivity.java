package com.amgcyo.cuttadon.activity.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.fatcatfat.io.R;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class MkClearCacheActivity extends BaseTitleBarActivity {
    public static final String Glide = "Glide";

    @BindView(R.id.ll_book_cache)
    LinearLayout llBookCache;

    @BindView(R.id.ll_pic_cache)
    LinearLayout llPicCache;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    String f2827n0;

    @BindView(R.id.tv_ad_cache_size)
    TextView tvAdCacheSize;

    @BindView(R.id.tv_book_cache_size)
    TextView tvBookCacheSize;

    @BindView(R.id.tv_pic_cache_size)
    TextView tvPicCacheSize;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "清除缓存";
    }

    public /* synthetic */ void e(View view) {
        com.amgcyo.cuttadon.j.a.e.a(a(), com.amgcyo.cuttadon.utils.otherutils.z.b + "/books", true, new com.amgcyo.cuttadon.j.e.b() { // from class: com.amgcyo.cuttadon.activity.setting.l
            @Override // com.amgcyo.cuttadon.j.e.b
            public final void a() {
                this.a.n();
            }
        }, true);
    }

    public /* synthetic */ void f(View view) {
        com.amgcyo.cuttadon.j.a.e.a(a(), this.f2827n0 + File.separator + "Glide", true, new com.amgcyo.cuttadon.j.e.b() { // from class: com.amgcyo.cuttadon.activity.setting.m
            @Override // com.amgcyo.cuttadon.j.e.b
            public final void a() {
                this.a.o();
            }
        }, true);
    }

    public /* synthetic */ void g(View view) {
        showLoading("努力加载中...");
        com.amgcyo.cuttadon.j.g.b.a(new f0(this, ""));
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        try {
            long jA = com.amgcyo.cuttadon.j.a.e.a(new File(com.amgcyo.cuttadon.utils.otherutils.z.b + "/books"));
            String str = "book_folderSize: " + jA;
            this.tvBookCacheSize.setText(com.amgcyo.cuttadon.j.a.e.a(jA));
            File externalCacheDir = getExternalCacheDir();
            if (externalCacheDir != null) {
                this.llPicCache.setVisibility(0);
                this.f2827n0 = externalCacheDir.getAbsolutePath();
                String str2 = "图片缓存：" + this.f2827n0;
                long jA2 = com.amgcyo.cuttadon.j.a.e.a(new File(this.f2827n0));
                long jA3 = com.amgcyo.cuttadon.j.a.e.a(new File(this.f2827n0 + File.separator + "Glide"));
                this.tvPicCacheSize.setText(com.amgcyo.cuttadon.j.a.e.a((double) jA3));
                this.tvAdCacheSize.setText(com.amgcyo.cuttadon.j.a.e.a((double) (jA2 - jA3)));
            } else {
                this.llPicCache.setVisibility(8);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_clear_cache;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    public /* synthetic */ void n() {
        this.tvBookCacheSize.setText("0.0B");
    }

    public /* synthetic */ void o() {
        this.tvPicCacheSize.setText("0.0B");
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @OnClick({R.id.ll_pic_cache, R.id.ll_book_cache, R.id.ll_ad_cache})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.ll_ad_cache) {
            try {
                if (TextUtils.isEmpty(this.f2827n0)) {
                    showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_error));
                    return;
                } else {
                    com.amgcyo.cuttadon.f.o.a(a(), "提示", "该操作将清除所有其它缓存！是否清除?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f2870s.g(view2);
                        }
                    }, (View.OnClickListener) null);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (id == R.id.ll_book_cache) {
            com.amgcyo.cuttadon.f.o.a(a(), "提示", "该操作将清除已缓存的书籍内容(不会清除书架)！是否清除?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f2869s.e(view2);
                }
            }, (View.OnClickListener) null);
        } else {
            if (id != R.id.ll_pic_cache) {
                return;
            }
            if (TextUtils.isEmpty(this.f2827n0)) {
                showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_error));
            } else {
                com.amgcyo.cuttadon.f.o.a(a(), "提示", "该操作将清除所有书籍封面缓存！是否清除?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f2868s.f(view2);
                    }
                }, (View.OnClickListener) null);
            }
        }
    }
}
