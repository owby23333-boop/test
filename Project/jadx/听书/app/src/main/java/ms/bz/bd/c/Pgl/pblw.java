package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class pblw extends pbly.pgla {
    private static pblw z;

    public static class pgla {
        private String g;
        private long z;

        public final void g(String str, int i) {
            pblw pblwVarZ = pblw.z();
            if (pblwVarZ == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.z;
            pblwVarZ.g(jCurrentTimeMillis - j, j, this.g, str, i);
        }

        public final void z(String str) {
            this.g = str;
            this.z = System.currentTimeMillis();
        }

        public final void z(String str, int i) {
            pblw pblwVarZ = pblw.z();
            if (pblwVarZ == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.z;
            pblwVarZ.z(jCurrentTimeMillis - j, j, this.g, str, i);
        }
    }

    public static synchronized pblw z() {
        return z;
    }

    public static synchronized void z(pblw pblwVar) {
        z = pblwVar;
    }

    public abstract void g(long j, long j2, String str, String str2, int i);

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !z(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f654b8", new byte[]{88, Ascii.US});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                z(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void z(long j, long j2, String str, String str2, int i);

    public abstract void z(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean z(String str);
}
