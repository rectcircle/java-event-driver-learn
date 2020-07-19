package cn.rectcircle.learn.base;

import cn.rectcircle.learn.event.AbstractEvent;
import cn.rectcircle.learn.event.Dispatcher;

/**
 * @author rectcircle
 */
public class BaseEvent extends AbstractEvent<BaseEventType> {

    private final String word;

    public BaseEvent(final Dispatcher dispatcher, final BaseEventType type, final String word) {
        super(dispatcher, type);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

}