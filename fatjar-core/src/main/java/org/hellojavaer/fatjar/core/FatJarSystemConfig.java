/*
 * Copyright 2017-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hellojavaer.fatjar.core;

/**
 *
 * @author <a href="mailto:hellojavaer@gmail.com">Kaiming Zou</a>,created on 13/03/2017.
 */
class FatJarSystemConfig {

    private static final Logger logger            = new Logger();

    private static final String TEMP_FILE_DIR_KEY = "fatjar.temp.dir";
    private static final String LOG_LEVEL_KEY     = "fatjar.log.level";

    static {
        if (logger.isDebugEnabled()) {
            logger.debug("FatJarSystemConfig is loaded by " + FatJarSystemConfig.class.getClassLoader());
        }
    }

    public static String getTempDir() {
        return get(TEMP_FILE_DIR_KEY);
    }

    public static int getLogLevel() {
        String level = get(LOG_LEVEL_KEY);
        if ("error".equals(level)) {
            return 0;
        } else if ("warn".equals(level)) {
            return 1;
        } else if ("info".equals(level)) {
            return 2;
        } else if ("debug".equals(level)) {
            return 3;
        } else if ("trace".equals(level)) {
            return 4;
        } else {
            return 2;
        }
    }

    private static String get(String key) {
        String str = System.getProperty(key);
        if (str == null) {
            return null;
        } else {
            str = str.trim();
            if (str.length() == 0) {
                return null;
            } else {
                return str;
            }
        }
    }
}
