package com.ym.smartweb.auth.handler;


import jakarta.servlet.http.HttpServletRequest;

/**
 * @author qushutao
 * @since 2025/8/31 9:54
 **/
public abstract class AbstractHandler {

    protected AbstractHandler next;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.next = nextHandler;
    }

    public AbstractHandler nextHandler() {
        return next;
    }

    public abstract boolean handle(HttpServletRequest request);


    // 添加一个不修改原始状态的链式执行方法
    public boolean handleWithNext(HttpServletRequest request, AbstractHandler nextHandler) {
        boolean result = handle(request);
        if (result && nextHandler != null) {
            return nextHandler.handleWithNext(request, nextHandler.next);
        }
        return result;
    }
}
