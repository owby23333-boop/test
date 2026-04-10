package com.tramini.plugin.a.k;

import android.text.TextUtils;
import com.tramini.plugin.a.i.l;
import com.tramini.plugin.a.i.m;
import com.tramini.plugin.a.k.b;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.tramini.plugin.a.k.a$a, reason: collision with other inner class name */
    final class RunnableC0542a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ l.c.a.a.a f19370s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ b f19371t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ String f19372u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ String f19373v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final /* synthetic */ String f19374w;

        RunnableC0542a(l.c.a.a.a aVar, b bVar, String str, String str2, String str3) {
            this.f19370s = aVar;
            this.f19371t = bVar;
            this.f19372u = str;
            this.f19373v = str2;
            this.f19374w = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConcurrentHashMap<String, com.tramini.plugin.a.g.c> concurrentHashMapE;
            com.tramini.plugin.a.g.a aVarA = null;
            try {
                concurrentHashMapE = this.f19370s.e();
            } catch (Throwable unused) {
            }
            if (concurrentHashMapE == null) {
                if (this.f19371t != null) {
                    this.f19371t.a(null);
                    return;
                }
                return;
            }
            com.tramini.plugin.a.g.c cVar = concurrentHashMapE.get(TextUtils.equals(this.f19372u, "33") ? "2" : this.f19372u);
            String str = cVar != null ? cVar.f19338d : "";
            if (TextUtils.isEmpty(str)) {
                if (this.f19371t != null) {
                    this.f19371t.a(null);
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            String str2 = this.f19372u;
            byte b = -1;
            int iHashCode = str2.hashCode();
            if (iHashCode != 50) {
                if (iHashCode != 56) {
                    if (iHashCode != 1572) {
                        if (iHashCode != 1632) {
                            if (iHashCode != 1691) {
                                if (iHashCode != 53) {
                                    if (iHashCode != 54) {
                                        if (iHashCode != 1606) {
                                            if (iHashCode == 1607 && str2.equals("29")) {
                                                b = 7;
                                            }
                                        } else if (str2.equals("28")) {
                                            b = 6;
                                        }
                                    } else if (str2.equals("6")) {
                                        b = 3;
                                    }
                                } else if (str2.equals("5")) {
                                    b = 2;
                                }
                            } else if (str2.equals("50")) {
                                b = 8;
                            }
                        } else if (str2.equals("33")) {
                            b = 1;
                        }
                    } else if (str2.equals(AgooConstants.ACK_PACK_ERROR)) {
                        b = 5;
                    }
                } else if (str2.equals("8")) {
                    b = 4;
                }
            } else if (str2.equals("2")) {
                b = 0;
            }
            switch (b) {
                case 0:
                case 1:
                    aVarA = com.tramini.plugin.a.i.a.a(jSONObject, cVar, this.f19373v, this.f19374w);
                    break;
                case 2:
                    aVarA = com.tramini.plugin.a.i.b.a(jSONObject, cVar, this.f19373v, this.f19374w);
                    break;
                case 3:
                    aVarA = com.tramini.plugin.a.i.e.a(jSONObject, cVar, this.f19373v, this.f19374w);
                    break;
                case 4:
                    aVarA = com.tramini.plugin.a.i.c.a(jSONObject, cVar, this.f19373v);
                    break;
                case 5:
                    aVarA = m.a(jSONObject, cVar, this.f19373v);
                    break;
                case 6:
                    aVarA = com.tramini.plugin.a.i.d.a(jSONObject, cVar, this.f19373v);
                    break;
                case 7:
                    aVarA = l.a(jSONObject, cVar, this.f19373v);
                    break;
                case 8:
                    aVarA = com.tramini.plugin.a.i.g.a(jSONObject, cVar, this.f19373v);
                    break;
            }
            b bVar = this.f19371t;
            if (bVar != null) {
                bVar.a(aVarA);
            }
        }
    }

    public interface b {
        void a(com.tramini.plugin.a.g.a aVar);
    }

    public final class c implements CharSequence {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        CharSequence f19375s;

        public c(CharSequence charSequence) {
            this.f19375s = charSequence;
        }

        @Override // java.lang.CharSequence
        public final char charAt(int i2) {
            if (Thread.currentThread().isInterrupted()) {
                throw new RuntimeException("Interrupted!");
            }
            return this.f19375s.charAt(i2);
        }

        @Override // java.lang.CharSequence
        public final int length() {
            return this.f19375s.length();
        }

        @Override // java.lang.CharSequence
        public final CharSequence subSequence(int i2, int i3) {
            return new c(this.f19375s.subSequence(i2, i3));
        }

        @Override // java.lang.CharSequence
        public final String toString() {
            return this.f19375s.toString();
        }
    }

    public static void a(l.c.a.a.a aVar, String str, String str2, String str3, b bVar) {
        if (aVar == null) {
            bVar.a(null);
        } else {
            b.C0543b.a().a(new RunnableC0542a(aVar, bVar, str, str2, str3));
        }
    }
}
