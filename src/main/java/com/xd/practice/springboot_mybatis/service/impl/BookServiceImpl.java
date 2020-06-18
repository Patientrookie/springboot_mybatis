package com.xd.practice.springboot_mybatis.service.impl;

import com.xd.practice.springboot_mybatis.common.BaseResponseCode;
import com.xd.practice.springboot_mybatis.model.BookEntity;
import com.xd.practice.springboot_mybatis.dao.BookMapper;
import com.xd.practice.springboot_mybatis.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xd.practice.springboot_mybatis.common.CommonException;
import com.xd.practice.springboot_mybatis.common.RetJson;
import com.xd.practice.springboot_mybatis.enums.RetCode;
import com.xd.practice.springboot_mybatis.utils.UuidUtil;
import com.xd.practice.springboot_mybatis.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shawn
 * @since 2020-06-18
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookEntity> implements IBookService {

    @Autowired
    private PageUtils pageUtils;

    /**
     * 分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public IPage<BookEntity> page(BookEntity param) {

        QueryWrapper<BookEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                // 主键ID
                .eq(!StringUtils.isEmpty(param.getId()), BookEntity::getId, param.getId())
                // 书名
                .eq(!StringUtils.isEmpty(param.getName()), BookEntity::getName, param.getName())
                // 对书的描述
                .eq(!StringUtils.isEmpty(param.getDesc()), BookEntity::getDesc, param.getDesc())
                // 出版社
                .eq(!StringUtils.isEmpty(param.getPress()), BookEntity::getPress, param.getPress())
                // 删除标识（0 未删除 1 已删除）
                .eq(param.getDelFlag() != null, BookEntity::getDelFlag, param.getDelFlag())
                // 创建时间
                .eq(param.getCreateTime() != null, BookEntity::getCreateTime, param.getCreateTime())
                // 创建人（存ID）
                .eq(!StringUtils.isEmpty(param.getCreateBy()), BookEntity::getCreateBy, param.getCreateBy())
                // 更新时间
                .eq(param.getUpdateTime() != null, BookEntity::getUpdateTime, param.getUpdateTime())
                // 更新人（存ID）
                .eq(!StringUtils.isEmpty(param.getUpdateBy()), BookEntity::getUpdateBy, param.getUpdateBy())
        ;

        IPage<BookEntity> page = page(pageUtils.page(), queryWrapper);

        return page;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public BookEntity info(String id) {
        BookEntity book = getById(id);
        if(book == null){
            throw new CommonException(BaseResponseCode.OPERATION_ERRO);
        }
        return getById(id);
    }

    /**
     * 新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void add(BookEntity param) {

        param.setId(UuidUtil.base58Uuid());
        param.setCreateBy("shawn");
        param.setUpdateBy("shawn");
        param.setCreateTime(LocalDateTime.now());
        param.setUpdateTime(LocalDateTime.now());
        param.setDelFlag(0);


        if (!save(param)) {
            throw new CommonException(BaseResponseCode.OPERATION_ERRO);
        }
    }

    /**
     * 修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void modify(BookEntity param) {

        if (!updateById(param)) {
            throw new CommonException(BaseResponseCode.OPERATION_ERRO);
        }
    }

    /**
     * 删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) {
        removeById(id);
    }

    /**
     * 删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) {
        removeByIds(ids);
    }
}
