package xyz.jiang.mall.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.jiang.mall.common.ApiRestResponse;
import xyz.jiang.mall.common.Constant;
import xyz.jiang.mall.exception.MallException;
import xyz.jiang.mall.exception.MallExceptionEnum;
import xyz.jiang.mall.model.VO.CategoryVO;
import xyz.jiang.mall.model.pojo.Category;
import xyz.jiang.mall.model.pojo.User;
import xyz.jiang.mall.model.request.AddCategoryReq;
import xyz.jiang.mall.model.request.UpdateCategoryReq;
import xyz.jiang.mall.service.CategoryService;
import xyz.jiang.mall.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @Program: mall
 * @Classname CategoryController
 * @Description: TODO
 * @Author: JiangKan
 * @Create: 2020-10-07
 **/
@Controller
public class CategoryController {

    @Resource
    private UserService userService;
    @Resource
    private CategoryService categoryService;

    @ApiOperation("后台添加目录")
    @PostMapping("/admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session,@Valid @RequestBody AddCategoryReq addCategoryReq) {
        /*if (addCategoryReq.getName() == null || addCategoryReq.getType() == null || addCategoryReq.getOrderNum() == null || addCategoryReq.getParentId() == null ) {
            return ApiRestResponse.error(MallExceptionEnum.PARA_NOT_NULL);

        }*/
        User currentUser = (User)session.getAttribute(Constant.MALL_USER);
        if (null == currentUser) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN);
        }
        //校验是否是管理员
        boolean adminRole = userService.checkAdminRole(currentUser);
        if (adminRole) {
            //是管理员
            categoryService.add(addCategoryReq);
            return ApiRestResponse.success();
        }else {
            //不是管理员则无权限操作
            return ApiRestResponse.error(MallExceptionEnum.NEED_ADDMIN);
        }
    }

    @ApiOperation("后台更新目录")
    @PostMapping("/admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(HttpSession session,@Valid @RequestBody  UpdateCategoryReq updateCategoryReq){
        User currentUser = (User)session.getAttribute(Constant.MALL_USER);
        if (null == currentUser) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN);
        }
        //校验是否是管理员
        boolean adminRole = userService.checkAdminRole(currentUser);
        if (adminRole) {
            //是管理员
            Category category = new Category();
            BeanUtils.copyProperties(updateCategoryReq, category);
            categoryService.update(category);
            return ApiRestResponse.success();
        }else {
            //不是管理员则无权限操作
            return ApiRestResponse.error(MallExceptionEnum.NEED_ADDMIN);
        }

    }

    @ApiOperation("后台删除目录")
    @PostMapping("/admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam  Integer id){
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("管理员获取后台目录列表")
    @PostMapping("/admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("用户获取后台目录列表")
    @PostMapping("/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer(){
        List<CategoryVO>  categoryVOS = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.success(categoryVOS);
    }

}
