package com.baidu.tts.chainofresponsibility;

import com.baidu.tts.chainofresponsibility.IChain;

/* JADX INFO: loaded from: classes2.dex */
public interface IChain<T extends IChain<T>> {
    void hitch(T t2);
}
