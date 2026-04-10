package com.baidu.tts.chainofresponsibility;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AChain implements IChain<AChain> {
    protected AChain mNext;

    @Override // com.baidu.tts.chainofresponsibility.IChain
    public void hitch(AChain aChain) {
        if (aChain != null) {
            AChain aChain2 = this.mNext;
            if (aChain2 == null) {
                this.mNext = aChain;
            } else {
                this.mNext = aChain;
                this.mNext.hitch(aChain2);
            }
        }
    }
}
