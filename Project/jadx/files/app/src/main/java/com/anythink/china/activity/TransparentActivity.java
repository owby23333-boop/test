package com.anythink.china.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.anythink.china.common.d;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TransparentActivity extends Activity {
    public static final String a = "type";
    public static final String b = "request_code";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6351c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6352d = "permission_list";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, d.a> f6353e = new ConcurrentHashMap<>();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.getIntExtra("type", 0) == 1000) {
            ActivityCompat.requestPermissions(this, intent.getStringArrayExtra(f6352d), intent.getIntExtra(b, 0));
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (f6353e.get(Integer.valueOf(i2)) != null) {
            f6353e.remove(Integer.valueOf(i2));
        }
        finish();
    }
}
