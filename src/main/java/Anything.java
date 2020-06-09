import org.jdbi.v3.core.Handle;

import java.util.function.Function;
import java.util.function.Supplier;

public interface Anything {

  Long create(Long object);

  default <T> T executeOuter(final Supplier<T> callback) {
    return callback.get();
  }

  default Long executeInner(Function<Handle, Long> onSuccess) {
    return onSuccess.apply(null);
  }
}
