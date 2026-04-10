package com.amgcyo.cuttadon.adapter.comic;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.api.entity.comic.DanmakuContent;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.comic.network.ComicsNetUtil;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.w;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.comic.ComicReadPictureView;
import com.amgcyo.cuttadon.view.comic.GestureDetectorFrameLayout;
import com.amgcyo.cuttadon.view.comic.GestureDetectorLinearLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.k.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import com.github.chrisbanes.photoview.i;
import com.github.chrisbanes.photoview.l;
import com.zwb.danmaku.DanmakuState;
import com.zwb.danmaku.MkDanmakuView;
import com.zwb.danmaku.c.e;
import com.zwb.danmaku.model.BaseDanmaku;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import me.jessyan.art.entity.GlideBean;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkReaderAdapterQuick extends com.chad.library.adapter.base.a<ComicChapter, com.chad.library.adapter.base.b> {
    private String L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private i U;
    private com.amgcyo.cuttadon.view.comic.m.c V;
    private int W;
    private int X;
    private boolean Y;
    private String Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private g0 f3052a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f3053b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected me.jessyan.art.c.e.c f3054c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f3055d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f3056e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f3057f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f3058g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private HashMap<String, MkDanmakuView> f3059h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f3060i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f3061j0;

    @Retention(RetentionPolicy.SOURCE)
    @interface ReaderMode {
    }

    class a implements g<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ImageView f3062s;

        a(MkReaderAdapterQuick mkReaderAdapterQuick, ImageView imageView) {
            this.f3062s = imageView;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
            this.f3062s.setImageDrawable(w.a(w.a(drawable), 10));
            return false;
        }
    }

    class b implements g<Drawable> {
        final /* synthetic */ TextView A;
        final /* synthetic */ Space B;
        final /* synthetic */ Space C;
        final /* synthetic */ Space D;
        final /* synthetic */ ComicChapter E;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ GestureDetectorFrameLayout f3063s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ GestureDetectorLinearLayout f3064t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ ComicReadPictureView f3065u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ String f3066v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final /* synthetic */ TextView f3067w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ TextView f3068x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ TextView f3069y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ String f3070z;

        b(GestureDetectorFrameLayout gestureDetectorFrameLayout, GestureDetectorLinearLayout gestureDetectorLinearLayout, ComicReadPictureView comicReadPictureView, String str, TextView textView, TextView textView2, TextView textView3, int i2, String str2, TextView textView4, Space space, Space space2, Space space3, ComicChapter comicChapter) {
            this.f3063s = gestureDetectorFrameLayout;
            this.f3064t = gestureDetectorLinearLayout;
            this.f3065u = comicReadPictureView;
            this.f3066v = str;
            this.f3067w = textView;
            this.f3068x = textView2;
            this.f3069y = textView3;
            this.f3070z = str2;
            this.A = textView4;
            this.B = space;
            this.C = space2;
            this.D = space3;
            this.E = comicChapter;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
            String localizedMessage;
            ViewGroup.LayoutParams layoutParams = this.f3063s.getLayoutParams();
            if (MkReaderAdapterQuick.this.O == 1) {
                layoutParams.height = -2;
            }
            String strD = o.d(R.string.comic_error_retry);
            layoutParams.width = MkReaderAdapterQuick.this.M;
            this.f3063s.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f3064t.getLayoutParams();
            if (MkReaderAdapterQuick.this.O == 1) {
                layoutParams2.height = -2;
            }
            layoutParams2.width = MkReaderAdapterQuick.this.M;
            this.f3064t.setLayoutParams(layoutParams2);
            this.f3065u.setVisibility(8);
            boolean zC = ComicsNetUtil.c(((BaseQuickAdapter) MkReaderAdapterQuick.this).f14735w);
            String strD2 = o.d(R.string.onloadfailed);
            Object[] objArr = new Object[4];
            objArr[0] = zC ? "流量(3G、4G、5G)" : "WIFI";
            objArr[1] = strD;
            objArr[2] = strD;
            objArr[3] = this.f3066v;
            this.f3067w.setText(String.format("解决方式(任选其一或都尝试)：\n1，请检查网络设置，看看当前网络连接是否正常；\n2，切换到%s网络环境后再点击“%s”；\n3，开启飞行模式，然后再关闭飞行模式，5秒后再点击“%s”；\n4，返回到书架长按书籍，然后选择清除缓存后再重新打开书籍进行阅读！\n5，将书移出书架，然后再添加到书架，然后再重新打开书籍进行阅读！\n6，因漫画图片占用内存相对较多以及部分机型出现白屏现象，请退出应用并清理后台其他应用再重新打开！\n7，如果以上方式都无法解决，请点击下方“%s”按钮进行反馈或者反馈给客服！", objArr));
            this.f3068x.setText(this.f3066v);
            this.f3069y.setText(strD);
            if (glideException != null) {
                localizedMessage = glideException.getLocalizedMessage();
                if (localizedMessage != null && !TextUtils.isEmpty(localizedMessage) && (localizedMessage.contains("UnknownHostException") || localizedMessage.contains("returned no addresses for"))) {
                    this.f3067w.setText("");
                    this.f3069y.setText(o.d(R.string.comic_error_restart_app));
                    this.f3068x.setText(o.d(R.string.comic_error_to_kefu));
                    strD2 = "未知主机异常，请重新启动APP\n如果重启多次（5次以上）仍然无法解决，请反馈给客服！";
                }
            } else {
                localizedMessage = "图片加载失败!";
            }
            MkReaderAdapterQuick.this.b(this.f3067w);
            MkReaderAdapterQuick.this.a(this.f3064t, this.f3065u);
            this.f3068x.setTag(localizedMessage);
            this.f3069y.setTag(this.f3070z);
            boolean zQ0 = com.amgcyo.cuttadon.utils.otherutils.g.q0();
            TextView textView = this.A;
            Object[] objArr2 = new Object[1];
            if (!zQ0) {
                strD2 = "网络连接不可用，请检查网络设置!\n" + strD2;
            }
            objArr2[0] = strD2;
            textView.setText(String.format("%s", objArr2));
            MkReaderAdapterQuick.this.b(this.B, this.C, this.D, this.f3069y);
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
            MkReaderAdapterQuick.this.a(this.E);
            this.f3064t.setVisibility(8);
            this.f3065u.setTextVisibility(false);
            return false;
        }
    }

    class c extends RecyclerView.ItemDecoration {
        c(MkReaderAdapterQuick mkReaderAdapterQuick) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            rect.set(0, 0, 0, 0);
        }
    }

    class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if (MkReaderAdapterQuick.this.P) {
                rect.set(0, 10, 0, 10);
            } else {
                rect.set(10, 0, 10, 0);
            }
        }
    }

    public MkReaderAdapterQuick(List<ComicChapter> list, String str) {
        super(list);
        this.f3056e0 = com.zwb.danmaku.model.a.a;
        this.f3057f0 = 3;
        this.f3058g0 = 3;
        this.f3059h0 = new HashMap<>();
        this.X = com.amgcyo.cuttadon.h.a.i.b(3);
        this.Y = com.amgcyo.cuttadon.utils.otherutils.g.b(h.x());
        this.Z = str;
        this.R = com.amgcyo.cuttadon.utils.otherutils.g.l0();
        this.f3052a0 = g0.a();
        this.f3053b0 = z.a();
        b(1, R.layout.comic_vertical_ad_item);
        b(2, R.layout.item_read_stream);
        b(3, R.layout.item_read_reward);
    }

    private int i(int i2) {
        if (i2 == 2) {
            return 14;
        }
        if (i2 == 3) {
            return 16;
        }
        if (i2 != 4) {
            return i2 != 5 ? 12 : 20;
        }
        return 18;
    }

    private int j(int i2) {
        if (i2 == 2) {
            return 4;
        }
        if (i2 == 3) {
            return 6;
        }
        if (i2 != 4) {
            return i2 != 5 ? 2 : 10;
        }
        return 8;
    }

    public int e(int i2) {
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? o.b(R.color.danmu_black) : o.b(R.color.danmu_blue) : o.b(R.color.danmu_green) : o.b(R.color.danmu_yellow) : o.b(R.color.danmu_pink) : o.b(R.color.danmu_orange);
    }

    public void f(int i2) {
        this.f3057f0 = i2;
    }

    public void g(int i2) {
        this.O = i2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    public void h(int i2) {
        this.f3058g0 = i2;
    }

    public HashMap<String, MkDanmakuView> s() {
        return this.f3059h0;
    }

    public float t() {
        return this.f3055d0;
    }

    public RecyclerView.ItemDecoration u() {
        return this.O != 1 ? new c(this) : new d();
    }

    private void b(MkDanmakuView mkDanmakuView, List<DanmakuContent> list) {
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(mkDanmakuView.getDanmukus())) {
            mkDanmakuView.d();
        } else {
            a(mkDanmakuView, list);
            mkDanmakuView.e();
        }
    }

    private void d(com.chad.library.adapter.base.b bVar, ComicChapter comicChapter) {
        TextView textView = (TextView) bVar.a(R.id.tv_unlock_next);
        TextView textView2 = (TextView) bVar.a(R.id.tv_chapter_title);
        String tempName = comicChapter.getTempName();
        textView2.setText(tempName);
        textView.setText(comicChapter.getTips());
        textView.setTag(comicChapter);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_temp_pic);
        RelativeLayout relativeLayout = (RelativeLayout) bVar.a(R.id.re_top);
        ImageView imageView2 = (ImageView) bVar.a(R.id.temp);
        bVar.a(R.id.tv_unlock_next);
        this.f3054c0.a(this.f14735w, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(3), comicChapter.getBook_img())).form(3).listener(new a(this, imageView)).imageView(imageView2).build());
        if (this.O != 1 || tempName.startsWith("当前话")) {
            o.a(relativeLayout, 0, (this.N / 2) - n.a(140.0f), 0, 0);
        } else {
            o.a(relativeLayout, 0, 0, 0, 0);
        }
        a(comicChapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NonNull com.chad.library.adapter.base.b bVar) {
        MkDanmakuView mkDanmakuView;
        Context context;
        super.onViewRecycled(bVar);
        int itemViewType = bVar.getItemViewType();
        if (itemViewType == 1 || itemViewType != 2) {
            return;
        }
        ComicReadPictureView comicReadPictureView = (ComicReadPictureView) bVar.a(R.id.reader_image_view);
        if (comicReadPictureView != null && (context = this.f14735w) != null) {
            com.bumptech.glide.c.e(context).clear(comicReadPictureView);
        }
        if (this.R && this.Q && (mkDanmakuView = (MkDanmakuView) bVar.a(R.id.danmakuView)) != null) {
            mkDanmakuView.a();
        }
    }

    public void f(boolean z2) {
        this.P = z2;
    }

    public void g(boolean z2) {
        this.T = z2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected /* bridge */ /* synthetic */ void a(@NonNull com.chad.library.adapter.base.b bVar, Object obj, @NonNull List list) {
        a(bVar, (ComicChapter) obj, (List<Object>) list);
    }

    private void b(@NonNull com.chad.library.adapter.base.b bVar, ComicChapter comicChapter) {
        GestureDetectorLinearLayout gestureDetectorLinearLayout = (GestureDetectorLinearLayout) bVar.a(R.id.ll_ad_root);
        AdFrameLayout adFrameLayout = (AdFrameLayout) bVar.a(R.id.adframelayout_comics);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.ll_ad_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adFrameLayout.getLayoutParams();
        if (this.O == 0) {
            gestureDetectorLinearLayout.setTapListenerListener(this.U);
            linearLayout.setBackgroundColor(-1);
            a(gestureDetectorLinearLayout);
        }
        TextView textView = (TextView) bVar.a(R.id.tv_no_ad_read);
        TextView textView2 = (TextView) bVar.a(R.id.tv_ad_tips);
        NormalAdParams adParams = comicChapter.getAdParams();
        if (adParams != null) {
            adParams.setSelfAdPosition(com.amgcyo.cuttadon.f.n.E);
            if (!this.S) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.gravity = 17;
                int iRound = Math.round(this.M / 2.0f);
                layoutParams.width = iRound;
                adParams.setAdWidth(iRound);
                int i2 = layoutParams.width / 2;
                layoutParams.leftMargin = i2;
                layoutParams.rightMargin = i2;
                adFrameLayout.setLayoutParams(layoutParams);
                layoutParams2.gravity = layoutParams.gravity;
                layoutParams2.width = Math.round(this.M / 3.0f);
                textView.setLayoutParams(layoutParams2);
            } else {
                layoutParams.height = -2;
                layoutParams.width = -1;
                int iA = n.a(10.0f);
                layoutParams.leftMargin = iA;
                layoutParams.rightMargin = iA;
                adFrameLayout.setLayoutParams(layoutParams);
                o.a(adFrameLayout, iA, iA, iA, 0);
            }
            String str = "广告是：" + adParams.getBaseAd().toString();
            adFrameLayout.b(adParams);
            if (this.Y && this.X > 0) {
                textView.setVisibility(0);
                textView2.setVisibility(0);
                textView.setText(h.n(this.X));
                bVar.a(R.id.tv_no_ad_read);
            } else {
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        } else {
            adFrameLayout.setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(8);
        }
        a(comicChapter);
    }

    public void a(float f2) {
        this.f3056e0 = f2;
    }

    public void e(boolean z2) {
        this.S = z2;
    }

    public void a(Context context, com.amgcyo.cuttadon.view.comic.m.c cVar, me.jessyan.art.c.e.c cVar2) {
        this.V = cVar;
        this.M = n.c(context);
        this.N = n.a(context);
        this.f3054c0 = cVar2;
        this.L = com.amgcyo.cuttadon.utils.otherutils.g.n();
        String str = "下载图片：" + this.L;
        this.f3055d0 = context.getResources().getDisplayMetrics().density;
        this.W = (int) n.b(context);
        String str2 = "density:" + this.f3055d0;
    }

    private void c(@NonNull com.chad.library.adapter.base.b bVar, ComicChapter comicChapter) {
        TextView textView;
        String str;
        int bindingAdapterPosition = bVar.getBindingAdapterPosition();
        ComicReadPictureView comicReadPictureView = (ComicReadPictureView) bVar.a(R.id.reader_image_view);
        MkDanmakuView mkDanmakuView = (MkDanmakuView) bVar.a(R.id.danmakuView);
        comicReadPictureView.setText(String.valueOf(comicChapter.getIndex() + 1));
        GestureDetectorFrameLayout gestureDetectorFrameLayout = (GestureDetectorFrameLayout) bVar.a(R.id.fl_read);
        GestureDetectorLinearLayout gestureDetectorLinearLayout = (GestureDetectorLinearLayout) bVar.a(R.id.ll_fail);
        TextView textView2 = (TextView) bVar.a(R.id.tv_error_detail);
        TextView textView3 = (TextView) bVar.a(R.id.tv_error_solution);
        TextView textView4 = (TextView) bVar.a(R.id.btn_first);
        TextView textView5 = (TextView) bVar.a(R.id.btn_two);
        Space space = (Space) bVar.a(R.id.space_1);
        Space space2 = (Space) bVar.a(R.id.space_2);
        Space space3 = (Space) bVar.a(R.id.space_3);
        bVar.a(R.id.btn_first, R.id.btn_two);
        gestureDetectorLinearLayout.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = gestureDetectorFrameLayout.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) comicReadPictureView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) mkDanmakuView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) gestureDetectorLinearLayout.getLayoutParams();
        int height = comicChapter.getHeight();
        if (height <= 0) {
            height = this.N / 4;
        }
        int width = (this.M * height) / comicChapter.getWidth();
        layoutParams2.height = width;
        int i2 = this.M;
        layoutParams2.width = i2;
        layoutParams3.height = width;
        layoutParams3.width = i2;
        if (this.O == 1) {
            gestureDetectorFrameLayout.setClickable(false);
            gestureDetectorFrameLayout.setTapListenerListener(null);
            if (!comicChapter.isIs_content()) {
                textView = textView5;
                a(this.N / 3, layoutParams2, layoutParams, layoutParams4);
            } else {
                textView = textView5;
                a(width, layoutParams, layoutParams4);
                comicReadPictureView.setZoomable(false);
            }
        } else {
            textView = textView5;
            a(this.N, layoutParams);
            layoutParams4.gravity = 17;
            gestureDetectorLinearLayout.setBackgroundColor(-1);
            l attacher = comicReadPictureView.getAttacher();
            attacher.a(this.U);
            attacher.b(this.f3060i0);
            attacher.g(this.f3061j0);
            layoutParams2.gravity = 17;
            layoutParams3.gravity = 17;
            gestureDetectorFrameLayout.setBackgroundColor(o.b(R.color.colorWhite2));
            gestureDetectorFrameLayout.setTapListenerListener(this.U);
        }
        comicReadPictureView.setLayoutParams(layoutParams2);
        mkDanmakuView.setLayoutParams(layoutParams3);
        gestureDetectorLinearLayout.setTapListenerListener(this.U);
        gestureDetectorFrameLayout.setLayoutParams(layoutParams);
        gestureDetectorLinearLayout.setLayoutParams(layoutParams4);
        String path = comicChapter.getPath();
        String strD = o.d(R.string.comic_error_content);
        if (this.f3053b0) {
            a(gestureDetectorLinearLayout, comicReadPictureView);
            textView2.setText(String.format(o.d(R.string.string_enable), "5.0.2", h.C0()));
            textView4.setText(o.d(R.string.check_version));
            TextView textView6 = textView;
            textView6.setText(o.d(R.string.check_version_web));
            b(space, space2, space3, textView6);
            a(textView3);
            return;
        }
        TextView textView7 = textView;
        if (!comicChapter.isIs_content()) {
            String strD2 = o.d(R.string.comic_error_refresh);
            textView4.setText(strD2);
            a(gestureDetectorLinearLayout, comicReadPictureView);
            textView7.setText(strD);
            textView7.setTag("图片缺失：" + path);
            textView2.setText(String.format("错误详情：\n%s", o.d(R.string.is_content_flase)));
            b(space, space2, space3, textView7, textView3);
            textView3.setText(String.format("常用解决方式：\n1，请先点击下方“%s”按钮进行重试！\n2，如果“%s”无效，请点击“%s”进行章节反馈！", strD2, strD2, strD));
            return;
        }
        textView4.setTag(null);
        int encrypt_type = comicChapter.getEncrypt_type();
        int id = comicChapter.getId();
        String str2 = this.L + path;
        if (encrypt_type != 1 && encrypt_type != 0) {
            a(gestureDetectorLinearLayout, comicReadPictureView);
            textView2.setText(String.format("错误详情：\n%s", o.d(R.string.error_version)));
            textView4.setText(o.d(R.string.check_version));
            textView7.setText(o.d(R.string.check_version_web));
            b(space, space2, space3, textView7);
            a(textView3);
            return;
        }
        if (this.f3052a0 == null) {
            this.f3052a0 = g0.a();
        }
        String strD3 = "";
        if (TextUtils.isEmpty(path)) {
            str = "";
        } else {
            String strReplaceAll = path.replaceAll("/", "_");
            strD3 = this.f3052a0.d(strReplaceAll);
            str = strReplaceAll;
        }
        comicReadPictureView.a(this.f14735w, bindingAdapterPosition, str2, this.f3054c0, new GlideBean(id, comicChapter.getEncrypt_info(), encrypt_type, this.Z + strD3), new b(gestureDetectorFrameLayout, gestureDetectorLinearLayout, comicReadPictureView, strD, textView3, textView4, textView7, bindingAdapterPosition, str, textView2, space, space2, space3, comicChapter));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, ComicChapter comicChapter) {
        int itemViewType = bVar.getItemViewType();
        if (itemViewType == 1) {
            b(bVar, comicChapter);
        } else if (itemViewType == 2) {
            c(bVar, comicChapter);
        } else {
            if (itemViewType != 3) {
                return;
            }
            d(bVar, comicChapter);
        }
    }

    private void a(MkDanmakuView mkDanmakuView, List<DanmakuContent> list) {
        int iFloor;
        List<BaseDanmaku> arrayList = new ArrayList<>();
        Iterator<DanmakuContent> it = list.iterator();
        while (true) {
            iFloor = 0;
            if (!it.hasNext()) {
                break;
            }
            DanmakuContent next = it.next();
            BaseDanmaku baseDanmakuA = com.zwb.danmaku.a.a(BaseDanmaku.DanmakuType.TYPE_SCROLL_RL);
            BaseDanmaku baseDanmakuF = baseDanmakuA.a(next.getContent()).b((new Random().nextInt(100) + 10) * this.f3055d0).m(this.f3055d0 * i(this.f3057f0)).a(this.f3056e0).l(j(this.f3058g0)).f(next.getUser_id() == -1 ? o.b(R.color.danmu_white) : e(next.getColor()));
            if (next.getUser_id() == -1) {
                iFloor = R.drawable.shape_danmu_text_bg;
            }
            baseDanmakuF.a(iFloor).e(this.f3055d0 * 10.0f).h(this.f3055d0 * 10.0f).f(this.f3055d0 * 15.0f).g(this.f3055d0 * 15.0f);
            arrayList.add(baseDanmakuA);
        }
        mkDanmakuView.setDanmukus(arrayList);
        List<BaseDanmaku> danmukus = mkDanmakuView.getDanmukus();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(danmukus)) {
            int iB = n.b(mkDanmakuView.getHeight());
            if (this.O == 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mkDanmakuView.getLayoutParams();
                int i2 = this.W;
                if (iB >= i2) {
                    layoutParams.gravity = 48;
                    int i3 = iB - i2;
                    String str = "topMargin：" + i3 + " lineHeightDp:" + iB + " screenHeightDp: " + this.W;
                    layoutParams.topMargin = i3;
                } else {
                    layoutParams.gravity = 17;
                }
                mkDanmakuView.setLayoutParams(layoutParams);
            }
            Iterator<BaseDanmaku> it2 = danmukus.iterator();
            while (it2.hasNext() && (iFloor = (int) Math.floor(iB / it2.next().f())) == 0) {
            }
        }
        int i4 = iFloor < 4 ? iFloor : 4;
        if (i4 <= 0) {
            mkDanmakuView.a();
            mkDanmakuView.setVisibility(8);
        } else {
            mkDanmakuView.a(i4);
        }
    }

    public void d(boolean z2) {
        this.f3060i0 = z2;
    }

    public void b(float f2) {
        this.f3061j0 = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(0);
        }
    }

    protected void a(@NonNull com.chad.library.adapter.base.b bVar, ComicChapter comicChapter, @NonNull List<Object> list) {
        MkDanmakuView mkDanmakuView;
        super.a(bVar, comicChapter, list);
        if (this.R && (mkDanmakuView = (MkDanmakuView) bVar.a(R.id.danmakuView)) != null) {
            if (!this.Q) {
                mkDanmakuView.a();
                mkDanmakuView.setVisibility(8);
                return;
            }
            if (!mkDanmakuView.isShown()) {
                mkDanmakuView.setVisibility(0);
            }
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
                return;
            }
            List<DanmakuContent> danmakuContents = comicChapter.getDanmakuContents();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(danmakuContents)) {
                return;
            }
            int state = comicChapter.getState();
            if (state == 2) {
                mkDanmakuView.c();
                return;
            }
            if (state == 3) {
                mkDanmakuView.d();
                return;
            }
            if (state == 4) {
                a(mkDanmakuView, danmakuContents);
                mkDanmakuView.e();
                return;
            }
            if (state == 5) {
                mkDanmakuView.a();
                a(mkDanmakuView, danmakuContents);
                mkDanmakuView.e();
                return;
            }
            if (state != 6) {
                e drawHelper = mkDanmakuView.getDrawHelper();
                if (drawHelper != null) {
                    if (1 == drawHelper.b()) {
                        mkDanmakuView.a();
                        a(mkDanmakuView, danmakuContents);
                        mkDanmakuView.e();
                        return;
                    } else if (mkDanmakuView.getState() == DanmakuState.STOP) {
                        b(mkDanmakuView, danmakuContents);
                        return;
                    } else {
                        if (mkDanmakuView.b()) {
                            return;
                        }
                        a(mkDanmakuView, danmakuContents);
                        mkDanmakuView.e();
                        return;
                    }
                }
                return;
            }
            mkDanmakuView.a();
        }
    }

    private void a(GestureDetectorLinearLayout gestureDetectorLinearLayout) {
        ViewGroup.LayoutParams layoutParams = gestureDetectorLinearLayout.getLayoutParams();
        layoutParams.height = this.N;
        layoutParams.width = this.M;
        gestureDetectorLinearLayout.setLayoutParams(layoutParams);
    }

    private void a(int i2, ViewGroup.LayoutParams... layoutParamsArr) {
        for (ViewGroup.LayoutParams layoutParams : layoutParamsArr) {
            layoutParams.height = i2;
            layoutParams.width = this.M;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinearLayout linearLayout, ComicReadPictureView comicReadPictureView) {
        a((ComicChapter) null);
        linearLayout.setVisibility(0);
        comicReadPictureView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ComicChapter comicChapter) {
        com.amgcyo.cuttadon.view.comic.m.c cVar;
        if (this.T || (cVar = this.V) == null) {
            return;
        }
        cVar.hideLoadingView(comicChapter);
    }

    public void c(boolean z2) {
        this.Q = z2;
    }

    public void a(i iVar) {
        this.U = iVar;
    }

    public int a(int i2, int i3, boolean z2) {
        while (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) this.f14738z) && ((ComicChapter) this.f14738z.get(i2)).getIndex() + 1 < i3) {
            try {
                i2 = z2 ? i2 - 1 : i2 + 2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return i2;
    }

    private void a(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(8);
        }
    }
}
