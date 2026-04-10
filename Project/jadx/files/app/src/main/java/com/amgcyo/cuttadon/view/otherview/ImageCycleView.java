package com.amgcyo.cuttadon.view.otherview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7BannerBeanDataBean;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ImageCycleView extends FrameLayout {
    private float A;
    private h B;
    private boolean C;
    private long D;
    private Handler E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4979s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private e f4980t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<f> f4981u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private g f4982v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private LinearLayout f4983w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4984x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Bitmap f4985y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Bitmap f4986z;

    public enum IndicationStyle {
        COLOR,
        IMAGE
    }

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (ImageCycleView.this.f4980t != null) {
                ImageCycleView.this.f4980t.setCurrentItem(ImageCycleView.this.f4980t.getCurrentItem() + 1);
                ImageCycleView.this.E.sendEmptyMessageDelayed(0, ImageCycleView.this.D);
            }
            return false;
        }
    }

    class b extends ViewOutlineProvider {
        final /* synthetic */ int a;

        b(ImageCycleView imageCycleView, int i2) {
            this.a = i2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c extends PagerAdapter {
        private c() {
        }

        public /* synthetic */ void a(f fVar, View view) {
            if (ImageCycleView.this.B != null) {
                ImageCycleView.this.B.a(view, fVar);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            final f fVar = (f) ImageCycleView.this.f4981u.get(i2 % ImageCycleView.this.f4984x);
            ImageView imageViewA = ImageCycleView.this.f4982v.a(fVar);
            imageViewA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageViewA.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViewA.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.otherview.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f5102s.a(fVar, view);
                }
            });
            viewGroup.addView(imageViewA);
            return imageViewA;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* synthetic */ c(ImageCycleView imageCycleView, a aVar) {
            this();
        }
    }

    public class e extends ViewPager {
        public e(ImageCycleView imageCycleView, Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
            return super.onInterceptHoverEvent(motionEvent);
        }

        @Override // androidx.viewpager.widget.ViewPager, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }
    }

    public interface g {
        ImageView a(f fVar);
    }

    public interface h {
        void a(int i2);

        void a(View view, f fVar);
    }

    public ImageCycleView(Context context) {
        super(context);
        this.f4981u = new ArrayList();
        this.f4984x = 0;
        this.A = 0.5f;
        this.C = true;
        this.D = com.anythink.expressad.video.module.a.a.m.ag;
        this.E = new Handler(new a());
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.C) {
                a();
            }
        } else if (this.C) {
            b();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setAutoCycle(Boolean bool) {
        this.C = bool.booleanValue();
    }

    public void setCycleDelayed(long j2) {
        this.D = j2;
    }

    public void setOnPageClickListener(h hVar) {
        this.B = hVar;
    }

    private final class d implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f4991s;

        private d() {
            this.f4991s = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            int i3 = i2 % ImageCycleView.this.f4984x;
            try {
                ((ImageView) ImageCycleView.this.f4983w.getChildAt(this.f4991s)).setImageBitmap(ImageCycleView.this.f4985y);
                ((ImageView) ImageCycleView.this.f4983w.getChildAt(i3)).setImageBitmap(ImageCycleView.this.f4986z);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f4991s = i3;
            if (ImageCycleView.this.B != null) {
                ImageCycleView.this.B.a(i3);
            }
        }

        /* synthetic */ d(ImageCycleView imageCycleView, a aVar) {
            this();
        }
    }

    private void a(Context context) {
        this.f4979s = context;
        this.f4985y = a(50, com.amgcyo.cuttadon.f.o.b(R.color.color_f5f5f5));
        this.f4986z = a(50, com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
        d();
    }

    private void c() {
        this.f4983w.removeAllViews();
        for (int i2 = 0; i2 < this.f4984x; i2++) {
            ImageView imageView = new ImageView(this.f4979s);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f4983w.getLayoutParams().height, -1);
            layoutParams.leftMargin = (int) (this.f4983w.getLayoutParams().height * this.A);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setAdjustViewBounds(true);
            imageView.setLayoutParams(layoutParams);
            if (i2 == 0) {
                imageView.setImageBitmap(this.f4986z);
            } else {
                imageView.setImageBitmap(this.f4985y);
            }
            this.f4983w.addView(imageView);
        }
    }

    private void d() {
        View.inflate(this.f4979s, R.layout.mk_view_image_cycle, this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_image_cycle);
        this.f4980t = new e(this, this.f4979s);
        if (com.amgcyo.cuttadon.utils.otherutils.h.E0()) {
            a(this.f4980t, 25);
        }
        this.f4980t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(this.f4980t);
        this.f4980t.addOnPageChangeListener(new d(this, null));
        this.f4983w = (LinearLayout) findViewById(R.id.ll_indication_group);
    }

    public void b() {
        this.E.removeCallbacksAndMessages(null);
    }

    public static class f {
        public String a;
        public V7BannerBeanDataBean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4993c;

        public f(String str, String str2, int i2, V7BannerBeanDataBean v7BannerBeanDataBean) {
            this.a = str;
            this.b = v7BannerBeanDataBean;
            this.f4993c = i2;
        }

        public f(String str, String str2, int i2, int i3, V7BannerBeanDataBean v7BannerBeanDataBean) {
            this.a = str;
            this.b = v7BannerBeanDataBean;
            this.f4993c = i2;
        }
    }

    public void a(IndicationStyle indicationStyle, int i2, int i3, float f2) {
        if (indicationStyle == IndicationStyle.COLOR) {
            this.f4985y = a(30, i2);
            this.f4986z = a(30, i3);
        } else if (indicationStyle == IndicationStyle.IMAGE) {
            this.f4985y = BitmapFactory.decodeResource(this.f4979s.getResources(), i2);
            this.f4986z = BitmapFactory.decodeResource(this.f4979s.getResources(), i3);
        }
        this.A = f2;
        c();
    }

    public ImageCycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4981u = new ArrayList();
        this.f4984x = 0;
        this.A = 0.5f;
        this.C = true;
        this.D = com.anythink.expressad.video.module.a.a.m.ag;
        this.E = new Handler(new a());
        a(context);
    }

    public void a(List<f> list, g gVar) {
        this.f4981u = list;
        this.f4984x = list.size();
        c();
        this.f4982v = gVar;
        this.f4980t.setAdapter(new c(this, null));
        this.f4980t.setCurrentItem(this.f4984x * 1000);
    }

    private Bitmap a(int i2, int i3) {
        Paint paint = new Paint(1);
        paint.setColor(i3);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_4444);
        float f2 = i2 / 3;
        new Canvas(bitmapCreateBitmap).drawCircle(f2, f2, f2, paint);
        return bitmapCreateBitmap;
    }

    public void a() {
        this.E.sendEmptyMessageDelayed(0, this.D);
    }

    @TargetApi(21)
    public void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21 && view != null && i2 > 0) {
            view.setOutlineProvider(new b(this, i2));
            view.setClipToOutline(true);
        }
    }
}
