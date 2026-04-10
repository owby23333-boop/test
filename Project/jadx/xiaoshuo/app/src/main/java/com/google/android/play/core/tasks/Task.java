package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Task<TResult> {
    public abstract Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener);

    public abstract Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener);

    public abstract Task<TResult> addOnFailureListener(OnFailureListener onFailureListener);

    public abstract Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener);

    public abstract Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener);

    public abstract Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener);

    public abstract Exception getException();

    public abstract TResult getResult();

    public abstract <X extends Throwable> TResult getResult(Class<X> cls);

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();
}
