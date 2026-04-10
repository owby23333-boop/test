package com.baidu.tts.answer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AQuestion<T> implements IQuestion<T> {
    private String mTag;

    public AQuestion(String str) {
        this.mTag = str;
    }

    @Override // com.baidu.tts.answer.IQuestion
    public String getTag() {
        return this.mTag;
    }
}
