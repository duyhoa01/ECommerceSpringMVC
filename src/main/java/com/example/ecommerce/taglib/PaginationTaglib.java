package com.example.ecommerce.taglib;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.example.ecommerce.dao.productDetailDao;

public class PaginationTaglib extends SimpleTagSupport {
	private String uri;
	private int offset;
	private int count;
	private int max = 10;
	private int steps = 3;
	private String previous = "Previous";
	private String next = "Next";
	private String key="";
	private List<Integer> manufacturer=new ArrayList<Integer>();
	private List<Integer> pin=new ArrayList<Integer>();
	private List<Integer> price=new ArrayList<Integer>();
	
	
	public List<Integer> getPrice() {
		return price;
	}

	public void setPrice(List<Integer> price) {
		this.price = price;
	}

	public List<Integer> getPin() {
		return pin;
	}

	public void setPin(List<Integer> pin) {
		this.pin = pin;
	}

	public List<Integer> getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(List<Integer> manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	private Writer getWriter() {
		JspWriter out = getJspContext().getOut();
		return out;
	}

	@Override
	public void doTag() throws JspException {
		Writer out = getWriter();

		try {
			out.write("<nav>");
			out.write("<ul class=\"pagination\">");
			
//			if(offset<steps)
//				out.write(constructLink(0, previous, "disabled", true));
//			else
//				out.write(constructLink(offset-steps, previous, null, false));
			
			out.write(constructLink(0, previous, null, false));
			
			for(int itr=0;itr<count;itr+=steps) {
				if(offset==itr)
					out.write(constructLink((itr/steps+1)-1, String.valueOf(itr/steps+1), "active", false));
				else
					out.write(constructLink(itr/steps+1-1, String.valueOf(itr/steps+1), null , false));
			}
			
			out.write(constructLink((count/steps+1)-1, next, null, false));

//			if(offset+steps>=count)
//				out.write(constructLink(offset+steps, next, "disabled", true));
//			else
//				out.write(constructLink(offset+steps, next, null , false));
			
			out.write("</ul>");
			out.write("</nav>");
		} catch (java.io.IOException ex) {
			throw new JspException("Error in Paginator tag", ex);
		}
	}


	private String constructLink(int page, String text, String className, boolean disabled) {
		StringBuilder link = new StringBuilder("<li");
		if (className != null) {
			link.append(" class=\"");
			link.append(className);
			link.append("\"");
		}
		String keyString="";
		String manufacturerString="";
		String priceString="";
		String pinString="";
		keyString=(this.key!="" )? "&key="+key: "";
		if(manufacturer.size()>0) {
			for (Integer integer : manufacturer) {
				manufacturerString+="&manufacturer="+integer;
			}
		}
		if(price.size()>0) {
			for (Integer integer : price) {
				priceString+="&price="+integer;
			}
		}
		if(pin.size()>0) {
			for (Integer integer : pin) {
				pinString+="&pin="+integer;
			}
		}
		if(disabled)
			link.append(">").append("<a href=\"#\">"+text+"</a></li>");
		else
			link.append(">").append("<a href=\""+uri+"?page="+page + keyString + manufacturerString+priceString +pinString+ "\">"+text+"</a></li>");
		return link.toString();
	}
}
