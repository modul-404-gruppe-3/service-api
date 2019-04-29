package service.api;

/**
 * This interface is used to determin if a {@link AbstractProgram} can be stoped.
 * If this Interface is implemented it means that the {@link AbstractProgram} can be stoped and the Stop method
 * will be executed.
 */
public interface IStopable {
    /**
     * default means that the method does not need to be implemented into the {@link AbstractProgram}, but every Class that implements
     * this interface has access to this method.
     * you can override the Method in the implementing classes and that specific implementation will be used even if you
     * only have a IStopable Object and not a direct implementation.
     */
    default void stop() { }
}
