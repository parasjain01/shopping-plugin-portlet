/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.shopping.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.portlet.shopping.model.ShoppingItemPrice;
import com.liferay.portlet.shopping.service.ShoppingItemPriceLocalServiceUtil;

/**
 * The extended model base implementation for the ShoppingItemPrice service. Represents a row in the &quot;Shopping_ShoppingItemPrice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingItemPriceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPriceImpl
 * @see com.liferay.portlet.shopping.model.ShoppingItemPrice
 * @generated
 */
public abstract class ShoppingItemPriceBaseImpl
	extends ShoppingItemPriceModelImpl implements ShoppingItemPrice {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shopping item price model instance should use the {@link ShoppingItemPrice} interface instead.
	 */
	public void persist() throws SystemException {
		ShoppingItemPriceLocalServiceUtil.updateShoppingItemPrice(this);
	}
}