package com.xd.practice.springboot_mybatis.controller;

import com.xd.practice.springboot_mybatis.model.BookEntity;
import com.xd.practice.springboot_mybatis.service.IBookService;
import com.xd.practice.springboot_mybatis.common.RetJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

/**
* <p>
*  前端控制器
* </p>
*
* @author shawn
* @since 2020-06-18
*/
@Api(value= "",tags = "")
@RestController
@RequestMapping("//book-entity")
        public class BookController {

    @Autowired
    private IBookService iBookService;

    @ApiOperation(value = "分页列表", response = BookEntity.class)
    @ApiImplicitParams({
    @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
    @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
    @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
    @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")})
    @PostMapping(value = "/page")
    public  Object list(@Valid @RequestBody BookEntity param) {

    Object data = iBookService.page(param);
    return RetJson.ok(data);
    }

    @ApiOperation(value = "详情", response = BookEntity.class)
    @GetMapping(value = "/info/{id}")
    public  Object info(@PathVariable String id) {

    Object data = iBookService.info(id);
    return RetJson.ok(data);
    }

    @ApiOperation(value = "新增")
    @PostMapping(value = "/add")
    public  Object add(@Valid @RequestBody BookEntity param) {

    iBookService.add(param);
    return RetJson.ok();
    }

    @ApiOperation(value = "修改")
    @PostMapping(value = "/modify")
    public  Object modify(@Valid @RequestBody BookEntity param) {

    iBookService.modify(param);
    return RetJson.ok();
    }

    @ApiOperation(value = "删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public  Object remove(@PathVariable Long id) {

    iBookService.remove(id);
    return RetJson.ok();
    }

    @ApiOperation(value = "删除(多个条目)")
    @PostMapping(value = "/removes")
    public  Object removes(@Valid @RequestBody List
    <Long> ids) {

        iBookService.removes(ids);
        return RetJson.ok();
        }

        }
