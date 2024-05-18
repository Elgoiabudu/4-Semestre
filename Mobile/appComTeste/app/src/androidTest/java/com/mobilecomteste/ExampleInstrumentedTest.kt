package com.mobilecomteste

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class IMCTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun TesteCalculo() {
        // Context of the app under test.
        onView(withId(R.id.txtPeso)).perform(typeText("100"))
        onView(withId(R.id.txtAltura)).perform(typeText("2"))
        onView(withId(R.id.btCalcular)).perform(click())
        onView(withId(R.id.txtIMC)).check(matches(isDisplayed()))

    }
}