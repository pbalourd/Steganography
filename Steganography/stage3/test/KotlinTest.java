import org.hyperskill.hstest.stage.StageTest;
import steganography.MainKt;

public abstract class KotlinTest extends StageTest {
    public KotlinTest() {
        super(MainKt.class);
    }
    Class mainClass = MainKt.class;
}
