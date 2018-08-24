package cn.code.javaex.DTDL.exa;

import java.lang.reflect.Proxy;

public abstract class ProviderFactory {
    public static FontProvider getFontProvider() {
        Class<FontProvider> targetClass = FontProvider.class;
        return (FontProvider) Proxy.newProxyInstance(targetClass.getClassLoader(),
                new Class[] { targetClass },
                new CachedProviderHandler(new FontProviderFromDisk()));
    }
}