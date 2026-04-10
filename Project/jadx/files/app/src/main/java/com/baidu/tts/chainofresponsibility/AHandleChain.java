package com.baidu.tts.chainofresponsibility;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AHandleChain<V, R, C> extends AChain implements IHandler<V, R, C> {
    protected abstract boolean canHandle(V v2, R r2, C c2);

    @Override // com.baidu.tts.chainofresponsibility.IHandler
    public void handle(V v2, R r2, C c2) {
        if (canHandle(v2, r2, c2)) {
            handleIt(v2, r2, c2);
            return;
        }
        AChain aChain = this.mNext;
        if (aChain != null) {
            ((AHandleChain) aChain).handle(v2, r2, c2);
        }
    }

    protected abstract void handleIt(V v2, R r2, C c2);
}
