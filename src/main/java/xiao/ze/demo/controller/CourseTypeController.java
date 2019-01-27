package xiao.ze.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xiao.ze.demo.entity.CourseType;
import xiao.ze.demo.entity.WebResult;
import xiao.ze.demo.service.CourseTypeService;

import java.util.List;

/**
 * CourseTypeController
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@RestController
@RequestMapping("/courseType")
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService ;


    /**
     * 创建新课程类型
     */
    @PostMapping(value="/create")
    public String create(CourseType courseType) {

        try {
            if((courseType != null) && (!courseType.getTypeName().isEmpty())){
                courseTypeService.addCourseType(courseType);
                return "1";
            }
            return "0";

        }catch (Exception e){
            return "0";
        }

    }

    @GetMapping("/list")
    public WebResult list(@RequestParam(value="pageNo", required=false, defaultValue="1") String pageNoStr,
                          @RequestParam(value="pageSize", required=false, defaultValue="3") String pageSizeStr){

        int pageNo = 1;
        int pageSize = 3;

        //对 pageNo 的校验
        pageNo = Integer.parseInt(pageNoStr);
        if(pageNo < 1){
            pageNo = 1;
        }

        //对 pageSize 的校验
        pageSize = Integer.parseInt(pageSizeStr);
        if(pageSize < 1){
            pageSize = 3;
        }
        /*
         * 第一个参数：第几页;
         * 第二个参数：每页获取的条数.
         */
        PageHelper.startPage(pageNo, pageSize);
        List<CourseType> courseTypeList = courseTypeService.loadAll();

        PageInfo<CourseType> page=new PageInfo<>(courseTypeList);

        WebResult<CourseType> webResult = new WebResult<>(page.getList(), page.getPageNum(), page.getPageSize(), page.getPages(), page.getTotal());

        return webResult;
    }

    @GetMapping(value="/delete/{typeId}")
    public String delete(@PathVariable("typeId") Integer typeId) {

        try {
            courseTypeService.removeCourseType(typeId);
            return "1";
        }catch (Exception e){
            return "0";
        }

    }

    @GetMapping(value="/getCourseType/{typeId}")
    public CourseType getCourseType(@PathVariable("typeId") Integer typeId) {

        try {
            return courseTypeService.getCourseTypeById(typeId);
        }catch (Exception e){
            return null;
        }
    }

    @PostMapping(value="/update")
    public String update(CourseType courseType) {

        try {
            courseTypeService.updateCourseType(courseType);
            return "1";
        }catch (Exception e){
            return "0";
        }

    }

    @GetMapping(value="/getAllCourseType")
    public List<CourseType> getAllCourseType() {

        try {
            return courseTypeService.loadAll();
        }catch (Exception e){
            return null;
        }
    }

}
