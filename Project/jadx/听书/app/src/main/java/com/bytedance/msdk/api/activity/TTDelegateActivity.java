package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.msdk.core.g;
import com.bytedance.msdk.core.wp.gc;
import com.bytedance.msdk.core.wp.m;
import com.bytedance.msdk.z.gc.dl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity {
    private Intent z;

    public static class z implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z();
        this.z = getIntent();
        if (g.getContext() == null) {
            g.z(this);
        }
    }

    private void z() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (g.getContext() == null) {
            g.z(this);
        }
        try {
            setIntent(intent);
            this.z = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            g();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void g() {
        try {
            int intExtra = this.z.getIntExtra("type", 0);
            if (intExtra == 1) {
                z(intExtra, this.z.getIntArrayExtra("permissions"));
                return;
            }
            if (intExtra == 2) {
                z(this.z.getStringExtra("permission_id_key"), this.z.getStringArrayExtra("permission_content_key"));
            } else if (intExtra == 3) {
                z(intExtra, (int[]) null);
            } else {
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void z(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        try {
            gc.z().z(this, strArr, new m() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                @Override // com.bytedance.msdk.core.wp.m
                public void z() {
                    com.bytedance.msdk.core.wp.z.z(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.msdk.core.wp.m
                public void z(String str2) {
                    com.bytedance.msdk.core.wp.z.z(str, str2);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void z(int i, int[] iArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (i != 1) {
                if (i == 3) {
                    arrayList.add(com.kuaishou.weapon.p0.g.h);
                    arrayList.add(com.kuaishou.weapon.p0.g.g);
                    arrayList.add(com.kuaishou.weapon.p0.g.c);
                    arrayList.add(com.kuaishou.weapon.p0.g.j);
                }
            } else if (iArr != null && iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 == 1) {
                        arrayList.add(com.kuaishou.weapon.p0.g.h);
                        arrayList.add(com.kuaishou.weapon.p0.g.g);
                    } else if (i2 == 2) {
                        arrayList.add(com.kuaishou.weapon.p0.g.c);
                    } else if (i2 == 3) {
                        arrayList.add(com.kuaishou.weapon.p0.g.j);
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            gc.z().z(this, strArr, new m() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                @Override // com.bytedance.msdk.core.wp.m
                public void z() {
                    dl.z("TMe", "-------=----- onGranted");
                    com.bytedance.msdk.z.gc.m.a(new z());
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.msdk.core.wp.m
                public void z(String str) {
                    dl.z("TMe", "-------=----- onDenied: ".concat(String.valueOf(str)));
                    com.kuaishou.weapon.p0.g.c.equals(str);
                    com.bytedance.msdk.z.gc.m.a(new z());
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        gc.z().z(this, strArr, iArr);
        com.bytedance.msdk.z.gc.m.a(new z());
        finish();
    }
}
