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
package com.qlangtech.tis.manage.biz.dal.dao;

import com.qlangtech.tis.manage.biz.dal.pojo.GroupInfo;
import com.qlangtech.tis.manage.biz.dal.pojo.GroupInfoCriteria;
import java.util.List;

/**
 * @author 百岁（baisui@qlangtech.com）
 * @date 2020/04/13
 */
public interface IGroupInfoDAO {

    int countByExample(GroupInfoCriteria example);

    int countFromWriteDB(GroupInfoCriteria example);

    int deleteByExample(GroupInfoCriteria criteria);

    int deleteByPrimaryKey(Integer gid);

    void insert(GroupInfo record);

    void insertSelective(GroupInfo record);

    List<GroupInfo> selectByExample(GroupInfoCriteria criteria);

    List<GroupInfo> selectByExample(GroupInfoCriteria example, int page, int pageSize);

    GroupInfo selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(GroupInfo record, GroupInfoCriteria example);

    int updateByExample(GroupInfo record, GroupInfoCriteria example);

    GroupInfo loadFromWriteDB(Integer gid);
}
