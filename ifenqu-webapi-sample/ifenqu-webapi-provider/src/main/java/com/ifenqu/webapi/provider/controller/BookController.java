package com.ifenqu.webapi.provider.controller;

import com.ifenqu.webapi.annotation.Anonymous;
import com.ifenqu.webapi.controller.BasicController;
import com.ifenqu.webapi.provider.model.User;
import com.ifenqu.webapi.provider.util.DateUtils;
import com.ifenqu.webapi.exception.ApiExCode;
import com.ifenqu.webapi.model.OpResult;
import com.ifenqu.webapi.model.PageResult;
import com.ifenqu.webapi.provider.model.Book;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "Book", description = "图书增删改查API")
@RestController
@RequestMapping("/v1/books")
public class BookController extends BasicController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "分页获取图书列表", notes = "本接口限制调用限制为100次/秒")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页,从0开始", paramType = "query", dataType = "int", defaultValue = "0")
    })
    @GetMapping()
    public OpResult<PageResult<Book>> pagingQueryBooks(@RequestParam(required = false) Integer page) throws Exception {
        if (page == null || page < 0)
            page = 0;


        PageResult<Book> pageResult = new PageResult<Book>()
                .setTotal(1200)
                .setRows(this.constructBooks());
        return result(pageResult);
    }

    @ApiOperation("新增图书")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "book", value = "要新增的图书信息", paramType = "body")
    })
    @PostMapping
    public OpResult<String> addNewBook(@Valid @RequestBody Book book) {
        return result(book.getIsbn());
    }

    @ApiOperation("更新图书信息")
    @PutMapping("/{bookId}")
    public OpResult<String> editBook(@PathVariable String bookId, @RequestBody Book book) {
        return result(bookId);
    }

    @Anonymous
    @ApiOperation(" 测试")
    @GetMapping("/test")
    public OpResult<String> test(User user, Integer offset, Integer limit) {
        return result("hello world" + user.getName());
    }


    @Anonymous
    @ApiOperation(" 测试")
    @GetMapping("/error")
    public OpResult<String> error() {
        return error(ApiExCode.GENERAL_REQUEST_ERROR);
    }

    @ApiOperation("删除图书")
    @DeleteMapping("/{bookId}")
    public OpResult deleteBookById(@PathVariable String bookId) {
        return success();
    }

    private List<Book> constructBooks() {
        List<Book> books = new ArrayList<>();

        try {
            books.add(new Book().setIsbn("9787515407289").setName("Google:未来之镜(全球创新巨头真正的工作、思索与规划)").setPublishDate(DateUtils.parseShortDate("2016-11-01")));
            books.add(new Book().setIsbn("9787115373557").setName("数学之美(第二版)").setPublishDate(DateUtils.parseShortDate("2014-11-01")));
            books.add(new Book().setIsbn("7302423288").setName("机器学习)").setPublishDate(DateUtils.parseShortDate("2016-01-01")));
            logger.info("books:{}", books);
        } catch (ParseException e) {
            //provider only
        }
        return books;
    }
}
