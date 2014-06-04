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

package com.liferay.shopping.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.liferay.shopping.model.ShoppingCartClp;
import com.liferay.shopping.model.ShoppingCategoryClp;
import com.liferay.shopping.model.ShoppingCouponClp;
import com.liferay.shopping.model.ShoppingItemClp;
import com.liferay.shopping.model.ShoppingItemFieldClp;
import com.liferay.shopping.model.ShoppingItemPriceClp;
import com.liferay.shopping.model.ShoppingOrderClp;
import com.liferay.shopping.model.ShoppingOrderItemClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"shopping-plugin-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"shopping-plugin-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "shopping-plugin-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ShoppingCartClp.class.getName())) {
			return translateInputShoppingCart(oldModel);
		}

		if (oldModelClassName.equals(ShoppingCategoryClp.class.getName())) {
			return translateInputShoppingCategory(oldModel);
		}

		if (oldModelClassName.equals(ShoppingCouponClp.class.getName())) {
			return translateInputShoppingCoupon(oldModel);
		}

		if (oldModelClassName.equals(ShoppingItemClp.class.getName())) {
			return translateInputShoppingItem(oldModel);
		}

		if (oldModelClassName.equals(ShoppingItemFieldClp.class.getName())) {
			return translateInputShoppingItemField(oldModel);
		}

		if (oldModelClassName.equals(ShoppingItemPriceClp.class.getName())) {
			return translateInputShoppingItemPrice(oldModel);
		}

		if (oldModelClassName.equals(ShoppingOrderClp.class.getName())) {
			return translateInputShoppingOrder(oldModel);
		}

		if (oldModelClassName.equals(ShoppingOrderItemClp.class.getName())) {
			return translateInputShoppingOrderItem(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputShoppingCart(BaseModel<?> oldModel) {
		ShoppingCartClp oldClpModel = (ShoppingCartClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingCartRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputShoppingCategory(BaseModel<?> oldModel) {
		ShoppingCategoryClp oldClpModel = (ShoppingCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputShoppingCoupon(BaseModel<?> oldModel) {
		ShoppingCouponClp oldClpModel = (ShoppingCouponClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingCouponRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputShoppingItem(BaseModel<?> oldModel) {
		ShoppingItemClp oldClpModel = (ShoppingItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputShoppingItemField(BaseModel<?> oldModel) {
		ShoppingItemFieldClp oldClpModel = (ShoppingItemFieldClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingItemFieldRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputShoppingItemPrice(BaseModel<?> oldModel) {
		ShoppingItemPriceClp oldClpModel = (ShoppingItemPriceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingItemPriceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputShoppingOrder(BaseModel<?> oldModel) {
		ShoppingOrderClp oldClpModel = (ShoppingOrderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingOrderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputShoppingOrderItem(BaseModel<?> oldModel) {
		ShoppingOrderItemClp oldClpModel = (ShoppingOrderItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getShoppingOrderItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingCartImpl")) {
			return translateOutputShoppingCart(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingCategoryImpl")) {
			return translateOutputShoppingCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingCouponImpl")) {
			return translateOutputShoppingCoupon(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingItemImpl")) {
			return translateOutputShoppingItem(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingItemFieldImpl")) {
			return translateOutputShoppingItemField(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingItemPriceImpl")) {
			return translateOutputShoppingItemPrice(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingOrderImpl")) {
			return translateOutputShoppingOrder(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingOrderItemImpl")) {
			return translateOutputShoppingOrderItem(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.liferay.shopping.BillingCityException")) {
			return new com.liferay.shopping.BillingCityException();
		}

		if (className.equals("com.liferay.shopping.BillingCountryException")) {
			return new com.liferay.shopping.BillingCountryException();
		}

		if (className.equals(
					"com.liferay.shopping.BillingEmailAddressException")) {
			return new com.liferay.shopping.BillingEmailAddressException();
		}

		if (className.equals("com.liferay.shopping.BillingFirstNameException")) {
			return new com.liferay.shopping.BillingFirstNameException();
		}

		if (className.equals("com.liferay.shopping.BillingLastNameException")) {
			return new com.liferay.shopping.BillingLastNameException();
		}

		if (className.equals("com.liferay.shopping.BillingPhoneException")) {
			return new com.liferay.shopping.BillingPhoneException();
		}

		if (className.equals("com.liferay.shopping.BillingStateException")) {
			return new com.liferay.shopping.BillingStateException();
		}

		if (className.equals("com.liferay.shopping.BillingStreetException")) {
			return new com.liferay.shopping.BillingStreetException();
		}

		if (className.equals("com.liferay.shopping.BillingZipException")) {
			return new com.liferay.shopping.BillingZipException();
		}

		if (className.equals("com.liferay.shopping.CCExpirationException")) {
			return new com.liferay.shopping.CCExpirationException();
		}

		if (className.equals("com.liferay.shopping.CCNameException")) {
			return new com.liferay.shopping.CCNameException();
		}

		if (className.equals("com.liferay.shopping.CCNumberException")) {
			return new com.liferay.shopping.CCNumberException();
		}

		if (className.equals("com.liferay.shopping.CCTypeException")) {
			return new com.liferay.shopping.CCTypeException();
		}

		if (className.equals("com.liferay.shopping.CartMinOrderException")) {
			return new com.liferay.shopping.CartMinOrderException();
		}

		if (className.equals("com.liferay.shopping.CartMinQuantityException")) {
			return new com.liferay.shopping.CartMinQuantityException();
		}

		if (className.equals("com.liferay.shopping.CategoryNameException")) {
			return new com.liferay.shopping.CategoryNameException();
		}

		if (className.equals("com.liferay.shopping.CouponActiveException")) {
			return new com.liferay.shopping.CouponActiveException();
		}

		if (className.equals("com.liferay.shopping.CouponCodeException")) {
			return new com.liferay.shopping.CouponCodeException();
		}

		if (className.equals("com.liferay.shopping.CouponDateException")) {
			return new com.liferay.shopping.CouponDateException();
		}

		if (className.equals("com.liferay.shopping.CouponDescriptionException")) {
			return new com.liferay.shopping.CouponDescriptionException();
		}

		if (className.equals("com.liferay.shopping.CouponDiscountException")) {
			return new com.liferay.shopping.CouponDiscountException();
		}

		if (className.equals("com.liferay.shopping.CouponEndDateException")) {
			return new com.liferay.shopping.CouponEndDateException();
		}

		if (className.equals("com.liferay.shopping.CouponMinimumOrderException")) {
			return new com.liferay.shopping.CouponMinimumOrderException();
		}

		if (className.equals("com.liferay.shopping.CouponNameException")) {
			return new com.liferay.shopping.CouponNameException();
		}

		if (className.equals("com.liferay.shopping.CouponStartDateException")) {
			return new com.liferay.shopping.CouponStartDateException();
		}

		if (className.equals(
					"com.liferay.shopping.DuplicateCouponCodeException")) {
			return new com.liferay.shopping.DuplicateCouponCodeException();
		}

		if (className.equals("com.liferay.shopping.DuplicateItemSKUException")) {
			return new com.liferay.shopping.DuplicateItemSKUException();
		}

		if (className.equals("com.liferay.shopping.ItemLargeImageNameException")) {
			return new com.liferay.shopping.ItemLargeImageNameException();
		}

		if (className.equals("com.liferay.shopping.ItemLargeImageSizeException")) {
			return new com.liferay.shopping.ItemLargeImageSizeException();
		}

		if (className.equals(
					"com.liferay.shopping.ItemMediumImageNameException")) {
			return new com.liferay.shopping.ItemMediumImageNameException();
		}

		if (className.equals(
					"com.liferay.shopping.ItemMediumImageSizeException")) {
			return new com.liferay.shopping.ItemMediumImageSizeException();
		}

		if (className.equals("com.liferay.shopping.ItemNameException")) {
			return new com.liferay.shopping.ItemNameException();
		}

		if (className.equals("com.liferay.shopping.ItemSKUException")) {
			return new com.liferay.shopping.ItemSKUException();
		}

		if (className.equals("com.liferay.shopping.ItemSmallImageNameException")) {
			return new com.liferay.shopping.ItemSmallImageNameException();
		}

		if (className.equals("com.liferay.shopping.ItemSmallImageSizeException")) {
			return new com.liferay.shopping.ItemSmallImageSizeException();
		}

		if (className.equals("com.liferay.shopping.RequiredCouponException")) {
			return new com.liferay.shopping.RequiredCouponException();
		}

		if (className.equals("com.liferay.shopping.ShippingCityException")) {
			return new com.liferay.shopping.ShippingCityException();
		}

		if (className.equals("com.liferay.shopping.ShippingCountryException")) {
			return new com.liferay.shopping.ShippingCountryException();
		}

		if (className.equals(
					"com.liferay.shopping.ShippingEmailAddressException")) {
			return new com.liferay.shopping.ShippingEmailAddressException();
		}

		if (className.equals("com.liferay.shopping.ShippingFirstNameException")) {
			return new com.liferay.shopping.ShippingFirstNameException();
		}

		if (className.equals("com.liferay.shopping.ShippingLastNameException")) {
			return new com.liferay.shopping.ShippingLastNameException();
		}

		if (className.equals("com.liferay.shopping.ShippingPhoneException")) {
			return new com.liferay.shopping.ShippingPhoneException();
		}

		if (className.equals("com.liferay.shopping.ShippingStateException")) {
			return new com.liferay.shopping.ShippingStateException();
		}

		if (className.equals("com.liferay.shopping.ShippingStreetException")) {
			return new com.liferay.shopping.ShippingStreetException();
		}

		if (className.equals("com.liferay.shopping.ShippingZipException")) {
			return new com.liferay.shopping.ShippingZipException();
		}

		if (className.equals("com.liferay.shopping.NoSuchCartException")) {
			return new com.liferay.shopping.NoSuchCartException();
		}

		if (className.equals("com.liferay.shopping.NoSuchCategoryException")) {
			return new com.liferay.shopping.NoSuchCategoryException();
		}

		if (className.equals("com.liferay.shopping.NoSuchCouponException")) {
			return new com.liferay.shopping.NoSuchCouponException();
		}

		if (className.equals("com.liferay.shopping.NoSuchItemException")) {
			return new com.liferay.shopping.NoSuchItemException();
		}

		if (className.equals("com.liferay.shopping.NoSuchItemFieldException")) {
			return new com.liferay.shopping.NoSuchItemFieldException();
		}

		if (className.equals("com.liferay.shopping.NoSuchItemPriceException")) {
			return new com.liferay.shopping.NoSuchItemPriceException();
		}

		if (className.equals("com.liferay.shopping.NoSuchOrderException")) {
			return new com.liferay.shopping.NoSuchOrderException();
		}

		if (className.equals("com.liferay.shopping.NoSuchOrderItemException")) {
			return new com.liferay.shopping.NoSuchOrderItemException();
		}

		return throwable;
	}

	public static Object translateOutputShoppingCart(BaseModel<?> oldModel) {
		ShoppingCartClp newModel = new ShoppingCartClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingCartRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputShoppingCategory(BaseModel<?> oldModel) {
		ShoppingCategoryClp newModel = new ShoppingCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputShoppingCoupon(BaseModel<?> oldModel) {
		ShoppingCouponClp newModel = new ShoppingCouponClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingCouponRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputShoppingItem(BaseModel<?> oldModel) {
		ShoppingItemClp newModel = new ShoppingItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputShoppingItemField(BaseModel<?> oldModel) {
		ShoppingItemFieldClp newModel = new ShoppingItemFieldClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingItemFieldRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputShoppingItemPrice(BaseModel<?> oldModel) {
		ShoppingItemPriceClp newModel = new ShoppingItemPriceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingItemPriceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputShoppingOrder(BaseModel<?> oldModel) {
		ShoppingOrderClp newModel = new ShoppingOrderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingOrderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputShoppingOrderItem(BaseModel<?> oldModel) {
		ShoppingOrderItemClp newModel = new ShoppingOrderItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setShoppingOrderItemRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}