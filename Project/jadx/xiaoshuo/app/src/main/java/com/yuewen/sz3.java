package com.yuewen;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public abstract class sz3 {

    public class a implements Comparator<Map.Entry<Thread, StackTraceElement[]>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread f17805a;

        public a(Thread thread) {
            this.f17805a = thread;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<Thread, StackTraceElement[]> entry, Map.Entry<Thread, StackTraceElement[]> entry2) {
            if (entry.getKey() == this.f17805a) {
                return -1;
            }
            if (entry2.getKey() == this.f17805a) {
                return 1;
            }
            return entry.getKey().toString().compareTo(entry2.getKey().toString());
        }
    }

    public static Map<Thread, StackTraceElement[]> a() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Thread threadE = rv1.e();
        if (!allStackTraces.containsKey(threadE)) {
            allStackTraces.put(threadE, threadE.getStackTrace());
        }
        return allStackTraces;
    }

    public static List<Map.Entry<Thread, StackTraceElement[]>> b() {
        LinkedList linkedList = new LinkedList(a().entrySet());
        Collections.sort(linkedList, new a(rv1.e()));
        return linkedList;
    }
}
