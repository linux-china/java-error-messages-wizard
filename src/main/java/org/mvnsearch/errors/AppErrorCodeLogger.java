package org.mvnsearch.errors;

import org.jetbrains.annotations.PropertyKey;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.Locale;
import java.util.ResourceBundle;

public class AppErrorCodeLogger implements Logger {
    private final Logger delegate;
    private static final String BUNDLE_FQN = "app.ErrorMessages";
    private static final String ERROR_CODE_NAME = "error";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_FQN, new Locale("en", "US"));

    public AppErrorCodeLogger(Logger delegate) {
        this.delegate = delegate;
    }

    public static String errorMessage(@PropertyKey(resourceBundle = BUNDLE_FQN) String key, Object... params) {
        if (RESOURCE_BUNDLE.containsKey(key)) {
            String value = RESOURCE_BUNDLE.getString(key);
            final FormattingTuple tuple = MessageFormatter.arrayFormat(value, params);
            return key + " - " + tuple.getMessage();
        } else {
            return MessageFormatter.arrayFormat(key, params).getMessage();
        }
    }

    private static String errorCodeFormat(String errorCode) {
        if (RESOURCE_BUNDLE.containsKey(errorCode)) {
            //return errorCode + " - " + RESOURCE_BUNDLE.getString(errorCode);
            return RESOURCE_BUNDLE.getString(errorCode);
        } else {
            return errorCode;
        }
    }

    @Override
    public void trace(@PropertyKey(resourceBundle = BUNDLE_FQN) String format) {
        delegate.atTrace().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format));
    }

    @Override
    public void trace(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atTrace().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }


    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return delegate.isTraceEnabled();
    }


    @Override
    public void trace(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atTrace().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void trace(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atTrace().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void trace(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atTrace().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return delegate.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atTrace().addKeyValue(ERROR_CODE_NAME, msg).addMarker(marker).log(errorCodeFormat(msg));
    }

    @Override
    public void trace(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atTrace().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void trace(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atTrace().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void trace(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... argArray) {
        delegate.atTrace().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), argArray);
    }

    @Override
    public void trace(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atTrace().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isDebugEnabled() {
        return delegate.isDebugEnabled();
    }

    @Override
    public void debug(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atDebug().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void debug(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atDebug().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void debug(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atDebug().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void debug(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atDebug().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void debug(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atDebug().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return delegate.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atDebug().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void debug(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atDebug().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void debug(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atDebug().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void debug(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atDebug().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void debug(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atDebug().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isInfoEnabled() {
        return delegate.isInfoEnabled();
    }

    @Override
    public void info(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atInfo().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void info(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atInfo().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void info(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atInfo().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void info(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atInfo().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void info(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atInfo().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return delegate.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atInfo().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void info(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atInfo().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void info(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atInfo().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void info(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atInfo().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void info(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atInfo().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isWarnEnabled() {
        return delegate.isWarnEnabled();
    }

    @Override
    public void warn(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atWarn().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void warn(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atWarn().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void warn(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atWarn().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void warn(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atWarn().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void warn(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atWarn().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return delegate.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atWarn().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void warn(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atWarn().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void warn(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atWarn().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void warn(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atWarn().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void warn(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atWarn().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isErrorEnabled() {
        return delegate.isErrorEnabled();
    }

    @Override
    public void error(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atError().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void error(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atError().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void error(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atError().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void error(@PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atError().addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void error(@PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atError().addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return delegate.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg) {
        delegate.atError().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg));
    }

    @Override
    public void error(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg) {
        delegate.atError().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg);
    }

    @Override
    public void error(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object arg1, Object arg2) {
        delegate.atError().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arg1, arg2);
    }

    @Override
    public void error(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String format, Object... arguments) {
        delegate.atError().addMarker(marker).addKeyValue(ERROR_CODE_NAME, format).log(errorCodeFormat(format), arguments);
    }

    @Override
    public void error(Marker marker, @PropertyKey(resourceBundle = BUNDLE_FQN) String msg, Throwable t) {
        delegate.atError().addMarker(marker).addKeyValue(ERROR_CODE_NAME, msg).log(errorCodeFormat(msg), t);
    }
}
