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
package org.christianschenk.aspectjtest.example;

import org.christianschenk.aspectjtest.example.session.Session;
import org.christianschenk.aspectjtest.example.session.impl.SessionImpl;

public class Runner {

	public static void main(final String[] args) {
		final Session session = new SessionImpl();

		final FirstClass firstClass = new FirstClass();
		final SecondClass secondClass = new SecondClass();

		System.out.println("Conventional way:");
		firstClass.someMethod(session);
		secondClass.doesSomething(session);

		System.out.println("\nAOP way:");
		firstClass.someMethodSimplified(session);
		secondClass.doesSomethingSimplified(session);
	}
}