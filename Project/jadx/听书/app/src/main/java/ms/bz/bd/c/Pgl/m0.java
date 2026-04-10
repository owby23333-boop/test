package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import java.util.HashMap;
import java.util.Map;
import ms.bz.bd.c.Pgl.n0;

/* JADX INFO: loaded from: classes4.dex */
public final class m0 implements n0.pgla {
    private final pblu dl;
    private final Context g;
    private final long z;

    m0(pblu pbluVar, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.dl = pbluVar;
        this.g = context.getApplicationContext();
        this.z = j;
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final Map<String, String> getFeatureHash(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str != null && str.length() != 0) {
            long j = this.z;
            int i = pbly.z;
            String[] strArr = (String[]) com.volcengine.mobsecBiz.matrix.pgla.a(33554438, 0, j, str, bArr);
            if (strArr != null && strArr.length % 2 == 0) {
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    String str2 = strArr[i2];
                    String str3 = strArr[i2 + 1];
                    if (str2 != null && str3 != null) {
                        map.put(str2, str3);
                    }
                }
            }
        }
        return map;
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final String getToken() {
        long j = this.z;
        if (j == -1) {
            return "";
        }
        int i = pbly.z;
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(33554439, 0, j, null, null);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void report(String str) {
        if (this.z == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.z;
        Context context = this.g;
        int i = pbly.z;
        com.volcengine.mobsecBiz.matrix.pgla.a(InputDeviceCompat.SOURCE_HDMI, 0, j, str, context);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setBDDeviceID(String str) {
        this.dl.d = str;
        long j = this.z;
        if (j != -1) {
            Context context = this.g;
            int i = pbly.z;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554437, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setCollectMode(int i) {
        long j = this.z;
        if (j != -1) {
            int i2 = pbly.z;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554441, i, j, null, null);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setDeviceID(String str) {
        this.dl.c = str;
        long j = this.z;
        if (j != -1) {
            Context context = this.g;
            int i = pbly.z;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554434, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setInstallID(String str) {
        this.dl.e = str;
        long j = this.z;
        if (j != -1) {
            Context context = this.g;
            int i = pbly.z;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554435, 0, j, str, context);
        }
    }
}
