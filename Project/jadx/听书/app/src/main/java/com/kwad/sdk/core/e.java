package com.kwad.sdk.core;

import android.util.Pair;
import android.view.MotionEvent;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static final b awK = new b(100);
    private static final a awL = new a(10, 0);
    private static List<c> awM = new ArrayList(50);
    private static final List<List<c>> awN = new ArrayList();
    private static final List<Map<String, Double>> awO = new ArrayList();
    private static c awP;

    public static void e(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3 && action != 4) {
                        return;
                    }
                }
            }
            a(motionEvent, true);
            return;
        }
        a(motionEvent, false);
    }

    private static void a(MotionEvent motionEvent, boolean z) {
        c cVar = new c(motionEvent);
        c cVar2 = awP;
        if (cVar2 == null || !cVar2.a(cVar)) {
            awM.add(cVar);
            awP = cVar;
            if (z) {
                if (awM.size() > 3 && awM.size() < 100) {
                    awN.add(awM);
                }
                awM = new ArrayList(50);
                awP = null;
            }
        }
    }

    public static Pair<List<String>, Double> Eo() {
        Iterator<List<c>> it = awN.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            Iterator<c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                awK.k(it2.next());
            }
            List<Map<String, Double>> list = awO;
            double dY = y(list);
            if (dY > d) {
                d = dY;
            }
            list.clear();
            a aVar = awL;
            b bVar = awK;
            aVar.k(bVar.toString());
            bVar.clear();
        }
        return new Pair<>(Ep(), Double.valueOf(d));
    }

    private static List<String> Ep() {
        List<String> listEt = awL.Et();
        Er();
        Eq();
        return listEt;
    }

    private static void Eq() {
        awO.clear();
        awN.clear();
        awM.clear();
    }

    private static double y(List<Map<String, Double>> list) {
        double d = 0.0d;
        try {
            ArrayList arrayList = new ArrayList(list.size());
            ArrayList arrayList2 = new ArrayList(list.size());
            ArrayList arrayList3 = new ArrayList(list.size());
            ArrayList arrayList4 = new ArrayList(list.size());
            a(list, arrayList, arrayList2, arrayList3, arrayList4);
            int i = 1;
            for (int i2 = 1; i < list.size() - i2; i2 = 1) {
                int i3 = i;
                double dAbs = Math.abs((((Double) arrayList.get(i)).doubleValue() * ((Double) arrayList4.get(i)).doubleValue()) - (((Double) arrayList2.get(i)).doubleValue() * ((Double) arrayList3.get(i)).doubleValue())) / Math.pow(Math.pow(((Double) arrayList.get(i)).doubleValue(), 2.0d) + Math.pow(((Double) arrayList2.get(i)).doubleValue(), 2.0d), 1.5d);
                if (dAbs > d) {
                    d = dAbs;
                }
                i = i3 + 1;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return d;
    }

    private static void a(List<Map<String, Double>> list, List<Double> list2, List<Double> list3, List<Double> list4, List<Double> list5) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list2.add(Double.valueOf(0.0d));
            list3.add(Double.valueOf(0.0d));
            list4.add(Double.valueOf(0.0d));
            list5.add(Double.valueOf(0.0d));
        }
        int i2 = 1;
        while (i2 < size - 1) {
            int i3 = i2 + 1;
            double dDoubleValue = list.get(i3).get("x").doubleValue();
            int i4 = i2 - 1;
            double dDoubleValue2 = list.get(i4).get("x").doubleValue();
            double dDoubleValue3 = list.get(i3).get("y").doubleValue();
            double dDoubleValue4 = list.get(i4).get("y").doubleValue();
            double dDoubleValue5 = list.get(i2).get("x").doubleValue();
            double dDoubleValue6 = list.get(i2).get("y").doubleValue();
            list2.set(i2, Double.valueOf((dDoubleValue - dDoubleValue2) / 2.0d));
            list3.set(i2, Double.valueOf((dDoubleValue3 - dDoubleValue4) / 2.0d));
            list4.set(i2, Double.valueOf((dDoubleValue - (dDoubleValue5 * 2.0d)) + dDoubleValue2));
            list5.set(i2, Double.valueOf((dDoubleValue3 - (dDoubleValue6 * 2.0d)) + dDoubleValue4));
            i2 = i3;
        }
    }

    private static void Er() {
        awL.clear();
        awK.clear();
    }

    public static class c {
        private int action;
        private double x;
        private double y;

        public c(MotionEvent motionEvent) {
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
            this.action = motionEvent.getAction();
        }

        public final double Eu() {
            return this.x;
        }

        public final double Ev() {
            return this.y;
        }

        private int getAction() {
            return this.action;
        }

        public final boolean a(c cVar) {
            return this.x == cVar.Eu() && this.y == cVar.Ev() && this.action == cVar.getAction();
        }
    }

    public static class b {
        public final int awQ;
        public final Queue<String> awR = new LinkedList();

        public char Es() {
            return '|';
        }

        public b(int i) {
            this.awQ = i;
        }

        public boolean k(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (this.awR.size() >= this.awQ) {
                this.awR.poll();
            }
            HashMap map = new HashMap();
            c cVar = (c) obj;
            double dEu = cVar.Eu();
            double dEv = cVar.Ev();
            map.put("x", Double.valueOf(dEu));
            map.put("y", Double.valueOf(dEv));
            e.awO.add(map);
            return this.awR.offer(dEu + "_" + dEv);
        }

        public final void clear() {
            this.awR.clear();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.awR.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(Es());
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }

    public static class a extends b {
        @Override // com.kwad.sdk.core.e.b
        public final char Es() {
            return ',';
        }

        /* synthetic */ a(int i, byte b) {
            this(10);
        }

        private a(int i) {
            super(i);
        }

        @Override // com.kwad.sdk.core.e.b
        public final boolean k(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            if (this.awR.size() >= this.awQ) {
                this.awR.poll();
            }
            return this.awR.offer((String) obj);
        }

        public final List<String> Et() {
            return new ArrayList(this.awR);
        }
    }
}
