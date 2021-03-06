package net.nemerosa.ontrack.jenkins.pipeline

class ParamUtils {

    static String getParam(Map params, String key) {
        String value = params[key] as String
        if (value) {
            return value
        } else {
            throw new IllegalArgumentException("Missing parameter: $key")
        }
    }

    static String getParam(Map params, String key, String defaultValue) {
        String value = params[key] as String
        if (value) {
            return value
        } else if (defaultValue) {
            return defaultValue
        } else {
            throw new IllegalArgumentException("Missing parameter: $key")
        }
    }

    static boolean getBooleanParam(Map<String, ?> params, String key, boolean defaultValue) {
        def value = params.get(key)
        if (value != null) {
            return value as boolean
        } else {
            return defaultValue
        }
    }
}
