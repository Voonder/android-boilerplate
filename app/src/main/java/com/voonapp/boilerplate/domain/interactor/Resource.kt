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

package com.voonapp.boilerplate.domain.interactor

/**
 * A generic class that holds a value with its loading status.
 *
 * @author Julien NORMAND - Orange Applications for Business [julien.normand@orange.com](julien.normand@orange.com)
 * @version 1.0.0
 * @since 2018-06-20
 *
 * @property status The status of the value.
 * @property data The data result of network/cache source.
 * @property error The error information value.
 *
 * @param T The type of elements held.
 */
data class Resource<out T>(val status: Status, val data: T?, val error: Error?) {

    companion object {
        /**
         * Create a loading [Resource].
         *
         * @param data The data result of network/cache source.
         * @param T The type of elements held.
         */
        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)

        /**
         * Create a success [Resource].
         *
         * @param data The data result of network/cache source.
         *
         * @param T The type of elements held.
         */
        fun <T> success(data: T?) = Resource(Status.SUCCESS,data,null)

        /**
         * Create an error [Resource].
         *
         * @param data The data result of network/cache source.
         * @param error The error information value.
         *
         * @param T The type of elements held.
         */
        fun <T> error(data: T?, error: Error?) = Resource(Status.ERROR, data, error)
    }
}