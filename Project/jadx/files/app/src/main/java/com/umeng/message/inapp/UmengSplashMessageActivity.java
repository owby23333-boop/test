package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.UImageLoadTask;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.m;
import com.umeng.message.proguard.w;
import com.umeng.message.proguard.x;
import java.io.File;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UmengSplashMessageActivity extends Activity {
    private static final String a = UmengSplashMessageActivity.class.getName();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f20315s = 2000;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static int f20316t = 1000;
    private Activity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UImageLoadTask f20317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView f20318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f20319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f20320f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f20323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f20324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private UInAppMessage f20325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private UInAppHandler f20326l;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f20331q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f20332r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f20321g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20322h = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f20327m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f20328n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f20329o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f20330p = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private UImageLoadTask.ImageLoaderCallback f20333u = new UImageLoadTask.ImageLoaderCallback() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1
        @Override // com.umeng.message.inapp.UImageLoadTask.ImageLoaderCallback
        public void onLoadImage(Bitmap[] bitmapArr) {
            if (UmengSplashMessageActivity.this.e()) {
                return;
            }
            if (UmengSplashMessageActivity.this.f20323i != null) {
                UmengSplashMessageActivity.this.f20323i.a();
                UmengSplashMessageActivity.this.f20323i = null;
            }
            try {
                if (bitmapArr.length == 1) {
                    UmengSplashMessageActivity.this.f20318d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            UmengSplashMessageActivity.this.f20327m = true;
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f20325k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.this.f20332r += SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f20331q;
                            x.a(UmengSplashMessageActivity.this.b).a(UmengSplashMessageActivity.this.f20325k.msg_id, UmengSplashMessageActivity.this.f20325k.msg_type, 1, 1, 0, 0, 0, (int) UmengSplashMessageActivity.this.f20332r, 0);
                            UmengSplashMessageActivity.this.f();
                            UmengSplashMessageActivity.this.f20326l.handleInAppMessage(UmengSplashMessageActivity.this.b, UmengSplashMessageActivity.this.f20325k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f20319e.setVisibility(8);
                    UmengSplashMessageActivity.this.f20318d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.this.a(UmengSplashMessageActivity.this.f20318d);
                }
                if (bitmapArr.length == 2) {
                    UmengSplashMessageActivity.this.f20318d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            UmengSplashMessageActivity.this.f20328n = true;
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f20325k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.this.f20332r += SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f20331q;
                            x xVarA = x.a(UmengSplashMessageActivity.this.b);
                            String str = UmengSplashMessageActivity.this.f20325k.msg_id;
                            int i2 = UmengSplashMessageActivity.this.f20325k.msg_type;
                            UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                            xVarA.a(str, i2, 1, 0, 1, umengSplashMessageActivity.a(umengSplashMessageActivity.f20329o), 0, (int) UmengSplashMessageActivity.this.f20332r, 0);
                            UmengSplashMessageActivity.this.f();
                            UmengSplashMessageActivity.this.f20326l.handleInAppMessage(UmengSplashMessageActivity.this.b, UmengSplashMessageActivity.this.f20325k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f20319e.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            UmengSplashMessageActivity.this.f20329o = true;
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f20325k.bottom_action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.this.f20332r += SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f20331q;
                            x xVarA = x.a(UmengSplashMessageActivity.this.b);
                            String str = UmengSplashMessageActivity.this.f20325k.msg_id;
                            int i2 = UmengSplashMessageActivity.this.f20325k.msg_type;
                            UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                            xVarA.a(str, i2, 1, 0, umengSplashMessageActivity.a(umengSplashMessageActivity.f20328n), 1, 0, (int) UmengSplashMessageActivity.this.f20332r, 0);
                            UmengSplashMessageActivity.this.f();
                            UmengSplashMessageActivity.this.f20326l.handleInAppMessage(UmengSplashMessageActivity.this.b, UmengSplashMessageActivity.this.f20325k, 17);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f20318d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.this.f20319e.setImageBitmap(bitmapArr[1]);
                    UmengSplashMessageActivity.this.a(UmengSplashMessageActivity.this.f20318d);
                    UmengSplashMessageActivity.this.a(UmengSplashMessageActivity.this.f20319e);
                }
                UmengSplashMessageActivity.this.f20331q = SystemClock.elapsedRealtime();
                if (UmengSplashMessageActivity.this.f20325k.display_button) {
                    UmengSplashMessageActivity.this.f20320f.setVisibility(0);
                    UmengSplashMessageActivity.this.f20320f.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            UmengSplashMessageActivity.this.f20332r += SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f20331q;
                            x xVarA = x.a(UmengSplashMessageActivity.this.b);
                            String str = UmengSplashMessageActivity.this.f20325k.msg_id;
                            int i2 = UmengSplashMessageActivity.this.f20325k.msg_type;
                            UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                            int iA = umengSplashMessageActivity.a(umengSplashMessageActivity.f20327m);
                            UmengSplashMessageActivity umengSplashMessageActivity2 = UmengSplashMessageActivity.this;
                            int iA2 = umengSplashMessageActivity2.a(umengSplashMessageActivity2.f20328n);
                            UmengSplashMessageActivity umengSplashMessageActivity3 = UmengSplashMessageActivity.this;
                            xVarA.a(str, i2, 1, iA, iA2, umengSplashMessageActivity3.a(umengSplashMessageActivity3.f20329o), 1, (int) UmengSplashMessageActivity.this.f20332r, 0);
                            UmengSplashMessageActivity.this.f();
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                } else {
                    UmengSplashMessageActivity.this.f20320f.setVisibility(8);
                }
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).a(UmengSplashMessageActivity.this.f20325k);
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).a(UmengSplashMessageActivity.this.f20325k.msg_id, 1);
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).h();
                UmengSplashMessageActivity.this.f20321g = false;
                UmengSplashMessageActivity.this.f20324j = UmengSplashMessageActivity.this.new a(UmengSplashMessageActivity.this.f20325k.display_time * 1000, UmengSplashMessageActivity.f20316t);
                UmengSplashMessageActivity.this.f20324j.b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private IUmengInAppMessageCallback f20334v = new IUmengInAppMessageCallback() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.2
        @Override // com.umeng.message.inapp.IUmengInAppMessageCallback
        public void onCardMessage(UInAppMessage uInAppMessage) {
        }

        @Override // com.umeng.message.inapp.IUmengInAppMessageCallback
        public void onSplashMessage(UInAppMessage uInAppMessage) {
            UInAppMessage uInAppMessage2;
            String strE = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).e();
            if (TextUtils.isEmpty(strE)) {
                uInAppMessage2 = null;
            } else {
                try {
                    uInAppMessage2 = new UInAppMessage(new JSONObject(strE));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    uInAppMessage2 = null;
                }
            }
            if (uInAppMessage != null) {
                if (uInAppMessage2 != null && !uInAppMessage.msg_id.equals(uInAppMessage2.msg_id)) {
                    InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).a(new File(l.a(UmengSplashMessageActivity.this.b, uInAppMessage2.msg_id)));
                }
                UmengSplashMessageActivity.this.f20325k = uInAppMessage;
            } else if (uInAppMessage2 == null) {
                return;
            } else {
                UmengSplashMessageActivity.this.f20325k = uInAppMessage2;
            }
            if (UmengSplashMessageActivity.this.f20325k.show_type == 1 && !UmengSplashMessageActivity.this.g()) {
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).a(UmengSplashMessageActivity.this.f20325k.msg_id, 0);
            }
            if (InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).b(UmengSplashMessageActivity.this.f20325k) && InAppMessageManager.getInstance(UmengSplashMessageActivity.this.b).c(UmengSplashMessageActivity.this.f20325k)) {
                if (UmengSplashMessageActivity.this.f20325k.msg_type == 0) {
                    UMLog.mutlInfo(UmengSplashMessageActivity.a, 2, "SPLASH_A");
                    UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                    umengSplashMessageActivity.f20317c = new UImageLoadTask(umengSplashMessageActivity.b, UmengSplashMessageActivity.this.f20325k);
                    UmengSplashMessageActivity.this.f20317c.a(UmengSplashMessageActivity.this.f20333u);
                    UmengSplashMessageActivity.this.f20317c.execute(UmengSplashMessageActivity.this.f20325k.image_url);
                }
                if (UmengSplashMessageActivity.this.f20325k.msg_type == 1) {
                    UMLog.mutlInfo(UmengSplashMessageActivity.a, 2, "SPLASH_B");
                    UmengSplashMessageActivity umengSplashMessageActivity2 = UmengSplashMessageActivity.this;
                    umengSplashMessageActivity2.f20317c = new UImageLoadTask(umengSplashMessageActivity2.b, UmengSplashMessageActivity.this.f20325k);
                    UmengSplashMessageActivity.this.f20317c.a(UmengSplashMessageActivity.this.f20333u);
                    UmengSplashMessageActivity.this.f20317c.execute(UmengSplashMessageActivity.this.f20325k.image_url, UmengSplashMessageActivity.this.f20325k.bottom_image_url);
                }
            }
        }
    };

    class a extends w {
        a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // com.umeng.message.proguard.w
        public void a(long j2) {
            if (UmengSplashMessageActivity.this.f20321g) {
                return;
            }
            UmengSplashMessageActivity.this.f20320f.setVisibility(0);
            TextView textView = UmengSplashMessageActivity.this.f20320f;
            StringBuilder sb = new StringBuilder();
            double d2 = j2;
            Double.isNaN(d2);
            double d3 = UmengSplashMessageActivity.f20316t;
            Double.isNaN(d3);
            sb.append((int) Math.ceil((d2 * 1.0d) / d3));
            sb.append(" ");
            sb.append(UmengSplashMessageActivity.this.f20325k.display_name);
            textView.setText(sb.toString());
        }

        @Override // com.umeng.message.proguard.w
        public void e() {
            if (UmengSplashMessageActivity.this.e() && UmengSplashMessageActivity.this.f20321g) {
                return;
            }
            if (!UmengSplashMessageActivity.this.f20321g) {
                x xVarA = x.a(UmengSplashMessageActivity.this.b);
                String str = UmengSplashMessageActivity.this.f20325k.msg_id;
                int i2 = UmengSplashMessageActivity.this.f20325k.msg_type;
                UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                int iA = umengSplashMessageActivity.a(umengSplashMessageActivity.f20327m);
                UmengSplashMessageActivity umengSplashMessageActivity2 = UmengSplashMessageActivity.this;
                int iA2 = umengSplashMessageActivity2.a(umengSplashMessageActivity2.f20328n);
                UmengSplashMessageActivity umengSplashMessageActivity3 = UmengSplashMessageActivity.this;
                xVarA.a(str, i2, 1, iA, iA2, umengSplashMessageActivity3.a(umengSplashMessageActivity3.f20329o), 0, UmengSplashMessageActivity.this.f20325k.display_time * 1000, 0);
            }
            UmengSplashMessageActivity.this.f();
            UmengSplashMessageActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(boolean z2) {
        return z2 ? 1 : 0;
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = this;
        if ((getIntent().getFlags() & 4194304) > 0) {
            finish();
            return;
        }
        if (onCustomPretreatment()) {
            return;
        }
        setRequestedOrientation(1);
        setContentView(c());
        d();
        this.f20326l = InAppMessageManager.getInstance(this.b).getInAppHandler();
        this.f20323i = new a(f20315s, f20316t);
        this.f20323i.b();
    }

    public boolean onCustomPretreatment() {
        return false;
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        a aVar = this.f20323i;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.f20324j;
        if (aVar2 != null) {
            aVar2.a();
        }
        UImageLoadTask uImageLoadTask = this.f20317c;
        if (uImageLoadTask != null) {
            uImageLoadTask.a((UImageLoadTask.ImageLoaderCallback) null);
        }
        this.f20330p = false;
        this.f20327m = false;
        this.f20328n = false;
        this.f20329o = false;
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        super.onPause();
        a aVar = this.f20323i;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f20324j != null) {
            this.f20332r += SystemClock.elapsedRealtime() - this.f20331q;
            this.f20324j.c();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a aVar = this.f20323i;
        if (aVar != null) {
            aVar.d();
        }
        if (this.f20324j != null) {
            this.f20331q = SystemClock.elapsedRealtime();
            this.f20324j.d();
        }
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (this.f20322h) {
            this.f20322h = false;
            Intent intent = new Intent();
            intent.setClassName(this.b, InAppMessageManager.getInstance(this).a());
            intent.setFlags(536870912);
            try {
                this.b.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(InAppMessageManager.getInstance(this.b).i());
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    private View c() {
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 13.0f);
        this.f20318d = new ImageView(this.b);
        this.f20318d.setLayoutParams(layoutParams);
        this.f20318d.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f20318d);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 3.0f);
        this.f20319e = new ImageView(this.b);
        this.f20319e.setLayoutParams(layoutParams2);
        this.f20319e.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f20319e);
        frameLayout.addView(linearLayout);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        layoutParams3.rightMargin = m.a(this.b, 30.0f);
        layoutParams3.topMargin = m.a(this.b, 20.0f);
        this.f20320f = new TextView(this.b);
        this.f20320f.setLayoutParams(layoutParams3);
        int iA = m.a(this.b, 6.0f);
        int i2 = iA / 3;
        this.f20320f.setPadding(iA, i2, iA, i2);
        this.f20320f.setTextSize(14.0f);
        this.f20320f.setBackgroundColor(Color.parseColor("#80000000"));
        this.f20320f.setTextColor(-1);
        this.f20320f.setVisibility(8);
        frameLayout.addView(this.f20320f);
        return frameLayout;
    }

    private void d() {
        if (InAppMessageManager.a) {
            x.a(this).a(this.f20334v);
        } else if (System.currentTimeMillis() - InAppMessageManager.getInstance(this.b).d() > InAppMessageManager.b) {
            x.a(this).a(this.f20334v);
        } else {
            this.f20334v.onSplashMessage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean e() {
        boolean z2;
        z2 = this.f20330p;
        this.f20330p = true;
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(500L);
        view.startAnimation(alphaAnimation);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
