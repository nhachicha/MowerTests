/*
 * Copyright 2013 Nabil HACHICHA

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package dev.nhachicha.demo.test;

import junit.framework.TestCase;
import dev.nhachicha.demo.engine.ConsoleEngineImpl;
import dev.nhachicha.demo.engine.EngineInterface;
import dev.nhachicha.demo.entity.Mower;
/**
 * We test the Algo only here (collision, bearing) we don't need AndroidTestCase just plain old JUnit
 * @author Nabil Hachicha
 *
 */
public class AlgoTest extends TestCase{

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testDemoEngineImpl () {
		Mower mower = new Mower (1,2,"N", "GAGAGAGAA");
		ConsoleEngineImpl engine = new ConsoleEngineImpl(5, 5);
		engine.run(mower);
		assertEquals(1, mower.position.x);
		assertEquals(3, mower.position.y);
		assertEquals("N", mower.orientation.description);
		
		mower = new Mower (3,3,"E", "AADAADADDA");
		engine.run(mower);
		assertEquals(5, mower.position.x);
		assertEquals(1, mower.position.y);
		assertEquals("E", mower.orientation.description);
	}
}
