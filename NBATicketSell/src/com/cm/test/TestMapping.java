package com.cm.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import junit.framework.TestCase;

public class TestMapping extends TestCase{

	public void testMapping() {
		
		Configuration cf = new Configuration().configure();
		
		if(cf != null) {
			SchemaExport se = new SchemaExport(cf);
			se.create(true, true);
		}
	}
}
