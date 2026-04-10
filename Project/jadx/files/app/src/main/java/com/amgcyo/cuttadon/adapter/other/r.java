package com.amgcyo.cuttadon.adapter.other;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.widget.ui.SmoothCheckBox;
import com.amgcyo.cuttadon.widget.util.NoUnderlineSpan;
import com.fatcatfat.io.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MkTtsSaltedFishPagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends PagerAdapter implements View.OnClickListener {
    private SmoothCheckBox A;
    private SmoothCheckBox B;
    private SmoothCheckBox C;
    private SmoothCheckBox D;
    private LinearLayout E;
    private SmoothCheckBox F;
    private SmoothCheckBox G;
    private SmoothCheckBox H;
    private SmoothCheckBox I;
    private SmoothCheckBox J;
    private SmoothCheckBox K;
    private SmoothCheckBox L;
    private SmoothCheckBox M;
    private LinearLayout N;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private SparseArray<String> f3095s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Context f3096t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.amgcyo.cuttadon.j.e.c f3097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SparseArray<View> f3098v = new SparseArray<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3099w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3100x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.amgcyo.cuttadon.view.read.page.k f3101y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private SmoothCheckBox f3102z;

    /* JADX INFO: compiled from: MkTtsSaltedFishPagerAdapter.java */
    class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            com.amgcyo.cuttadon.utils.otherutils.g.e((Activity) r.this.f3096t);
        }
    }

    public r(Context context, SparseArray<String> sparseArray, com.amgcyo.cuttadon.view.read.page.k kVar, com.amgcyo.cuttadon.j.e.c cVar, int i2, int i3) {
        this.f3095s = sparseArray;
        this.f3096t = context;
        this.f3101y = kVar;
        this.f3097u = cVar;
        this.f3099w = i2;
        this.f3100x = i3;
    }

    @NotNull
    private View b() {
        View viewInflate = View.inflate(this.f3096t, R.layout.ttstime_list_item, null);
        int iR = this.f3101y.r();
        this.f3102z = (SmoothCheckBox) viewInflate.findViewById(R.id.smoothcheckbox15);
        this.A = (SmoothCheckBox) viewInflate.findViewById(R.id.smoothcheckbox30);
        this.B = (SmoothCheckBox) viewInflate.findViewById(R.id.smoothcheckbox60);
        this.C = (SmoothCheckBox) viewInflate.findViewById(R.id.smoothcheckbox90);
        this.D = (SmoothCheckBox) viewInflate.findViewById(R.id.smoothcheckbox_close);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linearlayout15);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.linearlayout30);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.linearlayout60);
        LinearLayout linearLayout4 = (LinearLayout) viewInflate.findViewById(R.id.linearlayout90);
        LinearLayout linearLayout5 = (LinearLayout) viewInflate.findViewById(R.id.linearlayout_close);
        this.E = (LinearLayout) viewInflate.findViewById(R.id.ll_time_root);
        if (iR == 1) {
            a(this.E, this.f3102z);
        } else if (iR == 2) {
            a(this.E, this.A);
        } else if (iR == 3) {
            a(this.E, this.B);
        } else if (iR != 4) {
            a(this.E, this.D);
        } else {
            a(this.E, this.C);
        }
        if (this.f3097u != null) {
            this.f3102z.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.B.setOnClickListener(this);
            this.C.setOnClickListener(this);
            this.D.setOnClickListener(this);
            linearLayout.setOnClickListener(this);
            linearLayout2.setOnClickListener(this);
            linearLayout3.setOnClickListener(this);
            linearLayout4.setOnClickListener(this);
            linearLayout5.setOnClickListener(this);
        }
        return viewInflate;
    }

    @NotNull
    private View c() {
        View viewInflate = View.inflate(this.f3096t, R.layout.ttsvoicerfragment, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_voicer);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_tts_tips);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_desc);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_default_rate);
        if (this.f3099w == 0) {
            String strD = g0.a().d("phone_tts_name");
            textView3.setVisibility(8);
            textView.setVisibility(8);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.other.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3081s.a(view);
                }
            });
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "阅读下方指引步骤后再").append((CharSequence) "#点击此处#").append((CharSequence) "跳转到【文字转语音TTS】设置页面；\n").append((CharSequence) "1，先将首选引擎设置成您选择的【").append((CharSequence) strD).append((CharSequence) "】引擎；如果已经设置请忽略此步骤；\n").append((CharSequence) "2，然后点击图示的“设置图标”区域进入到引擎对应的设置页面；\n").append((CharSequence) "3，找到含有“发音人”等字样的菜单进行操作即可；\n").append((CharSequence) "4，也可根据下方图片指引进入到对应的语音合成引擎设置页面设置；\n").append((CharSequence) "温馨提示：\n1，设置成功后将下一段落生效；\n2，部分语音合成引擎可能不支持发音人设置。");
            spannableStringBuilder.setSpan(new a(), 10, 16, 33);
            spannableStringBuilder.setSpan(new NoUnderlineSpan(), 10, 16, 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary)), 10, 16, 33);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(spannableStringBuilder);
        } else {
            textView2.setText(com.amgcyo.cuttadon.f.o.d(R.string.listener_type_1));
            textView3.setVisibility(0);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.other.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3080s.b(view);
                }
            });
        }
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f3095s.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i2) {
        return this.f3095s.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        if (this.f3098v.size() > i2 && this.f3098v.get(i2) != null) {
            return this.f3098v.get(i2);
        }
        View viewA = i2 == 0 ? this.f3100x == 0 ? a() : c() : b();
        viewA.setFitsSystemWindows(true);
        this.f3098v.put(i2, viewA);
        viewGroup.addView(viewA, new ViewGroup.LayoutParams(-1, -1));
        return viewA;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r2) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.adapter.other.r.onClick(android.view.View):void");
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.utils.otherutils.g.e((Activity) this.f3096t);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0128  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View a() {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.adapter.other.r.a():android.view.View");
    }

    public /* synthetic */ void b(View view) {
        com.amgcyo.cuttadon.j.e.c cVar = this.f3097u;
        if (cVar != null) {
            cVar.b();
        }
    }

    private void a(ViewGroup viewGroup, SmoothCheckBox smoothCheckBox) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, smoothCheckBox);
            } else if (childAt instanceof SmoothCheckBox) {
                childAt.setEnabled(true);
                ((SmoothCheckBox) childAt).setChecked(false);
                smoothCheckBox.setEnabled(false);
                smoothCheckBox.setChecked(true);
            }
        }
    }

    private void a(int i2, SmoothCheckBox smoothCheckBox) {
        if (smoothCheckBox.isChecked()) {
            return;
        }
        a(this.E, smoothCheckBox);
        if (this.f3097u != null) {
            this.f3101y.k(i2);
            this.f3097u.a(i2);
        }
    }

    private void a(String str, SmoothCheckBox smoothCheckBox) {
        if (this.f3097u == null) {
            return;
        }
        a(this.N, smoothCheckBox);
        this.f3101y.a(str);
        this.f3097u.a();
    }
}
