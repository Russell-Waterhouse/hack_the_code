package ca.russell_waterhouse.hackthecode.ui.settings

import android.app.Instrumentation
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnitRunner
import ca.russell_waterhouse.hackthecode.CustomTestRunner
import ca.russell_waterhouse.hackthecode.R
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

class SettingsActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule<SettingsActivity>(SettingsActivity::class.java)
    private lateinit var scenario: ActivityScenario<SettingsActivity>
    private lateinit var settings: SettingsActivity
    @Before
    fun setUp() {
        scenario = activityScenarioRule.scenario
        scenario.onActivity{
            settings = it
        }
    }

    @Test
    fun resetLevels() {
        val model = settings.model
        onView(withId(R.id.reset)).perform(click())
        runBlocking {
            verify(model).deleteAllFromDatabase()
        }
    }

    @Test
    fun deleteAllFromDatabase() {
        val model = settings.model
        onView(withId(R.id.reset)).perform(click())
        runBlocking {
            verify(model).deleteAllFromDatabase()
        }
    }
}