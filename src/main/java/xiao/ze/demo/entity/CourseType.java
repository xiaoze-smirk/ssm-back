package xiao.ze.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * CourseType
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@TableName(value = "tbl_course_type")
public class CourseType implements Serializable{


    @TableId(value="type_id" , type = IdType.AUTO)
    private Integer typeId;

    private String  typeName;


    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @Override
    public String toString() {
        return "CourseType [typeId=" + typeId + ", typeName=" + typeName + "]";
    }

}
