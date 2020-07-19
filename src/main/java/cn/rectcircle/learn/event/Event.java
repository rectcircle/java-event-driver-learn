package cn.rectcircle.learn.event;

/**
 * Interface defining events api.
 * 事件接口
 * @author
 */
public interface Event<T extends Enum<T>> {

    /**
     * 事件类型
     * @return
     */
    T getType();

    /**
     * 事件触发的时间戳
     * @return 时间戳
     */
    long getTimestamp();

    /**
     * 获取分发器
     * 
     * @return {@link Dispatcher}
     */
    Dispatcher getDispatcher();

    /**
     * human string of event
     * @return
     */
    @Override
    String toString();

}