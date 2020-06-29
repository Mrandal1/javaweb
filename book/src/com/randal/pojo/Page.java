package com.randal.pojo;

import java.util.List;

import static com.randal.utils.Constants.DEFAULT_PAGE_SIZE;

/**
 * @param <T> 记录类型
 * @author Randal1
 * @version V1.0
 * @Package com.randal.pojo
 * @data 2020/6/24 20:05
 * 分页模型对象
 */
public class Page<T> {

    /**
     * 当前页码
     */
    private Integer pageNo;

    /**
     * 总页码数
     */
    private Integer pageTotal;

    /**
     * 单页显示记录数
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 总记录数
     */
    private Integer pageTotalCount;

    /**
     * 当前显示记录
     */
    private List<T> items;
    /**
     * 请求地址抽取
     */
    private String url;
    /**
     * 价格区间最小价格
     */
    private Integer min;
    /**
     * 价格区间最大价格
     */
    private Integer max;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
