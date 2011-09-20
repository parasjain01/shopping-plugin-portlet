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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.shopping.model.ShoppingCoupon;
import com.liferay.portlet.shopping.model.ShoppingCouponModel;
import com.liferay.portlet.shopping.model.ShoppingCouponSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the ShoppingCoupon service. Represents a row in the &quot;Shopping_ShoppingCoupon&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.shopping.model.ShoppingCouponModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingCouponImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCouponImpl
 * @see com.liferay.portlet.shopping.model.ShoppingCoupon
 * @see com.liferay.portlet.shopping.model.ShoppingCouponModel
 * @generated
 */
@JSON(strict = true)
public class ShoppingCouponModelImpl extends BaseModelImpl<ShoppingCoupon>
	implements ShoppingCouponModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shopping coupon model instance should use the {@link com.liferay.portlet.shopping.model.ShoppingCoupon} interface instead.
	 */
	public static final String TABLE_NAME = "Shopping_ShoppingCoupon";
	public static final Object[][] TABLE_COLUMNS = {
			{ "couponId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "code_", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "active_", Types.BOOLEAN },
			{ "limitCategories", Types.VARCHAR },
			{ "limitSkus", Types.VARCHAR },
			{ "minOrder", Types.DOUBLE },
			{ "discount", Types.DOUBLE },
			{ "discountType", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Shopping_ShoppingCoupon (couponId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,name VARCHAR(75) null,description STRING null,startDate DATE null,endDate DATE null,active_ BOOLEAN,limitCategories STRING null,limitSkus STRING null,minOrder DOUBLE,discount DOUBLE,discountType VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Shopping_ShoppingCoupon";
	public static final String ORDER_BY_JPQL = " ORDER BY shoppingCoupon.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Shopping_ShoppingCoupon.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.shopping.model.ShoppingCoupon"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.shopping.model.ShoppingCoupon"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ShoppingCoupon toModel(ShoppingCouponSoap soapModel) {
		ShoppingCoupon model = new ShoppingCouponImpl();

		model.setCouponId(soapModel.getCouponId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCode(soapModel.getCode());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setActive(soapModel.getActive());
		model.setLimitCategories(soapModel.getLimitCategories());
		model.setLimitSkus(soapModel.getLimitSkus());
		model.setMinOrder(soapModel.getMinOrder());
		model.setDiscount(soapModel.getDiscount());
		model.setDiscountType(soapModel.getDiscountType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ShoppingCoupon> toModels(ShoppingCouponSoap[] soapModels) {
		List<ShoppingCoupon> models = new ArrayList<ShoppingCoupon>(soapModels.length);

		for (ShoppingCouponSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public Class<?> getModelClass() {
		return ShoppingCoupon.class;
	}

	public String getModelClassName() {
		return ShoppingCoupon.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portlet.shopping.model.ShoppingCoupon"));

	public ShoppingCouponModelImpl() {
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

	@JSON
	public long getCouponId() {
		return _couponId;
	}

	public void setCouponId(long couponId) {
		_couponId = couponId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	public void setCode(String code) {
		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	@JSON
	public String getLimitCategories() {
		if (_limitCategories == null) {
			return StringPool.BLANK;
		}
		else {
			return _limitCategories;
		}
	}

	public void setLimitCategories(String limitCategories) {
		_limitCategories = limitCategories;
	}

	@JSON
	public String getLimitSkus() {
		if (_limitSkus == null) {
			return StringPool.BLANK;
		}
		else {
			return _limitSkus;
		}
	}

	public void setLimitSkus(String limitSkus) {
		_limitSkus = limitSkus;
	}

	@JSON
	public double getMinOrder() {
		return _minOrder;
	}

	public void setMinOrder(double minOrder) {
		_minOrder = minOrder;
	}

	@JSON
	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;
	}

	@JSON
	public String getDiscountType() {
		if (_discountType == null) {
			return StringPool.BLANK;
		}
		else {
			return _discountType;
		}
	}

	public void setDiscountType(String discountType) {
		_discountType = discountType;
	}

	@Override
	public ShoppingCoupon toEscapedModel() {
		if (isEscapedModel()) {
			return (ShoppingCoupon)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (ShoppingCoupon)ProxyUtil.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					ShoppingCoupon.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		ShoppingCouponImpl shoppingCouponImpl = new ShoppingCouponImpl();

		shoppingCouponImpl.setCouponId(getCouponId());
		shoppingCouponImpl.setGroupId(getGroupId());
		shoppingCouponImpl.setCompanyId(getCompanyId());
		shoppingCouponImpl.setUserId(getUserId());
		shoppingCouponImpl.setUserName(getUserName());
		shoppingCouponImpl.setCreateDate(getCreateDate());
		shoppingCouponImpl.setModifiedDate(getModifiedDate());
		shoppingCouponImpl.setCode(getCode());
		shoppingCouponImpl.setName(getName());
		shoppingCouponImpl.setDescription(getDescription());
		shoppingCouponImpl.setStartDate(getStartDate());
		shoppingCouponImpl.setEndDate(getEndDate());
		shoppingCouponImpl.setActive(getActive());
		shoppingCouponImpl.setLimitCategories(getLimitCategories());
		shoppingCouponImpl.setLimitSkus(getLimitSkus());
		shoppingCouponImpl.setMinOrder(getMinOrder());
		shoppingCouponImpl.setDiscount(getDiscount());
		shoppingCouponImpl.setDiscountType(getDiscountType());

		shoppingCouponImpl.resetOriginalValues();

		return shoppingCouponImpl;
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
		if (obj == null) {
			return false;
		}

		ShoppingCoupon shoppingCoupon = null;

		try {
			shoppingCoupon = (ShoppingCoupon)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

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
	public void resetOriginalValues() {
		ShoppingCouponModelImpl shoppingCouponModelImpl = this;

		shoppingCouponModelImpl._originalCode = shoppingCouponModelImpl._code;
	}

	@Override
	public CacheModel<ShoppingCoupon> toCacheModel() {
		ShoppingCouponCacheModel shoppingCouponCacheModel = new ShoppingCouponCacheModel();

		shoppingCouponCacheModel.couponId = getCouponId();

		shoppingCouponCacheModel.groupId = getGroupId();

		shoppingCouponCacheModel.companyId = getCompanyId();

		shoppingCouponCacheModel.userId = getUserId();

		shoppingCouponCacheModel.userName = getUserName();

		String userName = shoppingCouponCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			shoppingCouponCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			shoppingCouponCacheModel.createDate = createDate.getTime();
		}
		else {
			shoppingCouponCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			shoppingCouponCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			shoppingCouponCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		shoppingCouponCacheModel.code = getCode();

		String code = shoppingCouponCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			shoppingCouponCacheModel.code = null;
		}

		shoppingCouponCacheModel.name = getName();

		String name = shoppingCouponCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			shoppingCouponCacheModel.name = null;
		}

		shoppingCouponCacheModel.description = getDescription();

		String description = shoppingCouponCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			shoppingCouponCacheModel.description = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			shoppingCouponCacheModel.startDate = startDate.getTime();
		}
		else {
			shoppingCouponCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			shoppingCouponCacheModel.endDate = endDate.getTime();
		}
		else {
			shoppingCouponCacheModel.endDate = Long.MIN_VALUE;
		}

		shoppingCouponCacheModel.active = getActive();

		shoppingCouponCacheModel.limitCategories = getLimitCategories();

		String limitCategories = shoppingCouponCacheModel.limitCategories;

		if ((limitCategories != null) && (limitCategories.length() == 0)) {
			shoppingCouponCacheModel.limitCategories = null;
		}

		shoppingCouponCacheModel.limitSkus = getLimitSkus();

		String limitSkus = shoppingCouponCacheModel.limitSkus;

		if ((limitSkus != null) && (limitSkus.length() == 0)) {
			shoppingCouponCacheModel.limitSkus = null;
		}

		shoppingCouponCacheModel.minOrder = getMinOrder();

		shoppingCouponCacheModel.discount = getDiscount();

		shoppingCouponCacheModel.discountType = getDiscountType();

		String discountType = shoppingCouponCacheModel.discountType;

		if ((discountType != null) && (discountType.length() == 0)) {
			shoppingCouponCacheModel.discountType = null;
		}

		return shoppingCouponCacheModel;
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
		sb.append("com.liferay.portlet.shopping.model.ShoppingCoupon");
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

	private static ClassLoader _classLoader = ShoppingCoupon.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ShoppingCoupon.class
		};
	private long _couponId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _originalCode;
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
	private transient ExpandoBridge _expandoBridge;
	private ShoppingCoupon _escapedModelProxy;
}