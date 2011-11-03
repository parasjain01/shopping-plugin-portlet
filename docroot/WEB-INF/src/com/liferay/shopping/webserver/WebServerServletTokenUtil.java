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

package com.liferay.shopping.webserver;

/**
 * @author Brian Wing Shun Chan
 */
public class WebServerServletTokenUtil {

	public static WebServerServletToken getWebServerServletToken() {
		return _webServerServletToken;
	}

	public static String getToken(long imageId) {

		String token = _createToken(imageId);
		return token;
	}

	public static void resetToken(long imageId) {
		getWebServerServletToken().resetToken(imageId);
	}

	public void setWebServerServletToken(
		WebServerServletToken webServerServletToken) {

		_webServerServletToken = webServerServletToken;
	}

	private static String _createToken(long imageId) {
		return String.valueOf(System.currentTimeMillis());
	}

	private static WebServerServletToken _webServerServletToken;

}