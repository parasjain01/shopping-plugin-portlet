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
import com.liferay.shopping.service.ShoppingOrderItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderItemClp extends BaseModelImpl<ShoppingOrderItem>
	implements ShoppingOrderItem {
	public ShoppingOrderItemClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingOrderItem.class;
	}

	public String getModelClassName() {
		return ShoppingOrderItem.class.getName();
	}

	public long getPrimaryKey() {
		return _orderItemId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOrderItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_orderItemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orderItemId", getOrderItemId());
		attributes.put("orderId", getOrderId());
		attributes.put("itemId", getItemId());
		attributes.put("sku", getSku());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("properties", getProperties());
		attributes.put("price", getPrice());
		attributes.put("quantity", getQuantity());
		attributes.put("shippedDate", getShippedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orderItemId = (Long)attributes.get("orderItemId");

		if (orderItemId != null) {
			setOrderItemId(orderItemId);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		String itemId = (String)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		String sku = (String)attributes.get("sku");

		if (sku != null) {
			setSku(sku);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String properties = (String)attributes.get("properties");

		if (properties != null) {
			setProperties(properties);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Date shippedDate = (Date)attributes.get("shippedDate");

		if (shippedDate != null) {
			setShippedDate(shippedDate);
		}
	}

	public long getOrderItemId() {
		return _orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		_orderItemId = orderItemId;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderItemId", long.class);

				method.invoke(_shoppingOrderItemRemoteModel, orderItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderId", long.class);

				method.invoke(_shoppingOrderItemRemoteModel, orderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getItemId() {
		return _itemId;
	}

	public void setItemId(String itemId) {
		_itemId = itemId;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", String.class);

				method.invoke(_shoppingOrderItemRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getSku() {
		return _sku;
	}

	public void setSku(String sku) {
		_sku = sku;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSku", String.class);

				method.invoke(_shoppingOrderItemRemoteModel, sku);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_shoppingOrderItemRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_shoppingOrderItemRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProperties() {
		return _properties;
	}

	public void setProperties(String properties) {
		_properties = properties;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setProperties", String.class);

				method.invoke(_shoppingOrderItemRemoteModel, properties);
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

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_shoppingOrderItemRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_shoppingOrderItemRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getShippedDate() {
		return _shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		_shippedDate = shippedDate;

		if (_shoppingOrderItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingOrderItemRemoteModel.getClass();

				Method method = clazz.getMethod("setShippedDate", Date.class);

				method.invoke(_shoppingOrderItemRemoteModel, shippedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getShoppingOrderItemRemoteModel() {
		return _shoppingOrderItemRemoteModel;
	}

	public void setShoppingOrderItemRemoteModel(
		BaseModel<?> shoppingOrderItemRemoteModel) {
		_shoppingOrderItemRemoteModel = shoppingOrderItemRemoteModel;
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

		Class<?> remoteModelClass = _shoppingOrderItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_shoppingOrderItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingOrderItemLocalServiceUtil.addShoppingOrderItem(this);
		}
		else {
			ShoppingOrderItemLocalServiceUtil.updateShoppingOrderItem(this);
		}
	}

	@Override
	public ShoppingOrderItem toEscapedModel() {
		return (ShoppingOrderItem)ProxyUtil.newProxyInstance(ShoppingOrderItem.class.getClassLoader(),
			new Class[] { ShoppingOrderItem.class },
			new AutoEscapeBeanHandler(this));
	}

	public ShoppingOrderItem toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ShoppingOrderItemClp clone = new ShoppingOrderItemClp();

		clone.setOrderItemId(getOrderItemId());
		clone.setOrderId(getOrderId());
		clone.setItemId(getItemId());
		clone.setSku(getSku());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setProperties(getProperties());
		clone.setPrice(getPrice());
		clone.setQuantity(getQuantity());
		clone.setShippedDate(getShippedDate());

		return clone;
	}

	public int compareTo(ShoppingOrderItem shoppingOrderItem) {
		int value = 0;

		value = getName().compareTo(shoppingOrderItem.getName());

		if (value != 0) {
			return value;
		}

		value = getDescription().compareTo(shoppingOrderItem.getDescription());

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

		if (!(obj instanceof ShoppingOrderItemClp)) {
			return false;
		}

		ShoppingOrderItemClp shoppingOrderItem = (ShoppingOrderItemClp)obj;

		long primaryKey = shoppingOrderItem.getPrimaryKey();

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

		sb.append("{orderItemId=");
		sb.append(getOrderItemId());
		sb.append(", orderId=");
		sb.append(getOrderId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", sku=");
		sb.append(getSku());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", shippedDate=");
		sb.append(getShippedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingOrderItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orderItemId</column-name><column-value><![CDATA[");
		sb.append(getOrderItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sku</column-name><column-value><![CDATA[");
		sb.append(getSku());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>properties</column-name><column-value><![CDATA[");
		sb.append(getProperties());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippedDate</column-name><column-value><![CDATA[");
		sb.append(getShippedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orderItemId;
	private long _orderId;
	private String _itemId;
	private String _sku;
	private String _name;
	private String _description;
	private String _properties;
	private double _price;
	private int _quantity;
	private Date _shippedDate;
	private BaseModel<?> _shoppingOrderItemRemoteModel;
}