import org.junit.Assert.assertEquals
import org.junit.Test

class Base91Test {
  @Test def fixedTests(): Unit = {
    assertEquals("fPNKd", Base91.encode("test"))
    assertEquals(">OwJh>Io0Tv!8PE", Base91.encode("Hello World!"))
    assertEquals("test", Base91.decode("fPNKd"))
    assertEquals("Hello World!", Base91.decode(">OwJh>Io0Tv!8PE"))
  }
}