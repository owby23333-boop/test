package net.oauth;

/* JADX INFO: loaded from: classes9.dex */
public enum ParameterStyle {
    AUTHORIZATION_HEADER,
    BODY,
    QUERY_STRING;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ParameterStyle[] valuesCustom() {
        ParameterStyle[] parameterStyleArrValuesCustom = values();
        int length = parameterStyleArrValuesCustom.length;
        ParameterStyle[] parameterStyleArr = new ParameterStyle[length];
        System.arraycopy(parameterStyleArrValuesCustom, 0, parameterStyleArr, 0, length);
        return parameterStyleArr;
    }
}
