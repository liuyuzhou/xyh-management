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
package cn.stylefeng.guns.modular.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cn.stylefeng.guns.core.util.DateConver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.stylefeng.guns.core.common.annotion.BussinessLog;
import cn.stylefeng.guns.core.common.constant.dictmap.DeleteDict;
import cn.stylefeng.guns.core.common.constant.dictmap.NoticeMap;
import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.modular.system.entity.Notice;
import cn.stylefeng.guns.modular.system.service.NoticeService;
import cn.stylefeng.guns.modular.system.warpper.NoticeWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * 通知控制器
 *
 * @author fengshuonan
 * @Date 2017-05-09 23:02:21
 */
@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController {

	private String PREFIX = "/modular/system/notice/";
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		datetimeFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(datetimeFormat, false));
	}

	@Autowired
	private NoticeService noticeService;

	/**
	 * 跳转到通知列表首页
	 *
	 * @author fengshuonan
	 * @Date 2018/12/23 6:06 PM
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "notice.html";
	}

	/**
	 * 跳转到添加通知
	 *
	 * @author fengshuonan
	 * @Date 2018/12/23 6:06 PM
	 */
	@RequestMapping("/notice_add")
	public String noticeAdd() {
		return PREFIX + "notice_add.html";
	}

	/**
	 * 跳转到修改通知
	 *
	 * @author fengshuonan
	 * @Date 2018/12/23 6:06 PM
	 */
	@RequestMapping("/notice_update/{noticeId}")
	public String noticeUpdate(@PathVariable Long noticeId, Model model) {
		Notice notice = this.noticeService.getById(noticeId);
		model.addAllAttributes(DateConver.beanToMap(notice));
		LogObjectHolder.me().set(notice);
		return PREFIX + "notice_edit.html";
	}

	/**
	 * 获取通知列表
	 *
	 * @author fengshuonan
	 * @Date 2018/12/23 6:06 PM
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		Page<Map<String, Object>> list = this.noticeService.list(condition);
		Page<Map<String, Object>> wrap = new NoticeWrapper(list).wrap();
		return LayuiPageFactory.createPageInfo(wrap);
	}

	/**
	 * 新增通知
	 *
	 * @author fengshuonan
	 * @Date 2018/12/23 6:06 PM
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	@BussinessLog(value = "新增通知", key = "title", dict = NoticeMap.class)
	public Object add(Notice notice) {
		if (ToolUtil.isOneEmpty(notice, notice.getTitle(), notice.getContent())) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		// notice.setCreateUser(ShiroKit.getUserNotNull().getId());
		notice.setActCreator(ShiroKit.getUserNotNull().getName());
		notice.setCreateTime(new Date());
		notice.setUpdateTime(new Date());
		this.noticeService.save(notice);
		return SUCCESS_TIP;
	}

	/**
	 * 删除通知
	 *
	 * @author fengshuonan
	 * @Date 2018/12/23 6:06 PM
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	@BussinessLog(value = "删除通知", key = "noticeId", dict = DeleteDict.class)
	public Object delete(@RequestParam Long noticeId) {

		// 缓存通知名称
		LogObjectHolder.me().set(ConstantFactory.me().getNoticeTitle(noticeId));

		this.noticeService.removeById(noticeId);

		return SUCCESS_TIP;
	}

	/**
	 * 修改通知
	 *
	 * @author fengshuonan
	 * @Date 2018/12/23 6:06 PM
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	@BussinessLog(value = "修改通知", key = "title", dict = NoticeMap.class)
	public Object update(Notice notice) {
		if (ToolUtil.isOneEmpty(notice, notice.getActivateId(), notice.getTitle(), notice.getActTime(),
				notice.getEndTime(), notice.getActCreator(), notice.getContent(), notice.getParticipateNum(),
				notice.getCost())) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		Notice old = this.noticeService.getById(notice.getActivateId());
		old.setTitle(notice.getTitle());
		old.setAddress(notice.getAddress());
		old.setActTime(notice.getActTime());
		old.setEndTime(notice.getEndTime());
		old.setMeetingPlace(notice.getMeetingPlace());
		old.setActCreator(notice.getActCreator());
		old.setContent(notice.getContent());
		old.setParticipateNum(notice.getParticipateNum());
		old.setCost(notice.getCost());
		old.setUpdateTime(new Date());
		this.noticeService.updateById(old);
		return SUCCESS_TIP;
	}

}
