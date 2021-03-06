/**
 * Copyright (c) 2020 QingLang, Inc. <baisui@qlangtech.com>
 *
 * This program is free software: you can use, redistribute, and/or modify
 * it under the terms of the GNU Affero General Public License, version 3
 * or later ("AGPL"), as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.qlangtech.tis.plugin;

import java.util.regex.Pattern;

/**
 * @author 百岁（baisui@qlangtech.com）
 * @create: 2020-06-12 14:40
 */
public interface ValidatorCommons {

    Pattern PATTERN_URL = Pattern.compile("(https?|hdfs)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");

    String MSG_URL_ERROR = "不符合URL的规范";

    Pattern pattern_identity = Pattern.compile("[a-z]{1}[\\da-z_\\-]+");

    Pattern pattern_integer = Pattern.compile("[1-9]{1}[\\d]{0,}");

    String MSG_INTEGER_ERROR = "必须是整型数字";

    String MSG_IDENTITY_ERROR = "必须由小写字母开头，数字、下划线、字母、减号结尾";

    Pattern host_pattern = Pattern.compile("[\\da-z]{1}[\\da-z.]+:\\d+");

    String MSG_HOST_IP_ERROR = "必须由IP、HOST及端口号组成";

    String MSG_EMPTY_INPUT_ERROR = "必须填写";
}
