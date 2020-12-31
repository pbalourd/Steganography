import org.hyperskill.hstest.dynamic.input.DynamicTestingMethod
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram

class SteganographyTest: KotlinTest() {
    @DynamicTestingMethod
    fun menuTest(): CheckResult {
        val main = TestedProgram(mainClass)
        var outputString = main.start().toLowerCase().trim()
        if (!outputString.contains("task (hide, show, exit):")) {
            return CheckResult(false, "Prompt \"Task (hide, show, exit):\" is missing.")
        }

        outputString = main.execute("hide").toLowerCase().trim()
        if (!outputString.contains("hiding message in image.")) {
            return CheckResult(false, "Wrong output after the \"hide\" command.")
        }

        outputString = main.execute("show").toLowerCase().trim()
        if (!outputString.contains("obtaining message from image.")) {
            return CheckResult(false, "Wrong output after the \"show\" command.")
        }

        outputString = main.execute("test").toLowerCase().trim()
        if (!outputString.contains("wrong task:")) {
            return CheckResult(false, "Wrong output after a wrong command.")
        }

        outputString = main.execute("exit").toLowerCase().trim()
        if (!outputString.contains("bye!")) {
            return CheckResult(false, "Wrong output after the \"exit\" command.")
        }

        if (!main.isFinished) {
            return CheckResult(false, "Program has not terminated after the \"exit\" command.")
        }

        return CheckResult(true,"")
    }
}

