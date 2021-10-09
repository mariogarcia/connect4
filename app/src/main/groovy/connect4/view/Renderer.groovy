package connect4.view

interface Renderer {
    void writeln(String message)
    void writeln(Object object)

    boolean askBoolean(String message)
    public <T> T ask(String message, InputMapper<T> mapper)
}