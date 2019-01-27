package xiao.ze.demo.service.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xiao.ze.demo.entity.Course;
import xiao.ze.demo.mapper.CourseMapper;
import xiao.ze.demo.service.CourseService;
import xiao.ze.demo.utils.CourseQueryHelper;
import xiao.ze.demo.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CourseServiceImpl
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        if(ArrayUtils.isNotEmpty(course.getCourseReqs())){
            course.setReqs(Utils.getStr(course.getCourseReqs()));
        }
        courseMapper.addCourse(course);

    }

    @Override
    public boolean removeCourseByNo(String courseNo) {

        courseMapper.removeCourseByNo(courseNo) ;
        return true;

    }

    @Override
    public void updateCourse(Course course) {

        if(ArrayUtils.isNotEmpty(course.getCourseReqs())){
            course.setReqs(Utils.getStr(course.getCourseReqs()));
        }

        String[] courseReq = course.getCourseReqs();
        if (courseReq != null && courseReq.length > 0) {

            courseMapper.updateCourse(course);

        } else {
            course.setReqs("");
            courseMapper.updateCourse(course);
        }

    }

    @Override
    public Course loadCourseByNo(String courseNo) {

        Course course=new Course();
        course=null;
        if(courseNo!=null) {
            course = courseMapper.loadCourseByNo(courseNo);
        }
        return course;

    }

    @Override
    public List<Course> loadScopedCourses(CourseQueryHelper helper) {

        Map<String,Object> map = new HashMap<>(16);
        map=getQueryHelper(helper);

        List<Course> list = courseMapper.loadScopedCourses(map);

        return list;

    }

    private Map<String,Object> getQueryHelper(CourseQueryHelper helper) {

        Map<String,Object> map = new HashMap<>(16);

        if(helper.getQryCourseName()!=null){
            map.put("qryCourseName", helper.getQryCourseName());
        }

        if((helper.getQryCourseType()!=null)&&(!"".equals(helper.getQryCourseType()))){
            map.put("typeId", Integer.parseInt(helper.getQryCourseType()));
        }

        return map;
    }

}
