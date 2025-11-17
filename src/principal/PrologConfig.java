package principal;

public class PrologConfig {

    public static void inicializar() {
        // Ruta relativa al ejecutable del proyecto
        System.setProperty("swipl.home", "prolog_runtime/App/swi-prolog");

        // Para que JPL encuentre jpl.dll
        System.setProperty("java.library.path", "native");

        // Esta línea es necesaria porque java.library.path se cachea
        try {
            java.lang.reflect.Field sysPaths = ClassLoader.class.getDeclaredField("sys_paths");
            sysPaths.setAccessible(true);
            sysPaths.set(null, null);
        } catch (Exception e) {
            System.err.println("Error reseteando library path: " + e.getMessage());
        }
    }

}
