package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import okio.Utf8;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 {
    private static volatile boolean g;
    public static final /* synthetic */ int z = 0;
    private static final ConcurrentHashMap dl = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CopyOnWriteArraySet f2539a = new CopyOnWriteArraySet();

    public interface pgla {
        Map<String, String> getFeatureHash(String str, byte[] bArr);

        String getToken();

        void report(String str);

        void setBDDeviceID(String str);

        void setCollectMode(int i);

        void setDeviceID(String str);

        void setInstallID(String str);
    }

    protected n0() {
    }

    public static void dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "03a485", new byte[]{46, Utf8.REPLACEMENT_BYTE, 32, 69, Ascii.ETB, 45, 33, 6, Ascii.SYN, 109, 47, 56, 1, 72, 71, 54, 60, Ascii.EM, 53, 106, 97, 124, 95, 13, 71});
        Iterator it = f2539a.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
    }

    public static synchronized m0 g(String str) {
        if (str == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "45d9c4", new byte[]{36, 39, 7, 100, 120, 99, 58, 1, 38, 125, 101, 53, Ascii.DC2, 13, 79, 38, 35}));
        }
        if (!g) {
            return null;
        }
        int i = pbly.z;
        Object objA = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, null);
        if (objA == null) {
            return null;
        }
        pblu pbluVar = (pblu) dl.get(str);
        if (pbluVar == null) {
            return null;
        }
        return new m0(pbluVar, pblv.z().g(), ((Long) objA).longValue());
    }

    public static synchronized void z(String str) {
        if (pblv.z().g() != null) {
            pblu pbluVar = (pblu) dl.get(str);
            if (g(str) != null && pbluVar != null) {
                f2539a.addAll(pbluVar.p);
                PglMSManager pglMSManager = PglMSManagerUtils.get(str);
                if (pglMSManager != null) {
                    pglMSManager.report((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3856e8", new byte[]{Ascii.GS, 51, 72, 75, 78, 16, 34, Ascii.FS, 116, 105, 48, 46}));
                }
            }
        }
    }

    public static synchronized boolean z(Context context, pblu pbluVar) {
        if (context == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "074801", new byte[]{34, 58, 73, 88, 10, 62, 39, 86, 102, 103, 52, 57, 67, 12, 1, 41, 39, 86, 103, 109, 97, 59, 82, SignedBytes.MAX_POWER_OF_TWO, 3}));
        }
        if (pbluVar == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1649cb", new byte[]{35, 59, 73, 75, 85, 114, 114, Ascii.DC4, 106, 124, 44, 48, 7, 67, 83, 97, 114, Ascii.NAK, 96, 41, 46, 33, 75, 65}));
        }
        String str = pbluVar.f2541a;
        String str2 = (str == null || str.length() <= 0) ? pbluVar.g : pbluVar.f2541a;
        if (str2 == null || str2.length() <= 0) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1497c9", new byte[]{33, 38, 90, 106, 120, 110, Utf8.REPLACEMENT_BYTE, 0, 123, 115, 96, 52, 79, 3, 79, 43, 38}));
        }
        if (!g) {
            synchronized (n0.class) {
                if (!g) {
                    z(context);
                    g = true;
                }
            }
        }
        if (dl.containsKey(str2)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(pblu.a(pbluVar.f2541a));
        jSONArray.put(pblu.a(pbluVar.h));
        jSONArray.put(pblu.a(pbluVar.g));
        jSONArray.put(pblu.a(pbluVar.i));
        jSONArray.put(pblu.a(n1.z()));
        jSONArray.put(pblu.a(pbluVar.b));
        jSONArray.put(pblu.a(pbluVar.c));
        jSONArray.put(pblu.a(pbluVar.d));
        jSONArray.put(pblu.a(pbluVar.e));
        jSONArray.put(pblu.a(pbluVar.f));
        jSONArray.put(String.valueOf(pbluVar.k));
        jSONArray.put(String.valueOf(pbluVar.l));
        jSONArray.put(String.valueOf(pbluVar.m));
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, String> entry : pbluVar.n.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                jSONArray2.put(pblu.a(entry.getKey()));
                jSONArray2.put(pblu.a(entry.getValue()));
            }
        }
        jSONArray.put(jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (Map.Entry entry2 : pbluVar.o.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                if (((String) entry2.getKey()).equals("kOA1") && TextUtils.equals((CharSequence) entry2.getValue(), "1")) {
                    a1.z = false;
                    a1.g = pbluVar.j;
                }
                jSONArray3.put(pblu.a(entry2.getKey()));
                jSONArray3.put(pblu.a(entry2.getValue()));
            }
        }
        jSONArray.put(jSONArray3);
        String string = jSONArray.toString();
        int i = pbly.z;
        if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, string, null)).booleanValue()) {
            return false;
        }
        dl.put(str2, pbluVar);
        return true;
    }

    static synchronized void z(Context context) {
        if (!g) {
            Context applicationContext = context.getApplicationContext();
            pblv.z().z(applicationContext);
            e1.z(applicationContext);
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a3d8a5", new byte[]{62, 60, 4});
            pbly.z(16777218, new j());
            pbly.z(16777217, new u());
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "955618", new byte[]{102, 58, 66});
            pbly.z(16777219, new f0());
            pbly.z(16777221, new g0());
            pbly.z(16777222, new h0());
            pbly.z(16777223, new i0());
            pbly.z(16777224, new j0());
            pbly.z(16777225, new k0());
            pbly.z(16777226, new l0());
            pbly.z(16777228, new pblz());
            pbly.z(InputDeviceCompat.SOURCE_JOYSTICK, new a());
            pbly.z(16777233, new b());
            pbly.z(16777235, new c());
            pbly.z(16777238, new d());
            pbly.z(16777239, new e());
            pbly.z(16777241, new f());
            pbly.z(16777242, new g());
            pbly.z(16777243, new h());
            pbly.z(16777244, new i());
            pbly.z(16777245, new k());
            pbly.z(16777246, new l());
            pbly.z(16777247, new m());
            pbly.z(16777248, new n());
            pbly.z(16777249, new o());
            pbly.z(16777250, new p());
            pbly.z(16777251, new q());
            pbly.z(16777240, new r());
            pbly.z(16777252, new s());
            pbly.z(16777253, new t());
            pbly.z(16777254, new v());
            pbly.z(16777255, new w());
            pbly.z(16777256, new x());
            pbly.z(16777257, new y());
            pbly.z(16777258, new z());
            pbly.z(16777259, new a0());
            pbly.z(16777261, new b0());
            pbly.z(16777266, new c0());
            pbly.z(16777272, new d0());
            pbly.z(33554435, new e0());
            v0.z();
            w0.z();
            com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, applicationContext);
            g = true;
        }
    }
}
