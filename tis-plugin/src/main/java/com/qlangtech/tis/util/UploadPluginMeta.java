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
package com.qlangtech.tis.util;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析提交的plugin元数据信息，如果plugin为"xxxplugin:require" 则是在告诉服务端，该plugin必须要有输入内容，该plugin不可缺省
 *
 * @author 百岁（baisui@qlangtech.com）
 * @create: 2020-07-20 11:00
 */
public class UploadPluginMeta {

    private static final Pattern PATTERN_PLUGIN_ATTRIBUTE = Pattern.compile("\\w+");

    private static final Pattern PATTERN_PLUGIN_META = Pattern.compile("(.+?)(:(,?(" + PATTERN_PLUGIN_ATTRIBUTE + "))+)?");

    private static final String KEY_REQUIRE = "require";

    public static List<UploadPluginMeta> parse(String[] plugins) {
        if (plugins == null || plugins.length < 1) {
            throw new IllegalArgumentException("plugin size:" + plugins.length + " length can not small than 1");
        }
        List<UploadPluginMeta> metas = Lists.newArrayList();
        UploadPluginMeta pmeta = null;
        Matcher matcher = null;
        Matcher attrMatcher = null;
        for (String plugin : plugins) {
            matcher = PATTERN_PLUGIN_META.matcher(plugin);
            if (matcher.matches()) {
                pmeta = new UploadPluginMeta(matcher.group(1));
                if (matcher.group(2) != null) {
                    attrMatcher = PATTERN_PLUGIN_ATTRIBUTE.matcher(matcher.group(2));
                    while (attrMatcher.find()) {
                        switch(attrMatcher.group()) {
                            case KEY_REQUIRE:
                                pmeta.required = true;
                                break;
                            default:
                                throw new IllegalStateException("plugin is not valid:" + plugin);
                        }
                    }
                }
                metas.add(pmeta);
            } else {
                throw new IllegalStateException("plugin:" + plugin + " is not match the pattern:" + PATTERN_PLUGIN_META);
            }
        }
        if (plugins.length != metas.size()) {
            throw new IllegalStateException("param plugins length:" + plugins.length + " must equal with metaSize:" + metas.size());
        }
        return metas;
    }

    public static void main(String[] args) {
        String[] plugins = new String[] { "test_plugin:require" };
        List<UploadPluginMeta> pluginMetas = parse(plugins);
        for (UploadPluginMeta m : pluginMetas) {
            System.out.println(m);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    private final String name;

    private boolean required;

    public UploadPluginMeta(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UploadPluginMeta{" + "name='" + name + '\'' + ", required=" + required + '}';
    }
}
