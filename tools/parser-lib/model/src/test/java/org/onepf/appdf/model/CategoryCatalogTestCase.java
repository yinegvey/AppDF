/*******************************************************************************
 * Copyright 2012 One Platform Foundation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.onepf.appdf.model;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;



public class CategoryCatalogTestCase{

	/**
	 * Tests if parsing is working at all
	 * Warning is suppressed since call to class is a call to constructor witch do
	 * most of work
	 */
	@Test
	public void basicWorking(){
		@SuppressWarnings("unused")
		CategoryCatalog catalog = CategoryCatalog.CATALOG;		
	}
	/**
	 * Do we have some categories
	 */
	@Test
	public void categoryListIsNotEmpty(){
		CategoryCatalog catalog = CategoryCatalog.CATALOG;
		assertFalse(catalog.getAllCategories().isEmpty());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void cantModifyCategoryList(){
		CategoryCatalog catalog = CategoryCatalog.CATALOG;
		List<Category> allCategories = catalog.getAllCategories();
		allCategories.remove(0);
	}
	/**
	 * This one is based upon current categories.xml
	 */
	@Test
	public void properParsing(){
		String appdfCategory = "Comics";
		CategoryCatalog catalog = CategoryCatalog.CATALOG;
		assertNotNull(catalog.getCategoryByAppdfName(appdfCategory)); 
	}
}