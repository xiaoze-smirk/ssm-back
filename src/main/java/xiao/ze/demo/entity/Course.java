package xiao.ze.demo.entity;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Course
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Component
public class Course implements Serializable{

    private String courseNo;

    private String courseName;

    private Integer courseHours;

    /**
     * 单选互斥
     */
    private String courseStatus;

    private String courseStatusName;

    private Double coursePoint;

    /**
     * 多选
     */
    private String[] courseReqs;

    private String courseReqsName;

    private String reqs;

    private String courseMemo;

    private Integer typeId;

    /**
     * 对一关系
     */
    private CourseType courseType = new CourseType();

    private List<CourseType> courseTypeList;

    public String getCourseNo() {
        return courseNo;
    }
    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Integer getCourseHours() {
        return courseHours;
    }
    public void setCourseHours(Integer courseHours) {
        this.courseHours = courseHours;
    }

    public String[] getCourseReqs() {
        return courseReqs;
    }
    public void setCourseReqs(String[] courseReqs) {
        this.courseReqs = courseReqs;

    }

    public CourseType getCourseType() {
        return courseType;
    }
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
        if(courseType != null){
            if(courseType.getTypeId() != null){
                this.typeId = courseType.getTypeId();
            }
        }
    }
    public String getCourseStatus() {
        return courseStatus;
    }
    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }
    public Double getCoursePoint() {
        return coursePoint;
    }
    public void setCoursePoint(Double coursePoint) {
        this.coursePoint = coursePoint;
    }

    public String getCourseMemo() {
        return courseMemo;
    }
    public void setCourseMemo(String courseMemo) {
        this.courseMemo = courseMemo;
    }

    public String getReqs() {
        return reqs;
    }
    public void setReqs(String reqs) {
        this.reqs = reqs;
        if(StringUtils.isNotEmpty(reqs)){
            this.courseReqs = this.reqs.split("\\|");
        }
    }

    public List<CourseType> getCourseTypeList() {
        return courseTypeList;
    }

    public void setCourseTypeList(List<CourseType> courseTypeList) {
        this.courseTypeList = courseTypeList;
    }

    public String getCourseStatusName() {
        if(StringUtils.isNotEmpty(this.courseStatus)){
            if("O".equals(this.courseStatus)){
                return "开放公选";
            }else if("Z".equals(this.courseStatus)){
                return "暂不开放";
            }else if("C".equals(this.courseStatus)){
                return "停止授课";
            }
        }

        return courseStatusName;
    }

    public void setCourseStatusName(String courseStatusName) {
        this.courseStatusName = courseStatusName;
    }

    public String getCourseReqsName() {

        StringBuffer sb = new StringBuffer();

        if(ArrayUtils.isNotEmpty(this.courseReqs)){
            for(String str : this.courseReqs){
                if(StringUtils.isNotEmpty(str)){
                    switch (str){
                        case "a" : sb.append("大三以上").append("、");
                            break;
                        case "b" : sb.append("平均成绩80分").append("、");
                            break;
                        case "c" : sb.append("党员").append("、");
                            break;
                        case "d" : sb.append("未拖欠学费").append("、");
                            break;
                        default:break;
                    }

                }
            }
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }


        return courseReqsName;
    }

    public void setCourseReqsName(String courseReqsName) {
        this.courseReqsName = courseReqsName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;

        if(typeId != null){
            this.courseType.setTypeId(typeId);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseHours=" + courseHours +
                ", courseStatus='" + courseStatus + '\'' +
                ", courseStatusName='" + courseStatusName + '\'' +
                ", coursePoint=" + coursePoint +
                ", courseReqs=" + Arrays.toString(courseReqs) +
                ", courseReqsName='" + courseReqsName + '\'' +
                ", reqs='" + reqs + '\'' +
                ", courseMemo='" + courseMemo + '\'' +
                ", courseType=" + courseType +
                ", courseTypeList=" + courseTypeList +
                '}';
    }
}
