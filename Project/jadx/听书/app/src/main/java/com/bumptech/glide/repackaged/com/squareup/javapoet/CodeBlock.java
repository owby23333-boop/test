package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: classes2.dex */
public final class CodeBlock {
    final List<Object> args;
    final List<String> formatParts;
    private static final Pattern NAMED_ARGUMENT = Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");
    private static final Pattern LOWERCASE = Pattern.compile("[a-z]+[\\w_]*");

    private CodeBlock(Builder builder) {
        this.formatParts = Util.immutableList(builder.formatParts);
        this.args = Util.immutableList(builder.args);
    }

    public boolean isEmpty() {
        return this.formatParts.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new CodeWriter(stringWriter).emit(this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public static CodeBlock of(String str, Object... objArr) {
        return new Builder().add(str, objArr).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        final List<Object> args;
        final List<String> formatParts;

        private Object argToLiteral(Object obj) {
            return obj;
        }

        private boolean isNoArgPlaceholder(char c) {
            return c == '$' || c == '>' || c == '<' || c == '[' || c == ']' || c == 'W';
        }

        private Builder() {
            this.formatParts = new ArrayList();
            this.args = new ArrayList();
        }

        public Builder add(String str, Object... objArr) {
            int i;
            char cCharAt;
            boolean z;
            int i2;
            int[] iArr = new int[objArr.length];
            int i3 = 0;
            boolean z2 = false;
            int i4 = 0;
            boolean z3 = false;
            while (true) {
                if (i3 >= str.length()) {
                    break;
                }
                if (str.charAt(i3) != '$') {
                    int iIndexOf = str.indexOf(36, i3 + 1);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    this.formatParts.add(str.substring(i3, iIndexOf));
                    i3 = iIndexOf;
                } else {
                    int i5 = i3 + 1;
                    int i6 = i5;
                    while (true) {
                        Util.checkArgument(i6 < str.length(), "dangling format characters in '%s'", str);
                        i = i6 + 1;
                        cCharAt = str.charAt(i6);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i6 = i;
                    }
                    int i7 = i - 1;
                    if (isNoArgPlaceholder(cCharAt)) {
                        Util.checkArgument(i5 == i7, "$$, $>, $<, $[, $], and $W may not have an index", new Object[0]);
                        this.formatParts.add("$" + cCharAt);
                        i3 = i;
                    } else {
                        if (i5 < i7) {
                            int i8 = Integer.parseInt(str.substring(i5, i7)) - 1;
                            if (objArr.length > 0) {
                                int length = i8 % objArr.length;
                                iArr[length] = iArr[length] + 1;
                            }
                            z = true;
                            i2 = i4;
                            i4 = i8;
                        } else {
                            z = z3;
                            i2 = i4 + 1;
                            z2 = true;
                        }
                        Util.checkArgument(i4 >= 0 && i4 < objArr.length, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i4 + 1), str.substring(i5 - 1, i7 + 1), Integer.valueOf(objArr.length));
                        Util.checkArgument((z && z2) ? false : true, "cannot mix indexed and positional parameters", new Object[0]);
                        addArgument(str, cCharAt, objArr[i4]);
                        this.formatParts.add("$" + cCharAt);
                        i4 = i2;
                        i3 = i;
                        z3 = z;
                    }
                }
            }
            if (z2) {
                Util.checkArgument(i4 >= objArr.length, "unused arguments: expected %s, received %s", Integer.valueOf(i4), Integer.valueOf(objArr.length));
            }
            if (z3) {
                ArrayList arrayList = new ArrayList();
                for (int i9 = 0; i9 < objArr.length; i9++) {
                    if (iArr[i9] == 0) {
                        arrayList.add("$" + (i9 + 1));
                    }
                }
                Util.checkArgument(arrayList.isEmpty(), "unused argument%s: %s", arrayList.size() == 1 ? "" : "s", Util.join(", ", arrayList));
            }
            return this;
        }

        private void addArgument(String str, char c, Object obj) {
            if (c == 'L') {
                this.args.add(argToLiteral(obj));
                return;
            }
            if (c == 'N') {
                this.args.add(argToName(obj));
            } else if (c == 'S') {
                this.args.add(argToString(obj));
            } else {
                if (c == 'T') {
                    this.args.add(argToType(obj));
                    return;
                }
                throw new IllegalArgumentException(String.format("invalid format string: '%s'", str));
            }
        }

        private String argToName(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof ParameterSpec) {
                return ((ParameterSpec) obj).name;
            }
            if (obj instanceof FieldSpec) {
                return ((FieldSpec) obj).name;
            }
            if (obj instanceof MethodSpec) {
                return ((MethodSpec) obj).name;
            }
            if (obj instanceof TypeSpec) {
                return ((TypeSpec) obj).name;
            }
            throw new IllegalArgumentException("expected name but was " + obj);
        }

        private String argToString(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        private TypeName argToType(Object obj) {
            if (obj instanceof TypeName) {
                return (TypeName) obj;
            }
            if (obj instanceof TypeMirror) {
                return TypeName.get((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return TypeName.get(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return TypeName.get((Type) obj);
            }
            throw new IllegalArgumentException("expected type but was " + obj);
        }

        public Builder beginControlFlow(String str, Object... objArr) {
            add(str + " {\n", objArr);
            indent();
            return this;
        }

        public Builder nextControlFlow(String str, Object... objArr) {
            unindent();
            add("} " + str + " {\n", objArr);
            indent();
            return this;
        }

        public Builder endControlFlow() {
            unindent();
            add("}\n", new Object[0]);
            return this;
        }

        public Builder addStatement(String str, Object... objArr) {
            add("$[", new Object[0]);
            add(str, objArr);
            add(";\n$]", new Object[0]);
            return this;
        }

        public Builder add(CodeBlock codeBlock) {
            this.formatParts.addAll(codeBlock.formatParts);
            this.args.addAll(codeBlock.args);
            return this;
        }

        public Builder indent() {
            this.formatParts.add("$>");
            return this;
        }

        public Builder unindent() {
            this.formatParts.add("$<");
            return this;
        }

        public CodeBlock build() {
            return new CodeBlock(this);
        }
    }
}
