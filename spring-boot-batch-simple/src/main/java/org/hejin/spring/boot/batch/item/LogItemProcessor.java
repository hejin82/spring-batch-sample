package org.hejin.spring.boot.batch.item;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;

public class LogItemProcessor implements ItemProcessor<String, String> {

    private static final Log log = LogFactory.getLog(LogItemProcessor.class);

    public String process(String item) throws Exception {
        log.info(item);
        return item;
    }

}
