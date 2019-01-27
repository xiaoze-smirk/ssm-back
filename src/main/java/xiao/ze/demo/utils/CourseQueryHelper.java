package xiao.ze.demo.utils;

/**
 * CourseQueryHelper
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
public class CourseQueryHelper {

    private String qryCourseName;

    private String qryCourseType;

    public String getQryCourseName() {
        return qryCourseName;
    }

    public void setQryCourseName(String qryCourseName) {
        this.qryCourseName = qryCourseName;
    }

    public String getQryCourseType() {
        return qryCourseType;
    }

    public void setQryCourseType(String qryCourseType) {
        this.qryCourseType = qryCourseType;
    }

    @Override
    public String toString() {
        return "CourseQueryHelper{" +
                "qryCourseName='" + qryCourseName + '\'' +
                ", qryCourseType='" + qryCourseType + '\'' +
                '}';
    }
}
