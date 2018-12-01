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
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJAnnotation {

	private static final Logger log = Logger.getLogger(AspectJAnnotation.class);

	@Pointcut("execution(* org.christianschenk.*.Main.helloWorld())")
	public void helloWorld() {}

	@Before("helloWorld()")
	public void beforeHelloWorld(final JoinPoint thisJoinPoint) {
		log.debug("Before: " + thisJoinPoint.getStaticPart().getSignature().getName());
	}

	@After("helloWorld()")
	public void afterHelloWorld(final JoinPoint thisJoinPoint) {
		log.debug("After: " + thisJoinPoint.getStaticPart().getSignature().getName());
	}

	@Around("execution(org.christianschenk.*.Main.new())")
	public void aroundMainConstructor(final JoinPoint thisJoinPoint) {
		log.debug("Around : " + thisJoinPoint.getStaticPart().getSignature().getName());
	}
}