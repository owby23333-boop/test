package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.cz.CzOrderBean;
import com.amgcyo.cuttadon.utils.otherutils.ScannerUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fatcatfat.io.R;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: QRCodeDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class k1 extends Dialog {
    private LinearLayout A;
    private CountDownTimer B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f4730s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f4731t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Context f4732u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f4733v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f4734w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f4735x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f4736y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f4737z;

    /* JADX INFO: compiled from: QRCodeDialog.java */
    class a extends CountDownTimer {
        a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (k1.this.f4733v != null) {
                k1.this.f4733v.setText("订单已过期，请重新下单\n或检查是否完成充值！");
                k1.this.f4736y.setText(com.amgcyo.cuttadon.f.o.d(R.string.restart_order));
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            if (k1.this.f4733v != null) {
                long j3 = j2 - ((j2 / 86400000) * 86400000);
                long j4 = j3 / 3600000;
                long j5 = j3 - (3600000 * j4);
                long j6 = j5 / 60000;
                long j7 = (j5 - (60000 * j6)) / 1000;
                if (j4 <= 0) {
                    k1.this.f4733v.setText(String.format("支付剩余时间：%s", j6 + "分" + j7 + "秒"));
                    return;
                }
                k1.this.f4733v.setText(String.format("支付剩余时间：%s", j4 + "小时" + j6 + "分" + j7 + "秒"));
            }
        }
    }

    /* JADX INFO: compiled from: QRCodeDialog.java */
    class b implements com.bumptech.glide.request.g<Bitmap> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ String f4738s;

        /* JADX INFO: compiled from: QRCodeDialog.java */
        class a implements com.hjq.permissions.a {
            final /* synthetic */ Bitmap a;
            final /* synthetic */ boolean[] b;

            a(Bitmap bitmap, boolean[] zArr) {
                this.a = bitmap;
                this.b = zArr;
            }

            @Override // com.hjq.permissions.a
            public void a(List<String> list, boolean z2) {
                this.b[0] = false;
                if (k1.this.f4733v != null) {
                    k1.this.f4733v.setVisibility(0);
                }
                com.amgcyo.cuttadon.f.o.b("二维码保存到相册失败，请授予存储权限后重试！");
            }

            @Override // com.hjq.permissions.a
            public void b(List<String> list, boolean z2) {
                k1.this.a(this.a, this.b);
            }
        }

        b(String str) {
            this.f4738s = str;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Bitmap> jVar, boolean z2) {
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Bitmap bitmap, Object obj, com.bumptech.glide.request.k.j<Bitmap> jVar, DataSource dataSource, boolean z2) {
            if (bitmap != null) {
                boolean[] zArr = new boolean[1];
                if (com.amgcyo.cuttadon.utils.otherutils.i0.a()) {
                    zArr[0] = com.amgcyo.cuttadon.utils.otherutils.z.a(k1.this.f4732u, bitmap, this.f4738s, "image/jpeg");
                    if (zArr[0]) {
                        com.amgcyo.cuttadon.f.o.b("已成功保存二维码到相册");
                        if (k1.this.f4733v != null) {
                            k1.this.f4733v.setVisibility(0);
                        }
                    }
                } else if (com.hjq.permissions.f.a(k1.this.f4732u, com.amgcyo.cuttadon.f.n.f3693g)) {
                    k1.this.a(bitmap, zArr);
                } else {
                    com.hjq.permissions.f fVarA = com.hjq.permissions.f.a(k1.this.f4732u);
                    fVarA.a(com.amgcyo.cuttadon.f.n.f3693g);
                    fVarA.a(new a(bitmap, zArr));
                }
            }
            return false;
        }
    }

    public k1(Context context) {
        super(context, R.style.QRWaitDialog);
        this.f4732u = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_qrcode);
        Window window = getWindow();
        if (window != null) {
            Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            double width = defaultDisplay.getWidth();
            Double.isNaN(width);
            attributes.width = (int) (width * 0.85d);
            window.setAttributes(attributes);
        }
        a();
    }

    private void a() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f4730s = (ImageView) findViewById(R.id.qrcode);
        this.f4731t = (ImageView) findViewById(R.id.iv_close);
        this.f4733v = (TextView) findViewById(R.id.tv);
        this.A = (LinearLayout) findViewById(R.id.ll_button);
        this.f4734w = (TextView) findViewById(R.id.tv_title);
        this.f4735x = (TextView) findViewById(R.id.tv_desc);
        this.f4736y = (TextView) findViewById(R.id.tv_finish);
        this.f4737z = (TextView) findViewById(R.id.tv_help);
    }

    public void a(CzOrderBean czOrderBean, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        String str2;
        String str3;
        String pay_url = czOrderBean.getPay_url();
        if (TextUtils.isEmpty(str)) {
            str2 = "购买免广告套餐";
        } else {
            str2 = "购买" + str + "套餐";
        }
        int pay_type = czOrderBean.getPay_type();
        long jCurrentTimeMillis = System.currentTimeMillis() - com.anythink.expressad.exoplayer.i.a.f9492f;
        String pay_end_time = czOrderBean.getPay_end_time();
        long jB = com.amgcyo.cuttadon.utils.otherutils.t0.b();
        String str4 = "时区差：" + jB + " 当前时间：" + com.amgcyo.cuttadon.utils.otherutils.t0.d(jCurrentTimeMillis) + " 过期时间：" + pay_end_time;
        long jA = com.amgcyo.cuttadon.utils.otherutils.t0.a(pay_end_time) - jB;
        long j2 = ((jA - jCurrentTimeMillis) / 1000) / 60;
        String str5 = jA + "  " + jCurrentTimeMillis + " 两个时间差为：" + j2 + "分钟";
        if (2 == pay_type) {
            this.f4730s.setVisibility(8);
            Toast.makeText(this.f4732u, "正在打开支付页面...", 0).show();
            com.amgcyo.cuttadon.view.webview.b.startActivity(this.f4732u, pay_url);
            int iA = com.amgcyo.cuttadon.utils.otherutils.n.a(20.0f);
            com.amgcyo.cuttadon.f.o.a(this.f4735x, iA, iA, iA, iA);
            str3 = "请在新打开的支付页面完成充值";
        } else {
            this.f4730s.setVisibility(0);
            a(pay_url, str2);
            str3 = "支付方式说明\n1，让好友帮忙扫码支付；\n2，打开自己的“微信”或“支付宝”中的【扫一扫】功能，然后点击从【相册】内选择二维码识别并支付。";
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f4734w.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f4735x.setText(str3);
        }
        this.A.setVisibility(0);
        this.f4731t.setVisibility(4);
        this.f4731t.setOnClickListener(onClickListener);
        this.f4736y.setOnClickListener(onClickListener);
        this.f4737z.setOnClickListener(onClickListener2);
        long millis = TimeUnit.MINUTES.toMillis(j2);
        String str6 = "toMillis:" + millis;
        this.f4733v.setVisibility(0);
        this.B = new a(millis, 1000L);
        this.B.start();
    }

    public void a(String str, String str2) {
        Context context;
        if (this.f4730s == null || (context = this.f4732u) == null) {
            return;
        }
        com.bumptech.glide.c.e(context).asBitmap().mo49load(str).listener(new b(str2)).apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.bitmapTransform(new com.bumptech.glide.load.resource.bitmap.w(8)).placeholder(R.drawable.icon_pic_def)).into(this.f4730s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, boolean[] zArr) {
        zArr[0] = ScannerUtils.a(this.f4732u, "share_qrcode", bitmap, ScannerUtils.ScannerType.RECEIVER);
        if (zArr[0]) {
            com.amgcyo.cuttadon.f.o.b("已成功保存二维码到相册");
            TextView textView = this.f4733v;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }
}
