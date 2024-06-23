package com.rookie.stack.xpu.common.context;

/**
 * @author eumenides
 * @description
 * @date 2024/6/23
 */
public final class UserContext {
    private static final ThreadLocal<String> user = new ThreadLocal<String>();

    public static void add(String userId) {
        user.set(userId);
    }

    public static void remove() {
        user.remove();
    }

    /**
     * @return 当前登录用户的用户名
     */
    public static String getCurrentUserId() {
        return user.get();
    }
}
