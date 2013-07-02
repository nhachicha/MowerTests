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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;

import dev.nhachicha.demo.MainActivity;
import dev.nhachicha.demo.ui.GraphicModeFragment;

/**
 * Testing some basic UI rendering 
 * @author Nabil Hachicha
 *
 */
public class UITest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	public UITest() {
		super(MainActivity.class);
	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
	
	public void testGraphicMode () {
		// Check that we have the right activity
	    solo.assertCurrentActivity("wrong activiy", MainActivity.class);
	    // choose Graphic mode, from the chooser
	    solo.clickInList(2);
	    solo.sleep(1000);//we wait for the fragment to attach, otherwise we will have a NPE
	    Fragment frag = ((FragmentActivity) solo.getCurrentActivity()).getSupportFragmentManager().findFragmentById(dev.nhachicha.demo.R.id.fragGame);
	    assertTrue(frag instanceof GraphicModeFragment);
	 
	}
	
	
}
