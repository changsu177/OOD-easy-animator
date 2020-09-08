import java.io.IOException;

/**
 * This class implements Appendable interface, and it will throw IOException in all its three append
 * methods for test purpose.
 */
public class IOExceptionTester implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
