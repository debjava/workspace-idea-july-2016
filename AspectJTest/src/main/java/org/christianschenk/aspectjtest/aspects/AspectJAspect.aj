/*
 * AspectJTest - Quick look at AspectJ
 * Copyright (C) 2007 Christian Schenk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package org.christianschenk.aspectjtest.aspects;

import org.apache.log4j.Logger;

public aspect AspectJAspect {

	private static final Logger log = Logger.getLogger(AspectJAspect.class);

	private pointcut helloWorld() : execution(* org.christianschenk.*.Main.helloWorld());

	before() : helloWorld() {
		log.debug("Before: " + thisJoinPoint.getStaticPart().getSignature().getName());
	}

	after() : helloWorld() {
		log.debug("After: " + thisJoinPointStaticPart.getSignature().getName());
	}

	Object around() : execution(* org.christianschenk.*.Main.main(*)) {
		log.debug("Around");
		return proceed();
	}
}