package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile IFullTraceAnalysis a = new C0007a(null);
    private static boolean b = false;

    /* JADX INFO: renamed from: anet.channel.fulltrace.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    private static class C0007a implements IFullTraceAnalysis {
        private IFullTraceAnalysis a;

        C0007a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.a = iFullTraceAnalysis;
            boolean unused = a.b = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.b && (iFullTraceAnalysis = this.a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = a.b = false;
                    ALog.e("anet.AnalysisFactory", "fulltrace commit fail.", null, th, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.b || (iFullTraceAnalysis = this.a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = a.b = false;
                ALog.e("anet.AnalysisFactory", "createRequest fail.", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public b getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.b || (iFullTraceAnalysis = this.a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = a.b = false;
                ALog.e("anet.AnalysisFactory", "getSceneInfo fail", null, th, new Object[0]);
                return null;
            }
        }
    }

    public static IFullTraceAnalysis a() {
        return a;
    }

    public static void a(IFullTraceAnalysis iFullTraceAnalysis) {
        a = new C0007a(iFullTraceAnalysis);
    }
}
