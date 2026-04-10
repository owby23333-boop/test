package com.tencent.smtt.sdk.ui.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d extends Dialog {
    static WeakReference<ValueCallback<String>> a;
    protected List<b> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f19116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f19117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f19118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final String f19119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ListView f19120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Button f19121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Button f19122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f19123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f19124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f19125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f19126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f19127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Intent f19128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SharedPreferences f19129p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f19130q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f19131r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private FrameLayout f19132s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LinearLayout f19133t;

    public d(Context context, String str, Intent intent, Bundle bundle, ValueCallback<String> valueCallback, String str2, String str3) {
        List<b> list;
        List<b> list2;
        super(context, R.style.Theme.Dialog);
        this.f19123j = "TBSActivityPicker";
        this.f19116c = "extraMenu";
        this.f19117d = "name";
        this.f19118e = "resource_id";
        this.f19119f = "value";
        this.f19126m = "*/*";
        String str4 = null;
        this.f19129p = null;
        this.f19130q = 0;
        this.f19131r = 0;
        this.f19127n = str3;
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        TbsLog.i("TBSActivityPicker", "acts.size(): " + listQueryIntentActivities.size());
        Bundle bundle2 = bundle != null ? bundle.getBundle("extraMenu") : null;
        if (bundle2 != null) {
            this.b = new ArrayList();
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                Bundle bundle3 = bundle2.getBundle(it.next());
                if (bundle3 != null) {
                    String string = bundle3.getString("name", str4);
                    int i2 = bundle3.getInt("resource_id", -1);
                    String string2 = bundle3.getString("value", str4);
                    if (string != null && i2 != -1 && string2 != null) {
                        this.b.add(new b(getContext(), i2, string, string2));
                    }
                }
                str4 = null;
            }
        } else {
            TbsLog.i("TBSActivityPicker", "no extra menu info in bundle");
        }
        if ((listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) && (((list = this.b) == null || list.isEmpty()) && MttLoader.isBrowserInstalled(context))) {
            TbsLog.i("TBSActivityPicker", "no action has been found with Intent:" + intent.toString());
            QbSdk.isDefaultDialog = true;
        }
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && ((listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) && ((list2 = this.b) == null || list2.isEmpty()))) {
            TbsLog.i("TBSActivityPicker", "package name equal to `com.tencent.rtxlite` but no action has been found with Intent:" + intent.toString());
            QbSdk.isDefaultDialog = true;
        }
        this.f19124k = str;
        this.f19128o = intent;
        a = new WeakReference<>(valueCallback);
        this.f19129p = context.getSharedPreferences(QbSdk.SHARE_PREFERENCES_NAME, 0);
        if (!TextUtils.isEmpty(str2)) {
            this.f19126m = str2;
        }
        TbsLog.i("TBSActivityPicker", "Intent:" + this.f19126m + " MineType:" + this.f19126m);
    }

    private View a(Context context) {
        this.f19132s = new FrameLayout(context);
        this.f19133t = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, Double.valueOf(c.a(context) * 0.5f).intValue());
        layoutParams.gravity = 17;
        this.f19133t.setLayoutParams(layoutParams);
        this.f19133t.setOrientation(1);
        this.f19131r = c.a(context, 72.0f);
        com.tencent.smtt.sdk.ui.dialog.widget.a aVar = new com.tencent.smtt.sdk.ui.dialog.widget.a(context, c.a(context, 12.0f), c.a(context, 35.0f), c.a(context, 15.0f));
        aVar.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f19131r));
        aVar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        this.f19133t.addView(aVar);
        this.f19120g = new ListView(context);
        this.f19120g.setOverScrollMode(2);
        this.f19120g.setVerticalScrollBarEnabled(false);
        this.f19120g.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        this.f19120g.setLayoutParams(layoutParams2);
        this.f19120g.setDividerHeight(0);
        this.f19133t.addView(this.f19120g);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f19130q = c.a(context, 150.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, this.f19130q);
        layoutParams3.weight = 0.0f;
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setContentDescription("x5_tbs_activity_picker_btn_container");
        this.f19121h = new com.tencent.smtt.sdk.ui.dialog.widget.b(context, c.a(context, 12.0f), Color.parseColor("#EBEDF5"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, c.a(context, 90.0f));
        layoutParams4.weight = 1.0f;
        layoutParams4.topMargin = c.a(context, 30.0f);
        layoutParams4.bottomMargin = c.a(context, 30.0f);
        layoutParams4.leftMargin = c.a(context, 32.0f);
        layoutParams4.rightMargin = c.a(context, 8.0f);
        this.f19121h.setLayoutParams(layoutParams4);
        this.f19121h.setText(e.b("x5_tbs_wechat_activity_picker_label_always"));
        this.f19121h.setTextColor(Color.rgb(29, 29, 29));
        this.f19121h.setTextSize(0, c.a(context, 34.0f));
        linearLayout.addView(this.f19121h);
        this.f19122i = new com.tencent.smtt.sdk.ui.dialog.widget.b(context, c.a(context, 12.0f), Color.parseColor("#00CAFC"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, c.a(context, 90.0f));
        layoutParams5.weight = 1.0f;
        layoutParams5.topMargin = c.a(context, 30.0f);
        layoutParams5.bottomMargin = c.a(context, 30.0f);
        layoutParams5.leftMargin = c.a(context, 8.0f);
        layoutParams5.rightMargin = c.a(context, 32.0f);
        this.f19122i.setLayoutParams(layoutParams5);
        this.f19122i.setText(e.b("x5_tbs_wechat_activity_picker_label_once"));
        this.f19122i.setTextColor(Color.rgb(255, 255, 255));
        this.f19122i.setTextSize(0, c.a(context, 34.0f));
        linearLayout.addView(this.f19122i);
        this.f19133t.addView(linearLayout);
        this.f19132s.addView(this.f19133t);
        return this.f19132s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        StringBuilder sb;
        StringBuilder sb2;
        if (bVar.f()) {
            boolean zMatches = Build.CPU_ABI.matches("armeabi.*");
            if (c() && a.get() != null) {
                if (zMatches) {
                    sb2 = new StringBuilder();
                    sb2.append("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047");
                    sb2.append("&is64=0");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047");
                    sb2.append("&is64=1");
                }
                a.get().onReceiveValue(sb2.toString());
                return;
            }
            if (zMatches) {
                sb = new StringBuilder();
                sb.append("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041");
                sb.append("&is64=0");
            } else {
                sb = new StringBuilder();
                sb.append("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041");
                sb.append("&is64=1");
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            try {
                getContext().startActivity(intent);
            } catch (Throwable unused) {
                Toast.makeText(getContext(), "您的设备尚未安装QQ浏览器，请先下载", 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        ValueCallback<String> valueCallback;
        String str2;
        ValueCallback<String> valueCallback2;
        StringBuilder sb;
        String strD;
        ActivityInfo activityInfo;
        if (this.f19125l == null || !c()) {
            return;
        }
        b bVarA = this.f19125l.a();
        ResolveInfo resolveInfoA = this.f19125l.a(bVarA);
        if (a.get() != null) {
            if (bVarA != null && resolveInfoA != null && (activityInfo = resolveInfoA.activityInfo) != null && activityInfo.packageName != null) {
                valueCallback = a.get();
                str2 = str + resolveInfoA.activityInfo.packageName;
            } else {
                if (bVarA != null) {
                    if (bVarA.e()) {
                        valueCallback2 = a.get();
                        sb = new StringBuilder();
                        sb.append(str);
                        strD = bVarA.g();
                    } else {
                        if (!bVarA.f()) {
                            return;
                        }
                        valueCallback2 = a.get();
                        sb = new StringBuilder();
                        sb.append(str);
                        strD = bVarA.d();
                    }
                    sb.append(strD);
                    valueCallback2.onReceiveValue(sb.toString());
                    return;
                }
                valueCallback = a.get();
                str2 = str + "other";
            }
            valueCallback.onReceiveValue(str2);
        }
    }

    private Drawable c(String str) {
        Context context = getContext();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(context.getFilesDir(), str);
        if (!FileUtil.c(file)) {
            return null;
        }
        try {
            TbsLog.i("TBSActivityPicker", "load icon from: " + file.getAbsolutePath());
            return new BitmapDrawable(BitmapFactory.decodeFile(file.getAbsolutePath()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        String[] strArr = {TbsConfig.APP_QQ, "com.tencent.tim"};
        String packageName = getContext().getApplicationContext().getPackageName();
        for (String str : strArr) {
            if (str.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        Drawable drawableA;
        String string;
        a aVar = this.f19125l;
        String strB = null;
        b bVarA = aVar != null ? aVar.a() : null;
        SharedPreferences sharedPreferences = this.f19129p;
        if (sharedPreferences != null) {
            drawableA = c(sharedPreferences.getString("key_tbs_recommend_icon_url", null));
            string = this.f19129p.getString("key_tbs_recommend_label", null);
            String string2 = this.f19129p.getString("key_tbs_recommend_description", null);
            if (TextUtils.isEmpty(string)) {
                string = null;
            }
            if (!TextUtils.isEmpty(string2)) {
                strB = string2;
            }
        } else {
            drawableA = null;
            string = null;
        }
        if (drawableA == null) {
            drawableA = e.a("application_icon");
        }
        Drawable drawable = drawableA;
        if (string == null) {
            string = "QQ浏览器";
        }
        String str = string;
        if (strB == null) {
            strB = e.b("x5_tbs_wechat_activity_picker_label_recommend");
        }
        this.f19125l = new a(getContext(), this.f19128o, new b(getContext(), drawable, str, TbsConfig.APP_QB, strB), this.b, bVarA, this, this.f19120g);
        this.f19120g.setAdapter((ListAdapter) this.f19125l);
        e();
    }

    private void e() {
        ListAdapter adapter = this.f19120g.getAdapter();
        if (adapter == null) {
            return;
        }
        int measuredHeight = 0;
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            View view = adapter.getView(i2, null, this.f19120g);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += view.getMeasuredHeight();
        }
        float fA = c.a(getContext()) * 0.8f;
        float fA2 = c.a(getContext()) * 0.5f;
        float f2 = this.f19131r + measuredHeight + this.f19130q;
        this.f19133t.getLayoutParams().height = (f2 > fA ? Float.valueOf(fA) : f2 < fA2 ? Float.valueOf(fA2) : Float.valueOf(f2)).intValue();
    }

    public String a() {
        if (this.f19129p == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getTBSPickedDefaultBrowser: ");
        sb.append(this.f19129p.getString("key_tbs_picked_default_browser_" + this.f19126m, null));
        TbsLog.i("TBSActivityPicker", sb.toString());
        return this.f19129p.getString("key_tbs_picked_default_browser_" + this.f19126m, null);
    }

    public void a(String str) {
        SharedPreferences.Editor editorPutString;
        TbsLog.i("TBSActivityPicker", "setTBSPickedDefaultBrowser:" + str);
        if (this.f19129p != null) {
            if (TextUtils.isEmpty(str)) {
                TbsLog.i("TBSActivityPicker", "paramString empty, remove: key_tbs_picked_default_browser_" + this.f19126m);
                editorPutString = this.f19129p.edit().remove("key_tbs_picked_default_browser_" + this.f19126m);
            } else {
                TbsLog.i("TBSActivityPicker", "paramString not empty, set: key_tbs_picked_default_browser_" + this.f19126m + "=" + str);
                SharedPreferences.Editor editorEdit = this.f19129p.edit();
                StringBuilder sb = new StringBuilder();
                sb.append("key_tbs_picked_default_browser_");
                sb.append(this.f19126m);
                editorPutString = editorEdit.putString(sb.toString(), str);
            }
            editorPutString.commit();
        }
    }

    void a(boolean z2) {
        Button button = this.f19122i;
        if (button != null) {
            button.setEnabled(z2);
        }
        Button button2 = this.f19121h;
        if (button2 != null) {
            button2.setEnabled(z2);
        }
        b("userMenuClickEvent:");
    }

    public void b() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.horizontalMargin = 0.0f;
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
        }
        setContentView(a(getContext()));
        d();
        this.f19121h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVarA = d.this.f19125l.a();
                ResolveInfo resolveInfoA = d.this.f19125l.a(bVarA);
                d.this.b("userClickAlwaysEvent:");
                if (bVarA == null) {
                    return;
                }
                if (bVarA.e()) {
                    String strG = bVarA.g();
                    if (d.a.get() != null) {
                        d.a.get().onReceiveValue("extraMenuEvent:" + strG);
                    }
                    d.this.a("extraMenuEvent:" + strG);
                } else if (resolveInfoA == null) {
                    d.this.a(bVarA);
                } else {
                    Intent intent = d.this.f19128o;
                    Context context = d.this.getContext();
                    String str = resolveInfoA.activityInfo.packageName;
                    intent.setPackage(str);
                    if (TbsConfig.APP_QB.equals(str)) {
                        intent.putExtra("ChannelID", context.getApplicationContext().getPackageName());
                        intent.putExtra("PosID", "4");
                    }
                    if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                    }
                    if (!TextUtils.isEmpty(d.this.f19127n)) {
                        intent.putExtra("big_brother_source_key", d.this.f19127n);
                    }
                    try {
                        context.startActivity(intent);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (d.a.get() != null) {
                        d.a.get().onReceiveValue("always");
                    }
                    d.this.a(str);
                }
                d.this.dismiss();
            }
        });
        this.f19122i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVarA = d.this.f19125l.a();
                ResolveInfo resolveInfoA = d.this.f19125l.a(bVarA);
                d.this.b("userClickOnceEvent:");
                d.this.a("");
                if (bVarA == null) {
                    return;
                }
                if (bVarA.e()) {
                    if (d.this.c() && d.a.get() != null) {
                        d.a.get().onReceiveValue("extraMenuEvent:" + bVarA.g());
                    }
                } else if (resolveInfoA == null) {
                    d.this.a(bVarA);
                } else {
                    Intent intent = d.this.f19128o;
                    Context context = d.this.getContext();
                    String str = resolveInfoA.activityInfo.packageName;
                    intent.setPackage(str);
                    if (TbsConfig.APP_QB.equals(str)) {
                        intent.putExtra("ChannelID", context.getApplicationContext().getPackageName());
                        intent.putExtra("PosID", "4");
                    }
                    if (context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                    }
                    if (!TextUtils.isEmpty(d.this.f19127n)) {
                        intent.putExtra("big_brother_source_key", d.this.f19127n);
                    }
                    try {
                        context.startActivity(intent);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (d.a.get() != null) {
                        d.a.get().onReceiveValue("once");
                    }
                }
                d.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b();
    }
}
