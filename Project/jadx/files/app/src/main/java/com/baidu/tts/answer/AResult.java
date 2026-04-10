package com.baidu.tts.answer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AResult<T> implements IResult<T> {
    private T mResult;
    private String mTag;

    @Override // com.baidu.tts.answer.IResult
    public T getResult() {
        return this.mResult;
    }

    @Override // com.baidu.tts.answer.IResult
    public String getTag() {
        return this.mTag;
    }

    @Override // com.baidu.tts.answer.IResult
    public void setResult(T t2) {
        this.mResult = t2;
    }

    @Override // com.baidu.tts.answer.IResult
    public void setTag(String str) {
        this.mTag = str;
    }
}
