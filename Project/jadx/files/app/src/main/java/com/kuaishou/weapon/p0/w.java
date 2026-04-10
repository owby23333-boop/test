package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    private Context a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f16853c;

    public w(Context context) {
        this.b = 0;
        this.a = context;
        this.f16853c = h.a(this.a, "re_po_rt");
        h hVar = this.f16853c;
        if (hVar != null) {
            this.b = hVar.b(de.f16695p, 0);
        }
    }

    public JSONArray a(int i2) {
        try {
            new A(this.a, i2);
            JSONArray jsonObject = A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject != null) {
                for (int i3 = 0; i3 < jsonObject.length(); i3++) {
                    jSONArray.put(jsonObject.get(i3));
                }
                A.setJsonObject(null);
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray b(int i2) {
        try {
            return c(i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray c(int i2) {
        return d(i2);
    }

    public JSONArray d(int i2) {
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.a.getPackageManager();
            for (int i3 = 1000; i3 <= 19999; i3++) {
                String[] packagesForUid = null;
                try {
                    packagesForUid = packageManager.getPackagesForUid(i3);
                } catch (Exception unused) {
                }
                if (packagesForUid != null) {
                    for (String str : packagesForUid) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (i2 != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                v vVar = new v(packageInfo, this.a);
                                vVar.h();
                                jSONArray.put(vVar.k());
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
        return jSONArray;
    }
}
