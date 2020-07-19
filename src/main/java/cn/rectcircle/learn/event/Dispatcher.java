package cn.rectcircle.learn.event;

/**
 * Event Dispatcher interface. It dispatches events to registered event handlers
 * based on event types. 事件分发器。用于将事件分发到注册到 该 事件 eventType 的 EventHandler
 *
 * @author
 */
public interface Dispatcher {

    /**
     * 触发一个事件
     * @param event 一个事件
     */
    <T extends Enum<T>, E extends Event<T>> void dispatchEvent(E event);

    /**
     * 注册一个消息
     * @param eventType 事件类型
     * @param handler 事件处理器
     */
    <T extends Enum<T>, E extends Event<T>> void register(T eventType, EventHandler<T, E> handler);
}
