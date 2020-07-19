package cn.rectcircle.learn.main;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.rectcircle.learn.base.BaseEvent;
import cn.rectcircle.learn.base.BaseEventType;
import cn.rectcircle.learn.event.AsyncDispatcher;

/**
 * @author rectcircle
 */
@SuppressWarnings({"PMD.ThreadPoolCreationRule", "PMD.UndefineMagicConstantRule"})
public class BaseUsage {

    private static final Logger LOG = LoggerFactory.getLogger(BaseUsage.class);

    public static void main(String[] args) {
        
        AsyncDispatcher dispatcher = new AsyncDispatcher(
            Executors.newSingleThreadExecutor()
        );

        // 注册处理器
        dispatcher.register(BaseEventType.HELLO, (BaseEvent e) -> {
            LOG.info("Hello " + e.getWord());
        });
        dispatcher.register(BaseEventType.HI, (BaseEvent e) -> {
            LOG.info("Hi " + e.getWord());
        });

        // 启动事件循环
        dispatcher.serviceStart();

        // 发送事件
        for (int i = 0; i < 10; i++) {
            dispatcher.dispatchEvent(new BaseEvent(dispatcher, BaseEventType.HELLO, "World"));
            dispatcher.dispatchEvent(new BaseEvent(dispatcher, BaseEventType.HI, "世界"));
        }
    }
}