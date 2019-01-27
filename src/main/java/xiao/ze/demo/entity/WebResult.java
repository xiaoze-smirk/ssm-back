package xiao.ze.demo.entity;

import java.io.Serializable;
import java.util.List;


/**
 * WebResult
 *
 * @author xiaoze
 * @date 2018/1/25
 *
 */
public class WebResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public WebResult() {

    }

    public WebResult(List<T> objs, int pageNo, int pageSize, int pages, long total) {
        this.objs = objs;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pages = pages;
        this.total = total;
    }


    private List<T> objs;

    /**
     * 显示第几页
     */
    private int pageNo;

    /**
     * 每页有几条
     */
    private int pageSize;

    /**
     * 共几页
     */
    private int pages;

    /**
     * 总共几条数据
     */
    private long total;


    public List<T> getObjs() {
        return objs;
    }

    public void setObjs(List<T> objs) {
        this.objs = objs;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
