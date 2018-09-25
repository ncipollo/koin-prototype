package njc.koinprototype

import org.junit.Assert.assertTrue
import org.junit.Test
import org.koin.error.DependencyResolutionException
import org.koin.test.KoinTest
import org.koin.test.checkModules
import org.koin.test.error.BrokenDefinitionException

class InjectionTest : KoinTest {
    @Test
    fun noMissingDependencies() {
        checkModules(Injection.modules)
    }

    @Test
    fun missingDependencies() {
        var thrown = false
        try {
            checkModules(Injection.modulesMissingDependency)
        } catch (e: Exception) {
            when (e) {
                is BrokenDefinitionException, is DependencyResolutionException -> thrown = true
                else -> throw e
            }
        }
        assertTrue(thrown)
    }
}
