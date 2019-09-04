package com.zx.starter.controller.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author zhouxiong
 * @description
 * @date 2019/8/27 14:55
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
}
