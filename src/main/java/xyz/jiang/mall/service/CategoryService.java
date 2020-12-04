package xyz.jiang.mall.service;

import com.github.pagehelper.PageInfo;
import xyz.jiang.mall.model.VO.CategoryVO;
import xyz.jiang.mall.model.pojo.Category;
import xyz.jiang.mall.model.request.AddCategoryReq;

import java.util.List;

/**
 * 描述： 分类目录 Service
*/
public interface CategoryService {
    public void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategory);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listCategoryForCustomer(Integer parentId);
}
