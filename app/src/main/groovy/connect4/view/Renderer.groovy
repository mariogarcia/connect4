package connect4.view

interface Renderer {
    void show(String message)
    void show(Object object)

    boolean askBoolean(String message)
    public <T> T ask(String message, InputMapper<T> mapper)
}