package com.baidu.tts.memorizer;

import com.baidu.tts.memorizer.IMResult;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public interface IMemorizable<T, R extends IMResult> extends Comparable<T>, Callable<R> {
}
