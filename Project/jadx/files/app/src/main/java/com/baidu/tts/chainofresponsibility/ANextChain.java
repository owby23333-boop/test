package com.baidu.tts.chainofresponsibility;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ANextChain<V, R, C> extends AChain implements IHandler<V, R, C> {
    @Override // com.baidu.tts.chainofresponsibility.IHandler
    public void handle(V v2, R r2, C c2) {
        AChain aChain;
        handleIt(v2, r2, c2);
        if (!nextOrNot(v2, r2, c2) || (aChain = this.mNext) == null) {
            return;
        }
        ((ANextChain) aChain).handle(v2, r2, c2);
    }

    protected abstract void handleIt(V v2, R r2, C c2);

    protected abstract boolean nextOrNot(V v2, R r2, C c2);
}
