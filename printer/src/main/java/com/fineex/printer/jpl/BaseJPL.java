package com.fineex.printer.jpl;


import com.fineex.printer.Port;

public class BaseJPL
{
	protected Port port;
	protected JPL_Param param;

	public BaseJPL(JPL_Param param) {
		if (param.port == null)
			return;
		this.param = param;
		this.port = param.port;
	}
}
