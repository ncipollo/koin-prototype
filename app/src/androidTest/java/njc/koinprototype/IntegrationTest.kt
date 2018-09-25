package njc.koinprototype

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class IntegrationTest {

    @JvmField
    @Rule
    val activityTestRule = IntentsTestRule(MainActivity::class.java, true, true)

    @Test
    fun displaysText() {
        onView(withId(R.id.text))
            .check(matches(withText("$TEST_INTERVAL seconds have passed")))
    }
}
