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
import com.liferay.portal.util.PortalUtil;

import com.liferay.shopping.service.ClpSerializer;
import com.liferay.shopping.service.ShoppingCartLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingCartClp extends BaseModelImpl<ShoppingCart>
	implements ShoppingCart {
	public ShoppingCartClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingCart.class;
	}

	public String getModelClassName() {
		return ShoppingCart.class.getName();
	}

	public long getPrimaryKey() {
		return _cartId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCartId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_cartId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cartId", getCartId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("itemIds", getItemIds());
		attributes.put("couponCodes", getCouponCodes());
		attributes.put("altShipping", getAltShipping());
		attributes.put("insure", getInsure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String itemIds = (String)attributes.get("itemIds");

		if (itemIds != null) {
			setItemIds(itemIds);
		}

		String couponCodes = (String)attributes.get("couponCodes");

		if (couponCodes != null) {
			setCouponCodes(couponCodes);
		}

		Integer altShipping = (Integer)attributes.get("altShipping");

		if (altShipping != null) {
			setAltShipping(altShipping);
		}

		Boolean insure = (Boolean)attributes.get("insure");

		if (insure != null) {
			setInsure(insure);
		}
	}

	public long getCartId() {
		return _cartId;
	}

	public void setCartId(long cartId) {
		_cartId = cartId;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setCartId", long.class);

				method.invoke(_shoppingCartRemoteModel, cartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_shoppingCartRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_shoppingCartRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_shoppingCartRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_shoppingCartRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_shoppingCartRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_shoppingCartRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getItemIds() {
		return _itemIds;
	}

	public void setItemIds(String itemIds) {
		_itemIds = itemIds;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setItemIds", String.class);

				method.invoke(_shoppingCartRemoteModel, itemIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCouponCodes() {
		return _couponCodes;
	}

	public void setCouponCodes(String couponCodes) {
		_couponCodes = couponCodes;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setCouponCodes", String.class);

				method.invoke(_shoppingCartRemoteModel, couponCodes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getAltShipping() {
		return _altShipping;
	}

	public void setAltShipping(int altShipping) {
		_altShipping = altShipping;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setAltShipping", int.class);

				method.invoke(_shoppingCartRemoteModel, altShipping);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getInsure() {
		return _insure;
	}

	public boolean isInsure() {
		return _insure;
	}

	public void setInsure(boolean insure) {
		_insure = insure;

		if (_shoppingCartRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCartRemoteModel.getClass();

				Method method = clazz.getMethod("setInsure", boolean.class);

				method.invoke(_shoppingCartRemoteModel, insure);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public java.util.Map<com.liferay.shopping.model.ShoppingCartItem, java.lang.Integer> getItems() {
		try {
			String methodName = "getItems";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Map<com.liferay.shopping.model.ShoppingCartItem, java.lang.Integer> returnObj =
				(java.util.Map<com.liferay.shopping.model.ShoppingCartItem, java.lang.Integer>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public void addItemId(long itemId, java.lang.String fields) {
		try {
			String methodName = "addItemId";

			Class<?>[] parameterTypes = new Class<?>[] {
					long.class, java.lang.String.class
				};

			Object[] parameterValues = new Object[] { itemId, fields };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public int getItemsSize() {
		try {
			String methodName = "getItemsSize";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public com.liferay.shopping.model.ShoppingCoupon getCoupon() {
		try {
			String methodName = "getCoupon";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.shopping.model.ShoppingCoupon returnObj = (com.liferay.shopping.model.ShoppingCoupon)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getShoppingCartRemoteModel() {
		return _shoppingCartRemoteModel;
	}

	public void setShoppingCartRemoteModel(BaseModel<?> shoppingCartRemoteModel) {
		_shoppingCartRemoteModel = shoppingCartRemoteModel;
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

		Class<?> remoteModelClass = _shoppingCartRemoteModel.getClass();

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

		Object returnValue = method.invoke(_shoppingCartRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingCartLocalServiceUtil.addShoppingCart(this);
		}
		else {
			ShoppingCartLocalServiceUtil.updateShoppingCart(this);
		}
	}

	@Override
	public ShoppingCart toEscapedModel() {
		return (ShoppingCart)ProxyUtil.newProxyInstance(ShoppingCart.class.getClassLoader(),
			new Class[] { ShoppingCart.class }, new AutoEscapeBeanHandler(this));
	}

	public ShoppingCart toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ShoppingCartClp clone = new ShoppingCartClp();

		clone.setCartId(getCartId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setItemIds(getItemIds());
		clone.setCouponCodes(getCouponCodes());
		clone.setAltShipping(getAltShipping());
		clone.setInsure(getInsure());

		return clone;
	}

	public int compareTo(ShoppingCart shoppingCart) {
		long primaryKey = shoppingCart.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingCartClp)) {
			return false;
		}

		ShoppingCartClp shoppingCart = (ShoppingCartClp)obj;

		long primaryKey = shoppingCart.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{cartId=");
		sb.append(getCartId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", itemIds=");
		sb.append(getItemIds());
		sb.append(", couponCodes=");
		sb.append(getCouponCodes());
		sb.append(", altShipping=");
		sb.append(getAltShipping());
		sb.append(", insure=");
		sb.append(getInsure());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingCart");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cartId</column-name><column-value><![CDATA[");
		sb.append(getCartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemIds</column-name><column-value><![CDATA[");
		sb.append(getItemIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couponCodes</column-name><column-value><![CDATA[");
		sb.append(getCouponCodes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>altShipping</column-name><column-value><![CDATA[");
		sb.append(getAltShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insure</column-name><column-value><![CDATA[");
		sb.append(getInsure());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cartId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _itemIds;
	private String _couponCodes;
	private int _altShipping;
	private boolean _insure;
	private BaseModel<?> _shoppingCartRemoteModel;
}