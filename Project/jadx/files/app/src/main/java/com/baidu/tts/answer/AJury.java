package com.baidu.tts.answer;

import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AJury implements IJury {
    private Hashtable<String, IQuestion<?>> mQuestions = new Hashtable<>();
    private Hashtable<String, IResult<?>> mResults = new Hashtable<>();

    @Override // com.baidu.tts.answer.IJury
    public void check(String str) {
        IQuestion<?> iQuestion = this.mQuestions.get(str);
        IResult<?> iResult = this.mResults.get(str);
        if (iQuestion == null || iResult == null) {
            return;
        }
        iResult.setResult(iQuestion.answer());
    }

    @Override // com.baidu.tts.answer.IJury
    public IQuestion<?> getQuestion(String str) {
        Hashtable<String, IQuestion<?>> hashtable = this.mQuestions;
        if (hashtable != null) {
            return hashtable.get(str);
        }
        return null;
    }

    @Override // com.baidu.tts.answer.IJury
    public Hashtable<String, IQuestion<?>> getQuestions() {
        return this.mQuestions;
    }

    @Override // com.baidu.tts.answer.IJury
    public IResult<?> getResult(String str) {
        Hashtable<String, IResult<?>> hashtable = this.mResults;
        if (hashtable != null) {
            return hashtable.get(str);
        }
        return null;
    }

    @Override // com.baidu.tts.answer.IJury
    public Hashtable<String, IResult<?>> getResults() {
        return this.mResults;
    }

    @Override // com.baidu.tts.composite.IComposite
    public void add(IQuestion<?> iQuestion) {
        String tag = iQuestion.getTag();
        this.mQuestions.put(tag, iQuestion);
        IResult<?> iResultCreateResult = iQuestion.createResult(new Object[0]);
        iResultCreateResult.setTag(tag);
        this.mResults.put(tag, iResultCreateResult);
    }

    @Override // com.baidu.tts.composite.IComposite
    public void remove(IQuestion<?> iQuestion) {
        String tag = iQuestion.getTag();
        this.mQuestions.remove(tag);
        this.mResults.remove(tag);
    }

    @Override // com.baidu.tts.answer.IJury
    public void check() {
        Enumeration<IQuestion<?>> enumerationElements = this.mQuestions.elements();
        while (enumerationElements.hasMoreElements()) {
            IQuestion<?> iQuestionNextElement = enumerationElements.nextElement();
            if (iQuestionNextElement != null) {
                IResult<?> iResult = this.mResults.get(iQuestionNextElement.getTag());
                if (iResult != null) {
                    iResult.setResult(iQuestionNextElement.answer());
                }
            }
        }
    }
}
