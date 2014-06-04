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
import com.liferay.shopping.service.ShoppingItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemClp extends BaseModelImpl<ShoppingItem>
	implements ShoppingItem {
	public ShoppingItemClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingItem.class;
	}

	public String getModelClassName() {
		return ShoppingItem.class.getName();
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long primaryKey) {
		setItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("sku", getSku());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("properties", getProperties());
		attributes.put("fields", getFields());
		attributes.put("fieldsQuantities", getFieldsQuantities());
		attributes.put("minQuantity", getMinQuantity());
		attributes.put("maxQuantity", getMaxQuantity());
		attributes.put("price", getPrice());
		attributes.put("discount", getDiscount());
		attributes.put("taxable", getTaxable());
		attributes.put("shipping", getShipping());
		attributes.put("useShippingFormula", getUseShippingFormula());
		attributes.put("requiresShipping", getRequiresShipping());
		attributes.put("stockQuantity", getStockQuantity());
		attributes.put("featured", getFeatured());
		attributes.put("sale", getSale());
		attributes.put("smallImage", getSmallImage());
		attributes.put("smallImageId", getSmallImageId());
		attributes.put("smallImageURL", getSmallImageURL());
		attributes.put("mediumImage", getMediumImage());
		attributes.put("mediumImageId", getMediumImageId());
		attributes.put("mediumImageURL", getMediumImageURL());
		attributes.put("largeImage", getLargeImage());
		attributes.put("largeImageId", getLargeImageId());
		attributes.put("largeImageURL", getLargeImageURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		Boolean fields = (Boolean)attributes.get("fields");

		if (fields != null) {
			setFields(fields);
		}

		String fieldsQuantities = (String)attributes.get("fieldsQuantities");

		if (fieldsQuantities != null) {
			setFieldsQuantities(fieldsQuantities);
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

		Boolean requiresShipping = (Boolean)attributes.get("requiresShipping");

		if (requiresShipping != null) {
			setRequiresShipping(requiresShipping);
		}

		Integer stockQuantity = (Integer)attributes.get("stockQuantity");

		if (stockQuantity != null) {
			setStockQuantity(stockQuantity);
		}

		Boolean featured = (Boolean)attributes.get("featured");

		if (featured != null) {
			setFeatured(featured);
		}

		Boolean sale = (Boolean)attributes.get("sale");

		if (sale != null) {
			setSale(sale);
		}

		Boolean smallImage = (Boolean)attributes.get("smallImage");

		if (smallImage != null) {
			setSmallImage(smallImage);
		}

		Long smallImageId = (Long)attributes.get("smallImageId");

		if (smallImageId != null) {
			setSmallImageId(smallImageId);
		}

		String smallImageURL = (String)attributes.get("smallImageURL");

		if (smallImageURL != null) {
			setSmallImageURL(smallImageURL);
		}

		Boolean mediumImage = (Boolean)attributes.get("mediumImage");

		if (mediumImage != null) {
			setMediumImage(mediumImage);
		}

		Long mediumImageId = (Long)attributes.get("mediumImageId");

		if (mediumImageId != null) {
			setMediumImageId(mediumImageId);
		}

		String mediumImageURL = (String)attributes.get("mediumImageURL");

		if (mediumImageURL != null) {
			setMediumImageURL(mediumImageURL);
		}

		Boolean largeImage = (Boolean)attributes.get("largeImage");

		if (largeImage != null) {
			setLargeImage(largeImage);
		}

		Long largeImageId = (Long)attributes.get("largeImageId");

		if (largeImageId != null) {
			setLargeImageId(largeImageId);
		}

		String largeImageURL = (String)attributes.get("largeImageURL");

		if (largeImageURL != null) {
			setLargeImageURL(largeImageURL);
		}
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_shoppingItemRemoteModel, itemId);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_shoppingItemRemoteModel, groupId);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_shoppingItemRemoteModel, companyId);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_shoppingItemRemoteModel, userId);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_shoppingItemRemoteModel, userName);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_shoppingItemRemoteModel, createDate);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_shoppingItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_shoppingItemRemoteModel, categoryId);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSku", String.class);

				method.invoke(_shoppingItemRemoteModel, sku);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_shoppingItemRemoteModel, name);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_shoppingItemRemoteModel, description);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setProperties", String.class);

				method.invoke(_shoppingItemRemoteModel, properties);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getFields() {
		return _fields;
	}

	public boolean isFields() {
		return _fields;
	}

	public void setFields(boolean fields) {
		_fields = fields;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFields", boolean.class);

				method.invoke(_shoppingItemRemoteModel, fields);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getFieldsQuantities() {
		return _fieldsQuantities;
	}

	public void setFieldsQuantities(String fieldsQuantities) {
		_fieldsQuantities = fieldsQuantities;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFieldsQuantities",
						String.class);

				method.invoke(_shoppingItemRemoteModel, fieldsQuantities);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMinQuantity", int.class);

				method.invoke(_shoppingItemRemoteModel, minQuantity);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxQuantity", int.class);

				method.invoke(_shoppingItemRemoteModel, maxQuantity);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_shoppingItemRemoteModel, price);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", double.class);

				method.invoke(_shoppingItemRemoteModel, discount);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxable", boolean.class);

				method.invoke(_shoppingItemRemoteModel, taxable);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setShipping", double.class);

				method.invoke(_shoppingItemRemoteModel, shipping);
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

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUseShippingFormula",
						boolean.class);

				method.invoke(_shoppingItemRemoteModel, useShippingFormula);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getRequiresShipping() {
		return _requiresShipping;
	}

	public boolean isRequiresShipping() {
		return _requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		_requiresShipping = requiresShipping;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiresShipping",
						boolean.class);

				method.invoke(_shoppingItemRemoteModel, requiresShipping);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getStockQuantity() {
		return _stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		_stockQuantity = stockQuantity;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setStockQuantity", int.class);

				method.invoke(_shoppingItemRemoteModel, stockQuantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getFeatured() {
		return _featured;
	}

	public boolean isFeatured() {
		return _featured;
	}

	public void setFeatured(boolean featured) {
		_featured = featured;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFeatured", boolean.class);

				method.invoke(_shoppingItemRemoteModel, featured);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getSale() {
		return _sale;
	}

	public boolean isSale() {
		return _sale;
	}

	public void setSale(boolean sale) {
		_sale = sale;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSale", boolean.class);

				method.invoke(_shoppingItemRemoteModel, sale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getSmallImage() {
		return _smallImage;
	}

	public boolean isSmallImage() {
		return _smallImage;
	}

	public void setSmallImage(boolean smallImage) {
		_smallImage = smallImage;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImage", boolean.class);

				method.invoke(_shoppingItemRemoteModel, smallImage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getSmallImageId() {
		return _smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		_smallImageId = smallImageId;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageId", long.class);

				method.invoke(_shoppingItemRemoteModel, smallImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getSmallImageURL() {
		return _smallImageURL;
	}

	public void setSmallImageURL(String smallImageURL) {
		_smallImageURL = smallImageURL;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageURL", String.class);

				method.invoke(_shoppingItemRemoteModel, smallImageURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getMediumImage() {
		return _mediumImage;
	}

	public boolean isMediumImage() {
		return _mediumImage;
	}

	public void setMediumImage(boolean mediumImage) {
		_mediumImage = mediumImage;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMediumImage", boolean.class);

				method.invoke(_shoppingItemRemoteModel, mediumImage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getMediumImageId() {
		return _mediumImageId;
	}

	public void setMediumImageId(long mediumImageId) {
		_mediumImageId = mediumImageId;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMediumImageId", long.class);

				method.invoke(_shoppingItemRemoteModel, mediumImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getMediumImageURL() {
		return _mediumImageURL;
	}

	public void setMediumImageURL(String mediumImageURL) {
		_mediumImageURL = mediumImageURL;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMediumImageURL",
						String.class);

				method.invoke(_shoppingItemRemoteModel, mediumImageURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getLargeImage() {
		return _largeImage;
	}

	public boolean isLargeImage() {
		return _largeImage;
	}

	public void setLargeImage(boolean largeImage) {
		_largeImage = largeImage;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLargeImage", boolean.class);

				method.invoke(_shoppingItemRemoteModel, largeImage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getLargeImageId() {
		return _largeImageId;
	}

	public void setLargeImageId(long largeImageId) {
		_largeImageId = largeImageId;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLargeImageId", long.class);

				method.invoke(_shoppingItemRemoteModel, largeImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getLargeImageURL() {
		return _largeImageURL;
	}

	public void setLargeImageURL(String largeImageURL) {
		_largeImageURL = largeImageURL;

		if (_shoppingItemRemoteModel != null) {
			try {
				Class<?> clazz = _shoppingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLargeImageURL", String.class);

				method.invoke(_shoppingItemRemoteModel, largeImageURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public java.lang.String[] getFieldsQuantitiesArray() {
		try {
			String methodName = "getFieldsQuantitiesArray";

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

	public void setFieldsQuantitiesArray(
		java.lang.String[] fieldsQuantitiesArray) {
		try {
			String methodName = "setFieldsQuantitiesArray";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { fieldsQuantitiesArray };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getItemPrices() {
		try {
			String methodName = "getItemPrices";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.liferay.shopping.model.ShoppingItemPrice> returnObj =
				(java.util.List<com.liferay.shopping.model.ShoppingItemPrice>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public com.liferay.shopping.model.ShoppingCategory getCategory() {
		try {
			String methodName = "getCategory";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.shopping.model.ShoppingCategory returnObj = (com.liferay.shopping.model.ShoppingCategory)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getShoppingItemRemoteModel() {
		return _shoppingItemRemoteModel;
	}

	public void setShoppingItemRemoteModel(BaseModel<?> shoppingItemRemoteModel) {
		_shoppingItemRemoteModel = shoppingItemRemoteModel;
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

		Class<?> remoteModelClass = _shoppingItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_shoppingItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingItemLocalServiceUtil.addShoppingItem(this);
		}
		else {
			ShoppingItemLocalServiceUtil.updateShoppingItem(this);
		}
	}

	@Override
	public ShoppingItem toEscapedModel() {
		return (ShoppingItem)ProxyUtil.newProxyInstance(ShoppingItem.class.getClassLoader(),
			new Class[] { ShoppingItem.class }, new AutoEscapeBeanHandler(this));
	}

	public ShoppingItem toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ShoppingItemClp clone = new ShoppingItemClp();

		clone.setItemId(getItemId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCategoryId(getCategoryId());
		clone.setSku(getSku());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setProperties(getProperties());
		clone.setFields(getFields());
		clone.setFieldsQuantities(getFieldsQuantities());
		clone.setMinQuantity(getMinQuantity());
		clone.setMaxQuantity(getMaxQuantity());
		clone.setPrice(getPrice());
		clone.setDiscount(getDiscount());
		clone.setTaxable(getTaxable());
		clone.setShipping(getShipping());
		clone.setUseShippingFormula(getUseShippingFormula());
		clone.setRequiresShipping(getRequiresShipping());
		clone.setStockQuantity(getStockQuantity());
		clone.setFeatured(getFeatured());
		clone.setSale(getSale());
		clone.setSmallImage(getSmallImage());
		clone.setSmallImageId(getSmallImageId());
		clone.setSmallImageURL(getSmallImageURL());
		clone.setMediumImage(getMediumImage());
		clone.setMediumImageId(getMediumImageId());
		clone.setMediumImageURL(getMediumImageURL());
		clone.setLargeImage(getLargeImage());
		clone.setLargeImageId(getLargeImageId());
		clone.setLargeImageURL(getLargeImageURL());

		return clone;
	}

	public int compareTo(ShoppingItem shoppingItem) {
		int value = 0;

		if (getItemId() < shoppingItem.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItem.getItemId()) {
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

		if (!(obj instanceof ShoppingItemClp)) {
			return false;
		}

		ShoppingItemClp shoppingItem = (ShoppingItemClp)obj;

		long primaryKey = shoppingItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(69);

		sb.append("{itemId=");
		sb.append(getItemId());
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
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", sku=");
		sb.append(getSku());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append(", fields=");
		sb.append(getFields());
		sb.append(", fieldsQuantities=");
		sb.append(getFieldsQuantities());
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
		sb.append(", requiresShipping=");
		sb.append(getRequiresShipping());
		sb.append(", stockQuantity=");
		sb.append(getStockQuantity());
		sb.append(", featured=");
		sb.append(getFeatured());
		sb.append(", sale=");
		sb.append(getSale());
		sb.append(", smallImage=");
		sb.append(getSmallImage());
		sb.append(", smallImageId=");
		sb.append(getSmallImageId());
		sb.append(", smallImageURL=");
		sb.append(getSmallImageURL());
		sb.append(", mediumImage=");
		sb.append(getMediumImage());
		sb.append(", mediumImageId=");
		sb.append(getMediumImageId());
		sb.append(", mediumImageURL=");
		sb.append(getMediumImageURL());
		sb.append(", largeImage=");
		sb.append(getLargeImage());
		sb.append(", largeImageId=");
		sb.append(getLargeImageId());
		sb.append(", largeImageURL=");
		sb.append(getLargeImageURL());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(106);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
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
			"<column><column-name>fields</column-name><column-value><![CDATA[");
		sb.append(getFields());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fieldsQuantities</column-name><column-value><![CDATA[");
		sb.append(getFieldsQuantities());
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
			"<column><column-name>requiresShipping</column-name><column-value><![CDATA[");
		sb.append(getRequiresShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stockQuantity</column-name><column-value><![CDATA[");
		sb.append(getStockQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>featured</column-name><column-value><![CDATA[");
		sb.append(getFeatured());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sale</column-name><column-value><![CDATA[");
		sb.append(getSale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImage</column-name><column-value><![CDATA[");
		sb.append(getSmallImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageId</column-name><column-value><![CDATA[");
		sb.append(getSmallImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageURL</column-name><column-value><![CDATA[");
		sb.append(getSmallImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mediumImage</column-name><column-value><![CDATA[");
		sb.append(getMediumImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mediumImageId</column-name><column-value><![CDATA[");
		sb.append(getMediumImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mediumImageURL</column-name><column-value><![CDATA[");
		sb.append(getMediumImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImage</column-name><column-value><![CDATA[");
		sb.append(getLargeImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImageId</column-name><column-value><![CDATA[");
		sb.append(getLargeImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImageURL</column-name><column-value><![CDATA[");
		sb.append(getLargeImageURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private String _sku;
	private String _name;
	private String _description;
	private String _properties;
	private boolean _fields;
	private String _fieldsQuantities;
	private int _minQuantity;
	private int _maxQuantity;
	private double _price;
	private double _discount;
	private boolean _taxable;
	private double _shipping;
	private boolean _useShippingFormula;
	private boolean _requiresShipping;
	private int _stockQuantity;
	private boolean _featured;
	private boolean _sale;
	private boolean _smallImage;
	private long _smallImageId;
	private String _smallImageURL;
	private boolean _mediumImage;
	private long _mediumImageId;
	private String _mediumImageURL;
	private boolean _largeImage;
	private long _largeImageId;
	private String _largeImageURL;
	private BaseModel<?> _shoppingItemRemoteModel;
}