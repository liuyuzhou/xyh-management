/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.core.common.constant.dictmap;

import cn.stylefeng.guns.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * 通知的映射
 *
 * @author fengshuonan
 * @date 2017-05-06 15:01
 */
public class NoticeMap extends AbstractDictMap {

	@Override
	public void init() {
		put("activateId", "标题id");
		put("title", "标题");
		put("address", "地址");
		put("meetingPlace", "会议地址");
		put("actTime", "会议地址");
		put("actTime", "活动开始时间");
		put("endTime", "活动结束时间");
		put("content", "内容");
		put("participateNum", "参加人数");
		put("cost", "费用");
		put("status", "状态");
	}

	@Override
	protected void initBeWrapped() {
	}
}
