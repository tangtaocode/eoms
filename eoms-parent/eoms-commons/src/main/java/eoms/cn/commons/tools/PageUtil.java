package eoms.cn.commons.tools;

import java.util.List;

import com.github.pagehelper.Page;

@SuppressWarnings("rawtypes")
public class PageUtil {
	public static <T> int getPageTotalSize(List<T> list){
		if (list instanceof Page) {
            Page page = (Page) list;
            return Integer.valueOf(page.getTotal()+"");
            }else{
            	return list.size();
            }
	}
}
