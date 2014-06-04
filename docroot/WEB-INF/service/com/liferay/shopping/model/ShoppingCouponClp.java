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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.shopping.service.ClpSerializer;
import com.liferay.shopping.service.ShoppingCouponLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingCouponClp extends BaseModelImpl<ShoppingCoupon>
	implements ShoppingCoupon {
	public ShoppingCouponClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingCoupon.class;
	}

	public String getModelClassName() {
		return ShoppingCoupon.class.getName();
	}

	public long getPrimaryKey() {
		return _couponId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCouponId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_couponId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("couponId", getCouponId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("active", getActive());
		attributes.put("limitCategories", getLimitCategories());
		attributes.put("limitSkus", getLimitSkus());
		attributes.put("minOrder", getMinOrder());
		attributes.put("discount", getDiscount());
		attributes.put("discountType", getDiscountType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long couponId = (Long)attributes.get("couponId");

		if (couponId != null) {
			setCouponId(couponId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String limitCategories = (String)attributes.get("limitCategories");

		if (limitCategories != null) {
			setLimitCategories(limitCategories);
		}

		String limitSkus = (String)attributes.get("limitSkus");

		if (limitSkus != null) {
			setLimitSkus(limitSkus);
		}

		Double minOrder = (Double)attributes.get("minOrder");

		if (minOrder != null) {
			setMinOrder(minOrder);
		}

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		String discountType = (String)attributes.get("discountType");

		if (discountType != null) {
			setDiscountType(discountType);
		}
	}

	public long getCouponId() {
		return _couponId;
	}

	public void setCouponId(long couponId) {
		_couponId = couponId;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setCouponId", long.class);

				method.invoke(_shoppingCouponRemoteModel, couponId);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_shoppingCouponRemoteModel, groupId);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_shoppingCouponRemoteModel, companyId);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_shoppingCouponRemoteModel, userId);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_shoppingCouponRemoteModel, userName);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_shoppingCouponRemoteModel, createDate);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_shoppingCouponRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_shoppingCouponRemoteModel, code);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_shoppingCouponRemoteModel, name);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_shoppingCouponRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_shoppingCouponRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_shoppingCouponRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_shoppingCouponRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getLimitCategories() {
		return _limitCategories;
	}

	public void setLimitCategories(String limitCategories) {
		_limitCategories = limitCategories;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setLimitCategories",
						String.class);

				method.invoke(_shoppingCouponRemoteModel, limitCategories);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getLimitSkus() {
		return _limitSkus;
	}

	public void setLimitSkus(String limitSkus) {
		_limitSkus = limitSkus;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setLimitSkus", String.class);

				method.invoke(_shoppingCouponRemoteModel, limitSkus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public double getMinOrder() {
		return _minOrder;
	}

	public void setMinOrder(double minOrder) {
		_minOrder = minOrder;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setMinOrder", double.class);

				method.invoke(_shoppingCouponRemoteModel, minOrder);
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

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", double.class);

				method.invoke(_shoppingCouponRemoteModel, discount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getDiscountType() {
		return _discountType;
	}

	public void setDiscountType(String discountType) {
		_discountType = discountType;

		if (_shoppingCouponRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingCouponRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscountType", String.class);

				method.invoke(_shoppingCouponRemoteModel, discountType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean hasValidDateRange() {
		try {
			String methodName = "hasValidDateRange";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public boolean hasValidStartDate() {
		try {
			String methodName = "hasValidStartDate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public boolean hasValidEndDate() {
		try {
			String methodName = "hasValidEndDate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getShoppingCouponRemoteModel() {
		return _shoppingCouponRemoteModel;
	}

	public void setShoppingCouponRemoteModel(
		BaseModel<?> shoppingCouponRemoteModel) {
		_shoppingCouponRemoteModel = shoppingCouponRemoteModel;
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

		Class<?> remoteModelClass = _shoppingCouponRemoteModel.getClass();

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

		Object returnValue = method.invoke(_shoppingCouponRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingCouponLocalServiceUtil.addShoppingCoupon(this);
		}
		else {
			ShoppingCouponLocalServiceUtil.updateShoppingCoupon(this);
		}
	}

	@Override
	public ShoppingCoupon toEscapedModel() {
		return (ShoppingCoupon)ProxyUtil.newProxyInstance(ShoppingCoupon.class.getClassLoader(),
			new Class[] { ShoppingCoupon.class },
			new AutoEscapeBeanHandler(this));
	}

	public ShoppingCoupon toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ShoppingCouponClp clone = new ShoppingCouponClp();

		clone.setCouponId(getCouponId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCode(getCode());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setActive(getActive());
		clone.setLimitCategories(getLimitCategories());
		clone.setLimitSkus(getLimitSkus());
		clone.setMinOrder(getMinOrder());
		clone.setDiscount(getDiscount());
		clone.setDiscountType(getDiscountType());

		return clone;
	}

	public int compareTo(ShoppingCoupon shoppingCoupon) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				shoppingCoupon.getCreateDate());

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

		if (!(obj instanceof ShoppingCouponClp)) {
			return false;
		}

		ShoppingCouponClp shoppingCoupon = (ShoppingCouponClp)obj;

		long primaryKey = shoppingCoupon.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{couponId=");
		sb.append(getCouponId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", limitCategories=");
		sb.append(getLimitCategories());
		sb.append(", limitSkus=");
		sb.append(getLimitSkus());
		sb.append(", minOrder=");
		sb.append(getMinOrder());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", discountType=");
		sb.append(getDiscountType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingCoupon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>couponId</column-name><column-value><![CDATA[");
		sb.append(getCouponId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
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
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>limitCategories</column-name><column-value><![CDATA[");
		sb.append(getLimitCategories());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>limitSkus</column-name><column-value><![CDATA[");
		sb.append(getLimitSkus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minOrder</column-name><column-value><![CDATA[");
		sb.append(getMinOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discountType</column-name><column-value><![CDATA[");
		sb.append(getDiscountType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _couponId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private String _description;
	private Date _startDate;
	private Date _endDate;
	private boolean _active;
	private String _limitCategories;
	private String _limitSkus;
	private double _minOrder;
	private double _discount;
	private String _discountType;
	private BaseModel<?> _shoppingCouponRemoteModel;
}