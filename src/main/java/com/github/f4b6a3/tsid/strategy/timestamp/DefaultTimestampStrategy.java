/*
 * MIT License
 * 
 * Copyright (c) 2020 Fabio Lima
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

package com.github.f4b6a3.tsid.strategy.timestamp;

import java.time.Instant;

import com.github.f4b6a3.tsid.strategy.TimestampStrategy;
import com.github.f4b6a3.tsid.util.TsidTimeUtil;

/**
 * Strategy that provides the current timestamp.
 * 
 * The default epoch is 2020-01-01 00:00:00Z (TSID epoch).
 * 
 * One can use a custom epoch if the default is not desired.
 * 
 */
public class DefaultTimestampStrategy implements TimestampStrategy {

	protected Long customEpoch;

	public DefaultTimestampStrategy() {
	}

	/**
	 * Use a custom epoch instead of the default.
	 * 
	 * @param customEpoch the custom epoch milliseconds
	 */
	public DefaultTimestampStrategy(long customEpoch) {
		this.customEpoch = customEpoch;
	}

	/**
	 * Use a custom epoch instead of the default.
	 * 
	 * @param customEpoch the custom epoch milliseconds
	 */
	public DefaultTimestampStrategy(Instant customEpoch) {
		this.customEpoch = customEpoch.toEpochMilli();
	}

	/**
	 * Returns the number of milliseconds since 2020-01-01 00:00:00Z (TSID epoch) or
	 * since a custom epoch.
	 */
	@Override
	public long getTimestamp() {
		if (this.customEpoch == null) {
			return TsidTimeUtil.getCurrentTimestamp();
		} else {
			return TsidTimeUtil.getCurrentTimestamp(this.customEpoch);
		}
	}
}