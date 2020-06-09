import java.util.function.Consumer;

public class BugReproduction {

  public void doesNotCompile() {
    final Anything anything = null;

    anything.executeOuter(() -> {
      anything.executeInner((handle) -> {
        final var inferredAnything = handle.attach(Anything.class);
        consume(inferredAnything::create);
        return null;
      });
      return null;
    });
  }

  public void consume(Consumer<Long> noop) {
    noop.accept(1L);
  }

}
