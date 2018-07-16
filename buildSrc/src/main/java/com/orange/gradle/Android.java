/*
 * Copyright (c) 2018 Voonder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.orange.gradle;

@SuppressWarnings("unused")
public final class Android {
    private static final int MIN_ANDROID_VERSION = 21;
    private static final int MAX_ANDROID_VERSION = 27;
    private static final String PACKAGE_NAME = "com.voonapp.boilerplate";

    public static final String buildTools = "27.0.3";
    public static final int compileSdk = MAX_ANDROID_VERSION;
    public static final int minSdk = MIN_ANDROID_VERSION;
    public static final int targetSdk = MAX_ANDROID_VERSION;

    public final class Package {
        public static final String base = PACKAGE_NAME;
    }
}