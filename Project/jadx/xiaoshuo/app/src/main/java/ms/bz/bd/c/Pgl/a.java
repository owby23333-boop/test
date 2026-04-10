package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class a {
    protected String e = "";
    protected String bf = "";
    protected String d = "";
    protected String tg = "";
    protected String ga = "";
    protected String vn = "";
    protected String p = "";
    protected String v = "";
    protected String zk = "";
    protected int m = -1;
    protected int wu = -1;
    protected int xu = 99999;
    protected Map<String, String> bh = new HashMap();
    protected Map<String, String> t = new HashMap();
    protected Set<PglITokenObserver> s = new HashSet();

    public interface pblb {
    }

    public static abstract class pgla<T extends pblb> extends a implements pblb {
        public pgla(String str, String str2, String str3, int i) {
            this.p = str;
            this.v = str2;
            this.zk = str3;
            this.xu = i;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        public T bf(int i) {
            this.m = i;
            return this;
        }

        public T bf(String str) {
            this.d = str;
            return this;
        }

        public a bf() {
            this.m = 1;
            return this;
        }
    }

    public String e(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }
}
