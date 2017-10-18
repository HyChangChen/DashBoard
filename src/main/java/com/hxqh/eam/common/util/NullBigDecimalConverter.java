package com.hxqh.eam.common.util;

import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;

public class NullBigDecimalConverter extends BigDecimalConverter {

	@Override
	public Object fromString(String str) {
		
		if(null==str||"".equals(str))
			return null;
		return super.fromString(str);
	}
	

}
