package io.github.huanyv.util;

import com.intellij.ide.util.PropertiesComponent;

public class SimpleConfigUtil {

    private static final PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();

    public static String getString(String key) {
        return propertiesComponent.getValue(key);
    }

    public static boolean getBoolean(String key) {
        return propertiesComponent.getBoolean(key);
    }

    public static void save(String key, Object value) {
        if (value instanceof String) {
            save(key, (String) value);
        } else if (value instanceof Integer) {
            save(key, (int) value);
        } else if (value instanceof Boolean) {
            save(key, (boolean) value);
        } else if (value instanceof Float) {
            save(key, (float) value);
        }
    }

    private static void save(String key, String value) {
        propertiesComponent.setValue(key, value);
    }

    private static void save(String key, int value) {
        propertiesComponent.setValue(key, value, 0);
    }

    private static void save(String key, boolean value) {
        propertiesComponent.setValue(key, value);
    }

    private static void save(String key, float value) {
        propertiesComponent.setValue(key, value, 0.0f);
    }

}
