/*
 * Copyright 2015 AML Innovation & Consulting LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.amlinv.thread.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DaemonThreadFactory implements ThreadFactory {
    private AtomicInteger num = new AtomicInteger(0);
    private String namePrefix = "daemon-thread-";

    public DaemonThreadFactory(String prefix) {
        this.namePrefix = prefix;
    }

    public Thread newThread(Runnable run) {
        Thread result = new Thread(run);

        result.setDaemon(true);
        result.setName(namePrefix + num.incrementAndGet());

        return result;
    }
}
