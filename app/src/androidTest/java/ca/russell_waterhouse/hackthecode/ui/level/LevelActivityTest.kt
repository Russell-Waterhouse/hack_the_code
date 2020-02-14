package ca.russell_waterhouse.hackthecode.ui.level

import android.widget.TableRow
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import ca.russell_waterhouse.hackthecode.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LevelActivityTest{

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule<LevelActivity>(LevelActivity::class.java)
    private lateinit var scenario: ActivityScenario<LevelActivity>
    private lateinit var levels: LevelActivity


    @Before
    fun setup(){
        scenario = activityScenarioRule.scenario
        scenario.onActivity {
            levels = it
        }
    }

    @Test
    fun enterAnswer(){
        val enteredString = "Test string"
        onView(withId(R.id.final_answer)).check(matches(withText("")))
        onView(withId(R.id.final_answer)).perform(typeText(enteredString))
        onView(withId(R.id.check_answer)).perform(click())
        onView(withId(R.id.final_answer)).check(matches(withText("")))
    }

    @Test
    fun checkDisplayedGuesses(){
        onView(allOf(isDescendantOfA(isAssignableFrom(TableRow::class.java)), not(withText("ENCODED TEST STRING")))).check(matches(withText("test string")))
        onView(allOf(isDescendantOfA(isAssignableFrom(TableRow::class.java)), not(withText("test string")))).check(matches(withText("ENCODED TEST STRING")))
    }

}