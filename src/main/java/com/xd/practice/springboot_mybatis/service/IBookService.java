package com.xd.practice.springboot_mybatis.service;

import com.xd.practice.springboot_mybatis.model.BookEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
* <p>
 *  服务类
 * </p>
*
* @author shawn
* @since 2020-06-18
*/
 public interface IBookService extends IService<BookEntity> {

 /**
 * 分页列表
 * @param param 根据需要进行传值
 * @return
 */
 IPage<BookEntity> page(BookEntity param);

 /**
 * 详情
 * @param id
 * @return
 */
 BookEntity info(String id);

 /**
 * 新增
 * @param param 根据需要进行传值
 * @return
 */
 void add(BookEntity param);

 /**
 * 修改
 * @param param 根据需要进行传值
 * @return
 */
 void modify(BookEntity param);

 /**
 * 删除(单个条目)
 * @param id
 * @return
 */
 void remove(Long id);

 /**
 * 删除(多个条目)
 * @param ids
 * @return
 */
 void removes(List<Long> ids);
 }
