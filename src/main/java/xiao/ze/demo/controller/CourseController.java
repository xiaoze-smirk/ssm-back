package xiao.ze.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xiao.ze.demo.entity.Course;
import xiao.ze.demo.entity.WebResult;
import xiao.ze.demo.service.CourseService;
import xiao.ze.demo.service.CourseTypeService;
import xiao.ze.demo.utils.CourseQueryHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * CourseController
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseTypeService courseTypeService ;

    @ModelAttribute
    public void getCourse(@RequestParam(value="courseNo",required=false) String courseNo,
                          Map<String, Object> map){

        Course course=courseService.loadCourseByNo(courseNo);
        if(courseNo != null&&course!= null){
            map.put("course", course);
        }
    }

    @PostMapping(value="/create")
    public String create(Course course) {

        try{
            courseService.addCourse(course);
            return "1";
        }catch(Exception e){
            return "0";
        }

    }

    @RequestMapping("/list")
    public WebResult list(@RequestParam(value="pageNo", required=false, defaultValue="1") String pageNoStr,
                          @RequestParam(value="pageSize", required=false, defaultValue="3") String pageSizeStr,
                          @RequestParam(value="qryCourseName", required=false) String qryCourseName,
                          @RequestParam(value="qryCourseType", required=false) String qryCourseType) {

        CourseQueryHelper helper = new CourseQueryHelper();
        if (StringUtils.isNotEmpty(qryCourseName)){
            helper.setQryCourseName(qryCourseName);
        }
        if (StringUtils.isNotEmpty(qryCourseType)){
            helper.setQryCourseType(qryCourseType);
        }

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

        PageHelper.startPage(pageNo, pageSize);
        List<Course> courselist = courseService.loadScopedCourses(helper);
        PageInfo<Course> page=new PageInfo<>(courselist);

        WebResult<Course> webResult = new WebResult<>(page.getList(), page.getPageNum(), page.getPageSize(), page.getPages(), page.getTotal());

        return webResult;

    }


    @GetMapping(value="/delete/{courseNo}")
    public String delete(@PathVariable("courseNo") String courseNo) {

        try{
            courseService.removeCourseByNo(courseNo);
            return "1";
        }catch(Exception e){
            return "0";
        }

    }

    @GetMapping(value="/getCourse/{courseNo}")
    public Course getCourse(@PathVariable("courseNo") String courseNo) {

        try {

            Course course = courseService.loadCourseByNo(courseNo);
            course.setCourseTypeList(courseTypeService.loadAll());
            return course;

        }catch (Exception e){
            return null;
        }

    }

    @PostMapping(value="/update")
    public String update(Course course){
        System.out.println(course);
        try{

            courseService.updateCourse(course);
            return "1";

        }catch(Exception e){
            System.out.println(000000000);
            return "0";
        }

    }

}
