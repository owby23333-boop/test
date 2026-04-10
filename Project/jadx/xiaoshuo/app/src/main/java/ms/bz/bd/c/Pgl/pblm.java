package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pblb;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class pblm extends pblb.pgla {
    private static pblm e;

    public static class pgla {
        private long bf;
        private String d;
        private long e;
        private String tg;

        public void bf(String str, int i) {
            pblm pblmVarE = pblm.e();
            if (pblmVarE == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.e;
            long j2 = jCurrentTimeMillis - j;
            this.bf = j2;
            pblmVarE.bf(j2, j, this.d, this.tg, str, i, null);
        }

        public void e(String str) {
            this.d = str;
            this.tg = null;
            this.e = System.currentTimeMillis();
        }

        public void e(String str, int i) {
            pblm pblmVarE = pblm.e();
            if (pblmVarE == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.e;
            long j2 = jCurrentTimeMillis - j;
            this.bf = j2;
            pblmVarE.e(j2, j, this.d, this.tg, str, i, null);
        }
    }

    public abstract void bf(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject);

    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !e(str)) {
                return null;
            }
            return (String) pblk.a(16777217, 0, 0L, "0a5bad", new byte[]{Ascii.SO, 72});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                e(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void e(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject);

    public abstract void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean e(String str);

    public static synchronized pblm e() {
        return e;
    }

    public static synchronized void e(pblm pblmVar) {
        e = pblmVar;
    }
}
