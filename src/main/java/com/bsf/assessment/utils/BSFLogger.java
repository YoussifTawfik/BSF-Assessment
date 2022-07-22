package com.bsf.assessment.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BSFLogger {

    protected Logger logger;

    protected BSFLogger(final Class sourceClass) {
        this.logger = LoggerFactory.getLogger(sourceClass.getName());

    }

    protected BSFLogger(final Class sourceClass, String Prefix) {
        this.logger = LoggerFactory.getLogger(sourceClass.getName());

    }

    public static BSFLogger getInstance(final Class sourceClass, String Prefix) {
        return new BSFLogger(sourceClass, Prefix);
    }

    public static BSFLogger getInstance(final Class sourceClass) {
        return new BSFLogger(sourceClass);
    }

    public void traceEntry(final String methodName) {
        this.logger.info("Entry: " + methodName);
    }

    public void traceExit(final String methodName) {
        this.logger.info("Exit: " + methodName);
    }

    public void logInfo(final String methodName, final String msg) {
        this.logger.info(methodName + " " + msg);
    }

    public void logInfo(final String methodName, final String msg, final Object param) {
        this.logger.info(methodName + " " + msg, param);
    }

    public void logInfo(final String methodName, final String msg, final Object[] params) {
        this.logger.info(methodName + " " + msg, params);
    }
}
