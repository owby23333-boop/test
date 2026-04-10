package com.lxj.xpopup.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class XPermission {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static List<String> f17549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static XPermission f17550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static d f17551m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static d f17552n;
    private Context a;
    private c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f17553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f17554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f17555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f17556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f17557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f17558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f17559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f17560j;

    @RequiresApi(api = 23)
    public static class PermissionActivity extends Activity {
        public static final int TYPE_DRAW_OVERLAYS = 3;
        public static final int TYPE_RUNTIME = 1;
        public static final int TYPE_WRITE_SETTINGS = 2;

        public static void start(Context context, int i2) {
            Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.putExtra("TYPE", i2);
            context.startActivity(intent);
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i2, int i3, Intent intent) {
            if (i2 == 2) {
                if (XPermission.f17551m == null) {
                    return;
                }
                if (XPermission.f17550l.c()) {
                    XPermission.f17551m.onGranted();
                } else {
                    XPermission.f17551m.a();
                }
                d unused = XPermission.f17551m = null;
            } else if (i2 == 3) {
                if (XPermission.f17552n == null) {
                    return;
                }
                if (XPermission.f17550l.b()) {
                    XPermission.f17552n.onGranted();
                } else {
                    XPermission.f17552n.a();
                }
                d unused2 = XPermission.f17552n = null;
            }
            finish();
        }

        @Override // android.app.Activity
        protected void onCreate(@Nullable Bundle bundle) {
            getWindow().addFlags(262672);
            getWindow().getAttributes().alpha = 0.0f;
            int intExtra = getIntent().getIntExtra("TYPE", 1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    super.onCreate(bundle);
                    XPermission.f17550l.b(this, 2);
                    return;
                } else {
                    if (intExtra == 3) {
                        super.onCreate(bundle);
                        XPermission.f17550l.a(this, 3);
                        return;
                    }
                    return;
                }
            }
            if (XPermission.f17550l == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            if (XPermission.f17550l.f17555e != null) {
                XPermission.f17550l.f17555e.a(this);
            }
            super.onCreate(bundle);
            if (XPermission.f17550l.c(this)) {
                finish();
                return;
            }
            if (XPermission.f17550l.f17557g != null) {
                int size = XPermission.f17550l.f17557g.size();
                if (size <= 0) {
                    finish();
                } else {
                    requestPermissions((String[]) XPermission.f17550l.f17557g.toArray(new String[size]), 1);
                }
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            XPermission.f17550l.b(this);
            finish();
        }
    }

    class a implements c.a {
        a(XPermission xPermission) {
        }
    }

    public interface b {
        void a(List<String> list);

        void a(List<String> list, List<String> list2);
    }

    public interface c {

        public interface a {
        }

        void a(a aVar);
    }

    public interface d {
        void a();

        void onGranted();
    }

    public interface e {
        void a(Activity activity);
    }

    private XPermission(Context context, String... strArr) {
        f17550l = this;
        this.a = context;
        a(strArr);
    }

    private void i() {
        if (this.f17553c != null) {
            if (this.f17557g.size() == 0 || this.f17556f.size() == this.f17558h.size()) {
                this.f17553c.onGranted();
            } else if (!this.f17559i.isEmpty()) {
                this.f17553c.a();
            }
            this.f17553c = null;
        }
        if (this.f17554d != null) {
            if (this.f17557g.size() == 0 || this.f17556f.size() == this.f17558h.size()) {
                this.f17554d.a(this.f17558h);
            } else if (!this.f17559i.isEmpty()) {
                this.f17554d.a(this.f17560j, this.f17559i);
            }
            this.f17554d = null;
        }
        this.b = null;
        this.f17555e = null;
    }

    @RequiresApi(api = 23)
    private void j() {
        this.f17559i = new ArrayList();
        this.f17560j = new ArrayList();
        PermissionActivity.start(this.a, 1);
    }

    public void d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + this.a.getPackageName()));
        if (a(intent)) {
            this.a.startActivity(intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP));
        }
    }

    public void e() {
        this.f17558h = new ArrayList();
        this.f17557g = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            this.f17558h.addAll(this.f17556f);
            i();
            return;
        }
        for (String str : this.f17556f) {
            if (b(str)) {
                this.f17558h.add(str);
            } else {
                this.f17557g.add(str);
            }
        }
        if (this.f17557g.isEmpty()) {
            i();
        } else {
            j();
        }
    }

    @RequiresApi(api = 23)
    public boolean c() {
        return Settings.System.canWrite(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    public boolean c(Activity activity) {
        boolean z2 = false;
        if (this.b != null) {
            Iterator<String> it = this.f17557g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (activity.shouldShowRequestPermissionRationale(it.next())) {
                    a(activity);
                    this.b.a(new a(this));
                    z2 = true;
                    break;
                }
            }
            this.b = null;
        }
        return z2;
    }

    public List<String> a() {
        return a(this.a.getPackageName());
    }

    private boolean b(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this.a, str) == 0;
    }

    public List<String> a(String str) {
        try {
            String[] strArr = this.a.getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void b(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void a(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    @RequiresApi(api = 23)
    public boolean b() {
        return Settings.canDrawOverlays(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        a(activity);
        i();
    }

    public static XPermission a(Context context, String... strArr) {
        XPermission xPermission = f17550l;
        if (xPermission == null) {
            return new XPermission(context, strArr);
        }
        xPermission.a = context;
        xPermission.a(strArr);
        return f17550l;
    }

    private boolean a(Intent intent) {
        return this.a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private void a(String... strArr) {
        this.f17556f = new LinkedHashSet();
        f17549k = a();
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            for (String str2 : PermissionConstants.a(str)) {
                if (f17549k.contains(str2)) {
                    this.f17556f.add(str2);
                }
            }
        }
    }

    public XPermission a(d dVar) {
        this.f17553c = dVar;
        return this;
    }

    private void a(Activity activity) {
        for (String str : this.f17557g) {
            if (b(str)) {
                this.f17558h.add(str);
            } else {
                this.f17559i.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f17560j.add(str);
                }
            }
        }
    }
}
