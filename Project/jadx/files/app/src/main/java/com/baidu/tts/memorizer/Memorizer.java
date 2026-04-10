package com.baidu.tts.memorizer;

import com.baidu.tts.memorizer.IMResult;
import com.baidu.tts.memorizer.IMemorizable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class Memorizer<A extends IMemorizable<A, R>, R extends IMResult> {
    private static final String TAG = "Memorizer";
    private final ConcurrentMap<A, Future<R>> mCache = new ConcurrentHashMap();

    private A getKey(A a) {
        for (A a2 : this.mCache.keySet()) {
            if (a.compareTo(a2) == 0) {
                return a2;
            }
        }
        return null;
    }

    public void clear() {
        ConcurrentMap<A, Future<R>> concurrentMap = this.mCache;
        if (concurrentMap != null) {
            concurrentMap.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.concurrent.Future] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.concurrent.FutureTask] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public R memory(A r8) throws java.lang.Exception {
        /*
            r7 = this;
            com.baidu.tts.memorizer.IMemorizable r0 = r7.getKey(r8)
            r1 = 0
            if (r0 == 0) goto L10
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.memorizer.IMemorizable<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.memorizer.IMResult>> r2 = r7.mCache
            java.lang.Object r2 = r2.get(r0)
            java.util.concurrent.Future r2 = (java.util.concurrent.Future) r2
            goto L11
        L10:
            r2 = r1
        L11:
            java.lang.String r3 = "Memorizer"
            if (r2 == 0) goto L63
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "+ get f="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r4)
            java.lang.Object r4 = r2.get()
            com.baidu.tts.memorizer.IMResult r4 = (com.baidu.tts.memorizer.IMResult) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "- get f="
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r5)
            boolean r5 = r4.isValid()
            if (r5 != 0) goto L63
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "arg invalid r="
            r2.append(r5)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r2)
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.memorizer.IMemorizable<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.memorizer.IMResult>> r2 = r7.mCache
            r2.remove(r0)
            goto L64
        L63:
            r1 = r2
        L64:
            if (r1 != 0) goto La2
            java.util.concurrent.FutureTask r1 = new java.util.concurrent.FutureTask
            r1.<init>(r8)
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.memorizer.IMemorizable<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.memorizer.IMResult>> r0 = r7.mCache
            java.lang.Object r0 = r0.putIfAbsent(r8, r1)
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0
            if (r0 != 0) goto La1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "+ run f="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r0)
            r1.run()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "- run f="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r0)
            goto La2
        La1:
            r1 = r0
        La2:
            java.lang.Object r0 = r1.get()     // Catch: java.lang.Exception -> La9 java.util.concurrent.ExecutionException -> Lb0
            com.baidu.tts.memorizer.IMResult r0 = (com.baidu.tts.memorizer.IMResult) r0     // Catch: java.lang.Exception -> La9 java.util.concurrent.ExecutionException -> Lb0
            return r0
        La9:
            r0 = move-exception
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.memorizer.IMemorizable<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.memorizer.IMResult>> r2 = r7.mCache
            r2.remove(r8, r1)
            throw r0
        Lb0:
            r0 = move-exception
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.memorizer.IMemorizable<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.memorizer.IMResult>> r2 = r7.mCache
            r2.remove(r8, r1)
            java.lang.Throwable r8 = r0.getCause()
            java.lang.Exception r8 = (java.lang.Exception) r8
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.memorizer.Memorizer.memory(com.baidu.tts.memorizer.IMemorizable):com.baidu.tts.memorizer.IMResult");
    }
}
