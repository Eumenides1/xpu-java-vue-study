package com.rookie.stack.xpu.common.context;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
public class UserContext {
    private static final ThreadLocal<String> user = new ThreadLocal<>();
    public static void add(String userId) {
        user.set(userId);
    }
    public static void remove(){
        user.remove();
    }
    public static String getCurrentUserId(){
        return user.get();
    }

}
