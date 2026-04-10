package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes7.dex */
public interface JacksonAnnotationValue<A extends Annotation> {
    Class<A> valueFor();
}
