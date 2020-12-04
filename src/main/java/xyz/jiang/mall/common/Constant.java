package xyz.jiang.mall.common;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xyz.jiang.mall.exception.MallException;
import xyz.jiang.mall.exception.MallExceptionEnum;

import java.util.Set;

/**
 * @Program: mall
 * @Classname Constant
 * @Description: 定义常量的类
 * @Author: JiangKan
 * @Create: 2020-10-05
 **/

@Component
public class Constant {
    //session键值
    public static final String MALL_USER = "mall_user";
    //盐值
    public static final String SALT = "fdsafFDSADOJVNDAF;/,;K[OFDSAFJDASFDSAFWEORASD FKL;D'SAFKDSA90";

    //图片文件上传目录
    public static String FILE_UPLOAD_DIR;
    @Value("${file.upload.dir}")
    public void setFileUploadDir(String fileUploadDir){
        FILE_UPLOAD_DIR = fileUploadDir;
    }

    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price desc", "price asc");
    }

    public interface SaleStatus{
        int NOT_SALE = 0; //商品下价状态
        int SALE = 1; //商品上价状态
    }

    public interface Cart{
        int UN_CHECKED = 0; //未选中状态
        int CHECKED = 1;    //选中状态
    }

    public enum OrderStatusEnum{
        CANCELED(0,"用户已取消"),
        NOT_PAID(10,"未付款"),
        PAID(20,"已付款"),
        DELIVERED(30,"已发货"),
        FINISHED(40,"交易完成");

        private int code;
        private String value;


        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum value : values()) {
                if (value.getCode() == code) {
                    return value;
                }
            }
            throw new MallException(MallExceptionEnum.NO_ENUM);
        }
        }
    }
