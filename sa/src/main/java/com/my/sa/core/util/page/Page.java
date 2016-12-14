package com.my.sa.core.util.page;

import java.util.Iterator;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Page implements org.springframework.data.domain.Page{  
	  
    /** 
     * 一页数据默认20条 
     */  
    private int pageSize = 10;  
    /** 
     * 当前页码 
     */  
    private int pageNo;  
  
    /** 
     * 一共有多少条数据 
     */  
    private long totalCount;  
  
    /** 
     * 一共有多少页 
     */  
    private int totalPage;  
    /** 
     * 数据集合 
     */  
    private List datas;  
  

	/** 
     * 获取第一条记录位置 
     *  
     * @return 
     */  
    public int getFirstResult() {  
        return (this.getPageNo() - 1) * this.getPageSize();  
    }  
  
    /** 
     * 获取最后记录位置 
     *  
     * @return 
     */  
    public int getLastResult() {  
        return this.getPageNo() * this.getPageSize();  
    }  
  
    /** 
     * 计算一共多少页 
     */  
    public void setTotalPage() {  
        this.totalPage = (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)  
                : this.totalCount / this.pageSize);  
    }  
  
    public int getTotalPage() {  
        return totalPage;  
    }  
  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public int getPageNo() {  
        return pageNo;  
    }  
  
    public void setPageNo(int pageNo) {  
        this.pageNo = pageNo;  
    }  
  
    public long getTotalCount() {  
        return totalCount;  
    }  
  
    public void setTotalCount(long totalCount2) {  
        this.totalCount = totalCount2;  
    }  
  
    public List getDatas() {  
        return datas;  
    }  
  
    public void setDatas(List datas) {  
        this.datas = datas;  
    }  
  
  
    public Page(int pageNo, int pageSize, long totalCount) {  
        this.setPageNo(pageNo);  
        this.setPageSize(pageSize);  
        this.setTotalCount(totalCount);  
    }

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pageable nextPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTotalElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public org.springframework.data.domain.Page map(Converter converter) {
		// TODO Auto-generated method stub
		return null;
	}  
  
}  
