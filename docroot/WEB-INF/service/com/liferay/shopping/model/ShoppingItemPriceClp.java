/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.shopping.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.shopping.service.ClpSerializer;
import com.liferay.shopping.service.ShoppingItemPriceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemPriceClp extends BaseModelImpl<ShoppingItemPrice>
	implements ShoppingItemPrice {
	public ShoppingItemPriceClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingItemPrice.class;
	}

	public String getModelClassName() {
		return ShoppingItemPrice.class.getName();
	}

	public long getPrimaryKey() {
		return _itemPriceId;
	}

	public void setPrimaryKey(long primaryKey) {
		setItemPriceId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemPriceId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemPriceId", getItemPriceId());
		attributes.put("itemId", getItemId());
		attributes.put("minQuantity", getMinQuantity());
		attributes.put("maxQuantity", getMaxQuantity());
		attributes.put("price", getPrice());
		attributes.put("discount", getDiscount());
		attributes.put("taxable", getTaxable());
		attributes.put("shipping", getShipping());
		attributes.put("useShippingFormula", getUseShippingFormula());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemPriceId = (Long)attributes.get("itemPriceId");

		if (itemPriceId != null) {
			setItemPriceId(itemPriceId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Integer minQuantity = (Integer)attributes.get("minQuantity");

		if (minQuantity != null) {
			setMinQuantity(minQuantity);
		}

		Integer maxQuantity = (Integer)attributes.get("maxQuantity");

		if (maxQuantity != null) {
			setMaxQuantity(maxQuantity);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Boolean taxable = (Boolean)attributes.get("taxable");

		if (taxable != null) {
			setTaxable(taxable);
		}

		Double shipping = (Double)attributes.get("shipping");

		if (shipping != null) {
			setShipping(shipping);
		}

		Boolean useShippingFormula = (Boolean)attributes.get(
				"useShippingFormula");

		if (useShippingFormula != null) {
			setUseShippingFormula(useShippingFormula);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getItemPriceId() {
		return _itemPriceId;
	}

	public void setItemPriceId(long itemPriceId) {
		_itemPriceId = itemPriceId;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setItemPriceId", long.class);

				method.invoke(_shoppingItemPriceRemoteModel, itemPriceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_shoppingItemPriceRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getMinQuantity() {
		return _minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		_minQuantity = minQuantity;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setMinQuantity", int.class);

				method.invoke(_shoppingItemPriceRemoteModel, minQuantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getMaxQuantity() {
		return _maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		_maxQuantity = maxQuantity;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxQuantity", int.class);

				method.invoke(_shoppingItemPriceRemoteModel, maxQuantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_shoppingItemPriceRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", double.class);

				method.invoke(_shoppingItemPriceRemoteModel, discount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getTaxable() {
		return _taxable;
	}

	public boolean isTaxable() {
		return _taxable;
	}

	public void setTaxable(boolean taxable) {
		_taxable = taxable;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxable", boolean.class);

				method.invoke(_shoppingItemPriceRemoteModel, taxable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public double getShipping() {
		return _shipping;
	}

	public void setShipping(double shipping) {
		_shipping = shipping;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setShipping", double.class);

				method.invoke(_shoppingItemPriceRemoteModel, shipping);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getUseShippingFormula() {
		return _useShippingFormula;
	}

	public boolean isUseShippingFormula() {
		return _useShippingFormula;
	}

	public void setUseShippingFormula(boolean useShippingFormula) {
		_useShippingFormula = useShippingFormula;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setUseShippingFormula",
						boolean.class);

				method.invoke(_shoppingItemPriceRemoteModel, useShippingFormula);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;

		if (_shoppingItemPriceRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_shoppingItemPriceRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getShoppingItemPriceRemoteModel() {
		return _shoppingItemPriceRemoteModel;
	}

	public void setShoppingItemPriceRemoteModel(
		BaseModel<?> shoppingItemPriceRemoteModel) {
		_shoppingItemPriceRemoteModel = shoppingItemPriceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _shoppingItemPriceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_shoppingItemPriceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingItemPriceLocalServiceUtil.addShoppingItemPrice(this);
		}
		else {
			ShoppingItemPriceLocalServiceUtil.updateShoppingItemPrice(this);
		}
	}

	@Override
	public ShoppingItemPrice toEscapedModel() {
		return (ShoppingItemPrice)ProxyUtil.newProxyInstance(ShoppingItemPrice.class.getClassLoader(),
			new Class[] { ShoppingItemPrice.class },
			new AutoEscapeBeanHandler(this));
	}

	public ShoppingItemPrice toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ShoppingItemPriceClp clone = new ShoppingItemPriceClp();

		clone.setItemPriceId(getItemPriceId());
		clone.setItemId(getItemId());
		clone.setMinQuantity(getMinQuantity());
		clone.setMaxQuantity(getMaxQuantity());
		clone.setPrice(getPrice());
		clone.setDiscount(getDiscount());
		clone.setTaxable(getTaxable());
		clone.setShipping(getShipping());
		clone.setUseShippingFormula(getUseShippingFormula());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ShoppingItemPrice shoppingItemPrice) {
		int value = 0;

		if (getItemId() < shoppingItemPrice.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItemPrice.getItemId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getItemPriceId() < shoppingItemPrice.getItemPriceId()) {
			value = -1;
		}
		else if (getItemPriceId() > shoppingItemPrice.getItemPriceId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingItemPriceClp)) {
			return false;
		}

		ShoppingItemPriceClp shoppingItemPrice = (ShoppingItemPriceClp)obj;

		long primaryKey = shoppingItemPrice.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{itemPriceId=");
		sb.append(getItemPriceId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", minQuantity=");
		sb.append(getMinQuantity());
		sb.append(", maxQuantity=");
		sb.append(getMaxQuantity());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", taxable=");
		sb.append(getTaxable());
		sb.append(", shipping=");
		sb.append(getShipping());
		sb.append(", useShippingFormula=");
		sb.append(getUseShippingFormula());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingItemPrice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemPriceId</column-name><column-value><![CDATA[");
		sb.append(getItemPriceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minQuantity</column-name><column-value><![CDATA[");
		sb.append(getMinQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxQuantity</column-name><column-value><![CDATA[");
		sb.append(getMaxQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxable</column-name><column-value><![CDATA[");
		sb.append(getTaxable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipping</column-name><column-value><![CDATA[");
		sb.append(getShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useShippingFormula</column-name><column-value><![CDATA[");
		sb.append(getUseShippingFormula());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemPriceId;
	private long _itemId;
	private int _minQuantity;
	private int _maxQuantity;
	private double _price;
	private double _discount;
	private boolean _taxable;
	private double _shipping;
	private boolean _useShippingFormula;
	private int _status;
	private BaseModel<?> _shoppingItemPriceRemoteModel;
}