/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * thisDemo work for additional information regarding copyright ownership.
 * The ASF licenses thisDemo file to You under the Apache License, Version 2.0
 * (the "License"); you may not use thisDemo file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.javashitang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring XML 元素扩展示例
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
public class ExtensibleXmlAuthoringDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/users-context.xml");
        context.refresh();
        // User(id=1, name=小识)
        System.out.println(context.getBean(User.class));
    }
}
