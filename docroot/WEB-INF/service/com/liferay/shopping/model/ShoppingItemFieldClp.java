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
import com.liferay.shopping.service.ShoppingItemFieldLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemFieldClp extends BaseModelImpl<ShoppingItemField>
	implements ShoppingItemField {
	public ShoppingItemFieldClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingItemField.class;
	}

	public String getModelClassName() {
		return ShoppingItemField.class.getName();
	}

	public long getPrimaryKey() {
		return _itemFieldId;
	}

	public void setPrimaryKey(long primaryKey) {
		setItemFieldId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemFieldId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemFieldId", getItemFieldId());
		attributes.put("itemId", getItemId());
		attributes.put("name", getName());
		attributes.put("values", getValues());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemFieldId = (Long)attributes.get("itemFieldId");

		if (itemFieldId != null) {
			setItemFieldId(itemFieldId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String values = (String)attributes.get("values");

		if (values != null) {
			setValues(values);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	public long getItemFieldId() {
		return _itemFieldId;
	}

	public void setItemFieldId(long itemFieldId) {
		_itemFieldId = itemFieldId;

		if (_shoppingItemFieldRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setItemFieldId", long.class);

				method.invoke(_shoppingItemFieldRemoteModel, itemFieldId);
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

		if (_shoppingItemFieldRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_shoppingItemFieldRemoteModel, itemId);
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

		if (_shoppingItemFieldRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_shoppingItemFieldRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getValues() {
		return _values;
	}

	public void setValues(String values) {
		_values = values;

		if (_shoppingItemFieldRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setValues", String.class);

				method.invoke(_shoppingItemFieldRemoteModel, values);
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

		if (_shoppingItemFieldRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_shoppingItemFieldRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public void setValuesArray(java.lang.String[] valuesArray) {
		try {
			String methodName = "setValuesArray";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { valuesArray };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public java.lang.String[] getValuesArray() {
		try {
			String methodName = "getValuesArray";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String[] returnObj = (java.lang.String[])invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getShoppingItemFieldRemoteModel() {
		return _shoppingItemFieldRemoteModel;
	}

	public void setShoppingItemFieldRemoteModel(
		BaseModel<?> shoppingItemFieldRemoteModel) {
		_shoppingItemFieldRemoteModel = shoppingItemFieldRemoteModel;
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

		Class<?> remoteModelClass = _shoppingItemFieldRemoteModel.getClass();

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

		Object returnValue = method.invoke(_shoppingItemFieldRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingItemFieldLocalServiceUtil.addShoppingItemField(this);
		}
		else {
			ShoppingItemFieldLocalServiceUtil.updateShoppingItemField(this);
		}
	}

	@Override
	public ShoppingItemField toEscapedModel() {
		return (ShoppingItemField)ProxyUtil.newProxyInstance(ShoppingItemField.class.getClassLoader(),
			new Class[] { ShoppingItemField.class },
			new AutoEscapeBeanHandler(this));
	}

	public ShoppingItemField toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ShoppingItemFieldClp clone = new ShoppingItemFieldClp();

		clone.setItemFieldId(getItemFieldId());
		clone.setItemId(getItemId());
		clone.setName(getName());
		clone.setValues(getValues());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ShoppingItemField shoppingItemField) {
		int value = 0;

		if (getItemId() < shoppingItemField.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItemField.getItemId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().toLowerCase()
					.compareTo(shoppingItemField.getName().toLowerCase());

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

		if (!(obj instanceof ShoppingItemFieldClp)) {
			return false;
		}

		ShoppingItemFieldClp shoppingItemField = (ShoppingItemFieldClp)obj;

		long primaryKey = shoppingItemField.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{itemFieldId=");
		sb.append(getItemFieldId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", values=");
		sb.append(getValues());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingItemField");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemFieldId</column-name><column-value><![CDATA[");
		sb.append(getItemFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>values</column-name><column-value><![CDATA[");
		sb.append(getValues());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemFieldId;
	private long _itemId;
	private String _name;
	private String _values;
	private String _description;
	private BaseModel<?> _shoppingItemFieldRemoteModel;
}