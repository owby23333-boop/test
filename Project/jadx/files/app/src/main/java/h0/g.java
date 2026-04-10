package h0;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.gson.Gson;
import com.sntech.x2.Cif;
import com.sntech.x2.basics.upgrade.beans.ApkInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: compiled from: Upgrade.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static g f20829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicBoolean f20830h = new AtomicBoolean(false);
    public ApkInfo b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f20831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AlertDialog f20832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f20833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f20834f = new Handler(Looper.getMainLooper(), new a());
    public Context a = Cif.m154do();

    /* JADX INFO: compiled from: Upgrade.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        @RequiresApi(api = 19)
        @SuppressLint({"SetTextI18n"})
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.a((ApkInfo) message.obj);
            } else if (i2 == 2) {
                double dDoubleValue = ((Double) message.obj).doubleValue();
                g.this.f20833e.b.setVisibility(0);
                int i3 = (int) dDoubleValue;
                g.this.f20833e.f20836c.setProgress(i3);
                g.this.f20833e.f20837d.setText(i3 + "%");
            } else if (i2 == 3) {
                Toast.makeText(g.this.a, (String) message.obj, 1).show();
                g.this.f20833e.b.setVisibility(8);
                g.this.f20833e.f20836c.setProgress(0);
                g.this.f20833e.f20837d.setText("0%");
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: Upgrade.java */
    public class b {
        public TextView a;
        public View b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ProgressBar f20836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f20837d;

        public b(g gVar) {
        }
    }

    /* JADX INFO: compiled from: Upgrade.java */
    public class c implements h.b {
        public c() {
        }

        public void a() {
            g.f20830h.set(false);
            g.this.f20832d.getButton(-1).setText("立即安装");
            g gVar = g.this;
            ApkInfo apkInfo = gVar.b;
            if (apkInfo == null || gVar.f20831c == null) {
                return;
            }
            gVar.a(apkInfo.getMd5(), g.this.f20831c);
        }
    }

    public static g a() {
        if (f20829g == null) {
            synchronized (g.class) {
                if (f20829g == null) {
                    f20829g = new g();
                }
            }
        }
        return f20829g;
    }

    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ApkInfo apkInfo) throws Throwable {
        BufferedSink bufferedSinkBuffer;
        try {
            f20830h.set(true);
            File fileA = j.a.a(this.a, true);
            this.f20831c = fileA;
            String downloadURL = apkInfo.getDownloadURL();
            c cVar = new c();
            try {
                bufferedSinkBuffer = Okio.buffer(Okio.sink(fileA));
            } catch (Throwable th) {
                th = th;
                bufferedSinkBuffer = null;
            }
            try {
                new h.a(new h.c(bufferedSinkBuffer.outputStream(), cVar), null).b(downloadURL);
                bufferedSinkBuffer.close();
                try {
                    bufferedSinkBuffer.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused) {
            f20830h.set(false);
            Handler handler = this.f20834f;
            handler.sendMessage(Message.obtain(handler, 3, "下载出现错误，请重试"));
        }
    }

    @RequiresApi(api = 19)
    public final void a(final ApkInfo apkInfo) {
        Activity activity;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
        for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
            Class<?> cls2 = obj.getClass();
            Field declaredField2 = cls2.getDeclaredField("paused");
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                activity = (Activity) declaredField3.get(obj);
                break;
            }
            activity = null;
        }
        activity = null;
        if (activity == null || apkInfo == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        int iA = r.a.a(this.a, 25.0f);
        linearLayout.setPadding(iA, iA, iA, iA);
        TextView textView = new TextView(this.a);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextColor(Color.parseColor("#FF078666"));
        textView.setTextSize(20.0f);
        textView.setTypeface(null, 1);
        TextView textView2 = new TextView(this.a);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.topMargin = r.a.a(this.a, 10.0f);
        textView2.setLayoutParams(marginLayoutParams);
        textView2.setTextColor(Color.parseColor("#FF333333"));
        textView2.setTextSize(16.0f);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
        linearLayout2.setLayoutParams(marginLayoutParams2);
        linearLayout2.setOrientation(0);
        linearLayout2.setVisibility(8);
        ProgressBar progressBar = new ProgressBar(this.a, null, R.style.Widget.ProgressBar.Horizontal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, r.a.a(this.a, 6.0f));
        layoutParams.gravity = 16;
        layoutParams.weight = 9.0f;
        progressBar.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT >= 29) {
            progressBar.setMinWidth(r.a.a(this.a, 6.0f));
            progressBar.setMinHeight(r.a.a(this.a, 6.0f));
        }
        progressBar.setProgress(0);
        float[] fArr = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(Color.parseColor("#FFFDC800"));
        ClipDrawable clipDrawable = new ClipDrawable(shapeDrawable, 3, 1);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable2.getPaint().setColor(Color.parseColor("#FF666666"));
        progressBar.setProgressDrawable(clipDrawable);
        progressBar.setBackground(shapeDrawable2);
        progressBar.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.progress_horizontal));
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = r.a.a(this.a, 0.5f);
        layoutParams2.leftMargin = r.a.a(this.a, 12.0f);
        layoutParams2.weight = 1.0f;
        textView3.setLayoutParams(layoutParams2);
        textView3.setTextColor(Color.parseColor("#FF333333"));
        textView3.setTextSize(14.0f);
        linearLayout2.addView(progressBar);
        linearLayout2.addView(textView3);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(linearLayout2);
        b bVar = new b(this);
        this.f20833e = bVar;
        bVar.a = textView2;
        bVar.b = linearLayout2;
        bVar.f20836c = progressBar;
        bVar.f20837d = textView3;
        textView.setText(apkInfo.getTitle());
        this.f20833e.a.setText(apkInfo.getText());
        builder.setCancelable(!apkInfo.isForceUpgrade());
        builder.setView(linearLayout);
        builder.setPositiveButton(apkInfo.getConfirmBtn(), (DialogInterface.OnClickListener) null);
        if (!apkInfo.isForceUpgrade()) {
            builder.setNegativeButton(apkInfo.getCancelBtn(), new DialogInterface.OnClickListener() { // from class: h0.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    g.a(dialogInterface, i2);
                }
            });
        }
        AlertDialog alertDialog = this.f20832d;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog alertDialogShow = builder.show();
            this.f20832d = alertDialogShow;
            alertDialogShow.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: h0.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20821s.a(apkInfo, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HashMap map) {
        ApkInfo apkInfo;
        String strA;
        g gVarA = a();
        gVarA.getClass();
        try {
            strA = f.a.a(z.a.b, map);
        } catch (Exception unused) {
        }
        if (strA != null) {
            apkInfo = (ApkInfo) new Gson().fromJson(strA, ApkInfo.class);
            gVarA.b = apkInfo;
        } else {
            apkInfo = null;
        }
        if (apkInfo == null || !apkInfo.hasUpgrade()) {
            return;
        }
        Handler handler = this.f20834f;
        handler.sendMessageDelayed(Message.obtain(handler, 1, apkInfo), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        Toast.makeText(this.a, "Apk安全信息错误，安装失败。", 1).show();
    }

    @RequiresApi(api = 19)
    public void a(final HashMap<String, Object> map) {
        if (f20830h.get()) {
            a(this.b);
        } else {
            new Thread(new Runnable() { // from class: h0.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20819s.b(map);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final ApkInfo apkInfo, View view) {
        if (f20830h.get()) {
            Toast.makeText(this.a, "正在下载中，请稍后再试", 1).show();
        } else if (this.f20832d.getButton(-1).getText() == "立即安装") {
            a(apkInfo.getMd5(), this.f20831c);
        } else {
            new Thread(new Runnable() { // from class: h0.d
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f20823s.b(apkInfo);
                }
            }).start();
        }
    }

    public final void a(final String str, final File file) {
        new Thread(new Runnable() { // from class: h0.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f20825s.a(file, str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        String string = null;
        if (file != null && file.isFile()) {
            byte[] bArr = new byte[1024];
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            while (true) {
                try {
                    try {
                        int i2 = fileInputStream.read(bArr, 0, 1024);
                        if (i2 == -1) {
                            break;
                        } else {
                            messageDigest.update(bArr, 0, i2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (str == null) {
                    }
                    this.f20834f.post(new Runnable() { // from class: h0.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f20818s.b();
                        }
                    });
                }
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            fileInputStream.close();
            try {
                fileInputStream.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            if (bArrDigest != null && bArrDigest.length > 0) {
                for (byte b2 : bArrDigest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(hexString);
                }
                string = sb.toString();
            }
        }
        if (str == null && str.equalsIgnoreCase(string)) {
            r.b.a(this.a, file);
        } else {
            this.f20834f.post(new Runnable() { // from class: h0.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20818s.b();
                }
            });
        }
    }
}
