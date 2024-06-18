package com.rookie.stack.mybatisplus.config;

/**
 * @author eumenides
 * @description
 * @date 2024/6/18
 */
public class StdoutLogger extends com.p6spy.engine.spy.appender.StdoutLogger {
    public void logText(String text) {
        System.err.println(text);
    }
}
